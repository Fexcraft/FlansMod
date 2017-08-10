package com.flansmod.client;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;

import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/** All handled events for the client should go through here and be passed on. Makes it easier to see which events are being handled by the mod */
public class ClientEventHandler {
	
	private KeyInputHandler keyInputHandler = new KeyInputHandler();
	
	@SubscribeEvent
	public void clientTick(TickEvent.ClientTickEvent event){
		switch(event.phase){
			case START :{
				break;
			}
			case END :{
		    	//InstantBulletRenderer.UpdateAllTrails();
				FlansModClient.tick();
				break;
			}
		}	
	}
	
	@SubscribeEvent
	public void chatMessage(ClientChatReceivedEvent event)
	{
		if(event.getMessage().getUnformattedText().equals("#flansmod"))
		{
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void checkKeyInput(KeyInputEvent event){
		keyInputHandler.checkKeyInput(event);
	}
	
	@SubscribeEvent
	public void addDebugInfo(RenderGameOverlayEvent event){
		Minecraft mc = Minecraft.getMinecraft();
		//DEBUG vehicles
		if(mc.player.getRidingEntity() instanceof EntitySeat){
			EntityDriveable ent = ((EntitySeat)mc.player.getRidingEntity()).driveable;;
			mc.fontRenderer.drawString("Speed: " + calculateSpeed(ent) + " chunks per hour", 2, 2, 0xffffff);
			if(Static.dev()){
				mc.fontRenderer.drawString("Throttle : " + ent.throttle, 2, 12, 0xffffff);
			}
		}
		else if(FlansMod.FVTM){
			if(mc.player.getRidingEntity() instanceof com.flansmod.fvtm.EntitySeat){
				com.flansmod.fvtm.LandVehicle ent = ((com.flansmod.fvtm.EntitySeat)mc.player.getRidingEntity()).vehicle;
				mc.fontRenderer.drawString("Speed: " + calculateSpeed(ent) + " chunks per hour", 2, 2, 0xffffff);
				if(Static.dev()){
					mc.fontRenderer.drawString("Throttle : " + ent.throttle, 2, 12, 0xffffff);
				}
			}
		}
	}
	
	public static float calculateSpeed(Entity ent){
		double dX = ent.posX - ent.prevPosX, dY = ent.posY - ent.prevPosY, dZ = ent.posZ - ent.prevPosZ;
		float speed = (float)Math.sqrt(dX * dX + dY * dY + dZ * dZ) * 1000F / 16F; 
		return speed = (int)(speed * 10F) / 10F;
	}

}
