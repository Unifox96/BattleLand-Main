package com.aonerchina.battleland.API;

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
	public void sendBLMessage(String path) {
		
	}
}
