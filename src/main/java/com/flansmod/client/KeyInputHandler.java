package com.flansmod.client;

import org.lwjgl.input.Keyboard;

import com.flansmod.api.IControllable;
import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value = Side.CLIENT)
public class KeyInputHandler{
	
	private static final String name = FlansMod.NAME;
	public static KeyBinding downKey          = new KeyBinding("Down key",              Keyboard.KEY_LCONTROL, name);
	public static KeyBinding inventoryKey     = new KeyBinding("Inventory key",         Keyboard.KEY_R, name);
	//public static KeyBinding bombKey          = new KeyBinding("Bomb Key",              Keyboard.KEY_V, name);
	//public static KeyBinding gunKey           = new KeyBinding("Gun Key",               Keyboard.KEY_B, name);
	public static KeyBinding controlSwitchKey = new KeyBinding("Control Switch key",    Keyboard.KEY_C, name);
	public static KeyBinding reloadKey        = new KeyBinding("Reload key",            Keyboard.KEY_R, name);
	public static KeyBinding leftRollKey      = new KeyBinding("Roll Left Key",         Keyboard.KEY_Z, name);
	public static KeyBinding rightRollKey     = new KeyBinding("Roll Right Key",        Keyboard.KEY_X, name);
	public static KeyBinding gearKey          = new KeyBinding("Gear Up / Down Key",    Keyboard.KEY_L, name);
	public static KeyBinding doorKey          = new KeyBinding("Door Open / Close Key", Keyboard.KEY_K, name);
	public static KeyBinding modeKey          = new KeyBinding("Mode Switch Key",       Keyboard.KEY_J, name);
	public static KeyBinding debugKey         = new KeyBinding("Debug Key",             Keyboard.KEY_F10, name);
	public static KeyBinding reloadModelsKey  = new KeyBinding("Reload Models Key",     Keyboard.KEY_F9, name);

	Minecraft mc;
	
	public KeyInputHandler(){
		ClientRegistry.registerKeyBinding(downKey);
		ClientRegistry.registerKeyBinding(inventoryKey);
		//ClientRegistry.registerKeyBinding(bombKey);
		//ClientRegistry.registerKeyBinding(gunKey);
		ClientRegistry.registerKeyBinding(controlSwitchKey);
		ClientRegistry.registerKeyBinding(reloadKey);
		ClientRegistry.registerKeyBinding(leftRollKey);
		ClientRegistry.registerKeyBinding(rightRollKey);
		ClientRegistry.registerKeyBinding(gearKey);
		ClientRegistry.registerKeyBinding(doorKey);
		ClientRegistry.registerKeyBinding(modeKey);
		ClientRegistry.registerKeyBinding(debugKey);
		ClientRegistry.registerKeyBinding(reloadModelsKey);
		mc = Minecraft.getMinecraft();
	}

	public void checkKeyInput(KeyInputEvent event){
		if(FMLClientHandler.instance().isGUIOpen(GuiChat.class) || mc.currentScreen != null){
			return;
		}
		
		
		/*//Handle universal keys
		if(reloadKey.isPressed()){
			PlayerData data = PlayerHandler.getPlayerData(player, Side.CLIENT);
			ItemStack stack = player.getHeldItemMainhand();
			if(data.shootTimeRight <= 0.0f){
				if(stack != null && stack.getItem() instanceof ItemGun){
					ItemGun item = (ItemGun)stack.getItem();
					GunType type = item.getInfoType();
					
					if(item.CanReload(stack, player.inventory)){
						//TODO FlansMod.getPacketHandler().sendToServer(new PacketReload(EnumHandSide.RIGHT, true));
	
						//Set player shoot delay to be the reload delay
						//Set both gun delays to avoid reloading two guns at once
						data.shootTimeRight = data.shootTimeLeft = (int)type.getReloadTime(stack);
						
						GunAnimations animations = FlansModClient.getGunAnimations(player, EnumHandSide.RIGHT);
		
						int pumpDelay = type.model == null ? 0 : type.model.pumpDelayAfterReload;
						int pumpTime = type.model == null ? 1 : type.model.pumpTime;
						animations.doReload(type.reloadTime, pumpDelay, pumpTime);
						
						data.reloadingRight = true;
						data.burstRoundsRemainingRight = 0;
					}
				}
			}
		}*/
		/*if(debugKey.isPressed()){
			if(FlansMod.DEBUG){
				FlansMod.DEBUG = false;
			}
			else{
				//FlansMod.packetHandler.sendToServer(new PacketRequestDebug());
				JsonObject obj = JsonUtil.getJsonForPacket("flansmod_debug");
				obj.addProperty("task", "debug");
				PacketHandler.getInstance().sendToServer(new PacketJsonObject(obj));
			}
		}*/

		EntityPlayer player = mc.thePlayer;
		if(reloadModelsKey.isPressed()){
			Print.chat(player, "Reloading resources.");
			FlansModClient.reloadModels(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT));
		}
		Entity ridingEntity = player.getRidingEntity();
		if(ridingEntity instanceof IControllable){
			IControllable riding = (IControllable)ridingEntity;
			if(mc.gameSettings.keyBindForward.isPressed()){
				riding.pressKey(0, player);
			}
			if(mc.gameSettings.keyBindBack.isPressed()){
				riding.pressKey(1, player);
			}
			if(mc.gameSettings.keyBindLeft.isPressed()){
				riding.pressKey(2, player);
			}
			if(mc.gameSettings.keyBindRight.isPressed()){
				riding.pressKey(3, player);
			}
			if(mc.gameSettings.keyBindJump.isPressed()){
				riding.pressKey(4, player);
			}
			if(downKey.isPressed()){
				riding.pressKey(5, player);
			}
			if(mc.gameSettings.keyBindSneak.isPressed()){
				riding.pressKey(6, player);
			}
			if(mc.gameSettings.keyBindInventory.isPressed() || inventoryKey.isPressed()){
				riding.pressKey(7, player);
			}
			/*if(bombKey.isPressed()){
				riding.pressKey(8, player);
			}
			if(gunKey.isPressed()){
				riding.pressKey(9, player);
			}*/
			if(controlSwitchKey.isPressed()){
				riding.pressKey(10, player);
			}
			if(leftRollKey.isPressed()){
				riding.pressKey(11, player);
			}
			if(rightRollKey.isPressed()){
				riding.pressKey(12, player);
			}
			if(gearKey.isPressed()){
				riding.pressKey(13, player);
			}
			if(doorKey.isPressed()){
				riding.pressKey(14, player);
			}
			if(modeKey.isPressed()){
				riding.pressKey(15, player);
			}
		}
	}
}
