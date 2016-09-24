package com.flansmod.client.model;

import com.flansmod.client.ClientProxy;
import com.flansmod.common.FlansMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGunItem extends RenderEntityItem implements IRenderFactory
{
	@Override
	public Render createRenderFor(RenderManager manager)
	{
		return new RenderGunItem(manager, Minecraft.getMinecraft().getRenderItem(), ClientProxy.gunRenderer);
	}

	private RenderGun gunRenderer;

	public RenderGunItem(RenderManager manager)
	{
		super(manager, Minecraft.getMinecraft().getRenderItem());
	}
	public RenderGunItem(RenderManager renderManager, RenderItem renderItem, RenderGun gunRenderer) 
	{
		super(renderManager, renderItem);
		this.gunRenderer = gunRenderer;
	}

	@Override
	public void doRender(EntityItem entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		FlansMod.log("test123");
		super.doRender(entity, x, y, z, entityYaw, partialTicks);

	}


	/*@Override
    public void func_177075_a(EntityItem entity, double x, double y, double z, float p_177075_8_, float partialTicks)
    {
        ItemStack stack = entity.getEntityItem();
        
        if(stack.getItem() instanceof ItemGun && ((ItemGun)stack.getItem()).GetType().model != null)
        {
        	GlStateManager.pushMatrix();
        	GlStateManager.translate(x, y + 0.25D, z);
        	GlStateManager.rotate(entity.ticksExisted + partialTicks, 0F, 1F, 0F);
        	
        	gunRenderer.renderItem(ItemRenderType.ENTITY, stack);
        	GlStateManager.popMatrix();
        }
        else
        {
        	super.func_177075_a(entity, x, y, z, p_177075_8_, partialTicks);
        } 
    }*/
}
