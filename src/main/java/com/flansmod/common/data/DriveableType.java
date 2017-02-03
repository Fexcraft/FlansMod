package com.flansmod.common.data;

import java.util.ArrayList;
import java.util.List;
import com.flansmod.client.model.ModelDriveable;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePosition;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.Seat;
import com.flansmod.common.vector.Vector3f;

import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.math.Vec3f;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class DriveableType {
	
	private static final List<DriveableType> types = new ArrayList<DriveableType>();
	private String[] lines;
	protected String filename;
	public int colour = 0xffffff;
	public String contentpack;
	public Item item;
	//
	public Object[] recipe;
	public String[] recipeLine;
	public int recipeOutput = 1;
	public boolean shapeless;
	public String smeltableFrom = null;
	public boolean canDrop = true;
	//
	public String name;
	public String registryname;
	public ArrayList<String> description;
	public ArrayList<ResourceLocation> textures;
	public int paintjob = 0;
	public float modelScale = 1F;
	public String modelString;
	public int numPassengers = 0;
	public Seat[] seats;
	@SideOnly(value = Side.CLIENT)
	public ModelDriveable model;
	//
	public float maxThrottle = 1F, maxNegativeThrottle = 0F, drag = 1f;
	public boolean canRoll = false;
	public Vector3f turretOrigin = new Vector3f();
	public float turretRotationSpeed = 2.5F;
	public ArrayList<DriveablePosition> collisionPoints = new ArrayList<DriveablePosition>();
	public boolean floatOnWater = false, placeableOnLand = true, placeableOnWater = false;
	public float buoyancy = 0.0165F;
	public DriveablePosition[] wheelPositions = new DriveablePosition[0];
	public float wheelSpringStrength = 0.5F;
	public float wheelStepHeight = 1.0F;
	public boolean harvestBlocks = false;
	public ArrayList<Material> materialsHarvested = new ArrayList<Material>();
	public int numCargoSlots, numBombSlots, numMissileSlots;
	public int fuelTankSize = 100;
	public int animFrames = 0;
	public float bulletDetectionRadius = 5F;
	public float yOffset = 10F / 16F;
	public float cameraDistance = 5F;
	public boolean onRadar = false;
	//
	public String startSound;
	public int startSoundLength;
	public String engineSound;
	public int engineSoundLength;
	public String shootSoundPrimary, shootSoundSecondary;
	//
	
	//Fex's Stuff
	public RGB default_primary_color = RGB.BLUE;
	public RGB default_secondary_color = RGB.GREEN;
	public boolean hasColor;
	public boolean allowURL;
	public boolean hasLock = true;
	public List<Vec3f> cargopos = new ArrayList<Vec3f>();
	//
	
	
	public DriveableType(String contentpack, String filename, String[] lines){
		this.contentpack = contentpack;
		this.filename = filename;
		this.lines = lines;
		this.description = new ArrayList<String>();
		this.textures = new ArrayList<ResourceLocation>();
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
		for(String[] s : arr){
			preRead(s);
		}
		for(String[] s : arr){
			read(s);
		}
		for(String[] s : arr){
			postRead(s);
		}
	}
	
	protected void preRead(String[] split){
		try{
			switch(split[0]){
				case "Passengers":
					numPassengers = getInteger(split);
					seats = new Seat[numPassengers + 1];
					break;
				case "Texture":
					textures.add(new ResourceLocation(FlansMod.MODID, "skins/" + getString(split) + ".png"));
					break;
				case "NumWheels":
					wheelPositions = new DriveablePosition[getInteger(split)];
					break;
				default:
					break;
			}
		}
		catch(Exception e){
			Print.log("FFMM", "[PRE-READ] Failed to read type file [" + filename + ">" + contentpack + "];");
			e.printStackTrace();
			Static.stop();
		}
	}
	
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
				case "Paintjob":
					try{
						textures.add(new ResourceLocation(FlansMod.MODID, "skins/" + getString(split)));
					}
					catch(Exception e){
						exception(e, s);
					}
					break;
				case "MaxThrottle":
					maxThrottle = getFloat(split);
					break;
				case "MaxNegativeThrottle":
					maxNegativeThrottle = getFloat(split);
					break;
				case "Drag":
					drag = getFloat(split);
					break;
				case "TurretOrigin":
					turretOrigin = getVectorF(split);
					break;
				case "TurretRotationSpeed":
					turretRotationSpeed = getFloat(split);
					break;
				case "CanRoll":
					canRoll = getBoolean(split);
					break;
				case "PlaceableOnLand":
					placeableOnLand = getBoolean(split);
					break;
				case "PlaceableOnWater":
					placeableOnWater = getBoolean(split);
					break;
				case "FloatOnWater":
					floatOnWater = getBoolean(split);
					break;
				case "Boat":
					placeableOnLand = false;
					placeableOnWater = true;
					floatOnWater = true;
					wheelStepHeight = 0F;
					break;
				case "Buoyancy":
					buoyancy = getFloat(split);
					break;
				case "Wheel":
				case "WheelPosition":
					try{
						wheelPositions[Integer.parseInt(split[1])] = new DriveablePosition(new Vector3f(Float.parseFloat(split[2]) / 16F, Float.parseFloat(split[3]) / 16F, Float.parseFloat(split[4]) / 16F), split.length > 5 ? EnumDriveablePart.getPart(split[5]) : EnumDriveablePart.coreWheel);
					}
					catch(Exception e){
						exception(e, s);
					}
					break;
				case "WheelRadius":
				case "WheelStepHeight":
					wheelStepHeight = getFloat(split);
					break;
				case "WheelSpringStrength":
				case "SpringStrength":
					wheelSpringStrength = getFloat(split);
					break;
				case "Harvester":
					harvestBlocks = getBoolean(split);
					break;
				case "HarvestMaterial":
					materialsHarvested.add(getMaterial(split));
					break;
				case "HarvestToolType":
					if(split[1] != null){
						switch(split[1]){
							case "Axe":
								materialsHarvested.add(Material.WOOD);
								materialsHarvested.add(Material.PLANTS);
								materialsHarvested.add(Material.VINE);
								break;
							case "Pickaxe":
							case "Drill":
								materialsHarvested.add(Material.IRON);
								materialsHarvested.add(Material.ANVIL);
								materialsHarvested.add(Material.ROCK);
								break;
							case "Spade":
							case "Shovel":
							case "Excavator":
								materialsHarvested.add(Material.GROUND);
								materialsHarvested.add(Material.GRASS);
								materialsHarvested.add(Material.SAND);
								materialsHarvested.add(Material.SNOW);
								materialsHarvested.add(Material.CLAY);
								break;
							case "Hoe":
							case "Combine":
								materialsHarvested.add(Material.PLANTS);
								materialsHarvested.add(Material.LEAVES);
								materialsHarvested.add(Material.VINE);
								materialsHarvested.add(Material.CACTUS);
								materialsHarvested.add(Material.GOURD);
								break;
						}
					}
				case "CargoSlots":
					numCargoSlots = getInteger(split);
					break;
				case "BombSlots":
				case "MineSlots":
					numBombSlots = getInteger(split);
					break;
				case "MissileSlots":
				case "ShellSlots":
					numMissileSlots = getInteger(split);
					break;
				case "FuelTankSize":
					fuelTankSize = getInteger(split);
					break;
				case "TrackFrames":
					try{
						animFrames = Integer.parseInt(split[1])-1;
					}
					catch(Exception e){
						exception(e, s);
					}
					break;
				case "BulletDetection":
					bulletDetectionRadius = getInteger(split);
					break;
				case "AddRecipeParts":
					//TODO
					break;
				case "AddDye":
					//TODO
					break;
				case "SetupPart":
					//TODO
					break;
				case "Driver":
				case "Pilot":
					try{
						if(split.length > 4){
							seats[0] = new Seat(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6]), Float.parseFloat(split[7]));
						}
						else{
							seats[0] = new Seat(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
						}
					}
					catch(Exception e){
						exception(e, s);
					}
					break;
				case "RotatedDriverOffset":
					seats[0].rotatedOffset = getVectorI(split);
					break;
				case "DriverAimSpeed":
					seats[0].aimingSpeed = getVectorF(split);
					break;
				case "RotatedPassengerOffset":
					seats[Integer.parseInt(split[1])].rotatedOffset = getVectorI(split, 1);
					break;
				case "PassengerAimSpeed":
					seats[Integer.parseInt(split[1])].aimingSpeed = getVectorF(split, 1);
					break;
				case "DriverLegacyAiming":
					seats[0].legacyAiming = getBoolean(split);
					break;
				case "PassengerLegacyAiming":
					seats[Integer.parseInt(split[1])].legacyAiming = Boolean.parseBoolean(split[2]);
					break;
				case "DriverYawBeforePitch":
					seats[0].yawBeforePitch = getBoolean(split);
					break;
				case "PassengerYawBeforePitch":
					seats[Integer.parseInt(split[1])].yawBeforePitch = Boolean.parseBoolean(split[2]);
					break;
				case "DriverLatePitch":
					seats[0].latePitch = getBoolean(split);
					break;
				case "PassengerLatePitch":
					seats[Integer.parseInt(split[1])].latePitch = Boolean.parseBoolean(split[2]);
					break;
				case "DriverTraverseSounds":
					seats[0].traverseSounds = getBoolean(split);
					break;
				case "PassengerTraverseSounds":
					seats[Integer.parseInt(split[1])].traverseSounds = Boolean.parseBoolean(split[2]);
					break;
				case "Passenger":
					Seat seat = new Seat(split);
					seats[seat.id] = seat;
					break;
				case "GunOrigin":
					seats[Integer.parseInt(split[1])].gunOrigin = getVectorF(split, 1);
					break;
				case "YOffset":
					yOffset = getFloat(split);
					break;
				case "CameraDistance":
					cameraDistance = getFloat(split);
					break;
				case "StartSoundLength":
					startSoundLength = getInteger(split);
					break;
				case "EngineSoundLength":
					engineSoundLength = getInteger(split);
					break;
				case "YawSoundLength":
					seats[0].yawSoundLength = getInteger(split);
					break;
				case "PitchSoundLength":
					seats[0].pitchSoundLength = getInteger(split);
					break;
				case "PassengerYawSoundLength":
					seats[Integer.parseInt(split[1])].yawSoundLength = Integer.parseInt(split[2]);
					break;
				case "PassengerPitchSoundLength":
					seats[Integer.parseInt(split[1])].pitchSoundLength = Integer.parseInt(split[2]);
					break;
				case "StartSound":
					startSound = split[1];
					FlansMod.proxy.loadSound(contentpack, "driveables", split[1]);
					break;
				case "EngineSound":
					engineSound = split[1];
					FlansMod.proxy.loadSound(contentpack, "driveables", split[1]);
					break;
				case "YawSound":
					seats[0].yawSound = split[1];
					FlansMod.proxy.loadSound(contentpack, "driveables", split[1]);
					break;
				case "PitchSound":
					seats[0].pitchSound = split[1];
					FlansMod.proxy.loadSound(contentpack, "driveables", split[1]);
					break;
				case "PassengerYawSound":
					seats[Integer.parseInt(split[1])].yawSound = split[2];
					FlansMod.proxy.loadSound(contentpack, "driveables", split[1]);
					break;
				case "PassengerPitchSound":
					seats[Integer.parseInt(split[1])].pitchSound = split[2];
					FlansMod.proxy.loadSound(contentpack, "driveables", split[1]);
					break;
				case "OnRadar":
					onRadar = getBoolean(split);
					break;
				case "AddParticle":
				case "AddEmitter":
					//TODO
					break;
				case "EnableRGB":
					hasColor = getBoolean(split);
					break;
				case "DefaultPrimaryRGB":
					default_primary_color = parseRGB(split);
					hasColor = true;
					break;
				case "DefaultSecondaryRGB":
					default_secondary_color = parseRGB(split);
					hasColor = true;
					break;
				case "AllowRemoteTextures":
				case "AllowURLTextures":
				case "AllowTexturesFromURL":
					allowURL = getBoolean(split);
					break;
				case "HasLock":
					hasLock = getBoolean(split);
					break;
				case "AddCargoRenderPos":
					cargopos.add(new Vec3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])));
					break;
				default:
					break;
			}
		}
		catch(Exception e){
			Print.log("FFMM", "[READ] Failed to read type file [" + filename + ">" + contentpack + "];");
			e.printStackTrace();
			Static.stop();
		}
	}

	private void postRead(String[] split){
		try{
			String s = split[0];
			switch(s){
				case "Model":
					if(Static.side().isClient()){
						model = FlansMod.proxy.loadModel(split[1], registryname, ModelDriveable.class);
					}
					break;
				default:
					break;
			}
		}
		catch(Exception e){
			Print.log("FFMM", "[PRE-READ] Failed to read type file [" + filename + ">" + contentpack + "];");
			e.printStackTrace();
			Static.stop();
		}
	}

	@Override
	public String toString(){
		return super.getClass().getSimpleName() + ": " + registryname;
	}
	
	public void reloadModel(){
		
	}
	
	public static DriveableType getType(String s){
		for(DriveableType type : types){
			if(type.registryname.equals(s)){
				return type;
			}
		}
		return null;
	}
	
	public DriveableType getType(ItemStack stack){
		if(stack.hasTagCompound()){
			if(stack.getTagCompound().hasKey("DriveableType")){
				return getType(stack.getTagCompound().getString("DriveableType"));
			}
		}
		return null;
	}
	
	float getFloat(String[] split){
		try{
			return Float.parseFloat(split[1]);
		}
		catch(Exception e){
			exception(e, split[0]);
			return 0;
		}
	}
	
	String getString(String[] split){
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
	
	private void exception(Exception e, String s){
		Print.log("FFMM", "Failed to read config line (" + s + ") in [" + filename + ">" + contentpack + "];");
		e.printStackTrace();
		Static.stop();
	}
	
	int getInteger(String[] split){
		try{
			return Integer.parseInt(split[1]);
		}
		catch(Exception e){
			exception(e, split[0]);
			return 0;
		}
	}
	
	boolean getBoolean(String[] split){
		try{
			return Boolean.parseBoolean(split[1]);
		}
		catch(Exception e){
			exception(e, split[0]);
			return false;
		}
	}
	
	Vector3f getVectorF(String[] split, int i){
		try{
			return new Vector3f(Float.parseFloat(split[1 + i]) / 16F, Float.parseFloat(split[2 + i]) / 16F, Float.parseFloat(split[3 + i]) / 16F);
		}
		catch(Exception e){
			exception(e, split[0]);
			return new Vector3f(0, 0, 0);
		}
	}

	private Vector3f getVectorF(String[] split){
		return getVectorF(split, 0);
	}
	
	Vector3f getVectorI(String[] split, int i){
		try{
			return new Vector3f(Integer.parseInt(split[1 + i]) / 16F, Integer.parseInt(split[2 + i]) / 16F, Integer.parseInt(split[3 + i]) / 16F);
		}
		catch(Exception e){
			exception(e, split[0]);
			return new Vector3f(0, 0, 0);
		}
	}
	
	RGB parseRGB(String[] split){
		try{
			return new RGB(Float.parseFloat(split[1]) / 16F, Float.parseFloat(split[2]) / 16F, Float.parseFloat(split[3]) / 16F);
		}
		catch(Exception e){
			exception(e, split[0]);
			return new RGB(RGB.WHITE.red, RGB.WHITE.green, RGB.WHITE.blue);
		}
	}
	
	private Vector3f getVectorI(String[] split){
		return getVectorI(split, 0);
	}
	
	private Material getMaterial(String[] split){
		return Material.GROUND;
	}
	
	public static List<DriveableType> getTypes(){
		return types;
	}

	public static DriveableType getDriveable(String string){
		return getType(string);
	}

	public static void addType(DriveableType type){
		types.add(type);
	}

	public abstract EntityDriveable createDriveable(World world, double x, double y, double z, DriveableData data);
	
}