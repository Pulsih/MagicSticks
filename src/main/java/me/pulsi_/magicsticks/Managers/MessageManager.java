package me.pulsi_.magicsticks.Managers;

import me.pulsi_.magicsticks.Main;
import org.bukkit.entity.Player;

public class MessageManager {

    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    private Player p;

    public MessageManager(Player p){
        this.p = p;
    }

    public void reloadMessage(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("reload_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void noPermissions(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void unknownCommand(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("unknown_command").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void powerActivated(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("power_activated_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void unknownStick(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("unknown_stick_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void noMoney(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void invFull(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void strikerBuyMessage(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("buy_strikerpower_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void tankBuyMessage(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("buy_tankpower_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void furtivityBuyMessage(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("buy_furtivitypower_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void buyFireballStick(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("buy_fireballstick_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void buyWitherStick(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("buy_witherstick_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void buyIceStick(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("buy_icestick_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void buyElectricStick(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("buy_electricstick_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }

    public void buyBridgeStick(){
        p.sendMessage(Translator.Colors(messages.getConfig().getString("buy_bridgestick_message").replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
    }
}
