package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class NoNaturalSpawnsListener implements Listener {
   // $FF: synthetic field
   private static final int[] lIIl;
   // $FF: synthetic field
   Main plugin;

   @EventHandler
   void onMobSpawn(CreatureSpawnEvent lllllllIIlllIIl) {
      if (lllllllIIlllIIl.getSpawnReason().equals(SpawnReason.NATURAL)) {
         lllllllIIlllIIl.setCancelled((boolean)lIIl[0]);
      }

   }

   public NoNaturalSpawnsListener(Main lllllllIIllllIl) {
      lllllllIlIIIIII.plugin = lllllllIIllllIl;
   }

   private static void llI() {
      lIIl = new int[1];
      lIIl[0] = " ".length();
   }

   static {
      llI();
   }
}
