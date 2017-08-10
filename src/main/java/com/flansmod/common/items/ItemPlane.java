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
import com.flansmod.common.data.PlaneType;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.util.CTabs;
import com.flansmod.common.util.Util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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

public class ItemPlane extends Item {
	
	private static final ArrayList<String> rs = new ArrayList<String>();
	public PlaneType type;
	
	public ItemPlane(PlaneType planetype){
		maxStackSize = 1;
		type = planetype;
		type.item = this;
		this.setCreativeTab(CTabs.VEHICLES);
		FlansMod.AUTOREG.addItem(type.registryname, this, 0, null);
	}

	@Override
	/** Make sure client and server side NBTtags update */
	public boolean getShareTag(){
		return true;
	}
	
	private NBTTagCompound getTagCompound(ItemStack stack, World world){
		if(stack.getTagCompound() == null){
			if(!world.isRemote && stack.getItemDamage() != 0){
				stack.setTagCompound(getOldTagCompound(stack, world));
			}
			if(stack.getTagCompound() == null){
				NBTTagCompound tags = new NBTTagCompound();
				stack.setTagCompound(tags);
				tags.setString("Type", type.registryname);
				tags.setString("Engine", PartType.defaultEngines.get(EnumType.plane).registryname);
			}
		}
		return stack.getTagCompound();
	}
	
	private NBTTagCompound getOldTagCompound(ItemStack stack, World world){
		try{
			File file1 = world.getSaveHandler().getMapFileFromName("plane_" + stack.getItemDamage());
			if(file1 != null && file1.exists()){
				FileInputStream fileinputstream = new FileInputStream(file1);
				NBTTagCompound tags = CompressedStreamTools.readCompressed(fileinputstream).getCompoundTag("data");
				/*for(EnumDriveablePart part : EnumDriveablePart.values()){
					tags.setInteger(part.getShortName() + "_Health", type.health.get(part) == null ? 0 : type.health.get(part).health);
					tags.setBoolean(part.getShortName() + "_Fire", false);
				}*/
				fileinputstream.close();
				return tags;
			}
		}
		catch(IOException e){
			Util.log("Failed to read old vehicle file");
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void addInformation(ItemStack stack, World world, List lines, ITooltipFlag flag){
		if(type.description != null){
			for(String s : type.description){
				lines.add(s);
			}
		}
		NBTTagCompound tags = getTagCompound(stack, world);
		PartType part = PartType.getPart(tags.getString("Engine"));
		if(part != null){
			lines.add(part.name);
		}
		if(type.hasColor){
			if(tags.hasKey("PrimaryColorRed")){
				lines.add("Primary Color: R" + tags.getFloat("PrimaryColorRed") + " G" + tags.getFloat("PrimaryColorGreen") + " B" + tags.getFloat("PrimaryColorBlue"));
				lines.add("Secondary Color: R" + tags.getFloat("SecondaryColorRed") + " G" + tags.getFloat("SecondaryColorGreen") + " B" + tags.getFloat("SecondaryColorBlue"));
			}
			else{
				lines.add("Primary Color: R" + type.default_primary_color.red + " G" + type.default_primary_color.green + " B" + type.default_primary_color.blue);
				lines.add("Secondary Color: R" + type.default_secondary_color.red + " G" + type.default_secondary_color.green + " B" + type.default_secondary_color.blue);
			}
		}
		if(type.allowURL){
			if(tags.hasKey("RemoteTexture")){
				lines.add("Remote Texture: " + tags.getString("RemoteTexture"));
			}
		}
		if(type.hasLock){
			if(tags.hasKey("LockCode")){
				lines.add("Lock Code: " + tags.getString("LockCode"));
			}
			else{
				lines.add("Lock Code: none");
			}
		}
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand hand){
		ItemStack itemstack = entityplayer.getHeldItemMainhand();
		
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
            return new ActionResult(EnumActionResult.PASS, itemstack);
        }
        if(movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK){
        	BlockPos pos = movingobjectposition.getBlockPos();
            Block block = world.getBlockState(pos).getBlock();
            if(type.placeableOnLand || block instanceof BlockLiquid){
	            if(!world.isRemote){
	            	DriveableData data = getPlaneData(itemstack, world);
	            	if(data != null)
	            		world.spawnEntity(new EntityPlane(world, (double)pos.getX() + 0.5F, (double)pos.getY() + 2.5F, (double)pos.getZ() + 0.5F, entityplayer, type, data));
	            }
				if(!entityplayer.capabilities.isCreativeMode){	
					itemstack.shrink(1);
				}
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
	}

	public Entity spawnPlane(World world, double x, double y, double z, ItemStack stack){
		DriveableData data = getPlaneData(stack, world);
		if(data != null){
			Entity entity = new EntityPlane(world, x, y, z, type, data);
			if(!world.isRemote){
				world.spawnEntity(entity);
			}
			return entity;
		}
		return null;
	}
	
	public DriveableData getPlaneData(ItemStack itemstack, World world){
		return new DriveableData(getTagCompound(itemstack, world));
	}
	
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2){
    	return type.colour;
    }
    
    /** Make sure that creatively spawned planes have nbt data */
    @Override
    public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> list){
    	if(tabs != this.getCreativeTab()){
    		return;
    	}
    	ItemStack planeStack = new ItemStack(this, 1, 0);
    	NBTTagCompound tags = new NBTTagCompound();
    	tags.setString("Type", type.registryname);
    	if(PartType.defaultEngines.containsKey(EnumType.plane)){
    		tags.setString("Engine", PartType.defaultEngines.get(EnumType.plane).registryname);
    	}
    	/*for(EnumDriveablePart part : EnumDriveablePart.values()){
    		tags.setInteger(part.getShortName() + "_Health", type.health.get(part) == null ? 0 : type.health.get(part).health);
    		tags.setBoolean(part.getShortName() + "_Fire", false);
    	}*/
    	planeStack.setTagCompound(tags);
        list.add(planeStack);
    }

    public static Item getNew(PlaneType type){
		if(rs.contains(type.registryname)){
			return null;
		}
		else{
			rs.add(type.registryname);
			return new ItemPlane(type);
		}
	}
	
}
