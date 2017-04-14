package com.flansmod.common.network.packets;

import com.flansmod.common.driveables.EntityDriveable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketDriveableTexture implements IPacket, IMessage{
	
	public int entityId;
	public String texture_url;
	
	public PacketDriveableTexture(){}
	
	public PacketDriveableTexture(EntityDriveable ent){
		this.entityId = ent.getEntityId();
		this.texture_url = ent.driveableData.texture_url;
		if(texture_url == null){
			texture_url = "";
		}
	}

	@Override
	public void toBytes(ByteBuf bbuf){
		PacketBuffer buf = new PacketBuffer(bbuf);
		buf.writeInt(entityId);
		buf.writeString(texture_url);
	}

	@Override
	public void fromBytes(ByteBuf bbuf){
		PacketBuffer buf = new PacketBuffer(bbuf);
		entityId = buf.readInt();
		texture_url = buf.readStringFromBuffer(999);
	}
	
}