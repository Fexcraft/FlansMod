package com.flansmod.common.data;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePosition;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityVehicle;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.world.World;

public class VehicleType extends DriveableType {
	
	public float turnLeftModifier = 1F, turnRightModifier = 1F;
	public boolean squashMobs = false;
	public boolean fourWheelDrive = false;
	public boolean rotateWheels = false;
	public boolean tank = false;
	public boolean hasDoor = false;

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
	
	public void reloadModel(){
		model = FlansMod.proxy.loadModel(modelString, registryname, ModelVehicle.class);
	}
	
	@Override
	public EntityDriveable createDriveable(World world, double x, double y, double z, DriveableData data) {
		return new EntityVehicle(world, x, y, z, this, data);
	}
	
}