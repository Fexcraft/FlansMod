package com.flansmod.common.blocks;

import org.lwjgl.opengl.GL11;

import com.flansmod.client.model.ModelConstructionBlock;
import com.flansmod.common.FlansMod;
import com.flansmod.common.blocks.CenterBlock.CBE;
import com.flansmod.common.data.DriveableType;
import com.flansmod.common.items.ItemVehicle;

import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.fexcraft.mod.lib.util.common.Print;
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
		if(!p.getHeldItemMainhand().isEmpty()){
			if(p.getHeldItemMainhand().getItem() instanceof ItemVehicle){
				((VCBE)w.getTileEntity(pos)).type = ((ItemVehicle)p.getHeldItemMainhand().getItem()).type;
				Print.chat(p, "Vehicle: " + ((ItemVehicle)p.getHeldItemMainhand().getItem()).type.name);
				return true;
			}
		}
		else{
			if(w.getTileEntity(pos) != null){
				VCBE te = (VCBE)w.getTileEntity(pos);
				if(!te.linked){
					Print.chat(p, "Scanning...");
					int x = pos.getX() - 8;
					int y = pos.getY();
					int z = pos.getZ() - 8;
					for(int i = 0; i < 16; i++){
						for(int j = 0; j < 16; j++){
							TileEntity tile = w.getTileEntity(new BlockPos(x + i, y, z + j));
							if(tile != null && tile instanceof CBE){
								if(((CBE)tile).link == null){
									((CBE)tile).link(pos);
									te.linked = true;
									Print.chat(p, "Connected! " + ((CBE)tile).getPos().toString());
									break;
								}
							}
							if(!te.linked){
								tile = w.getTileEntity(new BlockPos(x + i, y - 1, z + j));
								if(tile != null && tile instanceof CBE){
									if(((CBE)tile).link == null){
										((CBE)tile).link(pos);
										te.linked = true;
										Print.chat(p, "Connected! " + ((CBE)tile).getPos().toString());
										break;
									}
								}
							}
							if(!te.linked){
								tile = w.getTileEntity(new BlockPos(x + i, y + 1, z + j));
								if(tile != null && tile instanceof CBE){
									if(((CBE)tile).link == null){
										((CBE)tile).link(pos);
										te.linked = true;
										Print.chat(p, "Connected! " + ((CBE)tile).getPos().toString());
										break;
									}
								}
							}
						}
					}
				}
			}
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
		private boolean linked;
		
		public DriveableType getType(){
			return type;
		}

		public boolean isTypeNull(){
			return type == null;
		}
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
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	    }
	}
	
}