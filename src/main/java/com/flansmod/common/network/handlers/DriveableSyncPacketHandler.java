package com.flansmod.common.network.handlers;

import com.flansmod.common.FlansMod;
import com.flansmod.common.data.UpgradeType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.network.packets.PacketDriveableSync;
import com.google.gson.JsonElement;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class DriveableSyncPacketHandler {
	
	public static class Server implements IMessageHandler<PacketDriveableSync, IMessage>{
		@Override
		public IMessage onMessage(final PacketDriveableSync packet, final MessageContext ctx) {
			IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayerMP player = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(ctx.getServerHandler().playerEntity.getName());
					EntityDriveable driveable = null;
					for(int i = 0; i < player.world.loadedEntityList.size(); i++){
						Object obj = player.world.loadedEntityList.get(i);
						if(obj instanceof EntityDriveable && ((Entity)obj).getEntityId() == packet.entityId){
							driveable = (EntityDriveable)obj;
							FlansMod.getNewPacketHandler().sendTo(new PacketDriveableSync(driveable), player);
							break;
						}
					}
					
				}
				
			});
			return null;
		}
	}
	
	public static class Client implements IMessageHandler<PacketDriveableSync, IMessage>{
		@Override
		public IMessage onMessage(final PacketDriveableSync packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityDriveable driveable = null;
					for(Object obj : Minecraft.getMinecraft().world.loadedEntityList){
						if(obj instanceof EntityDriveable && ((Entity)obj).getEntityId() == packet.entityId){
							driveable = (EntityDriveable)obj;
							driveable.driveableData.primary_color = packet.primary;
							driveable.driveableData.secondary_color = packet.secondary;
							driveable.driveableData.texture_url = packet.texture_url;
							for(JsonElement elm : packet.upgrades){
								UpgradeType type = UpgradeType.getUpgrade(elm.getAsString());
								if(type != null){
									driveable.driveableData.upgrades.add(type);
								}
							}
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