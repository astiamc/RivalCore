package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessageListener implements Listener {

   private final Main plugin;

   @EventHandler(priority = EventPriority.HIGHEST)
   public void onDeath(PlayerDeathEvent e) {
      Player p = e.getEntity();
      Player killer = p.getKiller();
      if (killer.getName().equalsIgnoreCase(p.getName())) {
         return;
      }

      String message = CC.translate(plugin.getConfig().getString("Death-Message"));
      String player_kills = String.valueOf(p.getStatistic(Statistic.PLAYER_KILLS));
      String killer_kills = String.valueOf(killer.getStatistic(Statistic.PLAYER_KILLS));
      message = message.replaceAll("%player%", p.getName());
      message = message.replaceAll("%killer%", killer.getName());
      message = message.replaceAll("%playerkills%", player_kills);
      message = message.replaceAll("%killerkills%", killer_kills);

      e.setDeathMessage(message);

      killer.getLocation().getWorld().playSound(killer.getLocation(), Sound.FIREWORK_LARGE_BLAST, 5.0F, 1.0F);
      killer.playSound(killer.getLocation(), Sound.GHAST_SCREAM, 2.14748365E9F, 2.0F);
   }

   @EventHandler(priority = EventPriority.HIGH)
   public void DamageEvent(EntityDamageByEntityEvent e) {
      if (!(e.getDamager() instanceof Arrow)) {
         return;
      }

      Entity damager = e.getDamager();
      if (!(damager instanceof Player)) {
         return;
      }

      Entity damaged = e.getEntity();
      String messsage = CC.translate(plugin.getConfig().getString("Bow-Damage"));
      if (!(damaged instanceof Player target)) {
         return;
      }

      double health = target.getHealth();
      double damage = e.getFinalDamage();
      messsage = messsage.replaceAll("%player%", target.getName());

      if (!damaged.isDead()) {
         String newHP = String.valueOf(health - damage);
         messsage = messsage.replaceAll("%player%", target.getName());
         messsage = messsage.replaceAll("%health%", newHP);
         if (Double.parseDouble(newHP) > 0) {
            damager.sendMessage(CC.translate(messsage));
         }
      }

   }

   public DeathMessageListener(Main main) {
      plugin = main;
   }
}
