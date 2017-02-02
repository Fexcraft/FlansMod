package com.flansmod.common.driveables.mechas;

import java.util.Collections;
import java.util.List;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.IFlanItem;
import com.flansmod.common.util.CTabs;

import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMechaAddon extends Item implements IFlanItem<MechaItemType> {
	
	public MechaItemType type;
	
	public ItemMechaAddon(MechaItemType type1){
		type = type1;
		setMaxStackSize(1);
		type.item = this;
		setCreativeTab(CTabs.vehicles);
		Registry.registerItemManually(FlansMod.MODID, type.shortName, 0, null, this);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b){
		if(type.description != null){
			Collections.addAll(list, type.description.split("_"));
		}
	}
	
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2){
    	return type.colour;
    }
    
	@Override
	public MechaItemType getInfoType(){
		return type;
	}
	
}
