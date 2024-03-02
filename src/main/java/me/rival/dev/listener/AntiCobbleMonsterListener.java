package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class AntiCobbleMonsterListener implements Listener {
   // $FF: synthetic field
   Main plugin;
   // $FF: synthetic field
   private final BlockFace[] faces;
   // $FF: synthetic field
   private static final int[] l;

   private static void l() {
      l = new int[12];
      l[0] = 138 ^ 141;
      l[1] = (48 ^ 80) & ~(47 ^ 79);
      l[2] = " ".length();
      l[3] = "  ".length();
      l[4] = "   ".length();
      l[5] = 172 ^ 168;
      l[6] = 195 ^ 139 ^ 84 ^ 25;
      l[7] = 5 ^ 3;
      l[8] = 158 + 162 - 256 + 107 ^ 144 + 123 - 221 + 117;
      l[9] = 77 ^ 6 ^ 54 ^ 116;
      l[10] = 40 ^ 34;
      l[11] = 165 ^ 174;
   }

   static {
      l();
   }

   public AntiCobbleMonsterListener(Main lllllllllIIlIll) {
      lllllllllIIllII.plugin = lllllllllIIlIll;
      BlockFace[] var10001 = new BlockFace[l[0]];
      var10001[l[1]] = BlockFace.SELF;
      var10001[l[2]] = BlockFace.UP;
      var10001[l[3]] = BlockFace.DOWN;
      var10001[l[4]] = BlockFace.NORTH;
      var10001[l[5]] = BlockFace.EAST;
      var10001[l[6]] = BlockFace.SOUTH;
      var10001[l[7]] = BlockFace.WEST;
      lllllllllIIllII.faces = var10001;
   }

   @EventHandler
   public void onFromTo(BlockFromToEvent lllllllllIIIIIl) {
      int lllllllllIIIlII = lllllllllIIIIIl.getBlock().getTypeId();
      Block lllllllllIIIIll = lllllllllIIIIIl.getToBlock();
      if (lllllllllIIIIlI.generatesCobble(lllllllllIIIlII, lllllllllIIIIll)) {
         lllllllllIIIIIl.setCancelled((boolean)l[2]);
      }

   }

   public boolean generatesCobble(int llllllllIlIllII, Block llllllllIllIIlI) {
      int var10000;
      if (llllllllIlIllII != l[8] && llllllllIlIllII != l[9]) {
         var10000 = l[8];
      } else {
         var10000 = l[10];
         "".length();
         if ("   ".length() >= (58 ^ 16 ^ 168 ^ 134)) {
            return (boolean)((210 ^ 161 ^ 109 ^ 10) & (138 + 41 - 92 + 127 ^ 25 + 126 - 147 + 190 ^ -" ".length()));
         }
      }

      int llllllllIllIIIl = var10000;
      if (llllllllIlIllII != l[8] && llllllllIlIllII != l[9]) {
         var10000 = l[9];
      } else {
         var10000 = l[11];
         "".length();
         if (null != null) {
            return (boolean)((66 ^ 92) & ~(65 ^ 95));
         }
      }

      int llllllllIllIIII = var10000;
      BlockFace[] llllllllIlIIlIl;
      float llllllllIlIIllI = (llllllllIlIIlIl = llllllllIlIllIl.faces).length;
      Exception llllllllIlIIlll = l[1];
      "".length();
      if (" ".length() <= 0) {
         return (boolean)((56 + 48 - -24 + 28 ^ 112 + 158 - 184 + 96) & (4 ^ 3 ^ 157 ^ 176 ^ -" ".length()));
      } else {
         while(llllllllIlIIlll < llllllllIlIIllI) {
            BlockFace llllllllIlIllll = llllllllIlIIlIl[llllllllIlIIlll];
            Block llllllllIlIlllI = llllllllIllIIlI.getRelative(llllllllIlIllll, l[2]);
            if (llllllllIlIlllI.getTypeId() == llllllllIllIIIl || llllllllIlIlllI.getTypeId() == llllllllIllIIII) {
               return (boolean)l[2];
            }

            ++llllllllIlIIlll;
         }

         return (boolean)l[1];
      }
   }
}
