package com.aonerchina.battleland.Event;

import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.aonerchina.battleland.API.BLPlayer;

public class EventPlayer implements Listener{
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		BLPlayer p = (BLPlayer) e.getPlayer();
		p.playEffect(p.getLocation(), Effect.FLAME, 1);
		if (!p.isPlayed()) {
			
		}
	}
}
