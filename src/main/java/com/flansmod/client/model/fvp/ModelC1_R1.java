//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 22.08.2016 - 20:40:40

package com.flansmod.client.model.fvp; //Path where the model is located

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelC1_R1 extends ModelVehicle {
	
	int textureX = 512;
	int textureY = 512;

	public ModelC1_R1(){
		initbodyModel_1();
		initprimaryPaintBodyDoorOpenModel_1();
		initprimaryPaintBodyDoorCloseModel_1();
		initleftFrontWheelModel_1();
		initrightFrontWheelModel_1();
		initleftBackWheelModel_1();
		initrightBackWheelModel_1();
		initprimaryPaintBodyModel_1();
		initsteeringWheelModel_1();
		translateAll(0F, 0F, 0F);
		flipAll();
	}

	private void initbodyModel_1(){
		bodyModel = new ModelRendererTurbo[147];
		bodyModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		bodyModel[1] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 1
		bodyModel[2] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 2
		bodyModel[3] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 3
		bodyModel[4] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 4
		bodyModel[5] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 9
		bodyModel[6] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 10
		bodyModel[7] = new ModelRendererTurbo(this, 377, 97, textureX, textureY); // Box 432
		bodyModel[8] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 433
		bodyModel[9] = new ModelRendererTurbo(this, 121, 105, textureX, textureY); // Box 434
		bodyModel[10] = new ModelRendererTurbo(this, 257, 105, textureX, textureY); // Box 435
		bodyModel[11] = new ModelRendererTurbo(this, 353, 105, textureX, textureY); // Box 436
		bodyModel[12] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 437
		bodyModel[13] = new ModelRendererTurbo(this, 105, 97, textureX, textureY); // Box 438
		bodyModel[14] = new ModelRendererTurbo(this, 121, 97, textureX, textureY); // Box 440
		bodyModel[15] = new ModelRendererTurbo(this, 153, 97, textureX, textureY); // Box 441
		bodyModel[16] = new ModelRendererTurbo(this, 185, 97, textureX, textureY); // Box 442
		bodyModel[17] = new ModelRendererTurbo(this, 233, 97, textureX, textureY); // Box 443
		bodyModel[18] = new ModelRendererTurbo(this, 193, 113, textureX, textureY); // Box 450
		bodyModel[19] = new ModelRendererTurbo(this, 265, 97, textureX, textureY); // Box 451
		bodyModel[20] = new ModelRendererTurbo(this, 297, 97, textureX, textureY); // Box 452
		bodyModel[21] = new ModelRendererTurbo(this, 321, 97, textureX, textureY); // Box 453
		bodyModel[22] = new ModelRendererTurbo(this, 329, 25, textureX, textureY); // Box 454
		bodyModel[23] = new ModelRendererTurbo(this, 345, 25, textureX, textureY); // Box 455
		bodyModel[24] = new ModelRendererTurbo(this, 57, 113, textureX, textureY); // Box 456
		bodyModel[25] = new ModelRendererTurbo(this, 417, 105, textureX, textureY); // Box 462
		bodyModel[26] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 463
		bodyModel[27] = new ModelRendererTurbo(this, 281, 113, textureX, textureY); // Box 464
		bodyModel[28] = new ModelRendererTurbo(this, 321, 113, textureX, textureY); // Box 465
		bodyModel[29] = new ModelRendererTurbo(this, 449, 113, textureX, textureY); // Box 466
		bodyModel[30] = new ModelRendererTurbo(this, 345, 121, textureX, textureY); // Box 467
		bodyModel[31] = new ModelRendererTurbo(this, 473, 121, textureX, textureY); // Box 468
		bodyModel[32] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 469
		bodyModel[33] = new ModelRendererTurbo(this, 169, 129, textureX, textureY); // Box 470
		bodyModel[34] = new ModelRendererTurbo(this, 289, 137, textureX, textureY); // Box 471
		bodyModel[35] = new ModelRendererTurbo(this, 433, 137, textureX, textureY); // Box 472
		bodyModel[36] = new ModelRendererTurbo(this, 265, 145, textureX, textureY); // Box 473
		bodyModel[37] = new ModelRendererTurbo(this, 313, 145, textureX, textureY); // Box 474
		bodyModel[38] = new ModelRendererTurbo(this, 457, 145, textureX, textureY); // Box 475
		bodyModel[39] = new ModelRendererTurbo(this, 337, 153, textureX, textureY); // Box 476
		bodyModel[40] = new ModelRendererTurbo(this, 377, 153, textureX, textureY); // Box 477
		bodyModel[41] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 478
		bodyModel[42] = new ModelRendererTurbo(this, 41, 161, textureX, textureY); // Box 479
		bodyModel[43] = new ModelRendererTurbo(this, 177, 161, textureX, textureY); // Box 480
		bodyModel[44] = new ModelRendererTurbo(this, 41, 177, textureX, textureY); // Box 503
		bodyModel[45] = new ModelRendererTurbo(this, 313, 97, textureX, textureY); // Box 504
		bodyModel[46] = new ModelRendererTurbo(this, 337, 97, textureX, textureY); // Box 505
		bodyModel[47] = new ModelRendererTurbo(this, 193, 177, textureX, textureY); // Box 506
		bodyModel[48] = new ModelRendererTurbo(this, 345, 97, textureX, textureY); // Box 507
		bodyModel[49] = new ModelRendererTurbo(this, 121, 113, textureX, textureY); // Box 508
		bodyModel[50] = new ModelRendererTurbo(this, 361, 25, textureX, textureY); // Box 509
		bodyModel[51] = new ModelRendererTurbo(this, 249, 49, textureX, textureY); // Box 510
		bodyModel[52] = new ModelRendererTurbo(this, 33, 113, textureX, textureY); // Box 511
		bodyModel[53] = new ModelRendererTurbo(this, 97, 113, textureX, textureY); // Box 512
		bodyModel[54] = new ModelRendererTurbo(this, 153, 113, textureX, textureY); // Box 513
		bodyModel[55] = new ModelRendererTurbo(this, 193, 113, textureX, textureY); // Box 514
		bodyModel[56] = new ModelRendererTurbo(this, 369, 193, textureX, textureY); // Box 524
		bodyModel[57] = new ModelRendererTurbo(this, 425, 201, textureX, textureY); // Box 525
		bodyModel[58] = new ModelRendererTurbo(this, 97, 137, textureX, textureY); // Box 554
		bodyModel[59] = new ModelRendererTurbo(this, 153, 137, textureX, textureY); // Box 555
		bodyModel[60] = new ModelRendererTurbo(this, 193, 209, textureX, textureY); // Box 556
		bodyModel[61] = new ModelRendererTurbo(this, 281, 225, textureX, textureY); // Box 557
		bodyModel[62] = new ModelRendererTurbo(this, 129, 121, textureX, textureY); // Box 559
		bodyModel[63] = new ModelRendererTurbo(this, 497, 121, textureX, textureY); // Box 560
		bodyModel[64] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 561
		bodyModel[65] = new ModelRendererTurbo(this, 225, 129, textureX, textureY); // Box 562
		bodyModel[66] = new ModelRendererTurbo(this, 385, 129, textureX, textureY); // Box 563
		bodyModel[67] = new ModelRendererTurbo(this, 457, 121, textureX, textureY); // Box 564
		bodyModel[68] = new ModelRendererTurbo(this, 481, 241, textureX, textureY); // Box 654
		bodyModel[69] = new ModelRendererTurbo(this, 129, 257, textureX, textureY); // Box 656
		bodyModel[70] = new ModelRendererTurbo(this, 193, 121, textureX, textureY); // Box 657
		bodyModel[71] = new ModelRendererTurbo(this, 89, 145, textureX, textureY); // Box 658
		bodyModel[72] = new ModelRendererTurbo(this, 281, 169, textureX, textureY); // Box 659
		bodyModel[73] = new ModelRendererTurbo(this, 233, 177, textureX, textureY); // Box 660
		bodyModel[74] = new ModelRendererTurbo(this, 1, 225, textureX, textureY); // Box 661
		bodyModel[75] = new ModelRendererTurbo(this, 473, 25, textureX, textureY); // Box 662
		bodyModel[76] = new ModelRendererTurbo(this, 297, 49, textureX, textureY); // Box 663
		bodyModel[77] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 666
		bodyModel[78] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 667
		bodyModel[79] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 668
		bodyModel[80] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 669
		bodyModel[81] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 670
		bodyModel[82] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 671
		bodyModel[83] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 672
		bodyModel[84] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 674
		bodyModel[85] = new ModelRendererTurbo(this, 217, 9, textureX, textureY); // Box 675
		bodyModel[86] = new ModelRendererTurbo(this, 265, 9, textureX, textureY); // Box 676
		bodyModel[87] = new ModelRendererTurbo(this, 329, 289, textureX, textureY); // Box 677
		bodyModel[88] = new ModelRendererTurbo(this, 481, 217, textureX, textureY); // Box 679
		bodyModel[89] = new ModelRendererTurbo(this, 481, 225, textureX, textureY); // Box 680
		bodyModel[90] = new ModelRendererTurbo(this, 433, 289, textureX, textureY); // Box 681
		bodyModel[91] = new ModelRendererTurbo(this, 57, 113, textureX, textureY); // Box 682
		bodyModel[92] = new ModelRendererTurbo(this, 305, 9, textureX, textureY); // Box 683
		bodyModel[93] = new ModelRendererTurbo(this, 441, 9, textureX, textureY); // Box 684
		bodyModel[94] = new ModelRendererTurbo(this, 369, 209, textureX, textureY); // Box 685
		bodyModel[95] = new ModelRendererTurbo(this, 433, 161, textureX, textureY); // Box 689
		bodyModel[96] = new ModelRendererTurbo(this, 89, 177, textureX, textureY); // Box 690
		bodyModel[97] = new ModelRendererTurbo(this, 457, 289, textureX, textureY); // Box 691
		bodyModel[98] = new ModelRendererTurbo(this, 25, 297, textureX, textureY); // Box 692
		bodyModel[99] = new ModelRendererTurbo(this, 193, 265, textureX, textureY); // Box 693
		bodyModel[100] = new ModelRendererTurbo(this, 473, 169, textureX, textureY); // Box 694
		bodyModel[101] = new ModelRendererTurbo(this, 481, 265, textureX, textureY); // Box 695
		bodyModel[102] = new ModelRendererTurbo(this, 233, 297, textureX, textureY); // Box 696
		bodyModel[103] = new ModelRendererTurbo(this, 369, 297, textureX, textureY); // Box 697
		bodyModel[104] = new ModelRendererTurbo(this, 393, 177, textureX, textureY); // Box 698
		bodyModel[105] = new ModelRendererTurbo(this, 185, 185, textureX, textureY); // Box 699
		bodyModel[106] = new ModelRendererTurbo(this, 73, 297, textureX, textureY); // Box 700
		bodyModel[107] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 701
		bodyModel[108] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 702
		bodyModel[109] = new ModelRendererTurbo(this, 425, 209, textureX, textureY); // Box 703
		bodyModel[110] = new ModelRendererTurbo(this, 1, 305, textureX, textureY); // Box 704
		bodyModel[111] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 705
		bodyModel[112] = new ModelRendererTurbo(this, 473, 305, textureX, textureY); // Box 706
		bodyModel[113] = new ModelRendererTurbo(this, 337, 185, textureX, textureY); // Box 707
		bodyModel[114] = new ModelRendererTurbo(this, 113, 313, textureX, textureY); // Box 708
		bodyModel[115] = new ModelRendererTurbo(this, 273, 297, textureX, textureY); // Box 709
		bodyModel[116] = new ModelRendererTurbo(this, 489, 185, textureX, textureY); // Box 710
		bodyModel[117] = new ModelRendererTurbo(this, 57, 129, textureX, textureY); // Box 725
		bodyModel[118] = new ModelRendererTurbo(this, 193, 129, textureX, textureY); // Box 726
		bodyModel[119] = new ModelRendererTurbo(this, 289, 193, textureX, textureY); // Box 727
		bodyModel[120] = new ModelRendererTurbo(this, 337, 193, textureX, textureY); // Box 728
		bodyModel[121] = new ModelRendererTurbo(this, 361, 41, textureX, textureY); // Box 729
		bodyModel[122] = new ModelRendererTurbo(this, 385, 41, textureX, textureY); // Box 730
		bodyModel[123] = new ModelRendererTurbo(this, 409, 41, textureX, textureY); // Box 731
		bodyModel[124] = new ModelRendererTurbo(this, 425, 41, textureX, textureY); // Box 732
		bodyModel[125] = new ModelRendererTurbo(this, 489, 41, textureX, textureY); // Box 733
		bodyModel[126] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 734
		bodyModel[127] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 735
		bodyModel[128] = new ModelRendererTurbo(this, 473, 57, textureX, textureY); // Box 736
		bodyModel[129] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 737
		bodyModel[130] = new ModelRendererTurbo(this, 41, 65, textureX, textureY); // Box 738
		bodyModel[131] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 739
		bodyModel[132] = new ModelRendererTurbo(this, 89, 65, textureX, textureY); // Box 740
		bodyModel[133] = new ModelRendererTurbo(this, 249, 65, textureX, textureY); // Box 741
		bodyModel[134] = new ModelRendererTurbo(this, 265, 65, textureX, textureY); // Box 742
		bodyModel[135] = new ModelRendererTurbo(this, 281, 65, textureX, textureY); // Box 743
		bodyModel[136] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 744
		bodyModel[137] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 745
		bodyModel[138] = new ModelRendererTurbo(this, 81, 81, textureX, textureY); // Box 746
		bodyModel[139] = new ModelRendererTurbo(this, 105, 81, textureX, textureY); // Box 747
		bodyModel[140] = new ModelRendererTurbo(this, 177, 81, textureX, textureY); // Box 748
		bodyModel[141] = new ModelRendererTurbo(this, 313, 81, textureX, textureY); // Box 749
		bodyModel[142] = new ModelRendererTurbo(this, 329, 81, textureX, textureY); // Box 750
		bodyModel[143] = new ModelRendererTurbo(this, 441, 193, textureX, textureY); // Box 751
		bodyModel[144] = new ModelRendererTurbo(this, 497, 193, textureX, textureY); // Box 752
		bodyModel[145] = new ModelRendererTurbo(this, 97, 169, textureX, textureY); // Box 753
		bodyModel[146] = new ModelRendererTurbo(this, 105, 321, textureX, textureY); // Box 742

		bodyModel[0].addBox(-32F, 1F, -21F, 64, 2, 40, 0F); // Box 0
		bodyModel[0].setRotationPoint(0F, -1F, 1F);

		bodyModel[1].addShapeBox(0F, 0F, 0F, 10, 2, 18, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 1
		bodyModel[1].setRotationPoint(32F, 1F, -9F);

		bodyModel[2].addShapeBox(0F, 0F, 0F, 10, 2, 28, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 2
		bodyModel[2].setRotationPoint(-42F, 1F, -14F);

		bodyModel[3].addBox(0F, 0F, 0F, 3, 3, 34, 0F); // Box 3
		bodyModel[3].setRotationPoint(42F, -1F, -17F);

		bodyModel[4].addBox(0F, 0F, 0F, 3, 3, 34, 0F); // Box 4
		bodyModel[4].setRotationPoint(-45F, -1F, -17F);

		bodyModel[5].addShapeBox(0F, 0F, 0F, 10, 2, 18, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 9
		bodyModel[5].setRotationPoint(45F, 1F, -9F);

		bodyModel[6].addShapeBox(0F, 0F, 0F, 10, 2, 28, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 10
		bodyModel[6].setRotationPoint(-55F, 1F, -14F);

		bodyModel[7].addShapeBox(0F, 0F, 0F, 58, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 432
		bodyModel[7].setRotationPoint(-29F, 0.5F, 21F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 58, 3, 1, 0F,0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 433
		bodyModel[8].setRotationPoint(-29F, 0.5F, -22F);

		bodyModel[9].addShapeBox(0F, 0F, 0F, 64, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 434
		bodyModel[9].setRotationPoint(-32F, 3F, 18F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 64, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 435
		bodyModel[10].setRotationPoint(-32F, 3F, -21F);

		bodyModel[11].addBox(0F, 0F, -21F, 3, 3, 42, 0F); // Box 436
		bodyModel[11].setRotationPoint(55F, 0F, 0F);

		bodyModel[12].addBox(0F, 0F, -21F, 3, 3, 42, 0F); // Box 437
		bodyModel[12].setRotationPoint(-58F, 0F, 0F);

		bodyModel[13].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1F, -0.5F); // Box 438
		bodyModel[13].setRotationPoint(55F, 0.5F, 21F);

		bodyModel[14].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F,0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 440
		bodyModel[14].setRotationPoint(32F, 1F, -12F);

		bodyModel[15].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F,0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 441
		bodyModel[15].setRotationPoint(45F, 1F, -12F);

		bodyModel[16].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -2F); // Box 442
		bodyModel[16].setRotationPoint(45F, 1F, 9F);

		bodyModel[17].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, -2F, 0F, 0F, 0F); // Box 443
		bodyModel[17].setRotationPoint(32F, 1F, 9F);

		bodyModel[18].addShapeBox(0F, 0F, -21F, 2, 4, 42, 0F,0F, 0F, 0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, -0.5F, 0.5F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -0.5F, 0.5F); // Box 450
		bodyModel[18].setRotationPoint(58F, 0F, 0F);

		bodyModel[19].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 451
		bodyModel[19].setRotationPoint(55F, 0.5F, -22F);

		bodyModel[20].addShapeBox(0F, 0F, 0F, 3, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 452
		bodyModel[20].setRotationPoint(55F, 3F, 15F);

		bodyModel[21].addShapeBox(0F, 0F, 0F, 3, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F); // Box 453
		bodyModel[21].setRotationPoint(55F, 3F, -20F);

		bodyModel[22].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 454
		bodyModel[22].setRotationPoint(55F, 3F, -21F);

		bodyModel[23].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 455
		bodyModel[23].setRotationPoint(55F, 3F, 20F);

		bodyModel[24].addShapeBox(0F, 0F, 0F, 3, 1, 30, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F); // Box 456
		bodyModel[24].setRotationPoint(55F, 3F, -15F);

		bodyModel[25].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 462
		bodyModel[25].setRotationPoint(57.65F, -2.7F, -9F);

		bodyModel[26].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 463
		bodyModel[26].setRotationPoint(57.6F, -3F, -9F);

		bodyModel[27].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 464
		bodyModel[27].setRotationPoint(57.55F, -3.3F, -9F);

		bodyModel[28].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 465
		bodyModel[28].setRotationPoint(57.5F, -3.6F, -9F);

		bodyModel[29].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 466
		bodyModel[29].setRotationPoint(57.45F, -3.9F, -9F);

		bodyModel[30].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 467
		bodyModel[30].setRotationPoint(57.4F, -4.2F, -9F);

		bodyModel[31].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 468
		bodyModel[31].setRotationPoint(57.35F, -4.5F, -9F);

		bodyModel[32].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 469
		bodyModel[32].setRotationPoint(57.3F, -4.8F, -9F);

		bodyModel[33].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 470
		bodyModel[33].setRotationPoint(57.25F, -5.1F, -9F);

		bodyModel[34].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 471
		bodyModel[34].setRotationPoint(57.2F, -5.4F, -9F);

		bodyModel[35].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 472
		bodyModel[35].setRotationPoint(57.15F, -5.7F, -9F);

		bodyModel[36].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 473
		bodyModel[36].setRotationPoint(57.1F, -6F, -9F);

		bodyModel[37].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 474
		bodyModel[37].setRotationPoint(57.05F, -6.3F, -9F);

		bodyModel[38].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 475
		bodyModel[38].setRotationPoint(57F, -6.6F, -9F);

		bodyModel[39].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 476
		bodyModel[39].setRotationPoint(56.95F, -6.9F, -9F);

		bodyModel[40].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 477
		bodyModel[40].setRotationPoint(56.9F, -7.2F, -9F);

		bodyModel[41].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 478
		bodyModel[41].setRotationPoint(56.85F, -7.5F, -9F);

		bodyModel[42].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 479
		bodyModel[42].setRotationPoint(56.8F, -7.8F, -9F);

		bodyModel[43].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 480
		bodyModel[43].setRotationPoint(56.75F, -8.1F, -9F);

		bodyModel[44].addShapeBox(0F, 0F, -21F, 2, 4, 42, 0F,0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -1F, -1F); // Box 503
		bodyModel[44].setRotationPoint(-60F, 0F, 0F);

		bodyModel[45].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, 0F, -0.5F); // Box 504
		bodyModel[45].setRotationPoint(-58F, 0.5F, 21F);

		bodyModel[46].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 505
		bodyModel[46].setRotationPoint(-58F, 0.5F, -22F);

		bodyModel[47].addShapeBox(0F, 0F, 0F, 3, 1, 30, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 506
		bodyModel[47].setRotationPoint(-58F, 3F, -15F);

		bodyModel[48].addShapeBox(0F, 0F, 0F, 3, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 507
		bodyModel[48].setRotationPoint(-58F, 3F, -20F);

		bodyModel[49].addShapeBox(0F, 0F, 0F, 3, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 508
		bodyModel[49].setRotationPoint(-58F, 3F, 15F);

		bodyModel[50].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 509
		bodyModel[50].setRotationPoint(-58F, 3F, 20F);

		bodyModel[51].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 510
		bodyModel[51].setRotationPoint(-58F, 3F, -21F);

		bodyModel[52].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -1F, -0.5F); // Box 511
		bodyModel[52].setRotationPoint(-32F, 0.5F, 21F);

		bodyModel[53].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -0.5F, -0.5F); // Box 512
		bodyModel[53].setRotationPoint(29F, 0.5F, 21F);

		bodyModel[54].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 513
		bodyModel[54].setRotationPoint(-32F, 0.5F, -22F);

		bodyModel[55].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, -0.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 514
		bodyModel[55].setRotationPoint(29F, 0.5F, -22F);

		bodyModel[56].addShapeBox(0F, 0F, 0F, 10, 2, 28, 0F,0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 524
		bodyModel[56].setRotationPoint(-55F, -1F, -14F);

		bodyModel[57].addShapeBox(0F, 0F, 0F, 10, 2, 28, 0F,0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 525
		bodyModel[57].setRotationPoint(-42F, -1F, -14F);

		bodyModel[58].addShapeBox(0F, 0F, 0F, 13, 2, 1, 0F,0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 554
		bodyModel[58].setRotationPoint(-3.5F, -28.5F, -10.5F);

		bodyModel[59].addShapeBox(0F, 0F, 0F, 13, 2, 1, 0F,0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 555
		bodyModel[59].setRotationPoint(-3.5F, -28.5F, 9.5F);

		bodyModel[60].addShapeBox(0F, 0F, 0F, 1, 2, 19, 0F,0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 556
		bodyModel[60].setRotationPoint(-3.5F, -28.5F, -9.5F);

		bodyModel[61].addShapeBox(0F, 0F, 0F, 1, 2, 19, 0F,0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 557
		bodyModel[61].setRotationPoint(8.5F, -28.5F, -9.5F);

		bodyModel[62].addShapeBox(0F, 0F, 0F, 3, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 559
		bodyModel[62].setRotationPoint(-3.5F, -27F, 17F);

		bodyModel[63].addShapeBox(0F, 0F, 0F, 3, 10, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 560
		bodyModel[63].setRotationPoint(-3.5F, -20F, 18F);

		bodyModel[64].addBox(0F, 0F, 0F, 3, 11, 1, 0F); // Box 561
		bodyModel[64].setRotationPoint(-3.5F, -10F, 19F);

		bodyModel[65].addBox(0F, 0F, 0F, 3, 11, 1, 0F); // Box 562
		bodyModel[65].setRotationPoint(-3.5F, -10F, -20F);

		bodyModel[66].addShapeBox(0F, 0F, 0F, 3, 10, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 563
		bodyModel[66].setRotationPoint(-3.5F, -20F, -19F);

		bodyModel[67].addShapeBox(0F, 0F, 0F, 3, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 564
		bodyModel[67].setRotationPoint(-3.5F, -27F, -18F);

		bodyModel[68].addShapeBox(0F, 0F, 0F, 3, 2, 10, 0F,0F, 0F, 0F, 0.7F, 0F, 0F, -0.1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.9F, 0F, 0F, 0.1F, 0F, -1F, -0.2F, 0F, 0F); // Box 654
		bodyModel[68].setRotationPoint(54.5F, -6F, 11F);

		bodyModel[69].addShapeBox(0F, 0F, 0F, 3, 2, 10, 0F,0F, 0F, 0F, -0.1F, 0F, -1F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0.1F, 0F, -1F, 0.9F, 0F, 0F, 0F, 0F, 0F); // Box 656
		bodyModel[69].setRotationPoint(54.5F, -6F, -21F);

		bodyModel[70].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F); // Box 657
		bodyModel[70].setRotationPoint(57.4F, -1.5F, 16F);

		bodyModel[71].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 658
		bodyModel[71].setRotationPoint(57.4F, -1.5F, -19F);

		bodyModel[72].addShapeBox(0F, 0F, 0F, 3, 5, 4, 0F,-0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, -0.6F, 0F, -0.9F, 0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.8F); // Box 659
		bodyModel[72].setRotationPoint(-58F, -8F, 17F);

		bodyModel[73].addShapeBox(0F, 0F, 0F, 3, 5, 4, 0F,-0.6F, 0F, -0.9F, 0F, 0F, -0.1F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0.3F, 0F, 0F); // Box 660
		bodyModel[73].setRotationPoint(-58F, -8F, -21F);

		bodyModel[74].addShapeBox(0F, 0F, 0F, 1, 3, 10, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 661
		bodyModel[74].setRotationPoint(60F, 0.5F, -5F);
		bodyModel[74].rotateAngleZ = -0.03490659F;

		bodyModel[75].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F,0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.7F, 0F, 0F, -0.7F); // Box 662
		bodyModel[75].setRotationPoint(29F, -9F, 20.9F);

		bodyModel[76].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F,0F, 0F, -0.7F, 0F, 0F, -0.7F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F); // Box 663
		bodyModel[76].setRotationPoint(29F, -9F, -21.9F);

		bodyModel[77].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 666
		bodyModel[77].setRotationPoint(30.5F, -2F, 20.1F);

		bodyModel[78].addShapeBox(0F, 0.8F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 667
		bodyModel[78].setRotationPoint(30.5F, -2F, 20.1F);

		bodyModel[79].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 668
		bodyModel[79].setRotationPoint(31.5F, -2F, 20.1F);

		bodyModel[80].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 669
		bodyModel[80].setRotationPoint(30.5F, -2F, 20.1F);
		bodyModel[80].rotateAngleZ = 0.17453293F;

		bodyModel[81].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 670
		bodyModel[81].setRotationPoint(30.1F, -2F, 20.1F);

		bodyModel[82].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 671
		bodyModel[82].setRotationPoint(29.1F, -2F, 20.1F);

		bodyModel[83].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 672
		bodyModel[83].setRotationPoint(29.1F, -1.6F, 20.1F);

		bodyModel[84].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 674
		bodyModel[84].setRotationPoint(29F, -2F, 20.1F);
		bodyModel[84].rotateAngleZ = 0.17453293F;

		bodyModel[85].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0.5F, -0.8F, 0F, -0.3F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 675
		bodyModel[85].setRotationPoint(29.1F, -1.8F, 20.1F);

		bodyModel[86].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.4F, 0F); // Box 676
		bodyModel[86].setRotationPoint(29.1F, -1.6F, 20.1F);

		bodyModel[87].addBox(0F, 0F, 0F, 12, 1, 12, 0F); // Box 677
		bodyModel[87].setRotationPoint(0F, -4F, 4F);

		bodyModel[88].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F,0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 679
		bodyModel[88].setRotationPoint(0F, -4F, 2F);

		bodyModel[89].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 680
		bodyModel[89].setRotationPoint(0F, -4F, 16F);

		bodyModel[90].addShapeBox(-0.5F, -16F, -7F, 2, 16, 14, 0F,-0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 681
		bodyModel[90].setRotationPoint(-1F, -4F, 10F);
		bodyModel[90].rotateAngleZ = 0.17453293F;

		bodyModel[91].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F,0F, 0F, 0F, -0.05F, 0.2F, 0F, -0.05F, 0.2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F); // Box 682
		bodyModel[91].setRotationPoint(-1F, -4F, 4F);

		bodyModel[92].addShapeBox(0F, -18F, -3F, 1, 2, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 683
		bodyModel[92].setRotationPoint(-1F, -4F, 10F);
		bodyModel[92].rotateAngleZ = 0.17453293F;

		bodyModel[93].addShapeBox(0F, -18F, 2F, 1, 2, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 684
		bodyModel[93].setRotationPoint(-1F, -4F, 10F);
		bodyModel[93].rotateAngleZ = 0.17453293F;

		bodyModel[94].addShapeBox(-0.5F, -20.5F, -3.5F, 2, 3, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 685
		bodyModel[94].setRotationPoint(-1F, -4F, 10F);
		bodyModel[94].rotateAngleZ = 0.17453293F;

		bodyModel[95].addBox(0F, 0F, -4F, 8, 2, 1, 0F); // Box 689
		bodyModel[95].setRotationPoint(2F, -2F, 10F);

		bodyModel[96].addBox(0F, 0F, 3F, 8, 2, 1, 0F); // Box 690
		bodyModel[96].setRotationPoint(2F, -2F, 10F);

		bodyModel[97].addShapeBox(0F, 0F, 0F, 11, 1, 11, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 691
		bodyModel[97].setRotationPoint(0.5F, -3F, 4.5F);

		bodyModel[98].addShapeBox(0F, -2F, -19F, 4, 9, 38, 0F,0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -1F); // Box 692
		bodyModel[98].setRotationPoint(21F, -12F, 0F);

		bodyModel[99].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 693
		bodyModel[99].setRotationPoint(0F, -4F, -4F);

		bodyModel[100].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F,0F, 0F, 0F, -0.05F, 0.2F, 0F, -0.05F, 0.2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F); // Box 694
		bodyModel[100].setRotationPoint(-1F, -4F, -16F);

		bodyModel[101].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F,0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 695
		bodyModel[101].setRotationPoint(0F, -4F, -18F);

		bodyModel[102].addBox(0F, 0F, 0F, 12, 1, 12, 0F); // Box 696
		bodyModel[102].setRotationPoint(0F, -4F, -16F);

		bodyModel[103].addShapeBox(0F, 0F, 0F, 11, 1, 11, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 697
		bodyModel[103].setRotationPoint(0.5F, -3F, -15.5F);

		bodyModel[104].addBox(0F, 0F, -4F, 8, 2, 1, 0F); // Box 698
		bodyModel[104].setRotationPoint(2F, -2F, -10F);

		bodyModel[105].addBox(0F, 0F, 3F, 8, 2, 1, 0F); // Box 699
		bodyModel[105].setRotationPoint(2F, -2F, -10F);

		bodyModel[106].addShapeBox(-0.5F, -16F, -7F, 2, 16, 14, 0F,-0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 700
		bodyModel[106].setRotationPoint(-1F, -4F, -10F);
		bodyModel[106].rotateAngleZ = 0.17453293F;

		bodyModel[107].addShapeBox(0F, -18F, -3F, 1, 2, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 701
		bodyModel[107].setRotationPoint(-1F, -4F, -10F);
		bodyModel[107].rotateAngleZ = 0.17453293F;

		bodyModel[108].addShapeBox(0F, -18F, 2F, 1, 2, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 702
		bodyModel[108].setRotationPoint(-1F, -4F, -10F);
		bodyModel[108].rotateAngleZ = 0.17453293F;

		bodyModel[109].addShapeBox(-0.5F, -20.5F, -3.5F, 2, 3, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 703
		bodyModel[109].setRotationPoint(-1F, -4F, -10F);
		bodyModel[109].rotateAngleZ = 0.17453293F;

		bodyModel[110].addShapeBox(-1F, -1F, -16F, 4, 7, 12, 0F,0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -1F); // Box 704
		bodyModel[110].setRotationPoint(21F, -12F, 0F);

		bodyModel[111].addShapeBox(-1.2F, 0F, -12.5F, 1, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 705
		bodyModel[111].setRotationPoint(21F, -12F, 0F);

		bodyModel[112].addShapeBox(-3F, -1.5F, 5F, 5, 7, 12, 0F,0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, 0F, -3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -1F); // Box 706
		bodyModel[112].setRotationPoint(21F, -12F, 0F);

		bodyModel[113].addShapeBox(-4F, -1F, -1F, 3, 2, 2, 0F,0F, 1.9F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.9F, -0.1F, 0F, -2.1F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.1F, -0.1F); // Box 707
		bodyModel[113].setRotationPoint(19F, -12F, 11F);

		bodyModel[114].addShapeBox(-1F, 0F, -4F, 5, 14, 8, 0F,0F, 0F, -2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 708
		bodyModel[114].setRotationPoint(21F, -14F, 0F);

		bodyModel[115].addShapeBox(-1F, 0F, -3F, 13, 3, 6, 0F,0F, -1F, -2F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 709
		bodyModel[115].setRotationPoint(8F, -3F, 0F);

		bodyModel[116].addShapeBox(-1F, 0F, -4F, 6, 2, 4, 0F,0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 710
		bodyModel[116].setRotationPoint(15F, -4F, 2F);

		bodyModel[117].addBox(0F, 0F, -0.5F, 1, 4, 1, 0F); // Box 725
		bodyModel[117].setRotationPoint(16F, -7F, 0F);
		bodyModel[117].rotateAngleZ = 0.17453293F;

		bodyModel[118].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 726
		bodyModel[118].setRotationPoint(19.9F, -13.5F, -1F);

		bodyModel[119].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 727
		bodyModel[119].setRotationPoint(19.9F, -11.5F, -1.5F);

		bodyModel[120].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 728
		bodyModel[120].setRotationPoint(19.9F, -12F, -1.5F);

		bodyModel[121].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 729
		bodyModel[121].setRotationPoint(19.9F, -12.5F, -1.75F);

		bodyModel[122].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 730
		bodyModel[122].setRotationPoint(19.9F, -12.5F, 0.75F);

		bodyModel[123].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 731
		bodyModel[123].setRotationPoint(19.9F, -12.5F, -0.5F);

		bodyModel[124].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 732
		bodyModel[124].setRotationPoint(19.9F, -13F, -1.75F);

		bodyModel[125].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 733
		bodyModel[125].setRotationPoint(19.9F, -13F, -0.5F);

		bodyModel[126].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 734
		bodyModel[126].setRotationPoint(19.9F, -13F, 0.75F);

		bodyModel[127].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 735
		bodyModel[127].setRotationPoint(19.9F, -13.5F, 1F);

		bodyModel[128].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 736
		bodyModel[128].setRotationPoint(19.9F, -13.5F, -2F);

		bodyModel[129].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 737
		bodyModel[129].setRotationPoint(17.9F, -14.5F, 6F);

		bodyModel[130].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 738
		bodyModel[130].setRotationPoint(17.9F, -13.5F, 6F);

		bodyModel[131].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 739
		bodyModel[131].setRotationPoint(17.9F, -12.5F, 6F);

		bodyModel[132].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 740
		bodyModel[132].setRotationPoint(17.9F, -11.5F, 6F);

		bodyModel[133].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 741
		bodyModel[133].setRotationPoint(17.9F, -11.5F, 7F);

		bodyModel[134].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 742
		bodyModel[134].setRotationPoint(17.9F, -12.5F, 7F);

		bodyModel[135].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 743
		bodyModel[135].setRotationPoint(17.9F, -13.5F, 7F);

		bodyModel[136].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 744
		bodyModel[136].setRotationPoint(17.9F, -14.5F, 7F);

		bodyModel[137].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 745
		bodyModel[137].setRotationPoint(17.9F, -14.5F, 14F);

		bodyModel[138].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 746
		bodyModel[138].setRotationPoint(17.9F, -14.5F, 15F);

		bodyModel[139].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 747
		bodyModel[139].setRotationPoint(17.9F, -13.5F, 15F);

		bodyModel[140].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 748
		bodyModel[140].setRotationPoint(17.9F, -11.5F, 15F);

		bodyModel[141].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 749
		bodyModel[141].setRotationPoint(17.9F, -11.5F, 14F);

		bodyModel[142].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 750
		bodyModel[142].setRotationPoint(17.9F, -13.5F, 14F);

		bodyModel[143].addShapeBox(0F, 0F, 0F, 4, 2, 2, 0F,0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 751
		bodyModel[143].setRotationPoint(21F, -2F, 7F);

		bodyModel[144].addShapeBox(0F, 0F, 0F, 4, 2, 2, 0F,0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 752
		bodyModel[144].setRotationPoint(21F, -2F, 13F);

		bodyModel[145].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F,0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 753
		bodyModel[145].setRotationPoint(22F, -2F, 12F);

		bodyModel[146].addBox(-32F, 1F, -21F, 64, 1, 42, 0F); // Box 742
		bodyModel[146].setRotationPoint(0F, 1F, 0F);
	}

	private void initprimaryPaintBodyDoorOpenModel_1(){
		primaryPaintBodyDoorOpenModel = new ModelRendererTurbo[41];
		primaryPaintBodyDoorOpenModel[0] = new ModelRendererTurbo(this, 129, 281, textureX, textureY); // Box 610
		primaryPaintBodyDoorOpenModel[1] = new ModelRendererTurbo(this, 193, 281, textureX, textureY); // Box 611
		primaryPaintBodyDoorOpenModel[2] = new ModelRendererTurbo(this, 217, 145, textureX, textureY); // Box 612
		primaryPaintBodyDoorOpenModel[3] = new ModelRendererTurbo(this, 225, 145, textureX, textureY); // Box 613
		primaryPaintBodyDoorOpenModel[4] = new ModelRendererTurbo(this, 81, 225, textureX, textureY); // Box 614
		primaryPaintBodyDoorOpenModel[5] = new ModelRendererTurbo(this, 345, 145, textureX, textureY); // Box 615
		primaryPaintBodyDoorOpenModel[6] = new ModelRendererTurbo(this, 505, 145, textureX, textureY); // Box 616
		primaryPaintBodyDoorOpenModel[7] = new ModelRendererTurbo(this, 145, 97, textureX, textureY); // Box 617
		primaryPaintBodyDoorOpenModel[8] = new ModelRendererTurbo(this, 177, 97, textureX, textureY); // Box 618
		primaryPaintBodyDoorOpenModel[9] = new ModelRendererTurbo(this, 257, 281, textureX, textureY); // Box 619
		primaryPaintBodyDoorOpenModel[10] = new ModelRendererTurbo(this, 321, 281, textureX, textureY); // Box 620
		primaryPaintBodyDoorOpenModel[11] = new ModelRendererTurbo(this, 337, 153, textureX, textureY); // Box 621
		primaryPaintBodyDoorOpenModel[12] = new ModelRendererTurbo(this, 401, 153, textureX, textureY); // Box 622
		primaryPaintBodyDoorOpenModel[13] = new ModelRendererTurbo(this, 409, 225, textureX, textureY); // Box 623
		primaryPaintBodyDoorOpenModel[14] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 624
		primaryPaintBodyDoorOpenModel[15] = new ModelRendererTurbo(this, 9, 161, textureX, textureY); // Box 625
		primaryPaintBodyDoorOpenModel[16] = new ModelRendererTurbo(this, 209, 97, textureX, textureY); // Box 626
		primaryPaintBodyDoorOpenModel[17] = new ModelRendererTurbo(this, 361, 113, textureX, textureY); // Box 627
		primaryPaintBodyDoorOpenModel[18] = new ModelRendererTurbo(this, 385, 281, textureX, textureY); // Box 628
		primaryPaintBodyDoorOpenModel[19] = new ModelRendererTurbo(this, 449, 281, textureX, textureY); // Box 629
		primaryPaintBodyDoorOpenModel[20] = new ModelRendererTurbo(this, 49, 161, textureX, textureY); // Box 630
		primaryPaintBodyDoorOpenModel[21] = new ModelRendererTurbo(this, 65, 161, textureX, textureY); // Box 631
		primaryPaintBodyDoorOpenModel[22] = new ModelRendererTurbo(this, 281, 249, textureX, textureY); // Box 632
		primaryPaintBodyDoorOpenModel[23] = new ModelRendererTurbo(this, 201, 161, textureX, textureY); // Box 633
		primaryPaintBodyDoorOpenModel[24] = new ModelRendererTurbo(this, 249, 161, textureX, textureY); // Box 634
		primaryPaintBodyDoorOpenModel[25] = new ModelRendererTurbo(this, 385, 113, textureX, textureY); // Box 635
		primaryPaintBodyDoorOpenModel[26] = new ModelRendererTurbo(this, 97, 121, textureX, textureY); // Box 636
		primaryPaintBodyDoorOpenModel[27] = new ModelRendererTurbo(this, 1, 289, textureX, textureY); // Box 637
		primaryPaintBodyDoorOpenModel[28] = new ModelRendererTurbo(this, 65, 289, textureX, textureY); // Box 638
		primaryPaintBodyDoorOpenModel[29] = new ModelRendererTurbo(this, 145, 169, textureX, textureY); // Box 639
		primaryPaintBodyDoorOpenModel[30] = new ModelRendererTurbo(this, 169, 169, textureX, textureY); // Box 640
		primaryPaintBodyDoorOpenModel[31] = new ModelRendererTurbo(this, 281, 257, textureX, textureY); // Box 641
		primaryPaintBodyDoorOpenModel[32] = new ModelRendererTurbo(this, 177, 169, textureX, textureY); // Box 642
		primaryPaintBodyDoorOpenModel[33] = new ModelRendererTurbo(this, 185, 169, textureX, textureY); // Box 643
		primaryPaintBodyDoorOpenModel[34] = new ModelRendererTurbo(this, 153, 121, textureX, textureY); // Box 644
		primaryPaintBodyDoorOpenModel[35] = new ModelRendererTurbo(this, 273, 137, textureX, textureY); // Box 645
		primaryPaintBodyDoorOpenModel[36] = new ModelRendererTurbo(this, 161, 289, textureX, textureY); // Box 646
		primaryPaintBodyDoorOpenModel[37] = new ModelRendererTurbo(this, 289, 289, textureX, textureY); // Box 647
		primaryPaintBodyDoorOpenModel[38] = new ModelRendererTurbo(this, 97, 273, textureX, textureY); // Box 648
		primaryPaintBodyDoorOpenModel[39] = new ModelRendererTurbo(this, 201, 49, textureX, textureY); // Box 652
		primaryPaintBodyDoorOpenModel[40] = new ModelRendererTurbo(this, 241, 217, textureX, textureY); // Box 653

		primaryPaintBodyDoorOpenModel[0].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 610
		primaryPaintBodyDoorOpenModel[0].setRotationPoint(25F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[0].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[1].addShapeBox(-27F, -2F, -0.5F, 27, 2, 1, 0F,-0.5F, 0.5F, 0.25F, -1F, 0.5F, 0.25F, -1F, 0.5F, -0.25F, -0.5F, 0.5F, -0.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 611
		primaryPaintBodyDoorOpenModel[1].setRotationPoint(25F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[1].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[2].addShapeBox(-5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -0.5F, -0.75F, 3F, -0.5F, -0.75F, 3F, -0.5F, 0.75F, -3F, -0.5F, 0.75F); // Box 612
		primaryPaintBodyDoorOpenModel[2].setRotationPoint(25F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[2].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[3].addShapeBox(-9F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, -1F, 4F, 0F, -1F, 4F, 0F, 1F, -4F, 0F, 1F); // Box 613
		primaryPaintBodyDoorOpenModel[3].setRotationPoint(25F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[3].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[4].addShapeBox(-25.5F, -17F, -2.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F); // Box 614
		primaryPaintBodyDoorOpenModel[4].setRotationPoint(25F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[4].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[5].addShapeBox(-26.5F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 615
		primaryPaintBodyDoorOpenModel[5].setRotationPoint(25F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[5].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[6].addShapeBox(-26.5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F); // Box 616
		primaryPaintBodyDoorOpenModel[6].setRotationPoint(25F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[6].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[7].addShapeBox(-24F, 0F, -0.1F, 3, 1, 1, 0F,0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0.2F, 0F, -0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0.4F, 0F, 0F, 0.4F, 0F, 0F); // Box 617
		primaryPaintBodyDoorOpenModel[7].setRotationPoint(25F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[7].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[8].addShapeBox(-12.5F, 0F, -1F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 618
		primaryPaintBodyDoorOpenModel[8].setRotationPoint(25F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[8].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[9].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 619
		primaryPaintBodyDoorOpenModel[9].setRotationPoint(25F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[9].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[10].addShapeBox(-27F, -2F, -0.5F, 27, 2, 1, 0F,-0.5F, 0.5F, -0.25F, -1F, 0.5F, -0.25F, -1F, 0.5F, 0.25F, -0.5F, 0.5F, 0.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 620
		primaryPaintBodyDoorOpenModel[10].setRotationPoint(25F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[10].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[11].addShapeBox(-5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -0.5F, 0.75F, 3F, -0.5F, 0.75F, 3F, -0.5F, -0.75F, -3F, -0.5F, -0.75F); // Box 621
		primaryPaintBodyDoorOpenModel[11].setRotationPoint(25F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[11].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[12].addShapeBox(-9F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 1F, 4F, 0F, 1F, 4F, 0F, -1F, -4F, 0F, -1F); // Box 622
		primaryPaintBodyDoorOpenModel[12].setRotationPoint(25F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[12].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[13].addShapeBox(-25.5F, -17F, 1.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F); // Box 623
		primaryPaintBodyDoorOpenModel[13].setRotationPoint(25F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[13].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[14].addShapeBox(-26.5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F); // Box 624
		primaryPaintBodyDoorOpenModel[14].setRotationPoint(25F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[14].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[15].addShapeBox(-26.5F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 625
		primaryPaintBodyDoorOpenModel[15].setRotationPoint(25F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[15].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[16].addShapeBox(-24F, 0F, -0.9F, 3, 1, 1, 0F,0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.4F); // Box 626
		primaryPaintBodyDoorOpenModel[16].setRotationPoint(25F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[16].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[17].addShapeBox(-12.5F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 627
		primaryPaintBodyDoorOpenModel[17].setRotationPoint(25F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[17].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[18].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 628
		primaryPaintBodyDoorOpenModel[18].setRotationPoint(-2.5F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[18].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[19].addShapeBox(-26.5F, -2F, -0.5F, 27, 2, 1, 0F,-1F, 0.5F, 0.25F, -0.5F, 0.5F, 0.25F, -0.5F, 0.5F, -0.25F, -1F, 0.5F, -0.25F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 629
		primaryPaintBodyDoorOpenModel[19].setRotationPoint(-2.5F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[19].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[20].addShapeBox(-1F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F); // Box 630
		primaryPaintBodyDoorOpenModel[20].setRotationPoint(-2.5F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[20].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[21].addShapeBox(-1F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 631
		primaryPaintBodyDoorOpenModel[21].setRotationPoint(-2.5F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[21].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[22].addShapeBox(-18F, -17F, -2.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F); // Box 632
		primaryPaintBodyDoorOpenModel[22].setRotationPoint(-2.5F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[22].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[23].addShapeBox(-18.5F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, -1F, -4F, 0F, -1F, -4F, 0F, 1F, 4F, 0F, 1F); // Box 633
		primaryPaintBodyDoorOpenModel[23].setRotationPoint(-2.5F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[23].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[24].addShapeBox(-22.5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, -0.75F, -3F, -0.5F, -0.75F, -3F, -0.5F, 0.75F, 3F, -0.5F, 0.75F); // Box 634
		primaryPaintBodyDoorOpenModel[24].setRotationPoint(-2.5F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[24].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[25].addShapeBox(-21F, 0F, -0.1F, 3, 1, 1, 0F,0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0.2F, 0F, -0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0.4F, 0F, 0F, 0.4F, 0F, 0F); // Box 635
		primaryPaintBodyDoorOpenModel[25].setRotationPoint(-2.5F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[25].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[26].addShapeBox(-7.5F, 0F, -1F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 636
		primaryPaintBodyDoorOpenModel[26].setRotationPoint(-2.5F, -10F, 20.5F);
		primaryPaintBodyDoorOpenModel[26].rotateAngleY = -1.04719755F;

		primaryPaintBodyDoorOpenModel[27].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 637
		primaryPaintBodyDoorOpenModel[27].setRotationPoint(-2.5F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[27].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[28].addShapeBox(-26.5F, -2F, -0.5F, 27, 2, 1, 0F,-1F, 0.5F, -0.25F, -0.5F, 0.5F, -0.25F, -0.5F, 0.5F, 0.25F, -1F, 0.5F, 0.25F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 638
		primaryPaintBodyDoorOpenModel[28].setRotationPoint(-2.5F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[28].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[29].addShapeBox(-1F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F); // Box 639
		primaryPaintBodyDoorOpenModel[29].setRotationPoint(-2.5F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[29].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[30].addShapeBox(-1F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 640
		primaryPaintBodyDoorOpenModel[30].setRotationPoint(-2.5F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[30].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[31].addShapeBox(-18F, -17F, 1.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F); // Box 641
		primaryPaintBodyDoorOpenModel[31].setRotationPoint(-2.5F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[31].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[32].addShapeBox(-18.5F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 1F, -4F, 0F, 1F, -4F, 0F, -1F, 4F, 0F, -1F); // Box 642
		primaryPaintBodyDoorOpenModel[32].setRotationPoint(-2.5F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[32].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[33].addShapeBox(-22.5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, 0.75F, -3F, -0.5F, 0.75F, -3F, -0.5F, -0.75F, 3F, -0.5F, -0.75F); // Box 643
		primaryPaintBodyDoorOpenModel[33].setRotationPoint(-2.5F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[33].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[34].addShapeBox(-21F, 0F, -0.9F, 3, 1, 1, 0F,0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.4F); // Box 644
		primaryPaintBodyDoorOpenModel[34].setRotationPoint(-2.5F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[34].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[35].addShapeBox(-7.5F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 645
		primaryPaintBodyDoorOpenModel[35].setRotationPoint(-2.5F, -10F, -20.5F);
		primaryPaintBodyDoorOpenModel[35].rotateAngleY = 1.04719755F;

		primaryPaintBodyDoorOpenModel[36].addShapeBox(-22F, 0F, -13F, 22, 2, 26, 0F,0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 646
		primaryPaintBodyDoorOpenModel[36].setRotationPoint(-32F, -12F, 0F);
		primaryPaintBodyDoorOpenModel[36].rotateAngleZ = -1.04719755F;

		primaryPaintBodyDoorOpenModel[37].addShapeBox(-26F, 0F, -13F, 4, 2, 26, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 647
		primaryPaintBodyDoorOpenModel[37].setRotationPoint(-32F, -12F, 0F);
		primaryPaintBodyDoorOpenModel[37].rotateAngleZ = -1.04719755F;

		primaryPaintBodyDoorOpenModel[38].addShapeBox(-26F, 2F, -13F, 2, 8, 26, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0.8F, 0F, 0F); // Box 648
		primaryPaintBodyDoorOpenModel[38].setRotationPoint(-32F, -12F, 0F);
		primaryPaintBodyDoorOpenModel[38].rotateAngleZ = -1.04719755F;

		primaryPaintBodyDoorOpenModel[39].addShapeBox(-26.5F, 4F, -7F, 1, 1, 12, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 652
		primaryPaintBodyDoorOpenModel[39].setRotationPoint(-32F, -12F, 0F);
		primaryPaintBodyDoorOpenModel[39].rotateAngleZ = -1.04719755F;

		primaryPaintBodyDoorOpenModel[40].addShapeBox(-26.5F, 5F, -6F, 1, 3, 10, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 653
		primaryPaintBodyDoorOpenModel[40].setRotationPoint(-32F, -12F, 0F);
		primaryPaintBodyDoorOpenModel[40].rotateAngleZ = -1.04719755F;
	}

	private void initprimaryPaintBodyDoorCloseModel_1(){
		primaryPaintBodyDoorCloseModel = new ModelRendererTurbo[41];
		primaryPaintBodyDoorCloseModel[0] = new ModelRendererTurbo(this, 105, 209, textureX, textureY); // Box 526
		primaryPaintBodyDoorCloseModel[1] = new ModelRendererTurbo(this, 209, 209, textureX, textureY); // Box 528
		primaryPaintBodyDoorCloseModel[2] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 529
		primaryPaintBodyDoorCloseModel[3] = new ModelRendererTurbo(this, 417, 241, textureX, textureY); // Box 569
		primaryPaintBodyDoorCloseModel[4] = new ModelRendererTurbo(this, 1, 249, textureX, textureY); // Box 570
		primaryPaintBodyDoorCloseModel[5] = new ModelRendererTurbo(this, 81, 249, textureX, textureY); // Box 571
		primaryPaintBodyDoorCloseModel[6] = new ModelRendererTurbo(this, 193, 249, textureX, textureY); // Box 572
		primaryPaintBodyDoorCloseModel[7] = new ModelRendererTurbo(this, 433, 257, textureX, textureY); // Box 573
		primaryPaintBodyDoorCloseModel[8] = new ModelRendererTurbo(this, 401, 273, textureX, textureY); // Box 577
		primaryPaintBodyDoorCloseModel[9] = new ModelRendererTurbo(this, 1, 281, textureX, textureY); // Box 578
		primaryPaintBodyDoorCloseModel[10] = new ModelRendererTurbo(this, 65, 281, textureX, textureY); // Box 579
		primaryPaintBodyDoorCloseModel[11] = new ModelRendererTurbo(this, 473, 121, textureX, textureY); // Box 580
		primaryPaintBodyDoorCloseModel[12] = new ModelRendererTurbo(this, 481, 121, textureX, textureY); // Box 581
		primaryPaintBodyDoorCloseModel[13] = new ModelRendererTurbo(this, 369, 129, textureX, textureY); // Box 583
		primaryPaintBodyDoorCloseModel[14] = new ModelRendererTurbo(this, 377, 129, textureX, textureY); // Box 584
		primaryPaintBodyDoorCloseModel[15] = new ModelRendererTurbo(this, 33, 137, textureX, textureY); // Box 585
		primaryPaintBodyDoorCloseModel[16] = new ModelRendererTurbo(this, 129, 137, textureX, textureY); // Box 586
		primaryPaintBodyDoorCloseModel[17] = new ModelRendererTurbo(this, 289, 137, textureX, textureY); // Box 587
		primaryPaintBodyDoorCloseModel[18] = new ModelRendererTurbo(this, 297, 137, textureX, textureY); // Box 588
		primaryPaintBodyDoorCloseModel[19] = new ModelRendererTurbo(this, 313, 137, textureX, textureY); // Box 589
		primaryPaintBodyDoorCloseModel[20] = new ModelRendererTurbo(this, 321, 137, textureX, textureY); // Box 590
		primaryPaintBodyDoorCloseModel[21] = new ModelRendererTurbo(this, 337, 137, textureX, textureY); // Box 591
		primaryPaintBodyDoorCloseModel[22] = new ModelRendererTurbo(this, 457, 137, textureX, textureY); // Box 592
		primaryPaintBodyDoorCloseModel[23] = new ModelRendererTurbo(this, 465, 137, textureX, textureY); // Box 593
		primaryPaintBodyDoorCloseModel[24] = new ModelRendererTurbo(this, 153, 145, textureX, textureY); // Box 594
		primaryPaintBodyDoorCloseModel[25] = new ModelRendererTurbo(this, 161, 145, textureX, textureY); // Box 595
		primaryPaintBodyDoorCloseModel[26] = new ModelRendererTurbo(this, 209, 145, textureX, textureY); // Box 596
		primaryPaintBodyDoorCloseModel[27] = new ModelRendererTurbo(this, 337, 177, textureX, textureY); // Box 597
		primaryPaintBodyDoorCloseModel[28] = new ModelRendererTurbo(this, 89, 185, textureX, textureY); // Box 599
		primaryPaintBodyDoorCloseModel[29] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 600
		primaryPaintBodyDoorCloseModel[30] = new ModelRendererTurbo(this, 89, 209, textureX, textureY); // Box 601
		primaryPaintBodyDoorCloseModel[31] = new ModelRendererTurbo(this, 265, 49, textureX, textureY); // Box 602
		primaryPaintBodyDoorCloseModel[32] = new ModelRendererTurbo(this, 281, 49, textureX, textureY); // Box 603
		primaryPaintBodyDoorCloseModel[33] = new ModelRendererTurbo(this, 425, 57, textureX, textureY); // Box 604
		primaryPaintBodyDoorCloseModel[34] = new ModelRendererTurbo(this, 441, 57, textureX, textureY); // Box 605
		primaryPaintBodyDoorCloseModel[35] = new ModelRendererTurbo(this, 457, 57, textureX, textureY); // Box 606
		primaryPaintBodyDoorCloseModel[36] = new ModelRendererTurbo(this, 161, 89, textureX, textureY); // Box 607
		primaryPaintBodyDoorCloseModel[37] = new ModelRendererTurbo(this, 177, 89, textureX, textureY); // Box 608
		primaryPaintBodyDoorCloseModel[38] = new ModelRendererTurbo(this, 193, 89, textureX, textureY); // Box 609
		primaryPaintBodyDoorCloseModel[39] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 649
		primaryPaintBodyDoorCloseModel[40] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 650

		primaryPaintBodyDoorCloseModel[0].addShapeBox(-22F, 0F, -13F, 22, 2, 26, 0F,0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 526
		primaryPaintBodyDoorCloseModel[0].setRotationPoint(-32F, -12F, 0F);

		primaryPaintBodyDoorCloseModel[1].addShapeBox(-26F, 2F, -13F, 2, 8, 26, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0.8F, 0F, 0F); // Box 528
		primaryPaintBodyDoorCloseModel[1].setRotationPoint(-32F, -12F, 0F);

		primaryPaintBodyDoorCloseModel[2].addShapeBox(-26F, 0F, -13F, 4, 2, 26, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 529
		primaryPaintBodyDoorCloseModel[2].setRotationPoint(-32F, -12F, 0F);

		primaryPaintBodyDoorCloseModel[3].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 569
		primaryPaintBodyDoorCloseModel[3].setRotationPoint(25F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[4].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 570
		primaryPaintBodyDoorCloseModel[4].setRotationPoint(-2.5F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[5].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 571
		primaryPaintBodyDoorCloseModel[5].setRotationPoint(25F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[6].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 572
		primaryPaintBodyDoorCloseModel[6].setRotationPoint(-2.5F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[7].addShapeBox(-27F, -2F, -0.5F, 27, 2, 1, 0F,-0.5F, 0.5F, 0.25F, -1F, 0.5F, 0.25F, -1F, 0.5F, -0.25F, -0.5F, 0.5F, -0.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 573
		primaryPaintBodyDoorCloseModel[7].setRotationPoint(25F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[8].addShapeBox(-26.5F, -2F, -0.5F, 27, 2, 1, 0F,-1F, 0.5F, 0.25F, -0.5F, 0.5F, 0.25F, -0.5F, 0.5F, -0.25F, -1F, 0.5F, -0.25F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 577
		primaryPaintBodyDoorCloseModel[8].setRotationPoint(-2.5F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[9].addShapeBox(-26.5F, -2F, -0.5F, 27, 2, 1, 0F,-1F, 0.5F, -0.25F, -0.5F, 0.5F, -0.25F, -0.5F, 0.5F, 0.25F, -1F, 0.5F, 0.25F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 578
		primaryPaintBodyDoorCloseModel[9].setRotationPoint(-2.5F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[10].addShapeBox(-27F, -2F, -0.5F, 27, 2, 1, 0F,-0.5F, 0.5F, -0.25F, -1F, 0.5F, -0.25F, -1F, 0.5F, 0.25F, -0.5F, 0.5F, 0.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 579
		primaryPaintBodyDoorCloseModel[10].setRotationPoint(25F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[11].addShapeBox(-5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -0.5F, -0.75F, 3F, -0.5F, -0.75F, 3F, -0.5F, 0.75F, -3F, -0.5F, 0.75F); // Box 580
		primaryPaintBodyDoorCloseModel[11].setRotationPoint(25F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[12].addShapeBox(-5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -0.5F, 0.75F, 3F, -0.5F, 0.75F, 3F, -0.5F, -0.75F, -3F, -0.5F, -0.75F); // Box 581
		primaryPaintBodyDoorCloseModel[12].setRotationPoint(25F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[13].addShapeBox(-22.5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, 0.75F, -3F, -0.5F, 0.75F, -3F, -0.5F, -0.75F, 3F, -0.5F, -0.75F); // Box 583
		primaryPaintBodyDoorCloseModel[13].setRotationPoint(-2.5F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[14].addShapeBox(-22.5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, -0.75F, -3F, -0.5F, -0.75F, -3F, -0.5F, 0.75F, 3F, -0.5F, 0.75F); // Box 584
		primaryPaintBodyDoorCloseModel[14].setRotationPoint(-2.5F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[15].addShapeBox(-26.5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F); // Box 585
		primaryPaintBodyDoorCloseModel[15].setRotationPoint(25F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[16].addShapeBox(-1F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F); // Box 586
		primaryPaintBodyDoorCloseModel[16].setRotationPoint(-2.5F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[17].addShapeBox(-1F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F); // Box 587
		primaryPaintBodyDoorCloseModel[17].setRotationPoint(-2.5F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[18].addShapeBox(-26.5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F); // Box 588
		primaryPaintBodyDoorCloseModel[18].setRotationPoint(25F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[19].addShapeBox(-26.5F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 589
		primaryPaintBodyDoorCloseModel[19].setRotationPoint(25F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[20].addShapeBox(-26.5F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 590
		primaryPaintBodyDoorCloseModel[20].setRotationPoint(25F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[21].addShapeBox(-1F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 591
		primaryPaintBodyDoorCloseModel[21].setRotationPoint(-2.5F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[22].addShapeBox(-1F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 592
		primaryPaintBodyDoorCloseModel[22].setRotationPoint(-2.5F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[23].addShapeBox(-9F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, -1F, 4F, 0F, -1F, 4F, 0F, 1F, -4F, 0F, 1F); // Box 593
		primaryPaintBodyDoorCloseModel[23].setRotationPoint(25F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[24].addShapeBox(-9F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 1F, 4F, 0F, 1F, 4F, 0F, -1F, -4F, 0F, -1F); // Box 594
		primaryPaintBodyDoorCloseModel[24].setRotationPoint(25F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[25].addShapeBox(-18.5F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 1F, -4F, 0F, 1F, -4F, 0F, -1F, 4F, 0F, -1F); // Box 595
		primaryPaintBodyDoorCloseModel[25].setRotationPoint(-2.5F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[26].addShapeBox(-18.5F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, -1F, -4F, 0F, -1F, -4F, 0F, 1F, 4F, 0F, 1F); // Box 596
		primaryPaintBodyDoorCloseModel[26].setRotationPoint(-2.5F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[27].addShapeBox(-25.5F, -17F, -2.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F); // Box 597
		primaryPaintBodyDoorCloseModel[27].setRotationPoint(25F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[28].addShapeBox(-25.5F, -17F, 1.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F); // Box 599
		primaryPaintBodyDoorCloseModel[28].setRotationPoint(25F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[29].addShapeBox(-18F, -17F, 1.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F); // Box 600
		primaryPaintBodyDoorCloseModel[29].setRotationPoint(-2.5F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[30].addShapeBox(-18F, -17F, -2.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F); // Box 601
		primaryPaintBodyDoorCloseModel[30].setRotationPoint(-2.5F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[31].addShapeBox(-24F, 0F, -0.1F, 3, 1, 1, 0F,0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0.2F, 0F, -0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0.4F, 0F, 0F, 0.4F, 0F, 0F); // Box 602
		primaryPaintBodyDoorCloseModel[31].setRotationPoint(25F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[32].addShapeBox(-24F, 0F, -0.9F, 3, 1, 1, 0F,0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.4F); // Box 603
		primaryPaintBodyDoorCloseModel[32].setRotationPoint(25F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[33].addShapeBox(-21F, 0F, -0.9F, 3, 1, 1, 0F,0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.4F); // Box 604
		primaryPaintBodyDoorCloseModel[33].setRotationPoint(-2.5F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[34].addShapeBox(-21F, 0F, -0.1F, 3, 1, 1, 0F,0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0.2F, 0F, -0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0.4F, 0F, 0F, 0.4F, 0F, 0F); // Box 605
		primaryPaintBodyDoorCloseModel[34].setRotationPoint(-2.5F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[35].addShapeBox(-12.5F, 0F, -1F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 606
		primaryPaintBodyDoorCloseModel[35].setRotationPoint(25F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[36].addShapeBox(-12.5F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 607
		primaryPaintBodyDoorCloseModel[36].setRotationPoint(25F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[37].addShapeBox(-7.5F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 608
		primaryPaintBodyDoorCloseModel[37].setRotationPoint(-2.5F, -10F, -20.5F);

		primaryPaintBodyDoorCloseModel[38].addShapeBox(-7.5F, 0F, -1F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 609
		primaryPaintBodyDoorCloseModel[38].setRotationPoint(-2.5F, -10F, 20.5F);

		primaryPaintBodyDoorCloseModel[39].addShapeBox(-26.5F, 4F, -7F, 1, 1, 12, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 649
		primaryPaintBodyDoorCloseModel[39].setRotationPoint(-32F, -12F, 0F);

		primaryPaintBodyDoorCloseModel[40].addShapeBox(-26.5F, 5F, -6F, 1, 3, 10, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 650
		primaryPaintBodyDoorCloseModel[40].setRotationPoint(-32F, -12F, 0F);
	}

	private void initleftFrontWheelModel_1(){
		leftFrontWheelModel = new ModelRendererTurbo[78];
		leftFrontWheelModel[0] = new ModelRendererTurbo(this, 17, 1, textureX, textureY); // Box 6
		leftFrontWheelModel[1] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 11
		leftFrontWheelModel[2] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 12
		leftFrontWheelModel[3] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 13
		leftFrontWheelModel[4] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 14
		leftFrontWheelModel[5] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 16
		leftFrontWheelModel[6] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 18
		leftFrontWheelModel[7] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 19
		leftFrontWheelModel[8] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 20
		leftFrontWheelModel[9] = new ModelRendererTurbo(this, 25, 9, textureX, textureY); // Box 21
		leftFrontWheelModel[10] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 22
		leftFrontWheelModel[11] = new ModelRendererTurbo(this, 217, 9, textureX, textureY); // Box 23
		leftFrontWheelModel[12] = new ModelRendererTurbo(this, 265, 9, textureX, textureY); // Box 24
		leftFrontWheelModel[13] = new ModelRendererTurbo(this, 305, 9, textureX, textureY); // Box 26
		leftFrontWheelModel[14] = new ModelRendererTurbo(this, 441, 9, textureX, textureY); // Box 27
		leftFrontWheelModel[15] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 28
		leftFrontWheelModel[16] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 29
		leftFrontWheelModel[17] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 30
		leftFrontWheelModel[18] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 31
		leftFrontWheelModel[19] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 32
		leftFrontWheelModel[20] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 33
		leftFrontWheelModel[21] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 34
		leftFrontWheelModel[22] = new ModelRendererTurbo(this, 481, 1, textureX, textureY); // Box 36
		leftFrontWheelModel[23] = new ModelRendererTurbo(this, 17, 9, textureX, textureY); // Box 37
		leftFrontWheelModel[24] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 38
		leftFrontWheelModel[25] = new ModelRendererTurbo(this, 281, 9, textureX, textureY); // Box 39
		leftFrontWheelModel[26] = new ModelRendererTurbo(this, 361, 9, textureX, textureY); // Box 40
		leftFrontWheelModel[27] = new ModelRendererTurbo(this, 401, 9, textureX, textureY); // Box 41
		leftFrontWheelModel[28] = new ModelRendererTurbo(this, 489, 9, textureX, textureY); // Box 42
		leftFrontWheelModel[29] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 43
		leftFrontWheelModel[30] = new ModelRendererTurbo(this, 17, 17, textureX, textureY); // Box 44
		leftFrontWheelModel[31] = new ModelRendererTurbo(this, 33, 17, textureX, textureY); // Box 45
		leftFrontWheelModel[32] = new ModelRendererTurbo(this, 265, 17, textureX, textureY); // Box 46
		leftFrontWheelModel[33] = new ModelRendererTurbo(this, 281, 17, textureX, textureY); // Box 47
		leftFrontWheelModel[34] = new ModelRendererTurbo(this, 385, 17, textureX, textureY); // Box 48
		leftFrontWheelModel[35] = new ModelRendererTurbo(this, 401, 17, textureX, textureY); // Box 49
		leftFrontWheelModel[36] = new ModelRendererTurbo(this, 505, 9, textureX, textureY); // Box 50
		leftFrontWheelModel[37] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 51
		leftFrontWheelModel[38] = new ModelRendererTurbo(this, 497, 17, textureX, textureY); // Box 52
		leftFrontWheelModel[39] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Box 53
		leftFrontWheelModel[40] = new ModelRendererTurbo(this, 17, 25, textureX, textureY); // Box 54
		leftFrontWheelModel[41] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Box 55
		leftFrontWheelModel[42] = new ModelRendererTurbo(this, 177, 25, textureX, textureY); // Box 56
		leftFrontWheelModel[43] = new ModelRendererTurbo(this, 193, 25, textureX, textureY); // Box 57
		leftFrontWheelModel[44] = new ModelRendererTurbo(this, 505, 17, textureX, textureY); // Box 58
		leftFrontWheelModel[45] = new ModelRendererTurbo(this, 305, 25, textureX, textureY); // Box 59
		leftFrontWheelModel[46] = new ModelRendererTurbo(this, 313, 25, textureX, textureY); // Box 60
		leftFrontWheelModel[47] = new ModelRendererTurbo(this, 209, 25, textureX, textureY); // Box 61
		leftFrontWheelModel[48] = new ModelRendererTurbo(this, 225, 25, textureX, textureY); // Box 62
		leftFrontWheelModel[49] = new ModelRendererTurbo(this, 321, 25, textureX, textureY); // Box 63
		leftFrontWheelModel[50] = new ModelRendererTurbo(this, 337, 25, textureX, textureY); // Box 65
		leftFrontWheelModel[51] = new ModelRendererTurbo(this, 353, 25, textureX, textureY); // Box 66
		leftFrontWheelModel[52] = new ModelRendererTurbo(this, 465, 25, textureX, textureY); // Box 67
		leftFrontWheelModel[53] = new ModelRendererTurbo(this, 481, 25, textureX, textureY); // Box 68
		leftFrontWheelModel[54] = new ModelRendererTurbo(this, 489, 25, textureX, textureY); // Box 69
		leftFrontWheelModel[55] = new ModelRendererTurbo(this, 265, 25, textureX, textureY); // Box 70
		leftFrontWheelModel[56] = new ModelRendererTurbo(this, 385, 25, textureX, textureY); // Box 71
		leftFrontWheelModel[57] = new ModelRendererTurbo(this, 441, 25, textureX, textureY); // Box 74
		leftFrontWheelModel[58] = new ModelRendererTurbo(this, 497, 25, textureX, textureY); // Box 75
		leftFrontWheelModel[59] = new ModelRendererTurbo(this, 505, 25, textureX, textureY); // Box 77
		leftFrontWheelModel[60] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 78
		leftFrontWheelModel[61] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // Box 79
		leftFrontWheelModel[62] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // Box 81
		leftFrontWheelModel[63] = new ModelRendererTurbo(this, 177, 33, textureX, textureY); // Box 82
		leftFrontWheelModel[64] = new ModelRendererTurbo(this, 201, 33, textureX, textureY); // Box 83
		leftFrontWheelModel[65] = new ModelRendererTurbo(this, 225, 33, textureX, textureY); // Box 84
		leftFrontWheelModel[66] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 85
		leftFrontWheelModel[67] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 86
		leftFrontWheelModel[68] = new ModelRendererTurbo(this, 249, 33, textureX, textureY); // Box 87
		leftFrontWheelModel[69] = new ModelRendererTurbo(this, 433, 33, textureX, textureY); // Box 88
		leftFrontWheelModel[70] = new ModelRendererTurbo(this, 441, 33, textureX, textureY); // Box 89
		leftFrontWheelModel[71] = new ModelRendererTurbo(this, 449, 33, textureX, textureY); // Box 93
		leftFrontWheelModel[72] = new ModelRendererTurbo(this, 457, 33, textureX, textureY); // Box 94
		leftFrontWheelModel[73] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 95
		leftFrontWheelModel[74] = new ModelRendererTurbo(this, 217, 41, textureX, textureY); // Box 99
		leftFrontWheelModel[75] = new ModelRendererTurbo(this, 233, 41, textureX, textureY); // Box 100
		leftFrontWheelModel[76] = new ModelRendererTurbo(this, 249, 41, textureX, textureY); // Box 101
		leftFrontWheelModel[77] = new ModelRendererTurbo(this, 265, 41, textureX, textureY); // Box 102

		leftFrontWheelModel[0].addBox(-1.5F, -1.5F, -3F, 3, 3, 3, 0F); // Box 6
		leftFrontWheelModel[0].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[1].addBox(-1.5F, 7.5F, -4.5F, 3, 2, 5, 0F); // Box 11
		leftFrontWheelModel[1].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[2].addBox(-1.5F, -9.5F, -4.5F, 3, 2, 5, 0F); // Box 12
		leftFrontWheelModel[2].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[3].addBox(7.5F, -1.5F, -4.5F, 2, 3, 5, 0F); // Box 13
		leftFrontWheelModel[3].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[4].addBox(-9.5F, -1.5F, -4.5F, 2, 3, 5, 0F); // Box 14
		leftFrontWheelModel[4].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[5].addShapeBox(3.7F, 4.7F, -4.5F, 3, 2, 5, 0F,-0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 16
		leftFrontWheelModel[5].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[6].addShapeBox(5.2F, -7.2F, -4.5F, 3, 2, 5, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 18
		leftFrontWheelModel[6].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[7].addShapeBox(-6.7F, 4.7F, -4.5F, 3, 2, 5, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 19
		leftFrontWheelModel[7].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[8].addShapeBox(-6.7F, -6.7F, -4.5F, 3, 2, 5, 0F,1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 20
		leftFrontWheelModel[8].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[9].addShapeBox(1.5F, 7.5F, -4.5F, 3, 2, 5, 0F,0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 21
		leftFrontWheelModel[9].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[10].addShapeBox(-4.5F, 7.5F, -4.5F, 3, 2, 5, 0F,-0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 22
		leftFrontWheelModel[10].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[11].addShapeBox(-4.5F, -9.5F, -4.5F, 3, 2, 5, 0F,1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 23
		leftFrontWheelModel[11].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[12].addShapeBox(1.5F, -9.5F, -4.5F, 3, 2, 5, 0F,0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 24
		leftFrontWheelModel[12].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[13].addShapeBox(7.5F, 1.5F, -4.5F, 2, 3, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 26
		leftFrontWheelModel[13].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[14].addShapeBox(7.5F, -4.5F, -4.5F, 2, 3, 5, 0F,1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 27
		leftFrontWheelModel[14].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[15].addShapeBox(-9.5F, -4.5F, -4.5F, 2, 3, 5, 0F,-1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 28
		leftFrontWheelModel[15].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[16].addShapeBox(-9.5F, 1.5F, -4.5F, 2, 3, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 29
		leftFrontWheelModel[16].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[17].addShapeBox(-1.5F, 7.5F, 0.5F, 3, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 30
		leftFrontWheelModel[17].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[18].addShapeBox(-1.5F, -9.5F, 0.5F, 3, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 31
		leftFrontWheelModel[18].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[19].addShapeBox(7.5F, -1.5F, 0.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 32
		leftFrontWheelModel[19].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[20].addShapeBox(-9.5F, -1.5F, 0.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 33
		leftFrontWheelModel[20].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[21].addShapeBox(7.5F, 1.5F, 0.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F); // Box 34
		leftFrontWheelModel[21].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[22].addShapeBox(3.7F, 4.7F, 0.5F, 3, 2, 1, 0F,-0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F); // Box 36
		leftFrontWheelModel[22].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[23].addShapeBox(1.5F, 7.5F, 0.5F, 3, 2, 1, 0F,0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F); // Box 37
		leftFrontWheelModel[23].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[24].addShapeBox(7.5F, -4.5F, 0.5F, 2, 3, 1, 0F,1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 38
		leftFrontWheelModel[24].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[25].addShapeBox(-9.5F, -4.5F, 0.5F, 2, 3, 1, 0F,-1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 39
		leftFrontWheelModel[25].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[26].addShapeBox(-9.5F, 1.5F, 0.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F); // Box 40
		leftFrontWheelModel[26].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[27].addShapeBox(3.7F, -6.7F, 0.5F, 3, 2, 1, 0F,-2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F); // Box 41
		leftFrontWheelModel[27].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[28].addShapeBox(-6.7F, -6.7F, 0.5F, 3, 2, 1, 0F,1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F); // Box 42
		leftFrontWheelModel[28].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[29].addShapeBox(-6.7F, 4.7F, 0.5F, 3, 2, 1, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F); // Box 43
		leftFrontWheelModel[29].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[30].addShapeBox(-4.5F, 7.5F, 0.5F, 3, 2, 1, 0F,-0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F); // Box 44
		leftFrontWheelModel[30].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[31].addShapeBox(-4.5F, -9.5F, 0.5F, 3, 2, 1, 0F,1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F); // Box 45
		leftFrontWheelModel[31].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[32].addShapeBox(1.5F, -9.5F, 0.5F, 3, 2, 1, 0F,0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 46
		leftFrontWheelModel[32].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[33].addShapeBox(-1.5F, -9.5F, -5.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 47
		leftFrontWheelModel[33].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[34].addShapeBox(1.5F, -9.5F, -5.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 48
		leftFrontWheelModel[34].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[35].addShapeBox(3.7F, -6.7F, -5.5F, 3, 2, 1, 0F,-1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F); // Box 49
		leftFrontWheelModel[35].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[36].addShapeBox(7.5F, -4.5F, -5.5F, 2, 3, 1, 0F,1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 50
		leftFrontWheelModel[36].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[37].addShapeBox(7.5F, -1.5F, -5.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 51
		leftFrontWheelModel[37].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[38].addShapeBox(7.5F, 1.5F, -5.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 52
		leftFrontWheelModel[38].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[39].addShapeBox(3.7F, 4.7F, -5.5F, 3, 2, 1, 0F,-0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 53
		leftFrontWheelModel[39].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[40].addShapeBox(1.5F, 7.5F, -5.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 54
		leftFrontWheelModel[40].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[41].addShapeBox(-1.5F, 7.5F, -5.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 55
		leftFrontWheelModel[41].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[42].addShapeBox(-4.5F, 7.5F, -5.5F, 3, 2, 1, 0F,-0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 56
		leftFrontWheelModel[42].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[43].addShapeBox(-6.7F, 4.7F, -5.5F, 3, 2, 1, 0F,-0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 57
		leftFrontWheelModel[43].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[44].addShapeBox(-9.5F, 1.5F, -5.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 58
		leftFrontWheelModel[44].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[45].addShapeBox(-9.5F, -1.5F, -5.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 59
		leftFrontWheelModel[45].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[46].addShapeBox(-9.5F, -4.5F, -5.5F, 2, 3, 1, 0F,-2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 60
		leftFrontWheelModel[46].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[47].addShapeBox(-6.7F, -6.7F, -5.5F, 3, 2, 1, 0F,0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 61
		leftFrontWheelModel[47].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[48].addShapeBox(-4.5F, -9.5F, -5.5F, 3, 2, 1, 0F,1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 62
		leftFrontWheelModel[48].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[49].addShapeBox(1.5F, -0.5F, -3F, 1, 1, 3, 0F,0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F); // Box 63
		leftFrontWheelModel[49].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[50].addShapeBox(-2.5F, -0.5F, -3F, 1, 1, 3, 0F,-0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F); // Box 65
		leftFrontWheelModel[50].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[51].addShapeBox(-0.5F, 1.5F, -3F, 1, 1, 3, 0F,0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F); // Box 66
		leftFrontWheelModel[51].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[52].addShapeBox(-0.5F, -2.5F, -3F, 1, 1, 3, 0F,-0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 67
		leftFrontWheelModel[52].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[53].addBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F); // Box 68
		leftFrontWheelModel[53].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[54].addBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F); // Box 69
		leftFrontWheelModel[54].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[55].addBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F); // Box 70
		leftFrontWheelModel[55].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[56].addBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F); // Box 71
		leftFrontWheelModel[56].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[57].addShapeBox(-1F, -1F, 0F, 2, 2, 1, 0F,0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 74
		leftFrontWheelModel[57].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[58].addShapeBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F,-0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 75
		leftFrontWheelModel[58].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[59].addShapeBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F,-3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 77
		leftFrontWheelModel[59].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[60].addShapeBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F,3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 78
		leftFrontWheelModel[60].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[61].addShapeBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F,0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 79
		leftFrontWheelModel[61].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[62].addShapeBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F,-0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 81
		leftFrontWheelModel[62].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[63].addShapeBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F,-1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 82
		leftFrontWheelModel[63].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[64].addShapeBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F,-0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 83
		leftFrontWheelModel[64].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[65].addShapeBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F,0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 84
		leftFrontWheelModel[65].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[66].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 85
		leftFrontWheelModel[66].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[67].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 86
		leftFrontWheelModel[67].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[68].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 87
		leftFrontWheelModel[68].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[69].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 88
		leftFrontWheelModel[69].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[70].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,-0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F); // Box 89
		leftFrontWheelModel[70].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[71].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F); // Box 93
		leftFrontWheelModel[71].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[72].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F); // Box 94
		leftFrontWheelModel[72].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[73].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,-3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F); // Box 95
		leftFrontWheelModel[73].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[74].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F); // Box 99
		leftFrontWheelModel[74].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[75].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F); // Box 100
		leftFrontWheelModel[75].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[76].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F); // Box 101
		leftFrontWheelModel[76].setRotationPoint(43.5F, 0.5F, 20F);

		leftFrontWheelModel[77].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F); // Box 102
		leftFrontWheelModel[77].setRotationPoint(43.5F, 0.5F, 20F);
	}

	private void initrightFrontWheelModel_1(){
		rightFrontWheelModel = new ModelRendererTurbo[78];
		rightFrontWheelModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 5
		rightFrontWheelModel[1] = new ModelRendererTurbo(this, 281, 41, textureX, textureY); // Box 103
		rightFrontWheelModel[2] = new ModelRendererTurbo(this, 305, 41, textureX, textureY); // Box 104
		rightFrontWheelModel[3] = new ModelRendererTurbo(this, 473, 33, textureX, textureY); // Box 105
		rightFrontWheelModel[4] = new ModelRendererTurbo(this, 329, 41, textureX, textureY); // Box 106
		rightFrontWheelModel[5] = new ModelRendererTurbo(this, 345, 41, textureX, textureY); // Box 107
		rightFrontWheelModel[6] = new ModelRendererTurbo(this, 361, 41, textureX, textureY); // Box 108
		rightFrontWheelModel[7] = new ModelRendererTurbo(this, 385, 41, textureX, textureY); // Box 109
		rightFrontWheelModel[8] = new ModelRendererTurbo(this, 409, 41, textureX, textureY); // Box 110
		rightFrontWheelModel[9] = new ModelRendererTurbo(this, 425, 41, textureX, textureY); // Box 111
		rightFrontWheelModel[10] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 112
		rightFrontWheelModel[11] = new ModelRendererTurbo(this, 473, 41, textureX, textureY); // Box 113
		rightFrontWheelModel[12] = new ModelRendererTurbo(this, 489, 41, textureX, textureY); // Box 114
		rightFrontWheelModel[13] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 115
		rightFrontWheelModel[14] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 116
		rightFrontWheelModel[15] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // Box 117
		rightFrontWheelModel[16] = new ModelRendererTurbo(this, 65, 49, textureX, textureY); // Box 118
		rightFrontWheelModel[17] = new ModelRendererTurbo(this, 89, 49, textureX, textureY); // Box 119
		rightFrontWheelModel[18] = new ModelRendererTurbo(this, 297, 41, textureX, textureY); // Box 120
		rightFrontWheelModel[19] = new ModelRendererTurbo(this, 321, 41, textureX, textureY); // Box 121
		rightFrontWheelModel[20] = new ModelRendererTurbo(this, 377, 41, textureX, textureY); // Box 122
		rightFrontWheelModel[21] = new ModelRendererTurbo(this, 401, 41, textureX, textureY); // Box 123
		rightFrontWheelModel[22] = new ModelRendererTurbo(this, 441, 41, textureX, textureY); // Box 124
		rightFrontWheelModel[23] = new ModelRendererTurbo(this, 465, 41, textureX, textureY); // Box 125
		rightFrontWheelModel[24] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // Box 126
		rightFrontWheelModel[25] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // Box 127
		rightFrontWheelModel[26] = new ModelRendererTurbo(this, 81, 49, textureX, textureY); // Box 128
		rightFrontWheelModel[27] = new ModelRendererTurbo(this, 105, 49, textureX, textureY); // Box 129
		rightFrontWheelModel[28] = new ModelRendererTurbo(this, 121, 49, textureX, textureY); // Box 130
		rightFrontWheelModel[29] = new ModelRendererTurbo(this, 137, 49, textureX, textureY); // Box 131
		rightFrontWheelModel[30] = new ModelRendererTurbo(this, 505, 41, textureX, textureY); // Box 132
		rightFrontWheelModel[31] = new ModelRendererTurbo(this, 153, 49, textureX, textureY); // Box 133
		rightFrontWheelModel[32] = new ModelRendererTurbo(this, 161, 49, textureX, textureY); // Box 134
		rightFrontWheelModel[33] = new ModelRendererTurbo(this, 169, 49, textureX, textureY); // Box 135
		rightFrontWheelModel[34] = new ModelRendererTurbo(this, 177, 49, textureX, textureY); // Box 136
		rightFrontWheelModel[35] = new ModelRendererTurbo(this, 185, 49, textureX, textureY); // Box 137
		rightFrontWheelModel[36] = new ModelRendererTurbo(this, 193, 49, textureX, textureY); // Box 138
		rightFrontWheelModel[37] = new ModelRendererTurbo(this, 217, 49, textureX, textureY); // Box 139
		rightFrontWheelModel[38] = new ModelRendererTurbo(this, 241, 49, textureX, textureY); // Box 140
		rightFrontWheelModel[39] = new ModelRendererTurbo(this, 257, 49, textureX, textureY); // Box 141
		rightFrontWheelModel[40] = new ModelRendererTurbo(this, 273, 49, textureX, textureY); // Box 142
		rightFrontWheelModel[41] = new ModelRendererTurbo(this, 289, 49, textureX, textureY); // Box 143
		rightFrontWheelModel[42] = new ModelRendererTurbo(this, 305, 49, textureX, textureY); // Box 144
		rightFrontWheelModel[43] = new ModelRendererTurbo(this, 313, 49, textureX, textureY); // Box 145
		rightFrontWheelModel[44] = new ModelRendererTurbo(this, 321, 49, textureX, textureY); // Box 146
		rightFrontWheelModel[45] = new ModelRendererTurbo(this, 361, 49, textureX, textureY); // Box 147
		rightFrontWheelModel[46] = new ModelRendererTurbo(this, 369, 49, textureX, textureY); // Box 148
		rightFrontWheelModel[47] = new ModelRendererTurbo(this, 393, 49, textureX, textureY); // Box 149
		rightFrontWheelModel[48] = new ModelRendererTurbo(this, 425, 49, textureX, textureY); // Box 150
		rightFrontWheelModel[49] = new ModelRendererTurbo(this, 449, 49, textureX, textureY); // Box 151
		rightFrontWheelModel[50] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Box 250
		rightFrontWheelModel[51] = new ModelRendererTurbo(this, 33, 57, textureX, textureY); // Box 251
		rightFrontWheelModel[52] = new ModelRendererTurbo(this, 49, 57, textureX, textureY); // Box 252
		rightFrontWheelModel[53] = new ModelRendererTurbo(this, 505, 49, textureX, textureY); // Box 253
		rightFrontWheelModel[54] = new ModelRendererTurbo(this, 65, 57, textureX, textureY); // Box 254
		rightFrontWheelModel[55] = new ModelRendererTurbo(this, 73, 57, textureX, textureY); // Box 255
		rightFrontWheelModel[56] = new ModelRendererTurbo(this, 81, 57, textureX, textureY); // Box 256
		rightFrontWheelModel[57] = new ModelRendererTurbo(this, 97, 57, textureX, textureY); // Box 257
		rightFrontWheelModel[58] = new ModelRendererTurbo(this, 113, 57, textureX, textureY); // Box 258
		rightFrontWheelModel[59] = new ModelRendererTurbo(this, 129, 57, textureX, textureY); // Box 259
		rightFrontWheelModel[60] = new ModelRendererTurbo(this, 145, 57, textureX, textureY); // Box 260
		rightFrontWheelModel[61] = new ModelRendererTurbo(this, 161, 57, textureX, textureY); // Box 261
		rightFrontWheelModel[62] = new ModelRendererTurbo(this, 169, 57, textureX, textureY); // Box 262
		rightFrontWheelModel[63] = new ModelRendererTurbo(this, 193, 57, textureX, textureY); // Box 263
		rightFrontWheelModel[64] = new ModelRendererTurbo(this, 201, 57, textureX, textureY); // Box 264
		rightFrontWheelModel[65] = new ModelRendererTurbo(this, 217, 57, textureX, textureY); // Box 265
		rightFrontWheelModel[66] = new ModelRendererTurbo(this, 233, 57, textureX, textureY); // Box 266
		rightFrontWheelModel[67] = new ModelRendererTurbo(this, 249, 57, textureX, textureY); // Box 267
		rightFrontWheelModel[68] = new ModelRendererTurbo(this, 265, 57, textureX, textureY); // Box 268
		rightFrontWheelModel[69] = new ModelRendererTurbo(this, 273, 57, textureX, textureY); // Box 269
		rightFrontWheelModel[70] = new ModelRendererTurbo(this, 281, 57, textureX, textureY); // Box 270
		rightFrontWheelModel[71] = new ModelRendererTurbo(this, 289, 57, textureX, textureY); // Box 271
		rightFrontWheelModel[72] = new ModelRendererTurbo(this, 297, 57, textureX, textureY); // Box 272
		rightFrontWheelModel[73] = new ModelRendererTurbo(this, 329, 57, textureX, textureY); // Box 273
		rightFrontWheelModel[74] = new ModelRendererTurbo(this, 337, 57, textureX, textureY); // Box 274
		rightFrontWheelModel[75] = new ModelRendererTurbo(this, 369, 57, textureX, textureY); // Box 275
		rightFrontWheelModel[76] = new ModelRendererTurbo(this, 385, 57, textureX, textureY); // Box 276
		rightFrontWheelModel[77] = new ModelRendererTurbo(this, 401, 57, textureX, textureY); // Box 277

		rightFrontWheelModel[0].addBox(-1.5F, -1.5F, 0F, 3, 3, 3, 0F); // Box 5
		rightFrontWheelModel[0].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[1].addBox(-1.5F, 7.5F, -0.5F, 3, 2, 5, 0F); // Box 103
		rightFrontWheelModel[1].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[2].addBox(-1.5F, -9.5F, -0.5F, 3, 2, 5, 0F); // Box 104
		rightFrontWheelModel[2].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[3].addShapeBox(-1F, -1F, -1F, 2, 2, 1, 0F,0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F); // Box 105
		rightFrontWheelModel[3].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[4].addBox(7.5F, -1.5F, -0.5F, 2, 3, 5, 0F); // Box 106
		rightFrontWheelModel[4].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[5].addBox(-9.5F, -1.5F, -0.5F, 2, 3, 5, 0F); // Box 107
		rightFrontWheelModel[5].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[6].addShapeBox(3.7F, 4.7F, -0.5F, 3, 2, 5, 0F,-0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 108
		rightFrontWheelModel[6].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[7].addShapeBox(-6.7F, 4.7F, -0.5F, 3, 2, 5, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 109
		rightFrontWheelModel[7].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[8].addShapeBox(7.5F, -4.5F, -0.5F, 2, 3, 5, 0F,1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 110
		rightFrontWheelModel[8].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[9].addShapeBox(5.2F, -7.2F, -0.5F, 3, 2, 5, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 111
		rightFrontWheelModel[9].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[10].addShapeBox(-6.7F, -6.7F, -0.5F, 3, 2, 5, 0F,1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 112
		rightFrontWheelModel[10].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[11].addShapeBox(7.5F, 1.5F, -0.5F, 2, 3, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 113
		rightFrontWheelModel[11].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[12].addShapeBox(-9.5F, 1.5F, -0.5F, 2, 3, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 114
		rightFrontWheelModel[12].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[13].addShapeBox(-9.5F, -4.5F, -0.5F, 2, 3, 5, 0F,-1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 115
		rightFrontWheelModel[13].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[14].addShapeBox(1.5F, 7.5F, -0.5F, 3, 2, 5, 0F,0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 116
		rightFrontWheelModel[14].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[15].addShapeBox(-4.5F, 7.5F, -0.5F, 3, 2, 5, 0F,-0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 117
		rightFrontWheelModel[15].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[16].addShapeBox(-4.5F, -9.5F, -0.5F, 3, 2, 5, 0F,1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 118
		rightFrontWheelModel[16].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[17].addShapeBox(1.5F, -9.5F, -0.5F, 3, 2, 5, 0F,0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 119
		rightFrontWheelModel[17].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[18].addShapeBox(-1.5F, 7.5F, -1.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 120
		rightFrontWheelModel[18].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[19].addShapeBox(-1.5F, -9.5F, -1.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 121
		rightFrontWheelModel[19].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[20].addShapeBox(7.5F, -1.5F, -1.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 122
		rightFrontWheelModel[20].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[21].addShapeBox(-9.5F, -1.5F, -1.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 123
		rightFrontWheelModel[21].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[22].addShapeBox(3.7F, -6.7F, -1.5F, 3, 2, 1, 0F,-1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F); // Box 124
		rightFrontWheelModel[22].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[23].addShapeBox(3.7F, 4.7F, -1.5F, 3, 2, 1, 0F,-0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 125
		rightFrontWheelModel[23].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[24].addShapeBox(-6.7F, 4.7F, -1.5F, 3, 2, 1, 0F,-0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 126
		rightFrontWheelModel[24].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[25].addShapeBox(-6.7F, -6.7F, -1.5F, 3, 2, 1, 0F,0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 127
		rightFrontWheelModel[25].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[26].addShapeBox(1.5F, 7.5F, -1.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 128
		rightFrontWheelModel[26].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[27].addShapeBox(-4.5F, 7.5F, -1.5F, 3, 2, 1, 0F,-0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 129
		rightFrontWheelModel[27].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[28].addShapeBox(-4.5F, -9.5F, -1.5F, 3, 2, 1, 0F,1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 130
		rightFrontWheelModel[28].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[29].addShapeBox(1.5F, -9.5F, -1.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 131
		rightFrontWheelModel[29].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[30].addShapeBox(7.5F, 1.5F, -1.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 132
		rightFrontWheelModel[30].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[31].addShapeBox(7.5F, -4.5F, -1.5F, 2, 3, 1, 0F,1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 133
		rightFrontWheelModel[31].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[32].addShapeBox(-9.5F, -4.5F, -1.5F, 2, 3, 1, 0F,-2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 134
		rightFrontWheelModel[32].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[33].addShapeBox(-9.5F, 1.5F, -1.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 135
		rightFrontWheelModel[33].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[34].addBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F); // Box 136
		rightFrontWheelModel[34].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[35].addBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F); // Box 137
		rightFrontWheelModel[35].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[36].addBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F); // Box 138
		rightFrontWheelModel[36].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[37].addBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F); // Box 139
		rightFrontWheelModel[37].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[38].addShapeBox(1.5F, -0.5F, 0F, 1, 1, 3, 0F,0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F); // Box 140
		rightFrontWheelModel[38].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[39].addShapeBox(-2.5F, -0.5F, 0F, 1, 1, 3, 0F,-0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F); // Box 141
		rightFrontWheelModel[39].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[40].addShapeBox(-0.5F, -2.5F, 0F, 1, 1, 3, 0F,-0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 142
		rightFrontWheelModel[40].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[41].addShapeBox(-0.5F, 1.5F, 0F, 1, 1, 3, 0F,0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F); // Box 143
		rightFrontWheelModel[41].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[42].addShapeBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F,3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 144
		rightFrontWheelModel[42].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[43].addShapeBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F,-3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 145
		rightFrontWheelModel[43].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[44].addShapeBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F,-0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 146
		rightFrontWheelModel[44].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[45].addShapeBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F,0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 147
		rightFrontWheelModel[45].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[46].addShapeBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F,0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 148
		rightFrontWheelModel[46].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[47].addShapeBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F,-0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 149
		rightFrontWheelModel[47].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[48].addShapeBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F,-0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 150
		rightFrontWheelModel[48].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[49].addShapeBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F,-1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 151
		rightFrontWheelModel[49].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[50].addShapeBox(-1.5F, -9.5F, 4.5F, 3, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 250
		rightFrontWheelModel[50].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[51].addShapeBox(1.5F, -9.5F, 4.5F, 3, 2, 1, 0F,0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 251
		rightFrontWheelModel[51].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[52].addShapeBox(3.7F, -6.7F, 4.5F, 3, 2, 1, 0F,-2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F); // Box 252
		rightFrontWheelModel[52].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[53].addShapeBox(7.5F, -4.5F, 4.5F, 2, 3, 1, 0F,1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 253
		rightFrontWheelModel[53].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[54].addShapeBox(7.5F, -1.5F, 4.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 254
		rightFrontWheelModel[54].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[55].addShapeBox(7.5F, 1.5F, 4.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F); // Box 255
		rightFrontWheelModel[55].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[56].addShapeBox(3.7F, 4.7F, 4.5F, 3, 2, 1, 0F,-0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F); // Box 256
		rightFrontWheelModel[56].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[57].addShapeBox(1.5F, 7.5F, 4.5F, 3, 2, 1, 0F,0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F); // Box 257
		rightFrontWheelModel[57].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[58].addShapeBox(-1.5F, 7.5F, 4.5F, 3, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 258
		rightFrontWheelModel[58].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[59].addShapeBox(-4.5F, 7.5F, 4.5F, 3, 2, 1, 0F,-0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F); // Box 259
		rightFrontWheelModel[59].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[60].addShapeBox(-6.7F, 4.7F, 4.5F, 3, 2, 1, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F); // Box 260
		rightFrontWheelModel[60].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[61].addShapeBox(-9.5F, 1.5F, 4.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F); // Box 261
		rightFrontWheelModel[61].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[62].addShapeBox(-9.5F, -1.5F, 4.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 262
		rightFrontWheelModel[62].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[63].addShapeBox(-9.5F, -4.5F, 4.5F, 2, 3, 1, 0F,-1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 263
		rightFrontWheelModel[63].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[64].addShapeBox(-6.7F, -6.7F, 4.5F, 3, 2, 1, 0F,1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F); // Box 264
		rightFrontWheelModel[64].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[65].addShapeBox(-4.5F, -9.5F, 4.5F, 3, 2, 1, 0F,1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F); // Box 265
		rightFrontWheelModel[65].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[66].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 266
		rightFrontWheelModel[66].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[67].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 267
		rightFrontWheelModel[67].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[68].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,-0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 268
		rightFrontWheelModel[68].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[69].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,-0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 269
		rightFrontWheelModel[69].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[70].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,-1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 270
		rightFrontWheelModel[70].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[71].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 271
		rightFrontWheelModel[71].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[72].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 272
		rightFrontWheelModel[72].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[73].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,-4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 273
		rightFrontWheelModel[73].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[74].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 274
		rightFrontWheelModel[74].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[75].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 275
		rightFrontWheelModel[75].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[76].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 276
		rightFrontWheelModel[76].setRotationPoint(43.5F, 0.5F, -20F);

		rightFrontWheelModel[77].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 277
		rightFrontWheelModel[77].setRotationPoint(43.5F, 0.5F, -20F);
	}

	private void initleftBackWheelModel_1(){
		leftBackWheelModel = new ModelRendererTurbo[78];
		leftBackWheelModel[0] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 7
		leftBackWheelModel[1] = new ModelRendererTurbo(this, 353, 57, textureX, textureY); // Box 278
		leftBackWheelModel[2] = new ModelRendererTurbo(this, 417, 57, textureX, textureY); // Box 279
		leftBackWheelModel[3] = new ModelRendererTurbo(this, 433, 57, textureX, textureY); // Box 280
		leftBackWheelModel[4] = new ModelRendererTurbo(this, 449, 57, textureX, textureY); // Box 281
		leftBackWheelModel[5] = new ModelRendererTurbo(this, 465, 57, textureX, textureY); // Box 282
		leftBackWheelModel[6] = new ModelRendererTurbo(this, 473, 57, textureX, textureY); // Box 283
		leftBackWheelModel[7] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 284
		leftBackWheelModel[8] = new ModelRendererTurbo(this, 497, 57, textureX, textureY); // Box 285
		leftBackWheelModel[9] = new ModelRendererTurbo(this, 25, 65, textureX, textureY); // Box 286
		leftBackWheelModel[10] = new ModelRendererTurbo(this, 41, 65, textureX, textureY); // Box 287
		leftBackWheelModel[11] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 288
		leftBackWheelModel[12] = new ModelRendererTurbo(this, 89, 65, textureX, textureY); // Box 289
		leftBackWheelModel[13] = new ModelRendererTurbo(this, 113, 65, textureX, textureY); // Box 290
		leftBackWheelModel[14] = new ModelRendererTurbo(this, 137, 65, textureX, textureY); // Box 291
		leftBackWheelModel[15] = new ModelRendererTurbo(this, 161, 65, textureX, textureY); // Box 292
		leftBackWheelModel[16] = new ModelRendererTurbo(this, 185, 65, textureX, textureY); // Box 293
		leftBackWheelModel[17] = new ModelRendererTurbo(this, 209, 65, textureX, textureY); // Box 294
		leftBackWheelModel[18] = new ModelRendererTurbo(this, 233, 65, textureX, textureY); // Box 295
		leftBackWheelModel[19] = new ModelRendererTurbo(this, 249, 65, textureX, textureY); // Box 296
		leftBackWheelModel[20] = new ModelRendererTurbo(this, 265, 65, textureX, textureY); // Box 297
		leftBackWheelModel[21] = new ModelRendererTurbo(this, 281, 65, textureX, textureY); // Box 298
		leftBackWheelModel[22] = new ModelRendererTurbo(this, 489, 57, textureX, textureY); // Box 299
		leftBackWheelModel[23] = new ModelRendererTurbo(this, 17, 65, textureX, textureY); // Box 300
		leftBackWheelModel[24] = new ModelRendererTurbo(this, 57, 65, textureX, textureY); // Box 301
		leftBackWheelModel[25] = new ModelRendererTurbo(this, 81, 65, textureX, textureY); // Box 302
		leftBackWheelModel[26] = new ModelRendererTurbo(this, 105, 65, textureX, textureY); // Box 303
		leftBackWheelModel[27] = new ModelRendererTurbo(this, 129, 65, textureX, textureY); // Box 304
		leftBackWheelModel[28] = new ModelRendererTurbo(this, 153, 65, textureX, textureY); // Box 305
		leftBackWheelModel[29] = new ModelRendererTurbo(this, 177, 65, textureX, textureY); // Box 306
		leftBackWheelModel[30] = new ModelRendererTurbo(this, 201, 65, textureX, textureY); // Box 307
		leftBackWheelModel[31] = new ModelRendererTurbo(this, 225, 65, textureX, textureY); // Box 308
		leftBackWheelModel[32] = new ModelRendererTurbo(this, 297, 65, textureX, textureY); // Box 309
		leftBackWheelModel[33] = new ModelRendererTurbo(this, 313, 65, textureX, textureY); // Box 310
		leftBackWheelModel[34] = new ModelRendererTurbo(this, 329, 65, textureX, textureY); // Box 311
		leftBackWheelModel[35] = new ModelRendererTurbo(this, 337, 65, textureX, textureY); // Box 312
		leftBackWheelModel[36] = new ModelRendererTurbo(this, 345, 65, textureX, textureY); // Box 313
		leftBackWheelModel[37] = new ModelRendererTurbo(this, 353, 65, textureX, textureY); // Box 314
		leftBackWheelModel[38] = new ModelRendererTurbo(this, 361, 65, textureX, textureY); // Box 315
		leftBackWheelModel[39] = new ModelRendererTurbo(this, 369, 65, textureX, textureY); // Box 316
		leftBackWheelModel[40] = new ModelRendererTurbo(this, 377, 65, textureX, textureY); // Box 317
		leftBackWheelModel[41] = new ModelRendererTurbo(this, 401, 65, textureX, textureY); // Box 318
		leftBackWheelModel[42] = new ModelRendererTurbo(this, 425, 65, textureX, textureY); // Box 319
		leftBackWheelModel[43] = new ModelRendererTurbo(this, 441, 65, textureX, textureY); // Box 320
		leftBackWheelModel[44] = new ModelRendererTurbo(this, 457, 65, textureX, textureY); // Box 321
		leftBackWheelModel[45] = new ModelRendererTurbo(this, 473, 65, textureX, textureY); // Box 322
		leftBackWheelModel[46] = new ModelRendererTurbo(this, 481, 65, textureX, textureY); // Box 323
		leftBackWheelModel[47] = new ModelRendererTurbo(this, 489, 65, textureX, textureY); // Box 324
		leftBackWheelModel[48] = new ModelRendererTurbo(this, 1, 73, textureX, textureY); // Box 325
		leftBackWheelModel[49] = new ModelRendererTurbo(this, 17, 73, textureX, textureY); // Box 326
		leftBackWheelModel[50] = new ModelRendererTurbo(this, 41, 73, textureX, textureY); // Box 327
		leftBackWheelModel[51] = new ModelRendererTurbo(this, 57, 73, textureX, textureY); // Box 328
		leftBackWheelModel[52] = new ModelRendererTurbo(this, 73, 73, textureX, textureY); // Box 329
		leftBackWheelModel[53] = new ModelRendererTurbo(this, 89, 73, textureX, textureY); // Box 330
		leftBackWheelModel[54] = new ModelRendererTurbo(this, 97, 73, textureX, textureY); // Box 331
		leftBackWheelModel[55] = new ModelRendererTurbo(this, 105, 73, textureX, textureY); // Box 332
		leftBackWheelModel[56] = new ModelRendererTurbo(this, 113, 73, textureX, textureY); // Box 333
		leftBackWheelModel[57] = new ModelRendererTurbo(this, 129, 73, textureX, textureY); // Box 334
		leftBackWheelModel[58] = new ModelRendererTurbo(this, 145, 73, textureX, textureY); // Box 335
		leftBackWheelModel[59] = new ModelRendererTurbo(this, 153, 73, textureX, textureY); // Box 336
		leftBackWheelModel[60] = new ModelRendererTurbo(this, 161, 73, textureX, textureY); // Box 337
		leftBackWheelModel[61] = new ModelRendererTurbo(this, 169, 73, textureX, textureY); // Box 338
		leftBackWheelModel[62] = new ModelRendererTurbo(this, 177, 73, textureX, textureY); // Box 339
		leftBackWheelModel[63] = new ModelRendererTurbo(this, 201, 73, textureX, textureY); // Box 340
		leftBackWheelModel[64] = new ModelRendererTurbo(this, 297, 73, textureX, textureY); // Box 341
		leftBackWheelModel[65] = new ModelRendererTurbo(this, 321, 73, textureX, textureY); // Box 342
		leftBackWheelModel[66] = new ModelRendererTurbo(this, 225, 73, textureX, textureY); // Box 343
		leftBackWheelModel[67] = new ModelRendererTurbo(this, 345, 73, textureX, textureY); // Box 344
		leftBackWheelModel[68] = new ModelRendererTurbo(this, 377, 73, textureX, textureY); // Box 345
		leftBackWheelModel[69] = new ModelRendererTurbo(this, 393, 73, textureX, textureY); // Box 346
		leftBackWheelModel[70] = new ModelRendererTurbo(this, 353, 73, textureX, textureY); // Box 347
		leftBackWheelModel[71] = new ModelRendererTurbo(this, 409, 73, textureX, textureY); // Box 348
		leftBackWheelModel[72] = new ModelRendererTurbo(this, 417, 73, textureX, textureY); // Box 349
		leftBackWheelModel[73] = new ModelRendererTurbo(this, 425, 73, textureX, textureY); // Box 350
		leftBackWheelModel[74] = new ModelRendererTurbo(this, 433, 73, textureX, textureY); // Box 351
		leftBackWheelModel[75] = new ModelRendererTurbo(this, 449, 73, textureX, textureY); // Box 352
		leftBackWheelModel[76] = new ModelRendererTurbo(this, 465, 73, textureX, textureY); // Box 353
		leftBackWheelModel[77] = new ModelRendererTurbo(this, 481, 73, textureX, textureY); // Box 354

		leftBackWheelModel[0].addBox(-1.5F, -1.5F, -3F, 3, 3, 3, 0F); // Box 7
		leftBackWheelModel[0].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[1].addShapeBox(-1F, -1F, 0F, 2, 2, 1, 0F,0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F); // Box 278
		leftBackWheelModel[1].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[2].addShapeBox(-2.5F, -0.5F, -3F, 1, 1, 3, 0F,-0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F); // Box 279
		leftBackWheelModel[2].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[3].addShapeBox(1.5F, -0.5F, -3F, 1, 1, 3, 0F,0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F); // Box 280
		leftBackWheelModel[3].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[4].addShapeBox(-0.5F, -2.5F, -3F, 1, 1, 3, 0F,-0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 281
		leftBackWheelModel[4].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[5].addShapeBox(-0.5F, 1.5F, -3F, 1, 1, 3, 0F,0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F); // Box 282
		leftBackWheelModel[5].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[6].addBox(-1.5F, -9.5F, -4.5F, 3, 2, 5, 0F); // Box 283
		leftBackWheelModel[6].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[7].addBox(-1.5F, 7.5F, -4.5F, 3, 2, 5, 0F); // Box 284
		leftBackWheelModel[7].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[8].addBox(7.5F, -1.5F, -4.5F, 2, 3, 5, 0F); // Box 285
		leftBackWheelModel[8].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[9].addBox(-9.5F, -1.5F, -4.5F, 2, 3, 5, 0F); // Box 286
		leftBackWheelModel[9].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[10].addShapeBox(3.7F, 4.7F, -4.5F, 3, 2, 5, 0F,-0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 287
		leftBackWheelModel[10].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[11].addShapeBox(5.2F, -7.2F, -4.5F, 3, 2, 5, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 288
		leftBackWheelModel[11].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[12].addShapeBox(-6.7F, -6.7F, -4.5F, 3, 2, 5, 0F,1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 289
		leftBackWheelModel[12].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[13].addShapeBox(-6.7F, 4.7F, -4.5F, 3, 2, 5, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 290
		leftBackWheelModel[13].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[14].addShapeBox(-4.5F, 7.5F, -4.5F, 3, 2, 5, 0F,-0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 291
		leftBackWheelModel[14].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[15].addShapeBox(1.5F, 7.5F, -4.5F, 3, 2, 5, 0F,0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 292
		leftBackWheelModel[15].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[16].addShapeBox(1.5F, -9.5F, -4.5F, 3, 2, 5, 0F,0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 293
		leftBackWheelModel[16].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[17].addShapeBox(-4.5F, -9.5F, -4.5F, 3, 2, 5, 0F,1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 294
		leftBackWheelModel[17].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[18].addShapeBox(7.5F, 1.5F, -4.5F, 2, 3, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 295
		leftBackWheelModel[18].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[19].addShapeBox(7.5F, -4.5F, -4.5F, 2, 3, 5, 0F,1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 296
		leftBackWheelModel[19].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[20].addShapeBox(-9.5F, -4.5F, -4.5F, 2, 3, 5, 0F,-1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 297
		leftBackWheelModel[20].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[21].addShapeBox(-9.5F, 1.5F, -4.5F, 2, 3, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 298
		leftBackWheelModel[21].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[22].addShapeBox(-1.5F, -9.5F, 0.5F, 3, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 299
		leftBackWheelModel[22].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[23].addShapeBox(-1.5F, 7.5F, 0.5F, 3, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 300
		leftBackWheelModel[23].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[24].addShapeBox(7.5F, -1.5F, 0.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 301
		leftBackWheelModel[24].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[25].addShapeBox(-9.5F, -1.5F, 0.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 302
		leftBackWheelModel[25].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[26].addShapeBox(3.7F, 4.7F, 0.5F, 3, 2, 1, 0F,-0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F); // Box 303
		leftBackWheelModel[26].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[27].addShapeBox(3.7F, -6.7F, 0.5F, 3, 2, 1, 0F,-2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F); // Box 304
		leftBackWheelModel[27].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[28].addShapeBox(-6.7F, 4.7F, 0.5F, 3, 2, 1, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F); // Box 305
		leftBackWheelModel[28].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[29].addShapeBox(-6.7F, -6.7F, 0.5F, 3, 2, 1, 0F,1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F); // Box 306
		leftBackWheelModel[29].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[30].addShapeBox(1.5F, 7.5F, 0.5F, 3, 2, 1, 0F,0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F); // Box 307
		leftBackWheelModel[30].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[31].addShapeBox(-4.5F, 7.5F, 0.5F, 3, 2, 1, 0F,-0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F); // Box 308
		leftBackWheelModel[31].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[32].addShapeBox(-4.5F, -9.5F, 0.5F, 3, 2, 1, 0F,1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F); // Box 309
		leftBackWheelModel[32].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[33].addShapeBox(1.5F, -9.5F, 0.5F, 3, 2, 1, 0F,0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 310
		leftBackWheelModel[33].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[34].addShapeBox(-9.5F, 1.5F, 0.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F); // Box 311
		leftBackWheelModel[34].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[35].addShapeBox(-9.5F, -4.5F, 0.5F, 2, 3, 1, 0F,-1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 312
		leftBackWheelModel[35].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[36].addShapeBox(7.5F, -4.5F, 0.5F, 2, 3, 1, 0F,1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 313
		leftBackWheelModel[36].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[37].addShapeBox(7.5F, 1.5F, 0.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F); // Box 314
		leftBackWheelModel[37].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[38].addBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F); // Box 315
		leftBackWheelModel[38].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[39].addBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F); // Box 316
		leftBackWheelModel[39].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[40].addBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F); // Box 317
		leftBackWheelModel[40].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[41].addBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F); // Box 318
		leftBackWheelModel[41].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[42].addShapeBox(-1.5F, -9.5F, -5.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 319
		leftBackWheelModel[42].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[43].addShapeBox(-4.5F, -9.5F, -5.5F, 3, 2, 1, 0F,1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 320
		leftBackWheelModel[43].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[44].addShapeBox(-6.7F, -6.7F, -5.5F, 3, 2, 1, 0F,0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 321
		leftBackWheelModel[44].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[45].addShapeBox(-9.5F, -4.5F, -5.5F, 2, 3, 1, 0F,-2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 322
		leftBackWheelModel[45].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[46].addShapeBox(-9.5F, -1.5F, -5.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 323
		leftBackWheelModel[46].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[47].addShapeBox(-9.5F, 1.5F, -5.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 324
		leftBackWheelModel[47].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[48].addShapeBox(-6.7F, 4.7F, -5.5F, 3, 2, 1, 0F,-0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 325
		leftBackWheelModel[48].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[49].addShapeBox(-4.5F, 7.5F, -5.5F, 3, 2, 1, 0F,-0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 326
		leftBackWheelModel[49].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[50].addShapeBox(-1.5F, 7.5F, -5.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 327
		leftBackWheelModel[50].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[51].addShapeBox(1.5F, 7.5F, -5.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 328
		leftBackWheelModel[51].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[52].addShapeBox(3.7F, 4.7F, -5.5F, 3, 2, 1, 0F,-0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 329
		leftBackWheelModel[52].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[53].addShapeBox(7.5F, 1.5F, -5.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 330
		leftBackWheelModel[53].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[54].addShapeBox(7.5F, -1.5F, -5.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 331
		leftBackWheelModel[54].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[55].addShapeBox(7.5F, -4.5F, -5.5F, 2, 3, 1, 0F,1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 332
		leftBackWheelModel[55].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[56].addShapeBox(3.7F, -6.7F, -5.5F, 3, 2, 1, 0F,-1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F); // Box 333
		leftBackWheelModel[56].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[57].addShapeBox(1.5F, -9.5F, -5.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 334
		leftBackWheelModel[57].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[58].addShapeBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F,-0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 335
		leftBackWheelModel[58].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[59].addShapeBox(-0.5F, 1.5F, -2.5F, 1, 6, 2, 0F,0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 336
		leftBackWheelModel[59].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[60].addShapeBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F,3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 337
		leftBackWheelModel[60].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[61].addShapeBox(-0.5F, -7.5F, -2.5F, 1, 6, 2, 0F,-3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 338
		leftBackWheelModel[61].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[62].addShapeBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F,-0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 339
		leftBackWheelModel[62].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[63].addShapeBox(-7.5F, -0.5F, -2.5F, 6, 1, 2, 0F,-1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 340
		leftBackWheelModel[63].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[64].addShapeBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F,0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 341
		leftBackWheelModel[64].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[65].addShapeBox(1.5F, -0.5F, -2.5F, 6, 1, 2, 0F,-0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 342
		leftBackWheelModel[65].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[66].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 343
		leftBackWheelModel[66].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[67].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F); // Box 344
		leftBackWheelModel[67].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[68].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 345
		leftBackWheelModel[68].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[69].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 346
		leftBackWheelModel[69].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[70].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,-0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F); // Box 347
		leftBackWheelModel[70].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[71].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F); // Box 348
		leftBackWheelModel[71].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[72].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F); // Box 349
		leftBackWheelModel[72].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[73].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,-3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F); // Box 350
		leftBackWheelModel[73].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[74].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F); // Box 351
		leftBackWheelModel[74].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[75].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F); // Box 352
		leftBackWheelModel[75].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[76].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F); // Box 353
		leftBackWheelModel[76].setRotationPoint(-43.5F, 0.5F, 20F);

		leftBackWheelModel[77].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F); // Box 354
		leftBackWheelModel[77].setRotationPoint(-43.5F, 0.5F, 20F);
	}

	private void initrightBackWheelModel_1(){
		rightBackWheelModel = new ModelRendererTurbo[78];
		rightBackWheelModel[0] = new ModelRendererTurbo(this, 217, 1, textureX, textureY); // Box 8
		rightBackWheelModel[1] = new ModelRendererTurbo(this, 497, 73, textureX, textureY); // Box 355
		rightBackWheelModel[2] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 356
		rightBackWheelModel[3] = new ModelRendererTurbo(this, 25, 81, textureX, textureY); // Box 357
		rightBackWheelModel[4] = new ModelRendererTurbo(this, 49, 81, textureX, textureY); // Box 358
		rightBackWheelModel[5] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 359
		rightBackWheelModel[6] = new ModelRendererTurbo(this, 81, 81, textureX, textureY); // Box 360
		rightBackWheelModel[7] = new ModelRendererTurbo(this, 105, 81, textureX, textureY); // Box 361
		rightBackWheelModel[8] = new ModelRendererTurbo(this, 129, 81, textureX, textureY); // Box 362
		rightBackWheelModel[9] = new ModelRendererTurbo(this, 177, 81, textureX, textureY); // Box 363
		rightBackWheelModel[10] = new ModelRendererTurbo(this, 201, 81, textureX, textureY); // Box 364
		rightBackWheelModel[11] = new ModelRendererTurbo(this, 225, 81, textureX, textureY); // Box 365
		rightBackWheelModel[12] = new ModelRendererTurbo(this, 249, 81, textureX, textureY); // Box 366
		rightBackWheelModel[13] = new ModelRendererTurbo(this, 273, 81, textureX, textureY); // Box 367
		rightBackWheelModel[14] = new ModelRendererTurbo(this, 297, 81, textureX, textureY); // Box 368
		rightBackWheelModel[15] = new ModelRendererTurbo(this, 313, 81, textureX, textureY); // Box 369
		rightBackWheelModel[16] = new ModelRendererTurbo(this, 329, 81, textureX, textureY); // Box 370
		rightBackWheelModel[17] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 371
		rightBackWheelModel[18] = new ModelRendererTurbo(this, 17, 81, textureX, textureY); // Box 372
		rightBackWheelModel[19] = new ModelRendererTurbo(this, 41, 81, textureX, textureY); // Box 373
		rightBackWheelModel[20] = new ModelRendererTurbo(this, 505, 73, textureX, textureY); // Box 374
		rightBackWheelModel[21] = new ModelRendererTurbo(this, 97, 81, textureX, textureY); // Box 375
		rightBackWheelModel[22] = new ModelRendererTurbo(this, 121, 81, textureX, textureY); // Box 376
		rightBackWheelModel[23] = new ModelRendererTurbo(this, 193, 81, textureX, textureY); // Box 377
		rightBackWheelModel[24] = new ModelRendererTurbo(this, 217, 81, textureX, textureY); // Box 378
		rightBackWheelModel[25] = new ModelRendererTurbo(this, 241, 81, textureX, textureY); // Box 379
		rightBackWheelModel[26] = new ModelRendererTurbo(this, 265, 81, textureX, textureY); // Box 380
		rightBackWheelModel[27] = new ModelRendererTurbo(this, 289, 81, textureX, textureY); // Box 381
		rightBackWheelModel[28] = new ModelRendererTurbo(this, 361, 81, textureX, textureY); // Box 382
		rightBackWheelModel[29] = new ModelRendererTurbo(this, 377, 81, textureX, textureY); // Box 383
		rightBackWheelModel[30] = new ModelRendererTurbo(this, 393, 81, textureX, textureY); // Box 384
		rightBackWheelModel[31] = new ModelRendererTurbo(this, 401, 81, textureX, textureY); // Box 385
		rightBackWheelModel[32] = new ModelRendererTurbo(this, 409, 81, textureX, textureY); // Box 386
		rightBackWheelModel[33] = new ModelRendererTurbo(this, 417, 81, textureX, textureY); // Box 387
		rightBackWheelModel[34] = new ModelRendererTurbo(this, 425, 81, textureX, textureY); // Box 388
		rightBackWheelModel[35] = new ModelRendererTurbo(this, 441, 81, textureX, textureY); // Box 389
		rightBackWheelModel[36] = new ModelRendererTurbo(this, 457, 81, textureX, textureY); // Box 390
		rightBackWheelModel[37] = new ModelRendererTurbo(this, 473, 81, textureX, textureY); // Box 391
		rightBackWheelModel[38] = new ModelRendererTurbo(this, 481, 81, textureX, textureY); // Box 392
		rightBackWheelModel[39] = new ModelRendererTurbo(this, 489, 81, textureX, textureY); // Box 393
		rightBackWheelModel[40] = new ModelRendererTurbo(this, 497, 81, textureX, textureY); // Box 394
		rightBackWheelModel[41] = new ModelRendererTurbo(this, 1, 89, textureX, textureY); // Box 395
		rightBackWheelModel[42] = new ModelRendererTurbo(this, 17, 89, textureX, textureY); // Box 396
		rightBackWheelModel[43] = new ModelRendererTurbo(this, 33, 89, textureX, textureY); // Box 397
		rightBackWheelModel[44] = new ModelRendererTurbo(this, 81, 89, textureX, textureY); // Box 398
		rightBackWheelModel[45] = new ModelRendererTurbo(this, 97, 89, textureX, textureY); // Box 399
		rightBackWheelModel[46] = new ModelRendererTurbo(this, 105, 89, textureX, textureY); // Box 400
		rightBackWheelModel[47] = new ModelRendererTurbo(this, 113, 89, textureX, textureY); // Box 401
		rightBackWheelModel[48] = new ModelRendererTurbo(this, 121, 89, textureX, textureY); // Box 402
		rightBackWheelModel[49] = new ModelRendererTurbo(this, 137, 89, textureX, textureY); // Box 403
		rightBackWheelModel[50] = new ModelRendererTurbo(this, 153, 89, textureX, textureY); // Box 404
		rightBackWheelModel[51] = new ModelRendererTurbo(this, 169, 89, textureX, textureY); // Box 405
		rightBackWheelModel[52] = new ModelRendererTurbo(this, 185, 89, textureX, textureY); // Box 406
		rightBackWheelModel[53] = new ModelRendererTurbo(this, 201, 89, textureX, textureY); // Box 407
		rightBackWheelModel[54] = new ModelRendererTurbo(this, 217, 89, textureX, textureY); // Box 408
		rightBackWheelModel[55] = new ModelRendererTurbo(this, 225, 89, textureX, textureY); // Box 409
		rightBackWheelModel[56] = new ModelRendererTurbo(this, 233, 89, textureX, textureY); // Box 410
		rightBackWheelModel[57] = new ModelRendererTurbo(this, 257, 89, textureX, textureY); // Box 411
		rightBackWheelModel[58] = new ModelRendererTurbo(this, 281, 89, textureX, textureY); // Box 412
		rightBackWheelModel[59] = new ModelRendererTurbo(this, 289, 89, textureX, textureY); // Box 413
		rightBackWheelModel[60] = new ModelRendererTurbo(this, 361, 89, textureX, textureY); // Box 414
		rightBackWheelModel[61] = new ModelRendererTurbo(this, 369, 89, textureX, textureY); // Box 415
		rightBackWheelModel[62] = new ModelRendererTurbo(this, 377, 89, textureX, textureY); // Box 416
		rightBackWheelModel[63] = new ModelRendererTurbo(this, 401, 89, textureX, textureY); // Box 417
		rightBackWheelModel[64] = new ModelRendererTurbo(this, 425, 89, textureX, textureY); // Box 418
		rightBackWheelModel[65] = new ModelRendererTurbo(this, 449, 89, textureX, textureY); // Box 419
		rightBackWheelModel[66] = new ModelRendererTurbo(this, 473, 89, textureX, textureY); // Box 420
		rightBackWheelModel[67] = new ModelRendererTurbo(this, 481, 89, textureX, textureY); // Box 421
		rightBackWheelModel[68] = new ModelRendererTurbo(this, 489, 89, textureX, textureY); // Box 422
		rightBackWheelModel[69] = new ModelRendererTurbo(this, 1, 97, textureX, textureY); // Box 423
		rightBackWheelModel[70] = new ModelRendererTurbo(this, 505, 89, textureX, textureY); // Box 424
		rightBackWheelModel[71] = new ModelRendererTurbo(this, 17, 97, textureX, textureY); // Box 425
		rightBackWheelModel[72] = new ModelRendererTurbo(this, 25, 97, textureX, textureY); // Box 426
		rightBackWheelModel[73] = new ModelRendererTurbo(this, 33, 97, textureX, textureY); // Box 427
		rightBackWheelModel[74] = new ModelRendererTurbo(this, 41, 97, textureX, textureY); // Box 428
		rightBackWheelModel[75] = new ModelRendererTurbo(this, 57, 97, textureX, textureY); // Box 429
		rightBackWheelModel[76] = new ModelRendererTurbo(this, 73, 97, textureX, textureY); // Box 430
		rightBackWheelModel[77] = new ModelRendererTurbo(this, 89, 97, textureX, textureY); // Box 431

		rightBackWheelModel[0].addBox(-1.5F, -1.5F, 0F, 3, 3, 3, 0F); // Box 8
		rightBackWheelModel[0].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[1].addShapeBox(-1F, -1F, -1F, 2, 2, 1, 0F,0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F); // Box 355
		rightBackWheelModel[1].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[2].addBox(-1.5F, 7.5F, -0.5F, 3, 2, 5, 0F); // Box 356
		rightBackWheelModel[2].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[3].addBox(-1.5F, -9.5F, -0.5F, 3, 2, 5, 0F); // Box 357
		rightBackWheelModel[3].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[4].addBox(-9.5F, -1.5F, -0.5F, 2, 3, 5, 0F); // Box 358
		rightBackWheelModel[4].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[5].addBox(7.5F, -1.5F, -0.5F, 2, 3, 5, 0F); // Box 359
		rightBackWheelModel[5].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[6].addShapeBox(-6.7F, 4.7F, -0.5F, 3, 2, 5, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 360
		rightBackWheelModel[6].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[7].addShapeBox(3.7F, 4.7F, -0.5F, 3, 2, 5, 0F,-0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 361
		rightBackWheelModel[7].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[8].addShapeBox(-6.7F, -6.7F, -0.5F, 3, 2, 5, 0F,1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 362
		rightBackWheelModel[8].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[9].addShapeBox(5.2F, -7.2F, -0.5F, 3, 2, 5, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 363
		rightBackWheelModel[9].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[10].addShapeBox(-4.5F, 7.5F, -0.5F, 3, 2, 5, 0F,-0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 364
		rightBackWheelModel[10].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[11].addShapeBox(1.5F, 7.5F, -0.5F, 3, 2, 5, 0F,0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 365
		rightBackWheelModel[11].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[12].addShapeBox(1.5F, -9.5F, -0.5F, 3, 2, 5, 0F,0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 366
		rightBackWheelModel[12].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[13].addShapeBox(-4.5F, -9.5F, -0.5F, 3, 2, 5, 0F,1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 367
		rightBackWheelModel[13].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[14].addShapeBox(-9.5F, 1.5F, -0.5F, 2, 3, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 368
		rightBackWheelModel[14].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[15].addShapeBox(-9.5F, -4.5F, -0.5F, 2, 3, 5, 0F,-1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 369
		rightBackWheelModel[15].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[16].addShapeBox(7.5F, -4.5F, -0.5F, 2, 3, 5, 0F,1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 370
		rightBackWheelModel[16].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[17].addShapeBox(7.5F, 1.5F, -0.5F, 2, 3, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 371
		rightBackWheelModel[17].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[18].addShapeBox(-1.5F, -9.5F, -1.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 372
		rightBackWheelModel[18].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[19].addShapeBox(-1.5F, 7.5F, -1.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 373
		rightBackWheelModel[19].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[20].addShapeBox(-9.5F, -1.5F, -1.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 374
		rightBackWheelModel[20].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[21].addShapeBox(7.5F, -1.5F, -1.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 375
		rightBackWheelModel[21].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[22].addShapeBox(-6.7F, -6.7F, -1.5F, 3, 2, 1, 0F,0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F); // Box 376
		rightBackWheelModel[22].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[23].addShapeBox(-6.7F, 4.7F, -1.5F, 3, 2, 1, 0F,-0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F); // Box 377
		rightBackWheelModel[23].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[24].addShapeBox(3.7F, 4.7F, -1.5F, 3, 2, 1, 0F,-0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F); // Box 378
		rightBackWheelModel[24].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[25].addShapeBox(-4.5F, 7.5F, -1.5F, 3, 2, 1, 0F,-0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F); // Box 379
		rightBackWheelModel[25].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[26].addShapeBox(1.5F, 7.5F, -1.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F); // Box 380
		rightBackWheelModel[26].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[27].addShapeBox(1.5F, -9.5F, -1.5F, 3, 2, 1, 0F,0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F); // Box 381
		rightBackWheelModel[27].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[28].addShapeBox(-4.5F, -9.5F, -1.5F, 3, 2, 1, 0F,1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F); // Box 382
		rightBackWheelModel[28].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[29].addShapeBox(3.7F, -6.7F, -1.5F, 3, 2, 1, 0F,-1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F); // Box 383
		rightBackWheelModel[29].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[30].addShapeBox(7.5F, 1.5F, -1.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F); // Box 384
		rightBackWheelModel[30].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[31].addShapeBox(7.5F, -4.5F, -1.5F, 2, 3, 1, 0F,1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 385
		rightBackWheelModel[31].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[32].addShapeBox(-9.5F, -4.5F, -1.5F, 2, 3, 1, 0F,-2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 386
		rightBackWheelModel[32].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[33].addShapeBox(-9.5F, 1.5F, -1.5F, 2, 3, 1, 0F,-0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F); // Box 387
		rightBackWheelModel[33].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[34].addShapeBox(-1.5F, -9.5F, 4.5F, 3, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 388
		rightBackWheelModel[34].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[35].addShapeBox(-4.5F, -9.5F, 4.5F, 3, 2, 1, 0F,1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F, -0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F); // Box 389
		rightBackWheelModel[35].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[36].addShapeBox(-6.7F, -6.7F, 4.5F, 3, 2, 1, 0F,1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F, -0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F); // Box 390
		rightBackWheelModel[36].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[37].addShapeBox(-9.5F, -4.5F, 4.5F, 2, 3, 1, 0F,-1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 391
		rightBackWheelModel[37].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[38].addShapeBox(-9.5F, -1.5F, 4.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 392
		rightBackWheelModel[38].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[39].addShapeBox(-9.5F, 1.5F, 4.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, -1.8F, 1.2F, 0F, 1.3F, -0.3F, 0F, 1.2F, -0.1F, -0.7F, -2F, 1.2F, -0.7F); // Box 393
		rightBackWheelModel[39].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[40].addShapeBox(-6.7F, 4.7F, 4.5F, 3, 2, 1, 0F,-0.5F, 0.5F, 0F, -0.5F, -1.5F, 0F, -0.7F, -1.6F, -0.7F, -0.4F, 0.3F, -0.7F, 1F, -1F, 0F, -2F, 1F, 0F, -1.9F, 0.8F, -0.7F, 0.8F, -1F, -0.7F); // Box 394
		rightBackWheelModel[40].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[41].addShapeBox(-4.5F, 7.5F, 4.5F, 3, 2, 1, 0F,-0.3F, 1.3F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, -0.1F, 1.2F, -0.7F, 1.2F, -1.8F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 1.1F, -2F, -0.7F); // Box 395
		rightBackWheelModel[41].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[42].addShapeBox(-1.5F, 7.5F, 4.5F, 3, 2, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 396
		rightBackWheelModel[42].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[43].addShapeBox(1.5F, 7.5F, 4.5F, 3, 2, 1, 0F,0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F); // Box 397
		rightBackWheelModel[43].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[44].addShapeBox(3.7F, 4.7F, 4.5F, 3, 2, 1, 0F,-0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F, -2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F); // Box 398
		rightBackWheelModel[44].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[45].addShapeBox(7.5F, 1.5F, 4.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F); // Box 399
		rightBackWheelModel[45].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[46].addShapeBox(7.5F, -1.5F, 4.5F, 2, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 400
		rightBackWheelModel[46].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[47].addShapeBox(7.5F, -4.5F, 4.5F, 2, 3, 1, 0F,1.3F, -0.3F, 0F, -1.8F, 1.2F, 0F, -2F, 1.2F, -0.7F, 1.2F, -0.1F, -0.7F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.7F, -0.2F, 0F, -0.7F); // Box 401
		rightBackWheelModel[47].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[48].addShapeBox(3.7F, -6.7F, 4.5F, 3, 2, 1, 0F,-2F, 1F, 0F, 1F, -1F, 0F, 0.8F, -1F, -0.7F, -1.9F, 0.8F, -0.7F, -0.5F, -1.5F, 0F, -0.5F, 0.5F, 0F, -0.4F, 0.3F, -0.7F, -0.7F, -1.6F, -0.7F); // Box 402
		rightBackWheelModel[48].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[49].addShapeBox(1.5F, -9.5F, 4.5F, 3, 2, 1, 0F,0F, 0F, 0F, 1.2F, -1.8F, 0F, 1.1F, -2F, -0.7F, 0F, -0.2F, -0.7F, 0F, 0F, 0F, -0.3F, 1.3F, 0F, -0.1F, 1.2F, -0.7F, 0F, -0.2F, -0.7F); // Box 403
		rightBackWheelModel[49].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[50].addShapeBox(1.5F, -0.5F, 0F, 1, 1, 3, 0F,0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F); // Box 404
		rightBackWheelModel[50].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[51].addShapeBox(-2.5F, -0.5F, 0F, 1, 1, 3, 0F,-0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F, -0.4F, -0.5F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, -0.4F, -0.5F, 0F); // Box 405
		rightBackWheelModel[51].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[52].addShapeBox(-0.5F, -2.5F, 0F, 1, 1, 3, 0F,-0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F); // Box 406
		rightBackWheelModel[52].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[53].addShapeBox(-0.5F, 1.5F, 0F, 1, 1, 3, 0F,0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, 0.1F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F); // Box 407
		rightBackWheelModel[53].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[54].addBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F); // Box 408
		rightBackWheelModel[54].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[55].addBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F); // Box 409
		rightBackWheelModel[55].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[56].addBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F); // Box 410
		rightBackWheelModel[56].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[57].addBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F); // Box 411
		rightBackWheelModel[57].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[58].addShapeBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F,0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 412
		rightBackWheelModel[58].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[59].addShapeBox(-0.5F, 1.5F, 0.5F, 1, 6, 2, 0F,-0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 413
		rightBackWheelModel[59].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[60].addShapeBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F,-3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 414
		rightBackWheelModel[60].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[61].addShapeBox(-0.5F, -7.5F, 0.5F, 1, 6, 2, 0F,3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 415
		rightBackWheelModel[61].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[62].addShapeBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F,-0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 416
		rightBackWheelModel[62].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[63].addShapeBox(-7.5F, -0.5F, 0.5F, 6, 1, 2, 0F,-1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 417
		rightBackWheelModel[63].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[64].addShapeBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F,0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 418
		rightBackWheelModel[64].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[65].addShapeBox(1.5F, -0.5F, 0.5F, 6, 1, 2, 0F,-0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 419
		rightBackWheelModel[65].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[66].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,-0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 420
		rightBackWheelModel[66].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[67].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,-0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 421
		rightBackWheelModel[67].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[68].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 422
		rightBackWheelModel[68].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[69].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 423
		rightBackWheelModel[69].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[70].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F, 3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F); // Box 424
		rightBackWheelModel[70].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[71].addShapeBox(-0.5F, 1.5F, -0.5F, 1, 6, 1, 0F,-1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F, -4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F); // Box 425
		rightBackWheelModel[71].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[72].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,-4.25F, -1.1F, -0.5F, 3.3F, -1F, -0.5F, 3.7F, -1.25F, 0F, -3.8F, -0.75F, 0F, -1.35F, 0.15F, -0.5F, 0.35F, 0.15F, -0.5F, 0.7F, 0.45F, 0F, -0.85F, -0.05F, 0F); // Box 426
		rightBackWheelModel[72].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[73].addShapeBox(-0.5F, -7.5F, -0.5F, 1, 6, 1, 0F,3.3F, -1F, -0.5F, -4.25F, -1.1F, -0.5F, -3.8F, -0.75F, 0F, 3.7F, -1.25F, 0F, 0.35F, 0.15F, -0.5F, -1.35F, 0.15F, -0.5F, -0.85F, -0.05F, 0F, 0.7F, 0.45F, 0F); // Box 427
		rightBackWheelModel[73].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[74].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F, -1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F); // Box 428
		rightBackWheelModel[74].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[75].addShapeBox(-7.5F, -0.5F, -0.5F, 6, 1, 1, 0F,-1.05F, 3.15F, -0.5F, 0.3F, 0.15F, -0.5F, 0.45F, 0.7F, 0F, -1.25F, 3.7F, 0F, -0.85F, -4.25F, -0.5F, 0.15F, -1.25F, -0.5F, -0.05F, -0.8F, 0F, -0.75F, -3.8F, 0F); // Box 429
		rightBackWheelModel[75].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[76].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F, 0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F); // Box 430
		rightBackWheelModel[76].setRotationPoint(-43.5F, 0.5F, -20F);

		rightBackWheelModel[77].addShapeBox(1.5F, -0.5F, -0.5F, 6, 1, 1, 0F,0.15F, -1.25F, -0.5F, -0.85F, -4.25F, -0.5F, -0.75F, -3.8F, 0F, -0.05F, -0.8F, 0F, 0.3F, 0.15F, -0.5F, -1.05F, 3.15F, -0.5F, -1.25F, 3.7F, 0F, 0.45F, 0.7F, 0F); // Box 431
		rightBackWheelModel[77].setRotationPoint(-43.5F, 0.5F, -20F);
	}

	private void initprimaryPaintBodyModel_1(){
		primaryPaintBodyModel = new ModelRendererTurbo[73];
		primaryPaintBodyModel[0] = new ModelRendererTurbo(this, 97, 113, textureX, textureY); // Box 439
		primaryPaintBodyModel[1] = new ModelRendererTurbo(this, 409, 105, textureX, textureY); // Box 444
		primaryPaintBodyModel[2] = new ModelRendererTurbo(this, 441, 105, textureX, textureY); // Box 445
		primaryPaintBodyModel[3] = new ModelRendererTurbo(this, 473, 105, textureX, textureY); // Box 446
		primaryPaintBodyModel[4] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 447
		primaryPaintBodyModel[5] = new ModelRendererTurbo(this, 57, 113, textureX, textureY); // Box 448
		primaryPaintBodyModel[6] = new ModelRendererTurbo(this, 73, 113, textureX, textureY); // Box 449
		primaryPaintBodyModel[7] = new ModelRendererTurbo(this, 97, 113, textureX, textureY); // Box 457
		primaryPaintBodyModel[8] = new ModelRendererTurbo(this, 153, 113, textureX, textureY); // Box 458
		primaryPaintBodyModel[9] = new ModelRendererTurbo(this, 177, 113, textureX, textureY); // Box 459
		primaryPaintBodyModel[10] = new ModelRendererTurbo(this, 505, 97, textureX, textureY); // Box 460
		primaryPaintBodyModel[11] = new ModelRendererTurbo(this, 201, 113, textureX, textureY); // Box 461
		primaryPaintBodyModel[12] = new ModelRendererTurbo(this, 401, 153, textureX, textureY); // Box 482
		primaryPaintBodyModel[13] = new ModelRendererTurbo(this, 265, 113, textureX, textureY); // Box 484
		primaryPaintBodyModel[14] = new ModelRendererTurbo(this, 201, 161, textureX, textureY); // Box 485
		primaryPaintBodyModel[15] = new ModelRendererTurbo(this, 305, 113, textureX, textureY); // Box 486
		primaryPaintBodyModel[16] = new ModelRendererTurbo(this, 65, 161, textureX, textureY); // Box 487
		primaryPaintBodyModel[17] = new ModelRendererTurbo(this, 97, 169, textureX, textureY); // Box 488
		primaryPaintBodyModel[18] = new ModelRendererTurbo(this, 137, 169, textureX, textureY); // Box 489
		primaryPaintBodyModel[19] = new ModelRendererTurbo(this, 241, 169, textureX, textureY); // Box 490
		primaryPaintBodyModel[20] = new ModelRendererTurbo(this, 401, 169, textureX, textureY); // Box 491
		primaryPaintBodyModel[21] = new ModelRendererTurbo(this, 57, 129, textureX, textureY); // Box 494
		primaryPaintBodyModel[22] = new ModelRendererTurbo(this, 369, 113, textureX, textureY); // Box 495
		primaryPaintBodyModel[23] = new ModelRendererTurbo(this, 193, 129, textureX, textureY); // Box 496
		primaryPaintBodyModel[24] = new ModelRendererTurbo(this, 409, 129, textureX, textureY); // Box 497
		primaryPaintBodyModel[25] = new ModelRendererTurbo(this, 257, 169, textureX, textureY); // Box 498
		primaryPaintBodyModel[26] = new ModelRendererTurbo(this, 241, 137, textureX, textureY); // Box 499
		primaryPaintBodyModel[27] = new ModelRendererTurbo(this, 481, 145, textureX, textureY); // Box 500
		primaryPaintBodyModel[28] = new ModelRendererTurbo(this, 361, 153, textureX, textureY); // Box 501
		primaryPaintBodyModel[29] = new ModelRendererTurbo(this, 25, 161, textureX, textureY); // Box 502
		primaryPaintBodyModel[30] = new ModelRendererTurbo(this, 489, 161, textureX, textureY); // Box 515
		primaryPaintBodyModel[31] = new ModelRendererTurbo(this, 313, 169, textureX, textureY); // Box 516
		primaryPaintBodyModel[32] = new ModelRendererTurbo(this, 313, 185, textureX, textureY); // Box 517
		primaryPaintBodyModel[33] = new ModelRendererTurbo(this, 1, 185, textureX, textureY); // Box 518
		primaryPaintBodyModel[34] = new ModelRendererTurbo(this, 89, 193, textureX, textureY); // Box 519
		primaryPaintBodyModel[35] = new ModelRendererTurbo(this, 145, 193, textureX, textureY); // Box 520
		primaryPaintBodyModel[36] = new ModelRendererTurbo(this, 233, 193, textureX, textureY); // Box 521
		primaryPaintBodyModel[37] = new ModelRendererTurbo(this, 457, 169, textureX, textureY); // Box 522
		primaryPaintBodyModel[38] = new ModelRendererTurbo(this, 369, 177, textureX, textureY); // Box 523
		primaryPaintBodyModel[39] = new ModelRendererTurbo(this, 25, 185, textureX, textureY); // Box 527
		primaryPaintBodyModel[40] = new ModelRendererTurbo(this, 465, 185, textureX, textureY); // Box 530
		primaryPaintBodyModel[41] = new ModelRendererTurbo(this, 57, 185, textureX, textureY); // Box 531
		primaryPaintBodyModel[42] = new ModelRendererTurbo(this, 313, 193, textureX, textureY); // Box 532
		primaryPaintBodyModel[43] = new ModelRendererTurbo(this, 201, 185, textureX, textureY); // Box 533
		primaryPaintBodyModel[44] = new ModelRendererTurbo(this, 481, 201, textureX, textureY); // Box 534
		primaryPaintBodyModel[45] = new ModelRendererTurbo(this, 369, 193, textureX, textureY); // Box 535
		primaryPaintBodyModel[46] = new ModelRendererTurbo(this, 177, 209, textureX, textureY); // Box 536
		primaryPaintBodyModel[47] = new ModelRendererTurbo(this, 425, 193, textureX, textureY); // Box 537
		primaryPaintBodyModel[48] = new ModelRendererTurbo(this, 25, 225, textureX, textureY); // Box 538
		primaryPaintBodyModel[49] = new ModelRendererTurbo(this, 225, 225, textureX, textureY); // Box 539
		primaryPaintBodyModel[50] = new ModelRendererTurbo(this, 225, 113, textureX, textureY); // Box 540
		primaryPaintBodyModel[51] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 541
		primaryPaintBodyModel[52] = new ModelRendererTurbo(this, 265, 113, textureX, textureY); // Box 542
		primaryPaintBodyModel[53] = new ModelRendererTurbo(this, 289, 113, textureX, textureY); // Box 543
		primaryPaintBodyModel[54] = new ModelRendererTurbo(this, 345, 113, textureX, textureY); // Box 544
		primaryPaintBodyModel[55] = new ModelRendererTurbo(this, 33, 121, textureX, textureY); // Box 545
		primaryPaintBodyModel[56] = new ModelRendererTurbo(this, 305, 113, textureX, textureY); // Box 546
		primaryPaintBodyModel[57] = new ModelRendererTurbo(this, 329, 113, textureX, textureY); // Box 547
		primaryPaintBodyModel[58] = new ModelRendererTurbo(this, 409, 233, textureX, textureY); // Box 548
		primaryPaintBodyModel[59] = new ModelRendererTurbo(this, 81, 241, textureX, textureY); // Box 549
		primaryPaintBodyModel[60] = new ModelRendererTurbo(this, 137, 241, textureX, textureY); // Box 550
		primaryPaintBodyModel[61] = new ModelRendererTurbo(this, 289, 241, textureX, textureY); // Box 551
		primaryPaintBodyModel[62] = new ModelRendererTurbo(this, 57, 145, textureX, textureY); // Box 552
		primaryPaintBodyModel[63] = new ModelRendererTurbo(this, 97, 145, textureX, textureY); // Box 553
		primaryPaintBodyModel[64] = new ModelRendererTurbo(this, 369, 241, textureX, textureY); // Box 558
		primaryPaintBodyModel[65] = new ModelRendererTurbo(this, 497, 97, textureX, textureY); // Box 565
		primaryPaintBodyModel[66] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 566
		primaryPaintBodyModel[67] = new ModelRendererTurbo(this, 25, 129, textureX, textureY); // Box 567
		primaryPaintBodyModel[68] = new ModelRendererTurbo(this, 433, 129, textureX, textureY); // Box 568
		primaryPaintBodyModel[69] = new ModelRendererTurbo(this, 441, 129, textureX, textureY); // Box 569
		primaryPaintBodyModel[70] = new ModelRendererTurbo(this, 505, 113, textureX, textureY); // Box 570
		primaryPaintBodyModel[71] = new ModelRendererTurbo(this, 369, 265, textureX, textureY); // Box 567
		primaryPaintBodyModel[72] = new ModelRendererTurbo(this, 1, 273, textureX, textureY); // Box 568

		primaryPaintBodyModel[0].addBox(0F, 0F, 0F, 3, 11, 42, 0F); // Box 439
		primaryPaintBodyModel[0].setRotationPoint(25F, -10F, -21F);

		primaryPaintBodyModel[1].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F,0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, -4F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 4F); // Box 444
		primaryPaintBodyModel[1].setRotationPoint(45F, -8F, -14F);

		primaryPaintBodyModel[2].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F,0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 2F); // Box 445
		primaryPaintBodyModel[2].setRotationPoint(32F, -8F, -14F);

		primaryPaintBodyModel[3].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F,0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, 2F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -2F); // Box 446
		primaryPaintBodyModel[3].setRotationPoint(32F, -8F, 12F);

		primaryPaintBodyModel[4].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F,0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 4F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -4F); // Box 447
		primaryPaintBodyModel[4].setRotationPoint(45F, -8F, 12F);

		primaryPaintBodyModel[5].addShapeBox(0F, 0F, 0F, 3, 9, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F); // Box 448
		primaryPaintBodyModel[5].setRotationPoint(42F, -8F, -12F);

		primaryPaintBodyModel[6].addShapeBox(0F, 0F, 0F, 3, 9, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 449
		primaryPaintBodyModel[6].setRotationPoint(42F, -8F, 10F);

		primaryPaintBodyModel[7].addShapeBox(0F, 0F, 0F, 3, 8, 12, 0F,0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 457
		primaryPaintBodyModel[7].setRotationPoint(55F, -8F, 9F);

		primaryPaintBodyModel[8].addShapeBox(0F, 0F, 0F, 3, 8, 12, 0F,1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 458
		primaryPaintBodyModel[8].setRotationPoint(55F, -8F, -21F);

		primaryPaintBodyModel[9].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F,0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 459
		primaryPaintBodyModel[9].setRotationPoint(58F, -2F, -9F);

		primaryPaintBodyModel[10].addShapeBox(0F, 0F, 0F, 1, 8, 2, 0F,1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 460
		primaryPaintBodyModel[10].setRotationPoint(58.2F, -8F, -1F);

		primaryPaintBodyModel[11].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F,0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 461
		primaryPaintBodyModel[11].setRotationPoint(58F, -2F, 1F);

		primaryPaintBodyModel[12].addShapeBox(0F, 0F, 0F, 9, 3, 12, 0F,0F, 1F, 0F, 0F, -1F, 0F, -1F, -1F, -1F, 1F, 1F, -1F, 0F, -2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F); // Box 482
		primaryPaintBodyModel[12].setRotationPoint(45F, -11F, 9F);

		primaryPaintBodyModel[13].addShapeBox(0F, 0F, 0F, 3, 2, 12, 0F,0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, -1F, 1F, 0F, -1F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 484
		primaryPaintBodyModel[13].setRotationPoint(54F, -10F, 9F);

		primaryPaintBodyModel[14].addShapeBox(0F, 0F, 0F, 16, 2, 12, 0F,0F, 0F, 0F, 1F, -1F, 0F, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 1F, 0F, 1F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 485
		primaryPaintBodyModel[14].setRotationPoint(28F, -13F, 9F);

		primaryPaintBodyModel[15].addShapeBox(0F, 0F, 0F, 3, 2, 12, 0F,1F, 0F, -1F, -1F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 0F, 0F, -1F, 0F, 0F); // Box 486
		primaryPaintBodyModel[15].setRotationPoint(54F, -10F, -21F);

		primaryPaintBodyModel[16].addShapeBox(0F, 0F, 0F, 9, 3, 12, 0F,1F, 1F, -1F, -1F, -1F, -1F, 0F, -1F, 0F, 0F, 1F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -2F, 0F); // Box 487
		primaryPaintBodyModel[16].setRotationPoint(45F, -11F, -21F);

		primaryPaintBodyModel[17].addShapeBox(0F, 0F, 0F, 16, 2, 12, 0F,0F, 0F, -1F, 0F, -1F, -1F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 1F, 1F, 0F, 0F, 1F, 0F); // Box 488
		primaryPaintBodyModel[17].setRotationPoint(28F, -13F, -21F);

		primaryPaintBodyModel[18].addShapeBox(0F, 0F, 0F, 4, 2, 18, 0F,0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 489
		primaryPaintBodyModel[18].setRotationPoint(54F, -10F, -9F);

		primaryPaintBodyModel[19].addShapeBox(0F, 0F, 0F, 9, 2, 18, 0F,0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 490
		primaryPaintBodyModel[19].setRotationPoint(45F, -12F, -9F);

		primaryPaintBodyModel[20].addShapeBox(0F, 0F, 0F, 17, 2, 18, 0F,0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 491
		primaryPaintBodyModel[20].setRotationPoint(28F, -13F, -9F);

		primaryPaintBodyModel[21].addShapeBox(0F, 0F, 0F, 6, 5, 8, 0F,0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, -3.5F, -0.5F, 1F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -3.5F, -0.5F, 0F); // Box 494
		primaryPaintBodyModel[21].setRotationPoint(49F, -9F, 13F);

		primaryPaintBodyModel[22].addShapeBox(0F, 0F, 0F, 3, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -2.5F, -0.5F, 1F, -0.5F, -0.5F, 1F, -0.5F, -0.5F, 0F, -2.5F, -0.5F, 0F); // Box 495
		primaryPaintBodyModel[22].setRotationPoint(52.5F, -4.5F, 13F);

		primaryPaintBodyModel[23].addShapeBox(0F, 0F, 0F, 6, 5, 8, 0F,0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, -3.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, -0.5F, 0F, -3.5F, -0.5F, 1F); // Box 496
		primaryPaintBodyModel[23].setRotationPoint(49F, -9F, -21F);

		primaryPaintBodyModel[24].addShapeBox(0F, 0F, 0F, 3, 5, 8, 0F,0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 1F, -2.5F, -0.5F, 1F); // Box 497
		primaryPaintBodyModel[24].setRotationPoint(52.5F, -4.5F, -21F);

		primaryPaintBodyModel[25].addBox(0F, 0F, 0F, 4, 11, 42, 0F); // Box 498
		primaryPaintBodyModel[25].setRotationPoint(28F, -10F, -21F);

		primaryPaintBodyModel[26].addShapeBox(0F, 0F, 0F, 8, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F); // Box 499
		primaryPaintBodyModel[26].setRotationPoint(32F, -10F, 13F);

		primaryPaintBodyModel[27].addShapeBox(0F, 0F, 0F, 2, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 500
		primaryPaintBodyModel[27].setRotationPoint(32F, -5F, 13F);

		primaryPaintBodyModel[28].addShapeBox(0F, 0F, 0F, 8, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F); // Box 501
		primaryPaintBodyModel[28].setRotationPoint(32F, -10F, -21F);

		primaryPaintBodyModel[29].addShapeBox(0F, 0F, 0F, 2, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 1F, 0F, 0F, 1F); // Box 502
		primaryPaintBodyModel[29].setRotationPoint(32F, -5F, -21F);

		primaryPaintBodyModel[30].addShapeBox(0F, 0F, 0F, 3, 10, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 515
		primaryPaintBodyModel[30].setRotationPoint(-58F, -10F, 13F);

		primaryPaintBodyModel[31].addShapeBox(0F, 0F, 0F, 3, 10, 8, 0F,-1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 516
		primaryPaintBodyModel[31].setRotationPoint(-58F, -10F, -21F);

		primaryPaintBodyModel[32].addBox(0F, 0F, 0F, 3, 11, 42, 0F); // Box 517
		primaryPaintBodyModel[32].setRotationPoint(-32F, -10F, -21F);

		primaryPaintBodyModel[33].addBox(0F, 0F, 0F, 23, 11, 1, 0F); // Box 518
		primaryPaintBodyModel[33].setRotationPoint(-55F, -10F, -14F);

		primaryPaintBodyModel[34].addBox(0F, 0F, 0F, 23, 11, 1, 0F); // Box 519
		primaryPaintBodyModel[34].setRotationPoint(-55F, -10F, 13F);

		primaryPaintBodyModel[35].addShapeBox(0F, 0F, 0F, 22, 2, 8, 0F,0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 520
		primaryPaintBodyModel[35].setRotationPoint(-54F, -12F, 13F);

		primaryPaintBodyModel[36].addShapeBox(0F, 0F, 0F, 22, 2, 8, 0F,0F, 0F, -1F, 0F, 1F, -1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 521
		primaryPaintBodyModel[36].setRotationPoint(-54F, -12F, -21F);

		primaryPaintBodyModel[37].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F); // Box 522
		primaryPaintBodyModel[37].setRotationPoint(-58F, -12F, 13F);

		primaryPaintBodyModel[38].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F,-2F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 523
		primaryPaintBodyModel[38].setRotationPoint(-58F, -12F, -21F);

		primaryPaintBodyModel[39].addShapeBox(0F, 0F, 0F, 2, 2, 26, 0F,-0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 527
		primaryPaintBodyModel[39].setRotationPoint(-59F, -2F, -13F);

		primaryPaintBodyModel[40].addShapeBox(0F, 0F, 0F, 8, 5, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F); // Box 530
		primaryPaintBodyModel[40].setRotationPoint(-40F, -10F, 14F);

		primaryPaintBodyModel[41].addShapeBox(0F, 0F, 0F, 2, 6, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 531
		primaryPaintBodyModel[41].setRotationPoint(-34F, -5F, 14F);

		primaryPaintBodyModel[42].addShapeBox(0F, 0F, 0F, 8, 5, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, -0.5F, 0F, 0F); // Box 532
		primaryPaintBodyModel[42].setRotationPoint(-55F, -10F, 14F);

		primaryPaintBodyModel[43].addShapeBox(0F, 0F, 0F, 2, 6, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 533
		primaryPaintBodyModel[43].setRotationPoint(-55F, -5F, 14F);

		primaryPaintBodyModel[44].addShapeBox(0F, 0F, 0F, 8, 5, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F); // Box 534
		primaryPaintBodyModel[44].setRotationPoint(-40F, -10F, -21F);

		primaryPaintBodyModel[45].addShapeBox(0F, 0F, 0F, 2, 6, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 535
		primaryPaintBodyModel[45].setRotationPoint(-34F, -5F, -21F);

		primaryPaintBodyModel[46].addShapeBox(0F, 0F, 0F, 8, 5, 7, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F); // Box 536
		primaryPaintBodyModel[46].setRotationPoint(-55F, -10F, -21F);

		primaryPaintBodyModel[47].addShapeBox(0F, 0F, 0F, 2, 6, 7, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 537
		primaryPaintBodyModel[47].setRotationPoint(-55F, -5F, -21F);

		primaryPaintBodyModel[48].addShapeBox(0F, 0F, 0F, 3, 3, 42, 0F,0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 538
		primaryPaintBodyModel[48].setRotationPoint(-32F, -13F, -21F);

		primaryPaintBodyModel[49].addShapeBox(0F, 0F, 0F, 3, 3, 42, 0F,0F, 1F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 539
		primaryPaintBodyModel[49].setRotationPoint(25F, -13F, -21F);

		primaryPaintBodyModel[50].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F,4F, 0F, 1F, -4F, 0F, 1F, -4F, 0F, -1F, 4F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 540
		primaryPaintBodyModel[50].setRotationPoint(25F, -20F, 19F);

		primaryPaintBodyModel[51].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F,4F, 0F, -1F, -4F, 0F, -1F, -4F, 0F, 1F, 4F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 541
		primaryPaintBodyModel[51].setRotationPoint(25F, -20F, -21F);

		primaryPaintBodyModel[52].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F,4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 542
		primaryPaintBodyModel[52].setRotationPoint(21F, -27F, 17F);

		primaryPaintBodyModel[53].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F,4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 543
		primaryPaintBodyModel[53].setRotationPoint(21F, -27F, -19F);

		primaryPaintBodyModel[54].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F,-4F, 0F, 1F, 4F, 0F, 1F, 4F, 0F, -1F, -4F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 544
		primaryPaintBodyModel[54].setRotationPoint(-31F, -20F, 19F);

		primaryPaintBodyModel[55].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F,-4F, 0F, -1F, 4F, 0F, -1F, 4F, 0F, 1F, -4F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 545
		primaryPaintBodyModel[55].setRotationPoint(-31F, -20F, -21F);

		primaryPaintBodyModel[56].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F,-4F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 546
		primaryPaintBodyModel[56].setRotationPoint(-27F, -27F, 17F);

		primaryPaintBodyModel[57].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F,-4F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 547
		primaryPaintBodyModel[57].setRotationPoint(-27F, -27F, -19F);

		primaryPaintBodyModel[58].addShapeBox(0F, 0F, 0F, 42, 1, 2, 0F,-1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 548
		primaryPaintBodyModel[58].setRotationPoint(-23F, -28F, 17F);

		primaryPaintBodyModel[59].addShapeBox(0F, 0F, 0F, 42, 1, 2, 0F,-1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 549
		primaryPaintBodyModel[59].setRotationPoint(-23F, -28F, -19F);

		primaryPaintBodyModel[60].addShapeBox(0F, 0F, 0F, 10, 1, 34, 0F,0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 550
		primaryPaintBodyModel[60].setRotationPoint(9F, -28F, -17F);

		primaryPaintBodyModel[61].addShapeBox(0F, 0F, 0F, 20, 1, 34, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 551
		primaryPaintBodyModel[61].setRotationPoint(-23F, -28F, -17F);

		primaryPaintBodyModel[62].addBox(0F, 0F, 0F, 12, 1, 7, 0F); // Box 552
		primaryPaintBodyModel[62].setRotationPoint(-3F, -28F, -17F);

		primaryPaintBodyModel[63].addBox(0F, 0F, 0F, 12, 1, 7, 0F); // Box 553
		primaryPaintBodyModel[63].setRotationPoint(-3F, -28F, 10F);

		primaryPaintBodyModel[64].addBox(0F, 0F, 0F, 11, 1, 19, 0F); // Box 558
		primaryPaintBodyModel[64].setRotationPoint(-2.5F, -28F, -9.5F);

		primaryPaintBodyModel[65].addShapeBox(0F, 0F, 0F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 565
		primaryPaintBodyModel[65].setRotationPoint(-2.5F, -27F, 18F);

		primaryPaintBodyModel[66].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 566
		primaryPaintBodyModel[66].setRotationPoint(-2.5F, -20F, 19F);

		primaryPaintBodyModel[67].addBox(0F, 0F, 0F, 1, 10, 1, 0F); // Box 567
		primaryPaintBodyModel[67].setRotationPoint(-2.5F, -10F, 20F);

		primaryPaintBodyModel[68].addBox(0F, 0F, 0F, 1, 10, 1, 0F); // Box 568
		primaryPaintBodyModel[68].setRotationPoint(-2.5F, -10F, -21F);

		primaryPaintBodyModel[69].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 569
		primaryPaintBodyModel[69].setRotationPoint(-2.5F, -20F, -20F);

		primaryPaintBodyModel[70].addShapeBox(0F, 0F, 0F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 570
		primaryPaintBodyModel[70].setRotationPoint(-2.5F, -27F, -19F);

		primaryPaintBodyModel[71].addBox(0F, 0F, 0F, 54, 1, 1, 0F); // Box 567
		primaryPaintBodyModel[71].setRotationPoint(-29F, 0F, 20F);

		primaryPaintBodyModel[72].addBox(0F, 0F, 0F, 54, 1, 1, 0F); // Box 568
		primaryPaintBodyModel[72].setRotationPoint(-29F, 0F, -21F);
	}

	private void initsteeringWheelModel_1(){
		steeringWheelModel = new ModelRendererTurbo[18];
		steeringWheelModel[0] = new ModelRendererTurbo(this, 177, 113, textureX, textureY); // Box 711
		steeringWheelModel[1] = new ModelRendererTurbo(this, 217, 113, textureX, textureY); // Box 712
		steeringWheelModel[2] = new ModelRendererTurbo(this, 121, 121, textureX, textureY); // Box 713
		steeringWheelModel[3] = new ModelRendererTurbo(this, 281, 41, textureX, textureY); // Box 714
		steeringWheelModel[4] = new ModelRendererTurbo(this, 345, 41, textureX, textureY); // Box 715
		steeringWheelModel[5] = new ModelRendererTurbo(this, 249, 177, textureX, textureY); // Box 719
		steeringWheelModel[6] = new ModelRendererTurbo(this, 73, 185, textureX, textureY); // Box 721
		steeringWheelModel[7] = new ModelRendererTurbo(this, 385, 193, textureX, textureY); // Box 754
		steeringWheelModel[8] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 755
		steeringWheelModel[9] = new ModelRendererTurbo(this, 297, 97, textureX, textureY); // Box 756
		steeringWheelModel[10] = new ModelRendererTurbo(this, 41, 201, textureX, textureY); // Box 757
		steeringWheelModel[11] = new ModelRendererTurbo(this, 57, 201, textureX, textureY); // Box 758
		steeringWheelModel[12] = new ModelRendererTurbo(this, 73, 201, textureX, textureY); // Box 759
		steeringWheelModel[13] = new ModelRendererTurbo(this, 121, 113, textureX, textureY); // Box 760
		steeringWheelModel[14] = new ModelRendererTurbo(this, 81, 129, textureX, textureY); // Box 761
		steeringWheelModel[15] = new ModelRendererTurbo(this, 209, 201, textureX, textureY); // Box 762
		steeringWheelModel[16] = new ModelRendererTurbo(this, 345, 201, textureX, textureY); // Box 763
		steeringWheelModel[17] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 764

		steeringWheelModel[0].addBox(-1F, -1F, -1F, 1, 2, 2, 0F); // Box 711
		steeringWheelModel[0].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[1].addBox(-1F, 3F, -1F, 1, 1, 2, 0F); // Box 712
		steeringWheelModel[1].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[2].addBox(-1F, -4F, -1F, 1, 1, 2, 0F); // Box 713
		steeringWheelModel[2].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[3].addBox(-1F, -1F, 3F, 1, 2, 1, 0F); // Box 714
		steeringWheelModel[3].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[4].addBox(-1F, -1F, -4F, 1, 2, 1, 0F); // Box 715
		steeringWheelModel[4].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[5].addShapeBox(-1F, 3F, 1F, 1, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 719
		steeringWheelModel[5].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[6].addShapeBox(-1F, 2F, -0.5F, 1, 1, 3, 0F,-0.1F, 2F, -1F, -0.1F, 2F, -1F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 721
		steeringWheelModel[6].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[7].addShapeBox(-1F, 3F, 1F, 1, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 754
		steeringWheelModel[7].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[8].addShapeBox(-1F, 1F, 3F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 755
		steeringWheelModel[8].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[9].addShapeBox(-1F, -4F, 3F, 1, 3, 1, 0F,0F, -2F, 1F, 0F, -2F, 1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 756
		steeringWheelModel[9].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[10].addShapeBox(-1F, -4F, 1F, 1, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F); // Box 757
		steeringWheelModel[10].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[11].addShapeBox(-1F, -4F, -4F, 1, 1, 3, 0F,0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 758
		steeringWheelModel[11].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[12].addShapeBox(-1F, 3F, -4F, 1, 1, 3, 0F,0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 759
		steeringWheelModel[12].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[13].addShapeBox(-1F, -4F, -4F, 1, 3, 1, 0F,0F, -1F, -1F, 0F, -1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 760
		steeringWheelModel[13].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[14].addShapeBox(-1F, 1F, -4F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F); // Box 761
		steeringWheelModel[14].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[15].addShapeBox(-1F, -3F, -2.5F, 1, 1, 3, 0F,-0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F); // Box 762
		steeringWheelModel[15].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[16].addShapeBox(-1F, -3F, -0.5F, 1, 1, 3, 0F,-0.1F, -3F, 0F, -0.1F, -3F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 763
		steeringWheelModel[16].setRotationPoint(15F, -14F, 11F);

		steeringWheelModel[17].addShapeBox(-1F, 2F, -2.5F, 1, 1, 3, 0F,-0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F); // Box 764
		steeringWheelModel[17].setRotationPoint(15F, -14F, 11F);
	}
}