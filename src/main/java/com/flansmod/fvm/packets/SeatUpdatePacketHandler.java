package com.flansmod.fvm.packets;

import com.flansmod.common.FlansMod;
import com.flansmod.common.util.Config;
import com.flansmod.fvm.LandVehicle;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SeatUpdatePacketHandler {
	
	public static class Server implements IMessageHandler<FvmPacketSeatUpdate, IMessage>{
		@Override
		public IMessage onMessage(final FvmPacketSeatUpdate packet, final MessageContext ctx) {
			IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayerMP player = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(ctx.getServerHandler().playerEntity.getName());
					LandVehicle driveable = null;
					for(Object obj : player.world.loadedEntityList){
						if(obj instanceof LandVehicle && ((Entity)obj).getEntityId() == packet.entityId){
							driveable = (LandVehicle)obj;
							break;
						}
					}
					if(driveable != null){
						driveable.seats[packet.seatId].prevLooking = driveable.seats[packet.seatId].looking.clone();
						driveable.seats[packet.seatId].looking.setAngles(packet.yaw, packet.pitch, 0F);
						FlansMod.getNewPacketHandler().sendToAllAround(packet, new TargetPoint(driveable.dimension, driveable.getPosition().getX(), driveable.getPosition().getY(), driveable.getPosition().getZ(), Config.soundRange));
					}
				}
			});
			return null;
		}
	}
	
	public static class Client implements IMessageHandler<FvmPacketSeatUpdate, IMessage>{
		@Override
		public IMessage onMessage(final FvmPacketSeatUpdate packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayer player = Minecraft.getMinecraft().player;
					LandVehicle driveable = null;
					for(int i = 0; i < player.world.loadedEntityList.size(); i++){
						Object obj = player.world.loadedEntityList.get(i);
						if(obj instanceof LandVehicle && ((Entity)obj).getEntityId() == packet.entityId){
							driveable = (LandVehicle)obj;
							break;
						}
					}
					if(driveable != null){
						//If this is the player who sent the packet in the first place, don't read it
						if(driveable.seats[packet.seatId] == null || driveable.seats[packet.seatId].getControllingPassenger() == player){
							return;
						}
						driveable.seats[packet.seatId].prevLooking = driveable.seats[packet.seatId].looking.clone();
						driveable.seats[packet.seatId].looking.setAngles(packet.yaw, packet.pitch, 0F);
					}
				}
			});
			return null;
		}
	}
	
}