package com.flansmod.fvm;

import com.flansmod.client.model.RenderNull;
import com.flansmod.common.FlansMod;
import com.flansmod.fvm.packets.FvmPacketSeatUpdate;
import com.flansmod.fvm.packets.PacketVehicleControl;
import com.flansmod.fvm.packets.SeatUpdatePacketHandler;
import com.flansmod.fvm.packets.VehicleControlPacketHandler;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * FVM-Hook package, adds working Vehicles for FVM using Flansmod physics/api.
 * <br>Until FVM has it's own entities (if ever).
 * 
 * @author Ferdinand (FEX___96)
 *
 */
public class FvmHook {

	public static void registerEntities(){
		EntityRegistry.registerModEntity(new ResourceLocation(FlansMod.MODID, "fvm_vehicle"), LandVehicle.class, "fvm_vehicle", 96, FlansMod.INSTANCE, 256, 5, false);
		EntityRegistry.registerModEntity(new ResourceLocation(FlansMod.MODID, "fvm_seat"), EntitySeat.class, "fvm_seat", 100, FlansMod.INSTANCE, 256, 5, false);
		EntityRegistry.registerModEntity(new ResourceLocation(FlansMod.MODID, "fvm_wheel"), EntityWheel.class, "fvm_wheel", 104, FlansMod.INSTANCE, 256, 10, false);
	}

	public static void registerPackets(SimpleNetworkWrapper instance, int id){
		instance.registerMessage(SeatUpdatePacketHandler.Client.class, FvmPacketSeatUpdate.class, id++, Side.CLIENT);
		instance.registerMessage(SeatUpdatePacketHandler.Server.class, FvmPacketSeatUpdate.class, id++, Side.SERVER);
		instance.registerMessage(VehicleControlPacketHandler.Client.class, PacketVehicleControl.class, id++, Side.CLIENT);
		instance.registerMessage(VehicleControlPacketHandler.Server.class, PacketVehicleControl.class, id++, Side.SERVER);
	}

	public static void registerRenders(){
		RenderingRegistry.registerEntityRenderingHandler(LandVehicle.class, RenderVehicle::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySeat.class, RenderNull::new);		
		RenderingRegistry.registerEntityRenderingHandler(EntityWheel.class, RenderNull::new);
	}
	
}