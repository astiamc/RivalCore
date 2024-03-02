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
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private static final int[] lIIllI;
   // $FF: synthetic field
   private HashMap<UUID, Long> cooldown;

   public EnderPearlCooldownListener(Main llllIllIlIIllII) {
      llllIllIlIIllIl.plugin = llllIllIlIIllII;
      llllIllIlIIllIl.cooldown = new HashMap();
   }

   private static int lIIIII(long var0, long var2) {
      long var4;
      return (var4 = var0 - var2) == 0L ? 0 : (var4 < 0L ? -1 : 1);
   }

   static {
      lllll();
   }

   private static void lllll() {
      lIIllI = new int[1];
      lIIllI[0] = " ".length();
   }

   @EventHandler
   public void onPlayerInteract(PlayerInteractEvent llllIllIIllllII) {
      Player llllIllIlIIIIIl = llllIllIIllllII.getPlayer();
      if ((llllIllIIllllII.getAction() == Action.RIGHT_CLICK_AIR || llllIllIIllllII.getAction() == Action.RIGHT_CLICK_BLOCK) && llllIllIlIIIIIl.getItemInHand().getType() == Material.ENDER_PEARL) {
         if (llllIllIIllllIl.cooldown.containsKey(llllIllIlIIIIIl.getUniqueId()) && lIIIII((Long)llllIllIIllllIl.cooldown.get(llllIllIlIIIIIl.getUniqueId()), System.currentTimeMillis()) > 0) {
            llllIllIIllllII.setCancelled((boolean)lIIllI[0]);
            float llllIllIIlllIlI = CC.translate(llllIllIIllllIl.plugin.getConfig().getString("EnderPearl-Cooldown"));
            long llllIllIIllllll = (Long)llllIllIIllllIl.cooldown.get(llllIllIlIIIIIl.getUniqueId()) - System.currentTimeMillis();
            String llllIllIIlllllI = String.valueOf((new StringBuilder()).append(llllIllIIllllll / 1000L));
            llllIllIIlllIlI = llllIllIIlllIlI.replace("%time%", llllIllIIlllllI);
            llllIllIlIIIIIl.sendMessage(CC.translate(llllIllIIlllIlI));
            "".length();
            if ((12 + 39 - 19 + 109 ^ 39 + 37 - 45 + 106) > (155 + 8 - 134 + 157 ^ 18 + 96 - -3 + 73)) {
               return;
            }
         } else {
            llllIllIIllllIl.cooldown.put(llllIllIlIIIIIl.getUniqueId(), System.currentTimeMillis() + 16000L);
            "".length();
         }
      }

   }
}
