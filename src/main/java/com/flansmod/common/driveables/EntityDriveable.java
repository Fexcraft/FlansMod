package com.flansmod.common.driveables;

import com.flansmod.api.IControllable;
import com.flansmod.client.EntityCamera;
import com.flansmod.client.FlansModClient;
import com.flansmod.client.debug.EntityDebugVector;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.data.DriveableData;
import com.flansmod.common.data.DriveableType;
import com.flansmod.common.data.EnumPartCategory;
import com.flansmod.common.data.PartType;
import com.flansmod.common.items.ItemPart;
import com.flansmod.common.network.packets.PacketDriveableKeyHeld;
import com.flansmod.common.network.packets.PacketDriveableSync;
import com.flansmod.common.util.Config;
import com.flansmod.common.util.Util;
import com.flansmod.common.vector.Vector3f;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityDriveable extends Entity implements IControllable, IEntityAdditionalSpawnData {
	
	public boolean syncFromServer = true;
	/** Ticks since last server update. Use to smoothly transition to new position */
	public int serverPositionTransitionTicker;
	/** Server side position, as synced by PacketVehicleControl packets */
	public double serverPosX, serverPosY, serverPosZ;
	/** Server side rotation, as synced by PacketVehicleControl packets */
	public double serverYaw, serverPitch, serverRoll;
	
	/** The driveable data which contains the inventory, the engine and the fuel */
	public DriveableData driveableData;
	/** The shortName of the driveable type, used to obtain said type */
	public String driveableType;
	
	/** The throttle, in the range -1, 1 is multiplied by the maxThrottle (or maxNegativeThrottle) from the plane type to obtain the thrust */
	public float throttle;
	/** The wheels on this plane */
	public EntityWheel[] wheels;
	
	public boolean fuelling;
	/** Extra prevRoation field for smoothness in all 3 rotational axes */
	public float prevRotationRoll;
	/** Angular velocity */
	public Vector3f angularVelocity = new Vector3f(0F, 0F, 0F);
	
	/** Whether each mouse button is held */
	public boolean leftMouseHeld = false, rightMouseHeld = false;
	
	/** Angle of harvester aesthetic piece */
	public float harvesterAngle;
	
	public RotatedAxes prevAxes;
	public RotatedAxes axes;
	
	public EntitySeat[] seats;
	
	private float yOffset;
	
	@SideOnly(Side.CLIENT)
	public EntityLivingBase camera;
	
	private int[] emitterTimers;
	
	public int animCount = 0;
	public int animFrame = 0;
	
	//MINUS START
	public boolean sync = false;
	//MINUS END
	
	public EntityDriveable(World world)
	{
		super(world);
		axes = new RotatedAxes();
		prevAxes = new RotatedAxes();
		preventEntitySpawning = true;
		setSize(1F, 1F);
		yOffset = 6F / 16F;
		ignoreFrustumCheck = true;
		if(world.isRemote){
			setRenderDistanceWeight(200D);
		}
	}
	
	public EntityDriveable(World world, DriveableType t, DriveableData d)
	{
		this(world);
		driveableType = t.registryname;
		driveableData = d;
	}
	
	protected void initType(DriveableType type, boolean clientSide)
	{
		seats = new EntitySeat[type.numPassengers + 1];
		for(int i = 0; i < type.numPassengers + 1; i++)
		{
			if(!clientSide)
			{
				seats[i] = new EntitySeat(world, this, i);
				world.spawnEntity(seats[i]);
			}
		}
		wheels = new EntityWheel[type.wheelPositions.length];
		for(int i = 0; i < wheels.length; i++)
		{
			if(!clientSide)
			{
				wheels[i] = new EntityWheel(world, this, i);
				world.spawnEntity(wheels[i]);
			}
		}
		stepHeight = type.wheelStepHeight;
		yOffset = type.yOffset;
		
		/*emitterTimers = new int[type.emitters.size()];
		for(int i = 0; i < type.emitters.size(); i++)
		{
			emitterTimers[i] = rand.nextInt(type.emitters.get(i).emitRate);
		}*/
		
		//Register Plane to Radar on Spawning
		//if(type.onRadar == true)
		//	RadarRegistry.register(this);
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound tag)
	{
		tag = driveableData.writeToNBT(tag);
		tag.setString("Type", driveableType);
		tag.setFloat("RotationYaw", axes.getYaw());
		tag.setFloat("RotationPitch", axes.getPitch());
		tag.setFloat("RotationRoll", axes.getRoll());
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag)
	{
		driveableType = tag.getString("Type");
		driveableData = new DriveableData(tag);
		initType(DriveableType.getDriveable(driveableType), false);
		
		prevRotationYaw = tag.getFloat("RotationYaw");
		prevRotationPitch = tag.getFloat("RotationPitch");
		prevRotationRoll = tag.getFloat("RotationRoll");
		axes = new RotatedAxes(prevRotationYaw, prevRotationPitch, prevRotationRoll);
		
	}
	
	@Override
	public void writeSpawnData(ByteBuf data)
	{
		ByteBufUtils.writeUTF8String(data, driveableType);
		
		NBTTagCompound tag = new NBTTagCompound();
		driveableData.writeToNBT(tag);
		ByteBufUtils.writeTag(data, tag);
		
		data.writeFloat(axes.getYaw());
		data.writeFloat(axes.getPitch());
		data.writeFloat(axes.getRoll());
		
		//Write damage
		/*for(EnumDriveablePart ep : EnumDriveablePart.values())
		{
			DriveablePart part = getDriveableData().parts.get(ep);
			data.writeShort((short)part.health);
			data.writeBoolean(part.onFire);
		}*/
	}

	@Override
	public void readSpawnData(ByteBuf data)
	{
		try
		{
			driveableType = ByteBufUtils.readUTF8String(data);
			driveableData = new DriveableData(ByteBufUtils.readTag(data));
			initType(getDriveableType(), true);
			
			axes.setAngles(data.readFloat(), data.readFloat(), data.readFloat());
			prevRotationYaw = axes.getYaw();
			prevRotationPitch = axes.getPitch();
			prevRotationRoll = axes.getRoll();
			
			//Read damage
			/*for(EnumDriveablePart ep : EnumDriveablePart.values())
			{
				DriveablePart part = getDriveableData().parts.get(ep);
				part.health = data.readShort();
				part.onFire = data.readBoolean();
			}*/

		}
		catch(Exception e)
		{
			Util.log("Failed to retreive plane type from server.");
			super.setDead();
			e.printStackTrace();
		}
		
		camera = new EntityCamera(world, this);
		world.spawnEntity(camera);
	}
	/**
	 * Called with the movement of the mouse. Used in controlling vehicles if need be.
	 * @param deltaY 
	 * @param deltaX 
	 * @return if mouse movement was handled.
	 */
	@Override
	public abstract void onMouseMoved(int deltaX, int deltaY);
	
	@Override
	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera()
	{
		return camera;
	}

	protected boolean canSit(int seat)
	{
		return getDriveableType().numPassengers >= seat && seats[seat].getControllingPassenger() == null;
	}
	
	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	protected void entityInit()
	{
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity)
	{
		return entity.getEntityBoundingBox();
	}

	@Override
    public boolean canBePushed()
    {
        return false;
    }

	@Override
	public double getMountedYOffset()
	{
		return -0.3D;
	}
	
	@Override
    public double getYOffset()
    {
    	return yOffset;
    }
	
	@Override
	/** Pass generic damage to the core */
	public boolean attackEntityFrom(DamageSource damagesource, float i) {
		return world.isRemote || isDead || attackPart(EnumDriveablePart.core, damagesource, i);
	}
	
	@Override
	public void setDead()
	{
		super.setDead();
		
		//Unregister to Radar
		//RadarRegistry.unregister(this);
		if(world.isRemote){
			camera.setDead();
		}
		
		for(EntitySeat seat : seats){
			if(seat != null){
				seat.setDead();
			}
		}
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) 
	{
		//Do nothing. Like a boss.
		// TODO: perhaps send the player flying??
		//Sounds good. ^ 
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !isDead;
	}
	
	@Override
	public void applyEntityCollision(Entity entity)
	{
		if(!isPartOfThis(entity))
			super.applyEntityCollision(entity);
	}
	
	@Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport)
    {
		if(ticksExisted > 1)
			return;
		if(!this.getPassengers().isEmpty() && this.getControllingPassenger() instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)this.getPassengers().get(0)))
		{
			//
		}
		else
		{				
			if(syncFromServer)
			{
				serverPositionTransitionTicker = posRotationIncrements + 5;
			}
			else
			{
				double var10 = x - posX;
				double var12 = y - posY;
				double var14 = z - posZ;
				double var16 = var10 * var10 + var12 * var12 + var14 * var14;
	
				if (var16 <= 1.0D)
				{
					return;
				}
	
				serverPositionTransitionTicker = 3;
			}
			serverPosX = x;
			serverPosY = y;
			serverPosZ = z;
			serverYaw = yaw;
			serverPitch = pitch;
		}
	}
	
	public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw)
	{
		if(world.isRemote)
		{
			serverPosX = x;
			serverPosY = y;
			serverPosZ = z;
			serverYaw = yaw;
			serverPitch = pitch;
			serverRoll = roll;
			serverPositionTransitionTicker = 5;
		}
		else
		{
			setPosition(x, y, z);
			prevRotationYaw = yaw;
			prevRotationPitch = pitch;
			prevRotationRoll = roll;
			setRotation(yaw, pitch, roll);
		}
		//Set the motions regardless of side.
		motionX = motX;
		motionY = motY;
		motionZ = motZ;
		angularVelocity = new Vector3f(velYaw, velPitch, velRoll);
		throttle = throt;
	}
	

	@Override
	public void setVelocity(double d, double d1, double d2)
	{
		motionX = d;
		motionY = d1;
		motionZ = d2;
	}
	
	@Override
	public boolean pressKey(int key, EntityPlayer player){
		return false;
	}
	
	@Override
	public void updateKeyHeldState(int key, boolean held)
	{
		if(world.isRemote)
		{
			FlansMod.getNewPacketHandler().sendToServer(new PacketDriveableKeyHeld(key, held));
		}
		switch(key)
		{
		case 9 : leftMouseHeld = held; break;
		case 8 : rightMouseHeld = held; break;
		}
	}

	private boolean driverIsCreative()
	{
		return seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer)seats[0].getControllingPassenger()).capabilities.isCreativeMode;
	}
	
	private EntityPlayer getDriver()
	{
		if(seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer)
			return ((EntityPlayer)seats[0].getControllingPassenger());
		else return null;
	}
	
	public Vector3f getOrigin(DriveablePosition dp)
	{
		//Rotate the gun vector to global axes
		Vector3f localGunVec = new Vector3f(dp.position);
				
		if(dp.part == EnumDriveablePart.turret)
		{
			//Untranslate by the turret origin, to get the rotation about the right point
			Vector3f.sub(localGunVec, getDriveableType().turretOrigin, localGunVec);
			//Rotate by the turret angles
			localGunVec = seats[0].looking.findLocalVectorGlobally(localGunVec);
			//Translate by the turret origin
			Vector3f.add(localGunVec, getDriveableType().turretOrigin, localGunVec);
		}
		
		return rotate(localGunVec);
	}
	
	public Vector3f getLookVector(DriveablePosition dp)
	{
		return axes.getXAxis();
	}
		
	@Override
    public void onUpdate(){
        super.onUpdate();
        
        if(world.isRemote && !sync){
			FlansMod.getNewPacketHandler().sendToServer(new PacketDriveableSync(this));
		}
        
        DriveableType type = getDriveableType();
        
        if(!world.isRemote){
        	for(int i = 0; i < getDriveableType().numPassengers + 1; i++){
        		if(seats[i] == null || !seats[i].addedToChunk){
        			seats[i] = new EntitySeat(world, this, i);
    				world.spawnEntity(seats[i]);
        		}
        	}
        	for(int i = 0; i < type.wheelPositions.length; i++){
        		if(wheels[i] == null || !wheels[i].addedToChunk){
        			wheels[i] = new EntityWheel(world, this, i);
    				world.spawnEntity(wheels[i]);
        		}
        	}
        }
        
        //Harvest stuff
  		//Aesthetics
  		if(hasEnoughFuel()){
  			harvesterAngle += throttle / 5F;	
  		}
  		//Actual harvesting
  		/*if(type.harvestBlocks && type.health.get(EnumDriveablePart.harvester) != null)
  		{
  			CollisionBox box = type.health.get(EnumDriveablePart.harvester);
  			for(float x = box.x; x <= box.x + box.w; x++)
  			{
  				for(float y = box.y; y <= box.y + box.h; y++)
  				{
  					for(float z = box.z; z <= box.z + box.d; z++)
  					{
  						Vector3f v = axes.findLocalVectorGlobally(new Vector3f(x, y, z));
  						
  						int blockX = (int)Math.round(posX + v.x);
  						int blockY = (int)Math.round(posY + v.y);
  						int blockZ = (int)Math.round(posZ + v.z);
  						IBlockState block = world.getBlockState(new BlockPos(blockX, blockY, blockZ));
  						
  						boolean cancelled = false;
						if(seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayerMP)
						{
							int eventOutcome = ForgeHooks.onBlockBreakEvent(world, ((EntityPlayerMP)seats[0].getControllingPassenger()).capabilities.isCreativeMode ? GameType.CREATIVE : ((EntityPlayerMP)seats[0].getControllingPassenger()).capabilities.allowEdit ? GameType.SURVIVAL : GameType.ADVENTURE, (EntityPlayerMP)seats[0].getControllingPassenger(), new BlockPos(blockX, blockY, blockZ));
							cancelled = eventOutcome == -1;
						}
						if(!cancelled)
						{
	  						if(type.materialsHarvested.contains(block.getMaterial()) && block.getBlockHardness(world, new BlockPos(blockX, blockY, blockZ)) >= 0F)
	  						{
	  							//Add the itemstack to mecha inventory
	  							List<ItemStack> stacks = block.getBlock().getDrops(world, new BlockPos(blockX, blockY, blockZ), world.getBlockState(new BlockPos(blockX, blockY, blockZ)), 0);
	  							for(int i = 0; i < stacks.size(); i++)
	  							{
	  								ItemStack stack = stacks.get(i);
	  								if(!InventoryHelper.addItemStackToInventory(driveableData, stack, driverIsCreative()) && !world.isRemote && world.getGameRules().getBoolean("doTileDrops"))//.getGameRuleBooleanValue("doTileDrops"))
	  								{
	  									world.spawnEntity(new EntityItem(world, blockX + 0.5F, blockY + 0.5F, blockZ + 0.5F, stack));
	  								}
	  							}
	  							//Destroy block
	  							world.destroyBlock(new BlockPos(blockX, blockY, blockZ), false);
	  						}
						}
  					}
  				}
  			}
  		}*/

        
        for(DriveablePart part : getDriveableData().parts.values())
        {
        	if(part.box != null)
        	{
        		
	        	part.update(this);
	        	//Client side particles
	        	if(world.isRemote)
	        	{
	           		if(part.onFire)
	        		{
	        			//Pick a random position within the bounding box and spawn a flame there
		        		Vector3f pos = axes.findLocalVectorGlobally(new Vector3f(part.box.x + rand.nextFloat() * part.box.w, part.box.y + rand.nextFloat() * part.box.h, part.box.z + rand.nextFloat() * part.box.d));
		        		world.spawnParticle(EnumParticleTypes.FLAME, posX + pos.x, posY + pos.y, posZ + pos.z, 0, 0, 0);
	        		}
	           		if(part.health > 0 && part.health < part.maxHealth / 2)
	        		{
	        			//Pick a random position within the bounding box and spawn a flame there
		        		Vector3f pos = axes.findLocalVectorGlobally(new Vector3f(part.box.x + rand.nextFloat() * part.box.w, part.box.y + rand.nextFloat() * part.box.h, part.box.z + rand.nextFloat() * part.box.d));
		        		world.spawnParticle(part.health < part.maxHealth / 4 ? EnumParticleTypes.SMOKE_LARGE : EnumParticleTypes.SMOKE_NORMAL, posX + pos.x, posY + pos.y, posZ + pos.z, 0, 0, 0);
	        		}
	        	}
	        	//Server side fire handling
	        	if(part.onFire)
	        	{
	        		//Rain can put out fire
	        		if(world.isRaining() && rand.nextInt(40) == 0)
	        			part.onFire = false;
	        		//Also water blocks
	        		//Get the centre point of the part
	        		Vector3f pos = axes.findLocalVectorGlobally(new Vector3f(part.box.x + part.box.w / 2F, part.box.y + part.box.h / 2F, part.box.z + part.box.d / 2F));
	        		if(world.getBlockState(new BlockPos(MathHelper.floor(posX + pos.x), MathHelper.floor(posY + pos.y), MathHelper.floor(posZ + pos.z))).getMaterial() == Material.WATER)
	        		{
	        			part.onFire = false;
	        		}
	        	}
	        	else
	        	{
	        		Vector3f pos = axes.findLocalVectorGlobally(new Vector3f(part.box.x / 16F + part.box.w / 32F, part.box.y / 16F + part.box.h / 32F, part.box.z / 16F + part.box.d / 32F));
	        		if(world.getBlockState(new BlockPos(MathHelper.floor(posX + pos.x), MathHelper.floor(posY + pos.y), MathHelper.floor(posZ + pos.z))).getMaterial() == Material.LAVA)
	        		{
	        			part.onFire = true;
	        		}
	        	}
        	}
        }
        
        /*for(int i = 0; i < type.emitters.size(); i++)
        {
        	ParticleEmitter emitter = type.emitters.get(i);
        	emitterTimers[i]--;
        	boolean canEmit = false;
    		DriveablePart part = getDriveableData().parts.get(EnumDriveablePart.getPart(emitter.part));
			float healthPercentage = (float)part.health / (float)part.maxHealth;
    		if(isPartIntact(EnumDriveablePart.getPart(emitter.part)) && healthPercentage >= emitter.minHealth && healthPercentage <= emitter.maxHealth){
    			canEmit = true;
    		} else {
    			canEmit = false;
    		}
        	if(emitterTimers[i] <= 0)
        	{     		
        		if(throttle >= emitter.minThrottle && throttle <= emitter.maxThrottle && canEmit){
        		//Emit!       		
        		Vector3f velocity = new Vector3f(0,0,0);;   
        		Vector3f pos = new Vector3f(0,0,0);
        		if(seats != null && seats[0] != null){
        		if(EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.turret && EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.head){
        			Vector3f localPosition = new Vector3f(emitter.origin.x + rand.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5f, 
							 emitter.origin.y + rand.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5f, 
							 emitter.origin.z + rand.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5f);
        			
        		pos = axes.findLocalVectorGlobally(localPosition);
        		velocity = axes.findLocalVectorGlobally(emitter.velocity);   
        		} else if(EnumDriveablePart.getPart(emitter.part) == EnumDriveablePart.turret || EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.head){
        			
        			Vector3f localPosition2 = new Vector3f(emitter.origin.x + rand.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5f, 
							 emitter.origin.y + rand.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5f, 
							 emitter.origin.z + rand.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5f);
        			
        		RotatedAxes yawOnlyLooking = new RotatedAxes(seats[0].looking.getYaw() + axes.getYaw(), axes.getPitch(), axes.getRoll());

        		pos = yawOnlyLooking.findLocalVectorGlobally(localPosition2);
        		velocity = yawOnlyLooking.findLocalVectorGlobally(emitter.velocity);  
        		}
        		world.spawnParticle(emitter.effectType, 
        				posX + pos.x, posY + pos.y, posZ + pos.z, velocity.x, velocity.y, velocity.z);
        		}
        		}
        		emitterTimers[i] = emitter.emitRate;
        	}
        }*/
        
        checkParts();

		prevRotationYaw = axes.getYaw();
		prevRotationPitch = axes.getPitch();
		prevRotationRoll = axes.getRoll();		
		prevAxes = axes.clone();
		
		boolean canThrust = driverIsCreative() || driveableData.fuelInTank > 0;

		//If there's no player in the driveable or it cannot thrust, slow the plane and turn off mouse held actions
		if((seats[0] != null && seats[0].getControllingPassenger() == null) || !canThrust && getDriveableType().maxThrottle != 0 && getDriveableType().maxNegativeThrottle != 0)
		{
			throttle *= 0.98F;
			rightMouseHeld = leftMouseHeld = false;
		}

		//Handle fuel
			
		int fuelMultiplier = 2;
		
		//The tank is currently full, so do nothing
		if(getDriveableData().fuelInTank >= type.fuelTankSize)
			return;
		
		//Look through the entire inventory for fuel cans, buildcraft fuel buckets and RedstoneFlux power sources
		for(int i = 0; i < getDriveableData().getSizeInventory(); i++)
		{
			ItemStack stack = getDriveableData().getStackInSlot(i);
			if(stack == null || stack.getCount() <= 0)
				continue;
			Item item = stack.getItem();
			//If we have an electric engine, look for RedstoneFlux power source items, such as power cubes
			/*
			if(getDriveableData().engine.useRFPower)
			{
				if(item instanceof IEnergyContainerItem)
				{
					IEnergyContainerItem energy = (IEnergyContainerItem)item;
					getDriveableData().fuelInTank += (fuelMultiplier * energy.extractEnergy(stack, getDriveableData().engine.RFDrawRate, false)) / getDriveableData().engine.RFDrawRate;
				}
			}
			else
			*/
			{
				//Check for Flan's Mod fuel items
				if(item instanceof ItemPart)
				{
					PartType part = ((ItemPart)item).type;
					//Check it is a fuel item
					if(part.category == EnumPartCategory.FUEL)
					{
						//Put 2 points of fuel 
						getDriveableData().fuelInTank += fuelMultiplier;
						
						//Damage the fuel item to indicate being used up
						int damage = stack.getItemDamage();
						stack.setItemDamage(damage + 1);
		
						//If we have finished this fuel item
						if(damage >= stack.getMaxDamage())
						{
							//Reset the damage to 0
							stack.setItemDamage(0);
							//Consume one item
							stack.shrink(1);
							//If we consumed the last one, destroy the stack
							if(stack.getCount() <= 0)
								getDriveableData().setInventorySlotContents(i, null);
						}
						
						//We found a fuel item and consumed some, so we are done
						break;
					}
				}
				//Check for Buildcraft oil and fuel buckets
				else if(FlansMod.hooks.BuildCraftLoaded && stack.isItemEqual(FlansMod.hooks.BuildCraftOilBucket) && getDriveableData().fuelInTank + 1000 * fuelMultiplier <= type.fuelTankSize)
				{
					getDriveableData().fuelInTank += 1000 * fuelMultiplier;
					getDriveableData().setInventorySlotContents(i, new ItemStack(Items.BUCKET));
				}
				else if(FlansMod.hooks.BuildCraftLoaded && stack.isItemEqual(FlansMod.hooks.BuildCraftFuelBucket) && getDriveableData().fuelInTank + 2000 * fuelMultiplier <= type.fuelTankSize)
				{
					getDriveableData().fuelInTank += 2000 * fuelMultiplier;
					getDriveableData().setInventorySlotContents(i, new ItemStack(Items.BUCKET));
				}
			}
		}
	}
		
	public void checkForCollisions()
	{
		boolean crashInWater = false;
		double speed = getSpeedXYZ();
		for(DriveablePosition p : getDriveableType().collisionPoints)
		{
			if(driveableData.parts.get(p.part).dead)
				continue;
			Vector3f lastRelPos = prevAxes.findLocalVectorGlobally(p.position);
			Vec3d lastPos = new Vec3d(prevPosX + lastRelPos.x, prevPosY + lastRelPos.y, prevPosZ + lastRelPos.z);
			
			Vector3f currentRelPos = axes.findLocalVectorGlobally(p.position);
			Vec3d currentPos = new Vec3d(posX + currentRelPos.x, posY + currentRelPos.y, posZ + currentRelPos.z);
			
			if(FlansMod.DEBUG && world.isRemote)
			{
				world.spawnEntity(new EntityDebugVector(world, new Vector3f(lastPos), Vector3f.sub(currentRelPos, lastRelPos, null), 10, 1F, 0F, 0F));
			}
			
			RayTraceResult hit = world.rayTraceBlocks(lastPos, currentPos, crashInWater);
			if(hit != null && hit.typeOfHit == RayTraceResult.Type.BLOCK)
			{
				BlockPos pos = hit.getBlockPos();
				IBlockState state =  world.getBlockState(pos);
				Block blockHit = state.getBlock();
				
				float blockHardness = state.getBlockHardness(world, pos);
				
				//Attack the part
				if(!attackPart(p.part, DamageSource.IN_WALL, blockHardness * blockHardness * (float)speed) && Config.vehiclesBreakBlocks)
				{
					//And if it didn't die from the attack, break the block
					//TODO worldObj.playAuxSFXAtEntity(null, 2001, pos, Block.getStateId(state));					
					
					if(!world.isRemote)
					{	
						blockHit.dropBlockAsItem(world, pos, state, 1);		
						world.setBlockToAir(pos);
					}
				}
				else
				{
					//The part died!
					world.createExplosion(this, currentPos.xCoord, currentPos.yCoord, currentPos.zCoord, 1F, false);
				}
			}
			
		}
	}
	
	@Override
    public void fall(float distance, float damageMultiplier)
    {
        if (distance <= 0) 
        	return;
        //super.fall(k);
        int i = MathHelper.ceil(distance - 10F);

        if(i > 0)
        	attackPart(EnumDriveablePart.core, DamageSource.FALL, damageMultiplier * i / 5);
    }
	
	/** Attack a certain part of a driveable and return whether it broke or not */
	public boolean attackPart(EnumDriveablePart ep, DamageSource source, float damage)
	{
		//DriveablePart part = driveableData.parts.get(ep);
		return false;//part.attack(damage, source.isFireDamage());
	}
		
	/** Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates */
	public Vector3f rotate(Vector3f inVec)
	{
		return axes.findLocalVectorGlobally(inVec);
	}
		
	/** Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates */
	public Vector3f rotate(Vec3d inVec)
	{
		return rotate(inVec.xCoord, inVec.yCoord, inVec.zCoord);
	}

	/** Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates */
	public Vector3f rotate(double x, double y, double z)
	{	
		return rotate(new Vector3f((float)x, (float)y, (float)z));
	}
	
	//Rotate the plane locally by some angle about the yaw axis
	public void rotateYaw(float rotateBy)
	{
		if(Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalYaw(rotateBy);
		updatePrevAngles();
	}
	
	//Rotate the plane locally by some angle about the pitch axis
	public void rotatePitch(float rotateBy)
	{
		if(Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalPitch(rotateBy);
		updatePrevAngles();
	}
	
	//Rotate the plane locally by some angle about the roll axis
	public void rotateRoll(float rotateBy)
	{
		if(Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalRoll(rotateBy);
		updatePrevAngles();
	}
		
	public void updatePrevAngles()
	{		
		//Correct angles that crossed the +/- 180 line, so that rendering doesnt make them swing 360 degrees in one tick.
		double dYaw = axes.getYaw() - prevRotationYaw;
		if(dYaw > 180)
			prevRotationYaw += 360F;
		if(dYaw < -180)
			prevRotationYaw -= 360F;
		
		double dPitch = axes.getPitch() - prevRotationPitch;
		if(dPitch > 180)
			prevRotationPitch += 360F;
		if(dPitch < -180)
			prevRotationPitch -= 360F;
		
		double dRoll = axes.getRoll() - prevRotationRoll;
		if(dRoll > 180)
			prevRotationRoll += 360F;
		if(dRoll < -180)
			prevRotationRoll -= 360F;
	}
	
	public void setRotation(float rotYaw, float rotPitch, float rotRoll){
		axes.setAngles(rotYaw, rotPitch, rotRoll);
	}
	
	//Used to stop self collision
	public boolean isPartOfThis(Entity ent)
	{
		for(EntitySeat seat : seats)
		{
			if(seat == null)
				continue;
			if(ent == seat)
				return true;
			if(seats[0].getControllingPassenger() == ent)
				return true;
		}
		return ent == this;	
	}
	
    public DriveableType getDriveableType()
    {
    	return DriveableType.getDriveable(driveableType);
    }
    
    public DriveableData getDriveableData()
    {
    	return driveableData;
    }
	
	@Override
	public boolean isDead()
	{
		return isDead;
	}
	
	@Override
	public Entity getControllingEntity()
	{
		return seats[0].getControllingEntity();
	}
	
	@Override
	public ItemStack getPickedResult(RayTraceResult target)
	{
		ItemStack stack = new ItemStack(getDriveableType().item, 1, 0);
		stack.setTagCompound(driveableData.writeToNBT(new NBTTagCompound()));
		return stack;
	}
	

	public boolean hasFuel(){
		if(seats == null || seats[0] == null || seats[0].getControllingPassenger() == null){
			return false;
		}
		return driverIsCreative() || driveableData.fuelInTank > 0;
	}

	public boolean hasEnoughFuel(){
		if(seats == null || seats[0] == null || seats[0].getControllingPassenger() == null){
			return false;
		}
		return driverIsCreative() || driveableData.fuelInTank > driveableData.engine.fuelConsumption * throttle;
	}
	
	//Physics time! Oooh yeah
	
	public double getSpeedXYZ()
	{
		return Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
	}
	
	public double getSpeedXZ()
	{
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}
	
	/** To be overriden by vehicles to get alternate collision system */
	public boolean landVehicle()
	{
		return false;
	}
	
	/** Overriden by planes for wheel parts */
	public boolean gearDown()
	{
		return true;
	}
	
	/** Whether or not the plane is on the ground 
	 * TODO : Replace with proper check based on wheels
	 * */
	public boolean onGround()
	{
		return onGround;
	}
	
	/** For overriding for toggles such as gear up / down on planes */
	public boolean canHitPart(EnumDriveablePart part)
	{
		return true;
	}
	
	/** Internal method for checking that all parts are ok, destroying broken ones, dropping items and making sure that child parts are destroyed when their parents are */
	public void checkParts()
	{
		for(DriveablePart part : getDriveableData().parts.values())
		{
			if(part != null && !part.dead && part.health <= 0 && part.maxHealth > 0)
			{
				killPart(part);
			}
		}
		
		
		//for(EntitySeat seat : seats){}
		
		
		//If the core was destroyed, kill the driveable
		/*if(getDriveableData().parts.get(EnumDriveablePart.core).dead)
		{
			if(!world.isRemote)
			{
				for(DriveablePart part : driveableData.parts.values())
				{
					if(part.health > 0 && !part.dead)
						killPart(part);
				}
			}
			setDead();
		}*/
			
	}
	
	/** Internal method for killing driveable parts */
	private void killPart(DriveablePart part){
		if(part.dead){
			return;
		}
		part.health = 0;
		part.dead = true;
		
		//Drop items
		//DriveableType type = getDriveableType();
		if(!world.isRemote){
			Vector3f pos = new Vector3f(0, 0, 0);
					
			//Get the midpoint of the part
			if(part.box != null){
				pos = axes.findLocalVectorGlobally(new Vector3f(part.box.x / 16F + part.box.w / 32F, part.box.y / 16F + part.box.h / 32F, part.box.z / 16F + part.box.d / 32F));
			}

			/*ArrayList<ItemStack> drops = type.getItemsRequired(part, getDriveableData().engine);
			if(drops != null){
				//Drop each itemstack 
				for(ItemStack stack : drops){
					world.spawnEntity(new EntityItem(world, posX + pos.x, posY + pos.y, posZ + pos.z, stack.copy()));
				}
			}*/
			dropItemsOnPartDeath(pos, part);
			
			//Inventory is in the core, so drop it if the core is broken
			if(part.type == EnumDriveablePart.core){
				for(int i = 0; i < getDriveableData().getSizeInventory(); i++){
					ItemStack stack = getDriveableData().getStackInSlot(i);
					if(stack != null){
						world.spawnEntity(new EntityItem(world, posX + rand.nextGaussian(), posY + rand.nextGaussian(), posZ + rand.nextGaussian(), stack));
					}
				}
			}
		}
		
		//Kill all child parts to stop things floating unconnected
		for(EnumDriveablePart child : part.type.getChildren())
		{
			killPart(getDriveableData().parts.get(child));
		}
	}
	
	/** Method for planes, vehicles and whatnot to drop their own specific items if they wish */
	protected abstract void dropItemsOnPartDeath(Vector3f midpoint, DriveablePart part);
	
	@Override
	public float getPlayerRoll() {
		return axes.getRoll();
	}
	
	@Override
	public float getPrevPlayerRoll() {
		return prevAxes.getRoll();
	}
	
	@Override
	public float getCameraDistance(){
		return getDriveableType().cameraDistance;
	}
	
	public boolean isPartIntact(EnumDriveablePart part){
		/*DriveablePart thisPart = getDriveableData().parts.get(part);
		return thisPart.maxHealth == 0 || thisPart.health > 0;*/
		return true;
	}
	
	public abstract boolean hasMouseControlMode();
	
	public abstract String getBombInventoryName();
	
	public abstract String getMissileInventoryName();
	
	public boolean rotateWithTurret(Seat seat){
		return seat.part == EnumDriveablePart.turret;
	}
	
	@Override
	public String getName(){
		return getDriveableType().name;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean showInventory(int seat){
		return seat != 0 || !FlansModClient.controlModeMouse;
	}
	
}
