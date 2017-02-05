package com.flansmod.common.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PartType extends DataType {
	
	public EnumPartCategory category;
	public int stackSize;
	public float engineSpeed = 1.0F;
	public float fuelConsumption = 1.0F;
	public int fuel = 0;
	public List<EnumType> worksWith = Arrays.asList(EnumType.plane, EnumType.vehicle);
	public boolean isAIChip = false;
	public boolean canBeDefaultEngine = true;
	public ArrayList<ItemStack> partBoxRecipe = new ArrayList<ItemStack>();
	public boolean useRFPower = false;
	public int RFDrawRate = 1;
	public static HashMap<EnumType, PartType> defaultEngines = new HashMap<EnumType, PartType>();
	public static List<PartType> parts = new ArrayList<PartType>();
	public static HashMap<EnumPartCategory, ArrayList<PartType>> partsByCategory = new HashMap<EnumPartCategory, ArrayList<PartType>>();
	static{
		for(EnumPartCategory cat : EnumPartCategory.values()){
			partsByCategory.put(cat, new ArrayList<PartType>());
		}
	}
	
	public PartType(String contentpack, String filename, String[] lines){
		super(contentpack, filename, lines);
		this.description = new ArrayList<String>();
	}

	@Override
	protected void preRead(String[] split){
		
	}

	@Override
	protected void read(String[] split){
		super.read(split);
		try{
			String s = split[0];
			switch(s){
				case "Category":
					category = getCategory(getString(split));
					break;
				case "StackSize":
					stackSize = getInteger(split);
					break;
				case "EngineSpeed":
					engineSpeed = getFloat(split);
					break;
				case "FuelConsumption":
					fuelConsumption = getFloat(split);
					break;
				case "Fuel":
					fuel = getInteger(split);
					break;
				case "PartBoxRecipe":
					/*ItemStack[] stacks = new ItemStack[(split.length - 2) / 2];
					for(int i = 0; i < (split.length - 2) / 2; i++){
						int amount = Integer.parseInt(split[2 * i + 2]);
						boolean damaged = split[2 * i + 3].contains(".");
						String itemName = damaged ? split[2 * i + 3].split("\\.")[0] : split[2 * i + 3];
						int damage = damaged ? Integer.parseInt(split[2 * i + 3].split("\\.")[1]) : 0;
						stacks[i] = getRecipeElement(itemName, amount, damage, registryname);
					}
					partBoxRecipe.addAll(Arrays.asList(stacks));*/
					break;
				case "WorksWith":
					worksWith = new ArrayList<EnumType>();
					for(int i = 0; i < split.length - 1; i++){
						worksWith.add(EnumType.get(split[i + 1]));
					}
					break;
				case "UseRF":
				case "UseRFPower":
					useRFPower = getBoolean(split);
					break;
				case "RFDrawRate":
					RFDrawRate = getInteger(split);
					break;
				case "IsAIChip":
					isAIChip = getBoolean(split);
					break;
				case "CanBeDefaultEngine":
					canBeDefaultEngine = getBoolean(split);
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
		if(category == EnumPartCategory.ENGINE && !useRFPower && canBeDefaultEngine){
			for(EnumType type : worksWith){
				if(defaultEngines.containsKey(type)){
					PartType possiblyInferiorEngine = defaultEngines.get(type);
					if(isInferiorEngine(possiblyInferiorEngine)){
						defaultEngines.put(type, this);
					}
				}
				else defaultEngines.put(type, this);
			}
		}
		partsByCategory.get(category).add(this);
	}
	
	public boolean isInferiorEngine(PartType quitePossiblyAnInferiorEngine){
		return engineSpeed > quitePossiblyAnInferiorEngine.engineSpeed;
	}

	public static PartType getPart(String s){
		for(PartType part : parts){
			if(part.registryname.equals(s)){
				return part;
			}
		}
		return null;
	}

	private EnumPartCategory getCategory(String s) {
		if(s.equals("Cockpit"))
			return EnumPartCategory.COCKPIT;
		if(s.equals("Wing"))
			return EnumPartCategory.WING;
		if(s.equals("Engine"))
			return EnumPartCategory.ENGINE;
		if(s.equals("Propeller"))
			return EnumPartCategory.PROPELLER;
		if(s.equals("Bay"))
			return EnumPartCategory.BAY;
		if(s.equals("Tail"))
			return EnumPartCategory.TAIL;
		if(s.equals("Wheel"))
			return EnumPartCategory.WHEEL;
		if(s.equals("Chassis"))
			return EnumPartCategory.CHASSIS;
		if(s.equals("Turret"))
			return EnumPartCategory.TURRET;
		if(s.equals("Fuel"))
			return EnumPartCategory.FUEL;
		if(s.equals("Misc"))
			return EnumPartCategory.MISC;
		if(s.equals("Upgrade")){
			return EnumPartCategory.UPGRADE;
		}
		return EnumPartCategory.MISC;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBase getModel(){
		return null;
	}

	@Override
	public void reloadModel(){
		//
	}

	@Override
	public ResourceLocation getTexture(DriveableData data){
		return null;
	}
	
}