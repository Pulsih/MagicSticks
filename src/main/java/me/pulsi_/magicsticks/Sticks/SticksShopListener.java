package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.MessageManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SticksShopListener implements Listener {

    ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");
    ConfigManager shopSticks = new ConfigManager(Main.getInstance(), "shop.yml");

    Economy econ = Main.getEconomy();

    @EventHandler
    public void ClickItem(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(Translator.Colors(shopSticks.getConfig().getString("Shop.title")))) {
            if (e.getCurrentItem() != null) {
                Player p = (Player) e.getWhoClicked();
                e.setCancelled(true);

                MessageManager message = new MessageManager(p);

                if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.fireballstick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.fireballstick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.fireballstick.price"));
                            message.buyFireballStick();
                            p.getInventory().addItem(Sticks.fireballstick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.witherstick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.witherstick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.witherstick.price"));
                            message.buyWitherStick();
                            p.getInventory().addItem(Sticks.witherstick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.icestick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.icestick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.icestick.price"));
                            message.buyIceStick();
                            p.getInventory().addItem(Sticks.icestick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.electricstick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.electricstick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.electricstick.price"));
                            message.buyElectricStick();
                            p.getInventory().addItem(Sticks.electricstick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            message.noMoney();
                        }
                    } else {
                        message.invFull();
                    }

                } else if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.bridgestick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.bridgestick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.bridgestick.price"));
                            message.buyBridgeStick();
                            p.getInventory().addItem(Sticks.bridgestick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
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