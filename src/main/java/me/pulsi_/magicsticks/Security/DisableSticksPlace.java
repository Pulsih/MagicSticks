package me.pulsi_.magicsticks.Security;

import me.pulsi_.magicsticks.Sticks.Sticks;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class DisableSticksPlace implements Listener {

    @EventHandler
    public void noPowerPlace(BlockPlaceEvent e) {
        ItemStack item = e.getItemInHand();
        if (!(item.isSimilar(Sticks.fireballstick()) ||
                item.isSimilar(Sticks.witherstick()) ||
                item.isSimilar(Sticks.icestick()) ||
                item.isSimilar(Sticks.electricstick()) ||
                item.isSimilar(Sticks.bridgestick()))) return;

        e.setCancelled(true);
    }
}