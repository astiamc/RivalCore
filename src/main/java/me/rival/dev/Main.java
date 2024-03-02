package me.rival.dev;

import me.rival.dev.commands.*;
import me.rival.dev.config.Config;
import me.rival.dev.listener.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    public static Main instance;
    public static Economy economy;
    public Random random;
    public List<String> ggList;
    public long time;
    public Logger log = this.getLogger();

    public Main() {
        instance = this;

        new DarkZoneMeteorsListener();
        this.time = 0L;
        this.ggList = new ArrayList<>();
        this.random = new Random();
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static Main getInstance() {
        return instance;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long newTime) {
        this.time = newTime;
    }

    public Random getRandom() {
        return random;
    }

    public List<String> getGGs() {
        return this.ggList;
    }

    public void onEnable() {
        Config.getConfig();
        Locations.getConfig();
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceholderHook().register();
        }

        if (Config.getConfig().getBoolean("darkzone-enabled")) {
            DarkZoneMeteorsListener.load();

            Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
                DarkZoneMeteorsListener.startMeteorsThread();
                Config.getConfig().set("darkzone-meteor-nexttime", System.currentTimeMillis() + (Config.getConfig().getInt("darkzone-meteor-time") * 20L));
                Config.getConfig().save();
            }, Config.getConfig().getInt("darkzone-meteor-time") * 50L, Config.getConfig().getInt("darkzone-meteor-time") * 50L);
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
        Bukkit.getConsoleSender().sendMessage(CC.translate("&b(Rival Factions Core) &c- &aMade by Azur#4386 &8--- &6Modified by Strokkur24"));
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");

        event(new GGChatListener());
        event(new WorldBorderListener());
        event(new NoNaturalSpawnsListener());
        event(new AntiHopperCraftListener());
        event(new IronGolemListener());

        event(new DarkZoneMeteorsListener(), "darkzone-enabled");
        event(new AntiWaterRedstoneListener(), "anti-water-redstone");
        event(new DeathMessageListener(), "death-messages");
        event(new WelcomeListener(), "welcome-message");
        event(new EnderPearlCooldownListener(), "enderpearl-cooldown");
        event(new AntiCobbleMonsterListener(), "anticobblemonster");
        event(new AntiRegenListener(), "regenwalls-and-spawnerprot");
        event(new DarkZoneMeteorsListener(), "darkzone-enabled");

        command("help", new HelpCommand());
        command("ads", new AdsCommand());
        command("donation", new DonationCommand());
        command("meteor", new MeteorCommand());
        command("gg", new GGCommand());

        Bukkit.getConsoleSender().sendMessage(CC.translate("&b(Rival Factions Core) &c- &aPlugin Enabled"));
    }

    private void event(Listener e, String configValue) {
        if (Config.getConfig().getBoolean(configValue)) {
            getServer().getPluginManager().registerEvents(e, this);
        }
    }

    private void event(Listener e) {
        getServer().getPluginManager().registerEvents(e, this);
    }

    private void command(String command, CommandExecutor exec, TabCompleter tabCompleter) {
        getCommand(command).setExecutor(exec);
        if (tabCompleter != null) {
            getCommand(command).setTabCompleter(tabCompleter);
        }
    }

    private void command(String command, CommandExecutor exec) {
        command(command, exec, null);
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
