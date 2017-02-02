package com.flansmod.common.cmds;

import com.flansmod.common.data.player.PlayerHandler;

import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class TextureCommand extends CommandBase {
	
	public static final String NAME = "fmTexture";
	
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
		if(args.length < 1){
			Print.chat(sender, "No Arguments speficied.");
			Print.chat(sender, "/" + NAME + " ?");
		}
		else if(args[0].equals("help") || args[0].equals("?")){
			Print.chat(sender, "Availavble subcommads:");
			Print.chat(sender, "/" + NAME + " help");
			Print.chat(sender, "/" + NAME + " reset");
			Print.chat(sender, "/" + NAME + " current");
			Print.chat(sender, "/" + NAME + " <URL>");
		}
		else if(args[0].equals("reset")){
			Print.chat(sender, "Texture clipload cleared.");
			PlayerHandler.getData((EntityPlayer)sender).setTextureURL(null);
		}
		else if(args[0].equals("current")){
			Print.chat(sender, "Current Texture URL:");
			Print.chat(sender, PlayerHandler.getData((EntityPlayer)sender).getTextureURL());
		}
		else{
			PlayerHandler.getData((EntityPlayer)sender).setTextureURL(args[0]);
			Print.chat(sender, "URL set to: " + args[0]);
		}
	}
	
}