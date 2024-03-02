package me.rival.dev.commands;

import java.util.Iterator;
import me.rival.dev.Main;
import me.rival.dev.listener.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdsCommand implements CommandExecutor {
   // $FF: synthetic field
   private static final int[] lIIIll;
   // $FF: synthetic field
   Main plugin;

   public AdsCommand(Main llllIllllIlIlII) {
      llllIllllIlIlll.plugin = llllIllllIlIlII;
   }

   static {
      lllII();
   }

   public boolean onCommand(CommandSender llllIllllIIIIll, Command llllIllllIIlIll, String llllIllllIIlIlI, String[] llllIllllIIIIIl) {
      if (!llllIllllIIlIll.getName().equalsIgnoreCase("ads")) {
         return (boolean)lIIIll[0];
      } else {
         String llllIllllIIIlIl;
         Iterator llllIlllIllllll;
         if (llllIllllIIIIll.hasPermission("rival.ads") && llllIllllIIIIll.isOp()) {
            if (llllIllllIIIIIl.length == 0) {
               llllIlllIllllll = llllIllllIIllIl.plugin.getConfig().getStringList("ads-usage").iterator();
               "".length();
               if ((78 ^ 74) <= ((145 ^ 159) & ~(145 ^ 159))) {
                  return (boolean)((47 ^ 25) & ~(240 ^ 198));
               } else {
                  while(llllIlllIllllll.hasNext()) {
                     llllIllllIIIlIl = (String)llllIlllIllllll.next();
                     llllIllllIIIIll.sendMessage(ChatColor.translateAlternateColorCodes((char)lIIIll[1], llllIllllIIIlIl));
                  }

                  return (boolean)lIIIll[0];
               }
            } else if (llllIllllIIIIIl.length != lIIIll[0]) {
               return (boolean)lIIIll[0];
            } else {
               int llllIllllIIIllI = lIIIll[2];
               "".length();
               if (((40 ^ 127) & ~(46 ^ 121)) > ((96 ^ 58) & ~(126 ^ 36) & ~((23 ^ 53) & ~(120 ^ 90)))) {
                  return (boolean)((54 ^ 108) & ~(117 ^ 47));
               } else {
                  while(llllIllllIIIllI < lIIIll[3]) {
                     Bukkit.broadcastMessage(" ");
                     "".length();
                     ++llllIllllIIIllI;
                  }

                  llllIlllIllllll = llllIllllIIllIl.plugin.getConfig().getStringList("ads-chat").iterator();
                  "".length();
                  if (((162 ^ 156 ^ 68 ^ 37) & (50 + 157 - 22 + 49 ^ 154 + 143 - 138 + 22 ^ -" ".length())) >= " ".length()) {
                     return (boolean)((127 ^ 81 ^ 246 ^ 145) & (189 + 146 - 236 + 99 ^ 12 + 72 - 0 + 59 ^ -" ".length()));
                  } else {
                     while(llllIlllIllllll.hasNext()) {
                        llllIllllIIIlIl = (String)llllIlllIllllll.next();
                        Bukkit.broadcastMessage(CC.translate(llllIllllIIIlIl));
                        "".length();
                     }

                     Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), llllIllllIIllIl.plugin.getConfig().getString("ads-ban-command").replace("%player%", llllIllllIIIIIl[lIIIll[2]]));
                     "".length();
                     return (boolean)lIIIll[0];
                  }
               }
            }
         } else {
            llllIlllIllllll = llllIllllIIllIl.plugin.getConfig().getStringList("no-permission-msg").iterator();
            "".length();
            if ((70 ^ 66) <= 0) {
               return (boolean)((98 ^ 124) & ~(131 ^ 157));
            } else {
               while(llllIlllIllllll.hasNext()) {
                  llllIllllIIIlIl = (String)llllIlllIllllll.next();
                  llllIllllIIIIll.sendMessage(ChatColor.translateAlternateColorCodes((char)lIIIll[1], llllIllllIIIlIl));
               }

               return (boolean)lIIIll[0];
            }
         }
      }
   }

   private static void lllII() {
      lIIIll = new int[4];
      lIIIll[0] = " ".length();
      lIIIll[1] = 81 ^ 119;
      lIIIll[2] = (17 + 101 - -53 + 55 ^ 164 + 50 - 166 + 124) & (86 + 94 - 113 + 71 ^ 180 + 27 - 204 + 193 ^ -" ".length());
      lIIIll[3] = 53 + 94 - 125 + 128;
   }
}
