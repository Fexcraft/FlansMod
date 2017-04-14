package com.flansmod.common.util.fni;
//package net.fexcraft.mod.lib.util.render;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


/**
 * 
 * @author Ferdinand (FEX___96)
 * Copy from FCL
 * LICENSED UNDER FCL LICENSE;
 * Included into this version of Flansmod due to being a backport.
 *
 */
public class RGB {
	
	public float red, green, blue;
	
	public RGB(){
		copyFrom(WHITE);
	}
	
	public RGB(float r, float g, float b){
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	
	public RGB(float[] f){
		try{
			this.red = f[0];
			this.green= f[1];
			this.blue = f[2];
		}
		catch(Exception e){
			copyFrom(WHITE);
		}
	}
	
	public RGB(int r, int g, int b){
		this.red = fromInt(r);
		this.green = fromInt(g);
		this.blue = fromInt(b);
	}
	
	public RGB(RGB rgb){
		this.red = rgb.red;
		this.blue = rgb.blue;
		this.green = rgb.green;
	}
	
	@SideOnly(Side.CLIENT)
	public void glColorApply(){
		org.lwjgl.opengl.GL11.glColor3f(red, green, blue);
	}
	
	@SideOnly(Side.CLIENT)
	public final static void glColorReset(){
		org.lwjgl.opengl.GL11.glColor3f(1F, 1F, 1F);
	}
	
	public static final RGB RED   = new RGB(1f, 0f, 0f);
	public static final RGB GREEN = new RGB(0f, 1f, 0f);
	public static final RGB BLUE  = new RGB(0f, 0f, 1f);
	public static final RGB BLACK = new RGB(0f, 0f, 0f);
	public static final RGB WHITE = new RGB(1f, 1f, 1f);
	
	public void fromDyeColor(EnumDyeColor e){
		switch(e){
			case BLACK:
				setAll(0.098f);
				break;
			case BLUE:
				set(0, 0.2f);
				set(1, 0.298f);
				set(2, 0.698f);
				break;
			case BROWN:
				set(0, 0.4f);
				set(1, 0.298f);
				set(2, 0.2f);
				break;
			case CYAN:
				set(0, 0.298f);
				set(1, 0.498f);
				set(2, 0.6f);
				break;
			case GRAY:
				setAll(0.298f);
				break;
			case GREEN:
				set(0, 0.4f);
				set(1, 0.498f);
				set(2, 0.2f);
				break;
			case LIGHT_BLUE:
				set(0, 0.4f);
				set(1, 0.6f);
				set(2, 0.847f);
				break;
			case LIME:
				set(0, 0.498f);
				set(1, 0.8f);
				set(2, 0.098f);
				break;
			case MAGENTA:
				set(0, 0.698f);
				set(1, 0.298f);
				set(2, 0.847f);
				break;
			case ORANGE:
				set(0, 0.847f);
				set(1, 0.498f);
				set(2, 0.2f);
				break;
			case PINK:
				set(0, 0.949f);
				set(1, 0.498f);
				set(2, 0.647f);
				break;
			case PURPLE:
				set(0, 0.498f);
				set(1, 0.247f);
				set(2, 0.698f);
				break;
			case RED:
				set(0, 0.6f);
				set(1, 0.2f);
				set(2, 0.2f);
				break;
			case SILVER:
				setAll(0.6f);
				break;
			case WHITE:
				setAll(1f);
				break;
			case YELLOW:
				set(0, 0.898f);
				set(1, 0.898f);
				set(2, 0.2f);
				break;
			default:
				break;
		}
	}

	public void add(int i, double d) {
		switch(i){
			case 0:
				red += d;
				if(red > 1f){
					red -= 1f;
				}
				if(red <= 0){
					red = 0;
				}
				break;
			case 1:
				green += d;
				if(green > 1f){
					green -= 1f;
				}
				if(green <= 0){
					green = 0;
				}
				break;
			case 2:
				blue += d;
				if(blue > 1f){
					blue -= 1f;
				}
				if(blue <= 0){
					blue = 0;
				}
				break;
			default:
				Print.spam(1, "[RGB] Invalid ID.");
				break;
		}
	}

	public void addAll(double d) {
		add(0, d); add(1, d); add(2, d);
	}
	
	public void set(int i, float d) {
		switch(i){
			case 0:
				red = d;
				break;
			case 1:
				green = d;
				break;
			case 2:
				blue = d;
				break;
			default:
				Print.spam(1, "[RGB] Invalid ID.");
				break;
		}
	}
	
	public void setAll(float f){
		set(0, f); set(1, f); set(2, f);
	}
	
	private void set(RGB rgb) {
		red = rgb.red;
		green = rgb.green;
		blue = rgb.blue;
	}

	/**
	 * @param a additional name data to append into the nbt tag key
	 */
	public NBTTagCompound writeToNBT(NBTTagCompound tag, String a){
		try{
			String s = a == null ? "" : "_" + a;
			tag.setFloat("RGB_Red" + s, red);
			tag.setFloat("RGB_Green" + s, green);
			tag.setFloat("RGB_Blue" + s, blue);
			return tag;
		}
		catch(Exception e){
			e.printStackTrace();
			return tag;
		}
	}
	
	/**
	 * @param tag additional name data to retrieve the right nbt key.
	 */
	public void readFromNBT(NBTTagCompound tag, String a) {
		try{
			String s = a == null ? "" : "_" + a;
			red = tag.getFloat("RGB_Red" + s);
			green = tag.getFloat("RGB_Green" + s);
			blue = tag.getFloat("RGB_Blue" + s);
		}
		catch(Exception e){
			e.printStackTrace();
			copyFrom(WHITE);
		}
	}

	public void copyFrom(RGB color) {
		red = color.red;
		green = color.green;
		blue = color.blue;
	}
	
	@Override
	public String toString(){
		return "[" + red + ":" + green + ":" + blue + "]";
	}

	public static RGB fromJSON(JsonObject object, boolean write){
		RGB rgb = new RGB();
		String[] red = {"Red", "red", "r", "R"};
		String[] blue = {"Blue", "blue", "b", "B"};
		String[] green = {"Green", "green", "g", "G"};
		rgb.red = getFJO(red, object, write, 0);
		rgb.blue = getFJO(blue, object, write, 0);
		rgb.green = getFJO(green, object, write, 0);
		return rgb;
	}

	public JsonElement toJSON(){
		JsonObject obj = new JsonObject();
		obj.addProperty("Red", red);
		obj.addProperty("Blue", blue);
		obj.addProperty("Green", green);
		return obj;
	}
	
	private static final float getFJO(String[] strings, JsonObject obj, boolean write, int i){
		for(String s : strings){
			if(obj.has(s)){
				return obj.get(s).getAsFloat();
			}
		}
		if(write){
			obj.addProperty(strings[i], 1f);
		}
		return 0f;
	}
	
	public static RGB fromUnknown(String x, String y, String z){
		try{
			return fromUnknown(Float.parseFloat(x), Float.parseFloat(y), Float.parseFloat(z));
		}
		catch(Exception e){
			return new RGB();
		}
	}
	
	public static RGB fromUnknown(float x, float y, float z){
		float[] f = new float[3];
		if(x % 1 != 0){
			f[0] = truncate(x);
		}
		else{
			f[0] = fromInt(x);
		}
		//
		if(y % 1 != 0){
			f[1] = truncate(y);
		}
		else{
			f[1] = fromInt(y);
		}
		//
		if(z % 1 != 0){
			f[2] = truncate(z);
		}
		else{
			f[2] = fromInt(z);
		}
		return new RGB(f);
	}
	
	private static final DecimalFormat df = new DecimalFormat("##.#####");
	
	private static final float truncate(float f){
		df.setRoundingMode(RoundingMode.DOWN);
		String s = df.format(f);
		return Float.parseFloat(s);
	}
	
	private static final float fromInt(Number number){
		return truncate(number.intValue() / 255f);
	}
	
}