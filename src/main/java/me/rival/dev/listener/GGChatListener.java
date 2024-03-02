package me.rival.dev.listener;

import java.util.List;
import me.rival.dev.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class GGChatListener implements Listener {
   // $FF: synthetic field
   private final Main plugin;

   public GGChatListener(Main llllllIIlllllII) {
      llllllIIlllllIl.plugin = llllllIIlllllII;
   }

   private static int llIl(long var0, long var2) {
      long var4;
      return (var4 = var0 - var2) == 0L ? 0 : (var4 < 0L ? -1 : 1);
   }

   @EventHandler(
      priority = EventPriority.LOW
   )
   public void onChat(AsyncPlayerChatEvent llllllIIlllIIlI) {
      if (llllllIIlllIIlI.getMessage().equalsIgnoreCase("GG") && llIl(llllllIIlllIlll.plugin.getTimeL(), System.currentTimeMillis()) >= 0) {
         List llllllIIlllIlIl = llllllIIlllIlll.plugin.getGGs();
         if (!llllllIIlllIlIl.isEmpty()) {
            String llllllIIlllIlII = (String)llllllIIlllIlIl.get(llllllIIlllIlll.plugin.getRandom().nextInt(llllllIIlllIlIl.size()));
            llllllIIlllIIlI.setMessage(CC.translate(llllllIIlllIlII));
         }
      }

   }
}
