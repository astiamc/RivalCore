package net.strokkur.util;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class CC {

    public static String B_WHITE;

    public static String BD_AQUA;

    public static String UNDERLINE;

    public static String SPACE_2;

    public static String SPACE_6;

    public static String SERVER_TS;

    public static String BD_GREEN;

    public static String B_BLACK;

    public static String SPACE_10;

    public static String MAGIC;

    public static String AQUA;

    public static String B_YELLOW;

    public static String D_BLUE;

    public static String BD_RED;

    public static String BD_PURPLE;

    public static String DG_ARROW;

    public static String D_AQUA;

    public static String SPACE_4;

    public static String ARROW_RIGHT;

    public static String D_GREEN;

    public static String B_PURPLE;

    public static String BD_GRAY;

    public static String PERM_MSG;

    public static String GOLD;

    public static String ITALIC;

    public static String PURPLE;

    public static String STRIKE;

    public static String B_GOLD;

    public static String SPACE_8;

    public static String YELLOW;

    public static String SPACE_9;

    public static String RED;

    public static String SERVER_STORE;

    public static String B_GRAY;

    public static String WHITE;

    public static String BLUE;

    public static String D_GRAY;

    public static String B_AQUA;

    public static String THIRD;

    public static String SERVER_IP;

    public static String B_BLUE;

    public static String GREEN;

    public static String LINE_MSG;

    public static String SERVER_NAME;

    public static String SPACE_7;

    public static String MAIN;

    public static String KITMAP_ONLY;

    public static Integer MAP_NUMBER;

    public static String D_PURPLE;

    public static String BOLD;

    public static String SECOND;

    public static String STRIKE_THROUGH;

    public static String SPACE_3;

    public static String B_GREEN;

    public static String SERVER_WEBSITE;

    public static String RESET;

    public static String BLACK;

    public static String D_RED;

    public static String SPACE_5;

    public static String BD_BLUE;

    public static String B_RED;

    public static String LINE;

    public static String GRAY;

    public static String SERVER_DISCORD;

    public static String SPACE;

    public static String ONLY_PLAYERS;

    static {
        MAIN = ChatColor.GOLD.toString();
        SECOND = ChatColor.WHITE.toString();
        THIRD = ChatColor.GRAY.toString();
        PERM_MSG = "You do not have permission to execute that command!";
        ONLY_PLAYERS = "This command can only be executed by players!";
        KITMAP_ONLY = "This command is disabled on HCF mode.";
        LINE_MSG = "----------------------------";
        DG_ARROW = ChatColor.DARK_GRAY + "»";
        SPACE = " ";
        SPACE_2 = "  ";
        SPACE_3 = "   ";
        SPACE_4 = "    ";
        SPACE_5 = "     ";
        SPACE_6 = "      ";
        SPACE_7 = "       ";
        SPACE_8 = "        ";
        SPACE_9 = "         ";
        SPACE_10 = "          ";
        MAGIC = ChatColor.MAGIC.toString();
        BOLD = ChatColor.BOLD.toString();
        STRIKE = ChatColor.STRIKETHROUGH.toString();
        UNDERLINE = ChatColor.UNDERLINE.toString();
        ITALIC = ChatColor.ITALIC.toString();
        RESET = ChatColor.WHITE.toString();
        AQUA = ChatColor.AQUA.toString();
        BLACK = ChatColor.BLACK.toString();
        BLUE = ChatColor.BLUE.toString();
        D_AQUA = ChatColor.DARK_AQUA.toString();
        D_BLUE = ChatColor.DARK_BLUE.toString();
        D_GRAY = ChatColor.DARK_GRAY.toString();
        D_GREEN = ChatColor.DARK_GREEN.toString();
        D_PURPLE = ChatColor.DARK_PURPLE.toString();
        D_RED = ChatColor.DARK_RED.toString();
        GOLD = ChatColor.GOLD.toString();
        GRAY = ChatColor.GRAY.toString();
        GREEN = ChatColor.GREEN.toString();
        PURPLE = ChatColor.LIGHT_PURPLE.toString();
        RED = ChatColor.RED.toString();
        WHITE = ChatColor.WHITE.toString();
        YELLOW = ChatColor.YELLOW.toString();
        ARROW_RIGHT = "»";
        B_AQUA = String.valueOf(ChatColor.AQUA) + ChatColor.BOLD;
        B_BLACK = String.valueOf(ChatColor.BLACK) + ChatColor.BOLD;
        B_BLUE = String.valueOf(ChatColor.BLUE) + ChatColor.BOLD;
        B_GOLD = String.valueOf(ChatColor.GOLD) + ChatColor.BOLD;
        B_GRAY = String.valueOf(ChatColor.GRAY) + ChatColor.BOLD;
        B_GREEN = String.valueOf(ChatColor.GREEN) + ChatColor.BOLD;
        B_PURPLE = String.valueOf(ChatColor.LIGHT_PURPLE) + ChatColor.BOLD;
        B_RED = String.valueOf(ChatColor.RED) + ChatColor.BOLD;
        B_WHITE = String.valueOf(ChatColor.WHITE) + ChatColor.BOLD;
        B_YELLOW = String.valueOf(ChatColor.YELLOW) + ChatColor.BOLD;
        BD_AQUA = String.valueOf(ChatColor.DARK_AQUA) + ChatColor.BOLD;
        BD_BLUE = String.valueOf(ChatColor.DARK_BLUE) + ChatColor.BOLD;
        BD_GRAY = String.valueOf(ChatColor.DARK_GRAY) + ChatColor.BOLD;
        BD_GREEN = String.valueOf(ChatColor.DARK_GREEN) + ChatColor.BOLD;
        BD_PURPLE = String.valueOf(ChatColor.DARK_PURPLE) + ChatColor.BOLD;
        BD_RED = String.valueOf(ChatColor.DARK_RED) + ChatColor.BOLD;
        STRIKE_THROUGH = ChatColor.STRIKETHROUGH.toString();
        LINE = String.valueOf(ChatColor.GRAY) + ChatColor.STRIKETHROUGH;
    }

    public static String translate(String lllllIIlIIllIIl) {
        return ChatColor.translateAlternateColorCodes('&', lllllIIlIIllIIl);
    }

    public static List<String> translateFromArray(List<String> in) {
        List<String> list = new ArrayList<>();

        for (String str : in) {
            list.add(translate(str));
        }

        return list;
    }
}
