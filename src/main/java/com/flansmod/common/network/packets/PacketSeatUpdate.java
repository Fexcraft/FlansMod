package com.flansmod.common.network.packets;

import com.flansmod.common.driveables.EntitySeat;
import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketSeatUpdate implements IPacket, IMessage{
	
	public int entityId, seatId;
	public float yaw, pitch;
	
	public PacketSeatUpdate(){}
	
	public PacketSeatUpdate(EntitySeat seat){
		entityId = seat.driveable.getEntityId();
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