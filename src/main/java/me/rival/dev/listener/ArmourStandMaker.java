package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

public class ArmourStandMaker {
   private ArmorStand as;

   public ArmourStandMaker(Location loc, Material material, boolean visible, boolean small, boolean gravity, String someData) {
      as = loc.getWorld().spawn(loc, ArmorStand.class);
      as.setBasePlate(false);
      as.setArms(true);
      as.setVisible(visible);
      as.setCanPickupItems(false);
      as.setGravity(gravity);
      as.setSmall(small);
      as.setHelmet(new ItemStack(material));
      if (someData != null) {
         as.setMetadata(someData, new FixedMetadataValue(Main.getInstance(), true));
      }

   }

   public void setVelocity(Vector v) {
      as.setVelocity(v);
   }

   public void delete() {
      as.remove();
   }

   public Location getLocation() {
      return as.getLocation();
   }
}
