package me.rival.dev.config;

import java.io.File;
import me.rival.dev.Main;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config extends YamlConfiguration {
   // $FF: synthetic field
   private static final int[] lllIl;
   // $FF: synthetic field
   private static Config config;
   // $FF: synthetic field
   private final Main plugin = Main.getPlugin(Main.class);
   // $FF: synthetic field
   private File configFile;

   public void save() {
      try {
         super.save(lllllIIIlIIlIll.configFile);
      } catch (Exception var2) {
         var2.printStackTrace();
         return;
      }

      "".length();
      if (null == null) {
      }
   }

   public void saveDefault() {
      lllllIIIlIIIlll.plugin.saveResource("config.yml", (boolean)lllIl[0]);
   }

   public static Config getConfig() {
      if (config == null) {
         config = new Config();
      }

      return config;
   }

   static {
      llIII();
   }

   public Config() {
      lllllIIIlIlIlll.configFile = new File(lllllIIIlIlIlll.plugin.getDataFolder(), "config.yml");
      lllllIIIlIlIlll.saveDefault();
      lllllIIIlIlIlll.reload();
   }

   public void reload() {
      try {
         super.load(configFile);
      } catch (Exception var2) {
         var2.printStackTrace();
         return;
      }

      "".length();
      if (null == null) {
      }
   }

   private static void llIII() {
      lllIl = new int[1];
      lllIl[0] = (43 ^ 10 ^ 175 ^ 148) & (37 ^ 64 ^ 23 + 51 - 19 + 72 ^ -" ".length());
   }
}
