package com.flansmod.common.network.handlers;

import com.flansmod.client.ClientProxy;
import com.flansmod.common.network.packets.PacketPlaySound;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PlaySoundPacketHandler {
	
	public static class Server implements IMessageHandler<PacketPlaySound, IMessage>{
		@Override
		public IMessage onMessage(final PacketPlaySound packet, final MessageContext ctx) {
			IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					Print.log("[> FM- <] Received play sound packet on server. Skipping.");
				}
				
			});
			return null;
		}
	}
	
	public static class Client implements IMessageHandler<PacketPlaySound, IMessage>{
		@Override
		public IMessage onMessage(final PacketPlaySound packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					if(packet.sound.equals("null")){
						return;
					}
					switch(packet.sound){
						case "engine_running": case "engine_starting":{
							//Entity ent = Minecraft.getMinecraft().world.getEntityByID(packet.entity);
							//TODO
							break;
						}
						case "": case "null": default:{
							break;
						}
					}
					FMLClientHandler.instance().getClient().getSoundHandler().playSound(new PositionedSoundRecord(ClientProxy.sounds.get(packet.sound), SoundCategory.AMBIENT, packet.silenced ? 5F : 10F, (packet.distort ? 1.0F / (Static.random.nextFloat() * 0.4F + 0.8F) : 1.0F) * (packet.silenced ? 2F : 1F), false, 0, null, packet.posX, packet.posY, packet.posZ));
				}
			});
			return null;
		}
	}
	
}