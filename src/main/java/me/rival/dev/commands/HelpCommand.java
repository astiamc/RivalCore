package me.rival.dev.commands;

import me.rival.dev.Main;
import me.rival.dev.listener.DarkZoneMeteorsListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
   // $FF: synthetic field
   DarkZoneMeteorsListener DarkZoneMeteorsListener;
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private static final int[] lI;

   private static void lI() {
      lI = new int[2];
      lI[0] = " ".length();
      lI[1] = 155 ^ 189 ^ (159 ^ 173) & ~(59 ^ 9);
   }

   static {
      lI();
   }

   public HelpCommand(Main llllllllIlIIIII) {
      llllllllIIlllll.DarkZoneMeteorsListener = new DarkZoneMeteorsListener(llllllllIIlllll.plugin);
      llllllllIIlllll.plugin = llllllllIlIIIII;
   }

   public boolean onCommand(CommandSender llllllllIIlIlIl, Command llllllllIIIllIl, String llllllllIIlIIll, String[] llllllllIIlIIlI) {
      if (!llllllllIIIllIl.getName().equalsIgnoreCase("help")) {
         return (boolean)lI[0];
      } else {
         if (llllllllIIlIIlI.length >= 0) {
            Player llllllllIIlIIIl = (Player)llllllllIIlIlIl;
            boolean llllllllIIIlIIl = llllllllIIIllll.plugin.getConfig().getStringList("Help.message").iterator();
            "".length();
            if (-" ".length() > 0) {
               return (boolean)((202 ^ 138) & ~(55 ^ 119));
            }

            while(llllllllIIIlIIl.hasNext()) {
               char llllllllIIIlIlI = (String)llllllllIIIlIIl.next();
               llllllllIIlIlIl.sendMessage(ChatColor.translateAlternateColorCodes((char)lI[1], llllllllIIIlIlI));
            }
         }

         return (boolean)lI[0];
      }
   }
}
