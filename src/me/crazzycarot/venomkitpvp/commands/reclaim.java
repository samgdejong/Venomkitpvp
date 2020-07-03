package me.crazzycarot.venomkitpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.crazzycarot.venomkitpvp.core.main;

public class reclaim implements CommandExecutor {
	private main plugin;
	public reclaim(main main) {plugin = main;}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("reclaim")) {
			String reclaimA = plugin.customConfig.getString("reclaimA.name");
			String reclaimB = plugin.customConfig.getString("reclaimB.name");
			String reclaimC = plugin.customConfig.getString("reclaimC.name");
			String reclaimD = plugin.customConfig.getString("reclaimD.name");
			String reclaimE = plugin.customConfig.getString("reclaimE.name");
			String reclaimF = plugin.customConfig.getString("reclaimF.name");
			String reclaimG = plugin.customConfig.getString("reclaimG.name");

			if (args.length > 0) {
				if (args[0].equals(reclaimA)) {
					if (plugin.customConfig.getString("reclaimA.enabled") == "true") {
						if (plugin.customConfig.getString("claimedA." + sender.getName()) == null) {
							plugin.customConfig.set("claimedA." + sender.getName(), "claimed");
							plugin.saveConfig();
							plugin.savereclaimYml(plugin.customConfig, plugin.reclaimYml);
							String command = plugin.customConfig.getString("reclaimA.command").replaceAll("%player%",
									sender.getName());
							plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "You already claimed this reclaim!");
						}
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "That reclaim is not enabled!");
					}
				}
				if (args[0].equals(reclaimB)) {
					if (plugin.customConfig.getString("reclaimB.enabled") == "true") {
						if (plugin.customConfig.getString("claimedB." + sender.getName()) == null) {
							plugin.customConfig.set("claimedB." + sender.getName(), "claimed");
							plugin.saveConfig();
							plugin.savereclaimYml(plugin.customConfig, plugin.reclaimYml);
							String command = plugin.customConfig.getString("reclaimB.command").replaceAll("%player%",
									sender.getName());
							plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "You already claimed this reclaim!");
						}
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "That reclaim is not enabled!");
					}
				}
				if (args[0].equals(reclaimC)) {
					if (plugin.customConfig.getString("reclaimC.enabled") == "true") {
						if (plugin.customConfig.getString("claimedC." + sender.getName()) == null) {
							plugin.customConfig.set("claimedC." + sender.getName(), "claimed");
							plugin.saveConfig();
							plugin.savereclaimYml(plugin.customConfig, plugin.reclaimYml);
							String command = plugin.customConfig.getString("reclaimC.command").replaceAll("%player%",
									sender.getName());
							plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "You already claimed this reclaim!");
						}
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "That reclaim is not enabled!");
					}
				}
				if (args[0].equals(reclaimD)) {
					if (plugin.customConfig.getString("reclaimD.enabled") == "true") {
						if (plugin.customConfig.getString("claimedD." + sender.getName()) == null) {
							plugin.customConfig.set("claimedD." + sender.getName(), "claimed");
							plugin.saveConfig();
							plugin.savereclaimYml(plugin.customConfig, plugin.reclaimYml);
							String command = plugin.customConfig.getString("reclaimD.command").replaceAll("%player%",
									sender.getName());
							plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "You already claimed this reclaim!");
						}
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "That reclaim is not enabled!");
					}
				}
				if (args[0].equals(reclaimE)) {
					if (plugin.customConfig.getString("reclaimE.enabled") == "true") {
						if (plugin.customConfig.getString("claimedE." + sender.getName()) == null) {
							plugin.customConfig.set("claimedE." + sender.getName(), "claimed");
							plugin.saveConfig();
							plugin.savereclaimYml(plugin.customConfig, plugin.reclaimYml);
							String command = plugin.customConfig.getString("reclaimE.command").replaceAll("%player%",
									sender.getName());
							plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "You already claimed this reclaim!");
						}
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "That reclaim is not enabled!");
					}
				}
				if (args[0].equals(reclaimF)) {
					if (plugin.customConfig.getString("reclaimF.enabled") == "true") {
						if (plugin.customConfig.getString("claimedF." + sender.getName()) == null) {
							plugin.customConfig.set("claimedF." + sender.getName(), "claimed");
							plugin.saveConfig();
							plugin.savereclaimYml(plugin.customConfig, plugin.reclaimYml);
							String command = plugin.customConfig.getString("reclaimF.command").replaceAll("%player%",
									sender.getName());
							plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "You already claimed this reclaim!");
						}
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "That reclaim is not enabled!");
					}
				}
				if (args[0].equals(reclaimG)) {
					if (plugin.customConfig.getString("reclaimG.enabled") == "true") {
						if (plugin.customConfig.getString("claimedG." + sender.getName()) == null) {
							plugin.customConfig.set("claimedG." + sender.getName(), "claimed");
							plugin.saveConfig();
							plugin.savereclaimYml(plugin.customConfig, plugin.reclaimYml);
							String command = plugin.customConfig.getString("reclaimG.command").replaceAll("%player%",
									sender.getName());
							plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "You already claimed this reclaim!");
						}
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "That reclaim is not enabled!");
					}
				}

			}
		}
		return true;
	}
}