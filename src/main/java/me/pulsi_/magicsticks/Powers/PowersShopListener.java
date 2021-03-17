package me.pulsi_.magicsticks.Powers;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PowersShopListener implements Listener {

    ConfigManager configSticks = new ConfigManager(Main.getInstance(), "powers.yml");
    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    Economy econ = Main.getEconomy();

    @EventHandler
    public void SelectPower(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(Translator.Colors("&4&lPowers &a&lSelector"))) {
            if (event.getCurrentItem() != null) {
                Player p = (Player) event.getWhoClicked();
                event.setCancelled(true);

                if (event.getSlot() == 10) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= 45000) {
                            econ.withdrawPlayer(p, 45000);
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message"))
                            .replace("%item%", ""+configSticks.getConfig().getString("Powers.Striker.name"))
                            .replace("%prefix%" , messages.getConfig().getString("prefix")));
                            p.getLocation().getWorld().dropItem(p.getLocation(), PowersItems.strikerItem()).setPickupDelay(0);
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message"))
                                    .replace("%prefix%", ""+messages.getConfig().getString("prefix")));
                        }
                    } else {
                        p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message"))
                                .replace("%prefix%", ""+messages.getConfig().getString("prefix")));
                    }

                } else if (event.getSlot() == 12) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= 45000) {
                            econ.withdrawPlayer(p, 45000);
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message"))
                                    .replace("%item%", ""+configSticks.getConfig().getString("Powers.Tank.name"))
                                    .replace("%prefix%" , messages.getConfig().getString("prefix")));
                            p.getInventory().addItem(PowersItems.tankItem());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message"))
                                    .replace("%prefix%", ""+messages.getConfig().getString("prefix")));
                        }
                    } else {
                        p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message"))
                                .replace("%prefix%", ""+messages.getConfig().getString("prefix")));
                    }

                } else if (event.getSlot() == 14) {
                    if (p.getInventory().firstEmpty() >= 0) {
                        if (econ.getBalance(p) >= 30000) {
                            econ.withdrawPlayer(p, 30000);
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message"))
                                    .replace("%item%", ""+configSticks.getConfig().getString("Powers.Furtivity.name"))
                                    .replace("%prefix%" , messages.getConfig().getString("prefix")));
                            p.getInventory().addItem(PowersItems.furtivityItem());
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
                        } else {
                            p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message"))
                                    .replace("%prefix%", ""+messages.getConfig().getString("prefix")));
                        }
                    } else {
                        p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message"))
                                .replace("%prefix%", ""+messages.getConfig().getString("prefix")));
                    }
                }
            }
        }
    }
}