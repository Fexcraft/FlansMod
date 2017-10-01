package com.flansmod.common.network.packets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketDriveableKeyHeld implements IPacket, IMessage{
	
	public int key;
	public boolean held;
	
	public PacketDriveableKeyHeld(){}
	
	public PacketDriveableKeyHeld(int key, boolean held){
		this.key = key;
		this.held = held;
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(key);
		buf.writeBoolean(held);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		key = buf.readInt();
		held = buf.readBoolean();
	}
	
}