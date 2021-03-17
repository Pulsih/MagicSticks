package me.pulsi_.magicsticks.Powers;

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

public class PowersItems {

    public static ItemStack strikerItem() {

        ConfigManager powers = new ConfigManager(Main.getInstance(), "powers.yml");

        ItemStack item = new ItemStack(Material.valueOf(powers.getConfig().getString("Powers.Striker.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Translator.Colors(powers.getConfig().getString("Powers.Striker.name")));

        if (powers.getConfig().getBoolean("Powers.Striker.use_lore")) {
            List<String> lore = new ArrayList<String>();
            for (String lines : powers.getConfig().getStringList("Powers.Striker.lore")) {
                lore.add(ChatColor.translateAlternateColorCodes('&', lines));
            }
            meta.setLore(lore);
        }

        if (powers.getConfig().getBoolean("Powers.Striker.glowing")) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack tankItem() {

        ConfigManager powers = new ConfigManager(Main.getInstance(), "powers.yml");

        ItemStack item = new ItemStack(Material.valueOf(powers.getConfig().getString("Powers.Tank.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Translator.Colors(powers.getConfig().getString("Powers.Tank.name")));

        if (powers.getConfig().getBoolean("Powers.Tank.use_lore")) {
            List<String> lore = new ArrayList<String>();
            for (String lines : powers.getConfig().getStringList("Powers.Tank.lore")) {
                lore.add(ChatColor.translateAlternateColorCodes('&', lines));
            }
            meta.setLore(lore);
        }

        if (powers.getConfig().getBoolean("Powers.Tank.glowing")) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack furtivityItem() {

        ConfigManager powers = new ConfigManager(Main.getInstance(), "powers.yml");

        ItemStack item = new ItemStack(Material.valueOf(powers.getConfig().getString("Powers.Furtivity.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Translator.Colors(powers.getConfig().getString("Powers.Furtivity.name")));

        if (powers.getConfig().getBoolean("Powers.Furtivity.use_lore")) {
            List<String> lore = new ArrayList<String>();
            for (String lines : powers.getConfig().getStringList("Powers.Furtivity.lore")) {
                lore.add(ChatColor.translateAlternateColorCodes('&', lines));
            }
            meta.setLore(lore);
        }

        if (powers.getConfig().getBoolean("Powers.Furtivity.glowing")) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }
}