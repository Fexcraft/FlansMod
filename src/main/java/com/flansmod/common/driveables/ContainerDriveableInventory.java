package com.flansmod.common.driveables;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerDriveableInventory extends Container
{
	public InventoryPlayer inventory;
	public World world;
	public EntityDriveable plane;
	public int numItems;
	public int screen;
	public int maxScroll;
	public int scroll;
	private int dragEvent;
	private int dragMode = -1;
    private final Set<Slot> dragSlots = Sets.<Slot>newHashSet();
	
	public ContainerDriveableInventory(InventoryPlayer inventoryplayer, World worldy, EntityDriveable entPlane, int i)
	{
		inventory = inventoryplayer;
		world = worldy;
		plane = entPlane;
		screen = i;
		//Find the number of items in the inventory
		numItems = 0;
		switch(i)
		{
			case 0 :
			{
				numItems = plane.driveableData.numGuns;
				maxScroll = (numItems > 3 ? numItems - 3 : 0);
				break;
			}
			case 1 : 
			{
				numItems = plane.getDriveableType().numBombSlots;
				maxScroll = (((numItems + 7) / 8) > 3 ? ((numItems + 7) / 8) - 3 : 0);
				break;
			}
			case 2 : 
			{
				numItems = plane.getDriveableType().numCargoSlots;
				maxScroll = (((numItems + 7) / 8) > 3 ? ((numItems + 7) / 8) - 3 : 0);
				break;
			}	
			case 3 : 
			{
				numItems = plane.getDriveableType().numMissileSlots;
				maxScroll = (((numItems + 7) / 8) > 3 ? ((numItems + 7) / 8) - 3 : 0);
				break;
			}	
		}
		
		//Add screen specific slots
		switch(screen)
		{
			case 0 : //Guns
			{
				int slotsDone = 0;
				for(int j = 0; j < plane.driveableData.numGuns; j++)
				{
					int yPos = -1000;
					if(slotsDone < 3 + scroll && slotsDone >= scroll)
						yPos = 25 + 19 * slotsDone;
					addSlotToContainer(new Slot(plane.driveableData, j, 29, yPos));
					slotsDone++;
				}	
				break;
			}
			case 1 : //Bombs
			case 2 : //Cargo
			case 3 : //Missiles
			{
				int startSlot = plane.driveableData.getBombInventoryStart();
				if(screen == 2)
					startSlot = plane.driveableData.getCargoInventoryStart();
				if(screen == 3)
					startSlot = plane.driveableData.getMissileInventoryStart();
				int m = ((numItems + 7) / 8);
				for(int row = 0; row < m; row++)
				{
					int yPos = -1000;
					if(row < 3 + scroll && row >= scroll)
						yPos = 25 + 19 * (row - scroll);
					for(int col = 0; col < ((row + scroll + 1) * 8 <= numItems ? 8 : numItems % 8); col++)
					{
						addSlotToContainer(new Slot(plane.driveableData, startSlot + row * 8 + col, 10 + 18 * col, yPos));
					}
				}
				break;
			}
		}
		
		//Main inventory slots
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 9; col++)
			{
				addSlotToContainer(new Slot(inventoryplayer, col + row * 9 + 9, 8 + col * 18, 98 + row * 18));
			}

		}
		//Quickbar slots
		for(int col = 0; col < 9; col++)
		{
			addSlotToContainer(new Slot(inventoryplayer, col, 8 + col * 18, 156));
		}
	}
	
	public void updateScroll(int scrololol)
	{
		scroll = scrololol;
		switch(screen)
		{
			case 0 :
			{
				int slotsDone = 0;
				for(int i = 0; i < plane.driveableData.numGuns; i++)
				{
					int yPos = -1000;
					if(slotsDone < 3 + scroll && slotsDone >= scroll)
						yPos = 25 + 19 * (slotsDone - scroll);
					((Slot)inventorySlots.get(slotsDone)).yPos = yPos;
					slotsDone++;
				}	
				break;
			}
			case 1 :
			case 2 :
			case 3 : 
			{
				int m = ((numItems + 7) / 8);
				for(int row = 0; row < m; row++)
				{
					int yPos = -1000;
					if(row < 3 + scroll && row >= scroll)
						yPos = 25 + 19 * (row - scroll);
					for(int col = 0; col < ((row + 1) * 8 <= numItems ? 8 : numItems % 8); col++)
					{
						((Slot)inventorySlots.get(row * 8 + col)).yPos = yPos;
					}
				}
				break;
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		ItemStack stack = ItemStack.EMPTY;
		Slot currentSlot = (Slot)inventorySlots.get(slotID);

		if(currentSlot != null && currentSlot.getHasStack())
		{
			ItemStack slotStack = currentSlot.getStack();
			stack = slotStack.copy();

			if(slotID >= numItems)
			{
				if(!mergeItemStack(slotStack, 0, numItems, false))
				{
					return ItemStack.EMPTY;
				}
			}
			else {
				if(!mergeItemStack(slotStack, numItems, inventorySlots.size(), true))
				{
					return ItemStack.EMPTY;
				}
			}

			if (slotStack.getCount() == 0)
			{
				currentSlot.putStack(ItemStack.EMPTY);
			}
			else
			{
				currentSlot.onSlotChanged();
			}

			if (slotStack.getCount() == stack.getCount())
			{
				return null;
			}

			currentSlot.onTake(player, slotStack);
		}

		return stack;
	}
	
	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        InventoryPlayer inventoryplayer = player.inventory;

        if (clickTypeIn == ClickType.QUICK_CRAFT)
        {
            int i = this.dragEvent;
            this.dragEvent = getDragEvent(dragType);

            if ((i != 1 || this.dragEvent != 2) && i != this.dragEvent)
            {
                this.resetDrag();
            }
            else if (inventoryplayer.getItemStack().isEmpty())
            {
                this.resetDrag();
            }
            else if (this.dragEvent == 0)
            {
                this.dragMode  = extractDragMode(dragType);

                if (isValidDragMode(this.dragMode, player))
                {
                    this.dragEvent = 1;
                    this.dragSlots.clear();
                }
                else
                {
                    this.resetDrag();
                }
            }
            else if (this.dragEvent == 1)
            {
                Slot slot = (Slot)this.inventorySlots.get(slotId);
                ItemStack itemstack1 = inventoryplayer.getItemStack();

                if (slot != null && canAddItemToSlot(slot, itemstack1, true) && slot.isItemValid(itemstack1) && (this.dragMode == 2 || itemstack1.getCount() > this.dragSlots.size()) && this.canDragIntoSlot(slot))
                {
                    this.dragSlots.add(slot);
                }
            }
            else if (this.dragEvent == 2)
            {
                if (!this.dragSlots.isEmpty())
                {
                    ItemStack itemstack5 = inventoryplayer.getItemStack().copy();
                    int l = inventoryplayer.getItemStack().getCount();

                    for (Slot slot1 : this.dragSlots)
                    {
                        ItemStack itemstack2 = inventoryplayer.getItemStack();

                        if (slot1 != null && canAddItemToSlot(slot1, itemstack2, true) && slot1.isItemValid(itemstack2) && (this.dragMode == 2 || itemstack2.getCount() >= this.dragSlots.size()) && this.canDragIntoSlot(slot1))
                        {
                            ItemStack itemstack3 = itemstack5.copy();
                            int j = slot1.getHasStack() ? slot1.getStack().getCount() : 0;
                            computeStackSize(this.dragSlots, this.dragMode, itemstack3, j);
                            int k = Math.min(itemstack3.getMaxStackSize(), slot1.getItemStackLimit(itemstack3));

                            if (itemstack3.getCount() > k)
                            {
                                itemstack3.setCount(k);
                            }

                            l -= itemstack3.getCount() - j;
                            slot1.putStack(itemstack3);
                        }
                    }

                    itemstack5.setCount(l);
                    inventoryplayer.setItemStack(itemstack5);
                }

                this.resetDrag();
            }
            else
            {
                this.resetDrag();
            }
        }
        else if (this.dragEvent != 0)
        {
            this.resetDrag();
        }
        else if ((clickTypeIn == ClickType.PICKUP || clickTypeIn == ClickType.QUICK_MOVE) && (dragType == 0 || dragType == 1))
        {
            if (slotId == -999)
            {
                if (!inventoryplayer.getItemStack().isEmpty())
                {
                    if (dragType == 0)
                    {
                        player.dropItem(inventoryplayer.getItemStack(), true);
                        inventoryplayer.setItemStack(ItemStack.EMPTY);
                    }

                    if (dragType == 1)
                    {
                        player.dropItem(inventoryplayer.getItemStack().splitStack(1), true);
                    }
                }
            }
            else if (clickTypeIn == ClickType.QUICK_MOVE)
            {
                if (slotId < 0)
                {
                    return ItemStack.EMPTY;
                }

                Slot slot6 = (Slot)this.inventorySlots.get(slotId);

                if (slot6 != null && slot6.canTakeStack(player))
                {
                    ItemStack itemstack10 = this.transferStackInSlot(player, slotId);

                    if (!itemstack10.isEmpty())
                    {
                        Item item = itemstack10.getItem();
                        itemstack = itemstack10.copy();

                        if (slot6.getStack().getItem() == item)
                        {
                            this.retrySlotClick(slotId, dragType, true, player);
                        }
                    }
                }
            }
            else
            {
                if (slotId < 0)
                {
                    return ItemStack.EMPTY;
                }

                Slot slot7 = (Slot)this.inventorySlots.get(slotId);

                if (slot7 != null)
                {
                    ItemStack itemstack11 = slot7.getStack();
                    ItemStack itemstack13 = inventoryplayer.getItemStack();

                    if (!itemstack11.isEmpty())
                    {
                        itemstack = itemstack11.copy();
                    }

                    if (itemstack11.isEmpty())
                    {
                        if (!itemstack13.isEmpty() && slot7.isItemValid(itemstack13))
                        {
                            int l2 = dragType == 0 ? itemstack13.getCount() : 1;

                            if (l2 > slot7.getItemStackLimit(itemstack13))
                            {
                                l2 = slot7.getItemStackLimit(itemstack13);
                            }

                            slot7.putStack(itemstack13.splitStack(l2));
                        }
                    }
                    else if (slot7.canTakeStack(player))
                    {
                        if (itemstack13.isEmpty())
                        {
                            if (itemstack11.isEmpty())
                            {
                                slot7.putStack(ItemStack.EMPTY);
                                inventoryplayer.setItemStack(ItemStack.EMPTY);
                            }
                            else
                            {
                                int k2 = dragType == 0 ? itemstack11.getCount() : (itemstack11.getCount() + 1) / 2;
                                inventoryplayer.setItemStack(slot7.decrStackSize(k2));

                                if (itemstack11.isEmpty())
                                {
                                    slot7.putStack(ItemStack.EMPTY);
                                }

                                slot7.onTake(player, inventoryplayer.getItemStack());
                            }
                        }
                        else if (slot7.isItemValid(itemstack13))
                        {
                            if (itemstack11.getItem() == itemstack13.getItem() && itemstack11.getMetadata() == itemstack13.getMetadata() && ItemStack.areItemStackTagsEqual(itemstack11, itemstack13))
                            {
                                int j2 = dragType == 0 ? itemstack13.getCount() : 1;

                                if (j2 > slot7.getItemStackLimit(itemstack13) - itemstack11.getCount())
                                {
                                    j2 = slot7.getItemStackLimit(itemstack13) - itemstack11.getCount();
                                }

                                if (j2 > itemstack13.getMaxStackSize() - itemstack11.getCount())
                                {
                                    j2 = itemstack13.getMaxStackSize() - itemstack11.getCount();
                                }

                                itemstack13.shrink(j2);
                                itemstack11.grow(j2);
                            }
                            else if (itemstack13.getCount() <= slot7.getItemStackLimit(itemstack13))
                            {
                                slot7.putStack(itemstack13);
                                inventoryplayer.setItemStack(itemstack11);
                            }
                        }
                        else if (itemstack11.getItem() == itemstack13.getItem() && itemstack13.getMaxStackSize() > 1 && (!itemstack11.getHasSubtypes() || itemstack11.getMetadata() == itemstack13.getMetadata()) && ItemStack.areItemStackTagsEqual(itemstack11, itemstack13) && !itemstack11.isEmpty())
                        {
                            int i2 = itemstack11.getCount();

                            if (i2 + itemstack13.getCount() <= itemstack13.getMaxStackSize())
                            {
                                itemstack13.grow(i2);
                                itemstack11 = slot7.decrStackSize(i2);

                                if (itemstack11.isEmpty())
                                {
                                    slot7.putStack(ItemStack.EMPTY);
                                }

                                slot7.onTake(player, inventoryplayer.getItemStack());
                            }
                        }
                    }

                    slot7.onSlotChanged();
                }
            }
        }
        else if (clickTypeIn == ClickType.SWAP && dragType >= 0 && dragType < 9)
        {
            Slot slot5 = (Slot)this.inventorySlots.get(slotId);
            ItemStack itemstack9 = inventoryplayer.getStackInSlot(dragType);
            ItemStack itemstack12 = slot5.getStack();

            if (!itemstack9.isEmpty() || !itemstack12.isEmpty())
            {
                if (itemstack9.isEmpty())
                {
                    if (slot5.canTakeStack(player))
                    {
                        inventoryplayer.setInventorySlotContents(dragType, itemstack12);
                        //slot5.onSwapCraft(itemstack12.getCount());
                        slot5.putStack(ItemStack.EMPTY);
                        slot5.onTake(player, itemstack12);
                    }
                }
                else if (itemstack12.isEmpty())
                {
                    if (slot5.isItemValid(itemstack9))
                    {
                        int k1 = slot5.getItemStackLimit(itemstack9);

                        if (itemstack9.getCount() > k1)
                        {
                            slot5.putStack(itemstack9.splitStack(k1));
                        }
                        else
                        {
                            slot5.putStack(itemstack9);
                            inventoryplayer.setInventorySlotContents(dragType, ItemStack.EMPTY);
                        }
                    }
                }
                else if (slot5.canTakeStack(player) && slot5.isItemValid(itemstack9))
                {
                    int l1 = slot5.getItemStackLimit(itemstack9);

                    if (itemstack9.getCount() > l1)
                    {
                        slot5.putStack(itemstack9.splitStack(l1));
                        slot5.onTake(player, itemstack12);

                        if (!inventoryplayer.addItemStackToInventory(itemstack12))
                        {
                            player.dropItem(itemstack12, true);
                        }
                    }
                    else
                    {
                        slot5.putStack(itemstack9);
                        inventoryplayer.setInventorySlotContents(dragType, itemstack12);
                        slot5.onTake(player, itemstack12);
                    }
                }
            }
        }
        else if (clickTypeIn == ClickType.CLONE && player.capabilities.isCreativeMode && inventoryplayer.getItemStack().isEmpty() && slotId >= 0)
        {
            Slot slot4 = (Slot)this.inventorySlots.get(slotId);

            if (slot4 != null && slot4.getHasStack())
            {
                ItemStack itemstack8 = slot4.getStack().copy();
                itemstack8.setCount(itemstack8.getMaxStackSize());
                inventoryplayer.setItemStack(itemstack8);
            }
        }
        else if (clickTypeIn == ClickType.THROW && inventoryplayer.getItemStack().isEmpty() && slotId >= 0)
        {
            Slot slot3 = (Slot)this.inventorySlots.get(slotId);

            if (slot3 != null && slot3.getHasStack() && slot3.canTakeStack(player))
            {
                ItemStack itemstack7 = slot3.decrStackSize(dragType == 0 ? 1 : slot3.getStack().getCount());
                slot3.onTake(player, itemstack7);
                player.dropItem(itemstack7, true);
            }
        }
        else if (clickTypeIn == ClickType.PICKUP_ALL && slotId >= 0)
        {
            Slot slot2 = (Slot)this.inventorySlots.get(slotId);
            ItemStack itemstack6 = inventoryplayer.getItemStack();

            if (!itemstack6.isEmpty() && (slot2 == null || !slot2.getHasStack() || !slot2.canTakeStack(player)))
            {
                int i1 = dragType == 0 ? 0 : this.inventorySlots.size() - 1;
                int j1 = dragType == 0 ? 1 : -1;

                for (int i3 = 0; i3 < 2; ++i3)
                {
                    for (int j3 = i1; j3 >= 0 && j3 < this.inventorySlots.size() && itemstack6.getCount() < itemstack6.getMaxStackSize(); j3 += j1)
                    {
                        Slot slot8 = (Slot)this.inventorySlots.get(j3);

                        if (slot8.getHasStack() && canAddItemToSlot(slot8, itemstack6, true) && slot8.canTakeStack(player) && this.canMergeSlot(itemstack6, slot8))
                        {
                            ItemStack itemstack14 = slot8.getStack();

                            if (i3 != 0 || itemstack14.getCount() != itemstack14.getMaxStackSize())
                            {
                                int k3 = Math.min(itemstack6.getMaxStackSize() - itemstack6.getCount(), itemstack14.getCount());
                                ItemStack itemstack4 = slot8.decrStackSize(k3);
                                itemstack6.grow(k3);

                                if (itemstack4.isEmpty())
                                {
                                    slot8.putStack(ItemStack.EMPTY);
                                }

                                slot8.onTake(player, itemstack4);
                            }
                        }
                    }
                }
            }

            this.detectAndSendChanges();
        }

        return itemstack;
    }
}
