package me.crazzycarot.venomkitpvp.core;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.crazzycarot.venomkitpvp.commands.lobby;
import me.crazzycarot.venomkitpvp.commands.reclaim;
import me.crazzycarot.venomkitpvp.commands.setarena;
import me.crazzycarot.venomkitpvp.commands.spawn;
import me.crazzycarot.venomkitpvp.commands.staffchat;
import me.crazzycarot.venomkitpvp.events.Join;
import me.crazzycarot.venomkitpvp.events.Kitselector;
import me.crazzycarot.venomkitpvp.events.death;
import me.crazzycarot.venomkitpvp.events.killstreak;
import me.crazzycarot.venomkitpvp.scoreboard.scoreboard;

@SuppressWarnings("unused")
public class main extends JavaPlugin implements Listener, CommandExecutor {

	public void onEnable() {
		getServer().getLogger().info("Venomkitpvp version 1.5.2 is enabled!");
		saveDefaultConfig();
		getConfig().options().copyDefaults();

		new death(this);
		new scoreboard(this);
		new Kitselector(this);
		new Join(this);
		new killstreak(this);

		getCommand("setarena").setExecutor(this);
		getCommand("spawn").setExecutor(new spawn(this));
		getCommand("lobby").setExecutor(new lobby(this));
		getCommand("setlobby").setExecutor(new lobby(this));
		getCommand("setspawn").setExecutor(new spawn(this));
		getCommand("reclaim").setExecutor(new reclaim(this));
		getCommand("setarena").setExecutor(new setarena(this));
		getCommand("staffchat").setExecutor(new staffchat(this));

	}
	
	public main plugin;


	public File reclaimYml = new File(this.getDataFolder() + "/reclaims.yml");
	public FileConfiguration customConfig= YamlConfiguration.loadConfiguration(reclaimYml);

	public void savereclaimYml(FileConfiguration ymlConfig, File ymlFile) {
		try {
			ymlConfig.save(ymlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}


