package com.flansmod.client.model;

import java.util.Collections;

import com.flansmod.client.model.OverrideVanillaModelLoader.BakedIconBasedModel;
import com.flansmod.common.types.IFlanItem;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CustomModelOverrideList extends ItemOverrideList
{
    public static final CustomModelOverrideList INSTANCE = new CustomModelOverrideList();

    private CustomModelOverrideList()
    {
        super(Collections.emptyList());
    }

    @Override
    public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, World world, EntityLivingBase entity)
    {

        BakedIconBasedModel bakedModel = ((BakedIconBasedModel) originalModel);
        OverrideVanillaModelLoader.OverrideModelState state = bakedModel.getState();
        state.setItem(((IFlanItem)stack.getItem()));
        state.setStack(stack);
        state.setEntity(entity);
        state.setWorld(world);
        /*
        FlansMod.log("itemp=" + perspective);

        if (perspective == TransformType.NONE)
        {
           return originalModel;
        }
        if (stack.getItem() instanceof IFlanItem)
        {
            RenderCustomItem renderer = ClientProxy.getRenderer(((IFlanItem) stack.getItem()));
            if (renderer != null)
            {
                renderer.renderPerspective(bakedModel.getState().getPerspective(), entity, stack, world);
            }
        }
        */
        return originalModel;
    }

}
