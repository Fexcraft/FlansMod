package com.flansmod.common.data;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePosition;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityVehicle;

import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleType extends DriveableType {
	
	public float turnLeftModifier = 1F, turnRightModifier = 1F;
	public boolean squashMobs = false;
	public boolean fourWheelDrive = false;
	public boolean rotateWheels = false;
	public boolean tank = false;
	public boolean hasDoor = false;
	//Sounds
	public String start_sound, engine_sound;
	public int start_sound_length, engine_sound_length;

	public VehicleType(String contentpack, String filename, String[] lines){
		super(contentpack, filename, lines);
		//
	}
	
	@Override
	public void preRead(String[] split){
		super.preRead(split);
		wheelPositions = new DriveablePosition[4];
	}
	
	@Override
	protected void read(String[] split){
		super.read(split);
		try{					
			String s = split[0];
			switch(s){
				case "TurnLeftSpeed":
					turnLeftModifier = getFloat(split);
					break;
				case "TurnRightSpeed":
					turnRightModifier = getFloat(split);
					break;
				case "SquashMobs":
					squashMobs = getBoolean(split);
					break;
				case "FourWheelDrive":
					fourWheelDrive = getBoolean(split);
					break;
				case "Tank":
				case "TankMode":
					tank = getBoolean(split);
					break;
				case "HasDoor":
					hasDoor = getBoolean(split);
					break;
				case "RotateWheels":
					rotateWheels = getBoolean(split);
					break;
				case "ShootSound":
					shootSoundPrimary = split[1];
					FlansMod.proxy.loadSound(contentpack, "driveables", split[1]);
					break;
				case "ShellSound":
					shootSoundSecondary = split[1];
					FlansMod.proxy.loadSound(contentpack, "driveables", split[1]);
					break;
				case "DriverTraverseSounds":{
					seats[0].traverseSounds = getBoolean(split);
					break;
				}
				case "PassengerTraverseSounds":{
					seats[Integer.parseInt(split[1])].traverseSounds = Boolean.getBoolean(split[2]);
					break;
				}
				case "StartSoundLength":{
					start_sound_length = this.getInteger(split);
					break;
				}
				case "EngineSoundLength":{
					engine_sound_length = this.getInteger(split);
					break;
				}
				case "YawSoundLength":{
					seats[0].yawSoundLength = getInteger(split);
					break;
				}
				case "PitchSoundLength":{
					seats[0].pitchSoundLength = getInteger(split);
					break;
				}
				case "PassengerYawSoundLength":{
					seats[Integer.parseInt(split[1])].yawSoundLength = Integer.parseInt(split[2]);
					break;
				}
				case "PassengerPitchSoundLength":{
					seats[Integer.parseInt(split[1])].pitchSoundLength = Integer.parseInt(split[2]);
					break;
				}
				case "StartSound":{
					this.start_sound = split[1];
					FlansMod.proxy.loadSound(this.contentpack, "driveables", split[1]);
					break;
				}
				case "EngineSound":{
					this.engine_sound = split[1];
					FlansMod.proxy.loadSound(this.contentpack, "driveables", split[1]);
					break;
				}
				case "YawSound":{
					seats[0].yawSound = split[1];
					FlansMod.proxy.loadSound(this.contentpack, "driveables", split[1]);
					break;
				}
				case "PitchSound":{
					seats[0].pitchSound = split[1];
					FlansMod.proxy.loadSound(this.contentpack, "driveables", split[1]);
					break;
				}
				case "PassengerYawSound":{
					seats[Integer.parseInt(split[1])].yawSound = split[2];
					FlansMod.proxy.loadSound(this.contentpack, "driveables", split[1]);
					break;
				}
				case "PassengerPitchSound":{
					seats[Integer.parseInt(split[1])].pitchSound = split[2];
					FlansMod.proxy.loadSound(this.contentpack, "driveables", split[1]);
					break;
				}
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
	
	@Override
	public void reloadModel(){
		model = FlansMod.proxy.loadModel(modelString, registryname, ModelVehicle.class);
	}
	
	@Override
	public EntityDriveable createDriveable(World world, double x, double y, double z, DriveableData data) {
		return new EntityVehicle(world, x, y, z, this, data);
	}

	public static VehicleType getPlane(String string){
		return (VehicleType)getDriveable(string);
	}

	@Override
	public ResourceLocation getTexture(DriveableData data) {
		if(data.allowURL && data.texture_url != null){
			return ExternalTextureHelper.get(data.texture_url);
		}
		else{
			return textures.get(data.paintjobID);
		}
	}
	
}