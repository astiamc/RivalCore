package me.rival.dev.listener;

import java.util.ArrayList;
import java.util.List;
import me.rival.dev.Main;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class FixesListener implements Listener {
   // $FF: synthetic field
   private final List<DamageCause> damage;
   // $FF: synthetic field
   private Main plugin;
   // $FF: synthetic field
   private static final int[] lIIlI;

   static {
      lllI();
   }

   public FixesListener(Main llllllIIllIllII) {
      llllllIIllIllIl.plugin = llllllIIllIllII;
      (llllllIIllIllIl.damage = new ArrayList()).add(DamageCause.LAVA);
      "".length();
      llllllIIllIllIl.damage.add(DamageCause.FIRE);
      "".length();
      llllllIIllIllIl.damage.add(DamageCause.FIRE_TICK);
      "".length();
      llllllIIllIllIl.damage.add(DamageCause.BLOCK_EXPLOSION);
      "".length();
      llllllIIllIllIl.damage.add(DamageCause.ENTITY_EXPLOSION);
      "".length();
   }

   private static void lllI() {
      lIIlI = new int[2];
      lIIlI[0] = " ".length();
      lIIlI[1] = (36 ^ 0) & ~(46 ^ 10);
   }

   @EventHandler
   public void onCreeperAntiGlitch(EntityDamageEvent llllllIIlIIlIII) {
      if (llllllIIlIIlIII.getEntity().getType().equals(EntityType.CREEPER) && (llllllIIlIIlIII.getCause().equals(DamageCause.DROWNING) || llllllIIlIIlIII.getCause().equals(DamageCause.SUFFOCATION))) {
         llllllIIlIIlIII.getEntity().remove();
      }

   }

   @EventHandler
   public void onExplosionDamage(EntityDamageEvent llllllIIlIIIlII) {
      if (llllllIIlIIIlII.getEntity() instanceof Player && llllllIIlIIIIll.isExplosion(llllllIIlIIIlII.getCause())) {
         llllllIIlIIIlII.setCancelled((boolean)lIIlI[0]);
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onEndermanTeleport(EntityTeleportEvent llllllIIlIlIllI) {
      int llllllIIlIlIIll = llllllIIlIlIllI.getEntityType();
      if (llllllIIlIlIIll.equals(EntityType.ENDERMAN)) {
         llllllIIlIlIllI.setCancelled((boolean)lIIlI[0]);
      }

   }

   private boolean damageCause(DamageCause llllllIIllIIllI) {
      return llllllIIllIIlIl.damage.contains(llllllIIllIIllI);
   }

   private boolean isExplosion(DamageCause llllllIIIlllllI) {
      return (boolean)(!llllllIIIlllllI.equals(DamageCause.ENTITY_EXPLOSION) && !llllllIIIlllllI.equals(DamageCause.BLOCK_EXPLOSION) ? lIIlI[1] : lIIlI[0]);
   }

   @EventHandler
   public void onWItherSpawn(EntitySpawnEvent llllllIIlIIllll) {
      if (!llllllIIlIIllll.isCancelled()) {
         String llllllIIlIIllII = llllllIIlIIllll.getEntityType();
         if (llllllIIlIIllII.toString().toUpperCase().contains("WITHER")) {
            llllllIIlIIllll.setCancelled((boolean)lIIlI[0]);
         }

      }
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void antiitemburn(EntityDamageEvent llllllIIlIllllI) {
      if (!llllllIIlIllllI.isCancelled() && llllllIIlIllllI.getEntity() instanceof Item && llllllIIllIIIIl.damageCause(llllllIIlIllllI.getCause())) {
         llllllIIlIllllI.setCancelled((boolean)lIIlI[0]);
      }

   }

   @EventHandler
   public void onBlazeWaterDamage(EntityDamageEvent llllllIIlIllIll) {
      if (!llllllIIlIllIll.isCancelled()) {
         if (llllllIIlIllIll.getEntity() instanceof Blaze && llllllIIlIllIll.getCause().equals(DamageCause.DROWNING)) {
            llllllIIlIllIll.setCancelled((boolean)lIIlI[0]);
         }

      }
   }
}
