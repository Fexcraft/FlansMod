package com.flansmod.common.network.packets;

import com.flansmod.common.driveables.EntityDriveable;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketDriveableColor implements IPacket, IMessage{
	
	public int entityId;
	public RGB primary;
	public RGB secondary;
	
	public PacketDriveableColor(){}
	
	public PacketDriveableColor(EntityDriveable ent){
		this.entityId = ent.getEntityId();
		this.primary = ent.primary_color;
		this.secondary = ent.secondary_color;
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(entityId);
		buf.writeFloat(primary.red);
		buf.writeFloat(primary.green);
		buf.writeFloat(primary.blue);
		buf.writeFloat(secondary.red);
		buf.writeFloat(secondary.green);
		buf.writeFloat(secondary.blue);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		entityId = buf.readInt();
		primary = new RGB(buf.readFloat(), buf.readFloat(), buf.readFloat());
		secondary = new RGB(buf.readFloat(), buf.readFloat(), buf.readFloat());
	}
	
}