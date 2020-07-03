package me.crazzycarot.venomkitpvp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.crazzycarot.venomkitpvp.core.main;

public class Join implements Listener {

	private main plugin;

	public Join(main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoins(PlayerJoinEvent e) {
		if (plugin.getConfig().getString("joinmessage.enabled").contentEquals("true")) {
			String message = plugin.getConfig().getString("joinmessage.join").replaceAll("%player%", e.getPlayer().getName());
			e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', message));
		}
		else {
			e.setJoinMessage(null);
		}
	}
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if (plugin.getConfig().getString("joinmessage.enabled").contentEquals("true")) {
			String message = plugin.getConfig().getString("joinmessage.quit").replaceAll("%player%", e.getPlayer().getName());
			e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', message));
		}
		else {
			e.setQuitMessage(null);
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if ((plugin.getConfig().getString("current.arena").contentEquals("1"))) {
			if (!(e.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("arenas.arena1.world")))) {
				float yaw = plugin.getConfig().getInt("arenas.arena1.yaw");
				float pitch = plugin.getConfig().getInt("arenas.arena1.pitch");
				Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena1.world")),
						plugin.getConfig().getDouble("arenas.arena1.x"),
						plugin.getConfig().getDouble("arenas.arena1.y"),
						plugin.getConfig().getDouble("arenas.arena1.z"), yaw, pitch);
				e.getPlayer().teleport(loc);
			}
		}
		if ((plugin.getConfig().getString("current.arena").contentEquals("2"))) {
			if (!(e.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("arenas.arena1.world")))) {

				float yaw = plugin.getConfig().getInt("arenas.arena2.yaw");
				float pitch = plugin.getConfig().getInt("arenas.arena2.pitch");
				Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena2.world")),
						plugin.getConfig().getDouble("arenas.arena2.x"),
						plugin.getConfig().getDouble("arenas.arena2.y"),
						plugin.getConfig().getDouble("arenas.arena2.z"), yaw, pitch);
				e.getPlayer().teleport(loc);
			}
		}
		if ((plugin.getConfig().getString("current.arena").contentEquals("3"))) {
			if (!(e.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("arenas.arena1.world")))) {

				float yaw = plugin.getConfig().getInt("arenas.arena3.yaw");
				float pitch = plugin.getConfig().getInt("arenas.arena3.pitch");
				Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena3.world")),
						plugin.getConfig().getDouble("arenas.arena3.x"),
						plugin.getConfig().getDouble("arenas.arena3.y"),
						plugin.getConfig().getDouble("arenas.arena3.z"), yaw, pitch);
				e.getPlayer().teleport(loc);
			}
		}
		if ((plugin.getConfig().getString("current.arena").contentEquals("4"))) {
			if (!(e.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("arenas.arena4.world")))) {

				float yaw = plugin.getConfig().getInt("arenas.arena4.yaw");
				float pitch = plugin.getConfig().getInt("arenas.arena4.pitch");
				Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena4.world")),
						plugin.getConfig().getDouble("arenas.arena4.x"),
						plugin.getConfig().getDouble("arenas.arena4.y"),
						plugin.getConfig().getDouble("arenas.arena4.z"), yaw, pitch);
				e.getPlayer().teleport(loc);
			}
		}
		if ((plugin.getConfig().getString("current.arena").contentEquals("5"))) {
			if (!(e.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("arenas.arena1.world")))) {

				float yaw = plugin.getConfig().getInt("arenas.arena5.yaw");
				float pitch = plugin.getConfig().getInt("arenas.arena5.pitch");
				Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena5.world")),
						plugin.getConfig().getDouble("arenas.arena5.x"),
						plugin.getConfig().getDouble("arenas.arena5.y"),
						plugin.getConfig().getDouble("arenas.arena5.z"), yaw, pitch);
				e.getPlayer().teleport(loc);
			}
		}

	}

}
