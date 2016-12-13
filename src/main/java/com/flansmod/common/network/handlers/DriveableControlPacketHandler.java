package com.flansmod.common.network.handlers;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.network.packets.PacketDriveableControl;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class DriveableControlPacketHandler {
	
	public static class Server implements IMessageHandler<PacketDriveableControl, IMessage>{
		@Override
		public IMessage onMessage(final PacketDriveableControl packet, final MessageContext ctx) {
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
							break;
						}
					}
					if(driveable != null){
						updateDriveable(driveable, packet);
					}
					
				}
				
			});
			return null;
		}
	}
	
	public static class Client implements IMessageHandler<PacketDriveableControl, IMessage>{
		@Override
		public IMessage onMessage(final PacketDriveableControl packet, final MessageContext ctx) {
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
							driveable.driveableData.fuelInTank = packet.fuelInTank;
							if(driveable.seats[0] != null && driveable.seats[0].getControllingPassenger() == player){
								return;
							}
							break;
						}
					}
					if(driveable != null){
						updateDriveable(driveable, packet);
					}
				}
			});
			return null;
		}
	}
	
	protected static void updateDriveable(EntityDriveable driveable, PacketDriveableControl pkt){
		if(pkt.errored){
			return;
		}
		driveable.setPositionRotationAndMotion(pkt.posX, pkt.posY, pkt.posZ, pkt.yaw, pkt.pitch, pkt.roll, pkt.motX, pkt.motY, pkt.motZ, pkt.avelx, pkt.avely, pkt.avelz, pkt.throttle, pkt.steeringYaw);
		driveable.driveableData.fuelInTank = pkt.fuelInTank;
	}
	
}