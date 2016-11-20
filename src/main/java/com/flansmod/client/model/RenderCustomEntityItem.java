package com.flansmod.client.model;

import static net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.GROUND;

import java.util.Random;

import com.flansmod.client.ClientProxy;
import com.flansmod.common.EntityCustomItem;
import com.flansmod.common.types.IFlanItem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Used to render ItemEntities with models.
 */
public class RenderCustomEntityItem extends RenderEntityItem implements IRenderFactory<EntityCustomItem>
{

    Random random = new Random();
    public RenderCustomEntityItem(RenderManager manager)
    {
        super(manager, Minecraft.getMinecraft().getRenderItem());

    }

    @Override
    public Render<? super EntityCustomItem> createRenderFor(RenderManager manager)
    {
        return new RenderCustomEntityItem(manager);
    }

    private int transformModelCount(EntityItem itemIn, double p_177077_2_, double p_177077_4_, double p_177077_6_, float p_177077_8_)
    {
        ItemStack itemstack = itemIn.getEntityItem();
        Item item = itemstack.getItem();

        if (item == null)
        {
            return 0;
        }
        else
        {

            int i = this.getModelCount(itemstack);
            float f = 0.25F;
            float f1 = shouldBob() ? MathHelper.sin(((float)itemIn.getAge() + p_177077_8_) / 10.0F + itemIn.hoverStart) * 0.1F + 0.1F : 0;
            float f2 = 1;//p_177077_9_.getItemCameraTransforms().getTransform(ItemCameraTransforms.TransformType.GROUND).scale.y;
            GlStateManager.translate((float)p_177077_2_, (float)p_177077_4_ + f1 + 0.25F * f2, (float)p_177077_6_);

            if (this.renderManager.options != null)
            {
                float f3 = (((float)itemIn.getAge() + p_177077_8_) / 20.0F + itemIn.hoverStart) * (180F / (float)Math.PI);
                GlStateManager.rotate(f3, 0.0F, 1.0F, 0.0F);
            }

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            return i;
        }
    }

    public void doRender(EntityItem entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        RenderCustomItem renderer = ClientProxy.getRenderer(((IFlanItem) (entity).getEntityItem().getItem()));
        ItemStack itemstack = entity.getEntityItem();
        int i=  Item.getIdFromItem(itemstack.getItem()) + itemstack.getMetadata();
        this.random.setSeed((long)i);


        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(516, 0.1F);
        GlStateManager.enableBlend();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.pushMatrix();
        int j = this.transformModelCount(entity, x, y, z, partialTicks);
        /*
        boolean flag1 = true;

        if (!flag1)
        {
            float f3 = -0.0F * (float)(j - 1) * 0.5F;
            float f4 = -0.0F * (float)(j - 1) * 0.5F;
            float f5 = -0.09375F * (float)(j - 1) * 0.5F;
            GlStateManager.translate(f3, f4, f5);
        }
        */

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        for (int k = 0; k < j; ++k)
        {

            GlStateManager.pushMatrix();

            if (k > 0)
            {
                float f7 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
                float f9 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
                float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
                GlStateManager.translate(shouldSpreadItems() ? f7 : 0, shouldSpreadItems() ? f9 : 0, f6);
            }

            //renderer.renderItemEntity(entity,x,y,z, entityYaw, partialTicks);
            renderer.renderPerspective(GROUND, null, itemstack, entity.worldObj);
            GlStateManager.popMatrix();
        }

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
        this.bindEntityTexture(entity);


        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

}
