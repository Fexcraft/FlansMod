package com.flansmod.common.network.handlers;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.network.packets.PacketSeatRemoval;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SeatRemovalPacketHandler {
	
	public static class Client implements IMessageHandler<PacketSeatRemoval, IMessage>{
		@Override
		public IMessage onMessage(final PacketSeatRemoval packet, final MessageContext ctx) {
			IThreadListener ls = Minecraft.getMinecraft();
			ls.addScheduledTask(new Runnable(){
				@Override
				public void run(){
					EntityPlayer player = Minecraft.getMinecraft().player;
					EntityDriveable driveable = null;
					for(int i = 0; i < player.world.loadedEntityList.size(); i++){
						Object obj = player.world.loadedEntityList.get(i);
						if(obj instanceof EntityDriveable && ((Entity)obj).getEntityId() == packet.entityId){
							driveable = (EntityDriveable)obj;
							break;
						}
					}
					if(driveable != null){
						driveable.seats[packet.seatId].exists = false;
						driveable.seats[packet.seatId].setDead();
					}
				}
			});
			return null;
		}
	}
	
}