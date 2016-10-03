package com.flansmod.common.guns;

import net.minecraft.item.ItemStack;

public class Paintjob 
{
	public final String name;
	public final String iconPath;
	public final String texturePath;
	public ItemStack[] dyesNeeded;
	public int ID;
	
	public Paintjob(int id, String name, String iconPath, String texturePath, ItemStack[] dyesNeeded)
	{
		this.ID = id;
		this.name = name;
		this.iconPath = iconPath;
		this.texturePath = texturePath;
		this.dyesNeeded = dyesNeeded;
	}
}
