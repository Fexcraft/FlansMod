package com.flansmod.common.network.packets;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityVehicle;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketVehicleControl extends PacketDriveableControl implements IPacket, IMessage{
	
	public boolean doors;
	
	public PacketVehicleControl(){}
	
	public PacketVehicleControl(EntityDriveable driveable){
		super(driveable);
		doors = ((EntityVehicle)driveable).varDoor;
	}

	@Override
	public void toBytes(ByteBuf buf){
		super.toBytes(buf);
		buf.writeBoolean(doors);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		super.fromBytes(buf);
		doors = buf.readBoolean();
	}
	
}