package com.flansmod.client;

import com.flansmod.client.model.InstantBulletRenderer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/** All handled events for the client should go through here and be passed on. Makes it easier to see which events are being handled by the mod */
public class ClientEventHandler {
	private KeyInputHandler keyInputHandler = new KeyInputHandler();

	/** List for storing replacement EntityItemCustomRenderers. Stops concurrent modifications and messing up the entity list. */
	//private LinkedList<EntityItemCustomRender> replacementItemEntities = new LinkedList<>();

	@SubscribeEvent
	public void renderTick(TickEvent.RenderTickEvent event)
	{
		switch(event.phase)
		{
			case START :
			{
				FlansModClient.UpdateCameraZoom(event.renderTickTime);
				break;
			}
			case END :
			{
				
				break;
			}
		}	
	}
	
	@SubscribeEvent
	public void clientTick(TickEvent.ClientTickEvent event)
	{
		switch(event.phase)
		{
			case START :
			{
				//Handle all packets received since last tick
				//FlansMod.getPacketHandler().handleClientPackets();
				FlansModClient.UpdateFlashlights(Minecraft.getMinecraft());
				break;
			}
			case END :
			{
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
	public void renderWorld(RenderWorldLastEvent event){
		InstantBulletRenderer.RenderAllTrails(event.getPartialTicks());
	}

}
