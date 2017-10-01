package com.flansmod.common.data;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.flansmod.common.items.ItemPart;
import com.flansmod.common.items.ItemPlane;
import com.flansmod.common.items.ItemUpgrade;
import com.flansmod.common.items.ItemVehicle;
import com.flansmod.common.vector.Vector3f;

import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class DataType implements Comparable<DataType> {
	
	private static final Set<DataType> types = new TreeSet<DataType>();
	private String[] lines;
	protected String filename;
	public String contentpack;
	public String registryname;
	public String name;
	public Item item;
	//
	public int colour = 0xffffff;
	public Object[] recipe;
	public String[] recipeLine;
	public int recipeOutput = 1;
	public boolean shapeless;
	public String smeltableFrom = null;
	public boolean canDrop = true;
	//
	public ArrayList<String> description;
	public ArrayList<ResourceLocation> textures;
	public int def_paintjob = 0;
	public float modelScale = 1F;
	public String modelString;
	@SideOnly(value = Side.CLIENT)
	public ModelBase model;
	
	public DataType(String contentpack, String filename, String[] lines){
		this.contentpack = contentpack;
		this.filename = filename;
		this.lines = lines;
	}
	
	public final void read(){
		ArrayList<String[]> arr = new ArrayList<String[]>();
		for(String s : lines){
			String[] split = s.split(" ");
			if(split.length < 2){
				continue;
			}
			arr.add(split);
		}
		for(String[] split : arr){
			preRead(split);
		}
		for(String[] split : arr){
			read(split);
		}
		for(String[] split : arr){
			postRead(split);
		}
	}

	protected abstract void preRead(String[] s);

	protected void read(String[] split){
		try{
			String s = split[0];
			switch(s){
				case "Model":
					modelString = split[1];
					break;
				case "ModelScale":
					modelScale = getFloat(split);
					break;
				case "Name":
					name = getString(split);
					break;
				case "Description":
					description.add(getString(split));
					break;
				case "ShortName":
				case "RegistryName":
					registryname = getString(split);
					break;
				case "Colour":
				case "Color":
					try{
						colour = (Integer.parseInt(split[1]) << 16) + ((Integer.parseInt(split[2])) << 8) + ((Integer.parseInt(split[3])));
					}
					catch(Exception e){
						exception(e, s);
					}
					break;
				case "RecipeOutput":
					recipeOutput = getInteger(split);
					break;
				case "Recipe":
					//TODO
					break;
				case "ShapelessRecipe":
					//TODO
					break;
				case "SmeltableFrom":
					smeltableFrom = getString(split);
					break;
				case "CanDrop":
					canDrop = getBoolean(split);
					break;
			}
		}
		catch(Exception e){
			Print.log("FFMM", "[READ] Failed to read type file [" + filename + ">" + contentpack + "];");
			e.printStackTrace();
			Static.stop();
		}
	}

	protected abstract void postRead(String[] s);
	
	public final static DataType getType(String s){
		for(DataType type : types){
			if(type.registryname != null && type.registryname.equals(s)){
				return type;
			}
		}
		return null;
	}
	
	public final static Set<DataType> getTypes(){
		return types;
	}
	
	public final static void addType(DataType type){
		types.add(type);
	}
	
	protected float getFloat(String[] split){
		try{
			return Float.parseFloat(split[1]);
		}
		catch(Exception e){
			exception(e, split[0]);
			return 0;
		}
	}
	
	protected String getString(String[] split){
		try{
			String result = split[1];
			for(int i = 0; i < split.length - 2; i++){
				result = result + " " + split[i + 2];
			}
			return result;
		}
		catch(Exception e){
			exception(e, split[0]);
			return "";
		}
	}
	
	protected void exception(Exception e, String s){
		Print.log("FFMM", "Failed to read config line (" + s + ") in [" + filename + ">" + contentpack + "];");
		e.printStackTrace();
		Static.stop();
	}
	
	protected int getInteger(String[] split){
		try{
			return Integer.parseInt(split[1]);
		}
		catch(Exception e){
			exception(e, split[0]);
			return 0;
		}
	}
	
	protected boolean getBoolean(String[] split){
		try{
			return Boolean.parseBoolean(split[1]);
		}
		catch(Exception e){
			exception(e, split[0]);
			return false;
		}
	}
	
	protected Vector3f getVectorF(String[] split, int i){
		try{
			return new Vector3f(Float.parseFloat(split[1 + i]) / 16F, Float.parseFloat(split[2 + i]) / 16F, Float.parseFloat(split[3 + i]) / 16F);
		}
		catch(Exception e){
			exception(e, split[0]);
			return new Vector3f(0, 0, 0);
		}
	}

	protected Vector3f getVectorF(String[] split){
		return getVectorF(split, 0);
	}
	
	protected Vector3f getVectorI(String[] split, int i){
		try{
			return new Vector3f(Integer.parseInt(split[1 + i]) / 16F, Integer.parseInt(split[2 + i]) / 16F, Integer.parseInt(split[3 + i]) / 16F);
		}
		catch(Exception e){
			exception(e, split[0]);
			return new Vector3f(0, 0, 0);
		}
	}
	
	protected RGB parseRGB(String[] split){
		try{
			return new RGB(Float.parseFloat(split[1]) / 16F, Float.parseFloat(split[2]) / 16F, Float.parseFloat(split[3]) / 16F);
		}
		catch(Exception e){
			exception(e, split[0]);
			return new RGB(RGB.WHITE.red, RGB.WHITE.green, RGB.WHITE.blue);
		}
	}
	
	protected Vector3f getVectorI(String[] split){
		return getVectorI(split, 0);
	}
	
	protected Material getMaterial(String[] split){
		return Material.GROUND;
	}

	@SideOnly(Side.CLIENT)
	public ModelBase getModel(){
		return null;
	}

	public void registerItem(){
		if(this instanceof VehicleType){
			item = ItemVehicle.getNew((VehicleType)this);
		}
		else if(this instanceof PlaneType){
			item = ItemPlane.getNew((PlaneType)this);
		}
		else if(this instanceof UpgradeType){
			item = ItemUpgrade.getNew((UpgradeType)this);
		}
		else if(this instanceof PartType){
			item = ItemPart.getNew((PartType)this);
		}
		else{
			Static.exception(4);
		}
	}

	public abstract void reloadModel();
	
	@Override
	public int compareTo(DataType type){
		return filename.compareTo(type.filename);
	}

	public static void removeInvalidTypes() {
		ArrayList<DataType> list = new ArrayList<DataType>();
		for(DataType type : types){
			if(type.item == null){
				list.add(type);
			}
		}
		for(DataType type : list){
			types.remove(type);
		}
	}
	
	protected Pos getPos(String[] split){
		return getPos(split, 0);
	}
	
	protected Pos getPos(String[] split, int i){
		try{
			return new Pos(Float.parseFloat(split[1 + i]), Float.parseFloat(split[2 + i]), Float.parseFloat(split[3 + i]));
		}
		catch(Exception e){
			exception(e, split[0]);
			return new Pos(0, 0, 0);
		}
	}
	
	public abstract ResourceLocation getTexture(DriveableData data);
	
}