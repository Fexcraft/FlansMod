package com.flansmod.common.types;

public interface IPaintableItem<T extends PaintableType> extends IFlanItem<T>
{
	@Override
	T getInfoType();
}
