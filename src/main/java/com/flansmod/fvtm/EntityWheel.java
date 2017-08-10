package com.flansmod.fvtm;

import com.flansmod.common.vector.Vector3f;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityWheel extends Entity implements IEntityAdditionalSpawnData {
	
	/** The vehicle this wheel is part of */
	public LandVehicle vehicle;
	/** The ID of this wheel within the vehicle */
	public int ID;
	
	/** Set this to true when the client has found the parent vehicle and connected them */
	@SideOnly(Side.CLIENT)
	public boolean foundVehicle;
	/** The ID of the vehicle this wheel is part of, for client-server syncing */
	private int vehicleID;
	
	public EntityWheel(World world){
		super(world);
		setSize(1F, 1F);
		stepHeight = 1.0F;
	}

	public EntityWheel(World world, LandVehicle entity,  int i){
		this(world);
		vehicle = entity;
		vehicleID = entity.getEntityId();
		ID = i;
		
		initPosition();
	}
	
	@Override
	public void writeSpawnData(ByteBuf data){
		data.writeInt(vehicleID);
		data.writeInt(ID);
	}

	@Override
	public void readSpawnData(ByteBuf data){
		vehicleID = data.readInt();
		ID = data.readInt();
		if(world.getEntityByID(vehicleID) instanceof LandVehicle){
			vehicle = (LandVehicle)world.getEntityByID(vehicleID);
		}
		if(vehicle != null){
			setPosition(posX, posY, posZ);
		}
	}
	
	public void initPosition(){
		Pos s = vehicle.getData().getWheelPos().get(ID);
		Vector3f wheelVector = vehicle.axes.findLocalVectorGlobally(new Vector3f(s.to16FloatX(), s.to16FloatY(), s.to16FloatZ()));
		setPosition(vehicle.posX + wheelVector.x, vehicle.posY + wheelVector.y, vehicle.posZ + wheelVector.z);
		stepHeight = vehicle.getData().getVehicle().getFMWheelStepHeight();
		
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
	}
	
	@Override
    public void fall(float k, float l){
		if(vehicle == null || k <= 0) 
			return;
		int i = MathHelper.ceil(k - 3F);
		if(i > 0){
			//vehicle.attackPart(vehicle.getDriveableType().wheelPositions[ID].part, DamageSource.FALL, i);
		}
	}

	@Override
	protected void entityInit(){
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tags){
		setDead();
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tags){
		
	}
	
	@Override
	public void onUpdate(){
		//super.onUpdate();
		
		//prevPosX = posX;
		//prevPosY = posY;
		//prevPosZ = posZ;
		
		//If on the client and the vehicle parent has yet to be found, search for it
		if(world.isRemote && !foundVehicle){
			if(!(world.getEntityByID(vehicleID) instanceof LandVehicle)){
				return;
			}
			vehicle = (LandVehicle)world.getEntityByID(vehicleID);
			foundVehicle = true;
			vehicle.wheels[ID] = this;
		}	
		
		if(vehicle == null){
			return;
		}
		
		if(!addedToChunk){
			world.spawnEntity(this);
		}
		/*
		//Update angles
		rotationYaw = vehicle.rotationYaw;
		//Front wheels
		if(ID == 2 || ID == 3)
		{
			rotationYaw += vehicle.wheelsYaw;
		}
		
		//Apply gravity
		motionY -= 0.98F / 400F;
		
		//Apply velocity
		if(vehicle.getVehicleType().fourWheelDrive || ID == 0 || ID == 1)
		{
			float velocityScale = 0.01F;
			motionX += vehicle.throttle * Math.cos(rotationYaw * 3.14159265F / 180F) * velocityScale;
			motionZ += vehicle.throttle * Math.sin(rotationYaw * 3.14159265F / 180F) * velocityScale;
		}
		
		//Apply steering
		if(ID == 2 || ID == 3)
		{
			float velocityScale = 0.02F;
			motionX -= getSpeedXZ() * Math.sin(rotationYaw * 3.14159265F / 180F) * velocityScale * vehicle.wheelsYaw;
			motionZ += getSpeedXZ() * Math.cos(rotationYaw * 3.14159265F / 180F) * velocityScale * vehicle.wheelsYaw;
		}
		
		motionX *= 0.95F;
		motionY *= 0.95F;
		motionZ *= 0.95F;
		
		moveEntity(motionX, motionY, motionZ);
		
		//Pull wheels towards car
		Vector3f targetWheelPos = vehicle.axes.findLocalVectorGlobally(vehicle.getVehicleType().wheelPositions[ID]);
		Vector3f currentWheelPos = new Vector3f(posX - vehicle.posX, posY - vehicle.posY, posZ - vehicle.posZ);
		
		Vector3f dPos = ((Vector3f)Vector3f.sub(targetWheelPos, currentWheelPos, null).scale(vehicle.getVehicleType().wheelSpringStrength * 5F));
			
		if(dPos.length() > 0.001F)
		{
			moveEntity(dPos.x, dPos.y, dPos.z);
			dPos.scale(0.2F);
			vehicle.moveEntity(-dPos.x, -dPos.y, -dPos.z);
		}
		*/

	}
	
	
	
	public double getSpeedXZ(){
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}
	
	@Override
    public void setPositionAndRotationDirect(double d, double d1, double d2, float f, float f1, int i, boolean b){
		
    }
	
}
