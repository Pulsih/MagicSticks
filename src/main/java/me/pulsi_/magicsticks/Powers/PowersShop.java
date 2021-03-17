package me.pulsi_.magicsticks.Powers;

import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PowersShop {

    private Player player;

    public PowersShop(Player player){
        this.player = player;
    }

    public void openPowers(){

        Inventory powers = Bukkit.createInventory(null, 27, (Translator.Colors("&4&lPowers &a&lSelector")));

        ItemStack powerStriker = new ItemStack(PowersItems.strikerItem());
        ItemStack powerTank = new ItemStack(PowersItems.tankItem());
        ItemStack powerFurtivity = new ItemStack(PowersItems.furtivityItem());

        powers.setItem(10, powerStriker);
        powers.setItem(13, powerTank);
        powers.setItem(16, powerFurtivity);

        player.openInventory(powers);
    }
}