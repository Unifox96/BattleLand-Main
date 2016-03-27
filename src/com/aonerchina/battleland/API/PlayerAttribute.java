package com.aonerchina.battleland.API;

import org.bukkit.configuration.file.FileConfiguration;

public class PlayerAttribute {
    /*
     *  Can this be replaced by Player MetaData..?
     */
	public int HP;
	public int MP;
	public int PA;
	public int PD;
	public int MA;
	public int MD;
	public int SP;
	public int LK;
	public int EG;
	public PlayerAttribute(FileConfiguration pro_config) {
		this.HP = pro_config.getInt("points.inital.hp");
		this.MP = pro_config.getInt("points.inital.mp");
		this.PA = pro_config.getInt("points.inital.pa");
		this.PD = pro_config.getInt("points.inital.pd");
		this.MA = pro_config.getInt("points.inital.ma");
		this.MD = pro_config.getInt("points.inital.md");
		this.SP = pro_config.getInt("points.inital.sp");
		this.LK = pro_config.getInt("points.inital.lk");
		this.EG = pro_config.getInt("points.inital.eg");
	}
}
