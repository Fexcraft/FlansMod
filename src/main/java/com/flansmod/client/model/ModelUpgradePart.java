package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.data.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityVehicle;

import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.model.ModelBase;

//Extensible ModelUpgradePart class for rendering vehicle upgrade models
public class ModelUpgradePart extends ModelBase {
	
	public ModelRendererTurbo bodyModel[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo primaryPaintBodyModel[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo secondaryPaintBodyModel[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorOpenModel[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorCloseModel[] = new ModelRendererTurbo[0];
	
	public boolean oldRotateOrder = false;
	
	public void render(RenderVehicle render, EntityDriveable driveable, float f1){
		render(0.0625F, render, (EntityVehicle)driveable, f1);
	}
	
	
	public void render(DriveableType type){
		renderPart(bodyModel);
		renderPart(primaryPaintBodyModel);
		renderPart(secondaryPaintBodyModel);
	}
	
	public void renderPart(ModelRendererTurbo[] part){
		for(ModelRendererTurbo bit : part){
			bit.render(0.0625F, oldRotateOrder);
		}
	}

	public void render(float f5, RenderVehicle render, EntityVehicle vehicle, float f){
		for(ModelRendererTurbo aBodyModel : bodyModel){
			aBodyModel.render(f5, oldRotateOrder);
		}
		vehicle.driveableData.primary_color.glColorApply();
		for(ModelRendererTurbo aBodyModel : primaryPaintBodyModel){
			aBodyModel.render(f5, oldRotateOrder);
		}
		RGB.glColorReset();
		vehicle.driveableData.secondary_color.glColorApply();
		for(ModelRendererTurbo aBodyModel : secondaryPaintBodyModel){
			aBodyModel.render(f5, oldRotateOrder);
		}
		RGB.glColorReset();
		
		if(vehicle.varDoor){
			for(ModelRendererTurbo aBodyDoorOpenModel : bodyDoorOpenModel) {
				aBodyDoorOpenModel.render(f5, oldRotateOrder);
			}
		}
		else{
			for(ModelRendererTurbo aBodyDoorCloseModel : bodyDoorCloseModel) {
				aBodyDoorCloseModel.render(f5, oldRotateOrder);
			}
		}
	}
	
	public void flipAll(){
		flip(bodyModel);
		flip(primaryPaintBodyModel);
		flip(secondaryPaintBodyModel);
		flip(bodyDoorOpenModel);
		flip(bodyDoorCloseModel);
	}
	
	public void translateAll(float x, float y, float z){
		translate(bodyModel, x, y, z);
		translate(primaryPaintBodyModel, x, y, z);
		translate(secondaryPaintBodyModel, x, y, z);
		translate(bodyDoorOpenModel, x, y, z);
		translate(bodyDoorCloseModel, x, y, z);
	}
	
	protected void flip(ModelRendererTurbo[] model){
		for(ModelRendererTurbo part : model){
			part.doMirror(false, true, true);
			part.setRotationPoint(part.rotationPointX, - part.rotationPointY, - part.rotationPointZ);
		}
	}
	
	protected void translate(ModelRendererTurbo[] model, float x, float y, float z){
		for(ModelRendererTurbo mod : model){
			mod.rotationPointX += x;
			mod.rotationPointY += y;
			mod.rotationPointZ += z;
		}
	}
	
}
