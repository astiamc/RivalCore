package me.rival.dev.listener;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.rival.dev.commands.MeteorCommand;
import me.rival.dev.config.Config;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlaceholderHook extends PlaceholderExpansion {


   @Override
   public @NotNull String getIdentifier() {
      return "rivalmeteors";
   }

   @Override
   public @NotNull String getAuthor() {
      return "Sisa";
   }

   @Override
   public @NotNull String getVersion() {
      return "1.1";
   }

   @Override
   public String onPlaceholderRequest(Player p, String placeholder) {
      if (placeholder.equalsIgnoreCase("time")) {
         long time = Config.getConfig().getLong("darkzone-meteor-nexttime") - System.currentTimeMillis();
         return MeteorCommand.timeAsString(time);
      }
      return "";
   }
}
