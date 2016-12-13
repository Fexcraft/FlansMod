package com.flansmod.common.network.handlers;

import com.flansmod.common.network.packets.PacketEmpty;

import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class EmptyPacketHandler implements IMessageHandler<PacketEmpty, IMessage>{
	
	@Override
	public IMessage onMessage(final PacketEmpty packet, final MessageContext ctx) {
		IThreadListener ls = FMLCommonHandler.instance().getMinecraftServerInstance();
		ls.addScheduledTask(new Runnable(){
			@Override
			public void run(){
				Print.spam(1, "Processing Empty Packet.");
			}
		});
		return null;
	}
	
}