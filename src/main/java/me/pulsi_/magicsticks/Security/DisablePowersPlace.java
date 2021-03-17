package me.pulsi_.magicsticks.Security;

import me.pulsi_.magicsticks.Powers.PowersItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class DisablePowersPlace implements Listener {

    @EventHandler
    public void noPowerPlace(BlockPlaceEvent e) {
        ItemStack item = e.getItemInHand();
        if (item.isSimilar(PowersItems.strikerItem()) ||
                item.isSimilar(PowersItems.tankItem()) ||
                item.isSimilar(PowersItems.furtivityItem())) {
            e.setCancelled(true);
        }
    }
}