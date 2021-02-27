package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.MagicSticks;
import me.pulsi_.magicsticks.Managers.Translator;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SticksShop {

    Economy econ = MagicSticks.getEconomy();

    private Player player;

    public SticksShop(Player player){
        this.player = player;
    }

    public void openShop(){

        Inventory shop = Bukkit.createInventory(null, 27, (Translator.Colors("&9&lSticks &a&lShop")));

        ItemStack getFireBallStick = new ItemStack(Material.STICK);
        ItemStack getWitherStick = new ItemStack(Material.STICK);
        ItemStack getIceStick = new ItemStack(Material.STICK);
        ItemStack getElectricStick = new ItemStack(Material.STICK);
        ItemStack getBridgeStick = new ItemStack(Material.STICK);
        ItemStack getEconomy = new ItemStack(Material.GOLD_INGOT);
        ItemStack whiteGlass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);


        //-------------------------------------------------------------------------------------
        //FireBallStick

        ItemMeta FireBallStick_meta = getFireBallStick.getItemMeta();
        FireBallStick_meta.setDisplayName(Translator.Colors("&c&lFireBall &a&lStick"));
        ArrayList<String> FireBallStick_lore = new ArrayList<>();
        FireBallStick_lore.add(Translator.Colors("&7The classic &cFireBall Stick&7!"));
        FireBallStick_lore.add(Translator.Colors("&7Shoot and kill everyone!"));
        FireBallStick_lore.add(Translator.Colors("&c"));
        FireBallStick_lore.add(Translator.Colors("&7Cost: &2$500"));
        FireBallStick_meta.addEnchant(Enchantment.DURABILITY, 1, true);
        FireBallStick_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        FireBallStick_meta.setLore(FireBallStick_lore);
        getFireBallStick.setItemMeta(FireBallStick_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //WitherStick

        ItemMeta WitherStick_meta = getWitherStick.getItemMeta();
        WitherStick_meta.setDisplayName(Translator.Colors("&8&lWither &3&lStick"));
        ArrayList<String> WitherStick_lore = new ArrayList<>();
        WitherStick_lore.add(Translator.Colors("&7A stick with the power of"));
        WitherStick_lore.add(Translator.Colors("&7the Wither Boss!"));
        WitherStick_lore.add(Translator.Colors("&c"));
        WitherStick_lore.add(Translator.Colors("&7Cost: &2$650"));
        WitherStick_meta.addEnchant(Enchantment.DURABILITY, 1, true);
        WitherStick_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        WitherStick_meta.setLore(WitherStick_lore);
        getWitherStick.setItemMeta(WitherStick_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //IceStick

        ItemMeta IceStick_meta = getIceStick.getItemMeta();
        IceStick_meta.setDisplayName(Translator.Colors("&9&lIce &3&lStick"));
        ArrayList<String> IceStick_lore = new ArrayList<>();
        IceStick_lore.add(Translator.Colors("&7Freeze player with this"));
        IceStick_lore.add(Translator.Colors("&7cold Stick!"));
        IceStick_lore.add(Translator.Colors("&c"));
        IceStick_lore.add(Translator.Colors("&7Cost: &2$500"));
        IceStick_meta.addEnchant(Enchantment.DURABILITY, 1, true);
        IceStick_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        IceStick_meta.setLore(IceStick_lore);
        getIceStick.setItemMeta(IceStick_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //ElectricStick

        ItemMeta ElectricStick_meta = getElectricStick.getItemMeta();
        ElectricStick_meta.setDisplayName(Translator.Colors("&b&lE&3&ll&b&le&3&lc&b&lt&3&lr&b&li&3&lc &7&lStick"));
        ArrayList<String> ElectricStick_lore = new ArrayList<>();
        ElectricStick_lore.add(Translator.Colors("&7Kill enemies with the power"));
        ElectricStick_lore.add(Translator.Colors("&7of the lightning!"));
        ElectricStick_lore.add(Translator.Colors("&c"));
        ElectricStick_lore.add(Translator.Colors("&7Cost: &2$750"));
        ElectricStick_meta.addEnchant(Enchantment.DURABILITY, 1, true);
        ElectricStick_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ElectricStick_meta.setLore(ElectricStick_lore);
        getElectricStick.setItemMeta(ElectricStick_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //BridgeStick

        ItemMeta BridgeStick_meta = getBridgeStick.getItemMeta();
        BridgeStick_meta.setDisplayName(Translator.Colors("&2&lB&6&lr&2&li&6&ld&2&lg&6&le &b&lStick"));
        ArrayList<String> BridgeStick_lore = new ArrayList<>();
        BridgeStick_lore.add(Translator.Colors("&7Kill enemies with the power"));
        BridgeStick_lore.add(Translator.Colors("&7of the lightning!"));
        BridgeStick_lore.add(Translator.Colors("&c"));
        BridgeStick_lore.add(Translator.Colors("&7Cost: &2$750"));
        BridgeStick_meta.addEnchant(Enchantment.DURABILITY, 1, true);
        BridgeStick_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        BridgeStick_meta.setLore(BridgeStick_lore);
        getBridgeStick.setItemMeta(BridgeStick_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //BridgeStick

        ItemMeta getEconomy_meta = getEconomy.getItemMeta();
        getEconomy_meta.setDisplayName(Translator.Colors("&6&lYour Balance"));
        ArrayList<String> getEconomy_lore = new ArrayList<>();
        getEconomy_lore.add(Translator.Colors("&6"));
        getEconomy_lore.add(Translator.Colors("&7Money: &2" + econ.getBalance(player)));
        getEconomy_meta.addEnchant(Enchantment.DURABILITY, 1, true);
        getEconomy_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        getEconomy_meta.setLore(getEconomy_lore);
        getEconomy.setItemMeta(getEconomy_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //WhiteGlass

        ItemMeta WhiteGlass_meta = whiteGlass.getItemMeta();
        WhiteGlass_meta.setDisplayName(Translator.Colors("&6"));
        BridgeStick_meta.setLore(ElectricStick_lore);
        whiteGlass.setItemMeta(WhiteGlass_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Sticks
        shop.setItem(11, getFireBallStick);
        shop.setItem(12, getWitherStick);
        shop.setItem(13, getIceStick);
        shop.setItem(14, getElectricStick);
        shop.setItem(15, getBridgeStick);
        // Sticks
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Glass
        shop.setItem(0, whiteGlass);
        shop.setItem(1, whiteGlass);
        shop.setItem(2, whiteGlass);
        shop.setItem(3, whiteGlass);
        shop.setItem(4, whiteGlass);
        shop.setItem(5, whiteGlass);
        shop.setItem(6, whiteGlass);
        shop.setItem(7, whiteGlass);
        shop.setItem(8, whiteGlass);
        shop.setItem(9, whiteGlass);
        shop.setItem(10, whiteGlass);
        shop.setItem(16, whiteGlass);
        shop.setItem(17, whiteGlass);
        shop.setItem(18, whiteGlass);
        shop.setItem(19, whiteGlass);
        shop.setItem(20, whiteGlass);
        shop.setItem(21, whiteGlass);
        shop.setItem(22, whiteGlass);
        shop.setItem(23, whiteGlass);
        shop.setItem(24, whiteGlass);
        shop.setItem(25, whiteGlass);
        // Glass
        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Other
        shop.setItem(26, getEconomy);
        // Other
        //-------------------------------------------------------------------------------------

        player.openInventory(shop);

    }
}
