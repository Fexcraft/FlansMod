package com.flansmod.common.data;

import java.util.ArrayList;

import com.flansmod.client.model.ModelPlane;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.EnumPlaneMode;
import com.flansmod.common.driveables.Propeller;
import com.flansmod.common.vector.Vector3f;

import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.world.World;

public class PlaneType extends DriveableType {
	
	public EnumPlaneMode mode = EnumPlaneMode.PLANE;	
	public float lookDownModifier = 1F, lookUpModifier = 1F;
	public float rollLeftModifier = 1F, rollRightModifier = 1F;
	public float turnLeftModifier = 1F, turnRightModifier = 1F;
	public float lift = 1F;
	public Vector3f bombPosition;
	public int planeShootDelay;
	public int planeBombDelay;
	public ArrayList<Propeller> propellers = new ArrayList<Propeller>();
	public ArrayList<Propeller> heliPropellers = new ArrayList<Propeller>(), heliTailPropellers = new ArrayList<Propeller>();
	public boolean hasGear = false, hasDoor = false, hasWing = false;
	public float restingPitch = 0F;
	public boolean invInflight = true;

	public PlaneType(String contentpack, String filename, String[] lines){
		super(contentpack, filename, lines);
		//
	}
	
	@Override
	public void preRead(String[] split){
		super.preRead(split);
	}
	
	@Override
	protected void read(String[] split){
		super.read(split);
		try{					
			String s = split[0];
			switch(s){
				case "Mode":
					mode = EnumPlaneMode.getMode(getString(split));
					break;
				case "TurnLeftSpeed":
					turnLeftModifier = getFloat(split);
					break;
				case "TurnRightSpeed":
					turnRightModifier = getFloat(split);
					break;
				case "LookUpSpeed":
					lookUpModifier = getFloat(split);
					break;
				case "LookDownSpeed":
					lookDownModifier = getFloat(split);
					break;
				case "RollLeftSpeed":
					rollLeftModifier = getFloat(split);
					break;
				case "RollRightSpeed":
					rollRightModifier = getFloat(split);
					break;
				case "Lift":
					lift = getFloat(split);
					break;
				case "ShootDelay":
					planeShootDelay = getInteger(split);
					break;
				case "BombDelay":
					planeBombDelay = getInteger(split);
					break;
				case "Propeller":
					Propeller propellerp = new Propeller(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), EnumDriveablePart.getPart(split[5]), PartType.getPart(split[6]));
					propellers.add(propellerp);
					break;
				case "HeliPropeller":
					Propeller propellerh = new Propeller(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), EnumDriveablePart.getPart(split[5]), PartType.getPart(split[6]));
					heliPropellers.add(propellerh);
					break;
				case "HeliTailPropeller":
					Propeller propellerht = new Propeller(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), EnumDriveablePart.getPart(split[5]), PartType.getPart(split[6]));
					heliTailPropellers.add(propellerht);
					break;
				case "PropSoundLength":
					engineSoundLength = getInteger(split);
					break;
				case "PropSound":
					engineSound = getString(split);
					FlansMod.proxy.loadSound(contentpack, "driveables", getString(split));
					break;
				case "ShootSound":
					shootSoundPrimary = getString(split);
					FlansMod.proxy.loadSound(contentpack, "driveables", getString(split));
					break;
				case "BombSound":
					shootSoundSecondary = getString(split);
					FlansMod.proxy.loadSound(contentpack, "driveables", getString(split));
					break;
				case "HasGear":
					hasGear = getBoolean(split);
					break;
				case "HasDoor":
					hasDoor = getBoolean(split);
					break;
				case "HasWing":
					hasWing = getBoolean(split);
					break;
				case "RestingPitch":
					restingPitch = getFloat(split);
					break;
				case "InflightInventory":
					invInflight = !getBoolean(split);
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
	
	@Override
	public void reloadModel(){
		model = FlansMod.proxy.loadModel(modelString, registryname, ModelPlane.class);
	}
	
	@Override
	public EntityDriveable createDriveable(World world, double x, double y, double z, DriveableData data) {
		return new EntityPlane(world, x, y, z, this, data);
	}
	
	public int numEngines(){
		switch(mode){
			case VTOL:
				return Math.max(propellers.size(), heliPropellers.size());
			case PLANE:
				return propellers.size();
			case HELI:
				return heliPropellers.size();
			default:
				return 1;
		}
	}

	public static PlaneType getPlane(String string){
		return (PlaneType)getDriveable(string);
	}
	
}