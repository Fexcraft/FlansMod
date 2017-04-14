package com.flansmod.common.util;

import java.io.File;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;

public class Config {
	
	private static Configuration config;
	public  static JsonObject object;
	private static File file;
	
	public static boolean addGunpowderRecipe = true;
	public static boolean addAllPaintjobsToCreative = false;
	
	public static boolean explosions, vehiclesBreakBlocks, vehiclesNeedFuel, canBreakGuns, canBreakGlass;
	public static boolean bombsEnabled, bulletsEnabled, shellsEnabled, forceAdventureMode, overrideHunger;
	public static int weaponDrops, planeLife, vehicleLife, maxVehicleKeys;
	
	public static final float soundRange = 50F;
	public static final float driveableUpdateRange = 200F;
	public static final int numPlayerSnapshots = 20;
	
	public static void initalize(Configuration configuration, File folder) {
		config = configuration;
		config.load();
		addGunpowderRecipe = config.getBoolean("Gunpowder Recipe", Configuration.CATEGORY_GENERAL, addGunpowderRecipe, "Whether or not to add the extra gunpowder recipe (3 charcoal + 1 lightstone)");
		addAllPaintjobsToCreative = config.getBoolean("Add All Paintjobs to Creative", Configuration.CATEGORY_GENERAL, addAllPaintjobsToCreative, "Whether all paintjobs should appear in creative");
		
		config.save();
		
		
		file = new File(folder, "/FlansModMinus.cfg");
		object = JsonUtil.get(file);
		explosions = JsonUtil.getIfExists(object, "explosions", true);
		vehiclesBreakBlocks = JsonUtil.getIfExists(object, "vehiclesBreakBlocks", true);
		bombsEnabled = JsonUtil.getIfExists(object, "bombsEnabled", true);
		bulletsEnabled = JsonUtil.getIfExists(object, "bulletsEnabled", true);
		shellsEnabled = JsonUtil.getIfExists(object, "shellsEnabled", true);
		forceAdventureMode = JsonUtil.getIfExists(object, "forceAdventureMode", false);
		overrideHunger = JsonUtil.getIfExists(object, "overrideHunger", false);
		canBreakGuns = JsonUtil.getIfExists(object, "canBreakGuns", true);
		canBreakGlass = JsonUtil.getIfExists(object, "canBreakGlass", true);
		weaponDrops = JsonUtil.getIfExists(object, "weaponDrops", 1).intValue();
		vehiclesNeedFuel = JsonUtil.getIfExists(object, "vehiclesNeedFuel", true);
		planeLife = JsonUtil.getIfExists(object, "planeLife", 0).intValue();
		vehicleLife = JsonUtil.getIfExists(object, "vehicleLife", 0).intValue();
		maxVehicleKeys = JsonUtil.getIfExists(object, "maxVehicleKeys", 3).intValue();
		JsonUtil.write(file, object);
	}


	public static Configuration getInstance(){
		return config;
	}
	
	public static JsonObject getObject(){
		return object;
	}
	
	public static void save(){
		if(config.hasChanged()){
			config.save();
		}
		JsonUtil.write(file, object);
		Util.log("Config Saved.");
	}


	public static TargetPoint getTargetPoint(Entity entity){
		return new TargetPoint(entity.dimension, entity.posX, entity.posY, entity.posZ, driveableUpdateRange);
	}
	
}