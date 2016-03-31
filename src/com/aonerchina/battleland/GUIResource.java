package com.aonerchina.battleland;

import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import com.aonerchina.battleland.API.BLWindowItemClickRunnable;
import com.aonerchina.battleland.API.InventoryWindow;
import com.aonerchina.battleland.API.Profession;

import net.md_5.bungee.api.ChatColor;

public class GUIResource {
	private InventoryWindow window_selectkit;

	public void init() {
		window_selectkit = new InventoryWindow(27, ChatColor.BLUE + "ƒ„ « ≤√¥»À£ø", false);
		for (Profession pro : BL.getInstance().pro_list) {
			window_selectkit.addButton(pro.getSymbol(), new BLWindowItemClickRunnable(){
				@Override
				public void run() {	
					this.getPlayer().sendMessage("You clicked" + this.getItemStack().getItemMeta().getDisplayName()
							+ " and this message should be shown once");
				}
			});
		}
	}
}
