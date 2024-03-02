package me.rival.dev.listener;

import java.util.HashMap;
import java.util.UUID;
import me.rival.dev.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnderPearlCooldownListener implements Listener {
   Main plugin;
   private final HashMap<UUID, Long> cooldown = new HashMap<>();

   public EnderPearlCooldownListener(Main main) {
      plugin = main;
   }

   private static int compare(long one, long two) {
      return Long.compare(one - two, 0L);
   }

   @EventHandler
   public void onPlayerInteract(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      
      if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
         return;
      }
      
      if (p.getItemInHand().getType() != Material.ENDER_PEARL) {
         return;
      }      
     
      if (cooldown.containsKey(p.getUniqueId()) && compare(cooldown.get(p.getUniqueId()), System.currentTimeMillis()) > 0) {
         e.setCancelled(true);

         String message = CC.translate(plugin.getConfig().getString("EnderPearl-Cooldown"));

         long remaining = cooldown.get(p.getUniqueId()) - System.currentTimeMillis();
         String seconds = String.valueOf(remaining / 1000L);

         message = message.replace("%time%", seconds);
         p.sendMessage(CC.translate(message));
         return;
      }

      cooldown.put(p.getUniqueId(), System.currentTimeMillis() + 16000L);
   }
}
