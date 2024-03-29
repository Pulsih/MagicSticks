package me.pulsi_.magicsticks.Powers;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PowersEffects implements Listener {

    Map<UUID, Long> cooldown = new HashMap<>();

    ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");

    @EventHandler
    public void Powers(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        World world = p.getWorld();
        if (!(Main.getInstance().getConfig().getString("shoot_selector").contains("MANA"))) return;
        if (!e.getAction().name().contains("RIGHT")) return;
        if (!p.isSneaking()) return;
        ItemStack item = e.getItem();

        if (item == null) return;
        if (!(item.isSimilar(PowersItems.tankItem()) || item.isSimilar(PowersItems.strikerItem()) || item.isSimilar(PowersItems.furtivityItem())))
            return;

        if (!this.cooldown.containsKey(p.getUniqueId()) || this.cooldown.get(p.getUniqueId()) <= System.currentTimeMillis()) {
            this.cooldown.put(p.getUniqueId(), System.currentTimeMillis() + (5 * 60 * 1000));

        } else {
            String messageCooldown = messages.getConfig().getString("cooldown_message")
                    .replace("%prefix%" , messages.getConfig().getString("prefix"));
            long timeleft = (this.cooldown.get(p.getUniqueId()) - System.currentTimeMillis());
            p.sendMessage(Translator.Colors(messageCooldown.replace("%timeleft%", (timeleft / 1000) + "")));
            return;
        }

        //-------------------------------------------------------------------------------------------
        // Striker Power
        if (item.isSimilar(PowersItems.strikerItem())) {
            if (p.getLevel() >= 20) {
                p.giveExpLevels(-20);
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 400, 4));
                p.getWorld().strikeLightningEffect(p.getLocation());
                p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 5, 1);
                p.sendMessage(Translator.Colors(messages.getConfig().getString("power_activated_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            } else {
                String noMana = messages.getConfig().getString("insufficient_mana_message")
                        .replace("%prefix%" , messages.getConfig().getString("prefix"));
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
            // Striker Power
            //-------------------------------------------------------------------------------------------


            //-------------------------------------------------------------------------------------------
            // Tank Power
        } else if (item.isSimilar(PowersItems.tankItem())) {
            if (p.getLevel() >= 15) {
                p.giveExpLevels(-15);
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 255));
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 400, 4));
                world.createExplosion(p.getLocation(), 0);
                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15, 1);
                p.sendMessage(Translator.Colors(messages.getConfig().getString("power_activated_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            } else {
                String noMana = Main.getInstance().getConfig().getString("insufficient_mana_message")
                        .replace("%prefix%" , messages.getConfig().getString("prefix"));
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
            // Tank Power
            //-------------------------------------------------------------------------------------------


            //-------------------------------------------------------------------------------------------
            // Furtivity Power
        } else if (item.isSimilar(PowersItems.furtivityItem())) {
            if (p.getLevel() >= 20) {
                p.giveExpLevels(-20);
                p.setHealth(20);
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 2));
                world.createExplosion(p.getLocation(), 0);
                p.playSound(p.getLocation(), Sound.ENTITY_SILVERFISH_AMBIENT, 15, 1);
                p.sendMessage(Translator.Colors(messages.getConfig().getString("power_activated_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            } else {
                String noMana = Main.getInstance().getConfig().getString("insufficient_mana_message")
                        .replace("%prefix%" , messages.getConfig().getString("prefix"));
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
        }
        // Furtivity Power
        //-------------------------------------------------------------------------------------------
    }
}