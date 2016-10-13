package com.flansmod.common.network.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketDriveableKey implements IPacket, IMessage{
	
	public int key;
	
	public PacketDriveableKey(){}
	
	public PacketDriveableKey(int key){
		this.key = key;
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(key);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		key = buf.readInt();
	}
	
}