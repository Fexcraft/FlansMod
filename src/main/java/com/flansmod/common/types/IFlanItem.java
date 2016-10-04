package com.flansmod.common.types;

import com.flansmod.client.model.RenderCustomItem;
import net.fexcraft.mod.lib.api.item.IItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IFlanItem<T extends InfoType> extends IItem
{
	T getInfoType();

	/**
	 * @return The Render class to use for this item.
	 */
	@SideOnly(Side.CLIENT)
	default RenderCustomItem getRenderItemEntity()
	{
		return null; //throw new NotImplementedException("No render specified for " + getInfoType());
	}

	@Override
	default int getVariantAmount()
	{
		return default_variant;
	}
}
