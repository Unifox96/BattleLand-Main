package com.aonerchina.battleland.Window;

import com.aonerchina.battleland.BL;
import com.aonerchina.battleland.API.BLWindow;
import com.aonerchina.battleland.API.BLWindowItemClickRunnable;
import com.aonerchina.battleland.API.Profession;

public class WindowSelectKit extends BLWindow{

	public WindowSelectKit() {
		super("SelectKit", 27, "—°‘Ò÷∞“µ", false);
		for (Profession pro : BL.getDefaultProfessionList()) {
			this.addButton(pro.getSymbol(), new BLWindowItemClickRunnable(){
				@Override
				public void run() {
					this.getPlayer().sendMessage("You choosed" + this.getItemStack().getItemMeta().getDisplayName());
					this.getPlayer().closeInventory();
				}
			});
		}
	}

}
