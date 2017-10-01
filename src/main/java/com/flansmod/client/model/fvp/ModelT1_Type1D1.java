package com.flansmod.client.model.fvp; //Path where the bodyModel is located

import com.flansmod.client.model.ModelUpgradePart;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelT1_Type1D1 extends ModelUpgradePart {
	
	int textureX = 512;
	int textureY = 512;

	public ModelT1_Type1D1(){
		
		primaryPaintBodyModel = new ModelRendererTurbo[2];
		primaryPaintBodyModel[0] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 719
		primaryPaintBodyModel[1] = new ModelRendererTurbo(this, 0, 0, textureX, textureY); // Box 720

		primaryPaintBodyModel[0].addShapeBox(0F, 0F, 0F, 32, 8, 46, 0F, 0F, 0F, -1F, -4F, 0F, -1F, -4F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 719
		primaryPaintBodyModel[0].setRotationPoint(22F, -48F, -23F);

		primaryPaintBodyModel[1].addShapeBox(0F, 0F, 0F, 28, 4, 44, 0F, 0F, 0F, -1F, -6F, 0F, -1F, -6F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 720
		primaryPaintBodyModel[1].setRotationPoint(22F, -52F, -22F);

		//translateAll(0F, 0F, 0F);

		flipAll();
		
	}
}