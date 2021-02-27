package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.MagicSticks;
import me.pulsi_.magicsticks.Managers.MessageManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SticksShopListener implements Listener {

    Economy econ = MagicSticks.getEconomy();

    @EventHandler
    public void ClickItem(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(Translator.Colors("&9&lSticks &a&lShop"))) {
            if (event.getCurrentItem() != null) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);

                MessageManager message = new MessageManager(player);

                if (event.getSlot() == 11) {
                    if (player.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(player) >= 500) {
                            econ.withdrawPlayer(player, 500);
                            message.buyFireballStick();
                            player.getInventory().addItem(Sticks.getFireBallStick());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (event.getSlot() == 12) {
                    if (player.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(player) >= 650) {
                            econ.withdrawPlayer(player, 650);
                            message.buyWitherStick();
                            player.getInventory().addItem(Sticks.getWitherStick());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (event.getSlot() == 13) {
                    if (player.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(player) >= 500) {
                            econ.withdrawPlayer(player, 500);
                            message.buyIceStick();
                            player.getInventory().addItem(Sticks.getIceStick());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (event.getSlot() == 14) {
                    if (player.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(player) >= 750) {
                            econ.withdrawPlayer(player, 750);
                            message.buyElectricStick();
                            player.getInventory().addItem(Sticks.getElectricStick());
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (event.getSlot() == 15) {
                    if (player.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(player) >= 750) {
                            econ.withdrawPlayer(player, 750);
                            message.buyBridgeStick();
                            player.getInventory().addItem(Sticks.getBridgeStick());
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