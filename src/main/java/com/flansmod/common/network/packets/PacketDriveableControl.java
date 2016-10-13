package com.flansmod.common.network.packets;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntityVehicle;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketDriveableControl implements IPacket, IMessage{
	
	public int entityId;
	public double posX, posY, posZ;
	public float yaw, pitch, roll;
	public double motX, motY, motZ;
	public float avelx, avely, avelz;
	public float throttle;
	public float fuelInTank;
	public float steeringYaw;
	
	public PacketDriveableControl(){}
	
	public PacketDriveableControl(EntityDriveable driveable){
		entityId = driveable.getEntityId();
		posX = driveable.posX;
		posY = driveable.posY;
		posZ = driveable.posZ;
		yaw = driveable.axes.getYaw();
		pitch = driveable.axes.getPitch();
		roll = driveable.axes.getRoll();
		motX = driveable.motionX;
		motY = driveable.motionY;
		motZ = driveable.motionZ;
		avelx = driveable.angularVelocity.x;
		avely = driveable.angularVelocity.y;
		avelz = driveable.angularVelocity.z;
		throttle = driveable.throttle;
		fuelInTank = driveable.driveableData.fuelInTank;
		if(driveable instanceof EntityVehicle)
		{
			EntityVehicle veh = (EntityVehicle)driveable;
			steeringYaw = veh.wheelsYaw;
		}
		else if(driveable instanceof EntityPlane)
		{
			EntityPlane plane = (EntityPlane)driveable;
			steeringYaw = plane.flapsYaw;
		}
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(entityId);
		buf.writeDouble(posX);
		buf.writeDouble(posY);
		buf.writeDouble(posZ);
		buf.writeFloat(yaw);
		buf.writeFloat(pitch);
		buf.writeFloat(roll);
		buf.writeDouble(motX);
		buf.writeDouble(motY);
		buf.writeDouble(motZ);
		buf.writeFloat(avelx);
		buf.writeFloat(avely);
		buf.writeFloat(avelz);
		buf.writeFloat(throttle);
		buf.writeFloat(fuelInTank);
		buf.writeFloat(steeringYaw);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		entityId = buf.readInt();
		posX = buf.readDouble();
		posY = buf.readDouble();
		posZ = buf.readDouble();
		yaw = buf.readFloat();
		pitch = buf.readFloat();
		roll = buf.readFloat();
		motX = buf.readDouble();
		motY = buf.readDouble();
		motZ = buf.readDouble();
		avelx = buf.readFloat();
		avely = buf.readFloat();
		avelz = buf.readFloat();
		throttle = buf.readFloat();
		fuelInTank = buf.readFloat();
		steeringYaw = buf.readFloat();
	}
	
}