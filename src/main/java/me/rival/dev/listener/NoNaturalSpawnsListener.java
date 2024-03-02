package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class NoNaturalSpawnsListener implements Listener {
   Main plugin;

   @EventHandler
   void onMobSpawn(CreatureSpawnEvent e) {
      if (e.getSpawnReason().equals(SpawnReason.NATURAL)) {
         e.setCancelled(true);
      }
   }
   public NoNaturalSpawnsListener(Main main) {
      plugin = main;
   }
}
