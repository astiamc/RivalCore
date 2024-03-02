package net.strokkur.util;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.strokkur.commands.MeteorCommand;
import net.strokkur.config.Config;
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
