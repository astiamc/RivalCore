package me.rival.dev.commands;

import java.util.Iterator;

import me.rival.dev.Main;
import me.rival.dev.listener.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdsCommand implements CommandExecutor {
    Main plugin;

    public AdsCommand(Main main) {
        plugin = main;
    }

    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!command.getName().equalsIgnoreCase("ads")) {
            return true;
        }
        String string;
        Iterator<String> stringIterator;

        if (!sender.hasPermission("rival.ads") || !sender.isOp()) {
            stringIterator = plugin.getConfig().getStringList("no-permission-msg").iterator();
            while (stringIterator.hasNext()) {
                string = stringIterator.next();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
            }

            return true;
        }

        if (args.length == 0) {
            stringIterator = plugin.getConfig().getStringList("ads-usage").iterator();
            while (stringIterator.hasNext()) {
                string = stringIterator.next();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
            }

            return true;
        }

        if (args.length != 1) {
            return true;
        }


        for (int i = 0; i < 150; i++) {
            Bukkit.broadcastMessage(" ");
        }

        stringIterator = plugin.getConfig().getStringList("ads-chat").iterator();
        while (stringIterator.hasNext()) {
            string = stringIterator.next();
            Bukkit.broadcastMessage(CC.translate(string));
        }

        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), plugin.getConfig().getString("ads-ban-command").replace("%player%", args[0]));
        return true;
    }
}
