package com.flansmod.common.util;

import com.flansmod.common.FlansMod;
import com.flansmod.common.data.DataType;
import com.flansmod.common.data.DriveableType;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CTabs {
	
	public static final CreativeTab VEHICLES = new CreativeTab(0);
	public static final CreativeTab PARTS = new CreativeTab(1);
	public static final CreativeTab OTHER = new CreativeTab(2);

	public static class CreativeTab extends CreativeTabs{
		public int id; //0 = Vehicles + Planes, 1 = Parts, 2 = Other
		public int icon;
		
		public CreativeTab(int i){
			super("tabFlan" + i);
			id = i;
		}

		@Override
		public ItemStack getTabIconItem(){
			return null;
		}
		
		@Override
		public ItemStack getIconItemStack(){
			icon = Ticker.tick / 20;
			switch(id){
				case 0:{
					return DriveableType.getTypes().size() == 0 ? new ItemStack(Blocks.WOOL, 1, icon % 15) : new ItemStack(DriveableType.getTypes().toArray(new DataType[]{})[icon % DriveableType.getTypes().size()].item);
				}
				case 1:{
					return FlansMod.partItems.size() == 0 ? new ItemStack(Blocks.WOOL, 1, icon % -15) : new ItemStack(FlansMod.partItems.get(icon % FlansMod.partItems.size()));
				}
				case 2:{
					return new ItemStack(Items.SNOWBALL, 1);
				}
			}
			return new ItemStack(Items.BRICK, 2);
		}
	}

}