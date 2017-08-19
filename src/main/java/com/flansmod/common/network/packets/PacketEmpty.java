package com.flansmod.common.network.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketEmpty implements IPacket, IMessage{
	
	public PacketEmpty(){
		new Exception().printStackTrace();
		//Static.stop();
		//turns out something keeps sending out empty packets, although I don't recall coding that in.
		//thus let's crash on purpose
	}

	@Override
	public void toBytes(ByteBuf buf){
		new Exception().printStackTrace();
		Print.spam(1, "Writing Empty Packet!");
		Static.stop();
	}

	@Override
	public void fromBytes(ByteBuf buf){
		new Exception().printStackTrace();
		Print.spam(1, "Reading Empty Packet!");
	}
	
}