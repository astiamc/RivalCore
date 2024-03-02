package me.rival.dev.commands;

import me.rival.dev.Main;
import me.rival.dev.listener.DarkZoneMeteorsListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;

public class HelpCommand implements CommandExecutor {
    DarkZoneMeteorsListener DarkZoneMeteorsListener;
    private final Main plugin = Main.getInstance();

    public HelpCommand() {
        DarkZoneMeteorsListener = new DarkZoneMeteorsListener();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!command.getName().equalsIgnoreCase("help")) {
            return true;
        }

        for (String str : plugin.getConfig().getStringList("Help.message")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
        }

        return true;
    }
}
