package com.flansmod.client.model;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.lib.tmt.ModelConverter;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand (FEX___96)
 *
 */
public class ModelConstructionBlock extends ModelConverter {
	
	int textureX = 256;
	int textureY = 256;

	public ModelConstructionBlock(){
		
		bodyModel = new ModelRendererTurbo[13];
		bodyModel[0] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 5
		bodyModel[1] = new ModelRendererTurbo(this, 105, 1, textureX, textureY); // Box 6
		bodyModel[2] = new ModelRendererTurbo(this, 145, 1, textureX, textureY); // Box 7
		bodyModel[3] = new ModelRendererTurbo(this, 185, 1, textureX, textureY); // Box 8
		bodyModel[4] = new ModelRendererTurbo(this, 121, 9, textureX, textureY); // Box 9
		bodyModel[5] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // Box 10
		bodyModel[6] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // Box 11
		bodyModel[7] = new ModelRendererTurbo(this, 225, 1, textureX, textureY); // Box 12
		bodyModel[8] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 13
		bodyModel[9] = new ModelRendererTurbo(this, 33, 1, textureX, textureY); // Box 14
		bodyModel[10] = new ModelRendererTurbo(this, 233, 1, textureX, textureY); // Box 15
		bodyModel[11] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // Box 16
		bodyModel[12] = new ModelRendererTurbo(this, 209, 9, textureX, textureY); // Box 17

		bodyModel[0].addBox(0F, 0F, 0F, 16, 23, 14, 0F); // Box 5
		bodyModel[0].setRotationPoint(-8F, -23F, -6F);

		bodyModel[1].addBox(0F, 0F, 0F, 15, 6, 1, 0F); // Box 6
		bodyModel[1].setRotationPoint(-7.5F, -7.5F, -7F);

		bodyModel[2].addBox(0F, 0F, 0F, 15, 6, 1, 0F); // Box 7
		bodyModel[2].setRotationPoint(-7.5F, -14.5F, -7F);

		bodyModel[3].addBox(0F, 0F, 0F, 15, 6, 1, 0F); // Box 8
		bodyModel[3].setRotationPoint(-7.5F, -21.5F, -7F);

		bodyModel[4].addBox(0F, 0F, 0F, 17, 1, 16, 0F); // Box 9
		bodyModel[4].setRotationPoint(-8.5F, -24F, -7.5F);

		bodyModel[5].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 10
		bodyModel[5].setRotationPoint(-2F, -6F, -7.5F);

		bodyModel[6].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 11
		bodyModel[6].setRotationPoint(-2F, -13F, -7.5F);

		bodyModel[7].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 12
		bodyModel[7].setRotationPoint(-2F, -20F, -7.5F);

		bodyModel[8].addShapeBox(0F, 0F, 0F, 10, 2, 5, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 13
		bodyModel[8].setRotationPoint(-7F, -25.5F, -5F);

		bodyModel[9].addBox(0F, 0F, 0F, 2, 1, 3, 0F); // Box 14
		bodyModel[9].setRotationPoint(5F, -25F, -5F);

		bodyModel[10].addShapeBox(0F, 0F, 0F, 5, 1, 4, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F); // Box 15
		bodyModel[10].setRotationPoint(-2.5F, -25F, 3F);

		bodyModel[11].addBox(0F, 0F, 0F, 2, 6, 1, 0F); // Box 16
		bodyModel[11].setRotationPoint(-1F, -31F, 5F);

		bodyModel[12].addBox(0F, 0F, 0F, 14, 10, 1, 0F); // Box 17
		bodyModel[12].setRotationPoint(-7F, -36F, 5F);
		bodyModel[12].rotateAngleX = -0.08726646F;


		turretModel = new ModelRendererTurbo[5];
		turretModel[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		turretModel[1] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 1
		turretModel[2] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 2
		turretModel[3] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // Box 3
		turretModel[4] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // Box 4

		turretModel[0].addBox(0F, 0F, 0F, 16, 1, 1, 0F); // Box 0
		turretModel[0].setRotationPoint(-8F, -1F, -3F);

		turretModel[1].addBox(0F, 0F, 0F, 16, 1, 1, 0F); // Box 1
		turretModel[1].setRotationPoint(-8F, -1F, 2F);

		turretModel[2].addShapeBox(0F, 0F, 0F, 16, 1, 8, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 2
		turretModel[2].setRotationPoint(-8F, -2F, -4F);

		turretModel[3].addShapeBox(0F, 0.5F, 0F, 16, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 3
		turretModel[3].setRotationPoint(-8F, -3F, -4F);

		turretModel[4].addShapeBox(0F, 0.5F, 0F, 16, 1, 1, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 4
		turretModel[4].setRotationPoint(-8F, -3F, 3F);
		
		translateAll(0F, 24F, 0F);
		
		//flipAll();
		
	}
	
	private static final ResourceLocation texture = new ResourceLocation(FlansMod.MODID, "textures/blocks/constructionblock.png");

	public ResourceLocation getTexture(){
		return texture;
	}
	
}