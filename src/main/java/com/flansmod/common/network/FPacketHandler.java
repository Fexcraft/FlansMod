package com.flansmod.common.network;

import com.flansmod.common.network.handlers.DriveableControlPacketHandler;
import com.flansmod.common.network.handlers.DriveableKeyPacketHandler;
import com.flansmod.common.network.handlers.VehicleControlPacketHandler;
import com.flansmod.common.network.packets.PacketDriveableControl;
import com.flansmod.common.network.packets.PacketDriveableKey;
import com.flansmod.common.network.packets.PacketVehicleControl;

import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * 
 * @author Ferdinand (FEX___96)
 * Based on the FCL/FRSM PacketHandler.
 * 
 */
public class FPacketHandler {
	
	public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("flansmod");
	private static int id = -1;
	
	public static void initialise(){
		Print.log("[Flan's Mod] Initialising Packet Handler.");
		instance.registerMessage(DriveableKeyPacketHandler.class,                 PacketDriveableKey.class,        id++, Side.SERVER);
		instance.registerMessage(DriveableControlPacketHandler.Server.class,      PacketDriveableControl.class,    id++, Side.SERVER);
		instance.registerMessage(DriveableControlPacketHandler.Client.class,      PacketDriveableControl.class,    id++, Side.CLIENT);
		instance.registerMessage(VehicleControlPacketHandler.Server.class,        PacketVehicleControl.class,      id++, Side.SERVER);
		instance.registerMessage(VehicleControlPacketHandler.Client.class,        PacketVehicleControl.class,      id++, Side.CLIENT);
		Print.log("[Flan's Mod] Done initialising Packet Handler.");
	}
	
	public static SimpleNetworkWrapper getInstance(){
		return instance;
	}
	
}