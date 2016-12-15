package com.flansmod.common.data.player;

import net.minecraft.nbt.NBTTagCompound;

public class PlayerData implements IPlayerData {
	
	private String texture_url;

	@Override
	public void read(NBTTagCompound nbt){
		texture_url = nbt.getString("texture_url");
	}

	@Override
	public NBTTagCompound write(){
		//
		return null;
	}

	@Override
	public void copy(IPlayerData data) {
		texture_url = data.getTextureURL();
	}

	@Override
	public String getTextureURL(){
		return texture_url;
	}

	@Override
	public void setTextureURL(String s) {
		texture_url = s;
	}
	
}