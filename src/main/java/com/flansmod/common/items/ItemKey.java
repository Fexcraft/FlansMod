package com.flansmod.common.items;

import java.util.List;
import java.util.UUID;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKey extends Item implements IItem {
	
	public ItemKey() {
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setHasSubtypes(true);
		//Registry.registerItemManually(FlansMod.MODID, "key", 0, null, this);
		ItemUtil.register(FlansMod.MODID, this);
		ItemUtil.registerRender(this);
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		setDefaults(true, itemstack, player);
	}
	
	public void setDefaults(boolean crafted, ItemStack stack, Entity entity){
		stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound nbt = stack.getTagCompound();
		nbt.setString("KeyOrigin", crafted ? "crafted" : "cheated");
		nbt.setString("KeyCreator", entity instanceof EntityPlayer ? ((EntityPlayer)entity).getGameProfile().getId().toString() : "");
		nbt.setString("KeyType", "common");
		nbt.setString("KeyCode", newKeyCode());
	}
	
	public static final String newKeyCode(){
		return UUID.randomUUID().toString().replace("-", "").substring(0, 7);
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if(itemstack.getTagCompound() == null){
			setDefaults(false, itemstack, entity);
		}
	}
	    
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean shift){
		if(itemstack.getTagCompound() != null){
			NBTTagCompound nbt = itemstack.getTagCompound();
			String creator = nbt.getString("KeyCreator");
			String name = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getProfileByUUID(UUID.fromString(creator)).getName();
			list.add("Key Type: " + nbt.getString("KeyType") + " (FlansMod Car Key)");
			list.add("Code: " + getCode(nbt.getString("KeyType"), nbt.getString("KeyCode")));
			list.add("Creator: " + name);
			list.add("Origin: " + nbt.getString("KeyOrigin"));
			list.add("Vehicle Type: " + nbt.getString("VehicleType"));
		}
		else{
			list.add("No Tag Compound.");
		}
	}

	private String getCode(String type, String code){
		return (type.equals("admin") ? TextFormatting.AQUA : TextFormatting.GREEN) + code;
	}

	public String getType(ItemStack stack){
		return stack.getTagCompound().getString("KeyType");
	}

	public String getCode(ItemStack stack){
		if(stack.getItem() instanceof ItemKey){
			return stack.getTagCompound().getString("KeyCode");
		}
		else return null;
	}

	public UUID getCreator(ItemStack stack){
		if(stack.getItem() instanceof ItemKey){
			return UUID.fromString(stack.getTagCompound().getString("KeyCode"));
		}
		else return null;
	}
	
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list){
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
    }

	@Override
	public String getName(){
		return "key";
	}

	@Override
	public int getVariantAmount(){
		return 3;
	}
	
}