package com.aonerchina.battleland.API;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BLWindowItemClickRunnable implements Runnable {
	private Player p;
	private ItemStack i;
	private boolean canDrag;
	
	public BLWindowItemClickRunnable() {
		this.canDrag = true;
	}
	
	public BLWindowItemClickRunnable(boolean canDrag) {
		this.canDrag = canDrag;
	}
	
	public void setPlayer(Player p) {
		this.p = p;
	}

	public Player getPlayer() {
		return p;
	}

	public void setItemStack(ItemStack i) {
		this.i = i;
	}

	public ItemStack getItemStack() {
		return i;
	}

	public boolean isDraggable() {
		return canDrag;
	}
	
	public void setDraggable(boolean canDrag) {
		this.canDrag = canDrag;
	}
	
	@Override
	public void run() {
		// If the function isn't be overrided
	}

}
