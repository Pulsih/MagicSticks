package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemCreators {

    public static ItemStack createItemStack(ConfigurationSection c) {

        ItemStack itemStack = new ItemStack(Material.valueOf(c.getString("material")), 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Translator.Colors(c.getString("name")));

        List<String> lore = new ArrayList<String>();
        for (String lines : c.getStringList("lore")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', lines));
        }

        if (c.getBoolean("glowing")) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}