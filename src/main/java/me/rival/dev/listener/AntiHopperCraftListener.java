package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;

public class AntiHopperCraftListener implements Listener {
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private static final int[] ll;

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onDarkZoneFix3(FurnaceSmeltEvent lllllllllIllIlI) {
      if (lllllllllIllIlI.getResult().getType() == Material.NETHER_BRICK_ITEM) {
         lllllllllIllIlI.setCancelled((boolean)ll[1]);
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onCraft(CraftItemEvent lllllllllIlIlIl) {
      Player lllllllllIlIlII = (Player)lllllllllIlIlIl.getWhoClicked();
      if (lllllllllIlIlIl.getRecipe().getResult().getType() == Material.HOPPER) {
         lllllllllIlIlIl.setCancelled((boolean)ll[1]);
         lllllllllIlIlII.sendMessage(CC.translate(lllllllllIlIllI.plugin.getConfig().getString("Cannot-craft-hopper")));
      }

   }

   public AntiHopperCraftListener(Main lllllllllllIIII) {
      lllllllllllIIIl.plugin = lllllllllllIIII;
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onDarkZoneFix2(CraftItemEvent llllllllllIIIlI) {
      boolean lllllllllIllllI = (Player)llllllllllIIIlI.getWhoClicked();
      if (llllllllllIIIlI.getRecipe().getResult().getType() == Material.INK_SACK && llllllllllIIIlI.getRecipe().getResult().getDurability() == ll[2]) {
         llllllllllIIIlI.setCancelled((boolean)ll[1]);
         lllllllllIllllI.sendMessage(CC.translate(llllllllllIIIII.plugin.getConfig().getString("Cannot-craft-hopper")));
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onDarkZoneFix1(CraftItemEvent llllllllllIlIll) {
      long llllllllllIIlll = (Player)llllllllllIlIll.getWhoClicked();
      if (llllllllllIlIll.getRecipe().getResult().getType() == Material.INK_SACK && llllllllllIlIll.getRecipe().getResult().getDurability() == ll[0]) {
         llllllllllIlIll.setCancelled((boolean)ll[1]);
         llllllllllIIlll.sendMessage(CC.translate(llllllllllIlIIl.plugin.getConfig().getString("Cannot-craft-hopper")));
      }

   }

   static {
      I();
   }

   private static void I() {
      ll = new int[3];
      ll[0] = 79 ^ 31 ^ 154 ^ 198;
      ll[1] = " ".length();
      ll[2] = 107 + 142 - 92 + 15 ^ 21 + 86 - 89 + 148;
   }
}
