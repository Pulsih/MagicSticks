package me.pulsi_.magicsticks.KillsEvent;

import me.pulsi_.magicsticks.Drops.PlayerDrops;
import me.pulsi_.magicsticks.Sticks.Sticks;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Players implements Listener {

    @EventHandler
    public void playerDeath(PlayerDeathEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (!(e.getEntity().getKiller() instanceof Player)) return;
        if (!(e.getEntity().getKiller().getInventory().getItemInHand().hasItemMeta())) return;
        if (!(e.getEntity().getKiller().getInventory().getItemInMainHand().isSimilar(Sticks.fireballstick()) ||
                e.getEntity().getKiller().getInventory().getItemInMainHand().isSimilar(Sticks.witherstick()) ||
                e.getEntity().getKiller().getInventory().getItemInMainHand().isSimilar(Sticks.icestick()) ||
                e.getEntity().getKiller().getInventory().getItemInMainHand().isSimilar(Sticks.electricstick()))) return;

        e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), PlayerDrops.playerDrops());
    }
}