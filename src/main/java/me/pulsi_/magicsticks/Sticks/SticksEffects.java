package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.MagicSticks;
import me.pulsi_.magicsticks.Managers.Translator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;


public class SticksEffects implements Listener {

    @EventHandler
    public static void SticksPowers(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Material materialHand = player.getInventory().getItemInMainHand().getType();
        if (materialHand == Material.STICK) {
            ItemStack item = e.getItem();
            if(item == null) return;

            //-------------------------------------------------------------------------------------------
            // FireBall Power
            if (item.isSimilar(Sticks.getFireBallStick())) {
                if (player.getLevel() >= 1) {
                    Fireball fireball = player.getPlayer().launchProjectile(Fireball.class);
                    fireball.setVelocity(fireball.getDirection().multiply(20.0));
                    player.giveExpLevels(-1);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 2, 2);
                } else {
                    String noMana = MagicSticks.getInstance().getConfig().getString("insufficient_mana_message");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
                }
                // FireBall Power
                //-------------------------------------------------------------------------------------------

                //-------------------------------------------------------------------------------------------
                // Wither Power
            } else if (item.isSimilar(Sticks.getWitherStick())) {
                if (player.getLevel() >= 1) {
                    WitherSkull wither = player.getPlayer().launchProjectile(WitherSkull.class);
                    wither.setVelocity(wither.getDirection().multiply(20.0));
                    player.giveExpLevels(-1);
                    player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 2, 2);
                } else {
                    String noMana = MagicSticks.getInstance().getConfig().getString("insufficient_mana_message");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
                }
                // Wither Power
                //-------------------------------------------------------------------------------------------

                //-------------------------------------------------------------------------------------------
                // Electric Power
            } else if (item.isSimilar(Sticks.getElectricStick())) {
                if (player.getLevel() >= 1) {
                    player.getWorld().strikeLightning(player.getCompassTarget());
                    player.playSound(player.getLocation(), Sound.BLOCK_STONE_BREAK, 2, 2);
                } else {
                    String noMana = MagicSticks.getInstance().getConfig().getString("insufficient_mana_message");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
                }
                // Electric Power
                //-------------------------------------------------------------------------------------------

                //-------------------------------------------------------------------------------------------
                // Ice Power
            } else if (item.isSimilar(Sticks.getIceStick())) {
                if (player.getLevel() >= 1) {
                    player.launchProjectile(Snowball.class);
                    player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 2, 2);
                } else {
                    String noMana = MagicSticks.getInstance().getConfig().getString("insufficient_mana_message");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Translator.Colors(noMana)));
                }
                // Ice Power
                //-------------------------------------------------------------------------------------------

                //-------------------------------------------------------------------------------------------
                // Bridge Power
            } else if (item.isSimilar(Sticks.getBridgeStick())) {
                if (player.getLevel() >= 1) {
                    player.giveExpLevels(-1);
                    player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 2, 1);

                    Location loc1 = player.getLocation().add(0, -1, 0);
                    Location loc2 = player.getLocation().add(1, -1, 0);
                    Location loc3 = player.getLocation().add(-1, -1, 0);
                    Location loc4 = player.getLocation().add(0, -1, 1);
                    Location loc5 = player.getLocation().add(0, -1, -1);

                    List<Location> locations = Arrays.asList(loc1,loc2,loc3,loc4,loc5);
                    for(Location loc : locations) {
                        Block block = loc.getBlock();
                        if(block.getType() == Material.GREEN_STAINED_GLASS) continue;
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
                        }).runTaskLater(MagicSticks.getInstance(), 40);
                    }

                    // Bridge Power
                    //-------------------------------------------------------------------------------------------
                }
            }
        }
    }

    @EventHandler
    public static void SticksDamages(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Snowball) {
            Snowball snowball = (Snowball) event.getDamager();
            if (snowball.getShooter() instanceof Player) {
                Player shooter = (Player) event.getDamager();
                String displayName = shooter.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                if (displayName.equalsIgnoreCase(Sticks.getIceStick().getItemMeta().getDisplayName())) {
                    event.setDamage(7.0);
                }
            }
        }
    }
}
