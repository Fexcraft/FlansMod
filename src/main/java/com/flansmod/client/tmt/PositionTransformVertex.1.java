package com.flansmod.client.tmt;

import java.util.ArrayList;

import net.minecraft.util.math.Vec3d;

public class PositionTransformVertex extends PositionTextureVertex
{
	public PositionTransformVertex(float x, float y, float z, float u, float v)
	{
		this(new Vec3d(x, y, z), u, v);
	}
	
	public PositionTransformVertex(PositionTextureVertex vertex, float u, float v)
	{
		super(vertex, u, v);
		if(vertex instanceof PositionTransformVertex)
			neutralVector = ((PositionTransformVertex)vertex).neutralVector;
		else
			neutralVector = new Vec3d(vertex.vector3D.xCoord, vertex.vector3D.yCoord, vertex.vector3D.zCoord);
	}
	
	public PositionTransformVertex(PositionTextureVertex vertex)
	{
		this(vertex, vertex.texturePositionX, vertex.texturePositionY);
	}
	
	public PositionTransformVertex(Vec3d vector, float u, float v)
	{
		super(vector, u, v);
		neutralVector = new Vec3d(vector.xCoord, vector.yCoord, vector.zCoord);
	}
	
	public void setTransformation()
	{
		if(transformGroups.size() == 0)
		{
			vector3D = new Vec3d(neutralVector.xCoord, neutralVector.yCoord, neutralVector.zCoord);
			return;
		}
		double weight = 0D;
		for (TransformGroup transformGroup : transformGroups) {
			weight += transformGroup.getWeight();
		}
		vector3D = new Vec3d(0, 0, 0);
		
		for(int i = 0; i < transformGroups.size(); i++)
		{
			TransformGroup group = transformGroups.get(i);
			double cWeight = group.getWeight() / weight;
			Vec3d vector = group.doTransformation(this);
			
			vector3D = new Vec3d(vector3D.xCoord + cWeight * vector.xCoord, vector3D.yCoord + cWeight * vector.yCoord, vector3D.zCoord + cWeight * vector.zCoord);
		}
	}
	
	public void addGroup(TransformGroup group)
	{
		transformGroups.add(group);
	}
	
	public void removeGroup(TransformGroup group)
	{
		transformGroups.remove(group);
	}
		
	public Vec3d neutralVector;
	public ArrayList<TransformGroup> transformGroups = new ArrayList<TransformGroup>();
	
}
