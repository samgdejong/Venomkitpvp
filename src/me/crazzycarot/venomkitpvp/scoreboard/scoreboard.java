package me.crazzycarot.venomkitpvp.scoreboard;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.crazzycarot.venomkitpvp.core.main;

public class scoreboard implements Listener {

	private main plugin;

	public scoreboard(main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	
	

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {

		ScoreboardManager manager = Bukkit.getScoreboardManager();
		@SuppressWarnings("unused")
		final Scoreboard board = manager.getNewScoreboard();
		final Player p = e.getPlayer();

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {

				String scoreboardtitle = plugin.getConfig().getString("scoreboard.title");
				String scoreboardline1 = plugin.getConfig().getString("scoreboard.line1");
				String scoreboardline2 = plugin.getConfig().getString("scoreboard.line2");
				String scoreboardline3 = plugin.getConfig().getString("scoreboard.line3");
				String scoreboardline4 = plugin.getConfig().getString("scoreboard.line4");
				String scoreboardline5 = plugin.getConfig().getString("scoreboard.line5");
				String scoreboardline6 = plugin.getConfig().getString("scoreboard.line6");
				String scoreboardline7 = plugin.getConfig().getString("scoreboard.line7");
				String scoreboardline8 = plugin.getConfig().getString("scoreboard.line8");
				String scoreboardline9 = plugin.getConfig().getString("scoreboard.line9");
				String scoreboardline10 = plugin.getConfig().getString("scoreboard.line10");
				String scoreboardline11 = plugin.getConfig().getString("scoreboard.line11");
					
							
				String name = e.getPlayer().getName();

				String deaths = plugin.getConfig().getString("deaths." + e.getPlayer().getUniqueId());
				String kills = plugin.getConfig().getString("kills." + e.getPlayer().getUniqueId());

				
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				final Scoreboard board = manager.getNewScoreboard();
				final Objective objective = board.registerNewObjective("test", "dummy");
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.setDisplayName(ChatColor.RED + scoreboardtitle);
				Score score1 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline1).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score1.setScore(16);
				Score score2 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline2).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score2.setScore(15);
				Score score3 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline3).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score3.setScore(14);
				Score score4 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline4).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score4.setScore(13);
				Score score5 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline5).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score5.setScore(12);
				Score score6 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline6).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score6.setScore(11);
				Score score7 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline7).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score7.setScore(10);
				Score score8 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline8).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score8.setScore(9);
				Score score9 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline9).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score9.setScore(8);
				Score score10 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline10).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score10.setScore(6);
				Score score11 = objective.getScore(ChatColor.translateAlternateColorCodes('&', scoreboardline11).replaceAll("%player%", name).replaceAll("%kills%", kills).replaceAll("%deaths%", deaths));
				score11.setScore(5);
				p.setScoreboard(board);

			}
		}, 0, 20 * 10);

	}

}
