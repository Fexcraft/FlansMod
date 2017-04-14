package com.flansmod.common.network.handlers;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.network.packets.PacketDriveableTexture;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class DriveableTexturePacketHandler {
	
	public static class Client implements IMessageHandler<PacketDriveableTexture, IMessage>{
		@Override
		public IMessage onMessage(final PacketDriveableTexture packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityDriveable driveable = null;
					for(Object obj : Minecraft.getMinecraft().theWorld.loadedEntityList){
						if(obj instanceof EntityDriveable && ((Entity)obj).getEntityId() == packet.entityId){
							driveable = (EntityDriveable)obj;
							driveable.driveableData.texture_url = packet.texture_url;
							driveable.sync = true;
							break;
						}
					}
				}
			});
			return null;
		}
	}
	
}