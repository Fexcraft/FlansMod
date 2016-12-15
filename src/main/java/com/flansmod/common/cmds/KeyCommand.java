package com.flansmod.common.cmds;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.util.Config;

import net.fexcraft.mod.lib.util.cls.Print;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;

public class KeyCommand extends CommandBase {
	
	public static final String NAME = "fmKey";
	
	@Override
	public String getName(){
		return NAME;
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "/" + NAME;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer == false){
			Print.chat(sender, "This command cann be only executed ingame!");
			return;
		}
		if(((Entity)sender).getRidingEntity() instanceof EntitySeat == false){
			Print.chat(sender, "You must be inside a vehicle to generate a key.");
			return;
		}
		if(args.length < 1){
			Print.chat(sender, "No Arguments speficied.");
			Print.chat(sender, "/" + NAME + " ?");
		}
		else if(args[0].equals("help") || args[0].equals("?")){
			Print.chat(sender, "Availavble subcommads:");
			Print.chat(sender, "/" + NAME + " help");
			Print.chat(sender, "/" + NAME + " universal");
			Print.chat(sender, "/" + NAME + " get <one/all>");
		}
		else if(args[0].equals("universal")){
			if(server.getOpPermissionLevel() > 2){
				givePlayerKey((EntityPlayer)sender, true, 1);
			}
			else{
				Print.chat(sender, "No Permission.");
			}
		}
		else if(args[0].equals("get")){
			if(args.length < 2){
				Print.chat(sender, "Missing argument.");
				Print.chat(sender, "try: /" + NAME + " get <one/all>");
			}
			else if(args[1].equals("one")){
				givePlayerKey((EntityPlayer)sender, false, 1);
			}
			else if(args[1].equals("all")){
				givePlayerKey((EntityPlayer)sender, false, Config.maxVehicleKeys);
			}
			else{
				Print.chat(sender, "Invalid argument.");
				Print.chat(sender, "try: /" + NAME + " get <one/all>");
			}
		}
		else{
			Print.chat(sender, "Wrong argument.");
			Print.chat(sender, "/" + NAME + " ?");
		}
	}

	private void givePlayerKey(EntityPlayer sender, boolean universal, int i){
		EntityDriveable driveable = ((EntitySeat)sender.getRidingEntity()).driveable;
		if(!driveable.driveableData.hasLock){
			Print.chat(sender, "This vehicle doesn't allow locking.");
			return;
		}
		for(int j = 0; j < i; j++){
			if((driveable.driveableData.spawnedKeys + 1) <= Config.maxVehicleKeys){
				ItemStack stack = new ItemStack(FlansMod.key, 1, 0);
				if(stack.getTagCompound() == null){
					stack.setTagCompound(new NBTTagCompound());
				}
				stack.getTagCompound().setString("owner", sender.getGameProfile().getId().toString());
				stack.getTagCompound().setString("code", driveable.driveableData.lock_code);
				stack.getTagCompound().setBoolean("universal", universal);
				stack.getTagCompound().setString("vehicle", driveable.driveableData.type);
				sender.inventory.addItemStackToInventory(stack);
				driveable.driveableData.spawnedKeys++;
			}
			else{
				Print.chat(sender, "Reached limit of spawned keys for this vehicle.");
			}
		}
	}
	
}