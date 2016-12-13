package com.flansmod.common.util;

import com.flansmod.common.EntityCustomItem;
import com.flansmod.common.guns.ItemGun;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Ticker {
	
	public static int tick = 0;
	public static long lastTime;
	
	public Ticker(){
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	/*@SubscribeEvent
	public void tick(TickEvent.ClientTickEvent event){
		switch(event.phase){
			case START:{
				break;
			}
			case END:{
				//FlansMod.playerHandler.clientTick();
				break;
			}		
		}
	}*/
	
	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event){
		switch(event.phase){
			case START:{
				//Handle all packets received since last tick
				//FlansMod.getPacketHandler().handleServerPackets();

				/*JsonObject obj = JsonUtil.getJsonForPacket("flansmod_debug");
				obj.addProperty("task", "tick");
				PacketHandler.getInstance().sendToServer(new PacketJsonObject(obj));*/
				break;
			}
			case END:{
				//TeamsManager.getInstance().tick();
				//FlansMod.playerHandler.serverTick();
				Ticker.tick++;
				break;
			}		
		}
	}

	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent event){
		if(event.getEntity() instanceof EntityItem && !(event.getEntity() instanceof EntityCustomItem)){
			ItemStack stack = ((EntityItem) event.getEntity()).getEntityItem();
			if(stack.getItem() instanceof ItemGun && ((ItemGun)stack.getItem()).getInfoType().modelString != null){
				EntityCustomItem replacementItem = new EntityCustomItem((EntityItem)event.getEntity());
				event.getWorld().spawnEntity(replacementItem);
				event.setCanceled(true);
			}
		}
	}
}