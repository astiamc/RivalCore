package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessageListener implements Listener {
   // $FF: synthetic field
   Main plugin;

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onDeath(PlayerDeathEvent llllIllllllIllI) {
      Player llllIlllllllllI = llllIllllllIllI.getEntity();
      Player llllIllllllllIl = llllIlllllllllI.getKiller();
      if (llllIllllllllIl instanceof Player && !llllIllllllllIl.getName().equalsIgnoreCase(llllIlllllllllI.getName())) {
         String llllIllllllllII = CC.translate(llllIllllllIlll.plugin.getConfig().getString("Death-Message"));
         int llllIlllllllIll = llllIlllllllllI.getStatistic(Statistic.PLAYER_KILLS);
         int llllIllllllIIIl = llllIllllllllIl.getStatistic(Statistic.PLAYER_KILLS);
         long llllIllllllIIII = String.valueOf((new StringBuilder()).append(llllIlllllllIll));
         char llllIlllllIllll = String.valueOf((new StringBuilder()).append(llllIllllllIIIl));
         llllIllllllllII = llllIllllllllII.replaceAll("%player%", llllIlllllllllI.getName());
         llllIllllllllII = llllIllllllllII.replaceAll("%killer%", llllIllllllllIl.getName());
         llllIllllllllII = llllIllllllllII.replaceAll("%playerkills%", llllIllllllIIII);
         llllIllllllllII = llllIllllllllII.replaceAll("%killerkills%", llllIlllllIllll);
         llllIllllllIllI.setDeathMessage(llllIllllllllII);
         llllIllllllllIl.getLocation().getWorld().playSound(llllIllllllllIl.getLocation(), Sound.FIREWORK_LARGE_BLAST, 5.0F, 1.0F);
         llllIllllllllIl.playSound(llllIllllllllIl.getLocation(), Sound.GHAST_SCREAM, 2.14748365E9F, 2.0F);
      }

   }

   @EventHandler(
      priority = EventPriority.HIGH
   )
   public void DamageEvent(EntityDamageByEntityEvent lllllIIIIlIIIIl) {
      if (lllllIIIIlIIIIl.getDamager() instanceof Arrow) {
         Exception lllllIIIIIlIIlI = (Arrow)lllllIIIIlIIIIl.getDamager();
         if (lllllIIIIIlIIlI.getShooter() instanceof Player) {
            long lllllIIIIIlIIIl = (Player)lllllIIIIIlIIlI.getShooter();
            String lllllIIIIIlIIII = (Damageable)lllllIIIIlIIIIl.getEntity();
            String lllllIIIIIlllII = CC.translate(lllllIIIIlIIIlI.plugin.getConfig().getString("Bow-Damage"));
            if (lllllIIIIIlIIII instanceof Player) {
               int lllllIIIIIIlllI = (Player)lllllIIIIIlIIII;
               Exception lllllIIIIIIllIl = lllllIIIIIlIIII.getHealth();
               long lllllIIIIIIllII = (int)lllllIIIIlIIIIl.getFinalDamage();
               lllllIIIIIlllII = lllllIIIIIlllII.replaceAll("%player%", lllllIIIIIIlllI.getName());
               if (!lllllIIIIIlIIII.isDead()) {
                  double lllllIIIIIIlIll = (int)(lllllIIIIIIllIl - (double)lllllIIIIIIllII);
                  Exception lllllIIIIIIlIlI = String.valueOf((new StringBuilder()).append(lllllIIIIIIlIll));
                  lllllIIIIIlllII = lllllIIIIIlllII.replaceAll("%player%", lllllIIIIIIlllI.getName());
                  lllllIIIIIlllII = lllllIIIIIlllII.replaceAll("%health%", lllllIIIIIIlIlI);
                  if (lllllIIIIIIlIll > 0) {
                     lllllIIIIIlIIIl.sendMessage(CC.translate(lllllIIIIIlllII));
                  }
               }
            }
         }
      }

   }

   public DeathMessageListener(Main lllllIIIIllIlll) {
      lllllIIIIlllIlI.plugin = lllllIIIIllIlll;
   }
}
