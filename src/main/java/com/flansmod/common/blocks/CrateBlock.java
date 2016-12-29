package com.flansmod.common.blocks;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.api.block.IBlock;
import net.fexcraft.mod.lib.util.block.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CrateBlock extends Block implements IBlock {
	
	public static Block instance;
	
	public CrateBlock() {
		super(Material.WOOD);
		BlockUtil.register(FlansMod.MODID, this);
		BlockUtil.registerFIB(this);
		BlockUtil.registerFIBRender(this);
	}

	@Override
	public String getName(){
		return "crate";
	}

	@Override
	public int getVariantAmount(){
		return default_variant;
	}
	
}