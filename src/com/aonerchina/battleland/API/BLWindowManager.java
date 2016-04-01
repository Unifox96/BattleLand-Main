package com.aonerchina.battleland.API;

import java.util.HashMap;
import java.util.Map;

public class BLWindowManager {
	private HashMap<String, BLWindow> windowMap;

	public BLWindowManager() {
		this.windowMap = new HashMap<String, BLWindow>();
	}

	public void addWindow(String name, BLWindow window) {
		this.windowMap.put(name, window);
	}

	public void removeWindow(String name) {
		this.windowMap.remove(name);
	}

	public Map<String, BLWindow> getMap() {
		return windowMap;
	}

	public int getRegisteredCount() {
		return windowMap.size();
	}
}
