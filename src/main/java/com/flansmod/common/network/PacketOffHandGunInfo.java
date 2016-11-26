package com.flansmod.common.network;

import com.flansmod.common.util.Util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;

@Deprecated
public class PacketOffHandGunInfo extends PacketBase 
{
	public int entityID;
	public ItemStack gunStack;
	
	public PacketOffHandGunInfo()
	{
		
	}
			
	public PacketOffHandGunInfo(EntityPlayerMP playerEntity, int slot) 
	{
		entityID = playerEntity.getEntityId();
		if(slot == 0)
			gunStack = null;
		else gunStack = playerEntity.inventory.getStackInSlot(slot - 1);
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		data.writeInt(entityID);
		ByteBufUtils.writeItemStack(data, gunStack);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		entityID = data.readInt();
		gunStack = ByteBufUtils.readItemStack(data);
	}

	@Override
	public void handleServerSide(EntityPlayerMP playerEntity) 
	{
		Util.log("Received off hand gun info packet on server. Skipping. Did you mean to send a PacketSelectOffHandGun?");
	}

	@Override
	public void handleClientSide(EntityPlayer clientPlayer) 
	{
		/*
		Entity entity = clientPlayer.worldObj.getEntityByID(entityID);
		if(entity instanceof EntityPlayer && entity != clientPlayer)
		{
			PlayerData data = PlayerHandler.getPlayerData((EntityPlayer) entity, Side.CLIENT);
			data.offHandGunStack = gunStack;
		}
		*/
	}

}
