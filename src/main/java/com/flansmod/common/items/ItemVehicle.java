package com.flansmod.common.items;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.flansmod.common.FlansMod;
import com.flansmod.common.data.DriveableData;
import com.flansmod.common.data.EnumType;
import com.flansmod.common.data.PartType;
import com.flansmod.common.data.VehicleType;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.util.CTabs;
import com.flansmod.common.util.Util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVehicle extends ItemMapBase {
	
	private static final ArrayList<String> rs = new ArrayList<String>();
	public VehicleType type;
	
	public ItemVehicle(VehicleType type1){
		maxStackSize = 1;
		type = type1;
		//type.item = this;
		setCreativeTab(CTabs.vehicles);
		FlansMod.AUTOREG.addItem(type.registryname, this, 0, null);
	}

	@Override
	/** Make sure client and server side NBTtags update */
	public boolean getShareTag(){
		return true;
	}
	
	private NBTTagCompound getTagCompound(ItemStack stack, World world){
		if(!stack.hasTagCompound()){
			if(!world.isRemote && stack.getItemDamage() != 0){
				stack.setTagCompound(getOldTagCompound(stack, world));
			}
			if(stack.getTagCompound() == null){
				NBTTagCompound tags = new NBTTagCompound();
				tags.setString("Type", type.registryname);
				tags.setString("Engine", PartType.defaultEngines.get(EnumType.vehicle).registryname);				
				stack.setTagCompound(tags);
			}
		}
		return stack.getTagCompound();
	}
	
	private NBTTagCompound getOldTagCompound(ItemStack stack, World world){
		try{
			File file1 = world.getSaveHandler().getMapFileFromName("vehicle_" + stack.getItemDamage());
			FileInputStream fileinputstream = new FileInputStream(file1);
			NBTTagCompound tags = CompressedStreamTools.readCompressed(fileinputstream).getCompoundTag("data");
			/*for(EnumDriveablePart part : EnumDriveablePart.values()){
				tags.setInteger(part.getShortName() + "_Health", type.health.get(part) == null ? 0 : type.health.get(part).health);
				tags.setBoolean(part.getShortName() + "_Fire", false);
			}*/
			fileinputstream.close();
			return tags;
		}
		catch(IOException e){
			Util.log("Failed to read old vehicle file");
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, World world, List lines, ITooltipFlag tooltip){
		if(type.description != null){
			for(String s : type.description){
				lines.add(s);
			}
		}
		NBTTagCompound tags = getTagCompound(stack, world);
		PartType part = PartType.getPart(tags.getString("Engine"));
		if(part == null){
			part = PartType.defaultEngines.get(EnumType.vehicle);
			tags.setString("Engine", part.registryname);
		}
		lines.add(part.name);
		if(!tags.hasKey("Minus")){
			return;
		}
		NBTTagCompound nbt = tags.getCompoundTag("Minus");
		lines.add("Upgrades: " + nbt.getString("Upgrades"));
		if(type.hasColor){
			if(nbt.hasKey("PrimaryColorRed")){
				lines.add("Primary Color R:" + nbt.getFloat("PrimaryColorRed") + " G:" + nbt.getFloat("PrimaryColorGreen") + " B:" + nbt.getFloat("PrimaryColorBlue"));
				lines.add("Secondary Color R:" + nbt.getFloat("SecondaryColorRed") + " G:" + nbt.getFloat("SecondaryColorGreen") + " B:" + nbt.getFloat("SecondaryColorBlue"));
			}
			else{
				lines.add("Primary Color R:" + type.default_primary_color.red + " G:" + type.default_primary_color.green + " B:" + type.default_primary_color.blue);
				lines.add("Secondary Color R:" + type.default_secondary_color.red + " G:" + type.default_secondary_color.green + " B:" + type.default_secondary_color.blue);
			}
		}
		if(type.allowURL){
			if(nbt.hasKey("RemoteTexture")){
				lines.add("Remote Texture: " + nbt.getString("RemoteTexture"));
			}
			else{
				lines.add("Remote Texture: none");
			}
		}
		if(type.hasLock){
			if(nbt.hasKey("LockCode")){
				lines.add("Lock Code: " + nbt.getString("LockCode").toUpperCase());
			}
			else{
				lines.add("Lock Code: none");
			}
			if(nbt.hasKey("SpawnedKeys")){
				lines.add("Spawned Keys: " + nbt.getInteger("SpawnedKeys"));
			}
		}
		lines.add(nbt.toString());
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand hand){
    	//Raytracing
        float cosYaw = MathHelper.cos(-entityplayer.rotationYaw * 0.01745329F - 3.141593F);
        float sinYaw = MathHelper.sin(-entityplayer.rotationYaw * 0.01745329F - 3.141593F);
        float cosPitch = -MathHelper.cos(-entityplayer.rotationPitch * 0.01745329F);
        float sinPitch = MathHelper.sin(-entityplayer.rotationPitch * 0.01745329F);
        double length = 5D;
        Vec3d posVec = new Vec3d(entityplayer.posX, entityplayer.posY + 1.62D - entityplayer.getYOffset(), entityplayer.posZ);        
        Vec3d lookVec = posVec.addVector(sinYaw * cosPitch * length, sinPitch * length, cosYaw * cosPitch * length);
        RayTraceResult movingobjectposition = world.rayTraceBlocks(posVec, lookVec, type.placeableOnWater);
        
        //Result check
        if(movingobjectposition == null){
            return new ActionResult(EnumActionResult.PASS, entityplayer.getHeldItem(hand));
        }
        if(movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK){
            BlockPos pos = movingobjectposition.getBlockPos();
            Block block = world.getBlockState(pos).getBlock();
            if(type.placeableOnLand || block instanceof BlockLiquid){
	            if(!world.isRemote){
					world.spawnEntity(new EntityVehicle(world, (double)pos.getX() + 0.5F, (double)pos.getY() + 2.5F, (double)pos.getZ() + 0.5F, entityplayer, type, getData(entityplayer.getHeldItem(hand), world)));
	            }
				if(!entityplayer.capabilities.isCreativeMode){	
					entityplayer.getHeldItem(hand).shrink(1);
				}
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, entityplayer.getHeldItemMainhand());
	}

	public Entity spawnVehicle(World world, double x, double y, double z, ItemStack stack){
		Entity entity = new EntityVehicle(world, x, y, z, type, getData(stack, world));
		if(!world.isRemote){
			world.spawnEntity(entity);
		}
		return entity;
	}
	
	public DriveableData getData(ItemStack itemstack, World world){
		return new DriveableData(getTagCompound(itemstack, world));
	}
	
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2){
    	return type.colour;
    }
    
    /** Make sure that creatively spawned planes have nbt data */
    @Override
    public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> list){
    	ItemStack planeStack = new ItemStack(this, 1, 0);
    	NBTTagCompound tags = new NBTTagCompound();
    	tags.setString("Type", type.registryname);
    	if(PartType.defaultEngines.containsKey(EnumType.vehicle)){
    		tags.setString("Engine", PartType.defaultEngines.get(EnumType.vehicle).registryname);
    	}
    	/*for(EnumDriveablePart part : EnumDriveablePart.values()){
    		tags.setInteger(part.getShortName() + "_Health", type.health.get(part) == null ? 0 : type.health.get(part).health);
    		tags.setBoolean(part.getShortName() + "_Fire", false);
    	}*/
    	planeStack.setTagCompound(tags);
        list.add(planeStack);
    }

	public static Item getNew(VehicleType type){
		if(rs.contains(type.registryname)){
			return null;
		}
		else{
			rs.add(type.registryname);
			return new ItemVehicle(type);
		}
	}
	
}
