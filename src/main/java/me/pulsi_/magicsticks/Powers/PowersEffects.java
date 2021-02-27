package me.pulsi_.magicsticks.Powers;

import me.pulsi_.magicsticks.MagicSticks;
import me.pulsi_.magicsticks.Managers.MessageManager;
import me.pulsi_.magicsticks.Managers.Translator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PowersEffects implements Listener {

    Map<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void Powers(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if(!e.getAction().name().contains("RIGHT"))return;
        if(!player.isSneaking()) return;
        ItemStack item = e.getItem();

        //List all your custom power items here
        if(item == null) return;
        if(!(item.isSimilar(PowersItems.getTankPower()) || item.isSimilar(PowersItems.getStrikerPower()) || item.isSimilar(PowersItems.getFurtivityPower()))) return;

        if(!this.cooldown.containsKey(player.getUniqueId()) || this.cooldown.get(player.getUniqueId()) <= System.currentTimeMillis()) {
            this.cooldown.put(player.getUniqueId(), System.currentTimeMillis() + (5 * 60 * 1000));

        } else {
            String messageCooldown = MagicSticks.getInstance().getConfig().getString("cooldown_message");
            long timeleft = (this.cooldown.get(player.getUniqueId()) - System.currentTimeMillis());
            player.sendMessage(Translator.Colors(messageCooldown.replace("%timeleft%", (timeleft / 1000) + "")));
            return;
        }

        MessageManager message = new MessageManager(player);

        //-------------------------------------------------------------------------------------------
        // Striker Power
        if(item.isSimilar(PowersItems.getStrikerPower())) {
            if(player.getLevel() >= 20) {
                player.giveExpLevels(-20);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 400, 4));
                player.getWorld().strikeLightning(player.getLocation());
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 5, 1);
                message.powerActivated();
            } else {
                String noMana = MagicSticks.getInstance().getConfig().getString("insufficient_mana_message");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
            // Striker Power
            //-------------------------------------------------------------------------------------------


            //-------------------------------------------------------------------------------------------
            // Tank Power
        }else if (item.isSimilar(PowersItems.getTankPower())) {
            if (player.getLevel() >= 15) {
                player.giveExpLevels(-15);
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 255));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 400, 4));
                world.createExplosion(player.getLocation(), 0);
                player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15, 1);


                message.powerActivated();
            } else {
                String noMana = MagicSticks.getInstance().getConfig().getString("insufficient_mana_message");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
            // Tank Power
            //-------------------------------------------------------------------------------------------


            //-------------------------------------------------------------------------------------------
            // Furtivity Power
        } else if (item.isSimilar(PowersItems.getFurtivityPower())) {
            if (player.getLevel() >= 20) {
                player.giveExpLevels(-20);
                player.setHealth(20);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 2));
                world.createExplosion(player.getLocation(), 0);
                player.playSound(player.getLocation(), Sound.ENTITY_SILVERFISH_AMBIENT, 15, 1);
                message.powerActivated();
            } else {
                String noMana = MagicSticks.getInstance().getConfig().getString("insufficient_mana_message");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
        }
        // Furtivity Power
        //-------------------------------------------------------------------------------------------
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        ItemStack item = e.getItemInHand();
        if (item.isSimilar(PowersItems.getTankPower())) {
            e.setCancelled(true);
        }
    }
}
