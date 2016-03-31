package com.aonerchina.battleland.API;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BLWindowItemClickRunnable implements Runnable {
	private Player p;
	private ItemStack i;

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

	@Override
	public void run() {
		// If the function isn't be overrided
	}

}
