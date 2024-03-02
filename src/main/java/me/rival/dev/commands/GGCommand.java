package me.rival.dev.commands;

import java.util.Iterator;
import me.rival.dev.Main;
import me.rival.dev.listener.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GGCommand implements CommandExecutor {
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private static final int[] lIlIl;

   public boolean onCommand(CommandSender lllllIIllIllIll, Command lllllIIllIlIIlI, String lllllIIllIllIIl, String[] lllllIIllIlIIIl) {
      if (!lllllIIllIlIIlI.getName().equalsIgnoreCase("gg")) {
         return (boolean)lIlIl[0];
      } else {
         String lllllIIllIlIIII;
         Iterator lllllIIllIIllll;
         if (lllllIIllIllIll.hasPermission("rival.gg") && lllllIIllIllIll.isOp()) {
            if (lllllIIllIlIIIl.length != 0) {
               if (lllllIIllIlIIIl.length >= lIlIl[0] && lllllIIllIlIIIl[lIlIl[2]].equalsIgnoreCase("start")) {
                  Bukkit.broadcastMessage(CC.translate(lllllIIllIlIlII.plugin.getConfig().getString("gg-start")));
                  "".length();
                  Long lllllIIllIlIlIl = lllllIIllIlIlII.plugin.getConfig().getLong("gg-time");
                  lllllIIllIlIlII.plugin.setTimeL(System.currentTimeMillis() + lllllIIllIlIlIl * 1000L);
                  Bukkit.getScheduler().runTaskLater(lllllIIllIlIlII.plugin, () -> {
                     Bukkit.broadcastMessage(CC.translate(lllllIIllIIllII.plugin.getConfig().getString("gg-end")));
                  }, 20L * lllllIIllIlIlIl);
                  "".length();
                  return (boolean)lIlIl[0];
               } else {
                  return (boolean)lIlIl[0];
               }
            } else {
               lllllIIllIIllll = lllllIIllIlIlII.plugin.getConfig().getStringList("gg-usage").iterator();
               "".length();
               if ("  ".length() <= -" ".length()) {
                  return (boolean)((102 ^ 117) & ~(59 ^ 40));
               } else {
                  while(lllllIIllIIllll.hasNext()) {
                     lllllIIllIlIIII = (String)lllllIIllIIllll.next();
                     lllllIIllIllIll.sendMessage(ChatColor.translateAlternateColorCodes((char)lIlIl[1], lllllIIllIlIIII));
                  }

                  return (boolean)lIlIl[0];
               }
            }
         } else {
            lllllIIllIIllll = lllllIIllIlIlII.plugin.getConfig().getStringList("no-permission-msg").iterator();
            "".length();
            if (null != null) {
               return (boolean)((103 ^ 64 ^ 104 ^ 4) & (8 ^ 63 ^ 9 ^ 117 ^ -" ".length()));
            } else {
               while(lllllIIllIIllll.hasNext()) {
                  lllllIIllIlIIII = (String)lllllIIllIIllll.next();
                  lllllIIllIllIll.sendMessage(ChatColor.translateAlternateColorCodes((char)lIlIl[1], lllllIIllIlIIII));
               }

               return (boolean)lIlIl[0];
            }
         }
      }
   }

   private static void lIIIl() {
      lIlIl = new int[3];
      lIlIl[0] = " ".length();
      lIlIl[1] = 66 ^ 100;
      lIlIl[2] = (217 ^ 134) & ~(238 ^ 177);
   }

   public GGCommand(Main lllllIIlllIIlIl) {
      lllllIIlllIIllI.plugin = lllllIIlllIIlIl;
   }

   static {
      lIIIl();
   }
}
