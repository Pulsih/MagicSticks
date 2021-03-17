package me.pulsi_.magicsticks.Abilities;

import me.pulsi_.magicsticks.Main;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class AbilitiesManager {

    public int getSkillLevel(Player p, Abilities ability) {
        File l = new File(Main.getInstance().getDataFolder() + File.separator + "data.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(l);
        if (yaml.contains(p.getUniqueId() + "." + ability.toString()))
            return yaml.getInt(p.getUniqueId() + "." + ability.toString());
        return 1;
    }

    public int getSkillPoints(Player p) {
        File l = new File(Main.getInstance().getDataFolder() + File.separator + "data.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(l);
        if (yaml.contains(p.getUniqueId() + ".points"))
            return yaml.getInt(p.getUniqueId() + ".points");
        return 0;
    }

    public int getTotalPointsSpent(Player p) {
        int points = getSkillPoints(p);
        int damage = getSkillLevel(p, Abilities.STRENGTH) - 1;
        int speed = getSkillLevel(p, Abilities.SPEED) - 1;
        int resistance = getSkillLevel(p, Abilities.RESISTANCE) - 1;
        int healthboost = getSkillLevel(p, Abilities.HEALTHBOOST) - 1;
        int total = points + damage + healthboost + resistance + speed;
        return total;
    }

    public void setSkillPoints(Player player, int points) {
        File l = new File(Main.getInstance().getDataFolder() + File.separator + "data.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(l);
        yaml.set(player.getUniqueId() + ".points", Integer.valueOf(points));
        try {
            yaml.save(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSkillLevel(Player player, Abilities ability, int level) {
        File l = new File(Main.getInstance().getDataFolder() + File.separator + "data.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(l);
        yaml.set(player.getUniqueId() + "." + ability.toString(), Integer.valueOf(level));
        try {
            yaml.save(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSkillLevel(OfflinePlayer player, Abilities ability) {
        if (!player.hasPlayedBefore())
            return 1;
        File l = new File(Main.getInstance().getDataFolder() + File.separator + "data.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(l);
        if (yaml.contains(player.getUniqueId() + "." + ability.toString()))
            return yaml.getInt(player.getUniqueId() + "." + ability.toString());
        return 1;
    }

    public int getSkillPoints(OfflinePlayer player) {
        if (!player.hasPlayedBefore())
            return 0;
        File l = new File(Main.getInstance().getDataFolder() + File.separator + "data.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(l);
        if (yaml.contains(player.getUniqueId() + ".points"))
            return yaml.getInt(player.getUniqueId() + ".points");
        return 0;
    }

    public int getTotalPointsSpent(OfflinePlayer p) {
        if (!p.hasPlayedBefore())
            return 0;
        int points = getSkillPoints(p);
        int damage = getSkillLevel(p, Abilities.STRENGTH) - 1;
        int speed = getSkillLevel(p, Abilities.SPEED) - 1;
        int resistance = getSkillLevel(p, Abilities.RESISTANCE) - 1;
        int healthboost = getSkillLevel(p, Abilities.HEALTHBOOST) - 1;
        int total = points + damage + speed + resistance + healthboost;
        return total;
    }

    public void setSkillPoints(OfflinePlayer player, int points) {
        File l = new File(Main.getInstance().getDataFolder() + File.separator + "data.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(l);
        yaml.set(player.getUniqueId() + ".points", Integer.valueOf(points));
        try {
            yaml.save(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSkillLevel(OfflinePlayer player, Abilities ability, int level) {
        File l = new File(Main.getInstance().getDataFolder() + File.separator + "data.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(l);
        yaml.set(player.getUniqueId() + "." + ability.toString(), Integer.valueOf(level));
        try {
            yaml.save(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMaximumLevel(Abilities ability) {
        return Main.getInstance().getConfig().getInt("skills." + ability.toString().toLowerCase() + ".max-level");
    }
}