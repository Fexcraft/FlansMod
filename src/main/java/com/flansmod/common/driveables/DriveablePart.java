package com.flansmod.common.driveables;

import net.minecraft.nbt.NBTTagCompound;

public class DriveablePart 
{
	public EnumDriveablePart type;
	public CollisionBox box;
	public int maxHealth;
	public int health;
	public int fireTime;
	public boolean onFire;
	/** Keeps track of whether death code has been called or not */
	public boolean dead;
	
	public DriveablePart(EnumDriveablePart e, CollisionBox b)
	{
		type = e;
		box = b;
		health = maxHealth = b == null ? 0 : b.health;
	}
	
	public void update(EntityDriveable driveable)
	{
		if(fireTime > 0)
			fireTime--;
		if(fireTime == 0)
			onFire = false;
		if(onFire)
			health--;
		if(health <= 0 && maxHealth > 0)
		{
			dead = true;
		}
	}
	
	public void writeToNBT(NBTTagCompound tags)
	{
		tags.setInteger(type.getShortName() + "_Health", health);
		tags.setBoolean(type.getShortName() + "_Fire", onFire);
	}
	
	public void readFromNBT(NBTTagCompound tags)
	{
		if(!tags.hasKey(type.getShortName() + "_Health"))
		{
			health = maxHealth;
			onFire = false;
			return;
		}
		health = tags.getInteger(type.getShortName() + "_Health");
		onFire = tags.getBoolean(type.getShortName() + "_Fire");
	}
	
	/** Called when a corner of this part hits the ground.
	 * @return The amount of damage to do to the block */
	public float smashIntoGround(EntityDriveable driveable, float damage)
	{
		//In these cases, there was no collision, so don't damage this or the block
		if(box == null || dead)
			return 0;
		if(!driveable.canHitPart(type))
			return 0;
		//This part is immortal. Smash that block into oblivion
		if(maxHealth == 0)
			return damage;
		//As standard, take half damage and return the other half
		health -= (int)(damage / 2F);
		return damage / 2F;
	}
	
	/** Ray traces a single co-ordinate 
	 * But only returns true once upon entering the box, and not while in or exiting
	 * @param start The start of the ray in this co-ordinate 
	 * @param end The end of the ray in this co-ordinate
	 * @param min The start of the box in this co-ordinate
	 * @param max The end of the box in this co-ordinate 
	 * @return true if the ray hits in this co-ordinate */
	private boolean coordIsEntering(float start, float end, float min, float max)
	{
		//Check to see if ray entered from the left hand side
		if(start < min && end >= min)
			return true;
		//Check to see if ray entered from the right hand side
		if(start > max && end <= max)
			return true;
		return false;	
	}
	
	/** Ray traces a single co-ordinate 
	 * Returns true if the ray is in the bounds at some point along its length
	 * @param start The start of the ray in this co-ordinate 
	 * @param end The end of the ray in this co-ordinate
	 * @param min The start of the box in this co-ordinate
	 * @param max The end of the box in this co-ordinate 
	 * @return true if the ray hits in this co-ordinate */
	private boolean coordIsIn(float start, float end, float min, float max)
	{
		//Check to see if the start point is in
		if(start >= min && start <= max)
			return true;
		//Check to see if the end point is in
		if(end >= min && end <= max)
			return true;
		//Check to see if the start and end points are either side of the interval
		if(start < min && end > max)
			return true;
		if(end < min && start > max)
			return true;
		return false;	
	}

	public boolean attack(float damage, boolean fireDamage) 
	{
		health -= damage;
		if(fireDamage)
		{				
			fireTime = 20;
			onFire = true;
		}
		return health <= 0;
	}
}
