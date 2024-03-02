package net.strokkur.config;

import net.strokkur.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config extends YamlConfiguration {
    private static Config config;
    private final Main plugin;
    private final File configFile;

    public Config(Main instance) {
        plugin = instance;
        configFile = new File(plugin.getDataFolder(), "config.yml");
        saveDefault();
        reload();
    }

    public static Config getConfig() {
        if (config == null) {
            config = new Config(Main.getInstance());
        }

        return config;
    }

    public void save() {
        try {
            super.save(configFile);
        }
        catch (Exception e) {
            plugin.log.severe(e.getMessage());
        }
    }

    public void saveDefault() {
        plugin.saveResource("config.yml", false);
    }

    public void reload() {
        try {
            super.load(configFile);
        }
        catch (Exception e) {
            plugin.log.severe(e.getMessage());
        }
    }
}
