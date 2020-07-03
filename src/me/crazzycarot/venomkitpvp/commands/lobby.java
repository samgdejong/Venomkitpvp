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

public class lobby implements CommandExecutor {
	private main plugin;
	public lobby(main main) {plugin = main;}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("setlobby")) {
			Player p = (Player) sender;
			plugin.getConfig().set("lobby.world", p.getLocation().getWorld().getName());
			plugin.getConfig().set("lobby.x", p.getLocation().getX());
			plugin.getConfig().set("lobby.y", p.getLocation().getY() + 3);
			plugin.getConfig().set("lobby.z", p.getLocation().getZ());
			plugin.getConfig().set("lobby.yaw", p.getLocation().getYaw());
			plugin.getConfig().set("lobby.pitch", p.getLocation().getPitch());

			plugin.saveConfig();
			p.sendMessage(ChatColor.GREEN + "The lobby has been set");
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("lobby")) {
			Player p = (Player) sender;
			if (plugin.getConfig().getConfigurationSection("lobby") == null) {
				p.sendMessage(ChatColor.RED + "The lobby has not been set yet");
				return true;
			} else {
				@SuppressWarnings("unused")
				World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("lobby.world"));
				float yaw = plugin.getConfig().getInt("lobby.yaw");
				float pitch = plugin.getConfig().getInt("lobby.pitch");
				Location loc = new Location(Bukkit.getWorld(plugin.getConfig().getString("lobby.world")),
						plugin.getConfig().getDouble("lobby.x"), plugin.getConfig().getDouble("lobby.y"),
						plugin.getConfig().getDouble("lobby.z"), yaw, pitch);

				p.teleport(loc);
				p.sendMessage(ChatColor.GREEN + "You have been teleported to the lobby");
			}
		}
		return true;
	}
}
