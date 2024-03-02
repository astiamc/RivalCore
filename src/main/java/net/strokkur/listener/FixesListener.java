package net.strokkur.listener;

import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTeleportEvent;

import java.util.List;

public class FixesListener implements Listener {
    private final List<DamageCause> damage = List.of(DamageCause.LAVA, DamageCause.FIRE, DamageCause.FIRE_TICK, DamageCause.BLOCK_EXPLOSION, DamageCause.ENTITY_EXPLOSION);

    @EventHandler
    public void onCreeperAntiGlitch(EntityDamageEvent e) {
        if (e.getEntity().getType().equals(EntityType.CREEPER) && (e.getCause().equals(DamageCause.DROWNING) || e.getCause().equals(DamageCause.SUFFOCATION))) {
            e.getEntity().remove();
        }
    }

    @EventHandler
    public void onExplosionDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player && isExplosion(e.getCause())) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEndermanTeleport(EntityTeleportEvent e) {
        EntityType type = e.getEntityType();
        if (type.equals(EntityType.ENDERMAN)) {
            e.setCancelled(true);
        }
    }

    private boolean damageCause(DamageCause e) {
        return damage.contains(e);
    }

    private boolean isExplosion(DamageCause e) {
        return e.equals(DamageCause.ENTITY_EXPLOSION) || e.equals(DamageCause.BLOCK_EXPLOSION);
    }

    @EventHandler
    public void onWitherSpawn(EntitySpawnEvent e) {
        if (!e.isCancelled()) {
            EntityType type = e.getEntityType();
            if (type.toString().toUpperCase().contains("WITHER")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void antiItemBurn(EntityDamageEvent e) {
        if (!e.isCancelled() && e.getEntity() instanceof Item && damageCause(e.getCause())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlazeWaterDamage(EntityDamageEvent e) {
        if (!e.isCancelled()) {
            if (e.getEntity() instanceof Blaze && e.getCause().equals(DamageCause.DROWNING)) {
                e.setCancelled(true);
            }
        }
    }
}
