package me.pulsi_.magicsticks.Powers;

import me.pulsi_.magicsticks.Sticks.Sticks;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PowersInTheInventory implements Listener {

    @SuppressWarnings("deprecated")
    @EventHandler
    public void onInventory(PlayerItemHeldEvent e) {
        Player player = (Player) e.getPlayer();
        if (player.getInventory().containsAtLeast(PowersItems.getStrikerPower(), 1)) {
            player.sendMessage("its working, you have the StrikerPower in the inventory!");
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 50, 0));
            player.setMaxHealth(16.0);
        }
    }
    @EventHandler
    public static void IncreaseDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Fireball) {

            Fireball f = (Fireball) event.getDamager();
            if (f.getShooter() instanceof Player) {
                Player shooter = (Player) event.getDamager();
                String displayName = shooter.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                if (displayName.equalsIgnoreCase(Sticks.fireballstick().getItemMeta().getDisplayName())) {
                    event.setDamage(9.0);
                }
            }
        }
    }
}
