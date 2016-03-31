package com.aonerchina.battleland.API;

import java.util.HashMap;

public class InventoryManager {
	private HashMap<String, InventoryWindow> windowMap;

	public InventoryManager() {
		this.windowMap = new HashMap<String, InventoryWindow>();
	}
	
	public void addWindow(String name, InventoryWindow window) {
		this.windowMap.put(name, window);
	}
}
