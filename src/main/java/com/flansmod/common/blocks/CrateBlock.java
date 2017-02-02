package com.flansmod.common.blocks;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.util.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CrateBlock extends Block {
	
	public static Block instance;
	
	public CrateBlock() {
		super(Material.WOOD);
		Registry.registerBlockManually(FlansMod.MODID, "crate", 0, null, this, null, null);
	}
	
}