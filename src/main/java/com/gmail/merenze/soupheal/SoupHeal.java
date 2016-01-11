package com.gmail.merenze.soupheal;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SoupHeal extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
	    getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getItem().equals(new ItemStack(Material.MUSHROOM_SOUP))) {
			Player user = e.getPlayer();
			double health = user.getHealth();
			
			if (health>=14.0) {
				if (health<20.0) {
				user.setHealth(20.0);
				user.setItemInHand(new ItemStack(Material.BOWL,1));
				}
			} else {
				user.setHealth(user.getHealth() + 6.0);
				user.setItemInHand(new ItemStack(Material.BOWL, 1));
			}
		}
	}
	@Override
	public void onDisable() {
		this.getLogger().info("SoupHeal plugin has terminated!");
	}
}
