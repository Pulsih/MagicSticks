package me.pulsi_.magicsticks.Mana;

import me.pulsi_.magicsticks.MagicSticks;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ManaRegeneration implements Listener {

    ConfigManager messages = new ConfigManager(MagicSticks.getInstance(), "messages.yml");

    String delay = MagicSticks.getInstance().getConfig().getString("manaregeneration_delay");
    String maxMana = MagicSticks.getInstance().getConfig().getString("maxmana");
    String expGiven = MagicSticks.getInstance().getConfig().getString("mana_given");

    @EventHandler
    public void MoveMana(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        new BukkitRunnable() {
            public void run() {
                if (player.getLevel() < Long.parseLong(maxMana)) {
                    player.giveExpLevels((int) Long.parseLong(expGiven));
                    String charging = messages.getConfig().getString("charging_message");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(charging)));
                } else {
                    String fullMana = messages.getConfig().getString("fullmana_message");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(fullMana)));
                }
            }
        }.runTaskTimer(MagicSticks.getInstance(), 0, Long.parseLong(delay));
    }
}
