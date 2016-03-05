package com.aonerchina.battleland.API;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.aonerchina.battleland.Util.ConfigUtil;

public abstract class BLPlayer implements Player{
	final String playerFolderName = "PlayerData";
	private FileConfiguration playerconfig;
	public BLPlayer() {
		this.playerconfig = ConfigUtil.getConfig(playerFolderName + "\\" + this.getName() + ".yml");
	}
	public boolean isPlayed() {
		return !(getBLConfig() == null);
	}
	public FileConfiguration getBLConfig() {
		return this.playerconfig;
	}
	public void sendStrMsg(String path) {
		this.sendMessage(ConfigUtil.getMsgStr(path));
	}
	public void sendLstMsg(String path) {
		List<String> list = ConfigUtil.getMsgList(path);
		for (String s : list) {
			this.sendMessage(s);
		}
	}
}
