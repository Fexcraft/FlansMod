package com.flansmod.common.items;

import java.util.ArrayList;
import java.util.List;

import com.flansmod.common.FlansMod;
import com.flansmod.common.data.EnumPartCategory;
import com.flansmod.common.data.UpgradeType;
import com.flansmod.common.util.CTabs;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUpgrade extends Item {
	
	private static final ArrayList<String> rs = new ArrayList<String>();
	public UpgradeType type;
	
	public ItemUpgrade(UpgradeType type1){
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
	public void addInformation(ItemStack stack, World world, List list, ITooltipFlag tooltip){
		if(type.compatible.size() > 0){
			list.add(TextFormatting.DARK_AQUA + "Compatible with:");
			for(String s : type.compatible){
				list.add(TextFormatting.AQUA + s);
			}
		}
		if(type.incompatible.size() > 0){
			list.add(TextFormatting.DARK_AQUA + "Incompatible with Upgrades:");
			for(String s : type.incompatible){
				list.add(TextFormatting.AQUA + s);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2){
    	return type.colour;
    }
	
	public static Item getNew(UpgradeType type){
		if(rs.contains(type.registryname)){
			return null;
		}
		else{
			rs.add(type.registryname);
			return new ItemUpgrade(type);
		}
	}
	
}