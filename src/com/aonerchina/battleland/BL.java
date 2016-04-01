package com.aonerchina.battleland;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import com.aonerchina.battleland.API.Profession;
import com.aonerchina.battleland.API.BLWindowManager;
import com.aonerchina.battleland.Event.EventPlayer;
import com.aonerchina.battleland.Util.ConfigUtil;

public class BL extends JavaPlugin {
	private static BL plugin;
	private static List<Profession> pro_list;
	private static BLWindowManager w_manager;

	@Override
	public void onEnable() {
		final String Version = "1.0.0";
		plugin = this;
		pro_list = new ArrayList<Profession>();
		w_manager = new BLWindowManager();
		ConfigUtil.initConfig();
		initDefaultPros();
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

	public void initDefaultPros() {
		File pro_folder = ConfigUtil.getFile("Pro");
		for (File pro_file : pro_folder.listFiles()) {
			pro_list.add(new Profession(pro_file));
		}
		this.getLogger().info("Loaded " + pro_folder.listFiles().length + " professions.");
	}

	public static List<Profession> getDefaultProfessionList() {
		return pro_list;
	}

	public static BLWindowManager getBaseWindowManager() {
		return w_manager;
	}
}