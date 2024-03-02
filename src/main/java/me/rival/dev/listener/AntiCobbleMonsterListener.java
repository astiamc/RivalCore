package me.rival.dev.listener;

import me.rival.dev.Main;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.junit.Ignore;

public class AntiCobbleMonsterListener implements Listener {
    private final Main plugin = Main.getInstance();
    private final BlockFace[] faces = new BlockFace[]{BlockFace.SELF, BlockFace.UP, BlockFace.DOWN, BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};


    @EventHandler
    public void onFromTo(BlockFromToEvent e) {
        int id = e.getBlock().getTypeId();
        Block block = e.getToBlock();
        if (generatesCobble(id, block)) {
            e.setCancelled(true);
        }

    }

    public boolean generatesCobble(int id, Block block) {
        int out;
        if (id != 8 && id != 9) {
            out = 8;
        }
        else {
            out = 10;
        }

        int out2 = out;
        if (id != 8 && id != 9) {
            out = 9;
        }
        else {
            out = 11;
        }

        int out3 = out;
        float amount = faces.length;
        int i = 0;
        while (i < amount) {
            BlockFace face = faces[i];
            Block b = block.getRelative(face, 1);
            if (b.getTypeId() == out2 || b.getTypeId() == out3) {
                return true;
            }

            ++i;
        }

        return false;
    }
}
