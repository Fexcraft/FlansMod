package com.flansmod.fvm.packets;

import com.flansmod.fvm.EntitySeat;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class FvmPacketSeatUpdate implements IPacket, IMessage {
	
	public int entityId, seatId;
	public float yaw, pitch;
	
	public FvmPacketSeatUpdate(){}
	
	public FvmPacketSeatUpdate(EntitySeat seat){
		entityId = seat.vehicle.getEntityId();
		seatId = seat.seatInfo.id;
		yaw = seat.looking.getYaw();
		pitch = seat.looking.getPitch();
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(entityId);
		buf.writeInt(seatId);
		buf.writeFloat(yaw);
		buf.writeFloat(pitch);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		entityId = buf.readInt();
		seatId = buf.readInt();
		yaw = buf.readFloat();
		pitch = buf.readFloat();
	}
	
}