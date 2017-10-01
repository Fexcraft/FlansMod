package com.flansmod.client.model.fvp;

import com.flansmod.client.model.ModelUpgradePart;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelT1_Type1 extends ModelUpgradePart {
	
	int textureX = 1024;
	int textureY = 1024;

	public ModelT1_Type1(){
		bodyModel = new ModelRendererTurbo[48];
		bodyModel[0] = new ModelRendererTurbo(this, 465, 145, textureX, textureY); // Box 219
		bodyModel[1] = new ModelRendererTurbo(this, 977, 177, textureX, textureY); // Box 4
		bodyModel[2] = new ModelRendererTurbo(this, 985, 177, textureX, textureY); // Box 5
		bodyModel[3] = new ModelRendererTurbo(this, 513, 257, textureX, textureY); // Box 8
		bodyModel[4] = new ModelRendererTurbo(this, 345, 161, textureX, textureY); // Box 669
		bodyModel[5] = new ModelRendererTurbo(this, 385, 161, textureX, textureY); // Box 670
		bodyModel[6] = new ModelRendererTurbo(this, 481, 161, textureX, textureY); // Box 671
		bodyModel[7] = new ModelRendererTurbo(this, 505, 161, textureX, textureY); // Box 672
		bodyModel[8] = new ModelRendererTurbo(this, 769, 161, textureX, textureY); // Box 673
		bodyModel[9] = new ModelRendererTurbo(this, 793, 161, textureX, textureY); // Box 674
		bodyModel[10] = new ModelRendererTurbo(this, 889, 169, textureX, textureY); // Box 675
		bodyModel[11] = new ModelRendererTurbo(this, 185, 177, textureX, textureY); // Box 676
		bodyModel[12] = new ModelRendererTurbo(this, 217, 177, textureX, textureY); // Box 677
		bodyModel[13] = new ModelRendererTurbo(this, 849, 177, textureX, textureY); // Box 678
		bodyModel[14] = new ModelRendererTurbo(this, 921, 161, textureX, textureY); // Box 679
		bodyModel[15] = new ModelRendererTurbo(this, 913, 169, textureX, textureY); // Box 680
		bodyModel[16] = new ModelRendererTurbo(this, 185, 177, textureX, textureY); // Box 681
		bodyModel[17] = new ModelRendererTurbo(this, 209, 177, textureX, textureY); // Box 682
		bodyModel[18] = new ModelRendererTurbo(this, 817, 193, textureX, textureY); // Box 683
		bodyModel[19] = new ModelRendererTurbo(this, 305, 225, textureX, textureY); // Box 684
		bodyModel[20] = new ModelRendererTurbo(this, 305, 233, textureX, textureY); // Box 685
		bodyModel[21] = new ModelRendererTurbo(this, 305, 241, textureX, textureY); // Box 686
		bodyModel[22] = new ModelRendererTurbo(this, 449, 161, textureX, textureY); // Box 687
		bodyModel[23] = new ModelRendererTurbo(this, 465, 161, textureX, textureY); // Box 688
		bodyModel[24] = new ModelRendererTurbo(this, 809, 161, textureX, textureY); // Box 689
		bodyModel[25] = new ModelRendererTurbo(this, 825, 161, textureX, textureY); // Box 690
		bodyModel[26] = new ModelRendererTurbo(this, 929, 161, textureX, textureY); // Box 691
		bodyModel[27] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 692
		bodyModel[28] = new ModelRendererTurbo(this, 9, 169, textureX, textureY); // Box 693
		bodyModel[29] = new ModelRendererTurbo(this, 25, 169, textureX, textureY); // Box 694
		bodyModel[30] = new ModelRendererTurbo(this, 33, 169, textureX, textureY); // Box 695
		bodyModel[31] = new ModelRendererTurbo(this, 57, 169, textureX, textureY); // Box 696
		bodyModel[32] = new ModelRendererTurbo(this, 65, 169, textureX, textureY); // Box 697
		bodyModel[33] = new ModelRendererTurbo(this, 313, 169, textureX, textureY); // Box 698
		bodyModel[34] = new ModelRendererTurbo(this, 321, 169, textureX, textureY); // Box 699
		bodyModel[35] = new ModelRendererTurbo(this, 337, 169, textureX, textureY); // Box 700
		bodyModel[36] = new ModelRendererTurbo(this, 345, 169, textureX, textureY); // Box 701
		bodyModel[37] = new ModelRendererTurbo(this, 361, 169, textureX, textureY); // Box 702
		bodyModel[38] = new ModelRendererTurbo(this, 369, 169, textureX, textureY); // Box 703
		bodyModel[39] = new ModelRendererTurbo(this, 385, 169, textureX, textureY); // Box 704
		bodyModel[40] = new ModelRendererTurbo(this, 393, 169, textureX, textureY); // Box 705
		bodyModel[41] = new ModelRendererTurbo(this, 481, 169, textureX, textureY); // Box 706
		bodyModel[42] = new ModelRendererTurbo(this, 489, 169, textureX, textureY); // Box 707
		bodyModel[43] = new ModelRendererTurbo(this, 505, 169, textureX, textureY); // Box 708
		bodyModel[44] = new ModelRendererTurbo(this, 769, 169, textureX, textureY); // Box 709
		bodyModel[45] = new ModelRendererTurbo(this, 777, 169, textureX, textureY); // Box 710
		bodyModel[46] = new ModelRendererTurbo(this, 793, 169, textureX, textureY); // Box 711
		bodyModel[47] = new ModelRendererTurbo(this, 881, 169, textureX, textureY); // Box 712

		bodyModel[0].addShapeBox(0F, 0F, 0F, 124, 1, 51, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 219
		bodyModel[0].setRotationPoint(-102F, -12F, -25.5F);

		bodyModel[1].addBox(0F, 0F, 0F, 2, 48, 1, 0F); // Box 4
		bodyModel[1].setRotationPoint(-101.5F, -60F, -24.5F);

		bodyModel[2].addBox(0F, 0F, 0F, 2, 48, 1, 0F); // Box 5
		bodyModel[2].setRotationPoint(-101.5F, -60F, 23.5F);

		bodyModel[3].addBox(0F, 0F, 0F, 2, 3, 46, 0F); // Box 8
		bodyModel[3].setRotationPoint(-102.5F, -11.5F, -23F);

		bodyModel[4].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 669
		bodyModel[4].setRotationPoint(-102.5F, -57F, -25F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 670
		bodyModel[5].setRotationPoint(-102.5F, -36.5F, -25F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F); // Box 671
		bodyModel[6].setRotationPoint(-102.5F, -19F, -25F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 672
		bodyModel[7].setRotationPoint(-102.5F, -19F, 23F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 673
		bodyModel[8].setRotationPoint(-102.5F, -36.5F, 23F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 2, 4, 2, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 674
		bodyModel[9].setRotationPoint(-102.5F, -57F, 23F);

		bodyModel[10].addBox(0F, 0F, 0F, 2, 2, 12, 0F); // Box 675
		bodyModel[10].setRotationPoint(-2F, -5F, -22.5F);

		bodyModel[11].addBox(0F, 0F, 0F, 2, 2, 12, 0F); // Box 676
		bodyModel[11].setRotationPoint(-48F, -5F, -22.5F);

		bodyModel[12].addBox(0F, 0F, 0F, 2, 2, 12, 0F); // Box 677
		bodyModel[12].setRotationPoint(-2F, -5F, 11.5F);

		bodyModel[13].addBox(0F, 0F, 0F, 2, 2, 12, 0F); // Box 678
		bodyModel[13].setRotationPoint(-48F, -5F, 11.5F);

		bodyModel[14].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 679
		bodyModel[14].setRotationPoint(-2F, -11F, -23.5F);

		bodyModel[15].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 680
		bodyModel[15].setRotationPoint(-48F, -11F, -23.5F);

		bodyModel[16].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 681
		bodyModel[16].setRotationPoint(-2F, -11F, 22.5F);

		bodyModel[17].addBox(0F, 0F, 0F, 2, 10, 1, 0F); // Box 682
		bodyModel[17].setRotationPoint(-48F, -11F, 22.5F);

		bodyModel[18].addBox(0F, 0F, 0F, 64, 4, 1, 0F); // Box 683
		bodyModel[18].setRotationPoint(-56F, -10F, -24F);

		bodyModel[19].addBox(0F, 0F, 0F, 64, 4, 1, 0F); // Box 684
		bodyModel[19].setRotationPoint(-56F, -4F, -24F);

		bodyModel[20].addBox(0F, 0F, 0F, 64, 4, 1, 0F); // Box 685
		bodyModel[20].setRotationPoint(-56F, -4F, 23F);

		bodyModel[21].addBox(0F, 0F, 0F, 64, 4, 1, 0F); // Box 686
		bodyModel[21].setRotationPoint(-56F, -10F, 23F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 687
		bodyModel[22].setRotationPoint(-101.5F, -60F, 24.3F);
		bodyModel[22].rotateAngleX = 0.01745329F;

		bodyModel[23].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 688
		bodyModel[23].setRotationPoint(-81.5F, -60F, 24.3F);
		bodyModel[23].rotateAngleX = 0.01745329F;

		bodyModel[24].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 689
		bodyModel[24].setRotationPoint(-71.5F, -60F, 24.3F);
		bodyModel[24].rotateAngleX = 0.01745329F;

		bodyModel[25].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 690
		bodyModel[25].setRotationPoint(-61.5F, -60F, 24.3F);
		bodyModel[25].rotateAngleX = 0.01745329F;

		bodyModel[26].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 691
		bodyModel[26].setRotationPoint(-51.5F, -60F, 24.3F);
		bodyModel[26].rotateAngleX = 0.01745329F;

		bodyModel[27].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 692
		bodyModel[27].setRotationPoint(-41.5F, -60F, 24.3F);
		bodyModel[27].rotateAngleX = 0.01745329F;

		bodyModel[28].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 693
		bodyModel[28].setRotationPoint(-31.5F, -60F, 24.3F);
		bodyModel[28].rotateAngleX = 0.01745329F;

		bodyModel[29].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 694
		bodyModel[29].setRotationPoint(-21.5F, -60F, 24.3F);
		bodyModel[29].rotateAngleX = 0.01745329F;

		bodyModel[30].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 695
		bodyModel[30].setRotationPoint(-11.5F, -60F, 24.3F);
		bodyModel[30].rotateAngleX = 0.01745329F;

		bodyModel[31].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 696
		bodyModel[31].setRotationPoint(-1.5F, -60F, 24.3F);
		bodyModel[31].rotateAngleX = 0.01745329F;

		bodyModel[32].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 697
		bodyModel[32].setRotationPoint(8.5F, -60F, 24.3F);
		bodyModel[32].rotateAngleX = 0.01745329F;

		bodyModel[33].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 698
		bodyModel[33].setRotationPoint(18.5F, -60F, 24.3F);
		bodyModel[33].rotateAngleX = 0.01745329F;

		bodyModel[34].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 699
		bodyModel[34].setRotationPoint(-91.5F, -60F, 24.3F);
		bodyModel[34].rotateAngleX = 0.01745329F;

		bodyModel[35].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 700
		bodyModel[35].setRotationPoint(-101.5F, -60F, -26.3F);
		bodyModel[35].rotateAngleX = 0.01745329F;

		bodyModel[36].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 701
		bodyModel[36].setRotationPoint(-91.5F, -60F, -26.3F);
		bodyModel[36].rotateAngleX = 0.01745329F;

		bodyModel[37].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 702
		bodyModel[37].setRotationPoint(-81.5F, -60F, -26.3F);
		bodyModel[37].rotateAngleX = 0.01745329F;

		bodyModel[38].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 703
		bodyModel[38].setRotationPoint(-71.5F, -60F, -26.3F);
		bodyModel[38].rotateAngleX = 0.01745329F;

		bodyModel[39].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 704
		bodyModel[39].setRotationPoint(-61.5F, -60F, -26.3F);
		bodyModel[39].rotateAngleX = 0.01745329F;

		bodyModel[40].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 705
		bodyModel[40].setRotationPoint(-51.5F, -60F, -26.3F);
		bodyModel[40].rotateAngleX = 0.01745329F;

		bodyModel[41].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 706
		bodyModel[41].setRotationPoint(-41.5F, -60F, -26.3F);
		bodyModel[41].rotateAngleX = 0.01745329F;

		bodyModel[42].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 707
		bodyModel[42].setRotationPoint(-31.5F, -60F, -26.3F);
		bodyModel[42].rotateAngleX = 0.01745329F;

		bodyModel[43].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 708
		bodyModel[43].setRotationPoint(-21.5F, -60F, -26.3F);
		bodyModel[43].rotateAngleX = 0.01745329F;

		bodyModel[44].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 709
		bodyModel[44].setRotationPoint(-11.5F, -60F, -26.3F);
		bodyModel[44].rotateAngleX = 0.01745329F;

		bodyModel[45].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 710
		bodyModel[45].setRotationPoint(-1.5F, -60F, -26.3F);
		bodyModel[45].rotateAngleX = 0.01745329F;

		bodyModel[46].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 711
		bodyModel[46].setRotationPoint(8.5F, -60F, -26.3F);
		bodyModel[46].rotateAngleX = 0.01745329F;

		bodyModel[47].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 712
		bodyModel[47].setRotationPoint(18.5F, -60F, -26.3F);
		bodyModel[47].rotateAngleX = 0.01745329F;


		bodyDoorOpenModel = new ModelRendererTurbo[23];
		bodyDoorOpenModel[0] = new ModelRendererTurbo(this, 721, 257, textureX, textureY); // Box 645
		bodyDoorOpenModel[1] = new ModelRendererTurbo(this, 417, 161, textureX, textureY); // Box 646
		bodyDoorOpenModel[2] = new ModelRendererTurbo(this, 433, 161, textureX, textureY); // Box 647
		bodyDoorOpenModel[3] = new ModelRendererTurbo(this, 849, 257, textureX, textureY); // Box 648
		bodyDoorOpenModel[4] = new ModelRendererTurbo(this, 1, 273, textureX, textureY); // Box 649
		bodyDoorOpenModel[5] = new ModelRendererTurbo(this, 921, 105, textureX, textureY); // Box 650
		bodyDoorOpenModel[6] = new ModelRendererTurbo(this, 25, 113, textureX, textureY); // Box 651
		bodyDoorOpenModel[7] = new ModelRendererTurbo(this, 961, 121, textureX, textureY); // Box 652
		bodyDoorOpenModel[8] = new ModelRendererTurbo(this, 33, 129, textureX, textureY); // Box 653
		bodyDoorOpenModel[9] = new ModelRendererTurbo(this, 153, 129, textureX, textureY); // Box 654
		bodyDoorOpenModel[10] = new ModelRendererTurbo(this, 1, 137, textureX, textureY); // Box 655
		bodyDoorOpenModel[11] = new ModelRendererTurbo(this, 249, 153, textureX, textureY); // Box 656
		bodyDoorOpenModel[12] = new ModelRendererTurbo(this, 97, 161, textureX, textureY); // Box 657
		bodyDoorOpenModel[13] = new ModelRendererTurbo(this, 105, 161, textureX, textureY); // Box 658
		bodyDoorOpenModel[14] = new ModelRendererTurbo(this, 313, 161, textureX, textureY); // Box 659
		bodyDoorOpenModel[15] = new ModelRendererTurbo(this, 321, 161, textureX, textureY); // Box 660
		bodyDoorOpenModel[16] = new ModelRendererTurbo(this, 337, 161, textureX, textureY); // Box 664
		bodyDoorOpenModel[17] = new ModelRendererTurbo(this, 785, 121, textureX, textureY); // Box 665
		bodyDoorOpenModel[18] = new ModelRendererTurbo(this, 417, 129, textureX, textureY); // Box 666
		bodyDoorOpenModel[19] = new ModelRendererTurbo(this, 361, 161, textureX, textureY); // Box 667
		bodyDoorOpenModel[20] = new ModelRendererTurbo(this, 609, 9, textureX, textureY); // Box 668
		bodyDoorOpenModel[21] = new ModelRendererTurbo(this, 609, 9, textureX, textureY); // Box 717
		bodyDoorOpenModel[22] = new ModelRendererTurbo(this, 609, 9, textureX, textureY); // Box 718

		bodyDoorOpenModel[0].addShapeBox(0F, 0F, 0F, 16, 2, 46, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 645
		bodyDoorOpenModel[0].setRotationPoint(-120.5F, 8F, -23F);

		bodyDoorOpenModel[1].addShapeBox(0F, 0F, 0F, 2, 17, 2, 0F, -2.5F, 0F, 0F, 2.5F, 0F, 0F, 2.5F, 0F, 0F, -2.5F, 0F, 0F, 1.5F, 0F, 0F, -1.5F, 1F, 0F, -1.5F, 1F, 0F, 1.5F, 0F, 0F); // Box 646
		bodyDoorOpenModel[1].setRotationPoint(-105F, -8.5F, -17F);

		bodyDoorOpenModel[2].addShapeBox(0F, 0F, 0F, 2, 17, 2, 0F, -2.5F, 0F, 0F, 2.5F, 0F, 0F, 2.5F, 0F, 0F, -2.5F, 0F, 0F, 1.5F, 0F, 0F, -1.5F, 1F, 0F, -1.5F, 1F, 0F, 1.5F, 0F, 0F); // Box 647
		bodyDoorOpenModel[2].setRotationPoint(-105F, -8.5F, 15F);

		bodyDoorOpenModel[3].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 648
		bodyDoorOpenModel[3].setRotationPoint(-102.5F, -60F, -50F);

		bodyDoorOpenModel[4].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 649
		bodyDoorOpenModel[4].setRotationPoint(-102.5F, -60F, 25F);

		bodyDoorOpenModel[5].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 650
		bodyDoorOpenModel[5].setRotationPoint(-102.3F, -60F, -47F);
		bodyDoorOpenModel[5].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[6].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 651
		bodyDoorOpenModel[6].setRotationPoint(-102.3F, -50F, -27F);
		bodyDoorOpenModel[6].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[7].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 652
		bodyDoorOpenModel[7].setRotationPoint(-102.3F, -40F, -27F);
		bodyDoorOpenModel[7].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[8].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 653
		bodyDoorOpenModel[8].setRotationPoint(-102.3F, -30F, -27F);
		bodyDoorOpenModel[8].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[9].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 654
		bodyDoorOpenModel[9].setRotationPoint(-102.3F, -20F, -27F);
		bodyDoorOpenModel[9].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[10].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 655
		bodyDoorOpenModel[10].setRotationPoint(-102.3F, -60F, -27F);
		bodyDoorOpenModel[10].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[11].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 656
		bodyDoorOpenModel[11].setRotationPoint(-102.3F, -60F, 25F);
		bodyDoorOpenModel[11].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[12].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 657
		bodyDoorOpenModel[12].setRotationPoint(-102.3F, -60F, 45F);
		bodyDoorOpenModel[12].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[13].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 658
		bodyDoorOpenModel[13].setRotationPoint(-102.3F, -50F, 25F);
		bodyDoorOpenModel[13].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[14].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 659
		bodyDoorOpenModel[14].setRotationPoint(-102.3F, -40F, 25F);
		bodyDoorOpenModel[14].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[15].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 660
		bodyDoorOpenModel[15].setRotationPoint(-102.3F, -20F, 25F);
		bodyDoorOpenModel[15].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[16].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 664
		bodyDoorOpenModel[16].setRotationPoint(-102.3F, -30F, 25F);
		bodyDoorOpenModel[16].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[17].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 665
		bodyDoorOpenModel[17].setRotationPoint(-102.3F, -58F, -50F);
		bodyDoorOpenModel[17].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[18].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 666
		bodyDoorOpenModel[18].setRotationPoint(-102.3F, -43F, -50F);
		bodyDoorOpenModel[18].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[19].addShapeBox(0F, 0F, 0F, 1, 2, 4, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 667
		bodyDoorOpenModel[19].setRotationPoint(-102.3F, -28F, -50F);
		bodyDoorOpenModel[19].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[20].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 668
		bodyDoorOpenModel[20].setRotationPoint(-102.3F, -58F, 46F);
		bodyDoorOpenModel[20].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[21].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 717
		bodyDoorOpenModel[21].setRotationPoint(-102.3F, -43F, 46F);
		bodyDoorOpenModel[21].rotateAngleX = 0.01745329F;

		bodyDoorOpenModel[22].addShapeBox(0F, 0F, 0F, 1, 2, 5, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 718
		bodyDoorOpenModel[22].setRotationPoint(-102.3F, -28F, 46F);
		bodyDoorOpenModel[22].rotateAngleX = 0.01745329F;


		bodyDoorCloseModel = new ModelRendererTurbo[22];
		bodyDoorCloseModel[0] = new ModelRendererTurbo(this, 953, 233, textureX, textureY); // Box 6
		bodyDoorCloseModel[1] = new ModelRendererTurbo(this, 329, 249, textureX, textureY); // Box 7
		bodyDoorCloseModel[2] = new ModelRendererTurbo(this, 617, 257, textureX, textureY); // Box 9
		bodyDoorCloseModel[3] = new ModelRendererTurbo(this, 889, 161, textureX, textureY); // Box 10
		bodyDoorCloseModel[4] = new ModelRendererTurbo(this, 81, 169, textureX, textureY); // Box 11
		bodyDoorCloseModel[5] = new ModelRendererTurbo(this, 1009, 121, textureX, textureY); // Box 12
		bodyDoorCloseModel[6] = new ModelRendererTurbo(this, 137, 161, textureX, textureY); // Box 13
		bodyDoorCloseModel[7] = new ModelRendererTurbo(this, 377, 89, textureX, textureY); // Box 14
		bodyDoorCloseModel[8] = new ModelRendererTurbo(this, 1017, 89, textureX, textureY); // Box 15
		bodyDoorCloseModel[9] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Box 16
		bodyDoorCloseModel[10] = new ModelRendererTurbo(this, 97, 97, textureX, textureY); // Box 17
		bodyDoorCloseModel[11] = new ModelRendererTurbo(this, 273, 97, textureX, textureY); // Box 18
		bodyDoorCloseModel[12] = new ModelRendererTurbo(this, 313, 97, textureX, textureY); // Box 19
		bodyDoorCloseModel[13] = new ModelRendererTurbo(this, 473, 97, textureX, textureY); // Box 20
		bodyDoorCloseModel[14] = new ModelRendererTurbo(this, 521, 97, textureX, textureY); // Box 21
		bodyDoorCloseModel[15] = new ModelRendererTurbo(this, 273, 105, textureX, textureY); // Box 22
		bodyDoorCloseModel[16] = new ModelRendererTurbo(this, 377, 105, textureX, textureY); // Box 23
		bodyDoorCloseModel[17] = new ModelRendererTurbo(this, 537, 105, textureX, textureY); // Box 24
		bodyDoorCloseModel[18] = new ModelRendererTurbo(this, 553, 105, textureX, textureY); // Box 25
		bodyDoorCloseModel[19] = new ModelRendererTurbo(this, 449, 161, textureX, textureY); // Box 661
		bodyDoorCloseModel[20] = new ModelRendererTurbo(this, 809, 161, textureX, textureY); // Box 662
		bodyDoorCloseModel[21] = new ModelRendererTurbo(this, 881, 169, textureX, textureY); // Box 663

		bodyDoorCloseModel[0].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 6
		bodyDoorCloseModel[0].setRotationPoint(-102.5F, -60F, -25F);

		bodyDoorCloseModel[1].addBox(0F, 0F, 0F, 1, 48, 25, 0F); // Box 7
		bodyDoorCloseModel[1].setRotationPoint(-102.5F, -60F, 0F);

		bodyDoorCloseModel[2].addShapeBox(0F, 0F, 0F, 2, 16, 46, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 9
		bodyDoorCloseModel[2].setRotationPoint(-104.5F, -26.5F, -23F);

		bodyDoorCloseModel[3].addBox(0F, 0F, 0F, 12, 2, 2, 0F); // Box 10
		bodyDoorCloseModel[3].setRotationPoint(-105F, -11.5F, -17F);

		bodyDoorCloseModel[4].addBox(0F, 0F, 0F, 12, 2, 2, 0F); // Box 11
		bodyDoorCloseModel[4].setRotationPoint(-105F, -11.5F, 15F);

		bodyDoorCloseModel[5].addShapeBox(0F, 0F, 0F, 1, 10, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 12
		bodyDoorCloseModel[5].setRotationPoint(-105F, -21.5F, -17F);

		bodyDoorCloseModel[6].addShapeBox(0F, 0F, 0F, 1, 10, 2, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
		bodyDoorCloseModel[6].setRotationPoint(-105F, -21.5F, 15F);

		bodyDoorCloseModel[7].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 14
		bodyDoorCloseModel[7].setRotationPoint(-102.7F, -60F, -25F);
		bodyDoorCloseModel[7].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[8].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 15
		bodyDoorCloseModel[8].setRotationPoint(-102.7F, -60F, -5F);
		bodyDoorCloseModel[8].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[9].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 16
		bodyDoorCloseModel[9].setRotationPoint(-102.7F, -60F, 3F);
		bodyDoorCloseModel[9].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[10].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 17
		bodyDoorCloseModel[10].setRotationPoint(-102.7F, -60F, 23F);
		bodyDoorCloseModel[10].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[11].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 18
		bodyDoorCloseModel[11].setRotationPoint(-102.7F, -50F, -25F);
		bodyDoorCloseModel[11].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[12].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 19
		bodyDoorCloseModel[12].setRotationPoint(-102.7F, -40F, -25F);
		bodyDoorCloseModel[12].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[13].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 20
		bodyDoorCloseModel[13].setRotationPoint(-102.7F, -30F, -25F);
		bodyDoorCloseModel[13].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[14].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 21
		bodyDoorCloseModel[14].setRotationPoint(-102.7F, -20F, -25F);
		bodyDoorCloseModel[14].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[15].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 22
		bodyDoorCloseModel[15].setRotationPoint(-102.7F, -50F, 23F);
		bodyDoorCloseModel[15].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[16].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 23
		bodyDoorCloseModel[16].setRotationPoint(-102.7F, -40F, 23F);
		bodyDoorCloseModel[16].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[17].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 24
		bodyDoorCloseModel[17].setRotationPoint(-102.7F, -30F, 23F);
		bodyDoorCloseModel[17].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[18].addShapeBox(0F, 0F, 0F, 1, 2, 2, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 25
		bodyDoorCloseModel[18].setRotationPoint(-102.7F, -20F, 23F);
		bodyDoorCloseModel[18].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[19].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 661
		bodyDoorCloseModel[19].setRotationPoint(-102.7F, -29F, -4F);
		bodyDoorCloseModel[19].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[20].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 662
		bodyDoorCloseModel[20].setRotationPoint(-102.7F, -58F, -4F);
		bodyDoorCloseModel[20].rotateAngleX = 0.01745329F;

		bodyDoorCloseModel[21].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 663
		bodyDoorCloseModel[21].setRotationPoint(-102.7F, -43F, -4F);
		bodyDoorCloseModel[21].rotateAngleX = 0.01745329F;
		
		secondaryPaintBodyModel = new ModelRendererTurbo[4];
		secondaryPaintBodyModel[0] = new ModelRendererTurbo(this, 465, 201, textureX, textureY); // Box 0
		secondaryPaintBodyModel[1] = new ModelRendererTurbo(this, 721, 201, textureX, textureY); // Box 1
		secondaryPaintBodyModel[2] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 2
		secondaryPaintBodyModel[3] = new ModelRendererTurbo(this, 409, 209, textureX, textureY); // Box 3

		secondaryPaintBodyModel[0].addBox(0F, 0F, 0F, 124, 48, 1, 0F); // Box 0
		secondaryPaintBodyModel[0].setRotationPoint(-102F, -60F, -25.5F);

		secondaryPaintBodyModel[1].addBox(0F, 0F, 0F, 124, 48, 1, 0F); // Box 1
		secondaryPaintBodyModel[1].setRotationPoint(-102F, -60F, 24.5F);

		secondaryPaintBodyModel[2].addBox(0F, 0F, 0F, 124, 1, 52, 0F); // Box 2
		secondaryPaintBodyModel[2].setRotationPoint(-102F, -61F, -26F);

		secondaryPaintBodyModel[3].addBox(0F, 0F, 0F, 1, 48, 49, 0F); // Box 3
		secondaryPaintBodyModel[3].setRotationPoint(21F, -60F, -24.5F);

		//translateAll(0F, 0F, 0F);

		flipAll();
	}
	
}