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
		this.primary = ent.driveableData.primary_color;
		this.secondary = ent.driveableData.secondary_color;
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeInt(entityId);
		buf.writeByte(primary.red);
		buf.writeByte(primary.green);
		buf.writeByte(primary.blue);
		buf.writeByte(secondary.red);
		buf.writeByte(secondary.green);
		buf.writeByte(secondary.blue);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		entityId = buf.readInt();
		primary = new RGB(buf.readByte(), buf.readByte(), buf.readByte());
		secondary = new RGB(buf.readByte(), buf.readByte(), buf.readByte());
	}
	
}