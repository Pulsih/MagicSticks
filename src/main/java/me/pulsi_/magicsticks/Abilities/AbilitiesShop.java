package me.pulsi_.magicsticks.Abilities;

import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AbilitiesShop {

    private Player player;

    public AbilitiesShop(Player player){
        this.player = player;
    }

    public void openAbilities(){

        Inventory abilities = Bukkit.createInventory(null, 27, (Translator.Colors("&5&lAbilities &a&lShop")));

        ItemStack abilityResistance = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack abilityDamage = new ItemStack(Material.REDSTONE);


        //-------------------------------------------------------------------------------------
        //Resistance Abilities

        ItemMeta abilityResistance_meta = abilityResistance.getItemMeta();
        abilityResistance_meta.setDisplayName(Translator.Colors("&d&lRESISTANCE"));
        ArrayList<String> abilityResistance_lore = new ArrayList<>();
        abilityResistance_lore.add(Translator.Colors("&8"));
        abilityResistance_lore.add(Translator.Colors("&8&l> &7Increase the Player Resistance"));
        abilityResistance_lore.add(Translator.Colors("&c"));
        abilityResistance_lore.add(Translator.Colors("&7Cost: &215 Gems"));
        abilityResistance_meta.setLore(abilityResistance_lore);
        abilityResistance.setItemMeta(abilityResistance_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //Resistance Abilities

        ItemMeta abilityDamage_meta = abilityDamage.getItemMeta();
        abilityDamage_meta.setDisplayName(Translator.Colors("&d&lRESISTANCE"));
        ArrayList<String> abilityDamage_lore = new ArrayList<>();
        abilityDamage_lore.add(Translator.Colors("&8"));
        abilityDamage_lore.add(Translator.Colors("&8&l> &7Increase the Damage of your Sticks"));
        abilityDamage_lore.add(Translator.Colors("&c"));
        abilityDamage_lore.add(Translator.Colors("&7Cost: &215 Gems"));
        abilityDamage_meta.setLore(abilityDamage_lore);
        abilityDamage.setItemMeta(abilityDamage_meta);

        //-------------------------------------------------------------------------------------


        abilities.setItem(11, abilityResistance);
        abilities.setItem(12, abilityDamage);

        player.openInventory(abilities);

    }
}
