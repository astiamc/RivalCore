package me.rival.dev.listener;

import java.io.File;
import me.rival.dev.Main;
import org.bukkit.configuration.file.YamlConfiguration;

public class Locations extends YamlConfiguration {
   // $FF: synthetic field
   private static final int[] lll;
   // $FF: synthetic field
   private static Locations locations;
   // $FF: synthetic field
   private File locationsFile;
   // $FF: synthetic field
   private Main plugin = (Main)Main.getPlugin(Main.class);

   public static Locations getConfig() {
      if (locations == null) {
         locations = new Locations();
      }

      return locations;
   }

   public void reload() {
      try {
         super.load(lllllllIllIIIIl.locationsFile);
      } catch (Exception var2) {
         var2.printStackTrace();
         return;
      }

      "".length();
      if (null == null) {
         ;
      }
   }

   public Locations() {
      lllllllIllIIlII.locationsFile = new File(lllllllIllIIlII.plugin.getDataFolder(), "locations.yml");
      lllllllIllIIlII.saveDefault();
      lllllllIllIIlII.reload();
   }

   private static void lII() {
      lll = new int[1];
      lll[0] = (55 + 147 - 125 + 78 ^ 101 + 44 - 83 + 113) & (16 ^ 67 ^ 60 ^ 91 ^ -" ".length());
   }

   public void save() {
      try {
         super.save(lllllllIlIllIIl.locationsFile);
      } catch (Exception var2) {
         var2.printStackTrace();
         return;
      }

      "".length();
      if ("  ".length() != 0) {
         ;
      }
   }

   static {
      lII();
   }

   public void saveDefault() {
      lllllllIlIlIlIl.plugin.saveResource("locations.yml", (boolean)lll[0]);
   }
}
