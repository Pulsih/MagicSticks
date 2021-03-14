package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Sticks {

    public static ItemStack fireballstick() {

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

        ItemStack item = new ItemStack(Material.valueOf(configSticks.getConfig().getString("Sticks.fireballstick.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Translator.Colors(configSticks.getConfig().getString("Sticks.fireballstick.name")));

        List<String> lore = new ArrayList<String>();
        for (String lines : configSticks.getConfig().getStringList("Sticks.fireballstick.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', lines));
        }
        meta.setLore(lore);

        if (configSticks.getConfig().getBoolean("Sticks.fireballstick.glowing")) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }


    public static ItemStack witherstick() {

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

        ItemStack item = new ItemStack(Material.valueOf(configSticks.getConfig().getString("Sticks.witherstick.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Translator.Colors(configSticks.getConfig().getString("Sticks.witherstick.name")));

        List<String> lore = new ArrayList<String>();
        for (String lines : configSticks.getConfig().getStringList("Sticks.witherstick.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', lines));
        }
        meta.setLore(lore);

        if (configSticks.getConfig().getBoolean("Sticks.witherstick.glowing")) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }


    public static ItemStack icestick() {

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

        ItemStack item = new ItemStack(Material.valueOf(configSticks.getConfig().getString("Sticks.icestick.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Translator.Colors(configSticks.getConfig().getString("Sticks.icestick.name")));

        List<String> lore = new ArrayList<String>();
        for (String lines : configSticks.getConfig().getStringList("Sticks.icestick.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', lines));
        }
        meta.setLore(lore);

        if (configSticks.getConfig().getBoolean("Sticks.icestick.glowing")) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }


    public static ItemStack electricstick() {

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

        ItemStack item = new ItemStack(Material.valueOf(configSticks.getConfig().getString("Sticks.electricstick.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Translator.Colors(configSticks.getConfig().getString("Sticks.electricstick.name")));

        List<String> lore = new ArrayList<String>();
        for (String lines : configSticks.getConfig().getStringList("Sticks.electricstick.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', lines));
        }
        meta.setLore(lore);

        if (configSticks.getConfig().getBoolean("Sticks.electricstick.glowing")) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }


    public static ItemStack bridgestick() {

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

        ItemStack item = new ItemStack(Material.valueOf(configSticks.getConfig().getString("Sticks.bridgestick.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Translator.Colors(configSticks.getConfig().getString("Sticks.bridgestick.name")));

        List<String> lore = new ArrayList<String>();
        for (String lines : configSticks.getConfig().getStringList("Sticks.bridgestick.lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', lines));
        }
        meta.setLore(lore);

        if (configSticks.getConfig().getBoolean("Sticks.bridgestick.glowing")) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }
}