package me.rival.dev.listener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.rival.dev.Main;
import me.rival.dev.config.Config;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class DarkZoneMeteorsListener implements Listener {
    private static final List<Location> spawnLocations = new ArrayList<>();
    Main plugin;

    public static void meteor(Location loc) {
        Location newLoc;

        newLoc = compare(loc.getX()) > 0 ? loc.subtract(2.0D, 0.0D, -5.0D) : loc.add(2.0D, 0.0D, -5.0D);

        World world = Bukkit.getWorld(Config.getConfig().getString("darkzone-world-name")); // ?
        Giant giant = (Giant) newLoc.getWorld().spawnEntity(newLoc, EntityType.GIANT);
        giant.setCustomNameVisible(true);
        giant.getEquipment().setItemInHand(new ItemStack(Material.TNT));
        giant.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 360000, 0));

        Location giantLocation = giant.getLocation();
        for (int i = 10; i <= 50; i += 5) {
            run(giantLocation, giant, i, (float) i / 10f);
        }

        endRun(loc, giant);
    }

    public static void setLocations(Player p) {
        List<String> locationList = Locations.getConfig().getStringList("Locations");
        locationList.add(getStringFromLocation(p.getLocation()));
        Locations.getConfig().set("Locations", locationList);
        Locations.getConfig().save();
    }

    private static String getStringFromLocation(Location loc) {
        return "World:" + loc.getWorld().getName() + ", X:" + loc.getBlockX() + ", Y:" + loc.getBlockY() + ", Z:" + loc.getBlockZ();
    }

    public static void spawnMeteors() {
        Iterator<Location> locationIterator = getSpawnLocations().iterator();
        locationIterator.forEachRemaining(loc -> {
            meteor(loc);
            loc = locationIterator.next();
            if (!loc.getChunk().isLoaded()) {
                loc.getChunk().load();
            }
        });
    }

    public static void load() {
        spawnLocations.clear();
        for (String location : Locations.getConfig().getStringList("Locations")) {
            try {
                spawnLocations.add(getLocationFromString(location));
            } catch (Exception e) {
                /* lol frick you this is just so that the plugin doesn't stop */
            }
        }
    }

    private static int compare(double var0) {
        return Double.compare(var0, 0d);
    }

    private static void run(Location loc, Giant giant, int delay, float blocks) {
        new BukkitRunnable() {
            @Override
            public void run() {
                loc.setY(loc.getBlockY() - blocks);
                giant.teleport(loc);
            }
        }.runTaskLater(Main.getInstance(), delay);
    }

    private static void endRun(Location loc, Giant giant) {
        new BukkitRunnable() {
            @Override
            public void run() {
                loc.getWorld().playEffect(loc, Effect.EXPLOSION_HUGE, 200);
                loc.getWorld().playSound(loc, Sound.EXPLODE, 5f, 5f);
                var nearbyBlocksIterator = DarkZoneMeteorsListener.getNearbyBlocks(loc, 8).iterator();

                loc.getWorld().playEffect(loc, Effect.EXPLOSION_HUGE, 200);
                loc.getWorld().playSound(loc, Sound.EXPLODE, 5f, 5f);

                while (nearbyBlocksIterator.hasNext()) {
                    Block block = nearbyBlocksIterator.next();
                    Chunk chunk = block.getChunk();
                    if (block.getType().equals(Material.STONE)) {
                        if (!chunk.isLoaded()) {
                            chunk.load();
                        }

                        block.setType(Material.QUARTZ_ORE);
                        block.getWorld().playEffect(block.getLocation(), Effect.EXPLOSION_HUGE, 200);
                        runListener91(chunk, block);
                    }
                }

                giant.remove();
            }
        }.runTaskLater(Main.getInstance(), 50);
    }

    private static void runListener91(Chunk chunk, Block block) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!chunk.isLoaded()) {
                    chunk.load();
                }

                block.setType(Material.STONE);
                block.getWorld().playEffect(block.getLocation(), Effect.MOBSPAWNER_FLAMES, 200);
            }
        }.runTaskLater(Main.getInstance(), 600L);

    }

    public DarkZoneMeteorsListener(Main main) {
        plugin = main;
    }

    private static Location getLocationFromString(String location) {
        World world = Main.instance.getServer().getWorlds().get(0);
        int x = 0;
        int y = 0;
        int z = 0;

        String[] infos = location.toLowerCase().split(", ");
        for (String info : infos) {
            if (info.startsWith("world:")) {
                world = Main.instance.getServer().getWorld(info.replace("world:", ""));
                continue;
            }

            if (info.startsWith("x:")) {
                x = Integer.parseInt(info.replace("x:", ""));
                continue;
            }

            if (info.startsWith("y:")) {
                y = Integer.parseInt(info.replace("y:", ""));
                continue;
            }

            if (info.startsWith("z:")) {
                z = Integer.parseInt(info.replace("z:", ""));
            }
        }

        return new Location(world, x, y, z);
    }

    private List<Location> getLocationsFromStringList(List<String> stringList) {
        ArrayList<Location> out = new ArrayList<>();
        for (String str : stringList) {
            out.add(getLocationFromString(str));
        }

        return out;
    }

    public static void startMeteorsThread() {
        load();
        for (String msg : Main.getInstance().getConfig().getStringList("darkzone-meteor-msg")) {
            msg = msg.replace("%time%", "5");
            Bukkit.broadcastMessage(CC.translate(msg));
        }

        run10();
        run11();
        run12();
        run13();
    }

    static void run10() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (String msg : Main.getInstance().getConfig().getStringList("darkzone-meteor-msg")) {
                    msg = msg.replace("%time%", "3");
                    Bukkit.broadcastMessage(CC.translate(msg));
                }
            }
        }.runTaskLater(Main.getInstance(), 40);
    }

    static void run11() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (String msg : Main.getInstance().getConfig().getStringList("darkzone-meteor-msg")) {
                    msg = msg.replace("%time%", "2");
                    Bukkit.broadcastMessage(CC.translate(msg));
                }
            }
        }.runTaskLater(Main.getInstance(), 60L);
    }

    static void run12() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (String msg : Main.getInstance().getConfig().getStringList("darkzone-meteor-msg")) {
                    msg = msg.replace("%time%", "1");
                    Bukkit.broadcastMessage(CC.translate(msg));
                }
            }
        }.runTaskLater(Main.getInstance(), 80L);
    }

    static void run13() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Config.getConfig().set("darkzone-meteor-nexttime", System.currentTimeMillis() + (Config.getConfig().getInt("darkzone-meteor-time") * 1000L));
                Config.getConfig().save();
                DarkZoneMeteorsListener.spawnMeteors();
            }
        }.runTaskLater(Main.getInstance(), 100L);
    }

    public static List<Block> getNearbyBlocks(Location loc, int radius) {
        List<Block> out = new ArrayList<>();
        int negativeX = loc.getBlockX() - radius;

        while (negativeX <= loc.getBlockX() + radius) {

            int negativeY = loc.getBlockY() - radius;
            while (negativeY <= loc.getBlockY() + radius) {

                int negativeZ = loc.getBlockZ() - radius;
                while (negativeZ <= loc.getBlockZ() + radius) {
                    out.add(loc.getWorld().getBlockAt(negativeX, negativeY, negativeZ));
                    negativeZ++;
                }

                negativeY++;
            }

            negativeX++;
        }

        return out;
    }

    public static List<Location> getSpawnLocations() {
        return spawnLocations;
    }
}
