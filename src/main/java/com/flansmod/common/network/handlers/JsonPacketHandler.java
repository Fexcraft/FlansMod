package com.flansmod.common.network.handlers;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.entity.player.EntityPlayerMP;

public class JsonPacketHandler{
	
	public static class Client implements IPacketListener<PacketJsonObject> {
		@Override
		public String getId(){
			return "flansmod_debug";
		}
		@Override
		public void process(PacketJsonObject packet, Object[] objs){
			if(packet.obj.has("task")){
				switch(packet.obj.get("task").getAsString()){
					case "debug":
						FlansMod.DEBUG = !FlansMod.DEBUG;
						break;
					case "tick":
						Print.spam(1, "TICK => " + Time.getDate() + ";");
						break;
				}
			}
		}
	}
	
	public static class Server implements IPacketListener<PacketJsonObject> {
		@Override
		public String getId(){
			return "flansmod_debug";
		}
		@Override
		public void process(PacketJsonObject packet, Object[] objs){
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