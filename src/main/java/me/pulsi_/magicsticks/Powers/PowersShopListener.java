package me.pulsi_.magicsticks.Powers;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.MessageManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PowersShopListener implements Listener {

    Economy econ = Main.getEconomy();

    @EventHandler
    public void SelectPower(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(Translator.Colors("&4&lPowers &a&lSelector"))) {
            if (event.getCurrentItem() != null) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);

                MessageManager message = new MessageManager(player);

                if (event.getSlot() == 10) {
                    if (player.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(player) >= 45000) {
                            econ.withdrawPlayer(player, 45000);
                            message.strikerBuyMessage();
                            player.getInventory().addItem(PowersItems.getStrikerPower());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (event.getSlot() == 12) {
                    if (player.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(player) >= 45000) {
                            econ.withdrawPlayer(player, 45000);
                            message.tankBuyMessage();
                            player.getInventory().addItem(PowersItems.getTankPower());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (event.getSlot() == 14) {
                    if (player.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(player) >= 30000) {
                            econ.withdrawPlayer(player, 30000);
                            message.furtivityBuyMessage();
                            player.getInventory().addItem(PowersItems.getFurtivityPower());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }
                }
            }
        }
    }
}
