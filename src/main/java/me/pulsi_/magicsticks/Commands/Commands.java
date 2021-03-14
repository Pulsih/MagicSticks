package me.pulsi_.magicsticks.Commands;

import me.pulsi_.magicsticks.Abilities.AbilitiesShop;
import me.pulsi_.magicsticks.Ammos.AmmoItems;
import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.MessageManager;
import me.pulsi_.magicsticks.Managers.Translator;
import me.pulsi_.magicsticks.Powers.PowersShop;
import me.pulsi_.magicsticks.Creator.CreateStick;
import me.pulsi_.magicsticks.Sticks.Sticks;
import me.pulsi_.magicsticks.Sticks.SticksShop;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    public Integer parseInt(String s) {
        try {
            return Integer.parseInt(s);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
        Player p = (Player) s;

        MessageManager message = new MessageManager(p);

        //---------------------------------------------------------------------------------------------------------
        //                                          Stick command
        if (args.length == 0) {
            if (s.isOp()) {
                s.sendMessage(Translator.Colors("&8&m==================================="));
                s.sendMessage(Translator.Colors("&6       &lThanks for using this Plugin!"));
                s.sendMessage(Translator.Colors(""));
                s.sendMessage(Translator.Colors("&7        &lPlugin create by &a&lPulsi_"));
                s.sendMessage(Translator.Colors("&b           &b&l/Stick help &a&lfor help"));
                s.sendMessage(Translator.Colors("&8&m==================================="));
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
            } else {
                s.sendMessage(Translator.Colors("&8&m==================================="));
                s.sendMessage(Translator.Colors(""));
                s.sendMessage(Translator.Colors("&c&l  (!) &cUsage: &a/MagicSticks Help"));
                s.sendMessage(Translator.Colors(""));
                s.sendMessage(Translator.Colors("&8&m==================================="));
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
            }
            //                                          Stick command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Help command
        } else if (args[0].equalsIgnoreCase("help")) {
            if (args.length > 1 && args[1].equalsIgnoreCase("1")) {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l        Magic&9&lSticks &a&lHelp 1/2"));
                s.sendMessage(Translator.Colors(""));
                s.sendMessage(Translator.Colors("&8> &a/Stick &7See the creator of the Plugin"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Help &7See this page"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Shop &7Open the Sticks Shop"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Abilities &7Open the Abilities GUI"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Powers &7Open the Powers GUI"));
                s.sendMessage(Translator.Colors("&8&m================================="));
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);

            } else if (args.length > 1 && args[1].equalsIgnoreCase("2")) {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l        Magic&9&lSticks &a&lHelp 2/2"));
                s.sendMessage(Translator.Colors(""));
                s.sendMessage(Translator.Colors("&8> &a/Stick Ammo <number> &7Give an amount of Ammo"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Reload &7Reload the Plugin"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Create &7Create a Stick"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Give <stick> <player> &7Give to a player a custom Stick"));
                s.sendMessage(Translator.Colors("&8> &a/Stick List &7See the list of all Sticks"));
                s.sendMessage(Translator.Colors("&8&m================================="));
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);

            } else {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l        Magic&9&lSticks &a&lHelp 1/2"));
                s.sendMessage(Translator.Colors("&a"));
                s.sendMessage(Translator.Colors("&8> &a/Stick &7See the creator of the Plugin"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Help &7See this page"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Shop &7Open the Sticks Shop"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Abilities &7Open the Abilities GUI"));
                s.sendMessage(Translator.Colors("&8> &a/Stick Powers &7Open the Powers GUI"));
                s.sendMessage(Translator.Colors("&8&m================================="));
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
            }
            //                                          Help command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          List command
        } else if (args[0].equalsIgnoreCase("list")) {
            if (p.hasPermission("magicsticks.list")) {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l        Magic&9&lSticks &a&lSticks list"));
                s.sendMessage(Translator.Colors("&a"));
                s.sendMessage(Translator.Colors("&8> &aFireBallStick"));
                s.sendMessage(Translator.Colors("&8> &aWitherStick"));
                s.sendMessage(Translator.Colors("&8> &aIceStick"));
                s.sendMessage(Translator.Colors("&8> &aElectricStick"));
                s.sendMessage(Translator.Colors("&8> &aBridgeStick"));
                s.sendMessage(Translator.Colors("&8&m================================="));
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 1, 1);
            } else {
                message.noPermissions();
            }
            //                                          List command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Give command
        } else if (args[0].equalsIgnoreCase("give")) {
            if (!(p.hasPermission("magicsticks.give"))) {
                message.noPermissions();
            } else if (args.length > 1 && args[1].equalsIgnoreCase("FireBallStick")) {
                p.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou have received the &cFireBall &aStick!"));   // FireBallStick
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);              // FireBallStick
                p.getInventory().addItem(Sticks.fireballstick());                                            // FireBallStick
            } else if (args.length > 1 && args[1].equalsIgnoreCase("WitherStick")) {
                p.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou have received the &8Wither &3Stick&a!"));    // WitherStick
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);               // WitherStick
                p.getInventory().addItem(Sticks.witherstick());                                               // WitherStick
            } else if (args.length > 1 && args[1].equalsIgnoreCase("IceStick")) {
                p.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou have received the &3Ice &9Stick&a!"));    // IceStick
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);            // IceStick
                p.getInventory().addItem(Sticks.icestick());                                               // IceStick
            } else if (args.length > 1 && args[1].equalsIgnoreCase("ElectricStick")) {
                p.sendMessage(Translator.Colors("&2&lSUCCESS! &aYou have received the &3Ice &9Stick&a!"));    // ElectricStick
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 1);            // ElectricStick
                p.getInventory().addItem(Sticks.electricstick());                                          // ElectricStick
            } else {
                message.unknownStick();
            }
            //                                      Give command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Reload command
        } else if (args[0].equalsIgnoreCase("reload")) {
            if (s.hasPermission("magicsticks.reload")) {
                Main.getInstance().reloadConfig();
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 2, 1);
                message.reloadMessage();
            } else {
                message.noPermissions();
            }
            //                                      Reload command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Shop command
        } else if (args[0].equalsIgnoreCase("shop")) {
            if (p.hasPermission("magicsticks.shop")) {
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                SticksShop gui = new SticksShop(p);
                gui.openShop();
            } else {
                message.noPermissions();
            }
            //                                      Shop command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Abilities command
        } else if (args[0].equalsIgnoreCase("abilities")) {
            if (p.hasPermission("magicsticks.abilities")) {
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                AbilitiesShop gui = new AbilitiesShop(p);
                gui.openAbilities();
            } else {
                message.noPermissions();
            }
            //                                      Abilities command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Powers command
        } else if (args[0].equalsIgnoreCase("powers")) {
            if (p.hasPermission("magicsticks.powers")) {
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                PowersShop gui = new PowersShop(p);
                gui.openPowers();
            } else {
                message.noPermissions();
            }
            //                                      Powers command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Ammo command
        } else if (args[0].equalsIgnoreCase("ammo")) {
            if (!p.hasPermission("magicsticks.ammo")) {
                message.noPermissions();
            } else if (args.length == 2 && args[0].equalsIgnoreCase("ammo") && args[1].equalsIgnoreCase("give")) {
                p.getInventory().addItem(AmmoItems.ammo());
            }
            //                                      Ammo command
            //---------------------------------------------------------------------------------------------------------

            //---------------------------------------------------------------------------------------------------------------
            // Unknown Command
        } else {
            message.unknownCommand();
            p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 2, 2);
            // Unknown Command
            //---------------------------------------------------------------------------------------------------------------
        }
        return true;
    }
}
