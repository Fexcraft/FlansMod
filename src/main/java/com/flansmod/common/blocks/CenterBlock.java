package com.flansmod.common.blocks;

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelConstructionBlock;
import com.flansmod.client.model.ModelVehicle;
import com.flansmod.common.FlansMod;
import com.flansmod.common.blocks.VehicleConstructionBlock.VCBE;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fBlock(modid = FlansMod.MODID, name = "central_construction_block", tileentity = CenterBlock.CBE.class)
public class CenterBlock extends BlockContainer {

	public CenterBlock(){
		super(Material.IRON, MapColor.GRAY);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	@Override
	public boolean isFullyOpaque(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
        return false;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new CBE();
	}
	
	public static class CBE extends TileEntity {
		public VCBE link = null;
		private int offset = 24;
		private int length = 4;
		private BlockPos remote;
		
		public CBE(){
			//
		}
		
		private int getRenderLength(){
			return (length * 2) + 1;
		}
		
		private float getRenderOffset(){
			return offset * 0.0625f;
		}

		public boolean isLinked(){
			return link == null;
		}

		public void link(BlockPos pos) {
			remote = pos;
			link = (VCBE)world.getTileEntity(pos);
		}

		public boolean hasType(){
			if(link != null){
				return !link.isTypeNull();
			}
			return false;
		}
		
	}
	
	@fTESR(tileentity = CenterBlock.CBE.class)
	public static class CBR extends TileEntitySpecialRenderer {
		
		private static final ModelConstructionBlock model = new ModelConstructionBlock();
		
		@Override
		public void renderTileEntityAt(TileEntity tileentity, double posX, double posY, double posZ, float partialticks, int destroystage){
	    	GL11.glPushMatrix();
			GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
			Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotated(90 , 0, 1D, 0);
			CBE te = (CBE)tileentity;
			//
			GL11.glTranslatef(0, 0, te.getRenderOffset());
			GL11.glTranslatef(te.length + 1, 0, 0);
			for(int i = 0; i < te.getRenderLength(); i++){
				GL11.glTranslatef(-1, 0, 0);
				model.render(model.turretModel);
			}
			GL11.glTranslatef(0, 0, -(te.getRenderOffset() * 2));
			for(int i = 0; i < te.getRenderLength(); i++){
				model.render(model.turretModel);
				GL11.glTranslatef(1, 0, 0);
			}
			GL11.glTranslatef(-te.length, 0, 0);
			//
			if(te.hasType()){
				ModelVehicle modvec = (ModelVehicle)te.link.type.getModel();
				if(modvec != null){
					Minecraft.getMinecraft().renderEngine.bindTexture(te.link.type.textures.get(0));
					GL11.glRotatef(-180F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0, -1, 2.25f);
					modvec.renderPart(modvec.bodyModel);
					modvec.renderPart(modvec.leftFrontWheelModel);
					modvec.renderPart(modvec.rightFrontWheelModel);
					modvec.renderPart(modvec.leftBackWheelModel);
					modvec.renderPart(modvec.rightBackWheelModel);
					modvec.renderPart(modvec.primaryPaintBodyModel);
					modvec.renderPart(modvec.secondaryPaintBodyModel);
					modvec.renderPart(modvec.steeringWheelModel);
					modvec.renderPart(modvec.bodyDoorCloseModel);
					modvec.renderPart(modvec.primaryPaintBodyDoorCloseModel);
					GL11.glTranslatef(0, 1, -2.5f);
					GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
					Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
				}
			}
			//
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	    }
	}
	
}