package me.rival.dev.listener;

import java.util.HashSet;
import java.util.Set;
import me.rival.dev.Main;
import me.rival.dev.listener.AntiSpamListener.1;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class AntiSpamListener implements Listener {
   // $FF: synthetic field
   long time;
   // $FF: synthetic field
   private static final int[] lIII;
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   Set<String> antispam;

   public AntiSpamListener(Main lllllllIlIIllll) {
      lllllllIlIlIIlI.plugin = lllllllIlIIllll;
      lllllllIlIlIIlI.antispam = new HashSet();
   }

   private static void lIl() {
      lIII = new int[1];
      lIII[0] = " ".length();
   }

   static {
      lIl();
   }

   @EventHandler
   public void onPlayerChat(AsyncPlayerChatEvent lllllllIlIIIlIl) {
      int lllllllIlIIIlII = lllllllIlIIIlIl.getPlayer();
      lllllllIlIIIllI.time *= 20L;
      float lllllllIlIIIIll = lllllllIlIIIllI.antispam.contains(lllllllIlIIIlII.getName());
      if (!lllllllIlIIIlII.hasPermission("antispam.bypass")) {
         if (!lllllllIlIIIIll) {
            lllllllIlIIIllI.antispam.add(lllllllIlIIIlII.getName());
            "".length();
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)lllllllIlIIIllI, new 1(lllllllIlIIIllI, lllllllIlIIIlII), lllllllIlIIIllI.time);
            "".length();
            "".length();
            if (((69 ^ 87) & ~(72 ^ 90)) != 0) {
               return;
            }
         } else {
            lllllllIlIIIlIl.setCancelled((boolean)lIII[0]);
            lllllllIlIIIlII.sendMessage(lllllllIlIIIllI.plugin.getConfig().getString("dont-spam"));
         }
      }

   }
}
