package me.pulsi_.magicsticks.Ammos;

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

public class AmmoItems {

    public static ItemStack ammo() {

        ConfigManager ammo = new ConfigManager(Main.getInstance(), "ammo.yml");

        ItemStack item = new ItemStack(Material.valueOf(ammo.getConfig().getString("Ammo.material")));

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(Translator.Colors(ammo.getConfig().getString("Ammo.name")));

        if (ammo.getConfig().getBoolean("Ammo.use_lore")) {
            List<String> lore = new ArrayList<String>();
            for (String lines : ammo.getConfig().getStringList("Ammo.lore")) {
                lore.add(ChatColor.translateAlternateColorCodes('&', lines));
            }
            meta.setLore(lore);
        }

        if (ammo.getConfig().getBoolean("Ammo.glowing")) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }
}