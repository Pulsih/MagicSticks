package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.Managers.Translator;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Sticks {

    public static ItemStack getFireBallStick() {
        //FireBallStick
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Translator.Colors("&c&lFireBall &a&lStick"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Translator.Colors("&8&m--------------------------"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&7The classic &cFireBall Stick&7!"));
        lore.add(Translator.Colors("&7Shoot and kill everyone!"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&cDamage: &a3 Hearths"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&8&m--------------------------"));
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public static ItemStack getWitherStick() {
        //WitherStick
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Translator.Colors("&8&lWither &3&lStick"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Translator.Colors("&8&m--------------------------"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&7A stick whit the power of"));
        lore.add(Translator.Colors("&7The Wither Boss!"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&cDamage: &a4 Hearths"));
        lore.add(Translator.Colors("&8"));
        lore.add(Translator.Colors("&8&m--------------------------"));
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public static ItemStack getIceStick() {
        //IceStick
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Translator.Colors("&9&lIce &3&lStick"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Translator.Colors("&7Freeze player whit this"));
        lore.add(Translator.Colors("&7cold Stick!"));
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    public static ItemStack getElectricStick() {
        //ElectricStick
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Translator.Colors("&b&lE&3&ll&b&le&3&lc&b&lt&3&lr&b&li&3&lc &7&lStick"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Translator.Colors("&7Kill enemies whit the power"));
        lore.add(Translator.Colors("&7of the lightning!"));
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;


    }


    public static ItemStack getBridgeStick() {
        //BridgeStick
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Translator.Colors("&2&lB&6&lr&2&li&6&ld&2&lg&6&le &b&lStick"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Translator.Colors("&7Right-Click on this stick for"));
        lore.add(Translator.Colors("&7automatically build a bridge"));
        lore.add(Translator.Colors("&7under your feet!"));
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }
}
