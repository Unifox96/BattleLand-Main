package com.aonerchina.battleland;

import org.bukkit.plugin.java.*;

public class BattleLand extends JavaPlugin{
	@Override
	public void onEnable() {
		final String Version = "1.0.0";
		this.getLogger().info("BattleLand " + Version + " is enabled now!");
		this.getLogger().info("Author: a-one-r (A1iR)");
	}
	@Override
	public void onDisable() {
		this.getLogger().info("Shutting down...");
		this.getLogger().info("BattleLand is disabled.");
	}
}