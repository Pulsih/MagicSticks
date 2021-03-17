package me.pulsi_.magicsticks.Powers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PowersPickup implements Listener {

    @EventHandler
    public void striker(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (!(e.getItem().getItemStack().isSimilar(PowersItems.strikerItem()))) return;
        if (!(e.getPlayer().getInventory().containsAtLeast(PowersItems.strikerItem(), 1))) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
        } else {
            if (e.getItem().getItemStack().getItemMeta().getDisplayName().equals(PowersItems.strikerItem())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void tank(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (!(e.getItem().getItemStack().isSimilar(PowersItems.tankItem()))) return;
        if (!(e.getPlayer().getInventory().containsAtLeast(PowersItems.tankItem(), 1))) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999999, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 0));
        } else {
            if (e.getItem().getItemStack().equals(PowersItems.tankItem())) {
                e.setCancelled(true);
            }
        }
    }
}