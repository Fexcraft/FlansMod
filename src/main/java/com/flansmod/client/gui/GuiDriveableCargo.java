package com.flansmod.client.gui;

import com.flansmod.common.driveables.ContainerDriveableCargo;
import com.flansmod.common.driveables.EntityDriveable;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiDriveableCargo extends GuiContainer{
	
	private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/vehicleinventory.png");
	
	public GuiDriveableCargo(InventoryPlayer inventoryplayer, World world1, EntityDriveable entPlane, int i) {
		super(new ContainerDriveableCargo(inventoryplayer, world1, entPlane, i));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
	}
	
}