package com.flansmod.client.model;

import com.flansmod.client.ClientProxy;
import com.flansmod.client.RenderUtils;
import com.flansmod.common.FlansMod;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.Paintjob;
import com.flansmod.common.types.IFlanItem;
import com.flansmod.common.types.IPaintableItem;
import com.flansmod.common.vector.Radian;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.model.IModelPart;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * ModelLoader that pretends to load vanilla json files.
 */
public class OverrideVanillaModelLoader implements ICustomModelLoader
{
    public static final OverrideVanillaModelLoader INSTANCE = new OverrideVanillaModelLoader();

    private final HashMap<ResourceLocation, ResourceLocation> acceptedIcons = new HashMap<>();

    private IResourceManager resourceManager;

    private OverrideVanillaModelLoader() {}

    @Override
    public boolean accepts(ResourceLocation modelLocation)
    {
        //TODO : possibly check if resource exists.
        return acceptedIcons.containsKey(modelLocation);
    }

    @Override
    public void onResourceManagerReload(@Nonnull IResourceManager resourceManager)
    {
        this.resourceManager = resourceManager;
    }
    
    public void setPaintJobIcons(Item item){
        for(Paintjob paintjob : ((IPaintableItem<GunType>)item).getInfoType().paintjobs){
            ModelResourceLocation modelLocation = new ModelResourceLocation(((IPaintableItem<GunType>)item).getInfoType().item.getRegistryName() + "_" +  paintjob.name, "inventory");
			ModelLoader.setCustomModelResourceLocation(item, paintjob.ID, modelLocation);
            OverrideVanillaModelLoader.INSTANCE.setCustomIcon(modelLocation, new ResourceLocation(FlansMod.MODID, "items/" + paintjob.iconPath));
        }
    }

    public void setCustomIcon(ModelResourceLocation model, ResourceLocation icon)
    {
        acceptedIcons.put(new ResourceLocation(model.getResourceDomain(), "models/item/" + model.getResourcePath()), icon);
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) throws Exception
    {
        return new IconBasedModel(acceptedIcons.get(modelLocation));
    }

    private static class IconBasedModel implements IModel
    {
        private final ResourceLocation iconLocation;
        private IconBasedModel(ResourceLocation iconLocation)
        {
            this.iconLocation = iconLocation;
        }

        @Override
        public Collection<ResourceLocation> getDependencies()
        {
            return Collections.emptyList();
        }

        @Override
        public IModelState getDefaultState()
        {
            return new OverrideModelState();
        }

        @Override
        public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
        {
            return new BakedIconBasedModel(iconLocation, bakedTextureGetter, new OverrideModelState());
        }

        @Override
        public Collection<ResourceLocation> getTextures()
        {
            return Collections.singleton(iconLocation);
        }

    }

    static class BakedIconBasedModel implements IPerspectiveAwareModel
    {
        private final OverrideModelState state;
        private final ResourceLocation iconLocation;
        private final Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter;

        private BakedIconBasedModel(ResourceLocation iconLocation, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter, OverrideModelState state)
        {
            this.iconLocation = iconLocation;
            this.bakedTextureGetter = bakedTextureGetter;
            this.state = state;
        }

        @Override @Nonnull
        public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand)
        {
            return Collections.emptyList();
        }

        @Override @Nonnull
        public ItemCameraTransforms getItemCameraTransforms()
        {
            return ItemCameraTransforms.DEFAULT;
        }


        private static TRSRTransformation thirdPersonTransformation = new TRSRTransformation(new Vector3f(0,0,0), TRSRTransformation.quatFromXYZ(Radian.d180,Radian.d180,Radian.d180), new Vector3f(1,1,1), new Quat4f(0,0,0,1));
        private Pair<IBakedModel, Matrix4f> cache2D = null;
        @Override
        public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType perspective)
        {
            RenderCustomItem renderer = ClientProxy.getRenderer(state.item);
            if (renderer.canRender(perspective))
            {
                renderer.renderPerspective(perspective, state.entity, state.stack, state.world);
            }
            else
            {
                switch (perspective)
                {
                    case GUI:
                        if (cache2D == null)
                        {
                            cache2D = Pair.of(RenderUtils.getIcon(iconLocation, bakedTextureGetter), null);
                        }
                        return cache2D;
                    //default:
                    case THIRD_PERSON_RIGHT_HAND:
                    case THIRD_PERSON_LEFT_HAND:

                        break;
                    default:

                        break;
                }
            }
            return Pair.of(this, null);
        }

        @Override
        public boolean isBuiltInRenderer()
        {
            return false;
        }

        @Override @Nonnull
        public TextureAtlasSprite getParticleTexture()
        {
            return ModelLoader.White.INSTANCE;
        }

        @Override @Nonnull
        public ItemOverrideList getOverrides()
        {
            return CustomModelOverrideList.INSTANCE;
        }

        @Override
        public boolean isGui3d()
        {
            return false;
        }

        @Override
        public boolean isAmbientOcclusion()
        {
            return false;
        }

        public OverrideModelState getState()
        {
            return state;
        }
    }
    public static class OverrideModelState implements IModelState
    {
        private IFlanItem item;
        private ItemStack stack;
        private EntityLivingBase entity;
        private World world;

        public void setItem(IFlanItem item)
        {
            this.item = item;
        }

        public void setStack(ItemStack stack)
        {
            this.stack = stack;
        }

        public void setWorld(World world)
        {
            this.world = world;
        }

        public void setEntity(EntityLivingBase entity)
        {
            this.entity = entity;
        }

        @Override
        public Optional<TRSRTransformation> apply(Optional<? extends IModelPart> part)
        {
            return Optional.absent();
        }
    }
}
