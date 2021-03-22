package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SticksShop {

    ConfigManager configShop = new ConfigManager(Main.getInstance(), "shop.yml");
    ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

    Economy econ = Main.getEconomy();

    final Player p;

    public SticksShop(Player p) {
        this.p = p;
    }

    public void openShop() {

        Inventory shop = Bukkit.createInventory(null, 27, (Translator.Colors(configShop.getConfig().getString("Shop.title"))));

        ConfigurationSection c = configShop.getConfig().getConfigurationSection("Shop.items");
        ConfigurationSection s = configSticks.getConfig().getConfigurationSection("Sticks");

        for (String string : c.getKeys(false)) {
            shop.setItem(c.getConfigurationSection(string).getInt("slot"), ItemCreators.createItemStack(s.getConfigurationSection(string)));
        }

        p.openInventory(shop);
    }
}