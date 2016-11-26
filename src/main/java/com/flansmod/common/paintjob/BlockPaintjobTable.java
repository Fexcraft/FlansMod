package com.flansmod.common.paintjob;

import com.flansmod.common.FlansMod;
import com.flansmod.common.util.CTabs;

import net.fexcraft.mod.lib.api.block.IBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class BlockPaintjobTable extends BlockContainer implements IBlock
{	
	public BlockPaintjobTable() 
	{
		super(Material.ROCK);
		setHardness(2F);
		setResistance(4F);
	    setUnlocalizedName("paintjobTable");
		setCreativeTab(CTabs.weapons);
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos)
	{
	    //return world.doesBlockHaveSolidTopSurface(world, pos.add(0, -1, 0));
		return world.isSideSolid(pos.add(0, -1, 0), EnumFacing.UP);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityPaintjobTable();
	}
	
	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
		
    @Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if(world.isRemote)
    	{
    		FlansMod.playerHandler.getPlayerData(player, Side.CLIENT).shootTimeLeft = FlansMod.playerHandler.getPlayerData(player, Side.CLIENT).shootTimeRight = 10;
    		return true;
    	}

    	//TileEntityPaintjobTable table = (TileEntityPaintjobTable)world.getTileEntity(pos);
    	
    	if(!world.isRemote) 
    	{
    		player.openGui(FlansMod.INSTANCE, 13, world, pos.getX(), pos.getY(), pos.getZ());
    	}
		return true;
    }
    
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof IInventory)
        {
            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }

        super.breakBlock(worldIn, pos, state);
    }

	@Override
	public String getName(){
		return "paintjobTable";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
}
