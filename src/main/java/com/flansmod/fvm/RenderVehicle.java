package com.flansmod.fvm;

import org.lwjgl.opengl.GL11;

import com.flansmod.common.FlansMod;

import net.fexcraft.mod.fvm.data.PartType;
import net.fexcraft.mod.fvm.models.VehicleModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderVehicle extends Render implements IRenderFactory {
	
	public RenderVehicle(RenderManager renderManager) {
		super(renderManager);
		shadowSize = 0.5F;
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void bindTexture(Entity ent){
		super.bindEntityTexture(ent);
	}
	
	public void bindTexture(ResourceLocation rs){
		super.bindTexture(rs);
	}
	
    public void render(LandVehicle vehicle, double d, double d1, double d2, float f, float f1){
    	if(vehicle.data == null){
    		return;
    	}
    	bindEntityTexture(vehicle);
        GL11.glPushMatrix();
        {
		    GL11.glTranslatef((float)d, (float)d1 /*+ -(vehicle.data.construction_height_offset * 0.0625)*/, (float)d2);
		    float dYaw = (vehicle.axes.getYaw() - vehicle.prevRotationYaw);
		    for(; dYaw > 180F; dYaw -= 360F) {}
		    for(; dYaw <= -180F; dYaw += 360F) {}
		    float dPitch = (vehicle.axes.getPitch() - vehicle.prevRotationPitch);
		    for(; dPitch > 180F; dPitch -= 360F) {}
		    for(; dPitch <= -180F; dPitch += 360F) {}
		    float dRoll = (vehicle.axes.getRoll() - vehicle.prevRotationRoll);
		    for(; dRoll > 180F; dRoll -= 360F) {}
		    for(; dRoll <= -180F; dRoll += 360F) {}
		    GL11.glRotatef(180F - vehicle.prevRotationYaw - dYaw * f1, 0.0F, 1.0F, 0.0F);
		    GL11.glRotatef(vehicle.prevRotationPitch + dPitch * f1, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(vehicle.prevRotationRoll + dRoll * f1, 1.0F, 0.0F, 0.0F);
			//GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
        	GL11.glRotatef(180f, 0f, 0f, 1f);
			
			float modelScale = vehicle.data.scale;
			GL11.glPushMatrix();
			{
				GL11.glScalef(modelScale, modelScale, modelScale);
				VehicleModel modVehicle = (VehicleModel)vehicle.data.getModel();
				if(modVehicle != null){
					modVehicle.render(vehicle.data);
					if(vehicle.data.parts.size() > 0){
						for(String key : vehicle.data.parts.keySet()){
							PartType part = vehicle.data.parts.get(key);
							Minecraft.getMinecraft().renderEngine.bindTexture(part.textures.get(vehicle.data.current_texture));
							part.translate(vehicle.data.registryname);
							part.getModel().render(vehicle.data, key, vehicle);
							part.translateR(vehicle.data.registryname);
						}
					}
				}
			}
			GL11.glPopMatrix();
			
			if(FlansMod.DEBUG){
				GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glColor4f(1F, 0F, 0F, 0.3F);
				GL11.glScalef(1F, 1F, 1F);
				/*for(DriveablePart part : vehicle.getDriveableData().parts.values()){
					if(part.box == null){
						continue;
					}
					
					renderOffsetAABB(new AxisAlignedBB(part.box.x, part.box.y, part.box.z, (part.box.x + part.box.w), (part.box.y + part.box.h), (part.box.z + part.box.d)), 0, 0, 0);
				}*/
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glColor4f(1F, 1F, 1F, 1F);
			}
		}
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity){
		return ((LandVehicle)entity).data.getTexture();
	}
	
	@SubscribeEvent
	public void renderWorld(RenderWorldLastEvent event){
		//Get the world
		World world = Minecraft.getMinecraft().world;
		if(world == null)
			return;

		//Get the camera frustrum for clipping
        Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
        double x = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * event.getPartialTicks();
        double y = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * event.getPartialTicks();
        double z = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * event.getPartialTicks();
        
        //Frustum frustrum = new Frustum();
        //frustrum.setPosition(x, y, z);
        
        //Push
        GL11.glPushMatrix();
        //Setup lighting
        Minecraft.getMinecraft().entityRenderer.enableLightmap();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        
        RenderHelper.enableStandardItemLighting();
        
        GL11.glTranslatef(-(float)x, -(float)y, -(float)z);
		for(Object entity : world.loadedEntityList)
		{
			if(entity instanceof LandVehicle)
			{
				LandVehicle vehicle = (LandVehicle)entity;
		        int i = vehicle.getBrightnessForRender(event.getPartialTicks());

		        if (vehicle.isBurning())
		        {
		            i = 15728880;
		        }

		        int j = i % 65536;
		        int k = i / 65536;
		        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
		        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		        render(vehicle, vehicle.prevPosX + (vehicle.posX - vehicle.prevPosX) * event.getPartialTicks(), vehicle.prevPosY + (vehicle.posY - vehicle.prevPosY) * event.getPartialTicks(), vehicle.prevPosZ + (vehicle.posZ - vehicle.prevPosZ) * event.getPartialTicks(), 0F, event.getPartialTicks());
			}
		}
		
		//Reset Lighting
		Minecraft.getMinecraft().entityRenderer.disableLightmap();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		//Pop
		GL11.glPopMatrix();
	}

	@Override
	public Render createRenderFor(RenderManager manager){
		return new RenderVehicle(manager);
	}
	
}