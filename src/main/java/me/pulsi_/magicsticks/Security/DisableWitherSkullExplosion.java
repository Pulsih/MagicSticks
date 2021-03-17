package me.pulsi_.magicsticks.Security;

import me.pulsi_.magicsticks.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class DisableWitherSkullExplosion implements Listener {

    @EventHandler
    public void noSkullExplosion(EntityExplodeEvent e) {
        if (!(Main.getInstance().getConfig().getBoolean("disable_witherskull_explosion"))) return;
        if (!(e.getEntityType() == EntityType.WITHER_SKULL)) return;
        e.setCancelled(true);
    }
}