package me.rival.dev.listener;

import java.util.List;
import me.rival.dev.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class GGChatListener implements Listener {
   private final Main plugin;

   public GGChatListener(Main main) {
      plugin = main;
   }

   private static int compare(long v1, long v2) {
      return Long.compare(v1 - v2, 0L);
   }

   @EventHandler(priority = EventPriority.LOW)
   public void onChat(AsyncPlayerChatEvent e) {
      if (!(e.getMessage().equalsIgnoreCase("GG") && compare(plugin.getTime(), System.currentTimeMillis()) >= 0)) {
         return;
      }

      List<String> ggs = plugin.getGGs();
      if (!ggs.isEmpty()) {
         String someMessage = ggs.get(plugin.getRandom().nextInt(ggs.size()));
         e.setMessage(CC.translate(someMessage));
      }
   }
}
