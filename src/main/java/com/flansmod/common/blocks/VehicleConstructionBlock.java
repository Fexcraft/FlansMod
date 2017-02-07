package com.flansmod.common.blocks;

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelConstructionBlock;
import com.flansmod.client.model.ModelVehicle;
import com.flansmod.common.FlansMod;
import com.flansmod.common.data.DriveableType;
import com.flansmod.common.items.ItemVehicle;

import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fBlock(modid = FlansMod.MODID, name = "vehicle_construction_block", tileentity = VehicleConstructionBlock.VCBE.class)
public class VehicleConstructionBlock extends BlockContainer {

	public VehicleConstructionBlock(){
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
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!p.getHeldItemMainhand().isEmpty() && p.getHeldItemMainhand().getItem() instanceof ItemVehicle){
			((VCBE)w.getTileEntity(pos)).type = ((ItemVehicle)p.getHeldItemMainhand().getItem()).type;
			return true;
		}
		return false;
    }

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new VCBE();
	}
	
	public static class VCBE extends TileEntity {
		public DriveableType type = null;
	}
	
	@fTESR(tileentity = VehicleConstructionBlock.VCBE.class)
	public static class VCBR extends TileEntitySpecialRenderer {
		
		private static final ModelConstructionBlock model = new ModelConstructionBlock();
		
		@Override
		public void renderTileEntityAt(TileEntity tileentity, double posX, double posY, double posZ, float partialticks, int destroystage){
	    	GL11.glPushMatrix();
			GL11.glTranslated(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
			Minecraft.getMinecraft().renderEngine.bindTexture(model.getTexture());
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotated(90 , 0, 1D, 0);
			model.render(model.bodyModel);
			VCBE te = (VCBE)tileentity;
			if(te.type != null){
				ModelVehicle modvec = (ModelVehicle)te.type.model;
				if(modvec != null){
					Minecraft.getMinecraft().renderEngine.bindTexture(te.type.textures.get(0));
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
			GL11.glTranslatef(0, 0, 1);
			GL11.glTranslatef(6, 0, 0);
			for(int i = 0; i < 11; i++){
				GL11.glTranslatef(-1, 0, 0);
				model.render(model.turretModel);
			}
			GL11.glTranslatef(0, 0, 3);
			for(int i = 0; i < 11; i++){
				model.render(model.turretModel);
				GL11.glTranslatef(1, 0, 0);
			}
			
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	    }
	}
	
}