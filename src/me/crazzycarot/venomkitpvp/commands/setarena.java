package me.crazzycarot.venomkitpvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.crazzycarot.venomkitpvp.core.main;

public class setarena implements CommandExecutor {
	private main plugin; 
	public setarena(main main) {plugin = main;}
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setarena")) {
			if (args.length > 0) {
				if (args[0].equals("1") || args[0].equals("2") || args[0].equals("3") || args[0].equals("4")
						|| args[0].equals("5")) {
					if (args[0].equals("1")) {
						plugin.getConfig().set("current.arena", "1");
						for (Player all : Bukkit.getServer().getOnlinePlayers()) {

							World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("arenas.arena1.world"));
							float yaw = plugin.getConfig().getInt("arenas.arena1.yaw");
							float pitch = plugin.getConfig().getInt("arenas.arena1.pitch");
							Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena1.world")),
									plugin.getConfig().getDouble("arenas.arena1.x"), plugin.getConfig().getDouble("arenas.arena1.y"),
									plugin.getConfig().getDouble("arenas.arena1.z"), yaw, pitch);

							all.teleport(loc);
						}

					}
					if (args[0].equals("2")) {
						for (Player all : Bukkit.getServer().getOnlinePlayers()) {

							plugin.getConfig().set("current.arena", "2");
							World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("arenas.arena2.world"));
							float yaw = plugin.getConfig().getInt("arenas.arena2.yaw");
							float pitch = plugin.getConfig().getInt("arenas.arena2.pitch");
							Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena2.world")),
									plugin.getConfig().getDouble("arenas.arena2.x"), plugin.getConfig().getDouble("arenas.arena2.y"),
									plugin.getConfig().getDouble("arenas.arena2.z"), yaw, pitch);
							all.teleport(loc);

						}

					}
					if (args[0].equals("3")) {
						plugin.getConfig().set("current.arena", "3");
						for (Player all : Bukkit.getServer().getOnlinePlayers()) {

							World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("arenas.arena3.world"));
							float yaw = plugin.getConfig().getInt("arenas.arena3.yaw");
							float pitch = plugin.getConfig().getInt("arenas.arena3.pitch");
							Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("arenas.arena3.world")),
									plugin.getConfig().getDouble("arenas.arena3.x"), plugin.getConfig().getDouble("arenas.arena3.y"),
									plugin.getConfig().getDouble("arenas.arena3.z"), yaw, pitch);

							all.teleport(loc);
						}

					}
					plugin.saveConfig();

					Bukkit.broadcastMessage(ChatColor.RED + "The arena has been switched to arena " + ChatColor.GRAY
							+ ChatColor.BOLD + args[0]);

				} else {
					sender.sendMessage(ChatColor.RED + "Wrong usage, use setarena 1/3");

				}
			}

			else {
				sender.sendMessage(ChatColor.RED + "Wrong usage, use setarena 1/3");
			}
		}
		return true;
		
	}
	}
