package com.flansmod.common.tools;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.lib.util.entity.EntUtil;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityParachute extends Entity implements IEntityAdditionalSpawnData
{
	public ToolType type;
	
	public EntityParachute(World w) 
	{
		super(w);
		ignoreFrustumCheck = true;
		System.out.println(w.isRemote ? "Client paraspawn" : "Server paraspawn");
	}
	
	public EntityParachute(World w, ToolType t, EntityPlayer player)
	{
		this(w);
		type = t;
		setPosition(player.posX, player.posY, player.posZ);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if(!worldObj.isRemote && (getPassengers() == null || getPassengers() != this))
		{
			setDead();
		}
		
		if(getPassengers() != null)
			EntUtil.setFallDistance(this, 0F);
		
		motionY = -0.1D;
		
		if(getPassengers() != null && getPassengers() instanceof EntityLivingBase)
		{
			float speedMultiplier = 0.002F;
			double moveForwards = ((EntityLivingBase)this.getPassengers()).moveForward;
			double moveStrafing = ((EntityLivingBase)this.getPassengers()).moveStrafing;
			double sinYaw = -Math.sin((EntUtil.getPassengerOf(this).rotationYaw * (float)Math.PI / 180.0F));
			double cosYaw = Math.cos((EntUtil.getPassengerOf(this).rotationYaw * (float)Math.PI / 180.0F));
			motionX += (moveForwards * sinYaw + moveStrafing * cosYaw) * speedMultiplier;
			motionZ += (moveForwards * cosYaw - moveStrafing * sinYaw) * speedMultiplier;
			
			prevRotationYaw = rotationYaw;
			rotationYaw = EntUtil.getPassengerOf(this).rotationYaw;
		}		
		
		motionX *= 0.8F;
		motionZ *= 0.8F;
		
		moveEntity(motionX, motionY, motionZ);
		
		if(onGround || worldObj.getBlockState(new BlockPos(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ))).getMaterial() == Material.WATER)
		{
			setDead();
		}
	}
	
	@Override
	public void fall(float par1, float k)
    {
		//Ignore fall damage
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float f)
	{
		setDead();
		return true;
	}
	
	@Override
	protected void entityInit() 
	{
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound tags) 
	{
		type = ToolType.getType(tags.getString("Type"));
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tags) 
	{
		tags.setString("Type", type.shortName);
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult target)
	{
		ItemStack stack = new ItemStack(type.item, 1, 0);
		return stack;
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) 
	{
		ByteBufUtils.writeUTF8String(buffer, type.shortName);
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) 
	{
		type = ToolType.getType(ByteBufUtils.readUTF8String(additionalData));
	}
}
