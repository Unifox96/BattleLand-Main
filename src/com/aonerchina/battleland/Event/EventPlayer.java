package com.aonerchina.battleland.Event;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.aonerchina.battleland.BL;
import com.aonerchina.battleland.API.BLPlayer;

public class EventPlayer implements Listener{
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage("");
		BLPlayer p = new BLPlayer(e.getPlayer());
		Bukkit.getScheduler().runTaskLater(BL.getInstance(), new Runnable() {
			public void run() {
				if (!p.isPlayed()) {
					p.sendLstMsg("first-join.motd-sel-pro");
					p.playEffect(p.getLocation(), Effect.HEART, 500);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100, 1);
					BL.getWindow_SelectPro().sendToPlayer(p);
				}
			}
		}, 20L);
	}
	@EventHandler
	public void onBreakBlock(BlockBreakEvent e) {
		if (!(e.getPlayer().hasPermission("bl.builder") || e.getPlayer().isOp())) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onPlaceBlock(BlockPlaceEvent e) {
		if (!(e.getPlayer().hasPermission("bl.builder") || e.getPlayer().isOp())) {
			e.setCancelled(true);
		}
	}
}
