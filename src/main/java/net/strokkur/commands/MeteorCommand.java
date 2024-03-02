package net.strokkur.commands;

import net.strokkur.Main;
import net.strokkur.config.Config;
import net.strokkur.config.Locations;
import net.strokkur.listener.DarkZoneMeteorsListener;
import net.strokkur.util.CC;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class MeteorCommand implements CommandExecutor {
    private final Main plugin = Main.getInstance();

    public static String timeAsString(long time) {
        String out = "";
        long newTime;

        long days = TimeUnit.MILLISECONDS.toDays(time);
        newTime = time - TimeUnit.DAYS.toMillis(days);

        long hours = TimeUnit.MILLISECONDS.toHours(newTime);
        newTime -= TimeUnit.HOURS.toMillis(hours);

        long minutes = TimeUnit.MILLISECONDS.toMinutes(newTime);
        newTime -= TimeUnit.MINUTES.toMillis(minutes);

        long seconds = TimeUnit.MILLISECONDS.toSeconds(newTime);
        if (compare(newTime, 0L) <= 0) {
            out = "Now";
        }

        if (compare(days, 1L) > 0) {
            out = out + days + " days ";
        }
        else if (compare(days, 1L) == 0) {
            out = out + days + " day ";
        }

        if (compare(hours, 1L) > 0) {
            out = out + hours + " hours ";
        }
        else if (compare(hours, 1L) == 0) {
            out = out + hours + " hour ";
        }

        if (compare(minutes, 1L) > 0) {
            out = out + minutes + " minutes ";
        }
        else if (compare(minutes, 1L) == 0) {
            out = out + minutes + " minute ";
        }

        if (compare(seconds, 1L) > 0) {
            out = out + seconds + " seconds ";
        }
        else if (compare(seconds, 1L) == 0) {
            out = out + seconds + " second ";
        }

        return out;
    }

    private static int compare(long var0, long var2) {
        return Long.compare(var0 - var2, 0);
    }

    public boolean onCommand(CommandSender sender, Command commmand, String alias, String[] args) {
        if (!commmand.getName().equalsIgnoreCase("meteor")) {
            return true;
        }

        if (args.length == 0) {
            for (String str : plugin.getConfig().getStringList("darkzone-usage")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
            }
            return true;
        }


        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("start")) {
                if (!sender.hasPermission("rival.meteor") && !sender.isOp()) {
                    sender.sendMessage(CC.translate("&cYou don't have the required permission."));
                }
                else {
                    sender.sendMessage(CC.translate("&cYou have force started the Meteor Event."));
                    DarkZoneMeteorsListener.startMeteorsThread();
                }

                return true;
            }

            if (args[0].equalsIgnoreCase("setlocation")) {
                if (!sender.hasPermission("rival.meteor") && !sender.isOp()) {
                    sender.sendMessage(CC.translate("&cYou don't have the required permission."));
                }
                else {
                    sender.sendMessage(CC.translate("&cYou have set the new Meteor Location"));
                    DarkZoneMeteorsListener.setLocations((Player) sender);
                    DarkZoneMeteorsListener.load();
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("reload")) {
                if (!sender.hasPermission("rival.meteor") && !sender.isOp()) {
                    sender.sendMessage(CC.translate("&cYou don't have the required permission."));
                }
                else {
                    sender.sendMessage(CC.translate("&cYou have reloaded the Meteor Config."));
                    Config.getConfig().reload();
                    Locations.getConfig().reload();
                    DarkZoneMeteorsListener.load();
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("time")) {
                long remaining = Config.getConfig().getLong("darkzone-meteor-nexttime") - System.currentTimeMillis();
                sender.sendMessage(CC.translate(Config.getConfig().getString("darkzone-time-message")).replace("{time}", timeAsString(remaining)));
            }
        }

        return true;
    }
}
