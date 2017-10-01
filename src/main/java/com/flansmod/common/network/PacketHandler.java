package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.network.handlers.*;
import com.flansmod.common.network.packets.*;
import com.flansmod.fvtm.FvtmHook;

import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * 
 * @author Ferdinand (FEX___96)
 * Based on the FCL/FRSM PacketHandler.
 * 
 */
public class PacketHandler {
	
	public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("flansmod");
	private static int id = -1;
	
	public static void initialise(){
		Print.log("[Flan's Mod Minus] Initialising Packet Handler.");
		instance.registerMessage(EmptyPacketHandler.class,                        PacketEmpty.class,               id++, Side.SERVER);//DEBUG
		instance.registerMessage(EmptyPacketHandler.class,                        PacketEmpty.class,               id++, Side.CLIENT);//DEBUG
		instance.registerMessage(DriveableKeyPacketHandler.class,                 PacketDriveableKey.class,        id++, Side.SERVER);
		instance.registerMessage(DriveableControlPacketHandler.Server.class,      PacketDriveableControl.class,    id++, Side.SERVER);
		instance.registerMessage(DriveableControlPacketHandler.Client.class,      PacketDriveableControl.class,    id++, Side.CLIENT);
		instance.registerMessage(VehicleControlPacketHandler.Server.class,        PacketVehicleControl.class,      id++, Side.SERVER);
		instance.registerMessage(VehicleControlPacketHandler.Client.class,        PacketVehicleControl.class,      id++, Side.CLIENT);
		instance.registerMessage(PlaneControlPacketHandler.Server.class,          PacketPlaneControl.class,        id++, Side.SERVER);
		instance.registerMessage(PlaneControlPacketHandler.Client.class,          PacketPlaneControl.class,        id++, Side.CLIENT);
		instance.registerMessage(SeatUpdatePacketHandler.Server.class,            PacketSeatUpdate.class,          id++, Side.SERVER);
		instance.registerMessage(SeatUpdatePacketHandler.Client.class,            PacketSeatUpdate.class,          id++, Side.CLIENT);
		instance.registerMessage(DriveableColorPacketHandler.Client.class,        PacketDriveableColor.class,      id++, Side.CLIENT);
		instance.registerMessage(DriveableSyncPacketHandler.Server.class,         PacketDriveableSync.class,       id++, Side.SERVER);
		instance.registerMessage(DriveableSyncPacketHandler.Client.class,         PacketDriveableSync.class,       id++, Side.CLIENT);
		instance.registerMessage(DriveableTexturePacketHandler.Client.class,      PacketDriveableTexture.class,    id++, Side.CLIENT);
		instance.registerMessage(SeatDismountPacketHandler.Client.class,          PacketSeatDismount.class,        id++, Side.CLIENT);
		instance.registerMessage(PlaySoundPacketHandler.Server.class,             PacketPlaySound.class,           id++, Side.SERVER);
		instance.registerMessage(PlaySoundPacketHandler.Client.class,             PacketPlaySound.class,           id++, Side.CLIENT);
		if(FlansMod.FVTM){
			FvtmHook.registerPackets(instance, id);
		}
		
		net.fexcraft.mod.lib.network.PacketHandler.registerListener(PacketHandlerType.JSON, Side.CLIENT, new JsonPacketHandler.Client());
		net.fexcraft.mod.lib.network.PacketHandler.registerListener(PacketHandlerType.JSON, Side.SERVER, new JsonPacketHandler.Server());
		
		Print.log("[Flan's Mod Minus] Done initialising Packet Handler.");
	}
	
	public static SimpleNetworkWrapper getInstance(){
		return instance;
	}
	
}