package com.flansmod.common.items;

import java.util.ArrayList;
import java.util.List;

import com.flansmod.common.FlansMod;
import com.flansmod.common.data.EnumPartCategory;
import com.flansmod.common.data.PartType;
import com.flansmod.common.util.CTabs;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPart extends Item {
	
	private static final ArrayList<String> rs = new ArrayList<String>();
	public PartType type;
	
	public ItemPart(PartType type1){
		super();
		type = type1;
		setMaxStackSize(type.stackSize);
		if(type.category == EnumPartCategory.FUEL){
			setMaxDamage(type.fuel);
			setHasSubtypes(true);
		}
		type.item = this;
		setCreativeTab(CTabs.parts);
		FlansMod.AUTOREG.addItem(type.registryname, this, 0, null);
	}
	
	@Override
	public void addInformation(ItemStack stack, World player, List list, ITooltipFlag flag){
		if(type.category == EnumPartCategory.FUEL){
			list.add("Fuel Stored: " + (type.fuel - stack.getItemDamage()) + " / " + type.fuel);
		}
	}
	
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2){
    	return type.colour;
    }
	
	public static Item getNew(PartType type){
		if(rs.contains(type.registryname)){
			return null;
		}
		else{
			rs.add(type.registryname);
			return new ItemPart(type);
		}
	}
	
}