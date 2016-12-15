package com.flansmod.common;

import com.flansmod.client.gui.GuiArmourBox;
import com.flansmod.client.gui.GuiDriveableCrafting;
import com.flansmod.client.gui.GuiDriveableFuel;
import com.flansmod.client.gui.GuiDriveableInventory;
import com.flansmod.client.gui.GuiDriveableRepair;
import com.flansmod.client.gui.GuiGunBox;
import com.flansmod.client.gui.GuiGunModTable;
import com.flansmod.client.gui.GuiMechaInventory;
import com.flansmod.client.gui.GuiPaintjobTable;
import com.flansmod.common.driveables.ContainerDriveableInventory;
import com.flansmod.common.driveables.ContainerDriveableMenu;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.mechas.ContainerMechaInventory;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.guns.ContainerGunModTable;
import com.flansmod.common.guns.boxes.BlockGunBox;
import com.flansmod.common.guns.boxes.ContainerGunBox;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.paintjob.ContainerPaintjobTable;
import com.flansmod.common.paintjob.TileEntityPaintjobTable;
import com.flansmod.common.teams.BlockArmourBox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CommonGuiHandler implements IGuiHandler {
	 @Override
	 public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		 switch(ID){	
			case 0 : return null; //Driveable crafting. No server side
			case 1 : return null; //Driveable repair. No server side
			case 2: return new ContainerGunModTable(player.inventory, world);
			case 3: return new ContainerDriveableMenu(player.inventory, world);
			case 4: return new ContainerDriveableMenu(player.inventory, world, true, ((EntitySeat)player.getRidingEntity()).driveable);
			case 5: return new ContainerGunBox(player.inventory);
			//Plane inventory screens
			case 6: return new ContainerDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 0);
			case 7: return new ContainerDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 1);
			case 8: return new ContainerDriveableMenu(player.inventory, world, true, ((EntitySeat)player.getRidingEntity()).driveable);
			case 9: return new ContainerDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 2);
			case 10: return new ContainerMechaInventory(player.inventory, world, (EntityMecha)((EntitySeat)player.getRidingEntity()).driveable);
			case 11 : return null; //Armour box. No server side
			case 12 : return new ContainerDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 3);
			case 13: return new ContainerPaintjobTable(player.inventory, world, (TileEntityPaintjobTable)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	 }

	 @Override
     public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		 if(((ID >= 6 && ID <= 10) || ID == 12) && player.getRidingEntity() == null) return null;
		
		 switch(ID){
			case 0: return new GuiDriveableCrafting(player.inventory, world, x, y, z);
			case 1: return new GuiDriveableRepair(player);
			case 2: return new GuiGunModTable(player.inventory, world);
			case 5: return new GuiGunBox(player.inventory, ((BlockGunBox)world.getBlockState(new BlockPos(x, y, z)).getBlock()).type);
			case 6: return new GuiDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 0);
			case 7: return new GuiDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 1);
			case 8: return new GuiDriveableFuel		(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable);
			case 9: return new GuiDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 2);
			case 10: return new GuiMechaInventory	(player.inventory, world, (EntityMecha)((EntitySeat)player.getRidingEntity()).driveable);
			case 11: return new GuiArmourBox(player.inventory, ((BlockArmourBox)world.getBlockState(new BlockPos(x, y, z)).getBlock()).type);
			case 12: return new GuiDriveableInventory(player.inventory, world, ((EntitySeat)player.getRidingEntity()).driveable, 3);
			case 13: return new GuiPaintjobTable(player.inventory, world, (TileEntityPaintjobTable)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
     }
     
 	@SideOnly(Side.CLIENT)
 	public static void openGunBoxGui(EntityPlayer player, GunBoxType type) {
 		EntityPlayerMP playerMP = FMLClientHandler.instance().getServer().getPlayerList().getPlayerByUsername(player.getName());
 		FMLClientHandler.instance().displayGuiScreen(player, new GuiGunBox(playerMP.inventory, type));
 	}
}