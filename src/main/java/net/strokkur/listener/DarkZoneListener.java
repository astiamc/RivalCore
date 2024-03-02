package net.strokkur.listener;

import net.strokkur.Main;
import net.strokkur.config.Config;
import net.strokkur.util.CC;
import net.strokkur.util.ItemBuilder;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class DarkZoneListener implements Listener {
    private final Main plugin = Main.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBlockBreak333(BlockDamageEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();
        if (p.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && p.getItemInHand().getType().toString().toLowerCase().contains("pickaxe") && (block.getType() == Material.DIAMOND_ORE || block.getType() == Material.QUARTZ_ORE || block.getType() == Material.EMERALD_ORE) && p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
            p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
        }
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onBlockBreak2(BlockBreakEvent e) {
        int min = plugin.getConfig().getInt("darkzonegems.min");
        int max = plugin.getConfig().getInt("darkzonegems.max");
        int amount = plugin.getRandom().nextInt((max - min)) + min;

        ItemStack is = (new ItemBuilder(Material.INK_SACK)).data((short) 10).enchant(Enchantment.DURABILITY, 10).displayName(CC.translate(plugin.getConfig().getString("darkzone-meteor-uranium-name"))).build();
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();
        Block block = e.getBlock();
        Chunk chunk = block.getChunk();

        if (p.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && block.getType() == Material.EMERALD_ORE) {
            e.setCancelled(true);
            e.getBlock().setType(Material.BEDROCK);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (chunk.isLoaded()) {
                        chunk.load();
                    }

                    e.getBlock().setType(Material.EMERALD_ORE);
                    Location location1 = e.getBlock().getLocation();
                    e.getBlock().getWorld().playEffect(location1, Effect.MOBSPAWNER_FLAMES, 200);
                }
            }.runTaskLater(plugin, 200L);


            ItemStack handItem;
            int fortuneLevel;
            int amountToGive;
            if (p.getInventory().firstEmpty() == -1) {
                handItem = p.getEquipment().getItemInHand();
                fortuneLevel = handItem.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                amountToGive = 1;

                if (fortuneLevel > 0) {
                    for (int i = 0; i < fortuneLevel; i++) {
                        if (plugin.getRandom().nextBoolean()) {
                            amountToGive++;
                        }
                    }
                }

                is.setAmount(amountToGive);
                p.getWorld().dropItem(p.getLocation(), is);

                if (Config.getConfig().getBoolean("mining-messages")) {
                    p.sendMessage(CC.translate(plugin.getConfig().getString("darkzone-meteor-uranium")));
                    p.sendMessage(CC.translate(plugin.getConfig().getString("darkzone-meteor-scrap-full")));
                }

            }
            else {
                if (Config.getConfig().getBoolean("mining-messages")) {
                    p.sendMessage(CC.translate(plugin.getConfig().getString("darkzone-meteor-uranium")));
                }

                handItem = p.getEquipment().getItemInHand();
                fortuneLevel = handItem.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                amountToGive = 1;

                if (fortuneLevel > 0) {
                    for (int i = 0; i < fortuneLevel; i++) {
                        if (plugin.getRandom().nextBoolean()) {
                            ++amountToGive;
                        }
                    }
                }

                is.setAmount(amountToGive);
                inv.addItem(is);
            }

            String amountString = String.valueOf(amount);
            if (plugin.getConfig().getBoolean("darkzonegems.enabled")) {
                p.sendMessage(CC.translate(plugin.getConfig().getString("darkzonegems.message").replace("%amount%", amountString)));
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gems add " + p.getName() + " " + amountString);
            }
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBlockBreak3333(PlayerItemHeldEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && !p.getItemInHand().getType().toString().toLowerCase().contains("pickaxe") && p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
            p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
        }
    }

    @EventHandler
    public void onTeleport(PlayerChangedWorldEvent e) {
        Player p = e.getPlayer();
        if (p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
            p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void blockbreak2(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals(plugin.getConfig().getString("darkzone-world-name"))) {
            if (p.hasPermission("rival.darkzonebuild")) {
                return;
            }

            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onBlockBreak33(BlockDamageEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && p.getItemInHand().getType().toString().toLowerCase().contains("pickaxe")) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 360000, 36000));
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPortal(PlayerPortalEvent e) {
        if (e.getCause() == TeleportCause.END_PORTAL) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            World world = Bukkit.getWorld(Main.getInstance().getConfig().getString("darkzone-exit.world"));
            int x = Main.getInstance().getConfig().getInt("darkzone-exit.x");
            int y = Main.getInstance().getConfig().getInt("darkzone-exit.y");
            int z = Main.getInstance().getConfig().getInt("darkzone-exit.z");
            int yaw = Main.getInstance().getConfig().getInt("darkzone-exit.yaw");
            int pitch = Main.getInstance().getConfig().getInt("darkzone-exit.pitch");
            Location loc = new Location(world, x, y, z, (float) yaw, (float) pitch);
            if (p != null) {
                p.teleport(loc);

                for (String str : Main.getInstance().getConfig().getStringList("darkzone-leave")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
                }
            }
        }

    }

    public static ItemStack getMeteorite(int amount) {
        ItemStack out = new ItemStack(Material.INK_SACK);
        out.setDurability((short) 12);
        out.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        out.setAmount(amount);
        ItemMeta meta = out.getItemMeta();
        meta.setDisplayName(CC.translate(Config.getConfig().getString("darkzone-meteorite-name")));

        ArrayList<String> lore = new ArrayList<>();
        for (String lorestring : Config.getConfig().getStringList("darkzone-meteorite-lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', lorestring));
        }

        meta.setLore(lore);
        out.setItemMeta(meta);
        return out;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBlockBreak33333(PlayerItemHeldEvent e) {
        Player p = e.getPlayer();
        int slot = e.getNewSlot();
        if (p.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name"))) {
            if (p.getInventory().getItem(e.getNewSlot()) == null) {
                if (p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
                    p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                }

                return;
            }

            if (p.getInventory().getItem(slot).getType() == Material.AIR) {
                if (p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
                    p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                }

                return;
            }

            if (p.getInventory().getItem(slot).getType() != Material.DIAMOND_PICKAXE && p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
                p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
            }
        }

    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent e) {
        int min = plugin.getConfig().getInt("darkzonegems.min");
        int max = plugin.getConfig().getInt("darkzonegems.max");
        int randomInt = plugin.getRandom().nextInt(max - min) + min;
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();
        Block block = e.getBlock();
        Chunk chunk = block.getChunk();

        if (p.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && block.getType() == Material.DIAMOND_ORE) {
            e.setCancelled(true);
            e.getBlock().setType(Material.BEDROCK);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (!chunk.isLoaded()) {
                        chunk.load();
                    }

                    e.getBlock().setType(Material.DIAMOND_ORE);
                    Location loc = e.getBlock().getLocation();
                    e.getBlock().getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 200);
                }
            }.runTaskLater(plugin, 200L);

            ItemStack itemStack1;
            int enchantmentLevel;
            int amount;
            if (p.getInventory().firstEmpty() == -1) {
                itemStack1 = p.getEquipment().getItemInHand();
                enchantmentLevel = itemStack1.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                amount = 1;

                if (enchantmentLevel > 0) {
                    for (int i = 0; i < enchantmentLevel; ++i) {
                        if (plugin.getRandom().nextBoolean()) {
                            ++amount;
                        }
                    }
                }

                p.getWorld().dropItem(p.getLocation(), getMeteorite(amount));
                if (Config.getConfig().getBoolean("mining-messages")) {
                    p.sendMessage(CC.translate(plugin.getConfig().getString("darkzone-meteorite")));
                    p.sendMessage(CC.translate(plugin.getConfig().getString("darkzone-meteor-scrap-full")));
                }
            }
            else {
                itemStack1 = p.getEquipment().getItemInHand();
                enchantmentLevel = itemStack1.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                amount = 1;
                if (enchantmentLevel > 0) {
                    for (int i = 0; i < enchantmentLevel; ++i) {
                        if (plugin.getRandom().nextBoolean()) {
                            ++amount;
                        }
                    }
                }

                if (Config.getConfig().getBoolean("mining-messages")) {
                    p.sendMessage(CC.translate(plugin.getConfig().getString("darkzone-meteorite")));
                }

                inv.addItem(getMeteorite(amount));
            }

            String randomIntString = String.valueOf(randomInt);
            if (plugin.getConfig().getBoolean("darkzonegems.enabled")) {
                p.sendMessage(CC.translate(plugin.getConfig().getString("darkzonegems.message").replace("%amount%", randomIntString)));
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gems add " + p.getName() + " " + randomIntString);
            }
        }

    }

    @EventHandler
    public void blockb2(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals(plugin.getConfig().getString("darkzone-world-name"))) {
            if (p.hasPermission("rival.darkzonebuild")) {
                return;
            }

            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onBlockBreak3(BlockBreakEvent e) {
        ItemStack is = (new ItemBuilder(Material.NETHER_BRICK_ITEM)).enchant(Enchantment.DURABILITY, 10).displayName(CC.translate(plugin.getConfig().getString("darkzone-meteor-scrap-name"))).build();
        Player p = e.getPlayer();
        Block block = e.getBlock();
        if (p.getWorld().getName().equals(Config.getConfig().getString("darkzone-world-name")) && block.getType() == Material.QUARTZ_ORE) {
            e.setCancelled(true);
            e.getBlock().setType(Material.STONE);
            Location loc = e.getBlock().getLocation();
            e.getBlock().getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 3);
            ItemStack itemStack;
            int fortuneLevel;
            int someNumber;
            if (p.getInventory().firstEmpty() == -1) {
                itemStack = p.getEquipment().getItemInHand();
                fortuneLevel = itemStack.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                someNumber = 3;
                if (fortuneLevel > 0) {

                    for (int i = 0; i < fortuneLevel; ++i) {
                        if (plugin.getRandom().nextBoolean()) {
                            ++someNumber;
                        }
                    }
                }

                is.setAmount(someNumber);
                p.getWorld().dropItem(p.getLocation(), is);
                if (Config.getConfig().getBoolean("mining-messages")) {
                    p.sendMessage(CC.translate(plugin.getConfig().getString("darkzone-meteor-scrap")));
                    p.sendMessage(CC.translate(plugin.getConfig().getString("darkzone-meteor-scrap-full")));
                }
            }
            else {
                if (Config.getConfig().getBoolean("mining-messages")) {
                    p.sendMessage(CC.translate(plugin.getConfig().getString("darkzone-meteor-scrap")));
                }

                itemStack = p.getEquipment().getItemInHand();
                fortuneLevel = itemStack.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                someNumber = 3;
                if (fortuneLevel > 0) {
                    for (int i = 0; i < fortuneLevel; ++i) {
                        if (plugin.getRandom().nextBoolean()) {
                            ++someNumber;
                        }
                    }
                }

                is.setAmount(someNumber);
                p.getInventory().addItem(is);
            }
        }

    }
}
