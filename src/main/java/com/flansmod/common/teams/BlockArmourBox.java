package com.flansmod.common.teams;

import com.flansmod.common.CraftingInstance;
import com.flansmod.common.FlansMod;
import com.flansmod.common.teams.ArmourBoxType.ArmourBoxEntry;
import com.flansmod.common.util.CTabs;

import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class BlockArmourBox extends Block implements IBlock
{
	public ArmourBoxType type;
	
	public BlockArmourBox(ArmourBoxType t) 
	{
		super(Material.WOOD);
		type = t;

		setHardness(2F);
		setResistance(4F);
		setCreativeTab(CTabs.other);
		type.block = this;
		type.item = Item.getItemFromBlock(this);
		
		BlockUtil.register(FlansMod.MODID, this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}
	
	public void buyArmour(String shortName, int piece, InventoryPlayer inventory)
	{
		if(FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			FlansMod.proxy.buyArmour(shortName, piece, type);
		} 
		ArmourBoxEntry entryPicked = null;
		for(ArmourBoxEntry page : type.pages)
		{
			if(page.shortName.equals(shortName))
				entryPicked = page;
		}
		
		ItemStack resultStack = new ItemStack(entryPicked.armours[piece].item);
		
		CraftingInstance crafting = new CraftingInstance(inventory, entryPicked.requiredStacks[piece], resultStack);
		if(crafting.canCraft())
		{
			crafting.craft(inventory.player);
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(player.isSneaking())
			return false;
		player.openGui(FlansMod.INSTANCE, 11, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	@Override
	public String getName(){
		return type.shortName;
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}
