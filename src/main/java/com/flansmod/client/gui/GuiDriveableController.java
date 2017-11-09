package com.flansmod.client.gui;

import java.io.IOException;
import java.text.DecimalFormat;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import com.flansmod.api.IControllable;
import com.flansmod.client.FlansModClient;
import com.flansmod.client.KeyInputHandler;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

public class GuiDriveableController extends GuiScreen {
	
	private IControllable plane;
	private boolean leftMouseHeld;
	private boolean rightMouseHeld;
	//private double maxspeed, negspeed;
	
	public GuiDriveableController(IControllable thePlane){
		super();
		plane = thePlane;
		/*if(plane instanceof LandVehicle){
			LandVehicle landveh = (LandVehicle)plane;
			if(landveh.data.getPart("engine") == null){
				maxspeed = 1;
				negspeed = -1;
			}
			else{
				maxspeed = landveh.data.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed() * landveh.data.getVehicle().getFMMaxPositiveThrottle();
				negspeed = landveh.data.getPart("engine").getPart().getAttribute(EngineAttribute.class).getEngineSpeed() * landveh.data.getVehicle().getFMMaxNegativeThrottle();
			}
		}*/
	}
	
	@Override
	public void initGui(){
		if(mc.gameSettings.thirdPersonView == 1)
			mc.setRenderViewEntity((plane.getCamera() == null ? mc.player : plane.getCamera()));
	}
	
	@Override
	public void onGuiClosed(){
		mc.mouseHelper.ungrabMouseCursor();
		mc.setRenderViewEntity(mc.player);
    }
	
	@Override
	public void handleMouseInput(){
		EntityPlayer player = (EntityPlayer)((Entity)plane).getControllingPassenger();
		if(player != mc.player){
			mc.displayGuiScreen(null);
			return;
		}
		
		int dWheel = Mouse.getDWheel();
		if(dWheel != 0){
			player.inventory.changeCurrentItem(dWheel);
		}
		
		//Right mouse. Fires shells, drops bombs. Is not a holding thing
		if(Mouse.isButtonDown(1)){
			plane.pressKey(8, player);
		}
		
		if(!leftMouseHeld&& Mouse.isButtonDown(0)) //Left mouse, for MGs. Is a holding thing
		{
			leftMouseHeld = true;
			plane.updateKeyHeldState(9, true);
		}
		if(leftMouseHeld && !Mouse.isButtonDown(0))
		{
			leftMouseHeld = false;
			plane.updateKeyHeldState(9, false);
		}
		if(!rightMouseHeld && Mouse.isButtonDown(1)) //Right mouse
		{
			rightMouseHeld = true;
			plane.updateKeyHeldState(8, true);
		}
		if(rightMouseHeld && !Mouse.isButtonDown(1))
		{
			rightMouseHeld = false;
			plane.updateKeyHeldState(8, false);
		}
	}
	
	@Override
	protected void keyTyped(char c, int i){
		if(i == 1){
			mc.displayGuiScreen(null);
			mc.displayInGameMenu();
		}
		if(i == 59)
		{
			mc.gameSettings.hideGUI = !mc.gameSettings.hideGUI;
		}
		if(i == 61)
		{
			mc.gameSettings.showDebugInfo = !mc.gameSettings.showDebugInfo;
		}
		if(i == 63)
		{
			mc.gameSettings.thirdPersonView = (mc.gameSettings.thirdPersonView + 1) % 3;
			if(mc.gameSettings.thirdPersonView == 1)
				mc.setRenderViewEntity((plane.getCamera() == null ? mc.player : plane.getCamera()));
			else mc.setRenderViewEntity(mc.player);
		}
		if(i == 66)
		{
			mc.gameSettings.smoothCamera = !mc.gameSettings.smoothCamera;
		}
		if(i == mc.gameSettings.keyBindInventory.getKeyCode())
		{
			mc.displayGuiScreen(new GuiInventory(mc.player));
		}
		if(i == mc.gameSettings.keyBindDrop.getKeyCode())
		{
			//mc.thePlayer.dropCurrentItem();
		}
		if(i == mc.gameSettings.keyBindChat.getKeyCode())
		{
			mc.displayGuiScreen(new GuiChat());
		}
		if(i == mc.gameSettings.keyBindCommand.getKeyCode())
		{
			mc.displayGuiScreen(new GuiChat("/"));
		}
		if(i == KeyInputHandler.debugKey.getKeyCode())
		{
			FlansMod.DEBUG = !FlansMod.DEBUG;
		}
		if(i == KeyInputHandler.reloadModelsKey.getKeyCode())
		{
			FlansModClient.reloadModels(false);
		}
		/*if(plane instanceof com.flansmod.fvtm.EntitySeat){
			plane.pressKey(-2, mc.player);
		}*/
	}
	
	@Override
	public void updateScreen(){
		if(mc.gameSettings.thirdPersonView == 1){
			mc.setRenderViewEntity((plane.getCamera() == null ? mc.player : plane.getCamera()));
		}
		else mc.setRenderViewEntity(mc.player);
	}
	
	@Override
	public void handleInput(){
		EntityPlayer player = (EntityPlayer)((Entity)plane).getControllingPassenger();
		if(player != mc.player){
			mc.displayGuiScreen(null);
			return;
		}
		if(!Mouse.isGrabbed()){
			mc.mouseHelper.grabMouseCursor();
		}
		handleMouseInput();

        for(; Keyboard.next(); ) {try {handleKeyboardInput();} catch(IOException e){} }
        
		int l = Mouse.getDX();
		int m = Mouse.getDY();
		
		plane.onMouseMoved(l, m);

		if(plane != null && !plane.isDead() && ((Entity)plane).getControllingPassenger() != null && ((Entity)plane).getControllingPassenger() instanceof EntityPlayer){
			if(FlansMod.proxy.keyDown(mc.gameSettings.keyBindForward.getKeyCode()))//KeyInputHandler.accelerateKey.getKeyCode()))
			{
				plane.pressKey(0, player);
			}
			if(FlansMod.proxy.keyDown(mc.gameSettings.keyBindBack.getKeyCode()))//KeyInputHandler.decelerateKey.getKeyCode()))
			{
				plane.pressKey(1, player);
			}
			if(FlansMod.proxy.keyDown(mc.gameSettings.keyBindLeft.getKeyCode()))//KeyInputHandler.leftKey.getKeyCode()))
			{
				plane.pressKey(2, player);
			}
			if(FlansMod.proxy.keyDown(mc.gameSettings.keyBindRight.getKeyCode()))//KeyInputHandler.rightKey.getKeyCode()))
			{
				plane.pressKey(3, player);
			}	
			if(FlansMod.proxy.keyDown(mc.gameSettings.keyBindJump.getKeyCode()))//KeyInputHandler.upKey.getKeyCode()))
			{
				plane.pressKey(4, player);
			}
			if(FlansMod.proxy.keyDown(KeyInputHandler.downKey.getKeyCode()))
			{
				plane.pressKey(5, player);
			}	
			if(FlansMod.proxy.keyDown(mc.gameSettings.keyBindSneak.getKeyCode()))//KeyInputHandler.exitKey.getKeyCode()))
			{
				plane.pressKey(6, player);
			}	
			if(FlansMod.proxy.keyDown(KeyInputHandler.inventoryKey.getKeyCode()))
			{
				plane.pressKey(7, player);
			}
			/*if(FlansMod.proxy.keyDown(KeyInputHandler.bombKey.getKeyCode()))
			{
				plane.pressKey(8, player);
			}
			if(FlansMod.proxy.keyDown(KeyInputHandler.gunKey.getKeyCode()))
			{
				plane.pressKey(9, player);
			}*/			
			if(FlansMod.proxy.keyDown(KeyInputHandler.controlSwitchKey.getKeyCode()))
			{
				plane.pressKey(10, player);
			}				
			if(FlansMod.proxy.keyDown(KeyInputHandler.leftRollKey.getKeyCode()))
			{
				plane.pressKey(11, player);
			}				
			if(FlansMod.proxy.keyDown(KeyInputHandler.rightRollKey.getKeyCode()))
			{
				plane.pressKey(12, player);
			}				
			if(FlansMod.proxy.keyDown(KeyInputHandler.gearKey.getKeyCode()))
			{
				plane.pressKey(13, player);
			}				
			if(FlansMod.proxy.keyDown(KeyInputHandler.doorKey.getKeyCode()))
			{
				plane.pressKey(14, player);
			}				
			if(FlansMod.proxy.keyDown(KeyInputHandler.modeKey.getKeyCode()))
			{
				plane.pressKey(15, player);
			}
			//if(FlansMod.proxy.keyDown(KeyInputHandler.trimKey.getKeyCode()))
			//{
			//	plane.pressKey(16, player);
			//}
		}
		else{
			mc.displayGuiScreen(null);
		}
	}
	   
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(0, 0, 0, 0, 206, 36);
		//
		EntityDriveable ent = ((EntitySeat)mc.player.getRidingEntity()).driveable;
		mc.fontRenderer.drawString("Speed: " + calculateSpeed(ent) + " ck/m", 7, 7, 0xffffff);
		mc.fontRenderer.drawString("Throttle: " + pc(ent.throttle) + "%", 7, 21, 0xffffff);
	}

	private String pc(double f){
		return format(f * 100);
	}
	
	private static final DecimalFormat df = new DecimalFormat("##.##");
	//static { df.setRoundingMode(RoundingMode.DOWN); }
	
	public static String format(double d){
		return df.format(d);
	}

	public static float calculateSpeed(Entity ent){
		double dX = ent.posX - ent.prevPosX, dY = ent.posY - ent.prevPosY, dZ = ent.posZ - ent.prevPosZ;
		float speed = (float)Math.sqrt(dX * dX + dY * dY + dZ * dZ) * 1000F / 16F; 
		return speed = (int)(speed * 10F) / 10F;
	}
	
	private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/vehicle_stat.png");

	@Override
	public boolean doesGuiPauseGame(){
		return false;
	}
}
