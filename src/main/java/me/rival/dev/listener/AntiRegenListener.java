package me.rival.dev.listener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.rival.dev.Main;
import me.rival.dev.util.CC;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class AntiRegenListener implements Listener {
    private final Main plugin = Main.getInstance();
    private final int radius;
    public boolean lava;
    public boolean water;
    public List<Block> blocklist;

    public AntiRegenListener() {
        water = true;
        lava = true;
        radius = 3;
        blocklist = new ArrayList<>();
    }

    public static List<Block> getNearbyBlocks(Location loc, int radius) {
        List<Block> out = new ArrayList<>();
        int xPos = loc.getBlockX() - radius;
        while (xPos <= loc.getBlockX() + radius) {
            int yPos = loc.getBlockY() - radius;

            while (yPos <= loc.getBlockY() + radius) {
                int zPos = loc.getBlockZ() - radius;

                while (zPos <= loc.getBlockZ() + radius) {
                    out.add(loc.getWorld().getBlockAt(xPos, yPos, zPos));
                    ++zPos;
                }

                ++yPos;
            }

            ++xPos;
        }

        return out;
    }

    @EventHandler
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent e) {
        Material bucketMaterial = e.getBucket();
        Block blockClicked = e.getBlockClicked();
        Player p = e.getPlayer();
        String spawnerCantPlace = plugin.getConfig().getString("SpawnerCantPlace");
        if (bucketMaterial.toString().contains("WATER") || bucketMaterial.toString().contains("LAVA")) {
            int someNumber = -2;

            while (someNumber <= 2) {
                int someOtherNumber = -2;

                while (someOtherNumber <= 2) {
                    int yetAnotherNumber = -2;

                    for (; yetAnotherNumber <= 2; ++yetAnotherNumber) {
                        Location loc = new Location(blockClicked.getWorld(), blockClicked.getX() + someNumber, blockClicked.getY() + someOtherNumber, blockClicked.getZ() + yetAnotherNumber);
                        Block block = loc.getBlock();
                        if (block.getType() == Material.MOB_SPAWNER) {
                            e.setCancelled(true);
                            p.sendMessage(CC.translate(spawnerCantPlace));
                        }
                    }

                    ++someOtherNumber;
                }

                ++someNumber;
            }
        }

    }

    @EventHandler
    public void explodeLava(ExplosionPrimeEvent e) {
        if (e.getEntity().getType().equals(EntityType.PRIMED_TNT)) {
            Location loc = e.getEntity().getLocation();
            if (loc.getBlock().getType() != Material.WATER && loc.getBlock().getType() != Material.STATIONARY_WATER) {
                Iterator<Block> blockIterator = getNearbyBlocks(e.getEntity().getLocation(), (int) e.getRadius()).iterator();

                blockIterator.forEachRemaining(b -> {
                    if (b.getType() != Material.LAVA && b.getType() != Material.STATIONARY_LAVA) {
                        b.setType(Material.AIR);
                    }
                });
            }
        }
    }

    @EventHandler
    public void explodeLava(EntityExplodeEvent e) {
        if (e.getEntityType().equals(EntityType.PRIMED_TNT)) {
            Location loc = e.getEntity().getLocation();
            if (loc.getBlock().getType() != Material.WATER && loc.getBlock().getType() != Material.STATIONARY_WATER) {
                Iterator<Block> blockIterator = getNearbyBlocks(e.getEntity().getLocation(), 4).iterator();

                blockIterator.forEachRemaining(b -> {
                    if (b.getType() != Material.LAVA && b.getType() != Material.STATIONARY_LAVA) {
                        b.setType(Material.AIR);
                    }
                });
            }
        }
    }

    @EventHandler
    public void antiLava(BlockFromToEvent e) {
        Block b = e.getBlock();
        if (b.getType() == Material.LAVA || b.getType() == Material.STATIONARY_LAVA) {
            int someNumber = -3;

            while (someNumber <= 3) {
                int anotherNumber = -3;

                while (anotherNumber <= 3) {
                    int yetAnotherNumber = -3;

                    for (; yetAnotherNumber <= 3; ++yetAnotherNumber) {
                        Location loc = new Location(b.getWorld(), b.getX() + someNumber, b.getY() + anotherNumber, b.getZ() + yetAnotherNumber);
                        Block block = loc.getBlock();
                        if (block.getType() == Material.MOB_SPAWNER) {
                            e.setCancelled(true);
                        }
                    }

                    ++anotherNumber;
                }

                ++someNumber;
            }
        }

    }

    @EventHandler
    public void antiWater(BlockFromToEvent e) {
        Block b = e.getBlock();
        if (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER) {
            int number = -3;

            while (number <= 3) {
                int moreNumber = -3;

                while (moreNumber <= 3) {
                    int anotherNumber = -3;

                    for (; anotherNumber <= 3; ++anotherNumber) {
                        Location loc = new Location(b.getWorld(), b.getX() + number, b.getY() + moreNumber, b.getZ() + anotherNumber);
                        Block block = loc.getBlock();
                        if (block.getType() == Material.MOB_SPAWNER) {
                            e.setCancelled(true);
                        }
                    }

                    ++moreNumber;
                }

                ++number;
            }
        }

    }

    @EventHandler
    public void antiblockplace(BlockPlaceEvent e) {
        Block b = e.getBlock();
        Player p = e.getPlayer();
        String noSpawnerMsg = plugin.getConfig().getString("SpawnerCantPlace");
        if (b.getType() == Material.OBSIDIAN || b.getType() == Material.ENCHANTMENT_TABLE || b.getType() == Material.DISPENSER || b.getType() == Material.DROPPER) {
            long number = -2;

            while (number <= 2) {
                int moreNumber = -2;

                while (moreNumber <= 2) {
                    int yetAnotherNumber = -2;

                    for (; yetAnotherNumber <= 2; ++yetAnotherNumber) {
                        Location loc = new Location(b.getWorld(), (double) (b.getX() + number), b.getY() + moreNumber, b.getZ() + yetAnotherNumber);
                        Block block = loc.getBlock();
                        if (block.getType() == Material.MOB_SPAWNER) {
                            e.setCancelled(true);
                            p.sendMessage(CC.translate(noSpawnerMsg));
                        }
                    }

                    ++moreNumber;
                }

                ++number;
            }
        }

    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent e) {
        Block b = e.getBlock();
        World world = b.getWorld();
        if (b.getType().equals(Material.MOB_SPAWNER)) {
            int x = b.getX();
            int y = b.getY();
            int z = b.getZ();
            int negativeRadius = -radius;

            int yOffset;
            int zOffset;
            Block block;
            while (negativeRadius <= radius) {
                yOffset = -radius;

                while (yOffset <= radius) {
                    zOffset = -radius;

                    for (; zOffset <= radius; ++zOffset) {
                        block = world.getBlockAt(x + negativeRadius, y + yOffset, z + zOffset);
                        if (block.getType().equals(Material.WATER) || block.getType().equals(Material.STATIONARY_WATER) || block.getType().equals(Material.OBSIDIAN) || block.getType().equals(Material.DISPENSER)) {
                            world.getBlockAt(x + negativeRadius, y + yOffset, z + zOffset).setType(Material.AIR);
                        }
                    }

                    ++yOffset;
                }

                ++negativeRadius;
            }

            negativeRadius = -radius;

            while (negativeRadius <= radius) {
                yOffset = -radius;

                while (yOffset <= radius) {
                    zOffset = -radius;

                    for (; zOffset <= radius; ++zOffset) {
                        block = world.getBlockAt(x + negativeRadius, y + yOffset, z + zOffset);
                        if (block.getType().equals(Material.LAVA) || block.getType().equals(Material.STATIONARY_LAVA)) {
                            world.getBlockAt(x + negativeRadius, y + yOffset, z + zOffset).setType(Material.AIR);
                        }
                    }

                    ++yOffset;
                }

                ++negativeRadius;
            }
        }

    }
}
