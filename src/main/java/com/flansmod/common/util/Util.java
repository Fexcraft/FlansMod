package com.flansmod.common.util;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flansmod.common.FlansMod;

import net.minecraftforge.fml.common.FMLCommonHandler;

public class Util {
	
	private static Logger logger = LogManager.getLogger(FlansMod.NAME);
	private static final Random random = new Random();

	public static void log(Object log){
		logger.info(String.valueOf(log));
	}

	public static void error(String message, Throwable e){
		logger.error(message, e);
	}
	
	public static void exit(){
		FMLCommonHandler.instance().exitJava(1, false);
	}
	
	public static int nextInt(int i){
		return random.nextInt(i);
	}
}