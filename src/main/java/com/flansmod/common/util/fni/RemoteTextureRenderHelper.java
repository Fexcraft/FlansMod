package com.flansmod.common.util.fni;
//package net.fexcraft.mod.lib.util.render;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;

/**
 * 
 * @author Ferdinand (FEX___96)
 * Copy from FCL
 * LICENSED UNDER FCL LICENSE;
 * Included into this version of Flansmod due to being a backport.
 *
 */
public class RemoteTextureRenderHelper {
	
	private static final Map<String, ResourceLocation> map = new HashMap<String, ResourceLocation>();
	private static final Map<String, ResourceLocation> tempmap = new HashMap<String, ResourceLocation>();
	
	public static ResourceLocation get(String s){
		if(map.containsKey(s)){
			return map.get(s);
		}
		ResourceLocation texture = new ResourceLocation("fcl:remote/" + s);
		ITextureObject object = Minecraft.getMinecraft().renderEngine.getTexture(texture);
        if(object == null){
    		ThreadDownloadImageData tdid = new ThreadDownloadImageData((File)null, s, null, null);
        	object = tdid;
        	Minecraft.getMinecraft().renderEngine.loadTexture(texture, object);
        }
        map.put(s, texture);
		return texture;
	}
	
	public static ResourceLocation getTemp(String s){
		if(tempmap.containsKey(s)){
			return tempmap.get(s);
		}
		ResourceLocation texture = new ResourceLocation("fcl:remote/" + s);
		ITextureObject object = Minecraft.getMinecraft().renderEngine.getTexture(texture);
        if(object == null){
    		ThreadDownloadImageData tdid = new ThreadDownloadImageData((File)null, s, null, null);
        	object = tdid;
        	Minecraft.getMinecraft().renderEngine.loadTexture(texture, object);
        }
        tempmap.put(s, texture);
		return texture;
	}
	
}