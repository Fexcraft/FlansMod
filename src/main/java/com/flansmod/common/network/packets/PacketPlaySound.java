package com.flansmod.common.network.packets;

import java.nio.charset.StandardCharsets;
import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketPlaySound implements IPacket, IMessage{
	
	public float posX, posY, posZ;
	public String sound;
	public boolean distort, silenced;
	public int entity;
	
	public PacketPlaySound(){}
	
	public PacketPlaySound(int ent, double x, double y, double z, String s){
		this(ent, x, y, z, s, false);
	}

	public PacketPlaySound(int ent, double x, double y, double z, String s, boolean distort){	
		this(ent, x, y, z, s, distort, false);
	}
	
	public PacketPlaySound(int ent, double x, double y, double z, String s, boolean distort, boolean silenced){
		this.entity = ent;
		posX = (float)x; posY = (float)y; posZ = (float)z;
		sound = s == null ? "null" : s;
		this.distort = distort;
		this.silenced = silenced;
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeFloat(posX);
		buf.writeFloat(posY);
		buf.writeFloat(posZ);
		buf.writeBoolean(distort);
		buf.writeBoolean(silenced);
		buf.writeInt(sound.length());
		buf.writeInt(entity);
		buf.writeCharSequence(sound, StandardCharsets.UTF_8);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		this.posX = buf.readFloat();
		this.posY = buf.readFloat();
		this.posZ = buf.readFloat();
		this.distort = buf.readBoolean();
		this.silenced = buf.readBoolean();
		int l = buf.readInt();
		this.entity = buf.readInt();
		this.sound = buf.readCharSequence(l, StandardCharsets.UTF_8).toString();
	}
	
}