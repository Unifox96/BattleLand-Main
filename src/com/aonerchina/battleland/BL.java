package com.aonerchina.battleland;

import org.bukkit.plugin.java.JavaPlugin;

import com.aonerchina.battleland.Event.EventPlayer;
import com.aonerchina.battleland.Util.ConfigUtil;

public class BL extends JavaPlugin{
	private static BL plugin;
	@Override
	public void onEnable() {
		final String Version = "1.0.0";
		plugin = this;
		ConfigUtil.initConfig();
		this.getServer().getPluginManager().registerEvents(new EventPlayer(), this);
		this.getLogger().info("BattleLand " + Version + " is enabled now!");
		this.getLogger().info("Author: a-one-r (A1iR)");
	}
	@Override
	public void onDisable() {
		this.getLogger().info("Shutting down...");
		this.getLogger().info("BattleLand is disabled.");
	}
	public static BL getInstance() {
		return plugin;
	}
}