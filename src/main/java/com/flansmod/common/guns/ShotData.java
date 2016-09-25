package com.flansmod.common.guns;

import com.flansmod.common.guns.raytracing.FlansModRaytracer.BulletHit;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHand;


public class ShotData 
{
	/**
	 * -2  : offHand
	 * -1  : Driveables
	 * 0-8 : mainHad (slots)
	 * May include special cases like deployable
	 */
	public int slot;
	public InfoType shotFrom;
	public ShootableType shotType;

	public ShotData(int slot, InfoType shotFrom, ShootableType shotType)
	{
		this.slot = slot;
		this.shotFrom = shotFrom;
		this.shotType = shotType;
	}
	public ShotData(EnumHand side, int slot, InfoType shotFrom, ShootableType shotType)
	{
		this.slot = side == EnumHand.OFF_HAND ? -2 : slot;
		this.shotFrom = shotFrom;
		this.shotType = shotType;
	}
	
	public static class SpawnEntityShotData extends ShotData
	{
		public SpawnEntityShotData(EnumHand side, int slot, InfoType shotFrom, ShootableType shotType, int shooterID, Vector3f direction)
		{
			super(side, slot, shotFrom, shotType);
			this.shooterID = shooterID;
			this.direction = direction;
		}

		public SpawnEntityShotData(int slot, InfoType shotFrom, ShootableType shotType, int shooterID, Vector3f direction)
		{
			super(slot, shotFrom, shotType);
			this.shooterID = shooterID;
			this.direction = direction;
		}
		
		public SpawnEntityShotData(int slot, InfoType shotFrom, ShootableType shotType, Entity shooter, Vector3f direction)
		{
			this(slot, shotFrom, shotType, shooter.getEntityId(), direction);
		}
		public SpawnEntityShotData(EnumHand hand, int slot, InfoType shotFrom, ShootableType shotType, Entity shooter, Vector3f direction)
		{
			this(hand, slot, shotFrom, shotType, shooter.getEntityId(), direction);
		}
		
		public int shooterID;
		public Vector3f direction;
	}
	
	public static class InstantShotData extends ShotData
	{
		public InstantShotData(EnumHand side, int slot, InfoType shotFrom, ShootableType shotType, int shooterID, Vector3f origin, BulletHit hitData, Vector3f hit, float damage, boolean isExtraBullet)
		{
			super(side, slot, shotFrom, shotType);
			this.shooterID = shooterID;
			this.origin = origin;
			this.hitData = hitData;
			this.hitPos = hit;
			this.damage = damage;
			this.isExtraBullet = isExtraBullet;
		}
		
		public InstantShotData(int slot, InfoType shotFrom, ShootableType shotType, int shooterID, Vector3f origin, BulletHit hitData, Vector3f hit, float damage, boolean isExtraBullet)
		{
			super(slot, shotFrom, shotType);
			this.shooterID = shooterID;
			this.origin = origin;
			this.hitData = hitData;
			this.hitPos = hit;
			this.damage = damage;
			this.isExtraBullet = isExtraBullet;
		}
		
		public InstantShotData(int slot, InfoType shotFrom, ShootableType shotType, Entity shooter, Vector3f origin, BulletHit hitData, Vector3f hit, float damage, boolean isExtraBullet)
		{
			this(slot, shotFrom, shotType, shooter.getEntityId(), origin, hitData, hit, damage, isExtraBullet);
		}
		public InstantShotData(EnumHand hand, int slot, InfoType shotFrom, ShootableType shotType, Entity shooter, Vector3f origin, BulletHit hitData, Vector3f hit, float damage, boolean isExtraBullet)
		{
			this(hand, slot, shotFrom, shotType, shooter.getEntityId(), origin, hitData, hit, damage, isExtraBullet);
		}
		
		public int shooterID;
		public Vector3f origin;
		
		// Can be null for environment hits etc
		public BulletHit hitData; 
		public Vector3f hitPos;
		
		public float damage;
		public boolean isExtraBullet; // For shotgun extra bullets that shouldn't consume ammo
	}
}
