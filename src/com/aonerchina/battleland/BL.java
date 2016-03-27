package com.aonerchina.battleland;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import com.aonerchina.battleland.API.InventoryWindow;
import com.aonerchina.battleland.API.Profession;
import com.aonerchina.battleland.Event.EventPlayer;
import com.aonerchina.battleland.Util.ConfigUtil;

import net.md_5.bungee.api.ChatColor;

public class BL extends JavaPlugin {
	private static BL plugin;
	private static List<Profession> pro_list;
	private static InventoryWindow window_select_pro;
	private static HashMap<Integer, Runnable> inv_buttons;
	@Override
	public void onEnable() {
		final String Version = "1.0.0";
		plugin = this;
		pro_list = new ArrayList<Profession>();
		inv_buttons = new HashMap<Integer, Runnable>();
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

	public void initDefaultPros() {
		File pro_folder = ConfigUtil.getFile("Pro");
		for (File pro_file : pro_folder.listFiles()) {
			pro_list.add(new Profession(pro_file));
		}
		this.getLogger().info("Loaded " + pro_folder.listFiles().length + " professions.");
		window_select_pro = new InventoryWindow(27, ChatColor.BLUE + "ƒ„ « ≤√¥»À£ø");
		for (Profession pro : pro_list) {
			window_select_pro.addButton(pro.getSymbol());
		}
	}
	
	public static BL getInstance() {
		return plugin;
	}
	
	public static HashMap<Integer, Runnable> getInventoryButtonMap() {
		return inv_buttons;
	}
	
	public static List<Profession> getDefaultProfessionList() {
		return pro_list;
	}
	
	public static InventoryWindow getWindow_SelectPro() {
		return window_select_pro;
	}
}