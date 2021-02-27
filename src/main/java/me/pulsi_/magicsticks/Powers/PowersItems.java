package me.pulsi_.magicsticks.Powers;

import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PowersItems {


    public static ItemStack getStrikerPower() {
        //Striker Power
        ItemStack item = new ItemStack(Material.FERMENTED_SPIDER_EYE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Translator.Colors("&4&l&oSTRIKER &3&l(140+ Points)"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&2&lVantages"));
        lore.add(Translator.Colors("&8> &6Make your sticks deal more damage!"));
        lore.add(Translator.Colors("&8> &6Makes you faster!"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&c&lDisadvantages"));
        lore.add(Translator.Colors("&8> &4Less health"));
        lore.add(Translator.Colors("&8> &4More vulnerable"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&6&l&nSUPER"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&8> &dShift+Right-Click &ato:"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&a- Give yourself &bRegeneration V &afor &b20 Seconds&a!"));
        lore.add(Translator.Colors("&a- Give yourself &bSpeed III &afor &b20 Seconds"));
        lore.add(Translator.Colors("&a- Shoot without using &dMana &afor &b20 Seconds"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&7Cost: &d20 Mana"));
        lore.add(Translator.Colors("&7&o*Cool down: 300 Seconds*"));
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public static ItemStack getTankPower() {

        ItemStack item = new ItemStack(Material.BEACON, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Translator.Colors("&b&l&oTANK &3&l(140+ Points)"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&2&lVantages"));
        lore.add(Translator.Colors("&8> &6+10 Bonus hearths!"));
        lore.add(Translator.Colors("&8> &6-20% of damage from attacks!"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&c&lDisadvantages"));
        lore.add(Translator.Colors("&8> &4More slow"));
        lore.add(Translator.Colors("&8> &4Less Mana capacity"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&6&l&nSUPER"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&8> &dShift+Right-Click &ato:"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&a- Create a physic barrier which protect you and your allies!"));
        lore.add(Translator.Colors("&a- Give yourself &bRegeneration II &afor &b30 Seconds"));
        lore.add(Translator.Colors("&a- Make yourself invincible for &b5 Seconds"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&7Cost: &d15 Mana"));
        lore.add(Translator.Colors("&7&o*Cool down 300 Seconds*"));
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public static ItemStack getFurtivityPower() {

        ItemStack item = new ItemStack(Material.FEATHER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Translator.Colors("&5&l&oFURTIVITY &3&l(110+ Points)"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&2&lVantages"));
        lore.add(Translator.Colors("&8> &6Speed and Jump Increased!"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&c&lDisadvantages"));
        lore.add(Translator.Colors("&8> &4Mana Regeneration more slow"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&6&l&nSUPER"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&8> &dShift+Right-Click &ato:"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&a- Becomes invisible to enemies for &b10 Seconds"));
        lore.add(Translator.Colors("&a- Gets an increment of Speed and Jump for &b20 Seconds"));
        lore.add(Translator.Colors("&a- Inflict &c+20% &6of damage while you are invisible"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&7Cost: &d20 Mana"));
        lore.add(Translator.Colors("&7&o*Cool down 300 Seconds*"));
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
