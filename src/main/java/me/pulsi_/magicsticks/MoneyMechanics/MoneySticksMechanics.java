package me.pulsi_.magicsticks.MoneyMechanics;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import me.pulsi_.magicsticks.Sticks.Sticks;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;

public class MoneySticksMechanics implements Listener {

    @EventHandler
    public static void SticksPowers(PlayerInteractEvent e) {
        if (!(Main.getInstance().getConfig().getString("shoot_selector").contains("MONEY"))) return;
        Player p = e.getPlayer();
        ItemStack item = e.getItem();
        if (item == null) return;

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");
        ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");
        Economy econ = Main.getEconomy();

        //-------------------------------------------------------------------------------------------
        // FireBall Power
        if (item.isSimilar(Sticks.fireballstick())) {
            if (econ.getBalance(p) >= configSticks.getConfig().getInt("Sticks.fireballstick.cost")) {
                econ.withdrawPlayer(p, configSticks.getConfig().getInt("Sticks.fireballstick.cost"));
                Fireball fireball = e.getPlayer().launchProjectile(Fireball.class);
                fireball.setVelocity(fireball.getDirection().multiply(20.0));
                p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 2, 2);
            } else {
                String noMana = messages.getConfig().getString("insufficient_mana_message");
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
            // FireBall Power
            //-------------------------------------------------------------------------------------------

            //-------------------------------------------------------------------------------------------
            // Wither Power
        } else if (item.isSimilar(Sticks.witherstick())) {
            if (econ.getBalance(p) >= configSticks.getConfig().getInt("Sticks.witherstick.cost")) {
                econ.withdrawPlayer(p, configSticks.getConfig().getInt("Sticks.witherstick.cost"));
                WitherSkull wither = e.getPlayer().launchProjectile(WitherSkull.class);
                wither.setVelocity(wither.getDirection().multiply(20.0));
                p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SHOOT, 2, 2);
            } else {
                String noMana = messages.getConfig().getString("insufficient_mana_message");
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
            // Wither Power
            //-------------------------------------------------------------------------------------------

            //-------------------------------------------------------------------------------------------
            // Electric Power
        } else if (item.isSimilar(Sticks.electricstick())) {
            if (econ.getBalance(p) >= configSticks.getConfig().getInt("Sticks.icestick.cost")) {
                econ.withdrawPlayer(p, configSticks.getConfig().getInt("Sticks.icestick.cost"));
                e.getPlayer().launchProjectile(Snowball.class);
                p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 5, 2);
            } else {
                String noMana = messages.getConfig().getString("insufficient_mana_message");
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
            // Electric Power
            //-------------------------------------------------------------------------------------------

            //-------------------------------------------------------------------------------------------
            // Ice Power
        } else if (item.isSimilar(Sticks.icestick())) {
            if (econ.getBalance(p) >= configSticks.getConfig().getInt("Sticks.electricstick.cost")) {
                econ.withdrawPlayer(p, configSticks.getConfig().getInt("Sticks.electricstick.cost"));
                p.launchProjectile(Snowball.class);
                p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 2, 2);
            } else {
                String noMana = messages.getConfig().getString("insufficient_mana_message");
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
            // Ice Power
            //-------------------------------------------------------------------------------------------

            //-------------------------------------------------------------------------------------------
            // Bridge Power
        } else if (item.isSimilar(Sticks.bridgestick())) {
            if (econ.getBalance(p) >= configSticks.getConfig().getInt("Sticks.bridgestick.cost")) {
                econ.withdrawPlayer(p, configSticks.getConfig().getInt("Sticks.bridgestick.cost"));
                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 2, 1);

                Location loc1 = p.getLocation().add(0, -1, 0);
                Location loc2 = p.getLocation().add(1, -1, 0);
                Location loc3 = p.getLocation().add(-1, -1, 0);
                Location loc4 = p.getLocation().add(0, -1, 1);
                Location loc5 = p.getLocation().add(0, -1, -1);

                List<Location> locations = Arrays.asList(loc1, loc2, loc3, loc4, loc5);
                for (Location loc : locations) {
                    Block block = loc.getBlock();
                    if (block.getType() == Material.GREEN_STAINED_GLASS) continue;
                    BlockState old = block.getState();
                    block.setType(Material.GREEN_STAINED_GLASS);
                    (new BukkitRunnable() {
                        @Override
                        public void run() {
                            BlockState state = block.getState();
                            state.setType(old.getType());
                            state.setData(old.getData());
                            state.update(true);
                        }
                    }).runTaskLater(Main.getInstance(), 40);
                }

                // Bridge Power
                //-------------------------------------------------------------------------------------------
            } else {
                String noMana = messages.getConfig().getString("insufficient_mana_message");
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
            }
        }
    }

    @EventHandler
    public static void icePower(EntityDamageByEntityEvent e) {
        if (!(e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE)) return;
        if (!(e.getCause().equals(Snowball.class))) return;
        if (!(e.getDamager() instanceof Player)) return;
        ((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 2));
    }
}