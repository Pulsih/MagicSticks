package me.pulsi_.magicsticks.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {

    public List<String> arguments = new ArrayList<String>();


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (arguments.isEmpty()) {
            arguments.add("shop");
            arguments.add("abilities");
            arguments.add("powers");
            arguments.add("help");
            arguments.add("list");
            arguments.add("give");
            arguments.add("reload");
            arguments.add("create");
            arguments.add("ammo");
        }

        List<String> result = new ArrayList<String>();
        if (args.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }
            return result;
        }
        return null;
    }
}