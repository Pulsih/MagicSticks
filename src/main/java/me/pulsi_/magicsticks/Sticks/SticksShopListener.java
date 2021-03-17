package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
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
    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    Economy econ = Main.getEconomy();

    @EventHandler
    public void ClickItem(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(Translator.Colors(shopSticks.getConfig().getString("Shop.title")))) {
            if (e.getCurrentItem() != null) {
                Player p = (Player) e.getWhoClicked();
                e.setCancelled(true);

                if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.fireballstick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.fireballstick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.fireballstick.price"));
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message")
                                    .replace("%item%", ""+configSticks.getConfig().getString("Sticks.fireballstick.name")
                                    .replace("%prefix%" , messages.getConfig().getString("prefix")))));
                            p.getInventory().addItem(Sticks.fireballstick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message")
                                    .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                        }
                    } else {
                        p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message")
                                .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                    }

                } else if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.witherstick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.witherstick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.witherstick.price"));
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message")
                                    .replace("%item%", ""+configSticks.getConfig().getString("Sticks.witherstick.name")
                                    .replace("%prefix%" , messages.getConfig().getString("prefix")))));
                            p.getInventory().addItem(Sticks.witherstick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message")
                                    .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                        }
                    } else {
                        p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message")
                                .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                    }

                } else if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.icestick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.icestick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.icestick.price"));
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message")
                                    .replace("%item%", ""+ configSticks.getConfig().getString("Sticks.icestick.name")
                                    .replace("%prefix%" , messages.getConfig().getString("prefix")))));
                            p.getInventory().addItem(Sticks.icestick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message")
                                    .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                        }
                    } else {
                        p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message")
                                .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                    }

                } else if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.electricstick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.electricstick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.electricstick.price"));
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message")
                                    .replace("%item%", ""+ configSticks.getConfig().getString("Sticks.electricstick.name")
                                    .replace("%prefix%" , messages.getConfig().getString("prefix")))));
                            p.getInventory().addItem(Sticks.electricstick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message")
                                    .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                        }
                    } else {
                        p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message")
                                .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                    }

                } else if (e.getSlot() == shopSticks.getConfig().getInt("Shop.items.bridgestick.position")) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= shopSticks.getConfig().getInt("Shop.items.bridgestick.price")) {
                            econ.withdrawPlayer(p, shopSticks.getConfig().getInt("Shop.items.bridgestick.price"));
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message")
                                    .replace("%item%", ""+ configSticks.getConfig().getString("Sticks.bridgestick.name")
                                    .replace("%prefix%" , messages.getConfig().getString("prefix")))));
                            p.getInventory().addItem(Sticks.bridgestick());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message")
                                    .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                        }
                    } else {
                        p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message")
                                .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
                    }
                }
            }
        }
    }
}