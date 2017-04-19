package com.flansmod.common.items;

import java.util.List;
import java.util.UUID;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKey extends KeyItem {
	
	public ItemKey() {
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setHasSubtypes(true);
		Registry.registerItemManually(FlansMod.MODID, "key", 0, null, this);
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		setDefaults(true, itemstack, player);
	}
	
	public void setDefaults(boolean crafted, ItemStack stack, Entity entity){
		stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound nbt = stack.getTagCompound();
		nbt.setString("KeyOrigin", crafted ? "crafted" : "cheated");
		nbt.setString("KeyCreator", entity instanceof EntityPlayer ? ((EntityPlayer)entity).getGameProfile().getId().toString() : Static.NULL_UUID_STRING);
		nbt.setString("KeyType", KeyType.COMMON.toString());
		nbt.setString("KeyCode", super.getNewKeyCode());
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
			String name = "<null>";
			try{
				Static.getServer().getPlayerProfileCache().getProfileByUUID(UUID.fromString(creator)).getName();
			}
			catch(Exception e){
				name = e.getMessage();
			}
			KeyType type = KeyType.fromString(nbt.getString("KeyType"));
			list.add("Key Type: " + type.toText() + " (FlansMod Car Key)");
			list.add("Code: " + getCode(type, nbt.getString("KeyCode")));
			list.add("Creator: " + name);
			list.add("Origin: " + nbt.getString("KeyOrigin"));
			list.add("Vehicle Type: " + nbt.getString("VehicleType"));
		}
		else{
			list.add("No Tag Compound.");
		}
	}

	private String getCode(KeyType type, String code){
		return (type == KeyType.ADMIN ? TextFormatting.AQUA : TextFormatting.GREEN) + code;
	}

	@Override
	public KeyType getType(ItemStack stack){
		return KeyType.fromString(stack.getTagCompound().getString("KeyType"));
	}

	@Override
	public String getCode(ItemStack stack){
		if(stack.getItem() instanceof ItemKey){
			return stack.getTagCompound().getString("KeyCode");
		}
		else return null;
	}

	@Override
	public UUID getCreator(ItemStack stack){
		if(stack.getItem() instanceof ItemKey){
			return UUID.fromString(stack.getTagCompound().getString("KeyCode"));
		}
		else return null;
	}
	
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> list){
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        while(world.isRemote || hand == EnumHand.OFF_HAND){
        	return EnumActionResult.PASS;
        }
		if(world.getBlockState(pos).getBlock() instanceof LockableObject){
        	LockableObject object = (LockableObject)world.getBlockState(pos).getBlock();
        	return process(world, player, object);
        }
        else if(world.getTileEntity(pos) instanceof LockableObject){
        	LockableObject object = (LockableObject)world.getTileEntity(pos);
        	return process(world, player, object);
        }
        else{
        	return EnumActionResult.PASS;
        }
    }

	private EnumActionResult process(World world, EntityPlayer player, LockableObject object){
		if(object.isLocked()){
    		return object.unlock(world, player, player.getHeldItemMainhand(), (KeyItem)player.getHeldItemMainhand().getItem()) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    	}
    	else{
    		return object.lock(world, player, player.getHeldItemMainhand(), (KeyItem)player.getHeldItemMainhand().getItem()) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    	}
	}
	
}