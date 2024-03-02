package me.rival.dev.commands;

import java.util.Iterator;

import me.rival.dev.Main;
import me.rival.dev.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DonationCommand implements CommandExecutor {
    private final Main plugin = Main.getInstance();


    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!command.getName().equalsIgnoreCase("donation")) {
            return true;
        }
        String string;
        Iterator<String> stringIterator;
        if (sender.hasPermission("rival.donation") && sender.isOp()) {
            if (args.length == 0) {
                stringIterator = plugin.getConfig().getStringList("Donation.usage").iterator();

                while (stringIterator.hasNext()) {
                    string = stringIterator.next();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
                }

                return true;
            }

            if (args.length != 1) {
                return true;
            }

            stringIterator = plugin.getConfig().getStringList("Donation.message").iterator();
            while (stringIterator.hasNext()) {
                string = stringIterator.next();
                Bukkit.broadcastMessage(CC.translate(string).replace("%player%", args[0]));
            }

            if (plugin.getConfig().getBoolean("Donation.trigger-gg-wave")) {
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "gg start");
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
}
