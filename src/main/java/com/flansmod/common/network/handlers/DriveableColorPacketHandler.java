package com.flansmod.common.network.handlers;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.network.packets.PacketDriveableColor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class DriveableColorPacketHandler {
	
	public static class Client implements IMessageHandler<PacketDriveableColor, IMessage>{
		@Override
		public IMessage onMessage(final PacketDriveableColor packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayer player = Minecraft.getMinecraft().player;
					if(player == null || player.world == null){
						return;
					}
					EntityDriveable driveable = null;
					for(Object obj : player.world.loadedEntityList){
						if(obj instanceof EntityDriveable && ((Entity)obj).getEntityId() == packet.entityId){
							driveable = (EntityDriveable)obj;
							driveable.primary_color = packet.primary;
							driveable.secondary_color = packet.secondary;
							break;
						}
					}
				}
			});
			return null;
		}
	}
	
}