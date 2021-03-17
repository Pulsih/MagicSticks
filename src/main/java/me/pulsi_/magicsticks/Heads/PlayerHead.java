package me.pulsi_.magicsticks.Heads;

import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerHead {

    public static ItemStack playerHead() {

        ItemStack head = new ItemStack(Material.PLAYER_HEAD);

        ItemMeta meta = head.getItemMeta();

        meta.setDisplayName(Translator.Colors("&cPlayer Head"));

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Translator.Colors("&5Use this head to upgrade your Abilities"));

        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.setLore(lore);
        head.setItemMeta(meta);
        return head;
    }
}