package me.crazzycarot.venomkitpvp.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.crazzycarot.venomkitpvp.core.main;

public class staffchat implements CommandExecutor {
	private main plugin;

	public staffchat(main main) {
		plugin = main;
	}

	public ArrayList<Player> staffchat = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("staffchat")) {
			if (plugin.getConfig().getString("staffchat.enabled") == "true") {
			Player p = (Player) sender;
			if (p.hasPermission("venomkitpvp.staffchat")) {
				{
					String message = "";
					for (String part : args) {
						if (message != "")
							message += " ";
						message += part;
					}
					for (Player all : Bukkit.getOnlinePlayers()) {
						if (all.hasPermission("venomkitpvp.staffchat")) {
							if (!staffchat.contains(all)) {
								if (plugin.getConfig().getString("staffchat.message")  == null) {
								all.sendMessage("§f§l[§6§lSTAFFCHAT§F§l]§f " + p.getName() + " §e" + message);
								}
								else {
									String format = plugin.getConfig().getString("staffchat.message").replaceAll("%player%", p.getName().replaceAll("%message%", message));
									all.sendMessage(ChatColor.translateAlternateColorCodes('&', format.replaceAll("%message%", message)));
								}
							}
  
						}
					}
				}
			} else {
				p.sendMessage(ChatColor.DARK_RED + "You dont have the required permission note venomkitpvp.staffchat");
			}
			}

		}
		return true;

	}
}