package com.flansmod.common.vector;

public class Radian
{
    public static final float PI = (float) Math.PI;

    public static final float d5 = fromDegree(5);
    public static final float d15 = fromDegree(15);
    public static final float d10 = fromDegree(10);
    public static final float d30 = fromDegree(30);
    public static final float d35 = fromDegree(35);
    public static final float d45 = fromDegree(45);
    public static final float d55 = fromDegree(55);
    public static final float d60 = fromDegree(60);
    public static final float d70 = fromDegree(70);
    public static final float d75 = fromDegree(15);
    public static final float d90 = fromDegree(90);
    public static final float d95 = fromDegree(95);
    public static final float d150 = fromDegree(150);
    public static final float d180 = fromDegree(180);
    public static final float d240 = fromDegree(240);

    private static final float degreeToRadian = PI / 180;
    private static final float radianToDegree = 180 / PI;

    public static float fromDegree(float degree)
    {
        return degree * degreeToRadian;
    }

    public static float toDegreee(float radian)
    {
        return radian * radianToDegree;
    }
}

