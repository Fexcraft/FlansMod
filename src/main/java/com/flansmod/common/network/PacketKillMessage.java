package com.flansmod.common.network;

import com.flansmod.client.ClientRenderHooks;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.util.Util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketKillMessage extends PacketBase 
{
	public InfoType killedBy;
	public String killerName;
	public String killedName;
	public boolean headshot;
	
	public PacketKillMessage()
	{
		
	}
	
	public PacketKillMessage(boolean head, InfoType weapon, String victim, String murderer)
	{
		killedBy = weapon;
		killerName = murderer;
		killedName = victim;
		headshot = head;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		data.writeBoolean(headshot);
		writeUTF(data, killedBy.shortName);
		writeUTF(data, killerName);
		writeUTF(data, killedName);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		headshot = data.readBoolean();
		killedBy = InfoType.getType(readUTF(data));
		killerName = readUTF(data);
		killedName = readUTF(data);
	}

	@Override
	public void handleServerSide(EntityPlayerMP playerEntity) 
	{
		Util.log("Received kill message packet on the server. Skipping.");
	}

	@Override
	public void handleClientSide(EntityPlayer clientPlayer) 
	{
		ClientRenderHooks.addKillMessage(headshot, killedBy, killerName, killedName);
	}

}
