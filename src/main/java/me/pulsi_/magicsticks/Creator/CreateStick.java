package me.pulsi_.magicsticks.Creator;

import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CreateStick {

    private Player player;

    public CreateStick(Player player){
        this.player = player;
    }

    public void openCreator(){

        Inventory creator = Bukkit.createInventory(null, 45, (Translator.Colors("&b&oStick Creator")));

        ItemStack setID = new ItemStack(Material.PAPER);
        ItemStack setName = new ItemStack(Material.WRITTEN_BOOK);


        //-------------------------------------------------------------------------------------
        //SetID

        ItemMeta setID_meta = setID.getItemMeta();
        setID_meta.setDisplayName(Translator.Colors("&aSet Item &b&oID"));
        ArrayList<String> setID_lore = new ArrayList<>();
        setID_lore.add(Translator.Colors("&aThe item ID is used for"));
        setID_lore.add(Translator.Colors("&9give &aor &9recive &athe Stick by"));
        setID_lore.add(Translator.Colors("&athe {ID}."));
        setID_lore.add(Translator.Colors("&aExample: &c*VenomStick*"));
        setID_lore.add(Translator.Colors("&c*VenomStick* &aWill be used for:"));
        setID_lore.add(Translator.Colors("&b/Stick give VenomStick"));
        setID_meta.setLore(setID_lore);
        setID.setItemMeta(setID_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        //SetName

        ItemMeta setName_meta = setName.getItemMeta();
        setID_meta.setDisplayName(Translator.Colors("&aSet Item &6&oName"));
        ArrayList<String> setName_lore = new ArrayList<>();
        setName_lore.add(Translator.Colors("&aSet the item &9Name"));
        setName_meta.setLore(setName_lore);
        setName.setItemMeta(setName_meta);

        //-------------------------------------------------------------------------------------


        //-------------------------------------------------------------------------------------
        // Sticks
        creator.setItem(11, setID);
        creator.setItem(19, setName);
        // Sticks
        //-------------------------------------------------------------------------------------

        player.openInventory(creator);

    }
}
