package net.strokkur.config;

import net.strokkur.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Locations extends YamlConfiguration {
    private static Locations locations;
    private final File locationsFile;
    private final Main plugin = Main.getInstance();

    public Locations() {
        locationsFile = new File(plugin.getDataFolder(), "locations.yml");
        saveDefault();
        reload();
    }

    public static Locations getConfig() {
        if (locations == null) {
            locations = new Locations();
        }

        return locations;
    }

    public void reload() {
        try {
            super.load(locationsFile);
        }
        catch (Exception e) {
            plugin.log.severe(e.getMessage());
        }
    }

    public void save() {
        try {
            super.save(locationsFile);
        }
        catch (Exception e) {
            plugin.log.severe(e.getMessage());
        }
    }

    public void saveDefault() {
        plugin.saveResource("locations.yml", true);
    }
}
