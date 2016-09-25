package com.flansmod.client;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.IRetexturableModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.TRSRTransformation;

import static net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND;
import static net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND;
import static net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND;

public class RenderUtils
{
    public static EnumHandSide getSide(ItemCameraTransforms.TransformType transformType)
    {
        return transformType == FIRST_PERSON_LEFT_HAND || transformType == THIRD_PERSON_LEFT_HAND ?
                EnumHandSide.LEFT : EnumHandSide.RIGHT;
    }

    public static boolean isFirstPerson(ItemCameraTransforms.TransformType transformType)
    {
        return transformType == FIRST_PERSON_LEFT_HAND || transformType == FIRST_PERSON_RIGHT_HAND;
    }
    public static final String defaultMaterialName = "None";



    private static IRetexturableModel model2D;
    static
    {
        try
        {
            model2D = (IRetexturableModel) ModelLoaderRegistry.getModel(new ResourceLocation("item/generated"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Returns a 2D icon from a resourceLocation.
     */
    public static IBakedModel getIcon(ResourceLocation location, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
    {
        IModel model2 = model2D.retexture(ImmutableMap.of("layer0", location.toString()));
        return model2.bake(TRSRTransformation.identity(), DefaultVertexFormats.ITEM, bakedTextureGetter);
    }
}
