package com.flansmod.common.network.handlers;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.network.packets.PacketSeatUpdate;
import com.flansmod.common.util.Config;

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
	
	public static class Server implements IMessageHandler<PacketSeatUpdate, IMessage>{
		@Override
		public IMessage onMessage(final PacketSeatUpdate packet, final MessageContext ctx) {
			IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayerMP player = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(ctx.getServerHandler().playerEntity.getName());
					EntityDriveable driveable = null;
					for(Object obj : player.worldObj.loadedEntityList){
						if(obj instanceof EntityDriveable && ((Entity)obj).getEntityId() == packet.entityId){
							driveable = (EntityDriveable)obj;
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
	
	public static class Client implements IMessageHandler<PacketSeatUpdate, IMessage>{
		@Override
		public IMessage onMessage(final PacketSeatUpdate packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayer player = Minecraft.getMinecraft().thePlayer;
					EntityDriveable driveable = null;
					for(int i = 0; i < player.worldObj.loadedEntityList.size(); i++){
						Object obj = player.worldObj.loadedEntityList.get(i);
						if(obj instanceof EntityDriveable && ((Entity)obj).getEntityId() == packet.entityId){
							driveable = (EntityDriveable)obj;
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