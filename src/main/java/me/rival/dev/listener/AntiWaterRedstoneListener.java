package me.rival.dev.listener;

import java.util.List;
import me.rival.dev.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class AntiWaterRedstoneListener implements Listener {
   Main plugin;

   public AntiWaterRedstoneListener(Main main) {
      plugin = main;
   }

   @EventHandler
   public void onWaterMove(BlockFromToEvent e) {
      List<String> stringList = plugin.getConfig().getStringList("AntiWater-Break");
      String brokenType = e.getToBlock().getType().toString();
      if (stringList.contains(brokenType)) {
         e.setCancelled(true);
      }
   }
}
