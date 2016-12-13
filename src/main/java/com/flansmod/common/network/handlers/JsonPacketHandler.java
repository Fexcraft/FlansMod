package com.flansmod.common.network.handlers;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.frsm.util.java.BoolUtil;
import net.fexcraft.mod.fsu.server.modules.nrr.util.Util;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketJsonObject;
import net.fexcraft.mod.lib.util.cls.Print;
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
						FlansMod.DEBUG = BoolUtil.reverse(FlansMod.DEBUG);
						break;
					case "tick":
						Print.spam(1, "TICK => " + Util.getTime() + ";");
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