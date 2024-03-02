package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

public class ArmourStandMaker {
   // $FF: synthetic field
   private ArmorStand as;
   // $FF: synthetic field
   private static final int[] llll;

   public ArmourStandMaker(Location lllllllIIIIIlIl, Material lllllllIIIlIIIl, boolean lllllllIIIlIIII, boolean lllllllIIIIIIIl, boolean lllllllIIIIIIII, String llllllIllllllll) {
      lllllllIIIlIIll.as = (ArmorStand)lllllllIIIIIlIl.getWorld().spawn(lllllllIIIIIlIl, ArmorStand.class);
      lllllllIIIlIIll.as.setBasePlate((boolean)llll[0]);
      lllllllIIIlIIll.as.setArms((boolean)llll[1]);
      lllllllIIIlIIll.as.setVisible(lllllllIIIlIIII);
      lllllllIIIlIIll.as.setCanPickupItems((boolean)llll[0]);
      lllllllIIIlIIll.as.setGravity(lllllllIIIIIIII);
      lllllllIIIlIIll.as.setSmall(lllllllIIIIIIIl);
      lllllllIIIlIIll.as.setHelmet(new ItemStack(lllllllIIIlIIIl));
      if (llllllIllllllll != null) {
         lllllllIIIlIIll.as.setMetadata(llllllIllllllll, new FixedMetadataValue(Main.getInstance(), Boolean.valueOf((boolean)llll[1])));
      }

   }

   static {
      lIll();
   }

   private static void lIll() {
      llll = new int[2];
      llll[0] = (93 ^ 24 ^ 44 ^ 69) & (134 + 137 - 149 + 35 ^ 139 + 151 - 237 + 124 ^ -" ".length());
      llll[1] = " ".length();
   }

   public void setVelocity(Vector llllllIlllllIll) {
      llllllIlllllIlI.as.setVelocity(llllllIlllllIll);
   }

   public void delete() {
      llllllIllllIlII.as.remove();
   }

   public Location getLocation() {
      return llllllIlllIllIl.as.getLocation();
   }
}
