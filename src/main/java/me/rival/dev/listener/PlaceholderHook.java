package me.rival.dev.listener;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.rival.dev.commands.MeteorCommand;
import me.rival.dev.config.Config;
import org.bukkit.entity.Player;

public class PlaceholderHook extends PlaceholderExpansion {
   // $FF: synthetic field
   private static final int[] lIllII;

   public String getAuthor() {
      return "Sisa";
   }

   public boolean persist() {
      return (boolean)lIllII[0];
   }

   public String getIdentifier() {
      return "rivalmeteors";
   }

   public String getVersion() {
      return "1.1";
   }

   private static void lIIlll() {
      lIllII = new int[1];
      lIllII[0] = " ".length();
   }

   static {
      lIIlll();
   }

   public String getPlugin() {
      return null;
   }

   public String onPlaceholderRequest(Player llllIIlllIlllII, String llllIIlllIllIIl) {
      if (llllIIlllIllIIl.equalsIgnoreCase("time")) {
         String llllIIlllIllIII = Config.getConfig().getLong("darkzone-meteor-nexttime") - System.currentTimeMillis();
         return MeteorCommand.timeAsString(llllIIlllIllIII);
      } else {
         return null;
      }
   }
}
