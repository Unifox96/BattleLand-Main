package com.aonerchina.battleland.Util;

import java.io.File;
import java.io.IOException;

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
}
