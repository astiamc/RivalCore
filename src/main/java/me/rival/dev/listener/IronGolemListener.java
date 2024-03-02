package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class IronGolemListener implements Listener {
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private static final int[] lIll;

   static {
      lll();
   }

   public IronGolemListener(Main lllllllIIllIlIl) {
      lllllllIIllIllI.plugin = lllllllIIllIlIl;
   }

   private static void lll() {
      lIll = new int[1];
      lIll[0] = -(-11269 & 31918) & -2119 & 32767;
   }

   @EventHandler
   public void BurnGolem(CreatureSpawnEvent lllllllIIllIIII) {
      if (lllllllIIllIIII.getSpawnReason() == SpawnReason.SPAWNER && lllllllIIllIIII.getEntityType() == EntityType.IRON_GOLEM) {
         lllllllIIllIIII.getEntity().setHealth(2.0D);
         lllllllIIllIIII.getEntity().setFireTicks(lIll[0]);
      }

   }
}
