package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class WelcomeListener implements Listener {
   Main plugin;

   @EventHandler
   public void join(PlayerJoinEvent e) {
      Player p = e.getPlayer();

      // Clear chat
      for (int i = 0; i < 150; i++) {
         p.sendMessage("");
      }

      // Print out welcome message
      for (String i : plugin.getConfig().getStringList("Welcome-Message")) {
         i = i.replace("{onlineCount}", Integer.toString(Bukkit.getOnlinePlayers().size()));
         i = i.replace("{maxCount}", Integer.toString(Bukkit.getMaxPlayers()));
         i = i.replace("&", "§");
         e.getPlayer().sendMessage(i);
      }
   }

   public WelcomeListener(Main main) {
      plugin = main;
   }
}
