package me.rival.dev.listener;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemBuilder {
   // $FF: synthetic field
   private ItemStack stack;
   // $FF: synthetic field
   private static final int[] lIIlII;
   // $FF: synthetic field
   private ItemMeta meta;

   public ItemBuilder(Material llllIlllIlllIIl) {
      this(llllIlllIlllIIl, lIIlII[0]);
   }

   static {
      llllI();
   }

   public ItemStack build() {
      if (llllIllIlIllIIl.meta != null) {
         llllIllIlIllIIl.stack.setItemMeta(llllIllIlIllIIl.meta);
         "".length();
      }

      return llllIllIlIllIIl.stack;
   }

   public ItemBuilder(ItemStack llllIlllIlIllII) {
      Preconditions.checkNotNull(llllIlllIlIllII, "ItemStack cannot be null");
      "".length();
      llllIlllIlIlIll.stack = llllIlllIlIllII;
   }

   public ItemBuilder data(short llllIllIlIlllII) {
      llllIllIlIlllll.stack.setDurability(llllIllIlIlllII);
      return llllIllIlIlllll;
   }

   public ItemBuilder setItemMeta(ItemMeta llllIlllIIIlIll) {
      llllIlllIIIllII.stack.setItemMeta(llllIlllIIIlIll);
      "".length();
      return llllIlllIIIllII;
   }

   public ItemBuilder enchant(Enchantment llllIllIllIIlII, int llllIllIllIIIll, boolean llllIllIllIIIlI) {
      if (llllIllIllIIIlI && llllIllIllIIIll >= llllIllIllIIlII.getMaxLevel()) {
         llllIllIllIIlIl.stack.addUnsafeEnchantment(llllIllIllIIlII, llllIllIllIIIll);
         "".length();
         if ("  ".length() < " ".length()) {
            return null;
         }
      } else {
         llllIllIllIIlIl.stack.addEnchantment(llllIllIllIIlII, llllIllIllIIIll);
      }

      return llllIllIllIIlIl;
   }

   public ItemBuilder lore(String... llllIllIlllIlll) {
      if (llllIllIllllIII.meta == null) {
         llllIllIllllIII.meta = llllIllIllllIII.stack.getItemMeta();
      }

      llllIllIllllIII.meta.setLore(Arrays.asList(llllIllIlllIlll));
      return llllIllIllllIII;
   }

   public ItemBuilder setColor(Color llllIlllIIlIIII) {
      char llllIlllIIIllll = (LeatherArmorMeta)llllIlllIIlIlII.stack.getItemMeta();
      llllIlllIIIllll.setColor(llllIlllIIlIIII);
      llllIlllIIlIlII.setItemMeta(llllIlllIIIllll);
      "".length();
      return llllIlllIIlIlII;
   }

   public ItemBuilder(Material llllIlllIlIIlII, int llllIlllIIlllll, byte llllIlllIIllllI) {
      Preconditions.checkNotNull(llllIlllIlIIlII, "Material cannot be null");
      "".length();
      int var10000;
      if (llllIlllIIlllll > 0) {
         var10000 = lIIlII[0];
         "".length();
         if ("  ".length() >= "   ".length()) {
            throw null;
         }
      } else {
         var10000 = lIIlII[1];
      }

      Preconditions.checkArgument((boolean)var10000, "Amount must be positive");
      llllIlllIlIIIIl.stack = new ItemStack(llllIlllIlIIlII, llllIlllIIlllll, (short)llllIlllIIllllI);
   }

   public ItemBuilder enchant(Enchantment llllIllIlllIIlI, int llllIllIlllIIIl) {
      return llllIllIlllIIII.enchant(llllIllIlllIIlI, llllIllIlllIIIl, (boolean)lIIlII[0]);
   }

   public ItemBuilder loreLine(String llllIlllIIIIIll) {
      if (llllIlllIIIIlII.meta == null) {
         llllIlllIIIIlII.meta = llllIlllIIIIlII.stack.getItemMeta();
      }

      short llllIllIllllllI = llllIlllIIIIlII.meta.hasLore();
      Object var10000;
      if (llllIllIllllllI) {
         var10000 = llllIlllIIIIlII.meta.getLore();
         "".length();
         if ("   ".length() < -" ".length()) {
            return null;
         }
      } else {
         var10000 = new ArrayList();
      }

      List<String> llllIllIlllllIl = var10000;
      int var10001;
      if (llllIllIllllllI) {
         var10001 = ((List)llllIllIlllllIl).size();
         "".length();
         if (null != null) {
            return null;
         }
      } else {
         var10001 = lIIlII[1];
      }

      ((List)llllIllIlllllIl).add(var10001, llllIlllIIIIIll);
      String[] var4 = new String[lIIlII[0]];
      var4[lIIlII[1]] = llllIlllIIIIIll;
      llllIlllIIIIlII.lore(var4);
      "".length();
      return llllIlllIIIIlII;
   }

   public ItemBuilder displayName(String llllIlllIIllIlI) {
      if (llllIlllIIllIll.meta == null) {
         llllIlllIIllIll.meta = llllIlllIIllIll.stack.getItemMeta();
      }

      llllIlllIIllIll.meta.setDisplayName(llllIlllIIllIlI);
      return llllIlllIIllIll;
   }

   private static void llllI() {
      lIIlII = new int[2];
      lIIlII[0] = " ".length();
      lIIlII[1] = (103 ^ 16 ^ 172 ^ 185) & (155 + 234 - 328 + 191 ^ 12 + 89 - -51 + 6 ^ -" ".length());
   }

   public ItemBuilder(Material llllIlllIllIIIl, int llllIlllIllIIll) {
      this(llllIlllIllIIIl, llllIlllIllIIll, (byte)lIIlII[1]);
   }
}
