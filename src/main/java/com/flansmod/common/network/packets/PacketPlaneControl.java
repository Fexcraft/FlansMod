package com.flansmod.common.network.packets;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketPlaneControl extends PacketDriveableControl implements IPacket, IMessage {
	
	public boolean gear, doors, wings; 
	
	public PacketPlaneControl(){}
	
	public PacketPlaneControl(EntityDriveable driveable){
		super(driveable);
		EntityPlane plane = ((EntityPlane)driveable);
		gear = plane.varGear;
		doors = plane.varDoor;
		wings = plane.varWing;
	}

	@Override
	public void toBytes(ByteBuf buf){
		super.toBytes(buf);
		buf.writeBoolean(gear);
		buf.writeBoolean(doors);
		buf.writeBoolean(wings);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		super.fromBytes(buf);
		gear = buf.readBoolean();
		doors = buf.readBoolean();
		wings = buf.readBoolean();
	}
	
}