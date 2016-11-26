package com.flansmod.common.eventhandlers;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerDeathEventListener {

	public PlayerDeathEventListener() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	@SubscribeEvent
	public void PlayerDied(LivingDeathEvent DamageEvent) {
		/*if ((DamageEvent.getSource().getDamageType().equalsIgnoreCase("explosion") && ((DamageEvent.getSource().getSourceOfDamage() instanceof EntityGrenade) || (DamageEvent.getSource().getSourceOfDamage() instanceof EntityBullet))) && DamageEvent.getEntityLiving() instanceof EntityPlayer) {
			boolean isGrenade;
			if (DamageEvent.getSource().getSourceOfDamage() instanceof EntityGrenade) {
				isGrenade = true;
				//EntityGrenade Grenade = (EntityGrenade) DamageEvent.getSource().getSourceOfDamage();
			} else {
				isGrenade = false;
				//EntityBullet Grenade = (EntityBullet) DamageEvent.getSource().getSourceOfDamage();
			}
			EntityPlayer killer = null;
			EntityPlayer killed = (EntityPlayer) DamageEvent.getEntityLiving();
			Team killerTeam = null;
			Team killedTeam = null;
			if (isGrenade) {
				killer = (EntityPlayer) ((EntityGrenade) DamageEvent.getSource().getSourceOfDamage()).thrower;
			} else {
				killer = (EntityPlayer) ((EntityBullet) DamageEvent.getSource().getSourceOfDamage()).owner;
			}
			killerTeam = PlayerHandler.getPlayerData(killer).team;
			killedTeam = PlayerHandler.getPlayerData(killed).team;
			if (DamageEvent.getEntityLiving() instanceof EntityPlayer && !isGrenade) {
				FlansMod.getPacketHandler().sendToDimension(new PacketKillMessage(false, ((EntityBullet) DamageEvent.getSource().getSourceOfDamage()).type, (killedTeam == null ? "f" : killedTeam.textColour) + ((EntityPlayer) DamageEvent.getEntity()).getDisplayName().getFormattedText(), (killerTeam == null ? "f" : killedTeam.textColour) + ((EntityPlayer) DamageEvent.getSource().getSourceOfDamage()).getDisplayName().getFormattedText()), DamageEvent.getEntityLiving().dimension);
			}
			if (DamageEvent.getEntityLiving() instanceof EntityPlayer && isGrenade) {
				FlansMod.getPacketHandler().sendToDimension(new PacketKillMessage(false, ((EntityGrenade) DamageEvent.getSource().getSourceOfDamage()).type, (killedTeam == null ? "f" : killedTeam.textColour) + ((EntityPlayer) DamageEvent.getEntity()).getDisplayName().getFormattedText(), (killerTeam == null ? "f" : killedTeam.textColour) + ((EntityPlayer) DamageEvent.getSource().getSourceOfDamage()).getDisplayName().getFormattedText()), DamageEvent.getEntityLiving().dimension);
			}
		}*/
	}
}
