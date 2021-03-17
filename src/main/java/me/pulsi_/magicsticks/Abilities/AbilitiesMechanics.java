package me.pulsi_.magicsticks.Abilities;

import me.pulsi_.magicsticks.Main;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AbilitiesMechanics implements Listener {

    @EventHandler
    public void increaseDamage(EntityDamageByEntityEvent e) {
        Player p = (Player) e.getDamager();
        if (!(e.getDamager() instanceof Fireball)) return;
        Fireball f = (Fireball) e.getDamager();
        if (!(f.getShooter() instanceof Player)) return;

        AbilitiesManager am = Main.getSkillManager();
        int skill = am.getSkillLevel(p, Abilities.STRENGTH) - 1;
        double d = e.getDamage() / 100.0D;
        d *= ((Integer)Main.getSkillMultipliers().get(Abilities.STRENGTH)).intValue();
        double finalDamage = skill * d;
        e.setDamage(e.getDamage() + finalDamage);
    }
}