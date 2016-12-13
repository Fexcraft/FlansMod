package com.flansmod.common.network;

import com.flansmod.common.util.Util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

@Deprecated
public class PacketSelectOffHandGun extends PacketBase 
{
	public int slot;
	public int entityID;
	
	public PacketSelectOffHandGun()
	{
		
	}
	
	public PacketSelectOffHandGun(int i)
	{
		slot = i;
	}
	
	public PacketSelectOffHandGun(EntityPlayer player, int i)
	{
		entityID = player.getEntityId();
		slot = i;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		data.writeByte(slot);
		data.writeInt(entityID);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		slot = data.readByte();
		entityID = data.readInt();
	}


	@Override
	public void handleServerSide(EntityPlayerMP playerEntity) 
	{
		//PlayerData data = PlayerHandler.getPlayerData(playerEntity, Side.SERVER);
		//data.offHandGunSlot = slot;
		
		//FlansMod.getPacketHandler().sendToAllAround(new PacketOffHandGunInfo(playerEntity, slot), playerEntity.posX, playerEntity.posY, playerEntity.posZ, 50F, playerEntity.dimension);
	}


	@Override
	public void handleClientSide(EntityPlayer clientPlayer) 
	{
		Util.log("Received off hand gun select packet on client. Skipping. Did you mean to send a PacketOffHandGunInfo?");
	}
}
