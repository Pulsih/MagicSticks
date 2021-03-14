package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SticksShop {

    ConfigManager configShop = new ConfigManager(Main.getInstance(), "shop.yml");
    ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

    Economy econ = Main.getEconomy();

    final Player p;

    public SticksShop(Player p){
        this.p = p;
    }

    public void openShop(){

        Inventory shop = Bukkit.createInventory(null, 27, (Translator.Colors(configShop.getConfig().getString("Shop.title"))));

        ItemStack fireballstick = Sticks.fireballstick();
        ItemStack witherstick = Sticks.witherstick();
        ItemStack icestick = Sticks.icestick();
        ItemStack electricstick = Sticks.electricstick();
        ItemStack bridgestick = Sticks.bridgestick();
        ItemStack getEconomy = new ItemStack(Material.GOLD_INGOT);
        ItemStack nullSlots = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);

        //-------------------------------------------------------------------------------------
        //Balance

        ItemMeta getEconomy_meta = getEconomy.getItemMeta();
        getEconomy_meta.setDisplayName(Translator.Colors(configShop.getConfig().getString("Shop.items.balance.name")));

        List<String> lore = new ArrayList<String>();
        for (String lines : configShop.getConfig().getStringList("Shop.items.balance.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', lines).replace("%money%", ""+econ.getBalance(p)));
        }
        getEconomy_meta.setLore(lore);

        if (configShop.getConfig().getBoolean("Shop.items.balance.glowing")) {
            getEconomy_meta.addEnchant(Enchantment.DURABILITY, 1, true);
            getEconomy_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        getEconomy.setItemMeta(getEconomy_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Sticks
        shop.setItem(configShop.getConfig().getInt("Shop.items.fireballstick.position"), fireballstick);
        shop.setItem(configShop.getConfig().getInt("Shop.items.witherstick.position"), witherstick);
        shop.setItem(configShop.getConfig().getInt("Shop.items.icestick.position"), icestick);
        shop.setItem(configShop.getConfig().getInt("Shop.items.electricstick.position"), electricstick);
        shop.setItem(configShop.getConfig().getInt("Shop.items.bridgestick.position"), bridgestick);
        // Sticks
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Other
        shop.setItem(configShop.getConfig().getInt("Shop.items.balance.position"), getEconomy);
        // Other
        //-------------------------------------------------------------------------------------

        p.openInventory(shop);
    }
}