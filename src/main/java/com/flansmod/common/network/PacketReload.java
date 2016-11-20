package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.FlansUtils;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//When the client receives one, it "reloads". Basically to stop client side recoil effects when the gun should be in a reload animation
//When the server receives one, it is interpreted as a forced reload
public class PacketReload extends PacketBase
{
	public EnumHandSide handSide;
	public boolean isForced;

	public PacketReload() {}

	public PacketReload(EnumHandSide handSide, boolean isForced)
	{
		this.handSide = handSide;
		this.isForced = isForced;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf data)
	{
		data.writeByte((byte)handSide.ordinal());
		data.writeBoolean(isForced);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data)
	{
		handSide = EnumHandSide.values()[data.readByte()];
		isForced = data.readBoolean();
	}

	@Override
	public void handleServerSide(EntityPlayerMP playerEntity)
	{
		PlayerData data = PlayerHandler.getPlayerData(playerEntity);
		EnumHand hand = FlansUtils.getHandForSide(handSide, playerEntity);
		ItemStack stack = playerEntity.getHeldItem(hand);
		/*
		if(isOffHand && data.offHandGunSlot != 0)
		{
			stack = playerEntity.inventory.getStackInSlot(data.offHandGunSlot - 1);
			playerEntity.inventory.currentItem = data.offHandGunSlot - 1;
		}
		*/
		if(data != null && stack != null && stack.getItem() instanceof ItemGun)
		{
			ItemGun gun = (ItemGun) stack.getItem();
			GunType type = gun.getInfoType();

			if (((ItemGun) stack.getItem()).Reload(stack, playerEntity.getEntityWorld(), playerEntity, playerEntity.inventory, handSide, isForced, playerEntity.isCreative()))
			{

				if (handSide == EnumHandSide.LEFT)
				{
					data.shootTimeLeft = type.reloadTime;
					data.reloadingLeft = true;
				}
				else
				{
					data.shootTimeRight = type.reloadTime;
					data.reloadingRight = true;
				}


				//Play reload sound
				if (type.reloadSound != null)
				{
					PacketPlaySound.sendSoundPacket(
							playerEntity.posX,
							playerEntity.posY,
							playerEntity.posZ,
							FlansMod.soundRange,
							playerEntity.dimension,
							type.reloadSound,
							false
					);
				}

			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleClientSide(EntityPlayer clientPlayer)
	{
		FlansMod.log("Recieved reload packet on client!");
	}
}
