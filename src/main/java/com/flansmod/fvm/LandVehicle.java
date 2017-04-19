package com.flansmod.fvm;

import java.util.ArrayList;
import java.util.List;

import com.flansmod.api.IControllable;
import com.flansmod.client.FlansModClient;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.DriveablePosition;
import com.flansmod.common.network.packets.PacketDriveableKey;
import com.flansmod.common.network.packets.PacketDriveableKeyHeld;
import com.flansmod.common.util.Config;
import com.flansmod.common.util.Util;
import com.flansmod.common.vector.Vector3f;
import com.flansmod.fvm.packets.PacketVehicleControl;
import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.fvm.FVM;
import net.fexcraft.mod.fvm.data.LoadedIn;
import net.fexcraft.mod.fvm.data.VehicleType;
import net.fexcraft.mod.fvm.items.VehicleItem;
import net.fexcraft.mod.fvm.util.FvmPerms;
import net.fexcraft.mod.fvm.util.FvmResources;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LandVehicle extends Entity implements IControllable, IEntityAdditionalSpawnData, LockableObject {
	
	public boolean syncFromServer = true;
	/** Ticks since last server update. Use to smoothly transition to new position */
	public int serverPositionTransitionTicker;
	/** Server side position, as synced by PacketVehicleControl packets */
	public double serverPosX, serverPosY, serverPosZ;
	/** Server side rotation, as synced by PacketVehicleControl packets */
	public double serverYaw, serverPitch, serverRoll;
	
	/** The driveable data which contains the inventory, the engine and the fuel */
	public VehicleType data;
	
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
	
	public RotatedAxes prevAxes;
	public RotatedAxes axes;
	
	public EntitySeat[] seats;
	
	private float yOffset;
	
	@SideOnly(Side.CLIENT)
	public EntityLivingBase camera;
	
	/** Position of looping sounds */
	public int soundPosition;
	/** Front wheel yaw, used to control the vehicle steering */
	public float wheelsYaw;
	/** Despawn time */
	private int ticksSinceUsed = 0;
	/** Wheel rotation angle. Only applies to vehicles that set a rotating wheels flag */
	public float wheelsAngle;
	/** Delayer for door button */
	public int toggleTimer = 0;
	
	
	public LandVehicle(World world){
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
		//
		stepHeight = 1.0F;
	}
	
	public LandVehicle(World world, VehicleType type){
		this(world);
		data = type;
	}
	
	//This one deals with spawning from a vehicle spawner
	public LandVehicle(World world, double x, double y, double z, VehicleType data){
		this(world, data);
		stepHeight = 1.0F;
		setPosition(x, y, z);
		initType(data, false);
	}

	//This one allows you to deal with spawning from items
	public LandVehicle(World world, double x, double y, double z, EntityPlayer placer, VehicleType data){
		this(world, data);
		stepHeight = 1.0F;
		setPosition(x, y, z);
		rotateYaw(placer.rotationYaw + 90F);
		initType(data, false);
	}
	
	//This one allows you to deal with spawning from the constructor
		public LandVehicle(World world, double x, double y, double z, int placer, VehicleType data){
			this(world, data);
			stepHeight = 1.0F;
			setPosition(x, y, z);
			rotateYaw((placer * 90f) + 90F);
			initType(data, false);
		}

	@Override
	public void writeSpawnData(ByteBuf buffer){
		ByteBufUtils.writeTag(buffer, data.write(null));
		
		buffer.writeFloat(axes.getYaw());
		buffer.writeFloat(axes.getPitch());
		buffer.writeFloat(axes.getRoll());
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
		try{
			data = new VehicleType(LoadedIn.ENTITY, ByteBufUtils.readTag(buffer));
			FvmResources.loadVehicleModel(data);
			
			initType(data, true);
			
			axes.setAngles(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
			prevRotationYaw = axes.getYaw();
			prevRotationPitch = axes.getPitch();
			prevRotationRoll = axes.getRoll();
		}
		catch(Exception e){
			e.printStackTrace();
			Print.debug("Failed to receive additional spawn data for this vehicle!");
		}
		
		camera = new EntityCamera(world, this);
		world.spawnEntity(camera);
		
	}
	
	protected void initType(VehicleType type, boolean clientSide){
		seats = new EntitySeat[type.seats.size()];
		for(int i = 0; i < type.seats.size(); i++){
			if(!clientSide){
				seats[i] = new EntitySeat(world, this, i);
				world.spawnEntity(seats[i]);
			}
		}
		wheels = new EntityWheel[type.wheelPos.length];
		for(int i = 0; i < wheels.length; i++){
			if(!clientSide){
				wheels[i] = new EntityWheel(world, this, i);
				world.spawnEntity(wheels[i]);
			}
		}
		stepHeight = type.wheelStepHeight;
		yOffset = 10F / 16F;//TODO check dis
		
		data.scripts.onCreated(this);
	}

	@Override
	protected void entityInit(){
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag){
		tag = data.write(tag);
		tag.setFloat("RotationYaw", axes.getYaw());
		tag.setFloat("RotationPitch", axes.getPitch());
		tag.setFloat("RotationRoll", axes.getRoll());
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag){
		if(data == null){
			data = new VehicleType(LoadedIn.ENTITY, tag);
		}
		else{
			data.read(tag);
		}
		
		initType(data, false);
		
		prevRotationYaw = tag.getFloat("RotationYaw");
		prevRotationPitch = tag.getFloat("RotationPitch");
		prevRotationRoll = tag.getFloat("RotationRoll");
		axes = new RotatedAxes(prevRotationYaw, prevRotationPitch, prevRotationRoll);
	}
	
	protected boolean canSit(int seat){
		return data.seats.size() >= seat && seats[seat].getControllingPassenger() == null;
	}
	
	@Override
	protected boolean canTriggerWalking(){
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBox(Entity entity)
	{
		return entity.getEntityBoundingBox();
	}

	@Override
    public boolean canBePushed(){
        return false;
    }

	@Override
	public double getMountedYOffset(){
		return 0D;
	}
	
	@Override
    public double getYOffset(){
    	return yOffset;
    }
	
	@Override
	public void setDead(){
		super.setDead();
		if(world.isRemote){
			camera.setDead();
		}
		for(EntitySeat seat : seats){
			if(seat != null){
				seat.setDead();
			}
		}
		for(EntityWheel wheel : wheels){
			if(wheel != null){
				wheel.setDead();
			}
		}
		data.scripts.onRemoved(this);
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		//Do nothing. Like a boss.
		// TODO: perhaps send the player flying??
		//Sounds good. ^ 
	}

	@Override
	public boolean canBeCollidedWith(){
		return !isDead;
	}
	
	@Override
	public void applyEntityCollision(Entity entity){
		if(!isPartOfThis(entity)){
			super.applyEntityCollision(entity);
		}
	}
	
	@Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport){
		if(ticksExisted > 1){
			return;
		}
		if(!this.getPassengers().isEmpty() && this.getControllingPassenger() instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)this.getPassengers().get(0))){
			//
		}
		else{				
			if(syncFromServer){
				serverPositionTransitionTicker = posRotationIncrements + 5;
			}
			else{
				double var10 = x - posX;
				double var12 = y - posY;
				double var14 = z - posZ;
				double var16 = var10 * var10 + var12 * var12 + var14 * var14;
	
				if (var16 <= 1.0D){
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
	
	public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw){
		if(world.isRemote){
			serverPosX = x;
			serverPosY = y;
			serverPosZ = z;
			serverYaw = yaw;
			serverPitch = pitch;
			serverRoll = roll;
			serverPositionTransitionTicker = 5;
		}
		else{
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
		//
		wheelsYaw = steeringYaw;
	}
	

	@Override
	public void setVelocity(double d, double d1, double d2){
		motionX = d;
		motionY = d1;
		motionZ = d2;
	}
	
	@Override
	public boolean processInitialInteract(EntityPlayer entityplayer, EnumHand hand){
		if(isDead || world.isRemote || hand == EnumHand.OFF_HAND){
			return false;
		}
		
		ItemStack currentItem = entityplayer.getHeldItemMainhand();
		if(!currentItem.isEmpty() && currentItem.getItem() instanceof KeyItem){
			if(this.isLocked()){
				this.unlock(world, entityplayer, currentItem, (KeyItem)currentItem.getItem());
			}
			else{
				this.lock(world, entityplayer, currentItem, (KeyItem)currentItem.getItem());
			}
			return true;
		}
		if(data.isLocked){
			Print.chat(entityplayer, "Vehicle is locked.");
			return true;
		}
		
		if(data.scripts.size() > 0){
			if(data.scripts.onInteract(this, entityplayer)){
				return true;
			}
		}
		
		//TODO Item interaction
		
		//Check each seat in order to see if the player can sit in it
		for(int i = 0; i <= data.seats.size(); i++){
			if(seats[i] != null && seats[i].processInitialInteract(entityplayer, hand)){
				if(i == 0){
					//FlansMod.proxy.doTutorialStuff(entityplayer, this);
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean pressKey(int key, EntityPlayer player){
		try{
			if(key == 9){
				return false;
			}
			//Send keys which require server side updates to the server
			if(world.isRemote && (key == 6 || key == 8 || key == 9 || key == 16 || key == 17)){
				FlansMod.getNewPacketHandler().sendToServer(new PacketDriveableKey(key));
				return true;
			}
			switch(key){
				case 0 : //Accelerate : Increase the throttle, up to 1.
				{
					throttle += 0.01F;
					if(throttle > 1F){
						throttle = 1F;
					}
					return true;
				}
				case 1 : //Decelerate : Decrease the throttle, down to -1, or 0 if the vehicle cannot reverse
				{
					throttle -= 0.01F;
					if(throttle < -1F){
						throttle = -1F;
					}
					if(throttle < 0F && data.maxNegativeThrottle == 0F){
						throttle = 0F;
					}
					return true;
				}
				case 2 : //Left : Yaw the wheels left
				{
					wheelsYaw -= 1F;
					return true;
				}
				case 3 : //Right : Yaw the wheels right
				{
					wheelsYaw += 1F;
					return true;
				}
				case 4 : //Up : Brake
				{
					throttle *= 0.8F;
					if(onGround)
					{
						motionX *= 0.8F;
						motionZ *= 0.8F;
					}
					return true;
				}
				case 5 : //Down : Do nothing
				{
					return true;
				}
				case 6 : //Exit : Get out
				{
					seats[0].getControllingPassenger().dismountRidingEntity();
			  		return true;
				}
				case 7 : //Inventory
				{
					if(world.isRemote)
					{
						((EntityPlayer)seats[0].getControllingPassenger()).openGui(FVM.INSTANCE, 356, world, getPosition().getX(), getPosition().getY(), getPosition().getZ());
						//open inventory
					}
					return true;
				}
				case 8 : //Shoot shell
				case 9 : //Shoot bullet
				{
					return true;//super.pressKey(key, player);
				}
				case 10 : //Change control mode : Do nothing
				{
					return true;
				}
				case 11 : //Roll left : Do nothing
				{
					return true;
				}
				case 12 : //Roll right : Do nothing
				{
					return true;
				}
				case 13 : // Gear : Do nothing
				{
					return true;
				}
				case 14 : // Door
				{
					if(toggleTimer <= 0)
					{
						data.doors = !data.doors;
						//if(data.hasDoor)
							player.sendMessage(new TextComponentString("Doors " + (data.doors ? "open" : "closed")));
						toggleTimer = 10;
						FlansMod.getNewPacketHandler().sendToServer(new PacketVehicleControl(this));
					}
					return true;
				}
				case 15 : // Wing : Do nothing
				{
					return true;
				}
			}
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Vector3f getLookVector(DriveablePosition dp){
		return rotate(seats[0].looking.getXAxis());
	}
	
	@Override
	public void updateKeyHeldState(int key, boolean held){
		if(world.isRemote){
			FlansMod.getNewPacketHandler().sendToServer(new PacketDriveableKeyHeld(key, held));
		}
		switch(key){
			case 9 : leftMouseHeld = held; break;
			case 8 : rightMouseHeld = held; break;
		}
	}

	private boolean driverIsCreative(){
		try{
			return seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer)seats[0].getControllingPassenger()).capabilities.isCreativeMode;
		}
		catch(Exception e){
			return false;
		}
	}
	
	private EntityPlayer getDriver(){
		if(seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer){
			return ((EntityPlayer)seats[0].getControllingPassenger());
		}
		else{
			return null;
		}
	}
		
	@Override
    public void onUpdate(){
        super.onUpdate();
        
        if(!world.isRemote){
        	for(int i = 0; i < data.seats.size(); i++){
        		if(seats[i] == null || !seats[i].addedToChunk){
        			seats[i] = new EntitySeat(world, this, i);
    				world.spawnEntity(seats[i]);
        		}
        	}
        	for(int i = 0; i < data.wheelPos.length; i++){
        		if(wheels[i] == null || !wheels[i].addedToChunk){
        			wheels[i] = new EntityWheel(world, this, i);
    				world.spawnEntity(wheels[i]);
        		}
        	}
        }
        
        //Harvest stuff
  		//Aesthetics
  		/*if(hasEnoughFuel()){
  			harvesterAngle += throttle / 5F;	
  		}*/
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

		prevRotationYaw = axes.getYaw();
		prevRotationPitch = axes.getPitch();
		prevRotationRoll = axes.getRoll();		
		prevAxes = axes.clone();
		
		boolean canThrust = driverIsCreative() || data.fuelStored > 0;

		//If there's no player in the driveable or it cannot thrust, slow the plane and turn off mouse held actions
		if(seats == null || seats.length == 0){
			this.setDead();
			return;
		}
		if((seats[0] != null && seats[0].getControllingPassenger() == null) || !canThrust && data.maxThrottle != 0 && data.maxNegativeThrottle != 0){
			throttle *= 0.98F;
			rightMouseHeld = leftMouseHeld = false;
		}

		//Handle fuel
			
		//int fuelMultiplier = 2;
		
		//The tank is currently full, so do nothing
		/*if(data.fuelStored >= data.fuelTankSize){
			return;
		}*///TODO
		
		//Look through the entire inventory for fuel cans, buildcraft fuel buckets and RedstoneFlux power sources
		/*for(int i = 0; i < data.getContainer().getSizeInventory(); i++){
			ItemStack stack = data.getContainer().getStackInSlot(i);
			if(stack == null || stack.getCount() <= 0)
				continue;
			Item item = stack.getItem();
			//If we have an electric engine, look for RedstoneFlux power source items, such as power cubes
			
			if(getDriveableData().engine.useRFPower)
			{
				if(item instanceof IEnergyContainerItem)
				{
					IEnergyContainerItem energy = (IEnergyContainerItem)item;
					getDriveableData().fuelInTank += (fuelMultiplier * energy.extractEnergy(stack, getDriveableData().engine.RFDrawRate, false)) / getDriveableData().engine.RFDrawRate;
				}
			}
			else
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
			}
		}*/
		
		//Vehicle Stuff
		//Get vehicle type
		if(data == null){
			Util.log("Vehicle type null. Not ticking vehicle.");
			Static.stop();
			return;
		}

		//Work out if this is the client side and the player is driving
		boolean thePlayerIsDrivingThis = world.isRemote && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)seats[0].getControllingPassenger());

		//Despawning
		ticksSinceUsed++;
		if(!world.isRemote && seats[0].getControllingPassenger() != null){
			ticksSinceUsed = 0;
		}
		if(!world.isRemote && Config.vehicleLife > 0 && ticksSinceUsed > Config.vehicleLife * 20){
			setDead();
		}
		
		if(toggleTimer > 0)
			toggleTimer--;
		if(soundPosition > 0)
			soundPosition--;
		
		//Aesthetics
		//Rotate the wheels
		if(hasEnoughFuel()){
			wheelsAngle += throttle * 0.2F;	
		}
		
		//Return the wheels to their resting position
		wheelsYaw *= 0.9F;
		
		//Limit wheel angles
		if(wheelsYaw > 20)
			wheelsYaw = 20;
		if(wheelsYaw < -20)
			wheelsYaw = -20;
		
		//Player is not driving this. Update its position from server update packets 
		if(world.isRemote && !thePlayerIsDrivingThis){
			//The driveable is currently moving towards its server position. Continue doing so.
			if (serverPositionTransitionTicker > 0){
				double x = posX + (serverPosX - posX) / serverPositionTransitionTicker;
				double y = posY + (serverPosY - posY) / serverPositionTransitionTicker;
				double z = posZ + (serverPosZ - posZ) / serverPositionTransitionTicker;
				double dYaw = MathHelper.wrapDegrees(serverYaw - axes.getYaw());
				double dPitch = MathHelper.wrapDegrees(serverPitch - axes.getPitch());
				double dRoll = MathHelper.wrapDegrees(serverRoll - axes.getRoll());
				rotationYaw = (float)(axes.getYaw() + dYaw / serverPositionTransitionTicker);
				rotationPitch = (float)(axes.getPitch() + dPitch / serverPositionTransitionTicker);
				float rotationRoll = (float)(axes.getRoll() + dRoll / serverPositionTransitionTicker);
				--serverPositionTransitionTicker;
				setPosition(x, y, z);
				setRotation(rotationYaw, rotationPitch, rotationRoll);
				//return;
			}
			//If the driveable is at its server position and does not have the next update, it should just simulate itself as a server side driveable would, so continue
		}
		
		//Movement

		Vector3f amountToMoveCar = new Vector3f();
		
		for(EntityWheel wheel : wheels){
			if(wheel != null && world != null){
				wheel.prevPosX = wheel.posX;
				wheel.prevPosY = wheel.posY;
				wheel.prevPosZ = wheel.prevPosZ;
			}
		}
		
		for(EntityWheel wheel : wheels){
			if(wheel == null){
				continue;
			}
			
			//Hacky way of forcing the car to step up blocks
			onGround = true;
			wheel.onGround = true;
			
			//Update angles
			wheel.rotationYaw = axes.getYaw();
			//Front wheels
			if(!data.hasTracks() && (wheel.ID == 2 || wheel.ID == 3))
			{
				wheel.rotationYaw += wheelsYaw;
			}
			
			wheel.motionX *= 0.9F;
			wheel.motionY *= 0.9F;
			wheel.motionZ *= 0.9F;
			
			//Apply gravity
			wheel.motionY -= 0.98F / 20F;
			
			//Apply velocity
			//If the player driving this is in creative, then we can thrust, no matter what
			boolean canThrustCreatively = !Config.vehiclesNeedFuel || (seats != null && seats[0] != null && seats[0].getControllingPassenger() instanceof EntityPlayer && ((EntityPlayer)seats[0].getControllingPassenger()).capabilities.isCreativeMode);
			//Otherwise, check the fuel tanks!
			if(canThrustCreatively || data.fuelStored > data.getPart("engine").fuelConsumption * throttle){
				float velocityScale;
				if(data.hasTracks()){
					boolean left = wheel.ID == 0 || wheel.ID == 3;
					
					float turningDrag = 0.02F;
					wheel.motionX *= 1F - (Math.abs(wheelsYaw) * turningDrag);
					wheel.motionZ *= 1F - (Math.abs(wheelsYaw) * turningDrag);
					
					velocityScale = 0.04F * (throttle > 0 ? data.maxThrottle : data.maxNegativeThrottle) * data.getPart("engine").engineSpeed;
					float steeringScale = 0.1F * (wheelsYaw > 0 ? data.turnLeftModifier : data.turnRightModifier);
					float effectiveWheelSpeed = (throttle + (wheelsYaw * (left ? 1 : -1) * steeringScale)) * velocityScale;
					wheel.motionX += effectiveWheelSpeed * Math.cos(wheel.rotationYaw * 3.14159265F / 180F);
					wheel.motionZ += effectiveWheelSpeed * Math.sin(wheel.rotationYaw * 3.14159265F / 180F);
				}
				else if(data.is4WD()){
					velocityScale = 0.1F * throttle * (throttle > 0 ? data.maxThrottle : data.maxNegativeThrottle) * data.getPart("engine").engineSpeed;
					wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
					wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
					
					velocityScale = 0.01F * (wheelsYaw > 0 ? data.turnLeftModifier : data.turnRightModifier) * (throttle > 0 ? 1 : -1);
					if(wheel.ID == 2 || wheel.ID == 3){
						wheel.motionX -= wheel.getSpeedXZ() * Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
						wheel.motionZ += wheel.getSpeedXZ() * Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
					}
					else{
						wheel.motionX *= 0.9F;
						wheel.motionZ *= 0.9F;
					}
				}
				else if(data.isFWD()){
					if(wheel.ID == 2 || wheel.ID == 3){
						velocityScale = 0.1F * throttle * (throttle > 0 ? data.maxThrottle : data.maxNegativeThrottle) * data.getPart("engine").engineSpeed;
						wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
						wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
						velocityScale = 0.01F * (wheelsYaw > 0 ? data.turnLeftModifier : data.turnRightModifier) * (throttle > 0 ? 1 : -1);
						wheel.motionX -= wheel.getSpeedXZ() * Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
						wheel.motionZ += wheel.getSpeedXZ() * Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
					}
					else{
						wheel.motionX *= 0.9F;
						wheel.motionZ *= 0.9F;
					}
				}
				else if(data.isRWD()){
					if(wheel.ID == 0 || wheel.ID == 1){
						velocityScale = 0.1F * throttle * (throttle > 0 ? data.maxThrottle : data.maxNegativeThrottle) * data.getPart("engine").engineSpeed;
						wheel.motionX += Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
						wheel.motionZ += Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale;
					}
					
					if(wheel.ID == 2 || wheel.ID == 3){
						velocityScale = 0.01F * ((wheelsYaw > 0 ? data.turnLeftModifier : data.turnRightModifier) * 16) * (throttle > 0 ? 1 : -1);
						wheel.motionX = wheels[wheel.ID - 2].motionX;
						wheel.motionZ = wheels[wheel.ID - 2].motionZ;
						wheel.motionX -= wheel.getSpeedXZ() * Math.sin(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;
						wheel.motionZ += wheel.getSpeedXZ() * Math.cos(wheel.rotationYaw * 3.14159265F / 180F) * velocityScale * wheelsYaw;

						wheels[wheel.ID - 2].motionX *= 0.9F;
						wheels[wheel.ID - 2].motionZ *= 0.9F;
					}
					//This is surely wrong.
				}
				else{
					//
				}
			}
			
			/*if(data.floatOnWater && world.containsAnyLiquid(wheel.getEntityBoundingBox()))//.isAnyLiquid(wheel.getEntityBoundingBox())){
				wheel.motionY += data.buoyancy;
			}*/
			
			//UtilGui.byId(6, "Fuel: " + data.fuelStored);
			//UtilGui.byId(wheel.ID + 1, "Wheel Movement Call; " + wheel.motionX + ", " + wheel.motionY + ", " + wheel.motionZ);
			wheel.move(MoverType.SELF, wheel.motionX, wheel.motionY, wheel.motionZ);
			
			//Pull wheels towards car
			Pos pos = data.wheelPos[wheel.ID];
			Vector3f targetWheelPos = axes.findLocalVectorGlobally(new Vector3f(pos.to16FloatX(), pos.to16FloatY(), pos.to16FloatZ()));
			Vector3f currentWheelPos = new Vector3f(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
				
			Vector3f dPos = ((Vector3f)Vector3f.sub(targetWheelPos, currentWheelPos, null).scale(data.wheelSpringStrength));
					
			if(dPos.length() > 0.001F){
				wheel.move(MoverType.SELF, dPos.x, dPos.y, dPos.z);
				dPos.scale(0.5F);
				Vector3f.sub(amountToMoveCar, dPos, amountToMoveCar);
			}
			//UtilGui.byId(7 + wheel.ID, "Wheel Movement Call; " + wheel.motionX + ", " + wheel.motionY + ", " + wheel.motionZ);
			//UtilGui.byId(7 + wheel.ID, "Vehicle Movement Call; " + amountToMoveCar.toString());
		}
		
		//UtilGui.byId(0, "Vehicle Movement Call; " + amountToMoveCar.toString());
		move(MoverType.SELF, amountToMoveCar.x, amountToMoveCar.y, amountToMoveCar.z);
		//UtilGui.byId(5, "Throttle: " + throttle);
		
		if(wheels[0] != null && wheels[1] != null && wheels[2] != null && wheels[3] != null){
			Vector3f frontAxleCentre = new Vector3f((wheels[2].posX + wheels[3].posX) / 2F, (wheels[2].posY + wheels[3].posY) / 2F, (wheels[2].posZ + wheels[3].posZ) / 2F); 
			Vector3f backAxleCentre = new Vector3f((wheels[0].posX + wheels[1].posX) / 2F, (wheels[0].posY + wheels[1].posY) / 2F, (wheels[0].posZ + wheels[1].posZ) / 2F); 
			Vector3f leftSideCentre = new Vector3f((wheels[0].posX + wheels[3].posX) / 2F, (wheels[0].posY + wheels[3].posY) / 2F, (wheels[0].posZ + wheels[3].posZ) / 2F); 
			Vector3f rightSideCentre = new Vector3f((wheels[1].posX + wheels[2].posX) / 2F, (wheels[1].posY + wheels[2].posY) / 2F, (wheels[1].posZ + wheels[2].posZ) / 2F); 
			
			float dx = frontAxleCentre.x - backAxleCentre.x;
			float dy = frontAxleCentre.y - backAxleCentre.y;
			float dz = frontAxleCentre.z - backAxleCentre.z;
			float drx = leftSideCentre.x - rightSideCentre.x;
			float dry = leftSideCentre.y - rightSideCentre.y;
			float drz = leftSideCentre.z - rightSideCentre.z;
			
			
			float dxz = (float)Math.sqrt(dx * dx + dz * dz);
			float drxz = (float)Math.sqrt(drx * drx + drz * drz);
			
			float yaw = (float)Math.atan2(dz, dx);
			float pitch = -(float)Math.atan2(dy, dxz);
			float roll = 0F;
			roll = -(float)Math.atan2(dry, drxz);
			
			if(data.hasTracks()){
				yaw = (float)Math.atan2(wheels[3].posZ - wheels[2].posZ, wheels[3].posX - wheels[2].posX) + (float)Math.PI / 2F;
			}
			
			axes.setAngles(yaw * 180F / 3.14159F, pitch * 180F / 3.14159F, roll * 180F / 3.14159F);
		}
		
		checkForCollisions();

		//Sounds
		//Starting sound
		/*if (throttle > 0.01F && throttle < 0.2F && soundPosition == 0 && hasEnoughFuel())
		{
			//PacketPlaySound.sendSoundPacket(posX, posY, posZ, 50, dimension, type.startSound, false);
			soundPosition = data.startSoundLength;
		}
		//Flying sound
		if (throttle > 0.2F && soundPosition == 0 && hasEnoughFuel())
		{
			//PacketPlaySound.sendSoundPacket(posX, posY, posZ, 50, dimension, type.engineSound, false);
			soundPosition = data.engineSoundLength;
		}*/
		
		for(EntitySeat seat : seats){
			if(seat != null){
				seat.updatePosition();
			}
		}
		
		//Calculate movement on the client and then send position, rotation etc to the server
		if(thePlayerIsDrivingThis){
			FlansMod.getNewPacketHandler().sendToServer(new PacketVehicleControl(this));
			serverPosX = posX;
			serverPosY = posY;
			serverPosZ = posZ;
			serverYaw = axes.getYaw();
		}
		
		//If this is the server, send position updates to everyone, having received them from the driver
		if(!world.isRemote && ticksExisted % 5 == 0){
			FlansMod.getNewPacketHandler().sendToAllAround(new PacketVehicleControl(this), new TargetPoint(dimension, posX, posY, posZ, Config.driveableUpdateRange));
		}
		
		//Behavior Scripts
		data.scripts.onUpdate(this);
	}
	
	private float averageAngles(float a, float b){
		Util.log("Pre  " + a + " " + b);

		float pi = (float)Math.PI;
		for(; a > b + pi; a -= 2 * pi) ;
		for(; a < b - pi; a += 2 * pi) ;

		float avg = (a + b) / 2F;

		for(; avg > pi; avg -= 2 * pi) ;
		for(; avg < -pi; avg += 2 * pi) ;

		Util.log("Post " + a + " " + b + " " + avg);

		return avg;
	}

	private Vec3d subtract(Vec3d a, Vec3d b){
		return new Vec3d(a.xCoord - b.xCoord, a.yCoord - b.yCoord, a.zCoord - b.zCoord);
	}
	
	private Vec3d crossProduct(Vec3d a, Vec3d b){
        return new Vec3d(a.yCoord * b.zCoord - a.zCoord * b.yCoord, a.zCoord * b.xCoord - a.xCoord * b.zCoord, a.xCoord * b.yCoord - a.yCoord * b.xCoord);
	}

	public boolean landVehicle(){
		return true;
	}

	public boolean attackEntityFrom(DamageSource damagesource, float i){
		if(world.isRemote || isDead){
			return true;
		}
		if(damagesource.damageType.equals("player") && damagesource.getEntity().onGround && (seats[0] == null || seats[0].getControllingPassenger() == null)){
			if(data.isLocked){
				Print.chat(damagesource.getEntity(), "Vehicle is locked. Unlock to remove it.");
				return false;
			}
			else{
				PlayerPerms pp = PermManager.getPlayerPerms((EntityPlayer)damagesource.getEntity());
				ItemStack stack = new ItemStack(VehicleItem.defaultItem(), 1, 0);
				stack.setTagCompound(data.write(new NBTTagCompound()));
				if(pp.hasPermission(FvmPerms.LAND_VEHICLE_BREAK) || pp.hasPermission(FvmPerms.permBreak(stack))){
					entityDropItem(stack, 0.5F);
			 		setDead();
			 		Print.debug(stack.toString());
			 		return true;
				}
				else{
					Print.chat(damagesource.getEntity(), "No permission to break this vehicle/type.");
			 		Print.debug(stack.toString());
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isLocked(){
		return data.isLocked;
	}

	@Override
	public boolean unlock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
		if(!stack.hasTagCompound()){
			Print.chat(entity, "[ERROR] Key don't has a NBT Tag Compound!");
			return false;
		}
		else{
			switch(item.getType(stack)){
				case PRIVATE:
					if(entity.getGameProfile().getId().toString().equals(item.getCreator(stack).toString())){
						Print.chat(entity, "This key can only be used by the Owner;");
						return false;
					}
					else{
						if(item.getCode(stack).equals(data.lock_code)){
							data.isLocked = false;
							Print.chat(entity, "Vehicle is now unlocked.");
							return true;
						}
						else{
							Print.chat(entity, "Wrong key.\n[V:" + data.lock_code.toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
							return false;
						}
					}
				case COMMON:
					if(item.getCode(stack).equals(data.lock_code)){
						data.isLocked = false;
						Print.chat(entity, "Vehicle is now unlocked.");
						return true;
					}
					else{
						Print.chat(entity, "Wrong key.\n[V:" + data.lock_code.toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
						return false;
					}
				case ADMIN:
					data.isLocked = false;
					Print.chat(entity, "[SU] Vehicle is now unlocked.");
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean lock(World world, EntityPlayer entity, ItemStack stack, KeyItem item) {
		if(!data.hasLock){
			Print.chat(entity, "This vehicle doesn't allow locking.");
			return false;
		}
		else{
			if(!stack.hasTagCompound()){
				Print.chat(entity, "[ERROR] Key don't has a NBT Tag Compound!");
				return false;
			}
			else{
				switch(item.getType(stack)){
					case PRIVATE:
						if(entity.getGameProfile().getId().toString().equals(item.getCreator(stack).toString())){
							Print.chat(entity, "This key can only be used by the Owner;");
							return false;
						}
						else{
							if(item.getCode(stack).equals(data.lock_code)){
								data.isLocked = true;
								Print.chat(entity, "Vehicle is now locked.");
								return true;
							}
							else{
								Print.chat(entity, "Wrong key.\n[V:" + data.lock_code.toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
								return false;
							}
						}
					case COMMON:
						if(item.getCode(stack).equals(data.lock_code)){
							data.isLocked = true;
							Print.chat(entity, "Vehicle is now locked.");
							return true;
						}
						else{
							Print.chat(entity, "Wrong key.\n[V:" + data.lock_code.toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
							return false;
						}
					case ADMIN:
						data.isLocked = true;
						Print.chat(entity, "[SU] Vehicle is now locked.");
						return true;
				}
			}
		}
		return false;
	}
		
	public void checkForCollisions(){
		/*boolean crashInWater = false;
		double speed = getSpeedXYZ();
		for(DriveablePosition p : this.getCollisionPoints()){
			if(data.parts.get(p.part).dead){
				continue;
			}
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
			
		}*/
	}
	
	private List<DriveablePosition> getCollisionPoints(){
		//TODO convert from data-pos
		return new ArrayList<DriveablePosition>();
	}

	@Override
    public void fall(float distance, float damageMultiplier){
        if (distance <= 0) 
        	return;
        //super.fall(k);
        int i = MathHelper.ceil(distance - 10F);

        if(i > 0){
        	//attackPart(EnumDriveablePart.core, DamageSource.FALL, damageMultiplier * i / 5);
        }
    }
		
	/** Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates */
	public Vector3f rotate(Vector3f inVec)
	{
		return axes.findLocalVectorGlobally(inVec);
	}
		
	/** Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates */
	public Vector3f rotate(Vec3d inVec){
		return rotate(inVec.xCoord, inVec.yCoord, inVec.zCoord);
	}

	/** Takes a vector (such as the origin of a seat / gun) and translates it from local coordinates to global coordinates */
	public Vector3f rotate(double x, double y, double z){	
		return rotate(new Vector3f((float)x, (float)y, (float)z));
	}
	
	//Rotate the plane locally by some angle about the yaw axis
	public void rotateYaw(float rotateBy){
		if(Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalYaw(rotateBy);
		updatePrevAngles();
	}
	
	//Rotate the plane locally by some angle about the pitch axis
	public void rotatePitch(float rotateBy){
		if(Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalPitch(rotateBy);
		updatePrevAngles();
	}
	
	//Rotate the plane locally by some angle about the roll axis
	public void rotateRoll(float rotateBy){
		if(Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateLocalRoll(rotateBy);
		updatePrevAngles();
	}
		
	public void updatePrevAngles(){		
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
	public boolean isPartOfThis(Entity ent){
		for(EntitySeat seat : seats){
			if(seat == null){
				continue;
			}
			if(ent == seat){
				return true;
			}
			if(seats[0].getControllingPassenger() == ent){
				return true;
			}
		}
		return ent == this;	
	}
	
	@Override
	public Entity getControllingEntity(){
		return seats[0].getControllingEntity();
	}
	
	@Override
	public ItemStack getPickedResult(RayTraceResult target){
		ItemStack stack = data.newStack();
		stack.setItemDamage(0);
		stack.setTagCompound(data.write(new NBTTagCompound()));
		return stack;
	}
	

	public boolean hasFuel(){
		if(seats == null || seats[0] == null || seats[0].getControllingPassenger() == null){
			return false;
		}
		return driverIsCreative() || data.fuelStored > 0;
	}

	public boolean hasEnoughFuel(){
		if(seats == null || seats[0] == null || seats[0].getControllingPassenger() == null){
			return false;
		}
		return driverIsCreative() || data.fuelStored > data.getPart("engine").fuelConsumption * throttle;
	}
	
	//Physics time! Oooh yeah
	
	public double getSpeedXYZ(){
		return Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
	}
	
	public double getSpeedXZ(){
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}
	
	/** Overriden by planes for wheel parts */
	public boolean gearDown(){
		return true;
	}
	
	/** Whether or not the plane is on the ground 
	 * TODO : Replace with proper check based on wheels
	 * */
	public boolean onGround()
	{
		return onGround;
	}
	
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
		return data.cameraDistance;
	}
	
	public boolean hasMouseControlMode(){
		return false;
	}
	
	@Override
	public String getName(){
		return data.registryname;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean showInventory(int seat){
		return seat != 0 || !FlansModClient.controlModeMouse;
	}

	@Override
	public void onMouseMoved(int deltaX, int deltaY){
		//
	}

	@Override
	public boolean isDead(){
		return isDead;
	}

	@Override
	public EntityLivingBase getCamera(){
		if(Static.side().isClient()){
			return null;
		}
		return camera;
	}

	public VehicleType getData(){
		return data;
	}

	public Seat getSeatInfo(int id){
		Pos s = data.seats.get(id).pos;
		return new Seat(id, s.x, s.y, s.z);
	}
	
}