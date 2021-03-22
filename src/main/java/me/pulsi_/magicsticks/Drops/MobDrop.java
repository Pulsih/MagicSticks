package me.pulsi_.magicsticks.Drops;

import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MobDrop {

    public static ItemStack mobDrops() {

        ItemStack nugget = new ItemStack(Material.GOLD_NUGGET);

        ItemMeta meta = nugget.getItemMeta();

        meta.setDisplayName(Translator.Colors("&aNugget"));

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Translator.Colors("&5Use 2 these nuggets to upgrade your Abilities"));

        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setLore(lore);
        nugget.setItemMeta(meta);
        return nugget;
    }
}