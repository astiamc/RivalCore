package me.rival.dev.listener;

import java.util.List;
import me.rival.dev.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class AntiWaterRedstoneListener implements Listener {
   // $FF: synthetic field
   private static final int[] lIllI;
   // $FF: synthetic field
   Main plugin;

   static {
      lIIlI();
   }

   public AntiWaterRedstoneListener(Main lllllIIllIIlIII) {
      lllllIIllIIIlll.plugin = lllllIIllIIlIII;
   }

   private static void lIIlI() {
      lIllI = new int[1];
      lIllI[0] = " ".length();
   }

   @EventHandler
   public void onWaterMove(BlockFromToEvent lllllIIlIllllII) {
      List<String> lllllIIlIlllIll = lllllIIlIllllIl.plugin.getConfig().getStringList("AntiWater-Break");
      long lllllIIlIlllIlI = lllllIIlIllllII.getToBlock().getType().toString();
      if (lllllIIlIlllIll.contains(lllllIIlIlllIlI)) {
         lllllIIlIllllII.setCancelled((boolean)lIllI[0]);
      }

   }
}
