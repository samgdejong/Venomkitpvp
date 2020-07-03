package me.crazzycarot.venomkitpvp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.crazzycarot.venomkitpvp.core.main;

public class death implements Listener {

	private main plugin;

	public death(main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void deathMessages(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getEntity().getKiller() instanceof Player) {
				Player attacker = e.getEntity().getPlayer().getKiller();
				Player victim = e.getEntity().getPlayer();
				Player p = e.getEntity().getPlayer();

				String command = plugin.getConfig().getString("death.reward").replaceAll("%killer%",
						e.getEntity().getKiller().getName());
				plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);

				if (plugin.getConfig().getString("current.arena").contentEquals("1")) {
					@SuppressWarnings("unused")
					World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("arenas.arena1.world"));
					float yaw = plugin.getConfig().getInt("arenas.arena1.yaw");
					float pitch = plugin.getConfig().getInt("arenas.arena1.pitch");
					Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena1.world")),
							plugin.getConfig().getDouble("arenas.arena1.x"),
							plugin.getConfig().getDouble("arenas.arena1.y"),
							plugin.getConfig().getDouble("arenas.arena1.z"), yaw, pitch);

					p.teleport(loc);

				}
				if (plugin.getConfig().getString("current.arena").contentEquals("2")) {
					@SuppressWarnings("unused")
					World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("arenas.arena2.world"));
					float yaw = plugin.getConfig().getInt("arenas.arena2.yaw");
					float pitch = plugin.getConfig().getInt("arenas.arena2.pitch");
					Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena2.world")),
							plugin.getConfig().getDouble("arenas.arena2.x"),
							plugin.getConfig().getDouble("arenas.arena1.y"),
							plugin.getConfig().getDouble("arenas.arena2.z"), yaw, pitch);

					p.teleport(loc);

				}
				if (plugin.getConfig().getString("current.arena").contentEquals("3")) {
					@SuppressWarnings("unused")
					World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("arenas.arena3.world"));
					float yaw = plugin.getConfig().getInt("arenas.arena3.yaw");
					float pitch = plugin.getConfig().getInt("arenas.arena3.pitch");
					Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena3.world")),
							plugin.getConfig().getDouble("arenas.arena3.x"),
							plugin.getConfig().getDouble("arenas.arena3.y"),
							plugin.getConfig().getDouble("arenas.arena3.z"), yaw, pitch);
					p.teleport(loc);

				}
				if (attacker instanceof Player) {

					if (!(plugin.getConfig().getString("death.enabled").contentEquals("true"))) {

					} else {
						String message = plugin.getConfig().getString("death.deathmessage")
								.replaceAll("%attacker%", attacker.getName()).replaceAll("%victim%", victim.getName());
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
					}
				}

			}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (plugin.getConfig().getString("kills." + e.getPlayer().getUniqueId()) == null) {
			plugin.getConfig().set("kills." + e.getPlayer().getUniqueId(), 0);
			plugin.saveConfig();

		}
	}

	@EventHandler
	public void onJoins(PlayerJoinEvent e) {
		if (plugin.getConfig().getString("deaths." + e.getPlayer().getUniqueId()) == null) {
			plugin.getConfig().set("deaths." + e.getPlayer().getUniqueId(), 0);
			plugin.saveConfig();

		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getEntity().getKiller() instanceof Player) {
				@SuppressWarnings("unused")
				Player killer = e.getEntity().getKiller();
				Player death = e.getEntity().getPlayer();
				if (plugin.getConfig().getString("deaths." + death.getUniqueId()) == null) {
					plugin.getConfig().set("deaths." + death.getUniqueId(), 1);
					plugin.saveConfig();
				} else {
					plugin.getConfig().set("deaths." + death.getUniqueId(),
							plugin.getConfig().getInt("deaths." + death.getUniqueId()) + 1);
					plugin.saveConfig();

				}

			}
		}

	}

	@EventHandler
	public void onDeaths(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getEntity().getKiller() instanceof Player) {
				Player killer = e.getEntity().getKiller();
				Player death = e.getEntity().getPlayer();
				if (plugin.getConfig().getString("kills." + killer.getUniqueId()) == null) {
					plugin.getConfig().set("kills." + killer.getUniqueId(), 1);
					plugin.saveConfig();

				} else {
					plugin.getConfig().set("kills." + killer.getUniqueId(),
							plugin.getConfig().getInt("kills." + death.getUniqueId()) + 1);
					plugin.saveConfig();

				}

			}
		}

	}

}
