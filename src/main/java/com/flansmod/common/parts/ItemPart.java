package com.flansmod.common.parts;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.IFlanItem;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemPart extends Item implements IFlanItem<PartType>, IItem
{
	public PartType type;
	
	public ItemPart(PartType type1)
	{
		super();
		type = type1;
		setMaxStackSize(type.stackSize);
		if (type.category == EnumPartCategory.FUEL)
		{
			setMaxDamage(type.fuel);
			setHasSubtypes(true);
		}
		type.item = this;
		setUnlocalizedName("FlansMod:" + type.iconPath);
		setCreativeTab(FlansMod.tabFlanParts);
		//GameRegistry.registerItem(this, type.shortName, FlansMod.MODID);
		ItemUtil.register(FlansMod.MODID, this);
		ItemUtil.registerRender(this);
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(type.category == EnumPartCategory.FUEL)
		{
			par3List.add("Fuel Stored: " + (type.fuel - par1ItemStack.getItemDamage()) + " / " + type.fuel);
		}
	}

	//TODO @Override
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
    	return type.colour;
    }
    
	@Override
	public PartType getInfoType()
	{
		return type;
	}

	@Override
	public String getName(){
		return type.shortName;
	}
}