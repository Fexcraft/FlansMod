package com.flansmod.common.util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CrateBlock extends Block {
	
	public static Block INSTANCE = new CrateBlock();
	
	public CrateBlock(){
		super(Material.WOOD);
	}
	
}