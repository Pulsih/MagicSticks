package me.pulsi_.magicsticks.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {

    public List<String> args0 = new ArrayList<String>();
    public List<String> args1 = new ArrayList<String>();


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args0.isEmpty()) {
            args0.add("shop");
            args0.add("abilities");
            args0.add("powers");
            args0.add("help");
            args0.add("list");
            args0.add("give");
            args0.add("reload");
            args0.add("create");
            args0.add("ammo");
            args0.add("list");

        } else if (args1.isEmpty()) {
            args1.add("shop");
            args1.add("abilities");
            args1.add("powers");
            args1.add("help");
            args1.add("list");
            args1.add("give");
            args1.add("reload");
            args1.add("create");
            args1.add("ammo");
            args1.add("list");
        }

        List<String> resultArgs0 = new ArrayList<String>();
        if (args.length == 1) {
            for (String a : args0) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    resultArgs0.add(a);
            }
            return resultArgs0;
        }

        List<String> resultArgs1 = new ArrayList<String>();
        if (args.length == 2 && args[0].equalsIgnoreCase("info")) {
            for (String a : args1) {
                if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                    resultArgs1.add(a);
            }
            return resultArgs1;
        }
        return null;
    }
}