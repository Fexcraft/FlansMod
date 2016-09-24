package com.flansmod.common.types;

import com.flansmod.client.model.RenderCustomItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IFlanItem
{
	InfoType getInfoType();

	/**
	 * @return The Render class to use for this item.
	 */
	@SideOnly(Side.CLIENT)
	default RenderCustomItem getRenderItemEntity()
	{
		return null; //throw new NotImplementedException("No render specified for " + getInfoType());
	}
}
