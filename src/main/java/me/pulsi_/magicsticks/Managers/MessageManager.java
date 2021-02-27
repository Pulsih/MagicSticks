package me.pulsi_.magicsticks.Managers;

import me.pulsi_.magicsticks.MagicSticks;
import org.bukkit.entity.Player;

public class MessageManager {

    ConfigManager messages = new ConfigManager(MagicSticks.getInstance(), "messages.yml");

    private Player player;

    public MessageManager(Player player){
        this.player = player;
    }

    public void reloadMessage(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("reload_message")));
    }

    public void noPermissions(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")));
    }

    public void unknownCommand(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("unknown_command")));
    }

    public void powerActivated(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("power_activated_message")));
    }

    public void unknownStick(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("unknown_stick_message")));
    }

    public void noMoney(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("nomoney_message")));
    }

    public void invFull(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("invfull_message")));
    }

    public void strikerBuyMessage(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("buy_strikerpower_message")));
    }

    public void tankBuyMessage(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("buy_tankpower_message")));
    }

    public void furtivityBuyMessage(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("buy_furtivitypower_message")));
    }

    public void buyFireballStick(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("buy_fireballstick_message")));
    }

    public void buyWitherStick(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("buy_witherstick_message")));
    }

    public void buyIceStick(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("buy_icestick_message")));
    }

    public void buyElectricStick(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("buy_electricstick_message")));
    }

    public void buyBridgeStick(){
        player.sendMessage(Translator.Colors(messages.getConfig().getString("buy_bridgestick_message")));
    }
}
