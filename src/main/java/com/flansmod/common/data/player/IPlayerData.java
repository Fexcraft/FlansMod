package com.flansmod.common.data.player;

import net.minecraft.nbt.NBTTagCompound;

public interface IPlayerData {
	
	public void read(NBTTagCompound nbt);
	
	public NBTTagCompound write();
	
	public void copy(IPlayerData data);
	
	public String getTextureURL();
	
	public void setTextureURL(String s);
	
}