package com.aonerchina.battleland.API;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.aonerchina.battleland.BL;

public class BLWindow {
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
	public BLWindow(String name, int size, String title, boolean canDrag) {
		BL.getBaseWindowManager().addWindow(name, this);
		this.canDrag = canDrag;
		this.inventory = Bukkit.createInventory(null, size, title);
		this.hashBuffer = new HashMap<ItemStack, BLWindowItemClickRunnable>();
	}

	public void addButton(ItemStack item, BLWindowItemClickRunnable r) {
		this.inventory.addItem(item);
		this.hashBuffer.put(item, r);
	}

	public void setButton(int index, ItemStack item, BLWindowItemClickRunnable r) {
		this.inventory.setItem(index, item);
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

	public HashMap<ItemStack, BLWindowItemClickRunnable> getButtons() {
		return this.hashBuffer;
	}
	
	public void clear() {
		this.hashBuffer.clear();
		this.inventory.clear();
	}
}
