package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldBorder;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;

public class WorldBorderListener implements Listener {

    private static int compare(double var1, double var2) {
        return Double.compare(var1, var2);
    }

    @EventHandler
    void onEnderPearlBorder(PlayerTeleportEvent e) {
        Player p = e.getPlayer();
        if (e.getCause() == TeleportCause.ENDER_PEARL && isOutsideOfBorder(e.getTo())) {
            e.setCancelled(true);
            p.sendMessage(CC.translate("&cYou cannot pearl trough the border."));
        }
    }

    @EventHandler
    void onBorder(EntityChangeBlockEvent e) {
        if (e.getEntityType() == EntityType.FALLING_BLOCK) {
            Location loc = e.getEntity().getLocation();
            if (e.getTo() != Material.AIR) {
                loc.getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(e.getTo()));
                e.setCancelled(true);
            }
        }
    }

    boolean isOutsideOfBorder(Location loc) {
        WorldBorder border = loc.getWorld().getWorldBorder();
        double x = loc.getX();
        double z = loc.getZ();
        double radius = border.getSize() / 2.0D;

        return compare(x, radius) >= 0 || compare(-x, radius) >= 0 || compare(z, radius) >= 0 || compare(-z, radius) >= 0;
    }
}
