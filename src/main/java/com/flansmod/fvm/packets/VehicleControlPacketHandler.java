package com.flansmod.fvm.packets;

import com.flansmod.fvm.LandVehicle;

import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class VehicleControlPacketHandler {
	
	public static class Server implements IMessageHandler<PacketVehicleControl, IMessage>{
		@Override
		public IMessage onMessage(final PacketVehicleControl packet, final MessageContext ctx) {
			IThreadListener ls = Static.getServer();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayerMP player = Static.getServer().getPlayerList().getPlayerByUsername(ctx.getServerHandler().playerEntity.getName());
					LandVehicle vehicle = null;
					for(int i = 0; i < player.world.loadedEntityList.size(); i++){
						Object obj = player.world.loadedEntityList.get(i);
						if(obj instanceof LandVehicle && ((Entity)obj).getEntityId() == packet.entityId){
							vehicle = (LandVehicle)obj;
							break;
						}
					}
					if(vehicle != null){
						updatevehicle(vehicle, packet);
					}
					
				}
				
			});
			return null;
		}
	}
	
	public static class Client implements IMessageHandler<PacketVehicleControl, IMessage>{
		@Override
		public IMessage onMessage(final PacketVehicleControl packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayer player = Minecraft.getMinecraft().player;
					if(player == null || player.world == null){
						return;
					}
					LandVehicle vehicle = null;
					for(Object obj : player.world.loadedEntityList){
						if(obj instanceof LandVehicle && ((Entity)obj).getEntityId() == packet.entityId){
							vehicle = (LandVehicle)obj;
							if(vehicle.seats[0] != null && vehicle.seats[0].getControllingPassenger() == player){
								return;
							}
							break;
						}
					}
					if(vehicle != null){
						updatevehicle(vehicle, packet);
					}
				}
			});
			return null;
		}
	}
	
	protected static void updatevehicle(LandVehicle vehicle, PacketVehicleControl pkt){
		vehicle.setPositionRotationAndMotion(pkt.posX, pkt.posY, pkt.posZ, pkt.yaw, pkt.pitch, pkt.roll, pkt.motX, pkt.motY, pkt.motZ, pkt.avelx, pkt.avely, pkt.avelz, pkt.throttle, pkt.steeringYaw);
		vehicle.data.doors = pkt.doors;
	}
	
}