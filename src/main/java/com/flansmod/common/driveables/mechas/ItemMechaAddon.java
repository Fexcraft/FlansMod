package com.flansmod.common.driveables.mechas;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.IFlanItem;
import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collections;
import java.util.List;

public class ItemMechaAddon extends Item implements IFlanItem<MechaItemType>, IItem
{
	public MechaItemType type;
	
	public ItemMechaAddon(MechaItemType type1)
	{
		type = type1;
		setMaxStackSize(1);
		type.item = this;
		setCreativeTab(FlansMod.tabFlanMechas);
		//GameRegistry.registerItem(this, type.shortName, FlansMod.MODID);
		ItemUtil.register(FlansMod.MODID, this);
		ItemUtil.registerRender(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b)
	{
		if(type.description != null)
		{
			Collections.addAll(list, type.description.split("_"));
		}
	}

	//TODO @Override
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
    	return type.colour;
    }
    
	@Override
	public MechaItemType getInfoType()
	{
		return type;
	}

	@Override
	public String getName(){
		return type.shortName;
	}
}
