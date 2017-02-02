package com.flansmod.common.cmds;

import com.flansmod.common.driveables.EntitySeat;

import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class QuickFix extends CommandBase {
	
	public static final String NAME = "rs";
	
	@Override
	public String getName(){
		return NAME;
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "/" + NAME;
	}
	
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
    	if(sender instanceof EntityPlayer){
    		return true;
    	}
    	else return false;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(((Entity)sender).getRidingEntity() instanceof EntitySeat){
			EntitySeat entity = (EntitySeat)((EntityPlayer)sender).getRidingEntity();
			((EntityPlayer)sender).dismountRidingEntity();
			((EntityPlayer)sender).startRiding(entity);
		}
		else{
			Print.chat(sender, "This Command can be only executed while in being in a Vehicle.");
		}
	}
	
}