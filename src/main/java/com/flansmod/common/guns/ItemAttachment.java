package com.flansmod.common.guns;

import java.util.Collections;
import java.util.List;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.IPaintableItem;
import com.flansmod.common.types.PaintableType;
import com.flansmod.common.util.CTabs;
import com.flansmod.common.util.Config;

import net.fexcraft.mod.lib.api.item.IItem;
import net.fexcraft.mod.lib.util.item.ItemUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAttachment extends Item implements IPaintableItem<AttachmentType>, IItem
{
	public AttachmentType type;
	
	public ItemAttachment(AttachmentType t) 
	{
		type = t;
		type.item = this;
		maxStackSize = t.maxStackSize;
		setCreativeTab(CTabs.weapons);
		//GameRegistry.registerItem(this, type.shortName, FlansMod.MODID);
		ItemUtil.register(FlansMod.MODID, this);
		ItemUtil.registerRender(this);
	}
	
	@SideOnly(Side.CLIENT)
    //TODO@Override
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
    	return type.colour;
    }
    
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean b)
	{
		if(type.description != null)
		{
			Collections.addAll(lines, type.description.split("_"));
		}
	}
	
	@Override
	public AttachmentType getInfoType() { return type; }

	
	// ----------------- Paintjobs -----------------
	
    @Override
    public void getSubItems(Item item, CreativeTabs tabs, NonNullList<ItemStack> list)
    {
    	PaintableType type = ((IPaintableItem)item).getInfoType();
    	if(Config.addAllPaintjobsToCreative){
    		for(Paintjob paintjob : type.paintjobs)
    			addPaintjobToList(item, type, paintjob, list);
    	}
        else addPaintjobToList(item, type, type.defaultPaintjob, list);
    }
    
    private void addPaintjobToList(Item item, PaintableType type, Paintjob paintjob, List list)
    {
    	ItemStack paintableStack = new ItemStack(item, 1, paintjob.ID);
    	NBTTagCompound tags = new NBTTagCompound();
    	paintableStack.setTagCompound(tags);
        list.add(paintableStack);
    }

	@Override
	public String getName(){
		return type.shortName;
	}
    
    // ---------------------------------------------
}
