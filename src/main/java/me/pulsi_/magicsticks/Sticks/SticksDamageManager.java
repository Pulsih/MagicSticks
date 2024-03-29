package me.pulsi_.magicsticks.Sticks;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SticksDamageManager implements Listener {

    @EventHandler
    public static void fireballDamage(EntityDamageByEntityEvent e) {

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

        if (e.getEntity() instanceof Player) {
            if (!(e.getDamager() instanceof Fireball)) return;
            Fireball f = (Fireball) e.getDamager();
            if (!(f.getShooter() instanceof Player)) return;
            Player shooter = (Player) f.getShooter();
            if (shooter.getInventory().getItemInHand().isSimilar(Sticks.fireballstick())) {

                int damage = configSticks.getConfig().getInt("Sticks.fireballstick.damage");

                e.setDamage(damage);
            }
        } else {
            if (!(e.getDamager() instanceof Snowball)) return;
            Snowball s = (Snowball) e.getDamager();
            if (!(s.getShooter() instanceof Player)) return;
            Player shooter = (Player) s.getShooter();
            if (shooter.getInventory().getItemInHand().isSimilar(Sticks.fireballstick())) {

                int damage = configSticks.getConfig().getInt("Sticks.fireballstick.damage");

                e.setDamage(damage);
            }
        }
    }

    @EventHandler
    public static void witherDamage(EntityDamageByEntityEvent e) {

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

        if (e.getEntity() instanceof Player) {
            if (!(e.getDamager() instanceof WitherSkull)) return;
            WitherSkull s = (WitherSkull) e.getDamager();
            if (!(s.getShooter() instanceof Player)) return;
            Player shooter = (Player) s.getShooter();
            if (shooter.getInventory().getItemInHand().isSimilar(Sticks.witherstick())) {

                int damage = configSticks.getConfig().getInt("Sticks.witherstick.damage");

                e.setDamage(damage);
            }
        } else {
            if (!(e.getDamager() instanceof Snowball)) return;
            Snowball s = (Snowball) e.getDamager();
            if (!(s.getShooter() instanceof Player)) return;
            Player shooter = (Player) s.getShooter();
            if (shooter.getInventory().getItemInHand().isSimilar(Sticks.witherstick())) {

                int damage = configSticks.getConfig().getInt("Sticks.witherstick.damage");

                e.setDamage(damage);
            }
        }
    }

    @EventHandler
    public static void iceDamage(EntityDamageByEntityEvent e) {

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

        if (e.getEntity() instanceof Player) {
            if (!(e.getDamager() instanceof Snowball)) return;
            Snowball s = (Snowball) e.getDamager();
            if (!(s.getShooter() instanceof Player)) return;
            Player shooter = (Player) s.getShooter();
            if (shooter.getInventory().getItemInHand().isSimilar(Sticks.icestick())) {

                int damage = configSticks.getConfig().getInt("Sticks.icestick.damage");

                e.setDamage(damage);
                ((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
            }
        } else {
            if (!(e.getDamager() instanceof Snowball)) return;
            Snowball s = (Snowball) e.getDamager();
            if (!(s.getShooter() instanceof Player)) return;
            Player shooter = (Player) s.getShooter();
            if (shooter.getInventory().getItemInHand().isSimilar(Sticks.icestick())) {

                int damage = configSticks.getConfig().getInt("Sticks.icestick.damage");

                e.setDamage(damage);
            }
        }
    }

    @EventHandler
    public static void electricDamage(EntityDamageByEntityEvent e) {

        ConfigManager configSticks = new ConfigManager(Main.getInstance(), "sticks.yml");

        if (e.getEntity() instanceof Player) {
            if (!(e.getDamager() instanceof Snowball)) return;
            Snowball s = (Snowball) e.getDamager();
            if (!(s.getShooter() instanceof Player)) return;
            Player shooter = (Player) s.getShooter();
            if (shooter.getInventory().getItemInHand().isSimilar(Sticks.electricstick())) {

                int damage = configSticks.getConfig().getInt("Sticks.electricstick.damage");

                e.setDamage(damage);
                s.getLocation().getWorld().strikeLightning(s.getLocation());
            }
        } else {
            if (!(e.getDamager() instanceof Snowball)) return;
            Snowball s = (Snowball) e.getDamager();
            if (!(s.getShooter() instanceof Player)) return;
            Player shooter = (Player) s.getShooter();
            if (shooter.getInventory().getItemInHand().isSimilar(Sticks.electricstick())) {

                int damage = configSticks.getConfig().getInt("Sticks.electricstick.damage");

                e.setDamage(damage);
                s.getLocation().getWorld().strikeLightning(s.getLocation());
            }
        }
    }
}