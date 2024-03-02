package me.rival.dev.listener;

import java.util.ArrayList;
import java.util.List;
import me.rival.dev.Main;
import me.rival.dev.config.Config;
import me.rival.dev.listener.DarkZoneMeteorsListener.1;
import me.rival.dev.listener.DarkZoneMeteorsListener.10;
import me.rival.dev.listener.DarkZoneMeteorsListener.11;
import me.rival.dev.listener.DarkZoneMeteorsListener.12;
import me.rival.dev.listener.DarkZoneMeteorsListener.13;
import me.rival.dev.listener.DarkZoneMeteorsListener.2;
import me.rival.dev.listener.DarkZoneMeteorsListener.3;
import me.rival.dev.listener.DarkZoneMeteorsListener.4;
import me.rival.dev.listener.DarkZoneMeteorsListener.5;
import me.rival.dev.listener.DarkZoneMeteorsListener.6;
import me.rival.dev.listener.DarkZoneMeteorsListener.7;
import me.rival.dev.listener.DarkZoneMeteorsListener.8;
import me.rival.dev.listener.DarkZoneMeteorsListener.9;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DarkZoneMeteorsListener implements Listener {
   // $FF: synthetic field
   private static List<Location> spawnLocations;
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private static final int[] lllI;

   public static void meteor(Location llllllIllIIlIlI) {
      Location llllllIllIIlIIl;
      if (lIlI(llllllIllIIlIlI.getX(), 0.0D) > 0) {
         llllllIllIIlIIl = llllllIllIIlIlI.subtract(2.0D, 0.0D, -5.0D);
         "".length();
         if ("  ".length() <= ((118 ^ 105) & ~(118 ^ 105))) {
            return;
         }
      } else {
         llllllIllIIlIIl = llllllIllIIlIlI.add(2.0D, 0.0D, -5.0D);
      }

      String llllllIllIIlIII = Bukkit.getWorld(Config.getConfig().getString("darkzone-world-name"));
      long llllllIllIIIlll = (Giant)llllllIllIIlIIl.getWorld().spawnEntity(llllllIllIIlIIl, EntityType.GIANT);
      llllllIllIIIlll.setCustomNameVisible((boolean)lllI[0]);
      llllllIllIIIlll.getEquipment().setItemInHand(new ItemStack(Material.TNT));
      llllllIllIIIlll.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, lllI[1], lllI[0]));
      "".length();
      Location llllllIllIIlIll = llllllIllIIIlll.getLocation();
      (new 1(llllllIllIIlIll, llllllIllIIIlll)).runTaskLater(Main.getInstance(), 10L);
      "".length();
      (new 2(llllllIllIIlIll, llllllIllIIIlll)).runTaskLater(Main.getInstance(), 15L);
      "".length();
      (new 3(llllllIllIIlIll, llllllIllIIIlll)).runTaskLater(Main.getInstance(), 20L);
      "".length();
      (new 4(llllllIllIIlIll, llllllIllIIIlll)).runTaskLater(Main.getInstance(), 25L);
      "".length();
      (new 5(llllllIllIIlIll, llllllIllIIIlll)).runTaskLater(Main.getInstance(), 30L);
      "".length();
      (new 6(llllllIllIIlIll, llllllIllIIIlll)).runTaskLater(Main.getInstance(), 35L);
      "".length();
      (new 7(llllllIllIIlIll, llllllIllIIIlll)).runTaskLater(Main.getInstance(), 40L);
      "".length();
      (new 8(llllllIllIIlIll, llllllIllIIIlll)).runTaskLater(Main.getInstance(), 45L);
      "".length();
      (new 9(llllllIllIIlIlI, llllllIllIIIlll)).runTaskLater(Main.getInstance(), 50L);
      "".length();
   }

   public static void setLocations(Player llllllIlIIIIllI) {
      ArrayList<String> llllllIlIIIIlIl = (ArrayList)Locations.getConfig().getStringList("Locations");
      llllllIlIIIIlIl.add(getStringFromLocation(llllllIlIIIIllI.getLocation()));
      "".length();
      Locations.getConfig().set("Locations", llllllIlIIIIlIl);
      Locations.getConfig().save();
   }

   private static String getStringFromLocation(Location llllllIlIIIIIlI) {
      return String.valueOf((new StringBuilder("World:")).append(llllllIlIIIIIlI.getWorld().getName()).append(", X:").append(llllllIlIIIIIlI.getBlockX()).append(", Y:").append(llllllIlIIIIIlI.getBlockY()).append(", Z:").append(llllllIlIIIIIlI.getBlockZ()));
   }

   public static void spawnMeteors() {
      float llllllIllIlIllI = getSpawnLocations().iterator();
      "".length();
      if (-"  ".length() <= 0) {
         Location llllllIllIllIII;
         for(; llllllIllIlIllI.hasNext(); meteor(llllllIllIllIII)) {
            llllllIllIllIII = (Location)llllllIllIlIllI.next();
            if (!llllllIllIllIII.getChunk().isLoaded()) {
               llllllIllIllIII.getChunk().load();
               "".length();
            }
         }

      }
   }

   static {
      lIIl();
      spawnLocations = new ArrayList();
   }

   public static void load() {
      spawnLocations.clear();
      short llllllIllIlllII = Locations.getConfig().getStringList("Locations").iterator();
      "".length();
      if ((67 ^ 9 ^ 29 ^ 82) > 0) {
         while(llllllIllIlllII.hasNext()) {
            String llllllIllIlllIl = (String)llllllIllIlllII.next();

            try {
               spawnLocations.add(getLocationFromString(llllllIllIlllIl));
               "".length();
            } catch (Exception var3) {
               continue;
            }

            "".length();
            if (-"   ".length() > 0) {
               return;
            }
         }

      }
   }

   private static void lIIl() {
      lllI = new int[3];
      lllI[0] = " ".length();
      lllI[1] = -191 & 360190;
      lllI[2] = (83 + 104 - 79 + 22 ^ 58 + 116 - 65 + 64) & (165 ^ 189 ^ 64 ^ 119 ^ -" ".length());
   }

   private static int lIlI(double var0, double var2) {
      double var4;
      return (var4 = var0 - var2) == 0.0D ? 0 : (var4 < 0.0D ? -1 : 1);
   }

   public DarkZoneMeteorsListener(Main llllllIlllIIIlI) {
      llllllIlllIIlIl.plugin = llllllIlllIIIlI;
   }

   private static Location getLocationFromString(String llllllIlIIlllll) {
      World llllllIlIlIIlII = (World)Main.instance.getServer().getWorlds().get(lllI[2]);
      byte llllllIlIIlllIl = lllI[2];
      int llllllIlIIlllII = lllI[2];
      int llllllIlIlIIIIl = lllI[2];
      String[] llllllIlIIlIlll;
      byte llllllIlIIllIII = (llllllIlIIlIlll = llllllIlIIlllll.toLowerCase().split(", ")).length;
      short llllllIlIIllIIl = lllI[2];
      "".length();
      if (((104 ^ 79) & ~(23 ^ 48)) > "   ".length()) {
         return null;
      } else {
         for(; llllllIlIIllIIl < llllllIlIIllIII; ++llllllIlIIllIIl) {
            String llllllIlIIllIlI = llllllIlIIlIlll[llllllIlIIllIIl];
            if (llllllIlIIllIlI.startsWith("world:")) {
               llllllIlIlIIlII = Main.instance.getServer().getWorld(llllllIlIIllIlI.replace("world:", ""));
               "".length();
               if (-"   ".length() > 0) {
                  return null;
               }
            } else if (llllllIlIIllIlI.startsWith("x:")) {
               llllllIlIIlllIl = Integer.parseInt(llllllIlIIllIlI.replace("x:", ""));
               "".length();
               if ("  ".length() <= ((152 ^ 132) & ~(136 ^ 148))) {
                  return null;
               }
            } else if (llllllIlIIllIlI.startsWith("y:")) {
               llllllIlIIlllII = Integer.parseInt(llllllIlIIllIlI.replace("y:", ""));
               "".length();
               if (null != null) {
                  return null;
               }
            } else if (llllllIlIIllIlI.startsWith("z:")) {
               llllllIlIlIIIIl = Integer.parseInt(llllllIlIIllIlI.replace("z:", ""));
            }
         }

         return new Location(llllllIlIlIIlII, (double)llllllIlIIlllIl, (double)llllllIlIIlllII, (double)llllllIlIlIIIIl);
      }
   }

   private List<Location> getLocationsFromStringList(List<String> llllllIlIIIlllI) {
      ArrayList<Location> llllllIlIIIllIl = new ArrayList();
      short llllllIlIIIlIll = llllllIlIIIlllI.iterator();
      "".length();
      if ("  ".length() == 0) {
         return null;
      } else {
         while(llllllIlIIIlIll.hasNext()) {
            boolean llllllIlIIIllII = (String)llllllIlIIIlIll.next();
            llllllIlIIIllIl.add(getLocationFromString(llllllIlIIIllII));
            "".length();
         }

         return llllllIlIIIllIl;
      }
   }

   public static void startMeteorsThread() {
      load();
      String llllllIlIlIllll = Main.getInstance().getConfig().getStringList("darkzone-meteor-msg").iterator();
      "".length();
      if ("  ".length() >= -" ".length()) {
         while(llllllIlIlIllll.hasNext()) {
            String llllllIlIllIIIl = (String)llllllIlIlIllll.next();
            llllllIlIllIIIl = llllllIlIllIIIl.replace("%time%", "5");
            Bukkit.broadcastMessage(CC.translate(llllllIlIllIIIl));
            "".length();
         }

         (new 10()).runTaskLater(Main.getInstance(), 40L);
         "".length();
         (new 11()).runTaskLater(Main.getInstance(), 60L);
         "".length();
         (new 12()).runTaskLater(Main.getInstance(), 80L);
         "".length();
         (new 13()).runTaskLater(Main.getInstance(), 100L);
         "".length();
      }
   }

   public static List<Block> getNearbyBlocks(Location llllllIlIllllll, int llllllIlIlllllI) {
      List<Block> llllllIlIllllIl = new ArrayList();
      double llllllIlIllIllI = llllllIlIllllll.getBlockX() - llllllIlIlllllI;
      "".length();
      if ((76 ^ 73) == 0) {
         return null;
      } else {
         while(llllllIlIllIllI <= llllllIlIllllll.getBlockX() + llllllIlIlllllI) {
            boolean llllllIlIllIlIl = llllllIlIllllll.getBlockY() - llllllIlIlllllI;
            "".length();
            if (null != null) {
               return null;
            }

            while(llllllIlIllIlIl <= llllllIlIllllll.getBlockY() + llllllIlIlllllI) {
               int llllllIlIlllIlI = llllllIlIllllll.getBlockZ() - llllllIlIlllllI;
               "".length();
               if (null != null) {
                  return null;
               }

               while(llllllIlIlllIlI <= llllllIlIllllll.getBlockZ() + llllllIlIlllllI) {
                  llllllIlIllllIl.add(llllllIlIllllll.getWorld().getBlockAt(llllllIlIllIllI, llllllIlIllIlIl, llllllIlIlllIlI));
                  "".length();
                  ++llllllIlIlllIlI;
               }

               ++llllllIlIllIlIl;
            }

            ++llllllIlIllIllI;
         }

         return llllllIlIllllIl;
      }
   }

   public static List<Location> getSpawnLocations() {
      return spawnLocations;
   }
}
