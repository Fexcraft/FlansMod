package com.flansmod.common.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flansmod.common.FlansMod;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
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
	
    public static Vec3d getVectorForRotation(float pitch, float yaw){
        float f = MathHelper.cos(-yaw * 0.017453292F - (float)Math.PI);
        float f1 = MathHelper.sin(-yaw * 0.017453292F - (float)Math.PI);
        float f2 = -MathHelper.cos(-pitch * 0.017453292F);
        float f3 = MathHelper.sin(-pitch * 0.017453292F);
        return new Vec3d((double)(f1 * f2), (double)f3, (double)(f * f2));
    }
    
    public static boolean isNull(String s){
    	if(s == null){
    		return true;
    	}
    	else if(s.equals("")){
    		return true;
    	}
    	else return false;
    }

	public static long getTime(){
		return new Date().getTime();
	}

	public static String randomKeyCode(){
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		s = s.replace("-", "");
		return s.substring(0, 7);
	}
}