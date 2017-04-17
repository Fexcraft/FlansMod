package com.flansmod.client;

import java.io.File;
import java.util.ArrayList;
import com.flansmod.api.IControllable;
import com.flansmod.client.gui.GuiDriveableController;
import com.flansmod.common.FlansMod;
import com.flansmod.common.util.Util;
import com.flansmod.common.vector.Vector3i;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class FlansModClient extends FlansMod {
	
	//Plane / Vehicle control handling
	/** Whether the player has received the vehicle tutorial text */
	public static boolean doneTutorial = false;
	/** Whether the player is in mouse control mode */
	public static boolean controlModeMouse = true;
	/** A delayer on the mouse control switch */
	public static int controlModeSwitchTimer = 20;

	//Variables to hold the state of some settings so that after being hacked for scopes, they may be restored
	/** The player's mouse sensitivity setting, as it was before being hacked by my mod */
	public static float originalMouseSensitivity = 0.5F;
	/** The player's original FOV */
	public static float originalFOV = 90F;
	/** The original third person mode, before being hacked */
	public static int originalThirdPerson = 0;
	
	/** Whether the player is in a plane or not */
	public static boolean inPlane = false;
	
	/** When a round ends, the teams score GUI is locked for this length of time */
	public static int teamsScoreGUILock = 0;	
	
	public static int hitMarkerTime = 0;
		
	public static ArrayList<Vector3i> blockLightOverrides = new ArrayList<Vector3i>();
	public static int lightOverrideRefreshRate = 5;
	
	public void load()
	{		
		Util.log("Loading Flan's mod client side.");

	}

	public static void tick(){
		if (minecraft.player == null || minecraft.world == null)
			return;
		
		if(minecraft.player.getRidingEntity() instanceof IControllable && minecraft.currentScreen == null){
			minecraft.displayGuiScreen(new GuiDriveableController((IControllable)minecraft.player.getRidingEntity()));
		}
		
		if(minecraft.player.getRidingEntity() instanceof IControllable){
			inPlane = true;	
			try{
				ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.entityRenderer, ((IControllable)minecraft.player.getRidingEntity()).getCameraDistance(), "thirdPersonDistance", "q", "field_78490_B");
			}
			catch (Exception e){
				Util.log("I forgot to update obfuscated reflection D:");
				throw new RuntimeException(e);
			}		
		}
		else if(inPlane){
			try{
				ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.entityRenderer, 4.0F, "thirdPersonDistance", "q", "field_78490_B");
			}
			catch (Exception e){
				Util.log("I forgot to update obfuscated reflection D:");
				throw new RuntimeException(e);
			}	
			inPlane = false;
		}
		if (controlModeSwitchTimer > 0)
			controlModeSwitchTimer--;
	}
		
	private boolean checkFileExists(File file)
	{
		if(!file.exists())
		{
			try
			{ 
				file.createNewFile();
			}
			catch(Exception e)
			{
				Util.log("Failed to create file");
				Util.log(file.getAbsolutePath());
			}
			return false;
		}	
		return true;
	}

	public static boolean flipControlMode(){
		if(controlModeSwitchTimer > 0){
			return false;
		}
		controlModeMouse = !controlModeMouse;
		FMLClientHandler.instance().getClient().displayGuiScreen(controlModeMouse ? new GuiDriveableController((IControllable)FMLClientHandler.instance().getClient().player.getRidingEntity()) : null);
		controlModeSwitchTimer = 40;
		return true;
	}
	
	public static void reloadModels(boolean reloadSkins){
		//loop datatypes - reload models
		if(reloadSkins){
			proxy.forceReload();
		}
	}
	
	public static Minecraft minecraft = FMLClientHandler.instance().getClient();
	
}
