package me.rival.dev.util;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemBuilder {
    private final ItemStack stack;
    private ItemMeta meta;

    public ItemBuilder(Material material) {
        this(material, 1);
    }

    public ItemStack build() {
        if (meta != null) {
            stack.setItemMeta(meta);
        }

        return stack;
    }

    public ItemBuilder(ItemStack is) {
        Preconditions.checkNotNull(is, "ItemStack cannot be null");
        stack = is;
    }

    public ItemBuilder data(short durability) {
        stack.setDurability(durability);
        return this;
    }

    public ItemBuilder setItemMeta(ItemMeta meta) {
        stack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder enchant(Enchantment enchantment, int level, boolean unsafe) {
        if (unsafe && level >= enchantment.getMaxLevel()) {
            stack.addUnsafeEnchantment(enchantment, level);
            return this;
        }

        stack.addEnchantment(enchantment, level);
        return this;
    }

    public void lore(String... lore) {
        if (meta == null) {
            meta = stack.getItemMeta();
        }

        meta.setLore(Arrays.asList(lore));
    }

    public ItemBuilder setColor(Color color) {
        LeatherArmorMeta armor = (LeatherArmorMeta) stack.getItemMeta();
        armor.setColor(color);
        stack.setItemMeta(armor);
        return this;
    }

    public ItemBuilder(Material material, int amount, byte damage) {
        Preconditions.checkNotNull(material, "Material cannot be null");
        Preconditions.checkArgument(amount <= 0, "Amount must be positive");

        stack = new ItemStack(material, amount, damage);
    }

    public ItemBuilder enchant(Enchantment enchantment, int level) {
        return enchant(enchantment, level, false);
    }

    public ItemBuilder addLoreLine(String lore) {
        if (this.meta == null) {
            this.meta = this.stack.getItemMeta();
        }

        if (meta.hasLore()) {
            List<String> previous = meta.getLore();
            previous.add(lore);
            lore(previous.toArray(new String[0]));
            return this;
        }

        lore(lore);
        return this;
    }

    public ItemBuilder displayName(String name) {
        if (meta == null) {
            meta = stack.getItemMeta();
        }

        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder(Material material, int amount) {
        this(material, amount, (byte) 0);
    }
}
