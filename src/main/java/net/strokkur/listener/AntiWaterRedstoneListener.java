package net.strokkur.listener;

import net.strokkur.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import java.util.List;

public class AntiWaterRedstoneListener implements Listener {
    private final Main plugin = Main.getInstance();

    @EventHandler
    public void onWaterMove(BlockFromToEvent e) {
        List<String> stringList = plugin.getConfig().getStringList("AntiWater-Break");
        String brokenType = e.getToBlock().getType().toString();
        if (stringList.contains(brokenType)) {
            e.setCancelled(true);
        }
    }
}
