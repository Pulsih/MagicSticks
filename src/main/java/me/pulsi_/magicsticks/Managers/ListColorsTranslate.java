package me.pulsi_.magicsticks.Managers;

import me.pulsi_.magicsticks.MagicSticks;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ListColorsTranslate {

    public ListColorsTranslate(){
    }

    public List<String> colorBoard() {

        ConfigManager scoreboard = new ConfigManager(MagicSticks.getInstance(), "scoreboard.yml");

        List<String> coloredList = new ArrayList<>();
        for ( String colors : scoreboard.getConfig().getStringList( "Scoreboard.List" ))
        {
            coloredList.add( ChatColor.translateAlternateColorCodes('&' , colors ));
        }
        return coloredList;
    }
}
