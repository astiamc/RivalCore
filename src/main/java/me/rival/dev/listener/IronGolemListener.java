package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class IronGolemListener implements Listener {
   Main plugin;
   public IronGolemListener(Main main) {
      plugin = main;
   }

   @EventHandler
   public void BurnGolem(CreatureSpawnEvent e) {
      if (e.getSpawnReason() == SpawnReason.SPAWNER && e.getEntityType() == EntityType.IRON_GOLEM) {
         e.getEntity().setHealth(2.0D);
         e.getEntity().setFireTicks(10000);
      }

   }
}
