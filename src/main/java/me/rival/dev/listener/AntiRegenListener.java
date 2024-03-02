package me.rival.dev.listener;

import java.util.ArrayList;
import java.util.List;
import me.rival.dev.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class AntiRegenListener implements Listener {
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private int radius;
   // $FF: synthetic field
   public boolean lava;
   // $FF: synthetic field
   public boolean water;
   // $FF: synthetic field
   private static final int[] lIlIII;
   // $FF: synthetic field
   public List<Block> blocklist;

   @EventHandler
   public void onPlayerBucketEmpty(PlayerBucketEmptyEvent llllIlIIlIIIlIl) {
      Material llllIlIIlIIllll = llllIlIIlIIIlIl.getBucket();
      Block llllIlIIlIIlllI = llllIlIIlIIIlIl.getBlockClicked();
      Player llllIlIIlIIllIl = llllIlIIlIIIlIl.getPlayer();
      String llllIlIIlIIllII = llllIlIIlIIIllI.plugin.getConfig().getString("SpawnerCantPlace");
      if (llllIlIIlIIllll.toString().contains("WATER") || llllIlIIlIIllll.toString().contains("LAVA")) {
         int llllIlIIlIIlIll = lIlIII[4];
         "".length();
         if (-"   ".length() > 0) {
            return;
         }

         while(llllIlIIlIIlIll <= lIlIII[5]) {
            byte llllIlIIIllllll = lIlIII[4];
            "".length();
            if (null != null) {
               return;
            }

            while(llllIlIIIllllll <= lIlIII[5]) {
               short llllIlIIIlllllI = lIlIII[4];
               "".length();
               if (((229 ^ 152 ^ 255 ^ 166) & (14 + 15 - -53 + 47 ^ 126 + 0 - 22 + 61 ^ -" ".length())) != 0) {
                  return;
               }

               for(; llllIlIIIlllllI <= lIlIII[5]; ++llllIlIIIlllllI) {
                  Location llllIlIIlIIlIII = new Location(llllIlIIlIIlllI.getWorld(), (double)(llllIlIIlIIlllI.getX() + llllIlIIlIIlIll), (double)(llllIlIIlIIlllI.getY() + llllIlIIIllllll), (double)(llllIlIIlIIlllI.getZ() + llllIlIIIlllllI));
                  Block llllIlIIlIIIlll = llllIlIIlIIlIII.getBlock();
                  if (llllIlIIlIIIlll.getType() == Material.MOB_SPAWNER) {
                     llllIlIIlIIIlIl.setCancelled((boolean)lIlIII[0]);
                     llllIlIIlIIllIl.sendMessage(CC.translate(llllIlIIlIIllII));
                  }
               }

               ++llllIlIIIllllll;
            }

            ++llllIlIIlIIlIll;
         }
      }

   }

   @EventHandler
   public void explodeLava(ExplosionPrimeEvent llllIlIlllIIlII) {
      if (llllIlIlllIIlII.getEntity().equals(EntityType.PRIMED_TNT)) {
         Location llllIlIlllIIllI = llllIlIlllIIlII.getEntity().getLocation();
         if (llllIlIlllIIllI.getBlock().getType() != Material.WATER && llllIlIlllIIllI.getBlock().getType() != Material.STATIONARY_WATER) {
            int llllIlIllIlllll = getNearbyBlocks(llllIlIlllIIlII.getEntity().getLocation(), (int)llllIlIlllIIlII.getRadius()).iterator();
            "".length();
            if (" ".length() >= -" ".length()) {
               while(true) {
                  Block llllIlIlllIIIIl;
                  do {
                     if (!llllIlIllIlllll.hasNext()) {
                        return;
                     }

                     llllIlIlllIIIIl = (Block)llllIlIllIlllll.next();
                  } while(llllIlIlllIIIIl.getType() != Material.LAVA && llllIlIlllIIIIl.getType() != Material.STATIONARY_LAVA);

                  llllIlIlllIIIIl.setType(Material.AIR);
               }
            }
         }
      }
   }

   static {
      lIIIll();
   }

   public static List<Block> getNearbyBlocks(Location llllIlIIIIlIlll, int llllIlIIIIlIIII) {
      List<Block> llllIlIIIIlIlIl = new ArrayList();
      int llllIlIIIIlIlII = llllIlIIIIlIlll.getBlockX() - llllIlIIIIlIIII;
      "".length();
      if ((23 ^ 70 ^ 218 ^ 143) == 0) {
         return null;
      } else {
         while(llllIlIIIIlIlII <= llllIlIIIIlIlll.getBlockX() + llllIlIIIIlIIII) {
            int llllIlIIIIlIIll = llllIlIIIIlIlll.getBlockY() - llllIlIIIIlIIII;
            "".length();
            if (((143 + 87 - 84 + 44 ^ 78 + 84 - 125 + 128) & (192 ^ 132 ^ 64 ^ 31 ^ -" ".length())) != 0) {
               return null;
            }

            while(llllIlIIIIlIIll <= llllIlIIIIlIlll.getBlockY() + llllIlIIIIlIIII) {
               long llllIlIIIIIllII = llllIlIIIIlIlll.getBlockZ() - llllIlIIIIlIIII;
               "".length();
               if ("  ".length() < 0) {
                  return null;
               }

               while(llllIlIIIIIllII <= llllIlIIIIlIlll.getBlockZ() + llllIlIIIIlIIII) {
                  llllIlIIIIlIlIl.add(llllIlIIIIlIlll.getWorld().getBlockAt(llllIlIIIIlIlII, llllIlIIIIlIIll, llllIlIIIIIllII));
                  "".length();
                  ++llllIlIIIIIllII;
               }

               ++llllIlIIIIlIIll;
            }

            ++llllIlIIIIlIlII;
         }

         return llllIlIIIIlIlIl;
      }
   }

   @EventHandler
   public void explodeLava(EntityExplodeEvent llllIlIIllIIIII) {
      if (llllIlIIllIIIII.getEntityType().equals(EntityType.PRIMED_TNT)) {
         Location llllIlIIllIIIlI = llllIlIIllIIIII.getEntity().getLocation();
         if (llllIlIIllIIIlI.getBlock().getType() != Material.WATER && llllIlIIllIIIlI.getBlock().getType() != Material.STATIONARY_WATER) {
            char llllIlIIlIlllIl = getNearbyBlocks(llllIlIIllIIIII.getEntity().getLocation(), lIlIII[3]).iterator();
            "".length();
            if (-"   ".length() < 0) {
               while(true) {
                  Block llllIlIIllIIIIl;
                  do {
                     if (!llllIlIIlIlllIl.hasNext()) {
                        return;
                     }

                     llllIlIIllIIIIl = (Block)llllIlIIlIlllIl.next();
                  } while(llllIlIIllIIIIl.getType() != Material.LAVA && llllIlIIllIIIIl.getType() != Material.STATIONARY_LAVA);

                  llllIlIIllIIIIl.setType(Material.AIR);
               }
            }
         }
      }
   }

   @EventHandler
   public void antiLava(BlockFromToEvent llllIlIIlllIllI) {
      Block llllIlIIlllIlIl = llllIlIIlllIllI.getBlock();
      if (llllIlIIlllIlIl.getType() == Material.LAVA || llllIlIIlllIlIl.getType() == Material.STATIONARY_LAVA) {
         int llllIlIIlllIlII = lIlIII[2];
         "".length();
         if ("  ".length() != "  ".length()) {
            return;
         }

         while(llllIlIIlllIlII <= lIlIII[1]) {
            char llllIlIIllIllII = lIlIII[2];
            "".length();
            if (((44 ^ 24) & ~(168 ^ 156)) > 0) {
               return;
            }

            while(llllIlIIllIllII <= lIlIII[1]) {
               int llllIlIIlllIIlI = lIlIII[2];
               "".length();
               if (((105 ^ 110) & ~(60 ^ 59)) != 0) {
                  return;
               }

               for(; llllIlIIlllIIlI <= lIlIII[1]; ++llllIlIIlllIIlI) {
                  Location llllIlIIlllIIIl = new Location(llllIlIIlllIlIl.getWorld(), (double)(llllIlIIlllIlIl.getX() + llllIlIIlllIlII), (double)(llllIlIIlllIlIl.getY() + llllIlIIllIllII), (double)(llllIlIIlllIlIl.getZ() + llllIlIIlllIIlI));
                  boolean llllIlIIllIlIIl = llllIlIIlllIIIl.getBlock();
                  if (llllIlIIllIlIIl.getType() == Material.MOB_SPAWNER) {
                     llllIlIIlllIllI.setCancelled((boolean)lIlIII[0]);
                  }
               }

               ++llllIlIIllIllII;
            }

            ++llllIlIIlllIlII;
         }
      }

   }

   @EventHandler
   public void antiWater(BlockFromToEvent llllIlIlIllllll) {
      Block llllIlIllIIIlIl = llllIlIlIllllll.getBlock();
      if (llllIlIllIIIlIl.getType() == Material.WATER || llllIlIllIIIlIl.getType() == Material.STATIONARY_WATER) {
         boolean llllIlIlIllllIl = lIlIII[2];
         "".length();
         if (((83 ^ 50) & ~(29 ^ 124)) != 0) {
            return;
         }

         while(llllIlIlIllllIl <= lIlIII[1]) {
            int llllIlIllIIIIll = lIlIII[2];
            "".length();
            if ((178 ^ 162 ^ 26 ^ 15) <= 0) {
               return;
            }

            while(llllIlIllIIIIll <= lIlIII[1]) {
               boolean llllIlIlIlllIll = lIlIII[2];
               "".length();
               if (null != null) {
                  return;
               }

               for(; llllIlIlIlllIll <= lIlIII[1]; ++llllIlIlIlllIll) {
                  byte llllIlIlIlllIlI = new Location(llllIlIllIIIlIl.getWorld(), (double)(llllIlIllIIIlIl.getX() + llllIlIlIllllIl), (double)(llllIlIllIIIlIl.getY() + llllIlIllIIIIll), (double)(llllIlIllIIIlIl.getZ() + llllIlIlIlllIll));
                  Block llllIlIllIIIIII = llllIlIlIlllIlI.getBlock();
                  if (llllIlIllIIIIII.getType() == Material.MOB_SPAWNER) {
                     llllIlIlIllllll.setCancelled((boolean)lIlIII[0]);
                  }
               }

               ++llllIlIllIIIIll;
            }

            ++llllIlIlIllllIl;
         }
      }

   }

   private static void lIIIll() {
      lIlIII = new int[6];
      lIlIII[0] = " ".length();
      lIlIII[1] = "   ".length();
      lIlIII[2] = -"   ".length();
      lIlIII[3] = 16 + 87 - 96 + 169 ^ 41 + 71 - -67 + 1;
      lIlIII[4] = -"  ".length();
      lIlIII[5] = "  ".length();
   }

   public AntiRegenListener(Main llllIlIlllIllIl) {
      llllIlIlllIlllI.water = (boolean)lIlIII[0];
      llllIlIlllIlllI.lava = (boolean)lIlIII[0];
      llllIlIlllIlllI.radius = lIlIII[1];
      llllIlIlllIlllI.plugin = llllIlIlllIllIl;
      llllIlIlllIlllI.blocklist = new ArrayList();
   }

   @EventHandler
   public void antiblockplace(BlockPlaceEvent llllIlIIIllIIII) {
      Block llllIlIIIlIllll = llllIlIIIllIIII.getBlock();
      Player llllIlIIIlIlllI = llllIlIIIllIIII.getPlayer();
      long llllIlIIIlIIIll = llllIlIIIlIIlll.plugin.getConfig().getString("SpawnerCantPlace");
      if (llllIlIIIlIllll.getType() == Material.OBSIDIAN || llllIlIIIlIllll.getType() == Material.ENCHANTMENT_TABLE || llllIlIIIlIllll.getType() == Material.DISPENSER || llllIlIIIlIllll.getType() == Material.DROPPER) {
         long llllIlIIIlIIIlI = lIlIII[4];
         "".length();
         if (-"   ".length() > 0) {
            return;
         }

         while(llllIlIIIlIIIlI <= lIlIII[5]) {
            int llllIlIIIlIlIll = lIlIII[4];
            "".length();
            if (" ".length() > (152 ^ 156)) {
               return;
            }

            while(llllIlIIIlIlIll <= lIlIII[5]) {
               int llllIlIIIlIlIlI = lIlIII[4];
               "".length();
               if ("   ".length() <= ((11 ^ 67) & ~(136 ^ 192))) {
                  return;
               }

               for(; llllIlIIIlIlIlI <= lIlIII[5]; ++llllIlIIIlIlIlI) {
                  Location llllIlIIIlIlIIl = new Location(llllIlIIIlIllll.getWorld(), (double)(llllIlIIIlIllll.getX() + llllIlIIIlIIIlI), (double)(llllIlIIIlIllll.getY() + llllIlIIIlIlIll), (double)(llllIlIIIlIllll.getZ() + llllIlIIIlIlIlI));
                  Block llllIlIIIlIlIII = llllIlIIIlIlIIl.getBlock();
                  if (llllIlIIIlIlIII.getType() == Material.MOB_SPAWNER) {
                     llllIlIIIllIIII.setCancelled((boolean)lIlIII[0]);
                     llllIlIIIlIlllI.sendMessage(CC.translate(llllIlIIIlIIIll));
                  }
               }

               ++llllIlIIIlIlIll;
            }

            ++llllIlIIIlIIIlI;
         }
      }

   }

   @EventHandler(
      priority = EventPriority.MONITOR,
      ignoreCancelled = true
   )
   public void onBlockPlace(BlockPlaceEvent llllIlIlIIIlIII) {
      long llllIlIlIIIIlll = llllIlIlIIIlIII.getBlock();
      World llllIlIlIIlIlIl = llllIlIlIIIIlll.getWorld();
      if (llllIlIlIIIIlll.getType().equals(Material.MOB_SPAWNER)) {
         float llllIlIlIIIIlIl = llllIlIlIIIIlll.getX();
         short llllIlIlIIIIlII = llllIlIlIIIIlll.getY();
         int llllIlIlIIIIIll = llllIlIlIIIIlll.getZ();
         int llllIlIlIIIIIlI = -llllIlIlIIIlIIl.radius;
         "".length();
         if (((226 ^ 162) & ~(233 ^ 169)) > 0) {
            return;
         }

         int llllIlIlIIIllII;
         int llllIlIlIIIIIII;
         Block llllIlIIlllllll;
         while(llllIlIlIIIIIlI <= llllIlIlIIIlIIl.radius) {
            llllIlIlIIIllII = -llllIlIlIIIlIIl.radius;
            "".length();
            if (-" ".length() != -" ".length()) {
               return;
            }

            while(llllIlIlIIIllII <= llllIlIlIIIlIIl.radius) {
               llllIlIlIIIIIII = -llllIlIlIIIlIIl.radius;
               "".length();
               if (-(53 ^ 25 ^ 189 ^ 148) >= 0) {
                  return;
               }

               for(; llllIlIlIIIIIII <= llllIlIlIIIlIIl.radius; ++llllIlIlIIIIIII) {
                  llllIlIIlllllll = llllIlIlIIlIlIl.getBlockAt(llllIlIlIIIIlIl + llllIlIlIIIIIlI, llllIlIlIIIIlII + llllIlIlIIIllII, llllIlIlIIIIIll + llllIlIlIIIIIII);
                  if (llllIlIIlllllll.getType().equals(Material.WATER) || llllIlIIlllllll.getType().equals(Material.STATIONARY_WATER) || llllIlIIlllllll.getType().equals(Material.OBSIDIAN) || llllIlIIlllllll.getType().equals(Material.DISPENSER)) {
                     llllIlIlIIlIlIl.getBlockAt(llllIlIlIIIIlIl + llllIlIlIIIIIlI, llllIlIlIIIIlII + llllIlIlIIIllII, llllIlIlIIIIIll + llllIlIlIIIIIII).setType(Material.AIR);
                  }
               }

               ++llllIlIlIIIllII;
            }

            ++llllIlIlIIIIIlI;
         }

         llllIlIlIIIIIlI = -llllIlIlIIIlIIl.radius;
         "".length();
         if ((17 + 64 - 37 + 115 ^ 109 + 46 - 19 + 19) == 0) {
            return;
         }

         while(llllIlIlIIIIIlI <= llllIlIlIIIlIIl.radius) {
            llllIlIlIIIllII = -llllIlIlIIIlIIl.radius;
            "".length();
            if (((85 + 72 - 58 + 32 ^ 0 + 71 - -60 + 46) & (153 + 44 - 154 + 117 ^ 78 + 13 - 39 + 94 ^ -" ".length())) != 0) {
               return;
            }

            while(llllIlIlIIIllII <= llllIlIlIIIlIIl.radius) {
               llllIlIlIIIIIII = -llllIlIlIIIlIIl.radius;
               "".length();
               if (-"   ".length() > 0) {
                  return;
               }

               for(; llllIlIlIIIIIII <= llllIlIlIIIlIIl.radius; ++llllIlIlIIIIIII) {
                  llllIlIIlllllll = llllIlIlIIlIlIl.getBlockAt(llllIlIlIIIIlIl + llllIlIlIIIIIlI, llllIlIlIIIIlII + llllIlIlIIIllII, llllIlIlIIIIIll + llllIlIlIIIIIII);
                  if (llllIlIIlllllll.getType().equals(Material.LAVA) || llllIlIIlllllll.getType().equals(Material.STATIONARY_LAVA)) {
                     llllIlIlIIlIlIl.getBlockAt(llllIlIlIIIIlIl + llllIlIlIIIIIlI, llllIlIlIIIIlII + llllIlIlIIIllII, llllIlIlIIIIIll + llllIlIlIIIIIII).setType(Material.AIR);
                  }
               }

               ++llllIlIlIIIllII;
            }

            ++llllIlIlIIIIIlI;
         }
      }

   }
}
