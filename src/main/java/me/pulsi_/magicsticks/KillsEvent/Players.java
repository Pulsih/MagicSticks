package me.pulsi_.magicsticks.KillsEvent;

import me.pulsi_.magicsticks.Sticks.Sticks;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

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

        //---------------------------------------------------
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        headMeta.setOwningPlayer(e.getEntity().getKiller());
        //---------------------------------------------------

        e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), head);
    }
}