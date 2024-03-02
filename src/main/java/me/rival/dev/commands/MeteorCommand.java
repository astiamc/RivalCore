package me.rival.dev.commands;

import java.util.concurrent.TimeUnit;
import me.rival.dev.Main;
import me.rival.dev.config.Config;
import me.rival.dev.listener.CC;
import me.rival.dev.listener.DarkZoneMeteorsListener;
import me.rival.dev.listener.Locations;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MeteorCommand implements CommandExecutor {
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private static final int[] lIlIIl;

   public static String timeAsString(long llllIlIlIllIIIl) {
      float llllIlIlIlIlIII = "";
      long llllIlIlIlIlllI = TimeUnit.MILLISECONDS.toDays(llllIlIlIllIIIl);
      int llllIlIlIlIlIIl = llllIlIlIllIIIl - TimeUnit.DAYS.toMillis(llllIlIlIlIlllI);
      long llllIlIlIlIllIl = TimeUnit.MILLISECONDS.toHours(llllIlIlIlIlIIl);
      llllIlIlIlIlIIl -= TimeUnit.HOURS.toMillis(llllIlIlIlIllIl);
      long llllIlIlIlIllII = TimeUnit.MILLISECONDS.toMinutes(llllIlIlIlIlIIl);
      llllIlIlIlIlIIl -= TimeUnit.MINUTES.toMillis(llllIlIlIlIllII);
      int llllIlIlIlIIlII = TimeUnit.MILLISECONDS.toSeconds(llllIlIlIlIlIIl);
      if (lIIlIl(llllIlIlIlIlIIl, 0L) <= 0) {
         llllIlIlIlIlIII = "Now";
      }

      if (lIIlIl(llllIlIlIlIlllI, 1L) > 0) {
         llllIlIlIlIlIII = String.valueOf(String.valueOf(llllIlIlIlIlIII) + llllIlIlIlIlllI + " days ");
         "".length();
         if ("  ".length() < "  ".length()) {
            return null;
         }
      } else if (lIIlIl(llllIlIlIlIlllI, 1L) == 0) {
         llllIlIlIlIlIII = String.valueOf(String.valueOf(llllIlIlIlIlIII) + llllIlIlIlIlllI + " day ");
      }

      if (lIIlIl(llllIlIlIlIllIl, 1L) > 0) {
         llllIlIlIlIlIII = String.valueOf(String.valueOf(llllIlIlIlIlIII) + llllIlIlIlIllIl + " hours ");
         "".length();
         if ("   ".length() <= -" ".length()) {
            return null;
         }
      } else if (lIIlIl(llllIlIlIlIllIl, 1L) == 0) {
         llllIlIlIlIlIII = String.valueOf(String.valueOf(llllIlIlIlIlIII) + llllIlIlIlIllIl + " hour ");
      }

      if (lIIlIl(llllIlIlIlIllII, 1L) > 0) {
         llllIlIlIlIlIII = String.valueOf(String.valueOf(llllIlIlIlIlIII) + llllIlIlIlIllII + " minutes ");
         "".length();
         if ("   ".length() != "   ".length()) {
            return null;
         }
      } else if (lIIlIl(llllIlIlIlIllII, 1L) == 0) {
         llllIlIlIlIlIII = String.valueOf(String.valueOf(llllIlIlIlIlIII) + llllIlIlIlIllII + " minute ");
      }

      if (lIIlIl(llllIlIlIlIIlII, 1L) > 0) {
         llllIlIlIlIlIII = String.valueOf(String.valueOf(llllIlIlIlIlIII) + llllIlIlIlIIlII + " seconds ");
         "".length();
         if (((234 ^ 176) & ~(127 ^ 37)) < ((39 ^ 30) & ~(125 ^ 68))) {
            return null;
         }
      } else if (lIIlIl(llllIlIlIlIIlII, 1L) == 0) {
         llllIlIlIlIlIII = String.valueOf(String.valueOf(llllIlIlIlIlIII) + llllIlIlIlIIlII + " second ");
      }

      return llllIlIlIlIlIII;
   }

   private static void lIIlII() {
      lIlIIl = new int[3];
      lIlIIl[0] = " ".length();
      lIlIIl[1] = 100 + 170 - 153 + 111 ^ 10 + 62 - -60 + 62;
      lIlIIl[2] = (71 ^ 74 ^ 25 ^ 37) & (65 ^ 45 ^ 23 ^ 74 ^ -" ".length());
   }

   private static int lIIlIl(long var0, long var2) {
      long var4;
      return (var4 = var0 - var2) == 0L ? 0 : (var4 < 0L ? -1 : 1);
   }

   static {
      lIIlII();
   }

   public MeteorCommand(Main llllIlIllllIlIl) {
      llllIlIllllIllI.plugin = llllIlIllllIlIl;
   }

   public boolean onCommand(CommandSender llllIlIllIllIIl, Command llllIlIllIlIIIl, String llllIlIllIlIlll, String[] llllIlIllIlIllI) {
      if (!llllIlIllIlIIIl.getName().equalsIgnoreCase("meteor")) {
         return (boolean)lIlIIl[0];
      } else if (llllIlIllIlIllI.length == 0) {
         float llllIlIllIIllII = llllIlIllIlIIll.plugin.getConfig().getStringList("darkzone-usage").iterator();
         "".length();
         if (((81 ^ 5 ^ 104 ^ 114) & (16 ^ 85 ^ 34 ^ 41 ^ -" ".length())) >= "  ".length()) {
            return (boolean)((113 ^ 47 ^ 57 ^ 65) & (129 ^ 176 ^ 132 ^ 147 ^ -" ".length()));
         } else {
            while(llllIlIllIIllII.hasNext()) {
               String llllIlIllIlIlIl = (String)llllIlIllIIllII.next();
               llllIlIllIllIIl.sendMessage(ChatColor.translateAlternateColorCodes((char)lIlIIl[1], llllIlIllIlIlIl));
            }

            return (boolean)lIlIIl[0];
         }
      } else {
         if (llllIlIllIlIllI.length == lIlIIl[0]) {
            if (llllIlIllIlIllI[lIlIIl[2]].equalsIgnoreCase("start")) {
               if (!llllIlIllIllIIl.hasPermission("rival.meteor") && !llllIlIllIllIIl.isOp()) {
                  llllIlIllIllIIl.sendMessage(CC.translate("&cYou dont have permission."));
               } else {
                  llllIlIllIllIIl.sendMessage(CC.translate("&cYou have force started the Meteor Event."));
                  DarkZoneMeteorsListener.startMeteorsThread();
                  "".length();
                  if ("   ".length() <= ((1 ^ 99) & ~(241 ^ 147))) {
                     return (boolean)((92 ^ 116) & ~(189 ^ 149));
                  }
               }
            }

            if (llllIlIllIlIllI[lIlIIl[2]].equalsIgnoreCase("setlocation")) {
               if (!llllIlIllIllIIl.hasPermission("rival.meteor") && !llllIlIllIllIIl.isOp()) {
                  llllIlIllIllIIl.sendMessage(CC.translate("&cYou dont have permission."));
               } else {
                  llllIlIllIllIIl.sendMessage(CC.translate("&cYou have set the new Meteor Location"));
                  DarkZoneMeteorsListener.setLocations((Player)llllIlIllIllIIl);
                  DarkZoneMeteorsListener.load();
                  "".length();
                  if ((" ".length() & ~" ".length()) < 0) {
                     return (boolean)((191 ^ 178) & ~(204 ^ 193));
                  }
               }
            }

            if (llllIlIllIlIllI[lIlIIl[2]].equalsIgnoreCase("reload")) {
               if (!llllIlIllIllIIl.hasPermission("rival.meteor") && !llllIlIllIllIIl.isOp()) {
                  llllIlIllIllIIl.sendMessage(CC.translate("&cYou dont have permission."));
               } else {
                  llllIlIllIllIIl.sendMessage(CC.translate("&cYou have reloaded the Meteor Config."));
                  Config.getConfig().reload();
                  Locations.getConfig().reload();
                  DarkZoneMeteorsListener.load();
                  "".length();
                  if (null != null) {
                     return (boolean)((54 ^ 19) & ~(224 ^ 197));
                  }
               }
            }

            if (llllIlIllIlIllI[lIlIIl[2]].equalsIgnoreCase("time")) {
               float llllIlIllIIlllI = Config.getConfig().getLong("darkzone-meteor-nexttime") - System.currentTimeMillis();
               llllIlIllIllIIl.sendMessage(CC.translate(Config.getConfig().getString("darkzone-time-message")).replace("{time}", timeAsString(llllIlIllIIlllI)));
            }
         }

         return (boolean)lIlIIl[0];
      }
   }
}
