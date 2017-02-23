package com.flansmod.fvm;

import java.util.List;
import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.flansmod.api.IControllable;
import com.flansmod.client.FlansModClient;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.items.ItemKey;
import com.flansmod.common.network.packets.PacketDriveableKey;
import com.flansmod.common.network.packets.PacketDriveableKeyHeld;
import com.flansmod.common.network.packets.PacketSeatDismount;
import com.flansmod.common.util.Config;
import com.flansmod.common.vector.Vector3f;
import com.flansmod.fvm.packets.FvmPacketSeatUpdate;
import com.google.common.collect.Lists;

public class EntitySeat extends Entity implements IControllable, IEntityAdditionalSpawnData
{
	/** Set this to true when the client has found the parent vehicle and connected them */
	@SideOnly(Side.CLIENT)
	public boolean foundvehicle;
	private int vehicleID;
	private int seatID;
	public LandVehicle vehicle;
	
	public float playerRoll, prevPlayerRoll;
	
	public Seat seatInfo;
	public boolean driver;
	public RotatedAxes playerLooking;
	public RotatedAxes prevPlayerLooking;
	/** A set of axes used to calculate where the player is looking, x axis is the direction of looking, y is up */
	public RotatedAxes looking;
	/** For smooth renderering */
	public RotatedAxes prevLooking;
	/** Delay ticker for shooting guns */
	public float gunDelay;
	
	/** Sound delay ticker for looping sounds */
	public int soundDelay;
	public int yawSoundDelay = 0;
	public int pitchSoundDelay = 0;
	
	public boolean playYawSound = false;
	public boolean playPitchSound = false;
	
	
	private double playerPosX, playerPosY, playerPosZ;
	private float playerYaw, playerPitch;
	/** For smoothness */
	private double prevPlayerPosX, prevPlayerPosY, prevPlayerPosZ;
	private float prevPlayerYaw, prevPlayerPitch;
    private Entity passenger;
	
	
	/** Default constructor for spawning client side 
	 * Should not be called server side EVER */
	public EntitySeat(World world) {
		super(world);
		setSize(1F, 1F);
		prevLooking = new RotatedAxes();
		looking = new RotatedAxes();
		playerLooking = new RotatedAxes();
		prevPlayerLooking = new RotatedAxes();
        this.passenger = null;
	}
		
	/** Server side seat constructor */
	public EntitySeat(World world, LandVehicle d, int id) {
		this(world);
		vehicle = d;
		vehicleID = d.getEntityId();
		seatInfo = vehicle.getSeatInfo(id);
		driver = id == 0;
		setPosition(d.posX, d.posY, d.posZ);
		playerPosX = prevPlayerPosX = posX;
		playerPosY = prevPlayerPosY = posY;
		playerPosZ = prevPlayerPosZ = posZ;
		looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
		prevLooking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
        this.passenger = null;
		//updatePosition();
	}

	@Override
	public void writeSpawnData(ByteBuf data){
		data.writeInt(vehicleID);
		data.writeInt(seatInfo.id);
	}

	@Override
	public void readSpawnData(ByteBuf data){
		vehicleID = data.readInt();
		if(world.getEntityByID(vehicleID) instanceof LandVehicle){
			vehicle = (LandVehicle)world.getEntityByID(vehicleID);
		}
		seatID = data.readInt();
		driver = seatID == 0;
		if(vehicle != null){
			seatInfo = vehicle.getSeatInfo(seatID);
			Print.debug(seatInfo.x + " " + seatInfo.y + " " + seatInfo.z);
			looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
			playerPosX = prevPlayerPosX = posX = vehicle.posX;
			playerPosY = prevPlayerPosY = posY = vehicle.posY;
			playerPosZ = prevPlayerPosZ = posZ = vehicle.posZ;
			setPosition(posX, posY, posZ);
		}
		
	}
	
	@Override
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int partialticks, boolean b){
		super.setPositionAndRotationDirect(x, y, z, yaw, pitch, partialticks, b);//TODO check
	}
	
	@Override
	public void onUpdate(){
		super.onUpdate();
		//prevPosX = posX;
		//prevPosY = posY;
		//prevPosZ = posZ;
		
		
		//If on the client and the vehicle parent has yet to be found, search for it
		if(world.isRemote && !foundvehicle){
			vehicle = (LandVehicle)world.getEntityByID(vehicleID);
			if(vehicle == null){
				return;
			}
			foundvehicle = true;
			vehicle.seats[seatID] = this;
			seatInfo = vehicle.getSeatInfo(seatID);
			Print.debug(seatInfo.x + " " + seatInfo.y + " " + seatInfo.z);
			looking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
			prevLooking.setAngles((seatInfo.minYaw + seatInfo.maxYaw) / 2, 0F, 0F);
			playerPosX = prevPlayerPosX = posX = vehicle.posX;
			playerPosY = prevPlayerPosY = posY = vehicle.posY;
			playerPosZ = prevPlayerPosZ = posZ = vehicle.posZ;
			//setPosition(posX, posY, posZ);
		}		
		//Update gun delay ticker
		if(gunDelay > 0){
			gunDelay--;
		}
		//Update sound delay ticker
		if(soundDelay > 0){
			soundDelay--;
		}
		if(yawSoundDelay > 0){
			yawSoundDelay--;
		}
		if(pitchSoundDelay > 0){
			pitchSoundDelay--;
		}
		
		//updatePosition();
		
		if (playYawSound == true && yawSoundDelay == 0 && seatInfo.traverseSounds == true){
			//PacketPlaySound.sendSoundPacket(posX, posY, posZ, 50, dimension, seatInfo.yawSound, false);
			yawSoundDelay = seatInfo.yawSoundLength;
		}
		
		if (playPitchSound == true && pitchSoundDelay == 0 && seatInfo.traverseSounds == true){
			//PacketPlaySound.sendSoundPacket(posX, posY, posZ, 50, dimension, seatInfo.pitchSound, false);
			pitchSoundDelay = seatInfo.pitchSoundLength;
		}
		
		boolean isThePlayer = this.getControllingPassenger() instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)this.getControllingPassenger());
		
		//Reset traverse sounds if player exits the vehicle
		
		if(isThePlayer){
			playYawSound = false;
			playPitchSound = false;
			yawSoundDelay = 0;
			pitchSoundDelay = 0;
		}
		
		//If on the client
		if(world.isRemote){
			if(driver && isThePlayer && FlansMod.proxy.mouseControlEnabled() && vehicle.hasMouseControlMode()){
				looking = new RotatedAxes();
				playerLooking = new RotatedAxes();
			}
		}

		if(this.getControllingPassenger() instanceof EntityPlayer){
			pressKey(9, (EntityPlayer)this.getControllingPassenger());
		}
		
		//prevLooking = looking.clone();
	}
	
	/** Set the position to be that of the vehicle plus the local position, rotated */
	public void updatePosition(){
		
		//If we haven't found our vehicle, give up
		if(world.isRemote && !foundvehicle){
			return;
		}
		
		prevPlayerPosX = playerPosX;
		prevPlayerPosY = playerPosY;
		prevPlayerPosZ = playerPosZ;
		
		prevPlayerYaw = playerYaw;
		prevPlayerPitch = playerPitch;
		prevPlayerRoll = playerRoll;

		//Get the position of this seat on the vehicle axes
		Vector3f localPosition = new Vector3f(seatInfo.x / 16F, seatInfo.y / 16F, seatInfo.z / 16F);
		
		//Rotate the offset vector by the turret yaw
		if(vehicle != null && vehicle.seats != null && vehicle.seats[0] != null && vehicle.seats[0].looking != null){
			RotatedAxes yawOnlyLooking = new RotatedAxes(vehicle.seats[0].looking.getYaw(), 0F, 0F);
			Vector3f rotatedOffset = yawOnlyLooking.findLocalVectorGlobally(seatInfo.rotatedOffset);
			Vector3f.add(localPosition, new Vector3f(rotatedOffset.x, 0F, rotatedOffset.z), localPosition);
		}
		
		//If this seat is connected to the turret, then its position vector on the vehicle axes needs an extra rotation in it
		//if(vehicle.rotateWithTurret(seatInfo) && vehicle.seats[0] != null)
			//localPosition = vehicle.seats[0].looking.findLocalVectorGlobally(localPosition);
		//Get the position of this seat globally, but positionally relative to the vehicle
		Vector3f relativePosition = vehicle.axes.findLocalVectorGlobally(localPosition);
		//Set the absol
		setPosition(vehicle.posX + relativePosition.x, vehicle.posY + relativePosition.y, vehicle.posZ + relativePosition.z);
		
		if(this.getControllingPassenger() != null){
	    	//vehicleType type = vehicle.getvehicleType();
			Vec3d yOffset = vehicle.axes.findLocalVectorGlobally(new Vector3f(0, this.getControllingPassenger().getEyeHeight() * 3 / 4, 0)).toVec3().subtract(0, this.getControllingPassenger().getEyeHeight(), 0);
			//vehicle.rotate(0, this.getControllingPassenger().getYOffset(), 0).toVec3();
			
			playerPosX = posX + yOffset.xCoord;
			playerPosY = posY + yOffset.yCoord;
			playerPosZ = posZ + yOffset.zCoord;
			
			this.updatePassenger();

			//Calculate the local look axes globally
			RotatedAxes globalLookAxes = vehicle.axes.findLocalAxesGlobally(playerLooking);
			//Set the player's rotation based on this
			playerYaw = -90F + globalLookAxes.getYaw();
			playerPitch = globalLookAxes.getPitch();
			
			double dYaw = playerYaw - prevPlayerYaw;
			if(dYaw > 180)
				prevPlayerYaw += 360F;
			if(dYaw < -180)
				prevPlayerYaw -= 360F;
			
			if(this.getControllingPassenger() instanceof EntityPlayer){
				this.getControllingPassenger().prevRotationYaw = prevPlayerYaw;
				this.getControllingPassenger().prevRotationPitch = prevPlayerPitch;
				
				this.getControllingPassenger().rotationYaw = playerYaw;
				this.getControllingPassenger().rotationPitch = playerPitch;
			}
			
			//If the entity is a player, roll its view accordingly
			if(world.isRemote){
				playerRoll = -globalLookAxes.getRoll();
			}
		}
	}
	
	@Override
    public void updatePassenger(Entity passengerr){
		if(passengerr == null){
			return;
		}
		if(passenger instanceof EntityPlayer == false){
			passenger.dismountRidingEntity();
		}
		passenger.rotationYaw = playerYaw;
		passenger.rotationPitch = playerPitch;
		passenger.prevRotationYaw = prevPlayerYaw;
		passenger.prevRotationPitch = prevPlayerPitch;
		passenger.lastTickPosX = passenger.prevPosX = prevPlayerPosX;
		passenger.lastTickPosY = passenger.prevPosY = prevPlayerPosY;
		passenger.lastTickPosZ = passenger.prevPosZ = prevPlayerPosZ;
		
		passenger.setPosition(playerPosX, playerPosY, playerPosZ);
		
		//DEBUG
		/*if(world.isRemote){
			UtilGui.n0 = "PC: " + passenger.getPositionVector().toString();
			UtilGui.n2 = "DC: " + this.vehicle.getPositionVector().toString();
			UtilGui.n4 = "SC: " + this.getPositionVector().toString();
		}
		else{
			UtilGui.n1 = "PS: " + passenger.getPositionVector().toString();
			UtilGui.n3 = "DS: " + this.vehicle.getPositionVector().toString();
			UtilGui.n5 = "SS: " + this.getPositionVector().toString();
		}*/
		
    }
	
	public void updatePassenger(){
		this.updatePassenger(passenger);
	}
		
	@Override
	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera()
	{
		return vehicle.getCamera();
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !isDead;
	}
	
	@Override
	protected void entityInit()
	{
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound tags){
		//
	}
	
	@Override
	public boolean isPassenger(Entity entity){
		return passenger.equals(entity);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tags){
		//
	}
	
	@Override
	public boolean writeToNBTOptional(NBTTagCompound tags)
	{
		return false;
	}
	
	//@Override
	public boolean writeMountToNBT(NBTTagCompound tags)
	{
		return false;
	}

	@Override
	public void onMouseMoved(int deltaX, int deltaY) 
	{
		if(!foundvehicle)
			return;		
		
		prevLooking = looking.clone();
		prevPlayerLooking = playerLooking.clone();
				
		//Driver seat should pass input to vehicle
		if(driver)
		{
			vehicle.onMouseMoved(deltaX, deltaY);
		}
		//Other seats should look around, but also the driver seat if mouse control mode is disabled
		if(!driver || !FlansModClient.controlModeMouse || !vehicle.hasMouseControlMode())
		{
			float lookSpeed = 4F;
			
			
			
			//Angle stuff for the player
			
			//Calculate the new pitch and consider pitch limiters
			float newPlayerPitch = playerLooking.getPitch() - deltaY / lookSpeed * Minecraft.getMinecraft().gameSettings.mouseSensitivity;
			if(newPlayerPitch > -seatInfo.minPitch)
				newPlayerPitch = -seatInfo.minPitch;
			if(newPlayerPitch < -seatInfo.maxPitch)
				newPlayerPitch = -seatInfo.maxPitch;
			
			//Calculate new yaw and consider yaw limiters
			float newPlayerYaw = playerLooking.getYaw() + deltaX / lookSpeed * Minecraft.getMinecraft().gameSettings.mouseSensitivity;
			//Since the yaw limiters go from -360 to 360, we need to find a pair of yaw values and check them both
			float otherNewPlayerYaw = newPlayerYaw - 360F; 
			if(newPlayerYaw < 0)
				otherNewPlayerYaw = newPlayerYaw + 360F;
			if((newPlayerYaw >= seatInfo.minYaw && newPlayerYaw <= seatInfo.maxYaw) || (otherNewPlayerYaw >= seatInfo.minYaw && otherNewPlayerYaw <= seatInfo.maxYaw))
			{
				//All is well
			}
			else
			{
				float newPlayerYawDistFromRange = Math.min(Math.abs(newPlayerYaw - seatInfo.minYaw), Math.abs(newPlayerYaw - seatInfo.maxYaw));
				float otherPlayerNewYawDistFromRange = Math.min(Math.abs(otherNewPlayerYaw - seatInfo.minYaw), Math.abs(otherNewPlayerYaw - seatInfo.maxYaw));
				//If the newYaw is closer to the range than the otherNewYaw, move newYaw into the range
				if(newPlayerYawDistFromRange <= otherPlayerNewYawDistFromRange)
				{
					if(newPlayerYaw > seatInfo.maxYaw)
						newPlayerYaw = seatInfo.maxYaw;
					if(newPlayerYaw < seatInfo.minYaw)
						newPlayerYaw = seatInfo.minYaw;
				}
				//Else, the otherNewYaw is closer, so move it in
				else
				{
					if(otherNewPlayerYaw > seatInfo.maxYaw)
						otherNewPlayerYaw = seatInfo.maxYaw;
					if(otherNewPlayerYaw < seatInfo.minYaw)
						otherNewPlayerYaw = seatInfo.minYaw;
					//Then match up the newYaw with the otherNewYaw
					if(newPlayerYaw < 0)
						newPlayerYaw = otherNewPlayerYaw - 360F;
					else newPlayerYaw = otherNewPlayerYaw + 360F;
				}
			}
			//Now set the new angles
			playerLooking.setAngles(newPlayerYaw, newPlayerPitch, 0F);
			
			
			//Move the seat accordingly
			
			
			//Consider new Yaw and Yaw limiters
			

			float targetX = playerLooking.getYaw();
			
			float yawToMove = (targetX - looking.getYaw());
			for(; yawToMove > 180F; yawToMove -= 360F) {}
			for(; yawToMove <= -180F; yawToMove += 360F) {}
			
			float signDeltaX = 0;
			if(yawToMove > (seatInfo.aimingSpeed.x/2) && seatInfo.legacyAiming == false){
				signDeltaX = 1;
			} else if(yawToMove < -(seatInfo.aimingSpeed.x/2) && seatInfo.legacyAiming == false){
				signDeltaX = -1;
			} else{
				signDeltaX = 0;
			}

			//Calculate new yaw and consider yaw limiters
			float newYaw = 0f;
			
			if(seatInfo.legacyAiming == true || (signDeltaX == 0 && deltaX == 0)){
				newYaw = playerLooking.getYaw();
			} else {
				newYaw = looking.getYaw() + signDeltaX*seatInfo.aimingSpeed.x;
			}
			//Since the yaw limiters go from -360 to 360, we need to find a pair of yaw values and check them both
			float otherNewYaw = newYaw - 360F; 
			if(newYaw < 0)
				otherNewYaw = newYaw + 360F;
			if((newYaw >= seatInfo.minYaw && newYaw <= seatInfo.maxYaw) || (otherNewYaw >= seatInfo.minYaw && otherNewYaw <= seatInfo.maxYaw))
			{
				//All is well
			}
			else
			{
				float newYawDistFromRange = Math.min(Math.abs(newYaw - seatInfo.minYaw), Math.abs(newYaw - seatInfo.maxYaw));
				float otherNewYawDistFromRange = Math.min(Math.abs(otherNewYaw - seatInfo.minYaw), Math.abs(otherNewYaw - seatInfo.maxYaw));
				//If the newYaw is closer to the range than the otherNewYaw, move newYaw into the range
				if(newYawDistFromRange <= otherNewYawDistFromRange)
				{
					if(newYaw > seatInfo.maxYaw)
						newYaw = seatInfo.maxYaw;
					if(newYaw < seatInfo.minYaw)
						newYaw = seatInfo.minYaw;
				}
				//Else, the otherNewYaw is closer, so move it in
				else
				{
					if(otherNewYaw > seatInfo.maxYaw)
						otherNewYaw = seatInfo.maxYaw;
					if(otherNewYaw < seatInfo.minYaw)
						otherNewYaw = seatInfo.minYaw;
					//Then match up the newYaw with the otherNewYaw
					if(newYaw < 0)
						newYaw = otherNewYaw - 360F;
					else newYaw = otherNewYaw + 360F;
				}
			}
			
			//Calculate the new pitch and consider pitch limiters
			float targetY = playerLooking.getPitch();
			
			float pitchToMove = (targetY - looking.getPitch());
			for(; pitchToMove > 180F; pitchToMove -= 360F) {}
			for(; pitchToMove <= -180F; pitchToMove += 360F) {}
			
			float signDeltaY = 0;
			if(pitchToMove > (seatInfo.aimingSpeed.y/2) && seatInfo.legacyAiming == false){
				signDeltaY = 1;
			} else if(pitchToMove < -(seatInfo.aimingSpeed.y/2) && seatInfo.legacyAiming == false){
				signDeltaY = -1;
			} else {
				signDeltaY = 0;
			} 

			float newPitch = 0f;
			
			
			//Pitches the gun at the last possible moment in order to reach target pitch at the same time as target yaw.
			float minYawToMove = 0f;
			
			float currentYawToMove = 0f;
			
			if(seatInfo.latePitch){
			minYawToMove = ((float)Math.sqrt((pitchToMove / seatInfo.aimingSpeed.y)*(pitchToMove / seatInfo.aimingSpeed.y)))*seatInfo.aimingSpeed.x;
			} else {
			minYawToMove = 360f;
			}
			
			currentYawToMove = (float)Math.sqrt((yawToMove)*(yawToMove));
			
			if(seatInfo.legacyAiming == true || (signDeltaY == 0 && deltaY == 0)){
				newPitch = playerLooking.getPitch();
			} else  if (seatInfo.yawBeforePitch == false && currentYawToMove < minYawToMove){
				newPitch = looking.getPitch() + signDeltaY*seatInfo.aimingSpeed.y;
			} else if (seatInfo.yawBeforePitch == true && signDeltaX == 0){
				newPitch = looking.getPitch() + signDeltaY*seatInfo.aimingSpeed.y;
			} else if (seatInfo.yawBeforePitch == true && signDeltaX != 0){
				newPitch = looking.getPitch();
			} else {
				newPitch = looking.getPitch();
			}
			
			if(newPitch > -seatInfo.minPitch)
				newPitch = -seatInfo.minPitch;
			if(newPitch < -seatInfo.maxPitch)
				newPitch = -seatInfo.maxPitch;
			
			//Now set the new angles
			looking.setAngles(newYaw, newPitch, 0F);
			
			FlansMod.getNewPacketHandler().sendToServer(new FvmPacketSeatUpdate(this));
			
			if(signDeltaX != 0 && seatInfo.traverseSounds == true){
				playYawSound = true;
			} else {
				playYawSound = false;
			}
			
			if(signDeltaY != 0 && seatInfo.yawBeforePitch == false && currentYawToMove < minYawToMove){
				playPitchSound = true;
			} else if (signDeltaY != 0 && seatInfo.yawBeforePitch == true && signDeltaX == 0){
				playPitchSound = true;
			} else {
				playPitchSound = false;
			}
		}
	}
	
	@Override
	public void updateKeyHeldState(int key, boolean held)
	{
		if(world.isRemote && foundvehicle)
		{
			FlansMod.getNewPacketHandler().sendToServer(new PacketDriveableKeyHeld(key, held));

		}
		if(driver)
		{
			vehicle.updateKeyHeldState(key, held);
		}
		else if(key == 9)
		{ 
			//shooting = held;
		}
	}

	@Override
	public boolean pressKey(int key, EntityPlayer player) 
	{
		//Driver seat should pass input to vehicle
		if(driver && (!world.isRemote || foundvehicle))
		{
			return vehicle.pressKey(key, player);
		}
		
		if(world.isRemote)
		{
			if(foundvehicle)
			{
				FlansMod.getNewPacketHandler().sendToServer(new PacketDriveableKey(key));
			}
			return false;
		}
		
		//Exit key pressed
		if(key == 6){
			this.getControllingPassenger().dismountRidingEntity();
		}
				
		if(key == 9){
			//Shoot
		}
		return false;
	}
	
	@Override
	public boolean processInitialInteract(EntityPlayer entityplayer, EnumHand hand){
		if(isDead || world.isRemote){
			return false;
		}
		if(hand == EnumHand.OFF_HAND){
			return false;
		}
		//If they are using a repair tool, don't put them in
		ItemStack currentItem = entityplayer.getHeldItem(hand);
		/*if(currentItem != null && currentItem.getItem() instanceof ItemTool && ((ItemTool)currentItem.getItem()).type.healvehicles){
			return true;
		}*/
		if(currentItem != null && currentItem.getItem() instanceof ItemKey){
			return true;
		}
		if(currentItem != null && currentItem.getItem() instanceof ItemLead){
			if(this.getControllingPassenger() != null && this.getControllingPassenger() instanceof EntityLiving && !(this.getControllingPassenger() instanceof EntityPlayer)){
				EntityLiving mob = (EntityLiving)this.getControllingPassenger();
				this.getControllingPassenger().dismountRidingEntity();
				Print.spam(1, "PASSENGER != ENTITYPLAYER >>> DISMOUNTING");
				mob.setLeashedToEntity(entityplayer, true);
				return true;
			}
			double checkRange = 10;
			List nearbyMobs = world.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(posX - checkRange, posY - checkRange, posZ - checkRange, posX + checkRange, posY + checkRange, posZ + checkRange));
			for(Object obj : nearbyMobs){
				EntityLiving entity = (EntityLiving)obj;
				if(entity.getLeashed() && entity.getLeashedToEntity() == entityplayer){
					entity.startRiding(this);
					looking.setAngles(-entity.rotationYaw, entity.rotationPitch, 0F);
					entity.clearLeashed(true, !entityplayer.capabilities.isCreativeMode);
				}
			}
			return true;
		}
		if(this.getControllingPassenger() == null){
			entityplayer.startRiding(this);
			return true;
		}
		return false;
	}
	
	@Override
	public Entity getControllingEntity(){
		return passenger;
	}
	
	@Override
	public Entity getControllingPassenger(){
		return passenger;
	}
	
	@Override
	public List<Entity> getPassengers(){
		List list = Lists.<Entity>newArrayList();
		if(passenger != null){
			list.add(passenger);
		}
		return list;
	}
	
	@Override
	public void addPassenger(Entity passenger){
		if(vehicle.getData().isLocked && this.driver){
			Print.chat(passenger, "Vehicle is locked. Unlock to drive it.");
			passenger.dismountRidingEntity();
			return;
		}
		if(passenger.getRidingEntity() != this){
            throw new IllegalStateException("Use x.startRiding(y), not y.addPassenger(x)");
        }
        else{
        	this.passenger = passenger;
        }
		Print.debug("AP => " + Time.getDate() + " " + (world.isRemote ? "[CLIENT]" : "[SERVER]"));
	}
	
	@Override
	public void removePassenger(Entity entity){
		if(world.isRemote){
			passenger = null;
			Print.debug("RM => " + Time.getDate() + " [CLIENT] OK");
		}
		else{
			FlansMod.getNewPacketHandler().sendToAllAround(new PacketSeatDismount(passenger.getEntityId()), Config.getTargetPoint(this));
			passenger = null;
			Print.debug("RM => " + Time.getDate() + " [SERVER]");
		}
	}

	@Override
	public boolean isDead() {
		return isDead;
	}
	
	@Override
	public void setDead(){
		if(world.isRemote){
			this.isDead = true;
			Print.debug("DD => " + Time.getDate() + " [CLIENT] OK;");
		}
		else{
			this.isDead = true;
			Print.debug("DD => " + Time.getDate() + " [SERVER]");
		}
	}
	
	@Override
	public ItemStack getPickedResult(RayTraceResult target)
	{
		if(world.isRemote && !foundvehicle)
			return null;
		return vehicle.getPickedResult(target);
	}
	
	@Override
	public float getPlayerRoll() 
	{
		return playerRoll;	
	}	
	
	@Override
	public float getPrevPlayerRoll() 
	{
		return prevPlayerRoll;
	}
	
	@Override
	public float getCameraDistance(){
		return foundvehicle && seatID == 0 ? vehicle.getData().cameraDistance : 5F;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float f) {
		return !(world.isRemote && !foundvehicle) && vehicle.attackEntityFrom(source, f);
	}
	
}