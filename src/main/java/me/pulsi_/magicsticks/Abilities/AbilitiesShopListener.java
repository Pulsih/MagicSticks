package me.pulsi_.magicsticks.Abilities;

import me.pulsi_.magicsticks.Managers.Translator;
import me.pulsi_.magicsticks.Sticks.Sticks;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AbilitiesShopListener implements Listener {

    @EventHandler
    public void ClickItem(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(Translator.Colors("&5&lAbilities &a&lShop"))) {
            if (event.getCurrentItem() != null) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);

                if (event.getSlot() == 11) {
                    player.sendMessage(Translator.Colors("&5&lSUCCESS! &aYou increased the &d&lRESISTANCE &aAbility by &21&a!"));
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                } else if (event.getSlot() == 12) {
                    player.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou bought a &8&lWither &3&lStick&a!"));
                    player.getInventory().addItem(Sticks.witherstick());
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                } else if (event.getSlot() == 13) {
                    player.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou bought a &9&lIce &3&lStick&a!"));
                    player.getInventory().addItem(Sticks.electricstick());
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                } else if (event.getSlot() == 14) {
                    player.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou bought a &b&lE&3&ll&b&le&3&lc&b&lt&3&lr&b&li&3&lc &7&lStick&a!"));
                    player.getInventory().addItem(Sticks.icestick());
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                } else {
                    player.sendMessage(Translator.Colors("&cl(!) ERROR! &7You don't have enough money!"));
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, 2, 1);

                }
            }
        }
    }
}
