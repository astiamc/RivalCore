package me.rival.dev.config;

import java.io.File;
import me.rival.dev.Main;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config extends YamlConfiguration {
   private static Config config;
   private final Main plugin = Main.getInstance();
   private final File configFile;

   public void save() {
      try {
         super.save(configFile);
      }
      catch (Exception var2) {
         plugin.log.severe(var2.getMessage());
      }
   }

   public void saveDefault() {
      plugin.saveResource("config.yml", false);
   }

   public static Config getConfig() {
      if (config == null) {
         config = new Config();
      }

      return config;
   }

   public Config() {
      configFile = new File(plugin.getDataFolder(), "config.yml");
      saveDefault();
      reload();
   }

   public void reload() {
      try {
         super.load(configFile);
      }
      catch (Exception var2) {
         plugin.log.severe(var2.getMessage());
      }
   }
}
