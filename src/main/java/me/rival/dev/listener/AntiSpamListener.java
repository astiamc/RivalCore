package me.rival.dev.listener;

import java.util.HashSet;
import java.util.Set;

import me.rival.dev.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class AntiSpamListener implements Listener {
    Main plugin;
    Set<String> antispam = new HashSet<>();

    public AntiSpamListener(Main main) {
        plugin = main;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        final Player player = e.getPlayer();
        plugin.time *= 20L;
        boolean containsPlayer = antispam.contains(player.getName());
        if (player.hasPermission("antispam.bypass")) {
            return;
        }
        if (containsPlayer) {
            e.setCancelled(true);
            player.sendMessage(plugin.getConfig().getString("dont-spam"));
            return;
        }

        antispam.add(player.getName());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            antispam.remove(player.getName());
        }, plugin.time);
    }
}
