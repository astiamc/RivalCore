package me.rival.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import me.rival.dev.commands.AdsCommand;
import me.rival.dev.commands.DonationCommand;
import me.rival.dev.commands.GGCommand;
import me.rival.dev.commands.HelpCommand;
import me.rival.dev.commands.MeteorCommand;
import me.rival.dev.config.Config;
import me.rival.dev.listener.AntiCobbleMonsterListener;
import me.rival.dev.listener.AntiHopperCraftListener;
import me.rival.dev.listener.AntiRegenListener;
import me.rival.dev.listener.AntiWaterRedstoneListener;
import me.rival.dev.listener.CC;
import me.rival.dev.listener.DarkZoneListener;
import me.rival.dev.listener.DarkZoneMeteorsListener;
import me.rival.dev.listener.DeathMessageListener;
import me.rival.dev.listener.EnderPearlCooldownListener;
import me.rival.dev.listener.GGChatListener;
import me.rival.dev.listener.IronGolemListener;
import me.rival.dev.listener.Locations;
import me.rival.dev.listener.NoNaturalSpawnsListener;
import me.rival.dev.listener.PlaceholderHook;
import me.rival.dev.listener.WelcomeListener;
import me.rival.dev.listener.WorldBorderListener;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
   public static Main instance;
   public Random random;
   public static Economy economy;
   public List<String> ggList;
   public long time;
   DarkZoneMeteorsListener DarkZoneMeteorsListener;
   public Logger log = this.getLogger();
   private static int[] someIntegerValues;

   public long getTime() {
      return this.time;
   }

   public void setTime(long newTime) {
      this.time = newTime;
   }

   public static Economy getEconomy() {
      return economy;
   }

   public Random getRandom() {
      return random;
   }

   public Main() {
      this.DarkZoneMeteorsListener = new DarkZoneMeteorsListener(instance);
      this.time = 0L;
      this.ggList = new ArrayList<>();
      this.random = new Random();
   }

   public List<String> getGGs() {
      return this.ggList;
   }

   public void onEnable() {
      Config.getConfig();
      Locations.getConfig();
      if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
         // TODO: Figure out this placeholder hook
         new PlaceholderHook().register();
      }

      if (Config.getConfig().getBoolean("darkzone-enabled")) {
         me.rival.dev.listener.DarkZoneMeteorsListener.load();
         // TODO Fix this
         Bukkit.getScheduler().runTaskTimerAsynchronously(this,
                 (long)(Config.getConfig().getInt("darkzone-meteor-time") * someIntegerValues[0]),
                 (long)(Config.getConfig().getInt("darkzone-meteor-time") * someIntegerValues[0]));

      }

      this.loadGGs();
      if (!this.setupEconomy()) {
         log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
         this.getServer().getPluginManager().disablePlugin(this);
         return;
      }

      Bukkit.getConsoleSender().sendMessage("");
      Bukkit.getConsoleSender().sendMessage("");
      Bukkit.getConsoleSender().sendMessage("");
      Bukkit.getConsoleSender().sendMessage(CC.translate("&b(Rival Factions Core) &c- &aPlugin loading...."));
      Bukkit.getConsoleSender().sendMessage(CC.translate("&b(Rival Factions Core) &c- &aMade by Azur#4386"));
      Bukkit.getConsoleSender().sendMessage("");
      Bukkit.getConsoleSender().sendMessage("");
      Bukkit.getConsoleSender().sendMessage("");
      instance = this;

      PluginManager pluginManager = this.getServer().getPluginManager();
      if (Config.getConfig().getBoolean("darkzone-enabled")) {
         pluginManager.registerEvents(new DarkZoneListener(this), this);
      }

      pluginManager.registerEvents(new GGChatListener(this), this);
      pluginManager.registerEvents(new WorldBorderListener(this), this);
      pluginManager.registerEvents(new NoNaturalSpawnsListener(this), this);
      pluginManager.registerEvents(new AntiHopperCraftListener(this), this);
      if (Config.getConfig().getBoolean("anti-water-redstone")) {
         pluginManager.registerEvents(new AntiWaterRedstoneListener(this), this);
      }

      if (Config.getConfig().getBoolean("death-messages")) {
         pluginManager.registerEvents(new DeathMessageListener(this), this);
      }

      pluginManager.registerEvents(new IronGolemListener(this), this);
      if (Config.getConfig().getBoolean("welcome-message")) {
         pluginManager.registerEvents(new WelcomeListener(this), this);
      }

      if (Config.getConfig().getBoolean("enderpearl-cooldown")) {
         pluginManager.registerEvents(new EnderPearlCooldownListener(this), this);
      }

      if (Config.getConfig().getBoolean("anticobblemonster")) {
         pluginManager.registerEvents(new AntiCobbleMonsterListener(this), this);
      }

      if (Config.getConfig().getBoolean("regenwalls-and-spawnerprot")) {
         pluginManager.registerEvents(new AntiRegenListener(this), this);
      }

      if (Config.getConfig().getBoolean("darkzone-enabled")) {
         pluginManager.registerEvents(new DarkZoneMeteorsListener(this), this);
      }

      this.getCommand("help").setExecutor(new HelpCommand(this));
      this.getCommand("ads").setExecutor(new AdsCommand(this));
      this.getCommand("donation").setExecutor(new DonationCommand(this));
      this.getCommand("meteor").setExecutor(new MeteorCommand(this));
      this.getCommand("gg").setExecutor(new GGCommand(this));
      Bukkit.getConsoleSender().sendMessage(CC.translate("&b(Rival Factions Core) &c- &aPlugin Enabled"));

   }

   public static Main getInstance() {
      return instance;
   }

   public void loadGGs() {
      this.ggList.clear();
      ggList.addAll(this.getConfig().getStringList("gg-list"));
   }

   public boolean setupEconomy() {
      if (getServer().getPluginManager().getPlugin("Vault") == null) {
         return false;
      }

      RegisteredServiceProvider<Economy> economyServiceProvider = getServer().getServicesManager().getRegistration(Economy.class);
      if (economyServiceProvider == null) {
         return false;
      }

      economy = economyServiceProvider.getProvider();
      return economy != null;
   }

   @Override
   public void onDisable() {
      instance = null;
   }

}
