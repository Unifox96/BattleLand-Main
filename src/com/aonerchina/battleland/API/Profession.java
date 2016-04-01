package com.aonerchina.battleland.API;

import java.io.File;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.aonerchina.battleland.BL;
import com.aonerchina.battleland.Util.ChatColorUtil;

import net.md_5.bungee.api.ChatColor;

public class Profession {
	private PlayerAttribute pro_attr;
	private FileConfiguration pro_config;
	private ItemStack symbolItem;

	@SuppressWarnings("deprecation")
	public Profession(File pro_config_file) {
		this.pro_config = new YamlConfiguration();
		try {
			this.pro_config.load(pro_config_file);
		} catch (IOException | InvalidConfigurationException e) {
			BL.getInstance().getLogger().info("Error while loading profession config" + e.getMessage());
			e.printStackTrace();
		}
		this.pro_attr = new PlayerAttribute(pro_config);
		symbolItem = new ItemStack(Material.getMaterial(pro_config.getInt("pro-display.item-id")),
				pro_config.getInt("pro-display.item-data"));
		symbolItem.setAmount(pro_config.getInt("pro-display.item-amount"));
		ItemMeta symbol_im = symbolItem.getItemMeta();
		symbol_im.setDisplayName(ChatColor.translateAlternateColorCodes('&', pro_config.getString("pro-display.name")));
		symbol_im.setLore(ChatColorUtil.translate(pro_config.getStringList("pro-display.lore"), '&'));
		symbolItem.setItemMeta(symbol_im);
	}

	public PlayerAttribute getDefaultAttribute() {
		return this.pro_attr;
	}

	public FileConfiguration getYamlConfig() {
		return this.pro_config;
	}

	public ItemStack getSymbol() {
		return symbolItem;
	}

}
