package com.flansmod.common.util;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveableType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CTabs {
	
	public static CreativeTab vehicles = new CreativeTab(0);
	public static CreativeTab parts = new CreativeTab(1);
	public static CreativeTab other = new CreativeTab(2);

	public static class CreativeTab extends CreativeTabs{
		public int id; //0 = Guns, 1 = Vehicles + Planes, 2 = Teams, 3 = Parts, 4 = Mechas
		public int icon;
		public int time = 0;
		
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
				case 0 : return DriveableType.types.size() == 0 ? new ItemStack(Blocks.WOOL, 1, 14) : new ItemStack(DriveableType.types.get(icon % DriveableType.types.size()).item);
				case 1 : return FlansMod.partItems.size() == 0 ? new ItemStack(Blocks.WOOL, 1, 5) : new ItemStack(FlansMod.partItems.get(icon % FlansMod.partItems.size()));
				case 2 : return new ItemStack(Items.SNOWBALL, 1);
			}
			return /*new ItemStack(Blocks.WOOL, 1, id);*/ new ItemStack(Items.BRICK, 2);
		}
	}

}