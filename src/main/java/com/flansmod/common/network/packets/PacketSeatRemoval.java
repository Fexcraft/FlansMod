package com.flansmod.common.network.packets;

import com.flansmod.common.driveables.EntitySeat;
import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketSeatRemoval implements IPacket, IMessage{
	
	public int entityId, seatId;
	
	public PacketSeatRemoval(){}
	
	public PacketSeatRemoval(EntitySeat seat){
		entityId = seat.driveable.getEntityId();
		seatId = seat.seatInfo.id;
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(entityId);
		buf.writeInt(seatId);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		entityId = buf.readInt();
		seatId = buf.readInt();
	}
	
}