package com.aonerchina.battleland.API;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.aonerchina.battleland.Util.ConfigUtil;

import net.minecraft.server.v1_8_R3.EntityPlayer;

public class BLPlayer extends CraftPlayer {
	final String playerFolderName = "PlayerData";
	private FileConfiguration playerconfig;

	public BLPlayer(Player p) {
		super((CraftServer) p.getServer(), (EntityPlayer) ((CraftPlayer) p).getHandle());
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
	
	public void initConfig() {
		
	}
}
