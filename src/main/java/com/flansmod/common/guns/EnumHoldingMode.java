package com.flansmod.common.guns;


import javax.annotation.Nullable;

import org.apache.commons.lang3.tuple.Pair;

import com.flansmod.common.vector.Radian;
import com.flansmod.common.vector.Vector3f;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

/**
 * Describes what the player model should look in third person, when a gun is being held.
 */
public enum EnumHoldingMode
{

    DEFAULT("default")
            {
                @Override
                public Pair<Vector3f, Vector3f> getArmRotations(GunType gun, float partialTick, Vector3f looking, EntityLivingBase entity, EnumHandSide side, boolean itemInOtherHand)
                {
                    Vector3f thisArm = new Vector3f(looking), otherArm = null;
                    thisArm.x -= Radian.d90;
                    float ageInTicks = (float) entity.ticksExisted + partialTick;

                    Vector3f.add(thisArm, EnumHoldingMode.getAdditionalArmMovement(side, ageInTicks), thisArm);
                    if (!itemInOtherHand)
                    {
                        int flip = side == EnumHandSide.RIGHT ? 1 : -1;
                        otherArm = new Vector3f(looking);
                        otherArm.x -= Radian.d90;
                        otherArm.y += (float) 0.6 * flip;

                        Vector3f.add(otherArm, EnumHoldingMode.getAdditionalArmMovement(side.opposite(), ageInTicks), otherArm);
                    }
                    return Pair.of(thisArm, otherArm);
                }
            },
    KNIFE("knife")
            {
                //TODO
            },
    MINIGUN("minigun")
            {
                //TODO
            },
    CUSTOM("custom")
            {
                //TODO
            };
            //TODO mode modes



    private final String shortName;
    EnumHoldingMode(String shortName)
    {
        this.shortName = shortName;
    }

    public Pair<Vector3f, Vector3f> getArmRotations(GunType gun, float partialTick, Vector3f looking, EntityLivingBase entity, EnumHandSide side, boolean itemInOtherHand)
    {
        return null;
    }

    @Nullable
    public Vector3f getHandRotationFirstPerson()
    {
        //TODO
        return null;
    }

    @Deprecated
    private static Vector3f getAngles(Vec3d direction)
    {
        double len = direction.lengthVector(); //should be 1.0
        float x = (float) Math.sin(direction.xCoord / len);
        float y = (float) Math.sin(direction.yCoord / len);
        return new Vector3f(x, y, 0);
    }

    private static Vector3f getAdditionalArmMovement(EnumHandSide side, float ageInTicks)
    {
        return side == EnumHandSide.RIGHT ?
                new Vector3f(MathHelper.sin(ageInTicks * 0.067F) * 0.03F, 0, MathHelper.cos(ageInTicks * 0.09F) * 0.03F + 0.05F) :
                new Vector3f(-MathHelper.sin(ageInTicks * 0.067F) * 0.03F, 0, -MathHelper.cos(ageInTicks * 0.09F) * 0.03F + 0.05F);
    }
    //TODO: gun rotation

    public static EnumHoldingMode getHoldingMode(String s)
    {
        s = s.toLowerCase();
        for(EnumHoldingMode mode : EnumHoldingMode.values())
        {
            if (s.equals(mode.shortName))
            {
                return mode;
            }
        }
        return DEFAULT;
    }
}
