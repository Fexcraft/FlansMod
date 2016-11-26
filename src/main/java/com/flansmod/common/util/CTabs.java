package com.flansmod.common.util;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.guns.GunType;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CTabs {
	
	public static CreativeTab weapons = new CreativeTab(0);
	public static CreativeTab vehicles = new CreativeTab(1);
	public static CreativeTab parts = new CreativeTab(2);
	public static CreativeTab other = new CreativeTab(3);

	public static class CreativeTab extends CreativeTabs{
		public int id; //0 = Guns, 1 = Vehicles + Planes, 2 = Teams, 3 = Parts, 4 = Mechas
		public int icon;
		public int time = 0;
		
		public CreativeTab(int i){
			super("tabFlan" + i);
			id = i;
		}

		@Override
		public Item getTabIconItem(){
			return null;
		}
		
		@Override
		public ItemStack getIconItemStack(){
			icon = Ticker.tick / 20;
			switch(id){
				case 0 : return GunType.gunList.size() == 0 ? new ItemStack(Blocks.WOOL, 1, 4) : new ItemStack(GunType.gunList.get(icon % GunType.gunList.size()).item);
				case 1 : return DriveableType.types.size() == 0 ? new ItemStack(Blocks.WOOL, 1, 14) : new ItemStack(DriveableType.types.get(icon % DriveableType.types.size()).item);
				case 2 : return FlansMod.partItems.size() == 0 ? new ItemStack(Blocks.WOOL, 1, 5) : new ItemStack(FlansMod.partItems.get(icon % FlansMod.partItems.size()));
				case 3 : return new ItemStack(Items.SNOWBALL, 1);
			}
			return /*new ItemStack(Blocks.WOOL, 1, id);*/ new ItemStack(FlansMod.workbench);
		}
	}

}