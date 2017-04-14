package com.flansmod.common.data;

import com.flansmod.common.data.PlaneType;
import com.flansmod.common.data.VehicleType;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.items.ItemPart;
import com.flansmod.common.items.ItemPlane;
import com.flansmod.common.items.ItemVehicle;

public enum EnumType {
	
	part("parts"), upgrade("upgrades"), vehicle("vehicles"), plane("planes");
	
	public String folderName;
	
	private EnumType(String s){
		folderName = s;
	}
	
	public static final EnumType get(String s){
		for(EnumType type : values()){
			if(type.folderName.equals(s)){
				return type;
			}
		}
		return null;
	}

	public static EnumType getFromObject(Object o){
		if(o instanceof PlaneType 			|| o instanceof ItemPlane 		|| o instanceof EntityPlane) 	return plane;
		if(o instanceof VehicleType			|| o instanceof ItemVehicle 	|| o instanceof EntityVehicle) 	return vehicle;
		if(o instanceof PartType  			|| o instanceof ItemPart) 										return part;
		if(o instanceof UpgradeType         /*|| o instanceof ItemUpgrade*/)                                return upgrade;
		return null;
	}

	public DataType getDataType(String string, String string2, String[] arr){
		switch(this){
			case part:
				return new PartType(string, string2, arr);
			case plane:
				return new PlaneType(string, string2, arr);
			case vehicle:
				return new VehicleType(string, string2, arr);
			case upgrade:
				return new UpgradeType(string, string2, arr);
			default:
				return null;
		}
	}
	
}
