package com.flansmod.common.util.fni;
//package net.fexcraft.mod.lib.util.math;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

/**
 * 
 * @author Ferdinand (FEX___96)
 * Copy from FCL
 * LICENSED UNDER FCL LICENSE;
 * Included into this version of Flansmod due to being a backport.
 *
 */
public class Pos{
	
	public float x, y, z;
	
	public Pos(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Pos(float[] pos){
		try{
			x = pos[0];
			y = pos[1];
			z = pos[2];
		}
		catch(Exception e){
			x = y = z = 0;
		}
	}
	
	public Pos copy(){
		return new Pos(x, y, z);
	}
	
	public Pos clone(){
		return copy();
	}
	
	@Override
	public String toString(){
		return "[" + x + "," + y + "," + z + "]";
	}
	
	public float to16FloatX(){
		return 0.0625f * x;
	}
	
	public float to16FloatY(){
		return 0.0625f * y;
	}
	
	public float to16FloatZ(){
		return 0.0625f * z;
	}

	public static Pos fromJSON(JsonObject obj){
		float x = obj.get("x").getAsFloat();
		float y = obj.get("y").getAsFloat();
		float z = obj.get("z").getAsFloat();
		return new Pos(x, y, z);
	}

	public JsonObject toJSON(){
		JsonObject obj = new JsonObject();
		obj.addProperty("x", x);
		obj.addProperty("y", y);
		obj.addProperty("z", z);
		return obj;
	}

	public void translate(){
		GL11.glTranslatef(x == 0 ? 0 : this.to16FloatX(), y == 0 ? 0 : this.to16FloatY(), z == 0 ? 0 : this.to16FloatZ());
	}
	
	public void translateR(){
		GL11.glTranslatef(x == 0 ? 0 : -this.to16FloatX(), y == 0 ? 0 : -this.to16FloatY(), z == 0 ? 0 : -this.to16FloatZ());
	}
	
}