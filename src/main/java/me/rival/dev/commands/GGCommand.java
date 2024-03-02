package me.rival.dev.commands;

import java.util.Iterator;

import me.rival.dev.Main;
import me.rival.dev.listener.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GGCommand implements CommandExecutor {
    Main plugin;

    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!command.getName().equalsIgnoreCase("gg")) {
            return true;
        }
        String string;
        Iterator<String> stringIterator;

        if (sender.hasPermission("rival.gg") && sender.isOp()) {
            if (args.length != 0) {
                if (args[0].equalsIgnoreCase("start")) {
                    Bukkit.broadcastMessage(CC.translate(plugin.getConfig().getString("gg-start")));
                    long ggTime = plugin.getConfig().getLong("gg-time");
                    plugin.setTime(System.currentTimeMillis() + ggTime * 1000L);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> Bukkit.broadcastMessage(CC.translate(plugin.getConfig().getString("gg-end"))), 20L * ggTime);
                }
                return true;
            }

            stringIterator = plugin.getConfig().getStringList("gg-usage").iterator();
            while (stringIterator.hasNext()) {
                string = stringIterator.next();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
            }

            return true;

        }

        stringIterator = plugin.getConfig().getStringList("no-permission-msg").iterator();
        while (stringIterator.hasNext()) {
            string = stringIterator.next();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
        }

        return true;
    }

    public GGCommand(Main main) {
        plugin = main;
    }
}
