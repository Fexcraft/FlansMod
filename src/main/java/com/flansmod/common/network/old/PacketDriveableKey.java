package com.flansmod.common.network.old;

import com.flansmod.api.IControllable;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.util.Util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketDriveableKey extends PacketBase 
{
	public int key;
	
	public PacketDriveableKey() {}

	public PacketDriveableKey(int k)
	{
		key = k;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		data.writeInt(key);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		key = data.readInt();
	}

	@Override
	public void handleServerSide(EntityPlayerMP playerEntity) 
	{
		if(playerEntity.getRidingEntity() != null && playerEntity.getRidingEntity() instanceof IControllable)
		{
			((IControllable)playerEntity.getRidingEntity()).pressKey(key, playerEntity);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleClientSide(EntityPlayer clientPlayer) 
	{
		Util.log("Driveable keypress packet received on client. Skipping.");
	}

}
