package com.flansmod.fvtm;

import com.flansmod.common.vector.Vector3f;

import net.fexcraft.mod.lib.util.math.Pos;

public class Seat 
{
	/** The x, y and z positions of the seat within the plane in model co-ordinates
	 * x is forwards, y is up and z is left */
	public Pos pos;
	/** The id of this seat */
	public int id;
	/** Limits for the look vector of the seat. Range is -360 to 360. Thus any range should lie in here without having to wrap */
	public float minYaw = -360F, maxYaw = 360F;
	/** Limits for the look vector of the seat. Range is -90 to 90, but don't go beyond +/-89 or the view will mess up at the poles */
	public float minPitch = -89F, maxPitch = 89F;
	/** For turret mounted seats on tanks, the seat will be positioned differently according to this offset and the yaw of the turret */
	public Vector3f rotatedOffset = new Vector3f();
	/** Yaw/Pitch rotation speeds (Yaw/Pitch/z) where Z is ignored*/
	public Vector3f aimingSpeed = new Vector3f(1f, 1f, 0f);
	/** Legacy aiming mode*/
	public boolean legacyAiming = false;
	/** Traverse Yaw before pitching */
	public boolean yawBeforePitch = false;
	/** Pitches gun at the last second */
	public boolean latePitch = true;
	
	/**Does the turret have traverse sounds?*/
	public boolean traverseSounds = false;
	
	public String yawSound;
	public int yawSoundLength;
	public String pitchSound;
	public int pitchSoundLength;
	
	/** Type file constructor. Line from type file should be of one of the following forms
	 * Passenger ID x y z
	 * Passenger ID x y z minYaw maxYaw minPitch maxPitch
	 * Passenger ID x y z minYaw maxYaw minPitch maxPitch gunType.shortName gunName
	 * */
	public Seat(String[] split)
	{
		id = Integer.parseInt(split[1]);
		pos = new Pos(Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
		if(split.length > 6)
		{
			minYaw = Float.parseFloat(split[6]);
			maxYaw = Float.parseFloat(split[7]);
			minPitch = Float.parseFloat(split[8]);
			maxPitch = Float.parseFloat(split[9]);
		}
	}
	
	/** Type file driver seat constructor. Line from type file should be of one of the following forms
	 * Driver x y z
	 * Pilot x y z
	 */
	public Seat(float dx, float dy, float dz){
		id = 0;
		pos = new Pos((int)dx, (int)dy, (int)dz);
	}
	
	public Seat(int ID, float dx, float dy, float dz){
		id = ID;
		pos = new Pos((int)dx, (int)dy, (int)dz);
	}
	
	/** Type file driver seat constructor with yaw and pitch limiters */
	public Seat(int dx, int dy, int dz, float y1, float y2, float p1, float p2){
		id = 0;
		pos = new Pos(dx, dy, dz);
		minYaw = y1;
		maxYaw = y2;
		minPitch = p1;
		maxPitch = p2;
	}
	
}
