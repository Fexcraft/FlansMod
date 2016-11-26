package com.flansmod.common.network;

import java.util.Random;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.FlansMod;
import com.flansmod.common.util.Util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.audio.ISound.AttenuationType;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketPlaySound extends PacketBase 
{
	public static Random rand = new Random();
	public float posX, posY, posZ;
	public String sound;
	public boolean distort, silenced;

	public PacketPlaySound() {}

	public static void sendSoundPacket(double x, double y, double z, double range, int dimension, String s, boolean distort)
	{	
		sendSoundPacket(x, y, z, range, dimension, s, distort, false);
	}
	
	public static void sendSoundPacket(double x, double y, double z, double range, int dimension, String s, boolean distort, boolean silenced)
	{
		FlansMod.getPacketHandler().sendToAllAround(new PacketPlaySound(x, y, z, s, distort, silenced), x, y, z, (float)range, dimension);
	}

	public PacketPlaySound(double x, double y, double z, String s)
	{
		this(x, y, z, s, false);
	}

	public PacketPlaySound(double x, double y, double z, String s, boolean distort)
	{	
		this(x, y, z, s, distort, false);
	}
	
	public PacketPlaySound(double x, double y, double z, String s, boolean distort, boolean silenced)
	{
		posX = (float)x; posY = (float)y; posZ = (float)z;
		sound = s;
		this.distort = distort;
		this.silenced = silenced;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		data.writeFloat(posX);
		data.writeFloat(posY);
		data.writeFloat(posZ);
		writeUTF(data, sound);
		data.writeBoolean(distort);
		data.writeBoolean(silenced);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) 
	{
		posX = data.readFloat();
		posY = data.readFloat();
		posZ = data.readFloat();
		sound = readUTF(data);
		distort = data.readBoolean();
		silenced = data.readBoolean();
	}

	@Override
	public void handleServerSide(EntityPlayerMP playerEntity) 
	{
		Util.log("Received play sound packet on server. Skipping.");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleClientSide(EntityPlayer clientPlayer) 
	{
		//TODO check this
		FMLClientHandler.instance().getClient().getSoundHandler().playSound(new PositionedSoundRecord(FlansModResourceHandler.getSound(sound), SoundCategory.MASTER, silenced ? 5F : 10F, (distort ? 1.0F / (rand.nextFloat() * 0.4F + 0.8F) : 1.0F) * (silenced ? 2F : 1F), false, 0, AttenuationType.NONE, posX, posY, posZ));
	}

}
