package com.aonerchina.battleland.Event;

import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import com.aonerchina.battleland.BL;
import com.aonerchina.battleland.API.BLPlayer;
import com.aonerchina.battleland.API.BLWindow;
import com.aonerchina.battleland.API.BLWindowItemClickRunnable;

public class EventPlayer implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		BLPlayer p = new BLPlayer(e.getPlayer());
		Bukkit.getScheduler().runTaskLater(BL.getInstance(), new Runnable() {
			public void run() {
				if (!p.isPlayed()) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100, 1);
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

	@EventHandler(priority = EventPriority.LOW)
	public void onInvClick(InventoryClickEvent e) {
		if (e.getAction() == InventoryAction.PICKUP_ONE) {
			for (Entry<String, BLWindow> entry_manager : BL.getBaseWindowManager().getMap().entrySet()) {
				for (Entry<ItemStack, BLWindowItemClickRunnable> entry_buttons : entry_manager.getValue().getButtons()
						.entrySet()) {
					if (e.getCurrentItem().isSimilar(entry_buttons.getKey())) {
						BLWindowItemClickRunnable runnable = entry_buttons.getValue();
						runnable.setPlayer((Player) e.getWhoClicked());
						runnable.setItemStack(entry_buttons.getKey());
						runnable.run();
					}
				}
			}
		}
	}
}
