package net.strokkur.commands;

import net.strokkur.Main;
import net.strokkur.listener.DarkZoneMeteorsListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {
    private final Main plugin = Main.getInstance();
    DarkZoneMeteorsListener DarkZoneMeteorsListener;

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
