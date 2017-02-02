package com.flansmod.common.parts;

import java.util.List;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemKey extends Item{
	
	public ItemKey(){
		this.setMaxStackSize(1);
		Registry.registerItemManually(FlansMod.MODID, "key", 0, null, this);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if(stack.getTagCompound() == null && entity instanceof EntityPlayer){
			stack.setTagCompound(new NBTTagCompound());
			NBTTagCompound nbt = stack.getTagCompound();
			nbt.setString("owner", ((EntityPlayer)entity).getGameProfile().getId().toString());
			nbt.setInteger("code", 10000);
			nbt.setBoolean("universal", false);
			nbt.setString("vehicle", "none");
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {		
		if(stack.getTagCompound() != null) {
			NBTTagCompound nbt = stack.getTagCompound();
			list.add("Owner: " + nbt.getString("owner"));
			list.add("Code: " + nbt.getString("code").toUpperCase());
			list.add("Universal: " + nbt.getBoolean("universal"));
			list.add("Vehicle: " + nbt.getString("vehicle"));
		}
	}
	
}