package com.flansmod.api;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IControllable
{
	/**
	 * This is fired every tick.
	 * @param deltaX  change in X of the mouse.
	 * @param deltaY change in Y of the mouse.
	 */
	public void onMouseMoved(int deltaX, int deltaY);

	/**
	 * 
	 * @param key the keycode of the key. see @link:KeyInputHandler
	 * @return boolean to indicate it this key was handled.
	 */
	public boolean pressKey(int key, EntityPlayer player);
	
	public void updateKeyHeldState(int key, boolean held);
	
	public boolean isDead();
	
	/** @return The player's view roll */
	public float getPlayerRoll();
	public float getPrevPlayerRoll();
	
	/** @return The player's 3rd person view distance */
	public float getCameraDistance();
	
	@SideOnly(Side.CLIENT)
	public EntityLivingBase getCamera();
}