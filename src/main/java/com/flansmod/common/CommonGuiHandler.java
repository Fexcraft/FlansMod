package com.flansmod.common;

import com.flansmod.client.gui.GuiDriveableFuel;
import com.flansmod.client.gui.GuiDriveableInventory;
import com.flansmod.client.gui.GuiDriveableRepair;
import com.flansmod.client.gui.GuiMechaInventory;
import com.flansmod.common.driveables.ContainerDriveableInventory;
import com.flansmod.common.driveables.ContainerDriveableMenu;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.mechas.ContainerMechaInventory;
import com.flansmod.common.driveables.mechas.EntityMecha;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CommonGuiHandler implements IGuiHandler {
	 @Override
	 public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		 switch(ID){	
			case 0 : return null; //Driveable crafting. No server side
			case 1 : return null; //Driveable repair. No server side
			case 3: return new ContainerDriveableMenu(player.inventory, world);
			case 4: return new ContainerDriveableMenu(player.inventory, world, true, ((EntitySeat)player.getRidingEntity()).driveable);
			//Plane inventory screens
			case 6: return new ContainerDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 0);
			case 7: return new ContainerDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 1);
			case 8: return new ContainerDriveableMenu(player.inventory, world, true, ((EntitySeat)player.getRidingEntity()).driveable);
			case 9: return new ContainerDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 2);
			case 10: return new ContainerMechaInventory(player.inventory, world, (EntityMecha)((EntitySeat)player.getRidingEntity()).driveable);
			case 11 : return null; //Armour box. No server side
			case 12 : return new ContainerDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 3);
		}
		return null;
	 }

	 @Override
     public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		 if(((ID >= 6 && ID <= 10) || ID == 12) && player.getRidingEntity() == null) return null;
		
		 switch(ID){
			case 1: return new GuiDriveableRepair(player);
			case 6: return new GuiDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 0);
			case 7: return new GuiDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 1);
			case 8: return new GuiDriveableFuel		(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable);
			case 9: return new GuiDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 2);
			case 10: return new GuiMechaInventory	(player.inventory, world, (EntityMecha)((EntitySeat)player.getRidingEntity()).driveable);
			case 12: return new GuiDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 3);
		}
		return null;
     }
	 
}