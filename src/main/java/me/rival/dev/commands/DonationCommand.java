package me.rival.dev.commands;

import java.util.Iterator;
import me.rival.dev.Main;
import me.rival.dev.listener.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DonationCommand implements CommandExecutor {
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private static final int[] lIlIlI;

   private static void lIIllI() {
      lIlIlI = new int[3];
      lIlIlI[0] = " ".length();
      lIlIlI[1] = 31 ^ 57;
      lIlIlI[2] = (49 ^ 126) & ~(205 ^ 130);
   }

   public boolean onCommand(CommandSender llllIIllllllllI, Command llllIIlllllllIl, String llllIIlllllllII, String[] llllIIlllllIlII) {
      if (!llllIIlllllllIl.getName().equalsIgnoreCase("donation")) {
         return (boolean)lIlIlI[0];
      } else {
         String llllIIlllllIIll;
         Iterator llllIIlllllIIlI;
         if (llllIIllllllllI.hasPermission("rival.donation") && llllIIllllllllI.isOp()) {
            if (llllIIlllllIlII.length == 0) {
               llllIIlllllIIlI = llllIIlllllIlll.plugin.getConfig().getStringList("Donation.usage").iterator();
               "".length();
               if (" ".length() == "   ".length()) {
                  return (boolean)((54 ^ 35) & ~(4 ^ 17));
               } else {
                  while(llllIIlllllIIlI.hasNext()) {
                     llllIIlllllIIll = (String)llllIIlllllIIlI.next();
                     llllIIllllllllI.sendMessage(ChatColor.translateAlternateColorCodes((char)lIlIlI[1], llllIIlllllIIll));
                  }

                  return (boolean)lIlIlI[0];
               }
            } else if (llllIIlllllIlII.length != lIlIlI[0]) {
               return (boolean)lIlIlI[0];
            } else {
               llllIIlllllIIlI = llllIIlllllIlll.plugin.getConfig().getStringList("Donation.message").iterator();
               "".length();
               if (-" ".length() > 0) {
                  return (boolean)((173 ^ 189) & ~(22 ^ 6));
               } else {
                  while(llllIIlllllIIlI.hasNext()) {
                     llllIIlllllIIll = (String)llllIIlllllIIlI.next();
                     Bukkit.broadcastMessage(CC.translate(llllIIlllllIIll).replace("%player%", llllIIlllllIlII[lIlIlI[2]]));
                     "".length();
                  }

                  if (llllIIlllllIlll.plugin.getConfig().getBoolean("Donation.trigger-gg-wave")) {
                     Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "gg start");
                     "".length();
                  }

                  return (boolean)lIlIlI[0];
               }
            }
         } else {
            llllIIlllllIIlI = llllIIlllllIlll.plugin.getConfig().getStringList("no-permission-msg").iterator();
            "".length();
            if (null != null) {
               return (boolean)((245 ^ 167 ^ 113 ^ 66) & (142 ^ 195 ^ 137 ^ 165 ^ -" ".length()));
            } else {
               while(llllIIlllllIIlI.hasNext()) {
                  llllIIlllllIIll = (String)llllIIlllllIIlI.next();
                  llllIIllllllllI.sendMessage(ChatColor.translateAlternateColorCodes((char)lIlIlI[1], llllIIlllllIIll));
               }

               return (boolean)lIlIlI[0];
            }
         }
      }
   }

   static {
      lIIllI();
   }

   public DonationCommand(Main llllIlIIIIIIllI) {
      llllIlIIIIIIlll.plugin = llllIlIIIIIIllI;
   }
}
