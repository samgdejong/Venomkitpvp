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

public class spawn implements CommandExecutor {
	private main plugin;
	public spawn(main main) {plugin = main;}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			Player p = (Player) sender;
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
		}
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			if (args.length > 0) {
				if (args[0].equals("arena1")) {
					Player p = (Player) sender;
					plugin.getConfig().set("arenas.arena1.world", p.getLocation().getWorld().getName());
					plugin.getConfig().set("arenas.arena1.x", p.getLocation().getX());
					plugin.getConfig().set("arenas.arena1.y", p.getLocation().getY() + 3);
					plugin.getConfig().set("arenas.arena1.z", p.getLocation().getZ());
					plugin.getConfig().set("arenas.arena1.yaw", p.getLocation().getYaw());
					plugin.getConfig().set("arenas.arena1.pitch", p.getLocation().getPitch());
					p.sendMessage(ChatColor.GREEN + "The spawn has been set");
					plugin.saveConfig();

				}
				if (args[0].equals("arena2")) {
					Player p = (Player) sender;
					plugin.getConfig().set("arenas.arena2.world", p.getLocation().getWorld().getName());
					plugin.getConfig().set("arenas.arena2.x", p.getLocation().getX());
					plugin.getConfig().set("arenas.arena2.y", p.getLocation().getY() + 3);
					plugin.getConfig().set("arenas.arena2.z", p.getLocation().getZ());
					plugin.getConfig().set("arenas.arena2.yaw", p.getLocation().getYaw());
					plugin.getConfig().set("arenas.arena2.pitch", p.getLocation().getPitch());
					p.sendMessage(ChatColor.GREEN + "The spawn has been set");
					plugin.saveConfig();

				}
				if (args[0].equals("arena3")) {
					Player p = (Player) sender;
					plugin.getConfig().set("arenas.arena3.world", p.getLocation().getWorld().getName());
					plugin.getConfig().set("arenas.arena3.x", p.getLocation().getX());
					plugin.getConfig().set("arenas.arena3.y", p.getLocation().getY() + 3);
					plugin.getConfig().set("arenas.arena3.z", p.getLocation().getZ());
					plugin.getConfig().set("arenas.arena3.yaw", p.getLocation().getYaw());
					plugin.getConfig().set("arenas.arena3.pitch", p.getLocation().getPitch());
					p.sendMessage(ChatColor.GREEN + "The spawn has been set");
					plugin.saveConfig();

				}

			} else {
				sender.sendMessage(ChatColor.YELLOW + "Wrong usage! perform /setspawn arena1/arena2/arena3");
			}
		}
		
		return true;
	}

}
