package com.flansmod.common.network.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketEmpty implements IPacket, IMessage{
	
	public PacketEmpty(){}

	@Override
	public void toBytes(ByteBuf buf){
		Print.spam(1, "Writing Empty Packet!");
	}

	@Override
	public void fromBytes(ByteBuf buf){
		Print.spam(1, "Reading Empty Packet!");
	}
	
}