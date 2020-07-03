package me.crazzycarot.venomkitpvp.events;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.crazzycarot.venomkitpvp.core.main;

public class Kitselector implements Listener {
	private main plugin;
	
    public Kitselector(main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    
	public static void createCustomItem(ItemStack mat, String displayName, int itemPlace, Inventory inv,
			String... lore) {
		ItemStack menu1 = new ItemStack(mat);
		ItemMeta shop1 = menu1.getItemMeta();
		shop1.setDisplayName(displayName);
		shop1.setLore(Arrays.asList(lore));
		menu1.setItemMeta(shop1);

		inv.contains(menu1);
		inv.setItem(itemPlace, menu1);
	}
    
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
    	if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR) {
    		if (e.getPlayer().getItemInHand().getType().equals(Material.BLAZE_ROD)) {
    		Player p = e.getPlayer();
    		String command = plugin.getConfig().getString("kitselector.command");
    		p.chat("/" + command);
    		}
    	}
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
		if (!(e.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("arenas.arena1.spawn.world")))) {
			if (!(e.getPlayer().getLocation().getWorld().getName().equals("arena1"))) {
				createCustomItem(new ItemStack(Material.BLAZE_ROD), ChatColor.DARK_RED + "Kit Selector", 4, e.getPlayer().getInventory(), ChatColor.GRAY + "Right click to select a kit");
			}
    		
    	}
		if (!(e.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("arenas.arena1.spawn.world")))) {
			if (!(e.getPlayer().getLocation().getWorld().getName().equals("arena2"))) {
				createCustomItem(new ItemStack(Material.BLAZE_ROD), ChatColor.DARK_RED + "Kit Selector", 4, e.getPlayer().getInventory(), ChatColor.GRAY + "Right click to select a kit");
			}
    		
    	}
		if (!(e.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("arenas.arena1.spawn.world")))) {
			if (!(e.getPlayer().getLocation().getWorld().getName().equals("arena3"))) {
				createCustomItem(new ItemStack(Material.BLAZE_ROD), ChatColor.DARK_RED + "Kit Selector", 4, e.getPlayer().getInventory(), ChatColor.GRAY + "Right click to select a kit");
			}
    		
    	}
    }
    
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
    	if (e.getEntity() instanceof Player) {
    	Player p = e.getEntity().getPlayer();
				createCustomItem(new ItemStack(Material.BLAZE_ROD), ChatColor.DARK_RED + "Kit Selector", 4, p.getInventory(), ChatColor.GRAY + "Right click to select a kit");
			
    		
    	}
    	
    }
    
    
    
}
