package me.pulsi_.magicsticks;

import me.pulsi_.magicsticks.Abilities.AbilitiesShop;
import me.pulsi_.magicsticks.Managers.MessageManager;
import me.pulsi_.magicsticks.Managers.Translator;
import me.pulsi_.magicsticks.Powers.PowersShop;
import me.pulsi_.magicsticks.Creator.CreateStick;
import me.pulsi_.magicsticks.Sticks.Sticks;
import me.pulsi_.magicsticks.Sticks.SticksShop;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        MessageManager message = new MessageManager(player);

        //---------------------------------------------------------------------------------------------------------
        //                                          Stick command
        if (args.length == 0) {
            if (player.isOp()) {
                sender.sendMessage(Translator.Colors("&8&m==================================="));
                sender.sendMessage(Translator.Colors("&6       &lThanks for using this Plugin!"));
                sender.sendMessage(Translator.Colors("&7"));
                sender.sendMessage(Translator.Colors("&7        &lPlugin create by &a&lPulsi_"));
                sender.sendMessage(Translator.Colors("&b           &b&l/Stick help &a&lfor help"));
                sender.sendMessage(Translator.Colors("&8&m==================================="));
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
            } else {
                sender.sendMessage(Translator.Colors("&8&m==================================="));
                sender.sendMessage(Translator.Colors("&8"));
                sender.sendMessage(Translator.Colors("&c&l  (!) &cUsage: &a/MagicSticks Help"));
                sender.sendMessage(Translator.Colors("&8"));
                sender.sendMessage(Translator.Colors("&8&m==================================="));
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
            }
            //                                          Stick command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Help command
        } else if (args[0].equalsIgnoreCase("help")) {
            if (args.length > 1 && args[1].equalsIgnoreCase("1")) {
                sender.sendMessage(Translator.Colors("&8&m================================="));
                sender.sendMessage(Translator.Colors("&5&l        Magic&9&lSticks &a&lHelp 1/2"));
                sender.sendMessage(Translator.Colors("&a"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick &7See the creator of the Plugin"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Help &7See this page"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Shop &7Open the Sticks Shop"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Abilities &7Open the Abilities GUI"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Powers &7Open the Powers GUI"));
                sender.sendMessage(Translator.Colors("&8&m================================="));
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);

            } else if (args.length > 1 && args[1].equalsIgnoreCase("2")) {
                sender.sendMessage(Translator.Colors("&8&m================================="));
                sender.sendMessage(Translator.Colors("&5&l        Magic&9&lSticks &a&lHelp 2/2"));
                sender.sendMessage(Translator.Colors("&a"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Toggle &7Toggle &2on&7/&coff &7the Stick effect"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Reload &7Reload the Plugin"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Create &7Create a Stick"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Give <stick> <player> &7Give to a player a custom Stick"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick List &7See the list of all Sticks"));
                sender.sendMessage(Translator.Colors("&8&m================================="));
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);

            } else {
                sender.sendMessage(Translator.Colors("&8&m================================="));
                sender.sendMessage(Translator.Colors("&5&l        Magic&9&lSticks &a&lHelp 1/2"));
                sender.sendMessage(Translator.Colors("&a"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick &7See the creator of the Plugin"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Help &7See this page"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Shop &7Open the Sticks Shop"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Abilities &7Open the Abilities GUI"));
                sender.sendMessage(Translator.Colors("&8> &a/Stick Powers &7Open the Powers GUI"));
                sender.sendMessage(Translator.Colors("&8&m================================="));
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
            }
            //                                          Help command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          List command
        } else if (args[0].equalsIgnoreCase("list")) {
            if (player.hasPermission("magicsticks.list")) {
                sender.sendMessage(Translator.Colors("&8&m================================="));
                sender.sendMessage(Translator.Colors("&5&l        Magic&9&lSticks &a&lSticks list"));
                sender.sendMessage(Translator.Colors("&a"));
                sender.sendMessage(Translator.Colors("&8> &aFireBallStick"));
                sender.sendMessage(Translator.Colors("&8> &aWitherStick"));
                sender.sendMessage(Translator.Colors("&8> &aIceStick"));
                sender.sendMessage(Translator.Colors("&8> &aElectricStick"));
                sender.sendMessage(Translator.Colors("&8> &aBridgeStick"));
                sender.sendMessage(Translator.Colors("&8&m================================="));
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 1, 1);
            } else {
                message.noPermissions();
            }
            //                                          List command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Give command
        } else if (args[0].equalsIgnoreCase("give")) {
            if (!(player.hasPermission("magicsticks.give"))) {
                message.noPermissions();
            } else if (args.length > 1 && args[1].equalsIgnoreCase("FireBallStick")) {
                player.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou have received the &cFireBall &aStick!"));   // FireBallStick
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);              // FireBallStick
                player.getInventory().addItem(Sticks.getFireBallStick());                                            // FireBallStick
            } else if (args.length > 1 && args[1].equalsIgnoreCase("WitherStick")) {
                player.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou have received the &8Wither &3Stick&a!"));    // WitherStick
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);               // WitherStick
                player.getInventory().addItem(Sticks.getWitherStick());                                               // WitherStick
            } else if (args.length > 1 && args[1].equalsIgnoreCase("IceStick")) {
                player.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou have received the &3Ice &9Stick&a!"));    // IceStick
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);            // IceStick
                player.getInventory().addItem(Sticks.getIceStick());                                               // IceStick
            } else if (args.length > 1 && args[1].equalsIgnoreCase("ElectricStick")) {
                player.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou have received the &3Ice &9Stick&a!"));    // ElectricStick
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);            // ElectricStick
                player.getInventory().addItem(Sticks.getElectricStick());                                          // ElectricStick
            } else {
                message.unknownStick();
            }
            //                                      Give command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Reload command
        } else if (args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("magicsticks.reload")) {
                MagicSticks.getInstance().reloadConfig();
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);
                message.reloadMessage();
            } else {
                message.noPermissions();
            }
            //                                      Reload command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Shop command
        } else if (args[0].equalsIgnoreCase("shop")) {
            if (player.hasPermission("magicsticks.shop")) {
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                SticksShop gui = new SticksShop(player);
                gui.openShop();
            } else {
                message.noPermissions();
            }
            //                                      Shop command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Abilities command
        } else if (args[0].equalsIgnoreCase("abilities")) {
            if (player.hasPermission("magicsticks.abilities")) {
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                AbilitiesShop gui = new AbilitiesShop(player);
                gui.openAbilities();
            } else {
                message.noPermissions();
            }
            //                                      Abilities command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Powers command
        } else if (args[0].equalsIgnoreCase("powers")) {
            if (player.hasPermission("magicsticks.powers")) {
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                PowersShop gui = new PowersShop(player);
                gui.openPowers();
            } else {
                message.noPermissions();
            }
            //                                      Powers command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Create command
        } else if (args[0].equalsIgnoreCase("create")) {
            if (player.hasPermission("magicsticks.create")) {
                player.playSound(player.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                CreateStick gui = new CreateStick(player);
                gui.openCreator();
            } else {
                message.noPermissions();
            }
            //                                      Create command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------------
            // Unknown Command
        } else {
            message.unknownCommand();
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
            // Unknown Command
            //---------------------------------------------------------------------------------------------------------------
        }
        return true;
    }
}
