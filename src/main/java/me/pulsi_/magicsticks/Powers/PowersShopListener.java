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
import org.bukkit.inventory.ItemStack;

public class PowersShopListener implements Listener {

    ConfigManager shopPowers = new ConfigManager(Main.getInstance(), "powers.yml");
    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    Economy econ = Main.getEconomy();

    public void buy(double money, int price, Player p, ItemStack powersItems) {
        if (money >= price) {
            if (p.getInventory().firstEmpty() >= 0) {
                econ.withdrawPlayer(p, price);

                p.getLocation().getWorld().dropItem(p.getLocation(), powersItems).setPickupDelay(0);
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 1);
            } else {
                p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message"))
                        .replace("%prefix%", "" + messages.getConfig().getString("prefix")));
            }
        } else {
            p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message"))
                    .replace("%prefix%", "" + messages.getConfig().getString("prefix")));
        }
    }

    @EventHandler
    public void selectPower(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(Translator.Colors(shopPowers.getConfig().getString("PowersShop.title")))) {
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);

                if (e.getSlot() == shopPowers.getConfig().getInt("PowersShop.strikerItem.position")) {
                    buy(econ.getBalance(p), 40000, p, PowersItems.strikerItem());
                    p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message"))
                            .replace("%item%", "" + e.getCurrentItem().getItemMeta().getDisplayName())
                            .replace("%prefix%", messages.getConfig().getString("prefix")));

                } else if (e.getSlot() == shopPowers.getConfig().getInt("PowersShop.tankItem.position")) {
                    buy(econ.getBalance(p), 40000, p, PowersItems.tankItem());
                    p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message"))
                            .replace("%item%", "" + e.getCurrentItem().getItemMeta().getDisplayName())
                            .replace("%prefix%", messages.getConfig().getString("prefix")));

                } else if (e.getSlot() == shopPowers.getConfig().getInt("PowersShop.furtivityItem.position")) {
                    buy(econ.getBalance(p), 40000, p, PowersItems.furtivityItem());
                    p.sendMessage(Translator.Colors(messages.getConfig().getString("success_buy_message"))
                            .replace("%item%", "" + e.getCurrentItem().getItemMeta().getDisplayName())
                            .replace("%prefix%", messages.getConfig().getString("prefix")));
                }
            }
        }
    }
}