package com.flansmod.common;

import java.lang.reflect.Field;

import com.flansmod.common.util.Util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;

public class FlansUtils
{
    /**
     * @return The side of the given {@param hand}.
     */
    public static EnumHandSide getSideForHand(EnumHand hand, EntityLivingBase entity)
    {
        return hand == EnumHand.MAIN_HAND ? entity.getPrimaryHand() : entity.getPrimaryHand().opposite();
    }

    /**
     * @return The hand on the given {@param side}.
     */
    public static EnumHand getHandForSide(EnumHandSide side, EntityLivingBase entity)
    {
        return side == entity.getPrimaryHand() ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND;
    }
    public static ItemStack getItemOnSide(EnumHandSide side, EntityLivingBase entity)
    {
        return entity.getHeldItem(side == entity.getPrimaryHand() ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND);
    }
    public static EnumHand getHandWithItem(EntityLivingBase entity, ItemStack stack)
    {
        if (stack == entity.getHeldItemMainhand())
        {
            return EnumHand.MAIN_HAND;
        }
        else if (stack == entity.getHeldItemOffhand())
        {
            return EnumHand.OFF_HAND;
        }
        else
        {
            throw new UnsupportedOperationException("Requested the hand with an item that was held in neither of the hands.");
        }
    }
    public static EnumHandSide getSideWithItem(EntityLivingBase entity, ItemStack stack)
    {
        return getSideForHand(getHandWithItem(entity, stack), entity);
    }

    public static void copy(Object from, Object to){
        for(Field field : from.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try{
                field.set(to, field.get(from));
            }
            catch(IllegalAccessException e){
            	Util.error(String.format("Could not set field %s while copying class %s.", field.getName(), from.getClass().getName()), e);
            }

        }
    }
}
