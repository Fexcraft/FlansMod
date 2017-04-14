package com.flansmod.common.network.handlers;

import java.util.Date;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.api.network.IPacket;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.entity.player.EntityPlayerMP;

public class JsonPacketHandler{
	
	public static class Client implements IPacketListener {
		@Override
		public String getId(){
			return "flansmod_debug";
		}
		@Override
		public void process(IPacket pkt, Object[] objs){
			PacketJsonObject packet = (PacketJsonObject)pkt;
			if(packet.obj.has("task")){
				switch(packet.obj.get("task").getAsString()){
					case "debug":
						FlansMod.DEBUG = !FlansMod.DEBUG;
						break;
					case "tick":
						Print.spam(1, "TICK => " + new Date().getTime() + ";");
						break;
				}
			}
		}
	}
	
	public static class Server implements IPacketListener {
		@Override
		public String getId(){
			return "flansmod_debug";
		}
		@Override
		public void process(IPacket pkt, Object[] objs){
			PacketJsonObject packet = (PacketJsonObject)pkt;
			if(packet.obj.has("task")){
				switch(packet.obj.get("task").getAsString()){
					case "debug":
						PacketHandler.getInstance().sendTo(new PacketJsonObject(packet.obj), (EntityPlayerMP)objs[0]);
						break;
				}
			}
		}
	}
	
}