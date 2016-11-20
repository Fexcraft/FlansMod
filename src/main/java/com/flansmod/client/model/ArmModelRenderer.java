package com.flansmod.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.flansmod.common.FlansUtils;
import com.flansmod.common.ReflectionUtils;
import com.flansmod.common.vector.Vector3f;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.EnumHandSide;

public class ArmModelRenderer extends ModelRenderer
{

    //Modifications
    private Vector3f rotationOverrides;

    private boolean shouldMakeChanges = true;

    private ModelRenderer original;

    public void setShouldMakeChanges(boolean shouldMakeChanges)
    {
        this.shouldMakeChanges = shouldMakeChanges;
    }

    public void setRotationOverrides(@Nullable Vector3f rotationOverrides)
    {
        this.rotationOverrides = rotationOverrides;
    }

    public ModelRenderer getOriginal()
    {
        return original;
    }

    public ArmModelRenderer(ModelBase modelBase, ModelRenderer arm)
    {
        super(modelBase);
        original = arm;
        FlansUtils.copy(original, this);
    }

    private void applyModifications()
    {
        if (shouldMakeChanges)
        {
            if (rotationOverrides != null)
            {
                rotateAngleX = rotationOverrides.x;
                rotateAngleY = rotationOverrides.y;
                rotateAngleZ = rotationOverrides.z;
            }
        }
    }

    //custom render methods
    @Override
    public void render(float scale)
    {
        applyModifications();
        super.render(scale);
    }

    @Override
    public void postRender(float scale)
    {
        applyModifications();
        super.postRender(scale);
    }

    @Override
    public void renderWithRotation(float scale)
    {
        applyModifications();
        super.renderWithRotation(scale);
    }

    public static List<ArmModelRenderer> getModelsForSide(EnumHandSide side, RenderLivingBase renderer, ModelBiped modelBiped)
    {
        return side == EnumHandSide.RIGHT ?
                getRightArm(renderer, modelBiped) : getLeftArm(renderer, modelBiped);
    }

    public static List<ArmModelRenderer> getRightArm(RenderLivingBase renderer, ModelBiped modelBase)
    {
        List<ArmModelRenderer> result = new ArrayList<ArmModelRenderer>();
        if (!(modelBase.bipedRightArm instanceof ArmModelRenderer))
        {
            modelBase.bipedRightArm = new ArmModelRenderer(modelBase, modelBase.bipedRightArm);
        }
        result.add((ArmModelRenderer) modelBase.bipedRightArm);

        //armors
        List<LayerRenderer> layerRenderers = ReflectionUtils.getValue(RenderLivingBase.class, renderer, "layerRenderers");
        for (LayerRenderer layerRenderer : layerRenderers)
        {
            if (!(layerRenderer instanceof LayerArmorBase))
            {
                continue;
            }
            LayerArmorBase armor = (LayerArmorBase) layerRenderer;
            ModelBase armorModel = armor.getModelFromSlot(EntityEquipmentSlot.CHEST);
            if (!(armorModel instanceof ModelBiped))
            {
                continue;
            }
            ModelBiped armorModelBase = (ModelBiped) armorModel;
            if (!(armorModelBase.bipedRightArm instanceof ArmModelRenderer))
            {
                armorModelBase.bipedRightArm = new ArmModelRenderer(modelBase, armorModelBase.bipedRightArm);
            }
            result.add((ArmModelRenderer) armorModelBase.bipedRightArm);

        }
        //players have an additional skin layer that needs to be modified.
        if (modelBase instanceof ModelPlayer)
        {
            ModelPlayer modelPlayer = (ModelPlayer) modelBase;
            if (!(modelPlayer.bipedRightArmwear instanceof ArmModelRenderer))
            {
                modelPlayer.bipedRightArmwear = new ArmModelRenderer(modelBase, modelPlayer.bipedRightArmwear);
            }
            result.add((ArmModelRenderer) modelPlayer.bipedRightArmwear);
        }
        return result;
    }

    public static List<ArmModelRenderer> getLeftArm(RenderLivingBase renderer, ModelBiped modelBase)
    {
        List<ArmModelRenderer> result = new ArrayList<ArmModelRenderer>();

        if (!(modelBase.bipedLeftArm instanceof ArmModelRenderer))
        {
            modelBase.bipedLeftArm = new ArmModelRenderer(modelBase, modelBase.bipedLeftArm);
        }
        result.add((ArmModelRenderer) modelBase.bipedLeftArm);

        //armors
        List<LayerRenderer> layerRenderers = ReflectionUtils.getValue(RenderLivingBase.class, renderer, "layerRenderers");
        for (LayerRenderer layerRenderer : layerRenderers)
        {
            if (!(layerRenderer instanceof LayerArmorBase))
            {
                continue;
            }
            LayerArmorBase armor = (LayerArmorBase) layerRenderer;
            ModelBase armorModel = armor.getModelFromSlot(EntityEquipmentSlot.CHEST);
            if (!(armorModel instanceof ModelBiped))
            {
                continue;
            }
            ModelBiped armorModelBase = (ModelBiped) armorModel;
            if (!(armorModelBase.bipedLeftArm instanceof ArmModelRenderer))
            {
                armorModelBase.bipedLeftArm = new ArmModelRenderer(modelBase, armorModelBase.bipedLeftArm);
            }
            result.add((ArmModelRenderer) armorModelBase.bipedLeftArm);

        }
        //players have an additional skin layer that needs to be modified.
        if (modelBase instanceof ModelPlayer)
        {
            ModelPlayer modelPlayer = (ModelPlayer) modelBase;
            //left arm
            if (!(modelPlayer.bipedLeftArmwear instanceof ArmModelRenderer))
            {
                modelPlayer.bipedLeftArmwear = new ArmModelRenderer(modelBase, modelPlayer.bipedLeftArmwear);
            }
            result.add((ArmModelRenderer) modelPlayer.bipedLeftArmwear);

        }
        return result;
    }

    public static void removeRightArm(RenderLivingBase renderer, ModelBiped modelBase)
    {
        if (modelBase.bipedRightArm instanceof ArmModelRenderer)
        {
            modelBase.bipedRightArm = ((ArmModelRenderer) modelBase.bipedRightArm).getOriginal();
        }

        //armors
        List<LayerRenderer> layerRenderers = ReflectionUtils.getValue(RenderLivingBase.class, renderer, "layerRenderers");
        for (LayerRenderer layerRenderer : layerRenderers)
        {
            if (!(layerRenderer instanceof LayerArmorBase))
            {
                continue;
            }
            LayerArmorBase armor = (LayerArmorBase) layerRenderer;
            ModelBase armorModel = armor.getModelFromSlot(EntityEquipmentSlot.CHEST);
            if (!(armorModel instanceof ModelBiped))
            {
                continue;
            }
            ModelBiped armorModelBase = (ModelBiped) armorModel;
            if (armorModelBase.bipedRightArm instanceof ArmModelRenderer)
            {
                armorModelBase.bipedRightArm = ((ArmModelRenderer) armorModelBase.bipedRightArm).getOriginal();
            }

        }
        //players have an additional skin layer that needs to be modified.
        if (modelBase instanceof ModelPlayer)
        {
            ModelPlayer modelPlayer = (ModelPlayer) modelBase;
            if (modelPlayer.bipedRightArmwear instanceof ArmModelRenderer)
            {
                modelPlayer.bipedRightArmwear = ((ArmModelRenderer) modelPlayer.bipedRightArmwear).getOriginal();
            }
        }
    }

    public static void removeLeftArm(RenderLivingBase renderer, ModelBiped modelBase)
    {

        if (modelBase.bipedLeftArm instanceof ArmModelRenderer)
        {
            modelBase.bipedLeftArm = ((ArmModelRenderer) modelBase.bipedLeftArm).getOriginal();
        }

        //armors
        List<LayerRenderer> layerRenderers = ReflectionUtils.getValue(RenderLivingBase.class, renderer, "layerRenderers");
        for (LayerRenderer layerRenderer : layerRenderers)
        {
            if (!(layerRenderer instanceof LayerArmorBase))
            {
                continue;
            }
            LayerArmorBase armor = (LayerArmorBase) layerRenderer;
            ModelBase armorModel = armor.getModelFromSlot(EntityEquipmentSlot.CHEST);
            if (!(armorModel instanceof ModelBiped))
            {
                continue;
            }
            ModelBiped armorModelBase = (ModelBiped) armorModel;
            if (armorModelBase.bipedLeftArm instanceof ArmModelRenderer)
            {
                armorModelBase.bipedLeftArm = ((ArmModelRenderer) armorModelBase.bipedLeftArm).getOriginal();
            }

        }
        //players have an additional skin layer that needs to be modified.
        if (modelBase instanceof ModelPlayer)
        {
            ModelPlayer modelPlayer = (ModelPlayer) modelBase;
            //left arm
            if (modelPlayer.bipedLeftArmwear instanceof ArmModelRenderer)
            {
                modelPlayer.bipedLeftArmwear = ((ArmModelRenderer) modelPlayer.bipedLeftArmwear).getOriginal();
            }
        }
    }
}
