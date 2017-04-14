package com.flansmod.common.data.player;

import com.flansmod.common.util.Util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerHandler {
	
	@CapabilityInject(IPlayerData.class)
	public static final Capability<IPlayerData> DATA = null;
	
	public static void initialize(){
		Util.log("Initialising Player Data Handler.");
		CapabilityManager.INSTANCE.register(IPlayerData.class, new Storage(), PlayerData.class);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	public static class Provider implements ICapabilitySerializable<NBTTagCompound>{
		IPlayerData instance = DATA.getDefaultInstance();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing){
			return capability == DATA;
		}
		
		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing){
			return hasCapability(capability, facing) ? DATA.<T>cast(instance) : null;
		}
		
		@Override
		public NBTTagCompound serializeNBT(){
			return (NBTTagCompound) DATA.getStorage().writeNBT(DATA, instance, null);
		}
		
		@Override
		public void deserializeNBT(NBTTagCompound nbt){
			DATA.getStorage().readNBT(DATA, instance, null, nbt);
		}
	}
	
	public static class Storage implements IStorage<IPlayerData> {

		@Override
		public NBTBase writeNBT(Capability<IPlayerData> capability, IPlayerData instance, EnumFacing side){
			return instance.write();
		}

		@Override
		public void readNBT(Capability<IPlayerData> capability, IPlayerData instance, EnumFacing side, NBTBase nbt){
			instance.read((NBTTagCompound)nbt);
		}
		
	}
	
	public static class EventHandler {
		
		@SubscribeEvent
		public void attachCapabilities(AttachCapabilitiesEvent.Entity event){
			if(event.getObject() instanceof EntityPlayer){
				event.addCapability(new ResourceLocation("ffmm", "default"), new Provider());
			}
		}
		
		@SubscribeEvent
		public void clonePlayer(PlayerEvent.Clone event){;
			getData(event.getEntityPlayer()).copy(getData(event.getOriginal()));
		}
	}
	
	public static IPlayerData getData(EntityPlayer entity){
		return entity.getCapability(DATA, EnumFacing.NORTH);
    }
	
}