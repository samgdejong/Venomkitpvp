package me.crazzycarot.venomkitpvp.events;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.crazzycarot.venomkitpvp.core.main;

public class killstreak implements Listener {

	private main plugin;

	public killstreak(main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	

	public static HashMap<String, Integer> killstreak = new HashMap<String, Integer>();
	{}

	@SuppressWarnings({ "unlikely-arg-type", "static-access" })
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getEntity().getKiller() instanceof Player) {
				Player attacker = e.getEntity().getPlayer().getKiller();
				Player victim = e.getEntity().getPlayer();
				if (plugin.getConfig().getString("killstreak.enabled").contentEquals("true")) {
					if (this.killstreak.containsKey(victim)) {
						this.killstreak.remove(victim);
						String message1 = plugin.getConfig().getString("killstreak.messagelost").replaceAll("%player%",
								victim.getName());
						victim.sendMessage(message1);
					} else {
						addtokillstreak(attacker);

					}

				}
			}
		}
	}

	@SuppressWarnings("static-access")
	public void addtokillstreak(Player attacker) {
		String name = attacker.getName();
		if (this.killstreak.containsKey(name)) {
			int kills = ((Integer) this.killstreak.get(name)).intValue();
			kills++;
			this.killstreak.put(name, Integer.valueOf(kills));
			String message = plugin.getConfig().getString("killstreak.messagecurrent").replaceAll("%killstreak%",
					Integer.toString(kills));
			attacker.sendMessage(message);

		} else {
			this.killstreak.put(name, Integer.valueOf(1));

		}
	}
}