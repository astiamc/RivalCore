package me.rival.dev.listener;

import java.util.ArrayList;
import me.rival.dev.Main;
import me.rival.dev.config.Config;
import me.rival.dev.listener.DarkZoneListener.1;
import me.rival.dev.listener.DarkZoneListener.2;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DarkZoneListener implements Listener {
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private static final int[] lIlI;

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   public void onBlockBreak333(BlockDamageEvent lllllIlIllIIlIl) {
      Player lllllIlIllIIlII = lllllIlIllIIlIl.getPlayer();
      float lllllIlIlIlllIl = lllllIlIllIIlII.getInventory();
      byte lllllIlIlIlllII = lllllIlIllIIlIl.getBlock();
      ItemStack lllllIlIllIIIIl = lllllIlIllIIlII.getItemInHand();
      boolean lllllIlIlIllIlI = lllllIlIlIlllII.getChunk();
      if (lllllIlIllIIlII.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && lllllIlIllIIlII.getItemInHand().getType().toString().toLowerCase().contains("pickaxe") && (lllllIlIlIlllII.getType() == Material.DIAMOND_ORE || lllllIlIlIlllII.getType() == Material.QUARTZ_ORE || lllllIlIlIlllII.getType() == Material.EMERALD_ORE) && lllllIlIllIIlII.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
         lllllIlIllIIlII.removePotionEffect(PotionEffectType.SLOW_DIGGING);
      }

   }

   @EventHandler(
      priority = EventPriority.LOW,
      ignoreCancelled = true
   )
   public void onBlockBreak2(BlockBreakEvent lllllIlllIllIII) {
      int lllllIllllIlllI = lllllIlllIllIIl.plugin.getConfig().getInt("darkzonegems.min");
      boolean lllllIlllIlIllI = (new ItemBuilder(Material.INK_SACK)).data((short)lIlI[2]).enchant(Enchantment.DURABILITY, lIlI[2]).displayName(CC.translate(lllllIlllIllIIl.plugin.getConfig().getString("darkzone-meteor-uranium-name"))).build();
      double lllllIlllIlIlIl = lllllIlllIllIIl.plugin.getConfig().getInt("darkzonegems.max");
      int lllllIllllIlIll = lllllIlllIllIIl.plugin.getRandom().nextInt(lllllIlllIlIlIl - lllllIllllIlllI) + lllllIllllIlllI;
      String lllllIlllIlIIll = lllllIlllIllIII.getPlayer();
      Exception lllllIlllIlIIlI = lllllIlllIlIIll.getInventory();
      Block lllllIllllIlIII = lllllIlllIllIII.getBlock();
      int lllllIlllIlIIII = lllllIlllIlIIll.getItemInHand();
      Chunk lllllIllllIIllI = lllllIllllIlIII.getChunk();
      if (lllllIlllIlIIll.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && lllllIllllIlIII.getType() == Material.EMERALD_ORE) {
         lllllIlllIllIII.setCancelled((boolean)lIlI[0]);
         Material lllllIllllIIlIl = lllllIllllIlIII.getType();
         String lllllIlllIIllIl = lllllIlllIllIIl.plugin.getRandom().nextInt(lIlI[3]) + lIlI[0];
         lllllIlllIllIII.getBlock().setType(Material.BEDROCK);
         Player lllllIllllIIIll = lllllIlllIllIII.getPlayer();
         (new 1(lllllIlllIllIIl, lllllIllllIIllI, lllllIlllIllIII)).runTaskLater(lllllIlllIllIIl.plugin, 200L);
         "".length();
         ItemStack lllllIlllIIlIll;
         int lllllIlllIlllIl;
         int lllllIlllIIlIIl;
         int lllllIlllIIlIII;
         if (lllllIlllIlIIll.getInventory().firstEmpty() == lIlI[4]) {
            lllllIlllIIlIll = lllllIlllIlIIll.getEquipment().getItemInHand();
            lllllIlllIlllIl = lllllIlllIIlIll.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            lllllIlllIIlIIl = lIlI[0];
            if (lllllIlllIlllIl > 0) {
               lllllIlllIIlIII = lIlI[5];
               "".length();
               if (-"   ".length() > 0) {
                  return;
               }

               for(; lllllIlllIIlIII < lllllIlllIlllIl; ++lllllIlllIIlIII) {
                  if (lllllIlllIllIIl.plugin.getRandom().nextBoolean()) {
                     ++lllllIlllIIlIIl;
                  }
               }
            }

            lllllIlllIlIllI.setAmount(lllllIlllIIlIIl);
            lllllIlllIlIIll.getWorld().dropItem(lllllIlllIlIIll.getLocation(), lllllIlllIlIllI);
            "".length();
            if (Config.getConfig().getBoolean("mining-messages")) {
               lllllIlllIlIIll.sendMessage(CC.translate(lllllIlllIllIIl.plugin.getConfig().getString("darkzone-meteor-uranium")));
               lllllIlllIlIIll.sendMessage(CC.translate(lllllIlllIllIIl.plugin.getConfig().getString("darkzone-meteor-scrap-full")));
               "".length();
               if ((139 ^ 143) <= "  ".length()) {
                  return;
               }
            }
         } else {
            if (Config.getConfig().getBoolean("mining-messages")) {
               lllllIlllIlIIll.sendMessage(CC.translate(lllllIlllIllIIl.plugin.getConfig().getString("darkzone-meteor-uranium")));
            }

            lllllIlllIIlIll = lllllIlllIlIIll.getEquipment().getItemInHand();
            lllllIlllIlllIl = lllllIlllIIlIll.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            lllllIlllIIlIIl = lIlI[0];
            if (lllllIlllIlllIl > 0) {
               lllllIlllIIlIII = lIlI[5];
               "".length();
               if ((88 ^ 92) <= 0) {
                  return;
               }

               for(; lllllIlllIIlIII < lllllIlllIlllIl; ++lllllIlllIIlIII) {
                  if (lllllIlllIllIIl.plugin.getRandom().nextBoolean()) {
                     ++lllllIlllIIlIIl;
                  }
               }
            }

            lllllIlllIlIllI.setAmount(lllllIlllIIlIIl);
            PlayerInventory var10000 = lllllIlllIlIIll.getInventory();
            ItemStack[] var10001 = new ItemStack[lIlI[0]];
            var10001[lIlI[5]] = lllllIlllIlIllI;
            var10000.addItem(var10001);
            "".length();
         }

         String lllllIlllIllIlI = String.valueOf((new StringBuilder()).append(lllllIllllIlIll));
         if (lllllIlllIllIIl.plugin.getConfig().getBoolean("darkzonegems.enabled")) {
            lllllIllllIIIll.sendMessage(CC.translate(lllllIlllIllIIl.plugin.getConfig().getString("darkzonegems.message").replace("%amount%", lllllIlllIllIlI)));
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.valueOf((new StringBuilder("gems add ")).append(lllllIllllIIIll.getName()).append(" ").append(lllllIlllIllIlI)));
            "".length();
         }
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   public void onBlockBreak3333(PlayerItemHeldEvent lllllIlIlllIIIl) {
      char lllllIlIlllIIII = lllllIlIlllIIIl.getPlayer();
      PlayerInventory lllllIlIlllIlII = lllllIlIlllIIII.getInventory();
      ItemStack lllllIlIlllIIll = lllllIlIlllIIII.getItemInHand();
      int lllllIlIlllIIlI = lllllIlIlllIIIl.getNewSlot();
      if (lllllIlIlllIIII.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && !lllllIlIlllIIII.getItemInHand().getType().toString().toLowerCase().contains("pickaxe") && lllllIlIlllIIII.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
         lllllIlIlllIIII.removePotionEffect(PotionEffectType.SLOW_DIGGING);
      }

   }

   @EventHandler
   public void onTeleport(PlayerChangedWorldEvent lllllIllIIIlllI) {
      Player lllllIllIIIllll = lllllIllIIIlllI.getPlayer();
      if (lllllIllIIIllll.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
         lllllIllIIIllll.removePotionEffect(PotionEffectType.SLOW_DIGGING);
      }

   }

   @EventHandler(
      priority = EventPriority.NORMAL,
      ignoreCancelled = true
   )
   public void blockbreak2(BlockBreakEvent llllllIIIIIIlII) {
      Player llllllIIIIIIllI = llllllIIIIIIlII.getPlayer();
      if (llllllIIIIIIllI.getWorld().getName().equals(llllllIIIIIlIII.plugin.getConfig().getString("darkzone-world-name"))) {
         if (llllllIIIIIIllI.hasPermission("rival.darkzonebuild")) {
            return;
         }

         llllllIIIIIIlII.setCancelled((boolean)lIlI[0]);
      }

   }

   static {
      lIII();
   }

   @EventHandler
   public void onBlockBreak33(BlockDamageEvent lllllIlIlIIllII) {
      Player lllllIlIlIlIIIl = lllllIlIlIIllII.getPlayer();
      PlayerInventory lllllIlIlIlIIII = lllllIlIlIlIIIl.getInventory();
      Exception lllllIlIlIIlIIl = lllllIlIlIIllII.getBlock();
      ItemStack lllllIlIlIIlllI = lllllIlIlIlIIIl.getItemInHand();
      long lllllIlIlIIIlll = lllllIlIlIIlIIl.getChunk();
      if (lllllIlIlIlIIIl.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && lllllIlIlIlIIIl.getItemInHand().getType().toString().toLowerCase().contains("pickaxe")) {
         lllllIlIlIlIIIl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, lIlI[7], lIlI[8]));
         "".length();
      }

   }

   @EventHandler(
      priority = EventPriority.MONITOR,
      ignoreCancelled = true
   )
   public void onPortal(PlayerPortalEvent llllllIIIIlllll) {
      if (llllllIIIIlllll.getCause() == TeleportCause.END_PORTAL) {
         llllllIIIIlllll.setCancelled((boolean)lIlI[0]);
         byte llllllIIIIllllI = llllllIIIIlllll.getPlayer();
         double llllllIIIIlllIl = Bukkit.getWorld(Main.getInstance().getConfig().getString("darkzone-exit.world"));
         long llllllIIIIlllII = Main.getInstance().getConfig().getInt("darkzone-exit.x");
         double llllllIIIIllIll = Main.getInstance().getConfig().getInt("darkzone-exit.y");
         long llllllIIIIllIlI = Main.getInstance().getConfig().getInt("darkzone-exit.z");
         boolean llllllIIIIllIIl = Main.getInstance().getConfig().getInt("darkzone-exit.yaw");
         short llllllIIIIllIII = Main.getInstance().getConfig().getInt("darkzone-exit.pitch");
         Location llllllIIIlIIIIl = new Location(llllllIIIIlllIl, (double)llllllIIIIlllII, (double)llllllIIIIllIll, (double)llllllIIIIllIlI, (float)llllllIIIIllIIl, (float)llllllIIIIllIII);
         if (llllllIIIIllllI != null && llllllIIIlIIIIl != null) {
            llllllIIIIllllI.teleport(llllllIIIlIIIIl);
            "".length();
            char llllllIIIIlIlIl = Main.getInstance().getConfig().getStringList("darkzone-leave").iterator();
            "".length();
            if (-(34 ^ 39) >= 0) {
               return;
            }

            while(llllllIIIIlIlIl.hasNext()) {
               double llllllIIIIlIllI = (String)llllllIIIIlIlIl.next();
               llllllIIIIllllI.sendMessage(ChatColor.translateAlternateColorCodes((char)lIlI[1], llllllIIIIlIllI));
            }
         }
      }

   }

   public static ItemStack getMeteorite(int lllllIlIlIIIIII) {
      ItemStack lllllIlIIllllll = new ItemStack(Material.INK_SACK);
      lllllIlIIllllll.setDurability((short)lIlI[9]);
      lllllIlIIllllll.addUnsafeEnchantment(Enchantment.DURABILITY, lIlI[2]);
      lllllIlIIllllll.setAmount(lllllIlIlIIIIII);
      double lllllIlIIlllIIl = lllllIlIIllllll.getItemMeta();
      lllllIlIIlllIIl.setDisplayName(CC.translate(Config.getConfig().getString("darkzone-meteorite-name")));
      ArrayList<String> lllllIlIIlllIII = new ArrayList();
      Exception lllllIlIIllIllI = Config.getConfig().getStringList("darkzone-meteorite-lore").iterator();
      "".length();
      if (-"  ".length() >= 0) {
         return null;
      } else {
         while(lllllIlIIllIllI.hasNext()) {
            String lllllIlIIllllII = (String)lllllIlIIllIllI.next();
            lllllIlIIlllIII.add(ChatColor.translateAlternateColorCodes((char)lIlI[1], lllllIlIIllllII));
            "".length();
         }

         lllllIlIIlllIIl.setLore(lllllIlIIlllIII);
         lllllIlIIllllll.setItemMeta(lllllIlIIlllIIl);
         "".length();
         return lllllIlIIllllll;
      }
   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   public void onBlockBreak33333(PlayerItemHeldEvent lllllIllIIIIllI) {
      float lllllIllIIIIIII = lllllIllIIIIllI.getPlayer();
      boolean lllllIlIlllllll = lllllIllIIIIIII.getInventory();
      byte lllllIlIllllllI = lllllIllIIIIIII.getItemInHand();
      int lllllIllIIIIIlI = lllllIllIIIIllI.getNewSlot();
      if (lllllIllIIIIIII.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name"))) {
         if (lllllIllIIIIIII.getInventory().getItem(lllllIllIIIIllI.getNewSlot()) == null) {
            if (lllllIllIIIIIII.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
               lllllIllIIIIIII.removePotionEffect(PotionEffectType.SLOW_DIGGING);
            }

            return;
         }

         if (lllllIllIIIIIII.getInventory().getItem(lllllIllIIIIIlI).getType() == Material.AIR) {
            if (lllllIllIIIIIII.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
               lllllIllIIIIIII.removePotionEffect(PotionEffectType.SLOW_DIGGING);
            }

            return;
         }

         if (lllllIllIIIIIII.getInventory().getItem(lllllIllIIIIIlI).getType() != Material.DIAMOND_PICKAXE && lllllIllIIIIIII.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
            lllllIllIIIIIII.removePotionEffect(PotionEffectType.SLOW_DIGGING);
         }
      }

   }

   @EventHandler(
      priority = EventPriority.LOW,
      ignoreCancelled = true
   )
   public void onBlockBreak(BlockBreakEvent lllllIlIIlIIIll) {
      int lllllIlIIlIIIlI = lllllIlIIIIlllI.plugin.getConfig().getInt("darkzonegems.min");
      int lllllIlIIIIlIll = lllllIlIIIIlllI.plugin.getConfig().getInt("darkzonegems.max");
      int lllllIlIIlIIIII = lllllIlIIIIlllI.plugin.getRandom().nextInt(lllllIlIIIIlIll - lllllIlIIlIIIlI) + lllllIlIIlIIIlI;
      boolean lllllIlIIIIlIIl = lllllIlIIlIIIll.getPlayer();
      PlayerInventory lllllIlIIIllllI = lllllIlIIIIlIIl.getInventory();
      String lllllIlIIIIIlll = lllllIlIIlIIIll.getBlock();
      int lllllIlIIIIIllI = lllllIlIIIIlIIl.getItemInHand();
      float lllllIlIIIIIlIl = lllllIlIIIIIlll.getChunk();
      if (lllllIlIIIIlIIl.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && lllllIlIIIIIlll.getType() == Material.DIAMOND_ORE) {
         lllllIlIIlIIIll.setCancelled((boolean)lIlI[0]);
         boolean lllllIlIIIIIlII = lllllIlIIIIIlll.getType();
         int lllllIlIIIllIIl = lllllIlIIIIlllI.plugin.getRandom().nextInt(lIlI[3]) + lIlI[0];
         lllllIlIIlIIIll.getBlock().setType(Material.BEDROCK);
         long lllllIlIIIIIIlI = lllllIlIIlIIIll.getPlayer();
         (new 2(lllllIlIIIIlllI, lllllIlIIIIIlIl, lllllIlIIlIIIll)).runTaskLater(lllllIlIIIIlllI.plugin, 200L);
         "".length();
         ItemStack lllllIlIIIlIIll;
         int lllllIlIIIlIIlI;
         int lllllIlIIIlIIIl;
         int lllllIlIIIlIIII;
         if (lllllIlIIIIlIIl.getInventory().firstEmpty() == lIlI[4]) {
            lllllIlIIIlIIll = lllllIlIIIIlIIl.getEquipment().getItemInHand();
            lllllIlIIIlIIlI = lllllIlIIIlIIll.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            lllllIlIIIlIIIl = lIlI[0];
            if (lllllIlIIIlIIlI > 0) {
               lllllIlIIIlIIII = lIlI[5];
               "".length();
               if ("  ".length() <= " ".length()) {
                  return;
               }

               for(; lllllIlIIIlIIII < lllllIlIIIlIIlI; ++lllllIlIIIlIIII) {
                  if (lllllIlIIIIlllI.plugin.getRandom().nextBoolean()) {
                     ++lllllIlIIIlIIIl;
                  }
               }
            }

            lllllIlIIIIlIIl.getWorld().dropItem(lllllIlIIIIlIIl.getLocation(), getMeteorite(lllllIlIIIlIIIl));
            "".length();
            if (Config.getConfig().getBoolean("mining-messages")) {
               lllllIlIIIIlIIl.sendMessage(CC.translate(lllllIlIIIIlllI.plugin.getConfig().getString("darkzone-meteorite")));
               lllllIlIIIIlIIl.sendMessage(CC.translate(lllllIlIIIIlllI.plugin.getConfig().getString("darkzone-meteor-scrap-full")));
               "".length();
               if ("  ".length() <= 0) {
                  return;
               }
            }
         } else {
            lllllIlIIIlIIll = lllllIlIIIIlIIl.getEquipment().getItemInHand();
            lllllIlIIIlIIlI = lllllIlIIIlIIll.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            lllllIlIIIlIIIl = lIlI[0];
            if (lllllIlIIIlIIlI > 0) {
               lllllIlIIIlIIII = lIlI[5];
               "".length();
               if ("   ".length() < " ".length()) {
                  return;
               }

               for(; lllllIlIIIlIIII < lllllIlIIIlIIlI; ++lllllIlIIIlIIII) {
                  if (lllllIlIIIIlllI.plugin.getRandom().nextBoolean()) {
                     ++lllllIlIIIlIIIl;
                  }
               }
            }

            if (Config.getConfig().getBoolean("mining-messages")) {
               lllllIlIIIIlIIl.sendMessage(CC.translate(lllllIlIIIIlllI.plugin.getConfig().getString("darkzone-meteorite")));
            }

            PlayerInventory var10000 = lllllIlIIIIlIIl.getInventory();
            ItemStack[] var10001 = new ItemStack[lIlI[0]];
            var10001[lIlI[5]] = getMeteorite(lllllIlIIIlIIIl);
            var10000.addItem(var10001);
            "".length();
         }

         String lllllIlIIIIllll = String.valueOf((new StringBuilder()).append(lllllIlIIlIIIII));
         if (lllllIlIIIIlllI.plugin.getConfig().getBoolean("darkzonegems.enabled")) {
            lllllIlIIIIIIlI.sendMessage(CC.translate(lllllIlIIIIlllI.plugin.getConfig().getString("darkzonegems.message").replace("%amount%", lllllIlIIIIllll)));
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.valueOf((new StringBuilder("gems add ")).append(lllllIlIIIIIIlI.getName()).append(" ").append(lllllIlIIIIllll)));
            "".length();
         }
      }

   }

   @EventHandler
   public void blockb2(BlockPlaceEvent llllllIIIIIllIl) {
      Player llllllIIIIIllll = llllllIIIIIllIl.getPlayer();
      if (llllllIIIIIllll.getWorld().getName().equals(llllllIIIIlIIIl.plugin.getConfig().getString("darkzone-world-name"))) {
         if (llllllIIIIIllll.hasPermission("rival.darkzonebuild")) {
            return;
         }

         llllllIIIIIllIl.setCancelled((boolean)lIlI[0]);
      }

   }

   @EventHandler(
      priority = EventPriority.LOW,
      ignoreCancelled = true
   )
   public void onBlockBreak3(BlockBreakEvent lllllIllIllIllI) {
      ItemStack lllllIllIllIlIl = (new ItemBuilder(Material.NETHER_BRICK_ITEM)).enchant(Enchantment.DURABILITY, lIlI[2]).displayName(CC.translate(lllllIllIllIlll.plugin.getConfig().getString("darkzone-meteor-scrap-name"))).build();
      Exception lllllIllIlIIIII = lllllIllIllIllI.getPlayer();
      PlayerInventory lllllIllIllIIll = lllllIllIlIIIII.getInventory();
      int lllllIllIIllllI = lllllIllIllIllI.getBlock();
      long lllllIllIIlllIl = lllllIllIlIIIII.getItemInHand();
      char lllllIllIIlllII = lllllIllIIllllI.getChunk();
      if (lllllIllIlIIIII.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && lllllIllIIllllI.getType() == Material.QUARTZ_ORE) {
         lllllIllIllIllI.setCancelled((boolean)lIlI[0]);
         char lllllIllIIllIll = lllllIllIIllllI.getType();
         int lllllIllIIllIlI = lllllIllIllIlll.plugin.getRandom().nextInt(lIlI[3]) + lIlI[0];
         lllllIllIllIllI.getBlock().setType(Material.STONE);
         Player lllllIllIlIllIl = lllllIllIllIllI.getPlayer();
         char lllllIllIIllIII = lllllIllIllIllI.getBlock().getLocation();
         lllllIllIllIllI.getBlock().getWorld().playEffect(lllllIllIIllIII, Effect.MOBSPAWNER_FLAMES, lIlI[6]);
         ItemStack lllllIllIlIIlll;
         int lllllIllIIlIllI;
         int lllllIllIlIIlIl;
         int lllllIllIIlIlII;
         if (lllllIllIlIIIII.getInventory().firstEmpty() == lIlI[4]) {
            lllllIllIlIIlll = lllllIllIlIIIII.getEquipment().getItemInHand();
            lllllIllIIlIllI = lllllIllIlIIlll.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            lllllIllIlIIlIl = lIlI[6];
            if (lllllIllIIlIllI > 0) {
               lllllIllIIlIlII = lIlI[5];
               "".length();
               if ((57 ^ 24 ^ 44 ^ 9) < "  ".length()) {
                  return;
               }

               for(; lllllIllIIlIlII < lllllIllIIlIllI; ++lllllIllIIlIlII) {
                  if (lllllIllIllIlll.plugin.getRandom().nextBoolean()) {
                     ++lllllIllIlIIlIl;
                  }
               }
            }

            lllllIllIllIlIl.setAmount(lllllIllIlIIlIl);
            lllllIllIlIIIII.getWorld().dropItem(lllllIllIlIIIII.getLocation(), lllllIllIllIlIl);
            "".length();
            if (Config.getConfig().getBoolean("mining-messages")) {
               lllllIllIlIIIII.sendMessage(CC.translate(lllllIllIllIlll.plugin.getConfig().getString("darkzone-meteor-scrap")));
               lllllIllIlIIIII.sendMessage(CC.translate(lllllIllIllIlll.plugin.getConfig().getString("darkzone-meteor-scrap-full")));
               "".length();
               if (" ".length() >= "  ".length()) {
                  return;
               }
            }
         } else {
            if (Config.getConfig().getBoolean("mining-messages")) {
               lllllIllIlIIIII.sendMessage(CC.translate(lllllIllIllIlll.plugin.getConfig().getString("darkzone-meteor-scrap")));
            }

            lllllIllIlIIlll = lllllIllIlIIIII.getEquipment().getItemInHand();
            lllllIllIIlIllI = lllllIllIlIIlll.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            lllllIllIlIIlIl = lIlI[6];
            if (lllllIllIIlIllI > 0) {
               lllllIllIIlIlII = lIlI[5];
               "".length();
               if (((171 ^ 182) & ~(142 ^ 147)) < 0) {
                  return;
               }

               for(; lllllIllIIlIlII < lllllIllIIlIllI; ++lllllIllIIlIlII) {
                  if (lllllIllIllIlll.plugin.getRandom().nextBoolean()) {
                     ++lllllIllIlIIlIl;
                  }
               }
            }

            lllllIllIllIlIl.setAmount(lllllIllIlIIlIl);
            PlayerInventory var10000 = lllllIllIlIIIII.getInventory();
            ItemStack[] var10001 = new ItemStack[lIlI[0]];
            var10001[lIlI[5]] = lllllIllIllIlIl;
            var10000.addItem(var10001);
            "".length();
         }
      }

   }

   private static void lIII() {
      lIlI = new int[10];
      lIlI[0] = " ".length();
      lIlI[1] = 192 ^ 183 ^ 91 ^ 10;
      lIlI[2] = 86 ^ 101 ^ 163 ^ 154;
      lIlI[3] = 11 ^ 111;
      lIlI[4] = -" ".length();
      lIlI[5] = (249 ^ 177) & ~(236 ^ 164);
      lIlI[6] = "   ".length();
      lIlI[7] = -163 & 360162;
      lIlI[8] = -(-4323 & 20975) & -18 & '춽';
      lIlI[9] = 66 ^ 78;
   }

   public DarkZoneListener(Main llllllIIIlllIlI) {
      llllllIIIlllIIl.plugin = llllllIIIlllIlI;
   }
}
