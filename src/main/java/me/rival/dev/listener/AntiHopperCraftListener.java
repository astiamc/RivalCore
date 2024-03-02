package me.rival.dev.listener;

import me.rival.dev.Main;
import me.rival.dev.util.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;

public class AntiHopperCraftListener implements Listener {
    private final Main plugin = Main.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDarkZoneFix3(FurnaceSmeltEvent e) {
        if (e.getResult().getType() == Material.NETHER_BRICK_ITEM) {
            e.setCancelled(true);
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCraft(CraftItemEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getRecipe().getResult().getType() == Material.HOPPER) {
            e.setCancelled(true);
            p.sendMessage(CC.translate(plugin.getConfig().getString("Cannot-craft-hopper")));
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDarkZoneFix2(CraftItemEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getRecipe().getResult().getType() == Material.INK_SACK && e.getRecipe().getResult().getDurability() == 10) {
            e.setCancelled(true);
            p.sendMessage(CC.translate(plugin.getConfig().getString("Cannot-craft-hopper")));
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDarkZoneFix1(CraftItemEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getRecipe().getResult().getType() == Material.INK_SACK && e.getRecipe().getResult().getDurability() == 12) {
            e.setCancelled(true);
            p.sendMessage(CC.translate(plugin.getConfig().getString("Cannot-craft-hopper")));
        }

    }
}
