package me.pulsi_.magicsticks.Powers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.potion.PotionEffectType;

public class PowersDrop implements Listener {

    @EventHandler
    public void striker(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (!(e.getItemDrop().getItemStack().isSimilar(PowersItems.strikerItem()))) return;
        if (!(e.getPlayer().getInventory().containsAtLeast(PowersItems.strikerItem(), 1))) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        }
    }

    @EventHandler
    public void tank(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (!(e.getItemDrop().getItemStack().isSimilar(PowersItems.tankItem()))) return;
        if (!(e.getPlayer().getInventory().containsAtLeast(PowersItems.tankItem(), 1))) {
            p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            p.removePotionEffect(PotionEffectType.SLOW);
        }
    }
}