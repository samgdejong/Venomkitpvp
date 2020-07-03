package me.crazzycarot.venomkitpvp.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.crazzycarot.venomkitpvp.core.main;

public class freeze implements Listener, CommandExecutor {
	private main plugin;

	public freeze(main main) {
		plugin = main;
        Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	ArrayList<String> freeze = new ArrayList<>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("freeze")) {
			if (args.length > 0) {
				if (Bukkit.getPlayer(args[0]) instanceof Player) {
					Player target = Bukkit.getPlayer(args[0]);
					if (freeze.contains(target.getName())) {
						freeze.remove(target.getName());
						sender.sendMessage(ChatColor.RED + target.getName() + " has succesfully been unfrozen");
						target.sendMessage(ChatColor.RED + "You have been frozen! You cant move anymore");

					} else {
						if (!(freeze.contains(target.getName()))) {
							freeze.add(target.getName());
							sender.sendMessage(ChatColor.RED + target.getName() + " has succesfully been frozen");
							target.sendMessage(ChatColor.RED + "You have been frozen! You cant move anymore");
						}
					}
				} else {
					sender.sendMessage(ChatColor.RED + "That is not a player");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Wrong usage execute: /freeze <playername>");
			}
		}
		return true;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (freeze.contains(e.getPlayer().getName())) {
			for (Player all : Bukkit.getServer().getOnlinePlayers()) {
				if (all.hasPermission("freeze.use")) {
					all.sendMessage(
							ChatColor.RED + e.getPlayer().getName() + " has joined the server, but he is frozen!");

				}
			}

		}
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		if (freeze.contains(e.getPlayer().getName())) {
			for (Player all : Bukkit.getServer().getOnlinePlayers()) {
				if (all.hasPermission("freeze.use")) {
					all.sendMessage(
							ChatColor.RED + e.getPlayer().getName() + " has left the server, but he is frozen!");

				}
			}

		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (freeze.contains(e.getPlayer().getName())) {
			e.setTo(e.getFrom());
		}
	}

	@EventHandler
	public void onItemDrom(PlayerDropItemEvent e) {
		if (freeze.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to break blocks while you are freezed.");
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (freeze.contains(p.getName())) {
				e.setDamage(0.0);
			}
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if (freeze.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlockPlace(BlockBreakEvent e) {
		if (freeze.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
}
