package me.pulsi_.magicsticks.Security;

import me.pulsi_.magicsticks.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class DisableItemsDestroy implements Listener {

    @EventHandler
    public void noItemsDestroy(ExplosionPrimeEvent e) {
        if (!(Main.getInstance().getConfig().getBoolean("disable_explosion_destroy_items"))) return;
        if (!(e.getEntityType() == EntityType.FIREBALL)) return;
        e.setCancelled(true);
    }
}