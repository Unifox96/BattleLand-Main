package com.aonerchina.battleland.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryWindow {
	private Inventory inventory;
	public InventoryWindow(int size, String title) {
		this.inventory = Bukkit.createInventory(null, size, title);
	}

	public void addButton(ItemStack item) {
		this.inventory.addItem(item);
	}

	public void addButton(ItemStack item, int index) {
		this.inventory.setItem(index, item);
	}

	public void sendToPlayer(Player p) {
		p.openInventory(inventory);
	}
}
