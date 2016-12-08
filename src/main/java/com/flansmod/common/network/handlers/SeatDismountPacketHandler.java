package com.flansmod.common.network.handlers;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.network.packets.PacketSeatDismount;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SeatDismountPacketHandler {
	
	public static class Client implements IMessageHandler<PacketSeatDismount, IMessage>{
		@Override
		public IMessage onMessage(final PacketSeatDismount packet, final MessageContext ctx) {
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
						driveable.seats[packet.seatId].dismount = true;
						driveable.seats[packet.seatId].removePassengers();
					}
				}
			});
			return null;
		}
	}
	
}