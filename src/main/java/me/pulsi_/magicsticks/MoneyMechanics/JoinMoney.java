package me.pulsi_.magicsticks.MoneyMechanics;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinMoney implements Listener {

    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    String delay = Main.getInstance().getConfig().getString("money_delay");
    String maxMoney = Main.getInstance().getConfig().getString("max_money");
    String moneyGiven = Main.getInstance().getConfig().getString("money_given");

    @EventHandler
    public void joinMoney(PlayerJoinEvent e) {
        if (!(Main.getInstance().getConfig().getString("shoot_selector").contains("MONEY"))) return;
        Player player = e.getPlayer();
        new BukkitRunnable() {
            public void run() {
                if (player.getLevel() < Long.parseLong(maxMoney)) {
                    player.giveExpLevels((int) Long.parseLong(moneyGiven));
                    String charging = messages.getConfig().getString("charging__money_message");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(charging)));
                } else {
                    String fullMana = messages.getConfig().getString("fullmoney_message");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(fullMana)));
                }
            }
        }.runTaskTimer(Main.getInstance(), 0, Long.parseLong(delay));
    }
}