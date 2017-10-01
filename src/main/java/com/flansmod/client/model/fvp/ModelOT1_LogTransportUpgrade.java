package com.flansmod.client.model.fvp;

import com.flansmod.client.model.ModelUpgradePart;
import com.flansmod.client.model.RenderVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.driveables.EntityVehicle;

public class ModelOT1_LogTransportUpgrade extends ModelUpgradePart {
	
	int textureX = 512;
	int textureY = 512;

	public ModelOT1_LogTransportUpgrade(){
		
		bodyModel = new ModelRendererTurbo[39];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 249, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 201, 249, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 201, 161, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 433, 177, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 1, 193, textureX, textureY); // Box 4
		bodyModel[5] = new ModelRendererTurbo(this, 33, 193, textureX, textureY); // Box 5
		bodyModel[6] = new ModelRendererTurbo(this, 241, 193, textureX, textureY); // Box 6
		bodyModel[7] = new ModelRendererTurbo(this, 33, 201, textureX, textureY); // Box 7
		bodyModel[8] = new ModelRendererTurbo(this, 377, 201, textureX, textureY); // Box 8
		bodyModel[9] = new ModelRendererTurbo(this, 393, 201, textureX, textureY); // Box 9
		bodyModel[10] = new ModelRendererTurbo(this, 25, 209, textureX, textureY); // Box 10
		bodyModel[11] = new ModelRendererTurbo(this, 481, 201, textureX, textureY); // Box 11
		bodyModel[12] = new ModelRendererTurbo(this, 449, 225, textureX, textureY); // Box 12
		bodyModel[13] = new ModelRendererTurbo(this, 465, 225, textureX, textureY); // Box 13
		bodyModel[14] = new ModelRendererTurbo(this, 481, 225, textureX, textureY); // Box 14
		bodyModel[15] = new ModelRendererTurbo(this, 497, 225, textureX, textureY); // Box 15
		bodyModel[16] = new ModelRendererTurbo(this, 417, 233, textureX, textureY); // Box 16
		bodyModel[17] = new ModelRendererTurbo(this, 433, 233, textureX, textureY); // Box 17
		bodyModel[18] = new ModelRendererTurbo(this, 401, 249, textureX, textureY); // Box 18
		bodyModel[19] = new ModelRendererTurbo(this, 497, 201, textureX, textureY); // Box 19
		bodyModel[20] = new ModelRendererTurbo(this, 241, 209, textureX, textureY); // Box 20
		bodyModel[21] = new ModelRendererTurbo(this, 257, 209, textureX, textureY); // Box 21
		bodyModel[22] = new ModelRendererTurbo(this, 489, 209, textureX, textureY); // Box 22
		bodyModel[23] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 23
		bodyModel[24] = new ModelRendererTurbo(this, 9, 225, textureX, textureY); // Box 24
		bodyModel[25] = new ModelRendererTurbo(this, 457, 249, textureX, textureY); // Box 25
		bodyModel[26] = new ModelRendererTurbo(this, 385, 233, textureX, textureY); // Box 26
		bodyModel[27] = new ModelRendererTurbo(this, 1, 257, textureX, textureY); // Box 28
		bodyModel[28] = new ModelRendererTurbo(this, 89, 257, textureX, textureY); // Box 29
		bodyModel[29] = new ModelRendererTurbo(this, 177, 257, textureX, textureY); // Box 30
		bodyModel[30] = new ModelRendererTurbo(this, 265, 257, textureX, textureY); // Box 31
		bodyModel[31] = new ModelRendererTurbo(this, 313, 265, textureX, textureY); // Box 32
		bodyModel[32] = new ModelRendererTurbo(this, 361, 281, textureX, textureY); // Box 33
		bodyModel[33] = new ModelRendererTurbo(this, 409, 289, textureX, textureY); // Box 34
		bodyModel[34] = new ModelRendererTurbo(this, 505, 89, textureX, textureY); // Box 35
		bodyModel[35] = new ModelRendererTurbo(this, 489, 249, textureX, textureY); // Box 36
		bodyModel[36] = new ModelRendererTurbo(this, 505, 249, textureX, textureY); // Box 37
		bodyModel[37] = new ModelRendererTurbo(this, 1, 257, textureX, textureY); // Box 38
		bodyModel[38] = new ModelRendererTurbo(this, 49, 257, textureX, textureY); // Box 39

		bodyModel[0].addShapeBox(0F, 0F, 0F, 96, 2, 1, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 0
		bodyModel[0].setRotationPoint(-77F, -14F, 21F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 96, 2, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 1
		bodyModel[1].setRotationPoint(-77F, -14F, -22F);

		bodyModel[2].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 2
		bodyModel[2].setRotationPoint(-77F, -15F, 21F);

		bodyModel[3].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		bodyModel[3].setRotationPoint(-77F, -15F, -23F);

		bodyModel[4].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		bodyModel[4].setRotationPoint(18F, -15F, -23F);

		bodyModel[5].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 5
		bodyModel[5].setRotationPoint(18F, -15F, 21F);

		bodyModel[6].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 6
		bodyModel[6].setRotationPoint(-46F, -15F, 21F);

		bodyModel[7].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 7
		bodyModel[7].setRotationPoint(-14F, -15F, 21F);

		bodyModel[8].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 8
		bodyModel[8].setRotationPoint(-14F, -15F, -23F);

		bodyModel[9].addShapeBox(-0.5F, 0F, 0F, 2, 3, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		bodyModel[9].setRotationPoint(-46F, -15F, -23F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 10
		bodyModel[10].setRotationPoint(-77.5F, -37F, 21F);

		bodyModel[11].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 11
		bodyModel[11].setRotationPoint(-77.5F, -43F, 21F);

		bodyModel[12].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 12
		bodyModel[12].setRotationPoint(-46.5F, -37F, 21F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 13
		bodyModel[13].setRotationPoint(-14.5F, -37F, 21F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 14
		bodyModel[14].setRotationPoint(17.5F, -37F, 21F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 15
		bodyModel[15].setRotationPoint(-77.5F, -37F, -23F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 16
		bodyModel[16].setRotationPoint(-46.5F, -37F, -23F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 17
		bodyModel[17].setRotationPoint(-14.5F, -37F, -23F);

		bodyModel[18].addShapeBox(0F, 0F, 0F, 2, 22, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 18
		bodyModel[18].setRotationPoint(17.5F, -37F, -23F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 19
		bodyModel[19].setRotationPoint(-46.5F, -43F, 21F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 20
		bodyModel[20].setRotationPoint(-14.5F, -43F, 21F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 21
		bodyModel[21].setRotationPoint(17.5F, -43F, 21F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 22
		bodyModel[22].setRotationPoint(-77.5F, -43F, -23F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 23
		bodyModel[23].setRotationPoint(-46.5F, -43F, -23F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 24
		bodyModel[24].setRotationPoint(-14.5F, -43F, -23F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 2, 6, 2, 0F, -0.3F, 0F, -1.2F, -0.3F, 0F, -1.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 25
		bodyModel[25].setRotationPoint(17.5F, -43F, -23F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 2, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 26
		bodyModel[26].setRotationPoint(17.5F, -43F, -21F);

		bodyModel[27].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 28
		bodyModel[27].setRotationPoint(18F, -39F, -21F);

		bodyModel[28].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 29
		bodyModel[28].setRotationPoint(18F, -35F, -21F);

		bodyModel[29].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 30
		bodyModel[29].setRotationPoint(18F, -31F, -21F);

		bodyModel[30].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 31
		bodyModel[30].setRotationPoint(18F, -27F, -21F);

		bodyModel[31].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 32
		bodyModel[31].setRotationPoint(18F, -23F, -21F);

		bodyModel[32].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 33
		bodyModel[32].setRotationPoint(18F, -19F, -21F);

		bodyModel[33].addShapeBox(0F, 0F, 0F, 1, 2, 42, 0F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, 0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F); // Box 34
		bodyModel[33].setRotationPoint(18F, -15F, -21F);

		bodyModel[34].addShapeBox(0F, 0F, 0F, 1, 29, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 35
		bodyModel[34].setRotationPoint(18F, -42F, -17F);

		bodyModel[35].addShapeBox(0F, 0F, 0F, 1, 29, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 36
		bodyModel[35].setRotationPoint(18F, -42F, 14F);

		bodyModel[36].addShapeBox(0F, 0F, 0F, 1, 29, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 37
		bodyModel[36].setRotationPoint(18F, -42F, -6F);

		bodyModel[37].addShapeBox(0F, 0F, 0F, 1, 29, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 38
		bodyModel[37].setRotationPoint(18F, -42F, 4F);

		bodyModel[38].addBox(0F, 0F, 0F, 1, 6, 26, 0F); // Box 39
		bodyModel[38].setRotationPoint(19.5F, -32F, -13F);


		trailerModel = new ModelRendererTurbo[22];
		trailerModel[0] = new ModelRendererTurbo(this, 1, 305, textureX, textureY); // Box 41
		trailerModel[1] = new ModelRendererTurbo(this, 1, 321, textureX, textureY); // Box 42
		trailerModel[2] = new ModelRendererTurbo(this, 1, 337, textureX, textureY); // Box 43
		trailerModel[3] = new ModelRendererTurbo(this, 209, 337, textureX, textureY); // Box 44
		trailerModel[4] = new ModelRendererTurbo(this, 1, 353, textureX, textureY); // Box 45
		trailerModel[5] = new ModelRendererTurbo(this, 209, 353, textureX, textureY); // Box 46
		trailerModel[6] = new ModelRendererTurbo(this, 1, 369, textureX, textureY); // Box 47
		trailerModel[7] = new ModelRendererTurbo(this, 209, 369, textureX, textureY); // Box 48
		trailerModel[8] = new ModelRendererTurbo(this, 1, 385, textureX, textureY); // Box 49
		trailerModel[9] = new ModelRendererTurbo(this, 209, 385, textureX, textureY); // Box 50
		trailerModel[10] = new ModelRendererTurbo(this, 1, 401, textureX, textureY); // Box 51
		trailerModel[11] = new ModelRendererTurbo(this, 209, 401, textureX, textureY); // Box 52
		trailerModel[12] = new ModelRendererTurbo(this, 1, 417, textureX, textureY); // Box 53
		trailerModel[13] = new ModelRendererTurbo(this, 217, 417, textureX, textureY); // Box 54
		trailerModel[14] = new ModelRendererTurbo(this, 1, 433, textureX, textureY); // Box 55
		trailerModel[15] = new ModelRendererTurbo(this, 217, 433, textureX, textureY); // Box 56
		trailerModel[16] = new ModelRendererTurbo(this, 1, 449, textureX, textureY); // Box 57
		trailerModel[17] = new ModelRendererTurbo(this, 217, 449, textureX, textureY); // Box 58
		trailerModel[18] = new ModelRendererTurbo(this, 1, 465, textureX, textureY); // Box 59
		trailerModel[19] = new ModelRendererTurbo(this, 217, 465, textureX, textureY); // Box 60
		trailerModel[20] = new ModelRendererTurbo(this, 1, 481, textureX, textureY); // Box 61
		trailerModel[21] = new ModelRendererTurbo(this, 217, 481, textureX, textureY); // Box 62

		trailerModel[0].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 41
		trailerModel[0].setRotationPoint(-81F, -20F, -21F);

		trailerModel[1].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 42
		trailerModel[1].setRotationPoint(-81F, -20F, 15F);

		trailerModel[2].addBox(0.5F, 0.2F, -0.5F, 97, 6, 6, 0F); // Box 43
		trailerModel[2].setRotationPoint(-81F, -20F, -14F);
		trailerModel[2].rotateAngleX = -0.03490659F;

		trailerModel[3].addBox(0.5F, 0F, -0.5F, 97, 6, 6, 0F); // Box 44
		trailerModel[3].setRotationPoint(-81F, -20F, 9F);
		trailerModel[3].rotateAngleX = -0.06981317F;

		trailerModel[4].addBox(0F, 0.2F, 0F, 97, 6, 6, 0F); // Box 45
		trailerModel[4].setRotationPoint(-81F, -20F, 1F);
		trailerModel[4].rotateAngleX = 0.05235988F;

		trailerModel[5].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 46
		trailerModel[5].setRotationPoint(-81F, -20F, -6.5F);

		trailerModel[6].addBox(0F, 0.2F, 0F, 96, 6, 6, 0F); // Box 47
		trailerModel[6].setRotationPoint(-79F, -26F, -9.5F);

		trailerModel[7].addBox(0.5F, 0F, -0.5F, 96, 6, 6, 0F); // Box 48
		trailerModel[7].setRotationPoint(-79F, -26F, -16F);
		trailerModel[7].rotateAngleX = -0.06981317F;

		trailerModel[8].addBox(0F, 0.2F, 0F, 97, 6, 6, 0F); // Box 49
		trailerModel[8].setRotationPoint(-80F, -30F, -21F);
		trailerModel[8].rotateAngleX = 0.55850536F;

		trailerModel[9].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 50
		trailerModel[9].setRotationPoint(-81.5F, -26F, -3F);
		trailerModel[9].rotateAngleX = 0.05235988F;

		trailerModel[10].addBox(0F, 0.2F, 0F, 95, 6, 6, 0F); // Box 51
		trailerModel[10].setRotationPoint(-78F, -26F, 4.5F);

		trailerModel[11].addBox(0.5F, 0F, -0.5F, 97, 6, 6, 0F); // Box 52
		trailerModel[11].setRotationPoint(-80F, -26F, 13F);
		trailerModel[11].rotateAngleX = -0.06981317F;

		trailerModel[12].addBox(0.5F, 0F, -0.5F, 98, 6, 6, 0F); // Box 53
		trailerModel[12].setRotationPoint(-81F, -32F, 16F);
		trailerModel[12].rotateAngleX = -0.2268928F;

		trailerModel[13].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 54
		trailerModel[13].setRotationPoint(-80F, -32F, 7.5F);

		trailerModel[14].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 55
		trailerModel[14].setRotationPoint(-81F, -32F, -12.5F);

		trailerModel[15].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 56
		trailerModel[15].setRotationPoint(-80.5F, -32F, -5.5F);

		trailerModel[16].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 57
		trailerModel[16].setRotationPoint(-80.5F, -32F, 0F);
		trailerModel[16].rotateAngleX = 0.89011792F;

		trailerModel[17].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 58
		trailerModel[17].setRotationPoint(-81F, -38F, 15F);
		trailerModel[17].rotateAngleX = -0.05235988F;

		trailerModel[18].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 59
		trailerModel[18].setRotationPoint(-80.4F, -38F, 8.5F);

		trailerModel[19].addBox(0F, 0F, 0F, 99, 6, 6, 0F); // Box 60
		trailerModel[19].setRotationPoint(-81.5F, -39F, -21F);
		trailerModel[19].rotateAngleX = -0.03490659F;

		trailerModel[20].addBox(0.5F, 0F, -0.5F, 98, 6, 6, 0F); // Box 61
		trailerModel[20].setRotationPoint(-80F, -39F, -13.5F);
		trailerModel[20].rotateAngleX = -0.2268928F;

		trailerModel[21].addBox(0F, 0.2F, 0F, 98, 6, 6, 0F); // Box 62
		trailerModel[21].setRotationPoint(-81.5F, -38F, -8F);
		trailerModel[21].rotateAngleX = -0.01745329F;

		translateAll(0F, 0F, 0F);

		flipAll();
	}
	
	@Override
	public void render(float f5, RenderVehicle render, EntityVehicle vehicle, float f){
		super.render(f5, render, vehicle, f);
		for(int i = 0; i < vehicle.driveableData.getInventorySize(); i++){
			if(i >= trailerModel.length){
				break;
			}
			trailerModel[i].render(f5, oldRotateOrder);
		}
		
	}
	
}