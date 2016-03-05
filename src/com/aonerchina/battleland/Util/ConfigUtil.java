package com.aonerchina.battleland.Util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.aonerchina.battleland.BattleLand;

public class ConfigUtil {
	public static FileConfiguration getConfig(String name) {
		File f = getFile(name);
		FileConfiguration c = new YamlConfiguration();
		try {
			c.load(f);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static File getFile(String name) {
		return new File(BattleLand.getInstance().getDataFolder(), name);
	}
	
	public static FileConfiguration getLanguageConfig(String locale) {
		return getConfig("languages\\lang-" + locale + ".yml");
	}
	
	public static List<String> getMsgList(String path) {
		// Will remove in future
		return getMsgList(path, "zh_cn");
	}
	
	public static String getMsgStr(String path) {
		// Will remove in future
		return getMsgStr(path, "zh_cn");
	}
	
	public static List<String> getMsgList(String path, String locale) {
		FileConfiguration config = getLanguageConfig(locale);
		List<String> list = config.getStringList(path);
		return ChatColorUtil.translate(list, '&');
	}
	
	public static String getMsgStr(String path, String locale) {
		FileConfiguration config = getLanguageConfig(locale);
		return ChatColor.translateAlternateColorCodes('&', config.getString(path));
	}
}
