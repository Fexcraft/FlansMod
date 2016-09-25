package com.flansmod.client.model;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface RenderCustomItem
{
    void renderPerspective(ItemCameraTransforms.TransformType perspective, EntityLivingBase entity, ItemStack stack, World world);
    boolean canRender(ItemCameraTransforms.TransformType perspective);
}
