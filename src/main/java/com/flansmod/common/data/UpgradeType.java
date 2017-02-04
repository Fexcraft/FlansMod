package com.flansmod.common.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.flansmod.client.model.ModelUpgradePart;
import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UpgradeType extends PartType {
	
	public Map<String, Pos> offset = new HashMap<String, Pos>();
	/** List of compatible Vehicles */
	public ArrayList<String> compatible = new ArrayList<String>();
	/** List of incompatible upgrades */
	public ArrayList<String> incompatible = new ArrayList<String>();
	
	public UpgradeType(String contentpack, String filename, String[] lines){
		super(contentpack, filename, lines);
	}

	@Override
	protected void preRead(String[] split){
		//
	}

	@Override
	protected void read(String[] split){
		super.read(split);
		try{
			String s = split[0];
			switch(s){
				case "CompatibleWith":
					compatible.add(split[1]);
					offset.put(split[1], getPos(split, 1));
					break;
				case "IncompatibleWithUpgrades":
					for(int i = 1; i < split.length; i++){
						incompatible.add(split[i]);
					}
					break;
				default:
					break;
			}
		} 
		catch(Exception e){
			System.out.println("Reading part file failed.");
			e.printStackTrace();
		}
	}

	@Override
	public void postRead(String[] split){
		if(compatible.size() < 0){
			compatible.add("*");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBase getModel(){
		return model;
	}

	@Override
	public void reloadModel(){
		model = FlansMod.proxy.loadModel(modelString, registryname, ModelUpgradePart.class);
		//Static.exception(4);
	}
	
	public static UpgradeType getUpgrade(String s){
		return (UpgradeType)getType(s);
	}
	
	public boolean canInstallUpgrade(DriveableData data){
		for(UpgradeType type : data.upgrades){
			if(type.registryname.equals(this.registryname)){
				return false;
			}
		}
		if(compatible.contains("All") || compatible.contains("*") || compatible.contains("all")){
			return true;
		}
		else{
			if(compatible.contains(data.type)){
				if(incompatible.contains("All") || incompatible.contains("*") || incompatible.contains("all")){
					return false;
				}
				for(UpgradeType type : data.upgrades){
					if(incompatible.contains(type.registryname)){
						return false;
					}
				}
				return true;
			}
			else{
				return false;
			}
		}
	}
	
}