package com.flansmod.client;

import com.flansmod.api.IControllable;
import com.flansmod.client.gui.GuiTeamScores;
import com.flansmod.client.model.ArmModelRenderer;
import com.flansmod.common.FlansMod;
import com.flansmod.common.FlansUtils;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketTeamInfo;
import com.flansmod.common.network.PacketTeamInfo.PlayerScoreData;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.Team;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.EntityViewRenderEvent.CameraSetup;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.util.glu.Project;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND;
import static net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND;

public class ClientRenderHooks 
{
	//public static final ResourceLocation offHand = new ResourceLocation("flansmod","gui/offHand.png");
	public static final ResourceLocation hitMarker = new ResourceLocation("flansmod", "gui/hitMarker.png");
	
	private Minecraft mc;
	private float fovModifier, fovModifierPrev;
	private float equippedProgressMainHand, prevEquippedProgressMainHand;
	private float equippedProgressOffHand, prevEquippedProgressOffHand;
	private ItemStack itemToRenderMainHand;
	private ItemStack itemToRenderOffHand;
	private int equippedItemSlot;
	private float partialTicks;
	
	private static class SidedStatus
	{
		private float fovModifierHandPrev, fovModifierHand;
		private float equippedProgress, prevEquippedProgress;
		private ItemStack stackToRender;
		private int equippedSlot;
	}
	
	private static RenderItem itemRenderer = Minecraft.getMinecraft().getRenderItem();
	private static List<KillMessage> killMessages = new ArrayList<KillMessage>();
	
	public ClientRenderHooks()
	{
		mc = Minecraft.getMinecraft();
	}
		
	/** Render guns in 3D in item frames */
	public void renderItemFrame(RenderItemInFrameEvent event)
	{
		if(event.getItem().getItem() instanceof ItemGun)
		{
			GunType type = ((ItemGun)event.getItem().getItem()).getInfoType();
			if(type.model != null)
			{
				event.setCanceled(true);
				
				int rotation = event.getEntityItemFrame().getRotation();
				GlStateManager.rotate(-rotation * 45F, 0F, 0F, 1F);
				RenderHelper.enableStandardItemLighting();
				GlStateManager.rotate(rotation * 45F, 0F, 0F, 1F);
				GlStateManager.pushMatrix();
				float scale = 0.75F;
				GlStateManager.scale(scale, scale, scale);
				GlStateManager.translate(0.15F, -0.15F, 0F);
				//ClientProxy.gunRenderer.renderItem(ItemRenderType.ENTITY, event.item);
				GlStateManager.popMatrix();
			}
		}
	}
	
	/** When Minecraft would render a 2D gun item, render the gun properly. Render the offhand gun too. */
	public void renderHeldItem(RenderHandEvent event)
	{

		//remove custom model if player is in first person.
		Render playerRenderer = Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(Minecraft.getMinecraft().thePlayer);
		if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && playerRenderer instanceof RenderPlayer)
		{
			//TODO first person model manipulation based on holdingType
			RenderPlayer renderPlayer = ((RenderPlayer) playerRenderer);
			ArmModelRenderer.removeRightArm(renderPlayer, renderPlayer.getMainModel());
			ArmModelRenderer.removeLeftArm(renderPlayer, renderPlayer.getMainModel());
		}

		boolean hasGunMainHand = itemToRenderMainHand != null && itemToRenderMainHand.getItem() instanceof ItemGun && ((ItemGun) itemToRenderMainHand.getItem()).getInfoType().model != null;
		boolean hasGunOffHand = itemToRenderOffHand != null && itemToRenderOffHand.getItem() instanceof ItemGun && ((ItemGun) itemToRenderOffHand.getItem()).getInfoType().model != null;
		//EntityPlayer player = mc.thePlayer;
		if(hasGunMainHand || hasGunOffHand)
		{
			float partialTicks = event.getPartialTicks();
			int pass = event.getRenderPass();
			EntityRenderer renderer = mc.entityRenderer;
			float farPlaneDistance = mc.gameSettings.renderDistanceChunks * 16F;
			ItemRenderer itemRenderer = mc.getItemRenderer();

			GlStateManager.clear(256);
			GlStateManager.matrixMode(5889);
	        GlStateManager.loadIdentity();

	        float f1 = 0.07F;
	        if(mc.gameSettings.anaglyph)
	            GlStateManager.translate((float)(-(pass * 2 - 1)) * f1, 0.0F, 0.0F);

	        Project.gluPerspective(getFOVModifier(partialTicks), (float)mc.displayWidth / (float)mc.displayHeight, 0.05F, farPlaneDistance * 2.0F);
	        GlStateManager.matrixMode(5888);
	        GlStateManager.loadIdentity();

	        if(mc.gameSettings.anaglyph)
	            GlStateManager.translate((float)(pass * 2 - 1) * 0.1F, 0.0F, 0.0F);

	        GlStateManager.pushMatrix();
	        hurtCameraEffect(partialTicks);

	        if(mc.gameSettings.viewBobbing)
	        	setupViewBobbing(partialTicks);

	        boolean flag = mc.getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)mc.getRenderViewEntity()).isPlayerSleeping();

	        if(mc.gameSettings.thirdPersonView == 0 && !flag && !mc.gameSettings.hideGUI && mc.playerController != null && !mc.playerController.isSpectator())
	        {
	        	renderer.enableLightmap();
				EnumHandSide mainSide = FlansUtils.getSideForHand(EnumHand.MAIN_HAND, mc.thePlayer);
				if (hasGunMainHand)
				{
					renderItemInFirstPerson(itemToRenderMainHand, itemRenderer,  partialTicks, mainSide, EnumHand.MAIN_HAND);
				}
				if (hasGunOffHand)
				{
					renderItemInFirstPerson(itemToRenderOffHand, itemRenderer,  partialTicks, mainSide.opposite(), EnumHand.OFF_HAND);
				}
	            renderer.disableLightmap();
	        }

	        GlStateManager.popMatrix();

	        if(mc.gameSettings.thirdPersonView == 0 && !flag)
	        {
	            itemRenderer.renderOverlays(partialTicks);
	            hurtCameraEffect(partialTicks);
	        }

	        if(mc.gameSettings.viewBobbing)
	        {
	            setupViewBobbing(partialTicks);
	        }
		}
	}
	
	private void renderItemInFirstPerson(ItemStack stack, ItemRenderer renderer, float partialTicks, EnumHandSide side, EnumHand hand)
	{
		float progressMovement = hand == EnumHand.MAIN_HAND ? 1.0F - (prevEquippedProgressMainHand + (equippedProgressMainHand - prevEquippedProgressMainHand) * partialTicks)
				: 1.0F - (prevEquippedProgressOffHand + (equippedProgressOffHand - prevEquippedProgressOffHand) * partialTicks);

		EntityPlayerSP entityplayersp = this.mc.thePlayer;
        float swingProgress = 0; //entityplayersp.getSwingProgress(partialTicks);
        float pitch = entityplayersp.prevRotationPitch + (entityplayersp.rotationPitch - entityplayersp.prevRotationPitch) * partialTicks;
        float yaw = entityplayersp.prevRotationYaw + (entityplayersp.rotationYaw - entityplayersp.prevRotationYaw) * partialTicks;
        
        //Setup lighting
        GlStateManager.disableLighting();
        GlStateManager.pushMatrix();
        GlStateManager.rotate(pitch, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(yaw, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
        
        //Do lighting
        int i = this.mc.theWorld.getCombinedLight(new BlockPos(entityplayersp.posX, entityplayersp.posY + (double)entityplayersp.getEyeHeight(), entityplayersp.posZ), 0);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)(i & 65535), (float)(i >> 16));
        
        //Do hand rotations
        float f5 = entityplayersp.prevRenderArmPitch + (entityplayersp.renderArmPitch - entityplayersp.prevRenderArmPitch) * partialTicks;
        float f6 = entityplayersp.prevRenderArmYaw + (entityplayersp.renderArmYaw - entityplayersp.prevRenderArmYaw) * partialTicks;
        GlStateManager.rotate((entityplayersp.rotationPitch - f5) * 0.1F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate((entityplayersp.rotationYaw - f6) * 0.1F, 0.0F, 1.0F, 0.0F);
        
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();

        //Do vanilla weapon swing

		float f7 = -0.4F * MathHelper.sin(MathHelper.sqrt_float(swingProgress) * (float)Math.PI);
        float f8 = 0.2F * MathHelper.sin(MathHelper.sqrt_float(swingProgress) * (float)Math.PI * 2.0F);
        float f9 = -0.2F * MathHelper.sin(swingProgress * (float)Math.PI);
        GlStateManager.translate(f7, f8, f9);
        
        GlStateManager.translate(0.56F, -0.52F, -0.71999997F);

		GlStateManager.translate(0.0F, progressMovement * -0.6F, 0.0F);


		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
        float f10 = MathHelper.sin(swingProgress * swingProgress * (float)Math.PI);
        float f11 = MathHelper.sin(MathHelper.sqrt_float(swingProgress) * (float)Math.PI);
        GlStateManager.rotate(f10 * -20.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f11 * -20.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(f11 * -80.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.scale(0.4F, 0.4F, 0.4F);


		TransformType transformType = side == EnumHandSide.LEFT ? FIRST_PERSON_LEFT_HAND : FIRST_PERSON_RIGHT_HAND;
        ClientProxy.gunRenderer.renderItem(transformType, stack, mc.thePlayer);

        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
	}

	
    private void hurtCameraEffect(float partialTicks)
    {
        if (this.mc.getRenderViewEntity() instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)this.mc.getRenderViewEntity();
            float f1 = (float)entitylivingbase.hurtTime - partialTicks;
            float f2;

            if (entitylivingbase.getHealth() <= 0.0F)
            {
                f2 = (float)entitylivingbase.deathTime + partialTicks;
                GlStateManager.rotate(40.0F - 8000.0F / (f2 + 200.0F), 0.0F, 0.0F, 1.0F);
            }

            if (f1 < 0.0F)
            {
                return;
            }

            f1 /= (float)entitylivingbase.maxHurtTime;
            f1 = MathHelper.sin(f1 * f1 * f1 * f1 * (float)Math.PI);
            f2 = entitylivingbase.attackedAtYaw;
            GlStateManager.rotate(-f2, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-f1 * 14.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(f2, 0.0F, 1.0F, 0.0F);
        }
    }
    
    private void setupViewBobbing(float partialTicks)
    {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)this.mc.getRenderViewEntity();
            float f1 = entityplayer.distanceWalkedModified - entityplayer.prevDistanceWalkedModified;
            float f2 = -(entityplayer.distanceWalkedModified + f1 * partialTicks);
            float f3 = entityplayer.prevCameraYaw + (entityplayer.cameraYaw - entityplayer.prevCameraYaw) * partialTicks;
            float f4 = entityplayer.prevCameraPitch + (entityplayer.cameraPitch - entityplayer.prevCameraPitch) * partialTicks;
            GlStateManager.translate(MathHelper.sin(f2 * (float)Math.PI) * f3 * 0.5F, -Math.abs(MathHelper.cos(f2 * (float)Math.PI) * f3), 0.0F);
            GlStateManager.rotate(MathHelper.sin(f2 * (float)Math.PI) * f3 * 3.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(Math.abs(MathHelper.cos(f2 * (float)Math.PI - 0.2F) * f3) * 5.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(f4, 1.0F, 0.0F, 0.0F);
        }
    }
    
    private float getFOVModifier(float partialTicks)
    {
        Entity entity = this.mc.getRenderViewEntity();
        float f1 = 70.0F;

        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getHealth() <= 0.0F)
        {
            float f2 = (float)((EntityLivingBase)entity).deathTime + partialTicks;
            f1 /= (1.0F - 500.0F / (f2 + 500.0F)) * 2.0F + 1.0F;
        }

        IBlockState block = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.mc.theWorld, entity, partialTicks);

        if (block.getMaterial() == Material.WATER)
            f1 = f1 * 60.0F / 70.0F;

        return f1;
    }
    
    public void update()
    {    	    	
		for(int i = 0; i < killMessages.size(); i++)
		{
			killMessages.get(i).timer--;
			if(killMessages.get(i).timer == 0)
			{
				killMessages.remove(i);
			}
		}

        //Update the FOV Modifier
		float fovModifier = 1.0F;
        if (mc.getRenderViewEntity() instanceof AbstractClientPlayer)
        {
            AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)this.mc.getRenderViewEntity();
            fovModifier = abstractclientplayer.getFovModifier();
        }

        //Adjust FOV modifier
        fovModifierPrev = this.fovModifier;
        this.fovModifier += (fovModifier - this.fovModifier) * 0.5F;
		//Limit FOV modifier to a certain range
		this.fovModifier = MathHelper.clamp_float(fovModifier,0.1F, 1.5F);

        //And update the itemToRender, for item switching
        
        prevEquippedProgressMainHand = equippedProgressMainHand;
		prevEquippedProgressOffHand = equippedProgressOffHand;

		EntityPlayerSP thePlayer = mc.thePlayer;
        if(thePlayer != null)
        {
        	//MainHand
	        ItemStack itemStackMainHand = thePlayer.getHeldItemMainhand();
	        boolean equippedGun = false;
	        if(itemToRenderMainHand != null && itemStackMainHand != null)
	        {
	            if (!itemToRenderMainHand.isItemEqual(itemStackMainHand))
	            {
	                if (!itemToRenderMainHand.getItem().shouldCauseReequipAnimation(itemToRenderMainHand, itemStackMainHand, equippedItemSlot != thePlayer.inventory.currentItem))
	                {
	                    itemToRenderMainHand = itemStackMainHand;
	                    equippedItemSlot = thePlayer.inventory.currentItem;
	                    return;
	                }
	                equippedGun = true;
	            }
	        }
	        else if(itemToRenderMainHand == null && itemStackMainHand == null)
	        {
	        	equippedGun = false;
	        }
	        else
	        {
	        	equippedGun = true;
	        }

	        float maxChange = 0.4F;
	        float targetProgress = equippedGun ? 0.0F : 1.0F;
	        float difference = MathHelper.clamp_float(targetProgress - equippedProgressMainHand, -maxChange, maxChange);
	        equippedProgressMainHand += difference;
	
	        if(equippedProgressMainHand < 0.1F)
	        {
	            itemToRenderMainHand = itemStackMainHand;
	            equippedItemSlot = thePlayer.inventory.currentItem;
	        }


			//OffHand
			ItemStack itemStackOffHand = thePlayer.getHeldItemOffhand();
			equippedGun = false;
			if(itemToRenderOffHand != null && itemStackOffHand != null)
			{
				if (!itemToRenderOffHand.isItemEqual(itemStackOffHand))
				{
					if (!itemToRenderOffHand.getItem().shouldCauseReequipAnimation(itemToRenderOffHand, itemStackOffHand, false))
					{
						itemToRenderOffHand = itemStackOffHand;
						//equippedItemSlot = thePlayer.inventory.currentItem;
						return;
					}
					equippedGun = true;
				}
			}
			else if(itemToRenderOffHand == null && itemStackOffHand == null)
			{
				equippedGun = false;
			}
			else
			{
				equippedGun = true;
			}

			maxChange = 0.4F;
			targetProgress = equippedGun ? 0.0F : 1.0F;
			difference = MathHelper.clamp_float(targetProgress - equippedProgressOffHand, -maxChange, maxChange);
			equippedProgressOffHand += difference;

			if(equippedProgressOffHand < 0.1F)
			{
				itemToRenderOffHand = itemStackOffHand;
			}


			//Render debug boxes for player snapshots
	        PlayerData data = PlayerHandler.getPlayerData(thePlayer);
			if(FlansMod.DEBUG && data != null)
			{
				if(data.snapshots[0] != null)
					data.snapshots[0].renderSnapshot();
			}
        }
    }
    
    public void SetPartialTick(float dT)
    {
    	partialTicks = dT;
    }

	public void renderThirdPerson(RenderLivingEvent.Pre event)
	{
		EntityLivingBase entity = event.getEntity();
		ItemStack mainHandStack = entity.getHeldItemMainhand();
		ItemStack offHandStack = entity.getHeldItemOffhand();

		ModelBase mainModel = event.getRenderer().getMainModel();
		if (!(mainModel instanceof ModelBiped))
		{
			return;
		}
		ModelBiped modelBase = ((ModelBiped) mainModel);


		//if no items or no items that are guns are being held, remove the custom renderer.
		if ((
				(mainHandStack == null || !(mainHandStack.getItem() instanceof ItemGun)) &
						(offHandStack == null || !(offHandStack.getItem() instanceof ItemGun))
		))
		{
			ArmModelRenderer.removeRightArm(event.getRenderer(), modelBase);
			ArmModelRenderer.removeLeftArm(event.getRenderer(), modelBase);
			return;

		}

		EnumHandSide mainHandSide = entity.getPrimaryHand();
		ItemStack rightStack = mainHandSide == EnumHandSide.RIGHT ? mainHandStack : offHandStack;
		ItemStack leftStack = mainHandSide == EnumHandSide.RIGHT ? offHandStack : mainHandStack;

		GunType gunRight = null;
		if (rightStack != null && rightStack.getItem() instanceof ItemGun)
		{
			gunRight = ((ItemGun) rightStack.getItem()).getInfoType();
		}
		GunType gunLeft = null;
		if (leftStack != null && leftStack.getItem() instanceof ItemGun)
		{
			gunLeft = ((ItemGun) leftStack.getItem()).getInfoType();
		}


		Pair<Vector3f, Vector3f> rightRotations = null;
		Pair<Vector3f, Vector3f> leftRotations = null;

		Vector3f looking = new Vector3f(modelBase.bipedHead.rotateAngleX, modelBase.bipedHead.rotateAngleY, modelBase.bipedHead.rotateAngleZ);
		if (gunRight != null)
		{
			rightRotations = gunRight.holdingType.getArmRotations(gunRight, partialTicks, looking, entity, EnumHandSide.RIGHT, leftStack != null);
		}
		if (gunLeft != null)
		{
			leftRotations = gunLeft.holdingType.getArmRotations(gunLeft, partialTicks, looking, entity, EnumHandSide.LEFT, rightStack != null);
		}
		Vector3f rightRotation = null;
		Vector3f leftRotation = null;
		if (rightRotations != null)
		{
			rightRotation = rightRotations.getLeft();
			if (leftRotations == null)
			{
				leftRotation = rightRotations.getRight();
			}
		}
		if (leftRotations != null)
		{
			leftRotation = leftRotations.getLeft();
			if (rightRotations == null)
			{
				rightRotation = leftRotations.getRight();
			}
		}
		List<ArmModelRenderer> rightModels = ArmModelRenderer.getModelsForSide(EnumHandSide.RIGHT, event.getRenderer(), modelBase);
		List<ArmModelRenderer> leftModels = ArmModelRenderer.getModelsForSide(EnumHandSide.LEFT, event.getRenderer(), modelBase);
		for (ArmModelRenderer modelRenderer : rightModels)
		{
			modelRenderer.setRotationOverrides(rightRotation);
			modelRenderer.setShouldMakeChanges(true);
		}
		for (ArmModelRenderer modelRenderer : leftModels)
		{
			modelRenderer.setRotationOverrides(leftRotation);
			modelRenderer.setShouldMakeChanges(true);
		}
	}


	/*
	public void renderThirdPersonWeapons(RenderLivingEvent.Post event)
	{
		ModelBase mainModel = event.getRenderer().getMainModel();
		EntityLivingBase entity = event.getEntity();
		for(EnumHand hand : EnumHand.values())
		{
			ItemStack stack = entity.getHeldItem(hand);
			if(stack == null || !(stack.getItem() instanceof ItemGun))
			{
				continue;
			}
			ModelBiped biped = (ModelBiped)mainModel;


			GunType type = ((ItemGun)stack.getItem()).GetType();
			if(type.model == null)
				continue;
		}

	}
	*/
	
	private float interpolateRotation(float x, float y, float dT)
	{
		float f3;

		for(f3 = y - x; f3 < -180.0F; f3 += 360.0F) { }
		for( ; f3 >= 180.0F; f3 -= 360.0F) { }

		return x + dT * f3;
	}

	//Handle player hiding / name tag removal for teams
	public void renderPlayer(RenderPlayerEvent.Pre event)
	{
		EntityPlayer player = event.getEntityPlayer();
		ItemStack stackMainHand = player.getHeldItemMainhand();
		ItemStack stackOffHand = player.getHeldItemOffhand();

		if (stackMainHand != null && stackMainHand.getItem() instanceof ItemGun || stackOffHand != null && stackOffHand.getItem() instanceof ItemGun)
		{
			player.swingProgress = 0;
		}

		PlayerData data = PlayerHandler.getPlayerData(event.getEntityPlayer(), Side.CLIENT);
					
		event.getRenderer().NAME_TAG_RANGE = 64F;
		event.getRenderer().NAME_TAG_RANGE_SNEAK = 32F;		
		if(event.getEntity() instanceof EntityPlayer && FlansModClient.teamInfo != null && FlansModClient.teamInfo.gametype != null && !"No Gametype".equals(FlansModClient.teamInfo.gametype))
		{
			PlayerScoreData rendering = FlansModClient.teamInfo.getPlayerScoreData(event.getEntity().getName());
			PlayerScoreData thePlayer = FlansModClient.teamInfo.getPlayerScoreData(mc.thePlayer.getName());
			
			Team renderingTeam = rendering == null ? Team.spectators : rendering.team.team;
			Team thePlayerTeam = thePlayer == null ? Team.spectators : thePlayer.team.team;
						
			//Do custom skin overrides
			//If we have no stored skin, try to get it
			if(data.skin == null)
				data.skin = ((AbstractClientPlayer)event.getEntityPlayer()).getLocationSkin();
			//Only once we have the stored skin may we override
			if(data.skin != null)
			{
				//ResourceLocation skin = rendering == null || rendering.playerClass == null ? null : FlansModResourceHandler.getTexture(rendering.playerClass);
				//((AbstractClientPlayer)event.entityPlayer).func_152121_a(Type.SKIN, skin == null ? data.skin : skin);
			}
			
			//Spectators see all
			if(thePlayerTeam == Team.spectators)
				return;
			//Nobody sees spectators
			if(renderingTeam == Team.spectators)
			{
				event.setCanceled(true);
				return;
			}
			//If we are on the other team, don't render the name tag
			if(renderingTeam != thePlayerTeam)
			{
				event.getRenderer().NAME_TAG_RANGE = 0F;
				event.getRenderer().NAME_TAG_RANGE_SNEAK = 0F;
				return;
			}
			//If its DM, don't render the name tag
			if(!FlansModClient.teamInfo.sortedByTeam)
			{
				event.getRenderer().NAME_TAG_RANGE = 0F;
				event.getRenderer().NAME_TAG_RANGE_SNEAK = 0F;
			}
		}
	}

	public void cameraSetup(CameraSetup event)
	{
		if(mc.thePlayer.getRidingEntity() instanceof IControllable)
		{
			IControllable cont = (IControllable)mc.thePlayer.getRidingEntity();
			float roll = interpolateRotation(cont.getPrevPlayerRoll(), cont.getPlayerRoll(), (float)event.getRenderPartialTicks());
			//If we are driving a vehicle with the roll component enabled, having the camera roll with the vehicle is disorientating at best, so we disable the roll component for these vehicles
			if(((EntitySeat)mc.thePlayer.getRidingEntity()).driveable != null){
			EntityDriveable ent = ((EntitySeat)mc.thePlayer.getRidingEntity()).driveable;
			
			if(ent.getDriveableType().canRoll){
				roll = 0F;
			}
			}
			
			event.setRoll(roll);
		}
	}
	
	public void ModifyHUD(RenderGameOverlayEvent event)
	{
		Minecraft mc = Minecraft.getMinecraft();
		
		//Remove crosshairs if looking down the sights of a gun
		if(event.getType() == ElementType.CROSSHAIRS && FlansModClient.currentScope != null)
		{
			event.setCanceled(true);
			return;
		}
		
		ScaledResolution scaledresolution = new ScaledResolution(FlansModClient.minecraft);//, FlansModClient.minecraft.displayWidth, FlansModClient.minecraft.displayHeight);
		int i = scaledresolution.getScaledWidth();
		int j = scaledresolution.getScaledHeight();
					
		Tessellator tessellator = Tessellator.getInstance();
		
		if(!event.isCancelable() && event.getType() == ElementType.HELMET)
		{
			//Scopes and helmet overlays
			String overlayTexture = null;
			if (FlansModClient.currentScope != null && FlansModClient.currentScope.hasZoomOverlay() && FMLClientHandler.instance().getClient().currentScreen == null && FlansModClient.zoomProgress > 0.8F)
			{
				overlayTexture = FlansModClient.currentScope.getZoomOverlay();
			}
			else if(mc.thePlayer != null)
			{
				ItemStack stack = mc.thePlayer.inventory.armorInventory[3];
				if(stack != null && stack.getItem() instanceof ItemTeamArmour)
				{
					overlayTexture = ((ItemTeamArmour)stack.getItem()).type.overlay;
				}
			}
			
			if(overlayTexture != null)
			{
				FlansModClient.minecraft.entityRenderer.setupOverlayRendering();
				GL11.glEnable(3042 /* GL_BLEND */);
				GL11.glDisable(2929 /* GL_DEPTH_TEST */);
				GL11.glDepthMask(false);
				GL11.glBlendFunc(770, 771);
				GL11.glColor4f(1F, 1F, 1F, 1.0F);
				GL11.glDisable(3008 /* GL_ALPHA_TEST */);

				mc.renderEngine.bindTexture(FlansModResourceHandler.getScope(overlayTexture));

				/*tessellator.getWorldRenderer().startDrawingQuads();
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 2 * j, j, -90D, 0.0D, 1.0D);
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 2 * j, j, -90D, 1.0D, 1.0D);
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 2 * j, 0.0D, -90D, 1.0D, 0.0D);
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 2 * j, 0.0D, -90D, 0.0D, 0.0D);
				tessellator.draw();*/
				GL11.glDepthMask(true);
				GL11.glEnable(2929 /* GL_DEPTH_TEST */);
				GL11.glEnable(3008 /* GL_ALPHA_TEST */);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
		
		if(event.isCancelable() && event.getType() == ElementType.CROSSHAIRS)
		{
			if(FlansModClient.hitMarkerTime > 0)
			{
				//Off-hand weapon graphics
				mc.renderEngine.bindTexture(hitMarker);
				
				GlStateManager.enableAlpha();
				GlStateManager.enableBlend();
				GlStateManager.color(1.0f, 1.0f, 1.0f, Math.max(((float)FlansModClient.hitMarkerTime - 10.0f + partialTicks) / 10.0f, 0.0f));

				
				//ItemStack currentStack = mc.thePlayer.inventory.getCurrentItem();
				//PlayerData data = PlayerHandler.getPlayerData(mc.thePlayer, Side.CLIENT);
				double zLevel = 0D;
				
				/*tessellator.getWorldRenderer().startDrawingQuads();
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 4d, j / 2 + 5d, zLevel, 0D / 16D, 9D / 16D);
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 5d, j / 2 + 5d, zLevel, 9D / 16D, 9D / 16D);
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 5d, j / 2 - 4d, zLevel, 9D / 16D, 0D / 16D);
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 4d, j / 2 - 4d, zLevel, 0D / 16D, 0D / 16D);
				tessellator.draw();*/
				

				GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
				GlStateManager.disableAlpha();
				GlStateManager.disableBlend();
			}
			

		}
		/*
		if(event.isCancelable() && event.getType() == ElementType.HOTBAR)
		{
			//Off-hand weapon graphics
			mc.renderEngine.bindTexture(offHand);
			
			ItemStack currentStack = mc.thePlayer.inventory.getCurrentItem();
			PlayerData data = PlayerHandler.getPlayerData(mc.thePlayer, Side.CLIENT);
			double zLevel = 0D;
			
			if(currentStack != null && currentStack.getItem() instanceof ItemGun && ((ItemGun)currentStack.getItem()).GetType().oneHanded)
			{
				for(int n = 0; n < 9; n++)
				{
					if(data.offHandGunSlot == n + 1)
					{
						/*tessellator.getWorldRenderer().startDrawingQuads();
						tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 88 + 20 * n, j - 3, zLevel, 16D / 64D, 16D / 32D);
						tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 72 + 20 * n, j - 3, zLevel, 32D / 64D, 16D / 32D);
						tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 72 + 20 * n, j - 19, zLevel, 32D / 64D, 0D / 32D);
						tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 88 + 20 * n, j - 19, zLevel, 16D / 64D, 0D / 32D);
						tessellator.draw();
					}
					else if(data.isValidOffHandWeapon(mc.thePlayer, n + 1))
					{					
						/*tessellator.getWorldRenderer().startDrawingQuads();
						tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 88 + 20 * n, j - 3, zLevel, 0D / 64D, 16D / 32D);
						tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 72 + 20 * n, j - 3, zLevel, 16D / 64D, 16D / 32D);
						tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 72 + 20 * n, j - 19, zLevel, 16D / 64D, 0D / 32D);
						tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 88 + 20 * n, j - 19, zLevel, 0D / 64D, 0D / 32D);
						tessellator.draw();
					}
				}
			}

		}
		*/
		if(!event.isCancelable() && event.getType() == ElementType.HOTBAR)
		{
			if(mc.thePlayer != null)
			{

				EnumHand rightHand = FlansUtils.getHandForSide(EnumHandSide.RIGHT, mc.thePlayer);
				ItemStack stackRightHand = mc.thePlayer.getHeldItem(rightHand);
				if(stackRightHand != null && stackRightHand.getItem() instanceof ItemGun)
				{
					ItemGun gunItem = (ItemGun)stackRightHand.getItem();
					GunType gunType = gunItem.getInfoType();
					int x = 0;
					for(int n = 0; n < gunType.numAmmoItemsInGun; n++)
					{
						ItemStack bulletStack = ((ItemGun)stackRightHand.getItem()).getBulletItemStack(stackRightHand, n);
						if(bulletStack != null && bulletStack.getItemDamage() < bulletStack.getMaxDamage())
						{
							RenderHelper.enableGUIStandardItemLighting();
							GL11.glEnable(GL12.GL_RESCALE_NORMAL);
							OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240F, 240F);
							drawSlotInventory(mc.fontRendererObj, bulletStack, i / 2 + 16 + x, j - 65);
							GL11.glDisable(GL12.GL_RESCALE_NORMAL);
							RenderHelper.disableStandardItemLighting();
							String s = (bulletStack.getMaxDamage() - bulletStack.getItemDamage()) + "/" + bulletStack.getMaxDamage();
							if(bulletStack.getMaxDamage() == 1)
								s = "";
							mc.fontRendererObj.drawString(s, i / 2 + 32 + x, j - 59, 0x000000);
							mc.fontRendererObj.drawString(s, i / 2 + 33 + x, j - 60, 0xffffff);
							x += 16 + mc.fontRendererObj.getStringWidth(s);
						}
					}
				}
				EnumHand leftHand = rightHand == EnumHand.MAIN_HAND ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
				ItemStack stackLeftHand = mc.thePlayer.getHeldItem(leftHand);

				if(stackLeftHand != null && stackLeftHand.getItem() instanceof ItemGun)
				{
					GunType offHandGunType = ((ItemGun)stackLeftHand.getItem()).getInfoType();
					int x = 0;
					for(int n = 0; n < offHandGunType.numAmmoItemsInGun; n++)
					{
						ItemStack bulletStack = ((ItemGun)stackLeftHand.getItem()).getBulletItemStack(stackLeftHand, n);
						if(bulletStack != null && bulletStack.getItemDamage() < bulletStack.getMaxDamage())
						{
							//Find the string we are displaying next to the ammo item
							String s = (bulletStack.getMaxDamage() - bulletStack.getItemDamage()) + "/" + bulletStack.getMaxDamage();
							if(bulletStack.getMaxDamage() == 1)
								s = "";

							//Draw the slot and then move leftwards
							RenderHelper.enableGUIStandardItemLighting();
							GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
							GL11.glEnable(GL12.GL_RESCALE_NORMAL);
							OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240F, 240F);
							drawSlotInventory(mc.fontRendererObj, bulletStack, i / 2 - 32 - x, j - 65);
							x += 16 + mc.fontRendererObj.getStringWidth(s);

							//Draw the string
							GL11.glDisable(GL12.GL_RESCALE_NORMAL);
							RenderHelper.disableStandardItemLighting();
							mc.fontRendererObj.drawString(s, i / 2 - 16 - x, j - 59, 0x000000);
							mc.fontRendererObj.drawString(s, i / 2 - 17 - x, j - 60, 0xffffff);
						}
					}
				}
			}
			
			PacketTeamInfo teamInfo = FlansModClient.teamInfo;
			
			if(teamInfo != null && FlansModClient.minecraft.thePlayer != null && (teamInfo.numTeams > 0 || !teamInfo.sortedByTeam) && teamInfo.getPlayerScoreData(FlansModClient.minecraft.thePlayer.getName()) != null)
			{
				GL11.glEnable(3042 /* GL_BLEND */);
				GL11.glDisable(2929 /* GL_DEPTH_TEST */);
				GL11.glDepthMask(false);
				GL11.glBlendFunc(770, 771);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glDisable(3008 /* GL_ALPHA_TEST */);
	
				mc.renderEngine.bindTexture(GuiTeamScores.texture);
								
				/*tessellator.getWorldRenderer().startDrawingQuads();
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 43, 27, -90D, 85D / 256D, 27D / 256D);
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 43, 27, -90D, 171D / 256D, 27D / 256D);
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 43, 0D, -90D, 171D / 256D, 0D / 256D);
				tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 43, 0D, -90D, 85D / 256D, 0D / 256D);
				tessellator.draw();*/
				
				//If we are in a two team gametype, draw the team scores at the top of the screen
				if(teamInfo.numTeams == 2 && teamInfo.sortedByTeam)
				{
					//Draw team 1 colour bit
					int colour = teamInfo.teamData[0].team.teamColour;	
					GL11.glColor4f(((colour >> 16) & 0xff) / 256F, ((colour >> 8) & 0xff) / 256F, (colour & 0xff) / 256F, 1.0F);
					/*tessellator.getWorldRenderer().startDrawingQuads();
					tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 43, 27, -90D, 0D / 256D, 125D / 256D);
					tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 19, 27, -90D, 24D / 256D, 125D / 256D);
					tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 19, 0D, -90D, 24D / 256D, 98D / 256D);
					tessellator.getWorldRenderer().addVertexWithUV(i / 2 - 43, 0D, -90D, 0D / 256D, 98D / 256D);
					tessellator.draw();*/
					//Draw team 2 colour bit
					colour = teamInfo.teamData[1].team.teamColour;	
					GL11.glColor4f(((colour >> 16) & 0xff) / 256F, ((colour >> 8) & 0xff) / 256F, (colour & 0xff) / 256F, 1.0F);
					/*tessellator.getWorldRenderer().startDrawingQuads();
					tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 19, 27, -90D, 62D / 256D, 125D / 256D);
					tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 43, 27, -90D, 86D / 256D, 125D / 256D);
					tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 43, 0D, -90D, 86D / 256D, 98D / 256D);
					tessellator.getWorldRenderer().addVertexWithUV(i / 2 + 19, 0D, -90D, 62D / 256D, 98D / 256D);
					tessellator.draw();*/
					
					GL11.glDepthMask(true);
					GL11.glEnable(2929 /* GL_DEPTH_TEST */);
					GL11.glEnable(3008 /* GL_ALPHA_TEST */);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					
					//Draw the team scores
					if(teamInfo.teamData[0] != null && teamInfo.teamData[1] != null)
					{
						mc.fontRendererObj.drawString(teamInfo.teamData[0].score + "", i / 2 - 35, 9, 0x000000);
						mc.fontRendererObj.drawString(teamInfo.teamData[0].score + "", i / 2 - 36, 8, 0xffffff);
						mc.fontRendererObj.drawString(teamInfo.teamData[1].score + "", i / 2 + 35 - mc.fontRendererObj.getStringWidth(teamInfo.teamData[1].score + ""), 9, 0x000000);
						mc.fontRendererObj.drawString(teamInfo.teamData[1].score + "", i / 2 + 34 - mc.fontRendererObj.getStringWidth(teamInfo.teamData[1].score + ""), 8, 0xffffff);
					}
				}
				
				mc.fontRendererObj.drawString(teamInfo.gametype + "", i / 2 + 48, 9, 0x000000);
				mc.fontRendererObj.drawString(teamInfo.gametype + "", i / 2 + 47, 8, 0xffffff);
				mc.fontRendererObj.drawString(teamInfo.map + "", i / 2 - 47 - mc.fontRendererObj.getStringWidth(teamInfo.map + ""), 9, 0x000000);
				mc.fontRendererObj.drawString(teamInfo.map + "", i / 2 - 48 - mc.fontRendererObj.getStringWidth(teamInfo.map + ""), 8, 0xffffff);
				
				int secondsLeft = teamInfo.timeLeft / 20;
				int minutesLeft = secondsLeft / 60;
				secondsLeft = secondsLeft % 60;
				String timeLeft = minutesLeft + ":" + (secondsLeft < 10 ? "0" + secondsLeft : secondsLeft);
				mc.fontRendererObj.drawString(timeLeft, i / 2 - mc.fontRendererObj.getStringWidth(timeLeft) / 2 - 1, 29, 0x000000);
				mc.fontRendererObj.drawString(timeLeft, i / 2 - mc.fontRendererObj.getStringWidth(timeLeft) / 2, 30, 0xffffff);
	
				
				GL11.glDepthMask(true);
				GL11.glEnable(2929 /* GL_DEPTH_TEST */);
				GL11.glEnable(3008 /* GL_ALPHA_TEST */);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				String playerUsername = FlansModClient.minecraft.thePlayer.getName();
				
				if(teamInfo.getPlayerScoreData(playerUsername) != null)
				{
					mc.fontRendererObj.drawString(teamInfo.getPlayerScoreData(playerUsername).score + "", i / 2 - 7, 1, 0x000000);
					mc.fontRendererObj.drawString(teamInfo.getPlayerScoreData(playerUsername).kills + "", i / 2 - 7, 9, 0x000000);
					mc.fontRendererObj.drawString(teamInfo.getPlayerScoreData(playerUsername).deaths + "", i / 2 - 7, 17, 0x000000);
				}
			}
			for(int n = 0; n < killMessages.size(); n++)
			{
				KillMessage killMessage = killMessages.get(n);
				mc.fontRendererObj.drawString("\u00a7" + killMessage.killerName + "     " + "\u00a7" + killMessage.killedName, i - mc.fontRendererObj.getStringWidth(killMessage.killerName + "     " + killMessage.killedName) - 6, j - 32 - killMessage.line * 16, 0xffffff);
			}
						
			//Draw icons indicated weapons used
			RenderHelper.enableGUIStandardItemLighting();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);

			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240F, 240F);	
			for(int n = 0; n < killMessages.size(); n++)
			{
				KillMessage killMessage = killMessages.get(n);
				drawSlotInventory(mc.fontRendererObj, new ItemStack(killMessage.weapon.item), i - mc.fontRendererObj.getStringWidth("     " + killMessage.killedName) - 12, j - 36 - killMessage.line * 16);
			}
			GL11.glDisable(3042 /*GL_BLEND*/);
			RenderHelper.disableStandardItemLighting();
			
			//DEBUG vehicles
			if(mc.thePlayer.getRidingEntity() instanceof EntitySeat)
			{
				EntityDriveable ent = ((EntitySeat)mc.thePlayer.getRidingEntity()).driveable;
				
				double dX = ent.posX - ent.prevPosX;
				double dY = ent.posY - ent.prevPosY;
				double dZ = ent.posZ - ent.prevPosZ;
				
				//Convert to chunks per Minecraft hour
				float speed = (float)Math.sqrt(dX * dX + dY * dY + dZ * dZ) * 1000F / 16F; 
				
				speed = (int)(speed * 10F) / 10F;
				
				mc.fontRendererObj.drawString("Speed: " + speed + " chunks per hour", 2, 2, 0xffffff);
				
				if(FlansMod.DEBUG)
				{
					mc.fontRendererObj.drawString("Throttle : " + ent.throttle, 2, 12, 0xffffff);
				}
			}
		}
	}
	
	private void drawSlotInventory(FontRenderer fontRenderer, ItemStack itemstack, int i, int j)
	{
		if(itemstack == null || itemstack.getItem() == null)
			return;
		itemRenderer.renderItemIntoGUI(itemstack, i, j);
		itemRenderer.renderItemOverlayIntoGUI(fontRenderer, itemstack, i, j, null); //May be something other than null
	}
		
	public static void addKillMessage(boolean headshot, InfoType infoType, String killer, String killed)
	{
		for(KillMessage killMessage : killMessages)
		{
			killMessage.line++;
			if(killMessage.line > 10)
				killMessage.timer = 0;
		}
		killMessages.add(new KillMessage(headshot, infoType, killer, killed));
	}

	private static class KillMessage
	{
		public KillMessage(boolean head, InfoType infoType, String killer, String killed)
		{
			headshot = head;
			killerName = killer;
			killedName = killed;
			weapon = infoType;
			line = 0;
			timer = 200;
		}
		
		public String killerName;
		public String killedName;
		public InfoType weapon;
		public int timer;
		public int line;
		public boolean headshot;
	}
}
