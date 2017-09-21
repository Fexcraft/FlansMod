package com.flansmod.fvtm;

import com.flansmod.client.model.RenderNull;
import com.flansmod.common.FlansMod;
import com.flansmod.fvtm.packets.FvmPacketSeatUpdate;
import com.flansmod.fvtm.packets.PacketVehicleControl;
import com.flansmod.fvtm.packets.SeatUpdatePacketHandler;
import com.flansmod.fvtm.packets.VehicleControlPacketHandler;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * FVTM-Hook package, adds working Vehicles for FVTM using Flansmod physics/api.
 * <br>Until FVTM has it's own entities (if ever).
 * 
 * @author Ferdinand (FEX___96)
 *
 */
public class FvtmHook {

	public static void registerEntities(){
		EntityRegistry.registerModEntity(new ResourceLocation(FlansMod.MODID, "fvtm_vehicle"), LandVehicle.class, "fvtm_vehicle", 96, FlansMod.INSTANCE, 256, 5, false);
		EntityRegistry.registerModEntity(new ResourceLocation(FlansMod.MODID, "fvtm_seat"), EntitySeat.class, "fvtm_seat", 100, FlansMod.INSTANCE, 256, 5, false);
		EntityRegistry.registerModEntity(new ResourceLocation(FlansMod.MODID, "fvtm_wheel"), EntityWheel.class, "fvtm_wheel", 104, FlansMod.INSTANCE, 256, 10, false);
	}

	public static void registerPackets(SimpleNetworkWrapper instance, int id){
		instance.registerMessage(SeatUpdatePacketHandler.Client.class, FvmPacketSeatUpdate.class, id++, Side.CLIENT);
		instance.registerMessage(SeatUpdatePacketHandler.Server.class, FvmPacketSeatUpdate.class, id++, Side.SERVER);
		instance.registerMessage(VehicleControlPacketHandler.Client.class, PacketVehicleControl.class, id++, Side.CLIENT);
		instance.registerMessage(VehicleControlPacketHandler.Server.class, PacketVehicleControl.class, id++, Side.SERVER);
	}

	public static void registerRenders(){
		net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(LandVehicle.class, RenderVehicle::new);
		net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(EntitySeat.class, RenderNull::new);		
		net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(EntityWheel.class, RenderNull::new);
	}
	
}