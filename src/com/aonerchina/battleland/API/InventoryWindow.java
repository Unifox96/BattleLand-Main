package com.aonerchina.battleland.API;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryWindow {
	private boolean canDrag;
	private Inventory inventory;
	private HashMap<ItemStack, BLWindowItemClickRunnable> hashBuffer;
	/***
	 * Create a new inventory gui window.
	 * 
	 * @param size
	 *            The size of inventory.
	 * @param title
	 *            The title of inventory.
	 * @param canDrag
	 *            If the inventory is draggable
	 */
	public InventoryWindow(InventoryManager manager, String name, int size, String title, boolean canDrag) {
		manager.addWindow(name, this);
		this.canDrag = canDrag;
		this.inventory = Bukkit.createInventory(null, size, title);
		this.hashBuffer = new HashMap<ItemStack, BLWindowItemClickRunnable>();
	}

	public void addButton(ItemStack item, BLWindowItemClickRunnable r) {
		this.inventory.addItem(item);
		this.hashBuffer.put(item, r);
	}

	public void addButton(ItemStack item, int index) {
		this.inventory.setItem(index, item);
	}

	public void sendToPlayer(Player p) {
		p.openInventory(inventory);
	}

	public boolean canDrag() {
		return this.canDrag;
	}
}
