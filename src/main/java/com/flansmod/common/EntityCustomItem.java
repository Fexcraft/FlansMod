package com.flansmod.common;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * An Entity that will be spawned instead of the normal EntityItem.
 */
public class EntityCustomItem extends EntityItem
{
	public EntityCustomItem(EntityItem entity)
	{
		super(entity.worldObj, entity.posX, entity.posY, entity.posZ, entity.getEntityItem());
		this.motionX = entity.motionX;
		this.motionY = entity.motionY;
		this.motionZ = entity.motionZ;
		this.setDefaultPickupDelay();
	}

	public EntityCustomItem(World world, double posX, double posY, double posZ, ItemStack stack)
	{
		super(world, posX, posY, posZ, stack);
	}

	public EntityCustomItem(World world)
	{
		super(world);
	}

	public EntityCustomItem(World w, double x, double y, double z)
	{
		super(w, x, y, z);
	}
}
