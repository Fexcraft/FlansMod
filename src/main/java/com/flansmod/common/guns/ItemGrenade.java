package com.flansmod.common.guns;

import java.util.Collections;
import java.util.List;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.types.IFlanItem;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.util.CTabs;
import com.flansmod.common.vector.Vector3f;
import com.google.common.collect.Multimap;

import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGrenade extends ItemShootable implements IFlanItem<GrenadeType>, IItem
{
	public GrenadeType type;
	
	public ItemGrenade(GrenadeType t) 
	{
		super(t);
		type = t;
		type.item = this;
		setCreativeTab(CTabs.weapons);
		ItemUtil.register(FlansMod.MODID, this);
		ItemUtil.registerRender(this);
	}
	
	@Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap multimap = super.getItemAttributeModifiers(equipmentSlot);
        multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", type.meleeDamage, 0));
        return multimap;
    }
	
	@Override
	public boolean isFull3D()
	{
		return true;
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		return type.meleeDamage == 0;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
	{
		PlayerData data = PlayerHandler.getPlayerData(player, world.isRemote ? Side.CLIENT : Side.SERVER);
		//If can throw grenade
		if(type.canThrow && data != null && data.shootTimeRight <= 0 && data.shootTimeLeft <= 0)
		{
			//Delay the next throw / weapon fire / whatnot
			data.shootTimeRight = type.throwDelay;
			//Create a new grenade entity
			EntityGrenade grenade = new EntityGrenade(world, type, player);
			//Spawn the entity server side
			if(!world.isRemote)
				world.spawnEntityInWorld(grenade);
			//If this can be remotely detonated, add it to the players detonate list
			if(type.remote)
				data.remoteExplosives.add(grenade);
			//Consume an item
			if(!player.capabilities.isCreativeMode)
				stack.stackSize--;
			//Drop an item upon throwing if necessary
			if(type.dropItemOnThrow != null)
			{
				String itemName = type.dropItemOnDetonate;
				int damage = 0;
				if (itemName.contains("."))
				{
					damage = Integer.parseInt(itemName.split("\\.")[1]);
					itemName = itemName.split("\\.")[0];
				}
				ItemStack dropStack = InfoType.getRecipeElement(itemName, damage);
				world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, dropStack));
			}
		}
		return new ActionResult(EnumActionResult.SUCCESS, stack);
	}
	
	//TODO @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
    	return type.colour;
    }
    
	@Override
	public GrenadeType getInfoType()
	{
		return type;
	}

	@Override
	public EntityShootable getEntity(World worldObj, Vec3d origin, float yaw,
			float pitch, double motionX, double motionY, double motionZ,
			EntityLivingBase shooter, float gunDamage,
			InfoType shotFrom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityShootable getEntity(World worldObj, Vector3f origin,
			Vector3f direction, EntityLivingBase thrower, float spread,
			float damage, float speed, InfoType shotFrom) 
	{
		return getGrenade(worldObj, thrower);
	}

	@Override
	public EntityShootable getEntity(World worldObj, Vec3d origin, float yaw,
			float pitch, EntityLivingBase shooter, float spread, float damage,
			InfoType shotFrom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityShootable getEntity(World worldObj, EntityLivingBase player,
			float bulletSpread, float damage, float bulletSpeed, boolean b,
			InfoType shotFrom) 
	{
		return getGrenade(worldObj, player);
	}
	
	public EntityGrenade getGrenade(World world, EntityLivingBase thrower)
	{
		//Create a new grenade entity
		EntityGrenade grenade = new EntityGrenade(world, type, thrower);
		//If this can be remotely detonated, add it to the players detonate list
		if(type.remote && thrower instanceof EntityPlayer)
			PlayerHandler.getPlayerData((EntityPlayer)thrower).remoteExplosives.add(grenade);
		return grenade;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		if(type.description != null)
		{
			Collections.addAll(list, type.description.split("_"));
		}
	}
	
	public void Shoot(World world,
			Vector3f origin,
			Vector3f direction,
			float damageModifier,
			float spreadModifier,
			float speedModifier,
			InfoType shotFrom,
			EntityLivingBase shooter)
	{
		EntityGrenade grenade = getGrenade(world, shooter);
		world.spawnEntityInWorld(grenade);
	}

	@Override
	public String getName(){
		return type.shortName;
	}
}
