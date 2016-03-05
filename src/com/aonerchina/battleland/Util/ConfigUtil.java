package com.aonerchina.battleland.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.aonerchina.battleland.BL;

public class ConfigUtil {
	public static void initConfig() {
		BL plugin = BL.getInstance();
		plugin.saveResource("config.yml", false);
		createFolder("languages");
		relRes("lang-zh_cn.yml", "languages\\lang-zh_cn.yml");
	}

	public static FileConfiguration getConfig(String name) {
		File f = getFile(name);
		FileConfiguration c = new YamlConfiguration();
		try {
			c.load(f);
		} catch (IOException | InvalidConfigurationException e) {
			c = null;
		}
		return c;
	}

	public static File getFile(String name) {
		return new File(BL.getInstance().getDataFolder(), name);
	}

	public static FileConfiguration getLanguageConfig(String locale) {
		return getConfig("languages\\lang-" + locale + ".yml");
	}

	public static void createFolder(String name) {
		getFile(name).mkdirs();
	}

	public static void relRes(String fileName, String relPath) {
		File file = new File(BL.getInstance().getDataFolder(), relPath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ex) {
				Logger.getLogger(ConfigUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		byte b;
		int temp;
		try {
			FileOutputStream out;
			try (InputStream in = BL.getInstance().getResource(fileName)) {
				out = new FileOutputStream(file);
				while ((temp = in.read()) != -1) {
					b = (byte) temp;
					out.write(b);
				}
				out.flush();
			}
			out.close();
		} catch (IOException ex) {
			Logger.getLogger(ConfigUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
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
