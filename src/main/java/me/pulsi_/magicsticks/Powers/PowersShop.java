package me.pulsi_.magicsticks.Powers;

import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PowersShop {

    private Player player;

    public PowersShop(Player player){
        this.player = player;
    }

    public void openPowers(){

        Inventory powers = Bukkit.createInventory(null, 27, (Translator.Colors("&4&lPowers &a&lSelector")));

        ItemStack powerStriker = new ItemStack(Material.FERMENTED_SPIDER_EYE);
        ItemStack powerTank = new ItemStack(Material.BEACON);
        ItemStack powerFurtivity = new ItemStack(Material.FEATHER);


        //-------------------------------------------------------------------------------------
        //Striker Ability

        ItemMeta powerStriker_meta = powerStriker.getItemMeta();
        powerStriker_meta.setDisplayName(Translator.Colors("&4&l&oSTRIKER &3&l(140+ Points)"));
        ArrayList<String> powerStriker_lore = new ArrayList<>();
        powerStriker_lore.add(Translator.Colors("&8"));
        powerStriker_lore.add(Translator.Colors("&2&lVantages"));
        powerStriker_lore.add(Translator.Colors("&8> &6Make your sticks deal more damage!"));
        powerStriker_lore.add(Translator.Colors("&8> &6Makes you faster!"));
        powerStriker_lore.add(Translator.Colors("&8"));
        powerStriker_lore.add(Translator.Colors("&c&lDisadvantages"));
        powerStriker_lore.add(Translator.Colors("&8> &4Less health"));
        powerStriker_lore.add(Translator.Colors("&8> &4More vulnerable"));
        powerStriker_lore.add(Translator.Colors("&8"));
        powerStriker_lore.add(Translator.Colors("&6&l&nSUPER"));
        powerStriker_lore.add(Translator.Colors("&8"));
        powerStriker_lore.add(Translator.Colors("&8> &dShift+Right-Click &ato:"));
        powerStriker_lore.add(Translator.Colors("&8"));
        powerStriker_lore.add(Translator.Colors("&a- Give yourself &bRegeneration V &afor &b20 Seconds&a!"));
        powerStriker_lore.add(Translator.Colors("&a- Give yourself &bSpeed III &afor &b20 Seconds"));
        powerStriker_lore.add(Translator.Colors("&a- Shoot without using &dMana &afor &b20 Seconds"));
        powerStriker_lore.add(Translator.Colors("&8"));
        powerStriker_lore.add(Translator.Colors("&7Cost: &d20 Mana"));
        powerStriker_lore.add(Translator.Colors("&7*&oCool down 300 Seconds*"));
        powerStriker_lore.add(Translator.Colors("&8"));
        powerStriker_lore.add(Translator.Colors("&2&l(!) &aClick to select it! &2&l(!)"));
        powerStriker_lore.add(Translator.Colors("&8"));
        powerStriker_lore.add(Translator.Colors("&7Cost: &2$45000"));
        powerStriker_meta.setLore(powerStriker_lore);
        powerStriker.setItemMeta(powerStriker_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //Tank Ability

        ItemMeta powerTank_meta = powerTank.getItemMeta();
        powerTank_meta.setDisplayName(Translator.Colors("&b&l&oTANK &3&l(140+ Points)"));
        ArrayList<String> powerTank_lore = new ArrayList<>();
        powerTank_lore.add(Translator.Colors("&8"));
        powerTank_lore.add(Translator.Colors("&2&lVantages"));
        powerTank_lore.add(Translator.Colors("&8> &6+10 Bonus hearths!"));
        powerTank_lore.add(Translator.Colors("&8> &6-20% of damage from attacks!"));
        powerTank_lore.add(Translator.Colors("&8"));
        powerTank_lore.add(Translator.Colors("&c&lDisadvantages"));
        powerTank_lore.add(Translator.Colors("&8> &4More slow"));
        powerTank_lore.add(Translator.Colors("&8> &4Less Mana capacity"));
        powerTank_lore.add(Translator.Colors("&8"));
        powerTank_lore.add(Translator.Colors("&6&l&nSUPER"));
        powerTank_lore.add(Translator.Colors("&8"));
        powerTank_lore.add(Translator.Colors("&8> &dShift+Right-Click &ato:"));
        powerTank_lore.add(Translator.Colors("&8"));
        powerTank_lore.add(Translator.Colors("&a- Create a physic barrier which protect you and your allies!"));
        powerTank_lore.add(Translator.Colors("&a- Give yourself &bRegeneration II &afor &b30 Seconds"));
        powerTank_lore.add(Translator.Colors("&a- Make yourself invincible for &b5 Seconds"));
        powerTank_lore.add(Translator.Colors("&8"));
        powerTank_lore.add(Translator.Colors("&7Cost: &d15 Mana"));
        powerTank_lore.add(Translator.Colors("&7&o*Cool down 300 Seconds*"));
        powerTank_lore.add(Translator.Colors("&8"));
        powerTank_lore.add(Translator.Colors("&2&l(!) &aClick to select it! &2&l(!)"));
        powerTank_lore.add(Translator.Colors("&8"));
        powerTank_lore.add(Translator.Colors("&7Cost: &2$45000"));
        powerTank_meta.setLore(powerTank_lore);
        powerTank.setItemMeta(powerTank_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //Tank Ability

        ItemMeta powerFurtivity_meta = powerFurtivity.getItemMeta();
        powerFurtivity_meta.setDisplayName(Translator.Colors("&5&l&oFURTIVITY &3&l(110+ Points)"));
        ArrayList<String> powerFurtivity_lore = new ArrayList<>();
        powerFurtivity_lore.add(Translator.Colors("&8"));
        powerFurtivity_lore.add(Translator.Colors("&2&lVantages"));
        powerFurtivity_lore.add(Translator.Colors("&8> &6Speed and Jump Increased!"));
        powerFurtivity_lore.add(Translator.Colors("&8"));
        powerFurtivity_lore.add(Translator.Colors("&c&lDisadvantages"));
        powerFurtivity_lore.add(Translator.Colors("&8> &4Mana Regeneration more slow"));
        powerFurtivity_lore.add(Translator.Colors("&8"));
        powerFurtivity_lore.add(Translator.Colors("&6&l&nSUPER"));
        powerFurtivity_lore.add(Translator.Colors("&8"));
        powerFurtivity_lore.add(Translator.Colors("&8> &dShift+Right-Click &ato:"));
        powerFurtivity_lore.add(Translator.Colors("&8"));
        powerFurtivity_lore.add(Translator.Colors("&a- Becomes invisible to enemies for 10 Seconds"));
        powerFurtivity_lore.add(Translator.Colors("&a- Heal yourself"));
        powerFurtivity_lore.add(Translator.Colors("&a- Inflict +20% of damage while you are invisible"));
        powerFurtivity_lore.add(Translator.Colors("&8"));
        powerFurtivity_lore.add(Translator.Colors("&7Cost: &d20 Mana"));
        powerFurtivity_lore.add(Translator.Colors("&7&o*Cool down 300 Seconds*"));
        powerFurtivity_lore.add(Translator.Colors("&8"));
        powerFurtivity_lore.add(Translator.Colors("&2&l(!) &aClick to select it! &2&l(!)"));
        powerFurtivity_lore.add(Translator.Colors("&8"));
        powerFurtivity_lore.add(Translator.Colors("&7Cost: &2$30000"));
        powerFurtivity_meta.setLore(powerFurtivity_lore);
        powerFurtivity.setItemMeta(powerFurtivity_meta);

        //-------------------------------------------------------------------------------------


        powers.setItem(10, powerStriker);
        powers.setItem(12, powerTank);
        powers.setItem(14, powerFurtivity);

        player.openInventory(powers);

    }
}
