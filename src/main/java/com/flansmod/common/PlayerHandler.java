package com.flansmod.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.network.PacketHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.relauncher.Side;

public class PlayerHandler
{
	public static Map<UUID, PlayerData> serverSideData = new HashMap<UUID, PlayerData>();
	public static Map<UUID, PlayerData> clientSideData = new HashMap<UUID, PlayerData>();
	public static ArrayList<UUID> clientsToRemoveAfterThisRound = new ArrayList<UUID>();
	
	public PlayerHandler()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onEntityHurt(LivingAttackEvent event)
	{
		EntityLivingBase entity = event.getEntityLiving();
		if((entity.getRidingEntity() instanceof EntityDriveable || entity.getRidingEntity() instanceof EntitySeat))
		{
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void onEntityKilled(LivingDeathEvent event) 
	{
		EntityLivingBase entity = event.getEntityLiving();
		if(entity instanceof EntityPlayer)
		{
			getPlayerData((EntityPlayer)entity).playerKilled();
		}
	}
		
	public void serverTick()
	{
		for(WorldServer world : FMLCommonHandler.instance().getMinecraftServerInstance().worlds)
		{
			for(Object player : world.playerEntities)
			{
				getPlayerData((EntityPlayer)player).tick((EntityPlayer)player);
			}
		}
	}
	
	public void clientTick()
	{
		if(Minecraft.getMinecraft().world != null)
		{
			for(Object player : Minecraft.getMinecraft().world.playerEntities)
			{
				getPlayerData((EntityPlayer)player).tick((EntityPlayer)player);
			}	
		}
	}
	
	public static PlayerData getPlayerData(EntityPlayer player)
	{
		if(player == null)
			return null;
		return getPlayerData(player.getUniqueID(), player.world.isRemote ? Side.CLIENT : Side.SERVER);
	}
	
	public static PlayerData getPlayerData(UUID username)
	{
		return getPlayerData(username, Side.SERVER);
	}

	public static PlayerData getPlayerData(EntityPlayer player, Side side)
	{
		if(player == null)
			return null;
		return getPlayerData(player.getUniqueID(), side);
	}
	
	public static PlayerData getPlayerData(UUID uuid, Side side)
	{
		if(side.isClient())
		{
			if(!clientSideData.containsKey(uuid))
				clientSideData.put(uuid, new PlayerData(uuid));
		}
		else
		{
			if(!serverSideData.containsKey(uuid))
				serverSideData.put(uuid, new PlayerData(uuid));
		}
		return side.isClient() ? clientSideData.get(uuid) : serverSideData.get(uuid);
	}

	@SubscribeEvent
	public void onPlayerEvent(PlayerEvent event) 
	{
		if(event instanceof PlayerLoggedInEvent)
		{
			EntityPlayer player = event.player;
			UUID uuid = player.getUniqueID();
			if(!serverSideData.containsKey(uuid))
				serverSideData.put(uuid, new PlayerData(uuid));
			if(clientsToRemoveAfterThisRound.contains(uuid))
				clientsToRemoveAfterThisRound.remove(uuid);
			
			PacketHandler.add((EntityPlayerMP)player);
		}
		else if(event instanceof PlayerLoggedOutEvent)
		{
			EntityPlayer player = event.player;
			UUID uuid = player.getUniqueID();
			/*if(TeamsManager.getInstance().currentRound == null)
				serverSideData.remove(uuid);
			else clientsToRemoveAfterThisRound.add(uuid);*/
			
			PacketHandler.tryRemove(uuid);
		}
		else if(event instanceof PlayerRespawnEvent)
		{
			EntityPlayer player = event.player;
			UUID uuid = player.getUniqueID();
			if(!serverSideData.containsKey(uuid))
				serverSideData.put(uuid, new PlayerData(uuid));

			//If a player dies, a new EntityPlayerMP is created on the server,
			//remove the old Player and add the current one.
			PacketHandler.add((EntityPlayerMP)player);
		}
	}
	
	/** Called by teams manager to remove lingering player data */
	public static void roundEnded()
	{
		for(UUID uuid : clientsToRemoveAfterThisRound)
		{
			serverSideData.remove(uuid);
		}
	}
}
