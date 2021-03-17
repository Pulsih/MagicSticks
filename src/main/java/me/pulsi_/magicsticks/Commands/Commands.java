package me.pulsi_.magicsticks.Commands;

import me.pulsi_.magicsticks.Abilities.AbilitiesShop;
import me.pulsi_.magicsticks.Ammos.AmmoItems;
import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import me.pulsi_.magicsticks.Powers.PowersShop;
import me.pulsi_.magicsticks.Sticks.Sticks;
import me.pulsi_.magicsticks.Sticks.SticksShop;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {

        ConfigManager messages = new ConfigManager(Main.getInstance(), "messages.yml");
        ConfigManager scoreboard = new ConfigManager(Main.getInstance(), "scoreboard.yml");
        ConfigManager sticks = new ConfigManager(Main.getInstance(), "sticks.yml");
        ConfigManager powers = new ConfigManager(Main.getInstance(), "powers.yml");
        ConfigManager shop = new ConfigManager(Main.getInstance(), "shop.yml");
        ConfigManager ammo = new ConfigManager(Main.getInstance(), "ammo.yml");
        ConfigManager abilities = new ConfigManager(Main.getInstance(), "abilities.yml");


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
            } else {
                s.sendMessage(Translator.Colors("&8&m==================================="));
                s.sendMessage(Translator.Colors(""));
                s.sendMessage(Translator.Colors("&c&l  (!) &cUsage: &a/MagicSticks Help"));
                s.sendMessage(Translator.Colors(""));
                s.sendMessage(Translator.Colors("&8&m==================================="));
            }
            //                                          Stick command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Help command
        } else if (args[0].equalsIgnoreCase("help")) {
            if (s.hasPermission("magicsticks.help")) {
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
                }

                } else {
                s.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            }
            //                                          Help command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          List command
        } else if (args[0].equalsIgnoreCase("list")) {
            if (s.hasPermission("magicsticks.list")) {
                s.sendMessage(Translator.Colors("&8&m================================="));
                s.sendMessage(Translator.Colors("&5&l        Magic&9&lSticks &a&lSticks list"));
                s.sendMessage(Translator.Colors("&a"));
                s.sendMessage(Translator.Colors("&8> &aFireBallStick"));
                s.sendMessage(Translator.Colors("&8> &aWitherStick"));
                s.sendMessage(Translator.Colors("&8> &aIceStick"));
                s.sendMessage(Translator.Colors("&8> &aElectricStick"));
                s.sendMessage(Translator.Colors("&8> &aBridgeStick"));
                s.sendMessage(Translator.Colors("&8&m================================="));
            } else {
                s.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            }
            //                                          List command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                          Give command
        } else if (args[0].equalsIgnoreCase("give")) {
            if (s instanceof Player) {
                Player p = (Player) s;
            if (!(s.hasPermission("magicsticks.give"))) {
                s.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
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
                s.sendMessage(Translator.Colors(messages.getConfig().getString("unknown_stick_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            }
            } else {
                s.sendMessage(Translator.Colors("&c&l(!) &fOnly Players can execute this command!"));
            }
            //                                      Give command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Reload command
        } else if (args[0].equalsIgnoreCase("reload")) {
            if (s.hasPermission("magicsticks.reload")) {
                Main.getInstance().reloadConfig();
                scoreboard.reloadConfig();
                messages.reloadConfig();
                powers.reloadConfig();
                sticks.reloadConfig();
                shop.reloadConfig();
                ammo.reloadConfig();
                abilities.reloadConfig();
                s.sendMessage(Translator.Colors(messages.getConfig().getString("reload_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            } else {
                s.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            }
            //                                      Reload command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Shop command
        } else if (args[0].equalsIgnoreCase("shop")) {
            if (s instanceof Player) {
                Player p = (Player) s;
            if (s.hasPermission("magicsticks.shop")) {
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                SticksShop gui = new SticksShop(p);
                gui.openShop();
            } else {
                s.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            }
            } else {
                s.sendMessage(Translator.Colors("&c&l(!) &fOnly Players can execute this command!"));
            }
            //                                      Shop command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Abilities command
        } else if (args[0].equalsIgnoreCase("abilities")) {
            if (s instanceof Player) {
                Player p = (Player) s;
            if (s.hasPermission("magicsticks.abilities")) {
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                AbilitiesShop gui = new AbilitiesShop(p);
                gui.openAbilities();
            } else {
                s.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            }
            } else {
                s.sendMessage(Translator.Colors("&c&l(!) &fOnly Players can execute this command!"));
            }
            //                                      Abilities command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Powers command
        } else if (args[0].equalsIgnoreCase("powers")) {
            if (s instanceof Player) {
                Player p = (Player) s;
            if (s.hasPermission("magicsticks.powers")) {
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_LAUNCH, 2, 1);
                PowersShop gui = new PowersShop(p);
                gui.openPowers();
            } else {
                s.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")
                        .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            }
            } else {
                s.sendMessage(Translator.Colors("&c&l(!) &fOnly Players can execute this command!"));
            }
            //                                      Powers command
            //---------------------------------------------------------------------------------------------------------


            //---------------------------------------------------------------------------------------------------------
            //                                      Ammo command
        } else if (args[0].equalsIgnoreCase("ammo")) {
            if (s instanceof Player) {
                Player p = (Player) s;
                if (p.hasPermission("magicsticks.ammo")) {
                    if (Main.getInstance().getConfig().getBoolean("use_mana")) {
                        p.sendMessage(Translator.Colors("&c&l(!) &aThis command is disabled! Please turn the use_mana to false in the config to use this command!"));

                    } else if (args.length == 2 && args[0].equalsIgnoreCase("ammo") && args[1].equalsIgnoreCase("give")) {
                        p.getInventory().addItem(AmmoItems.ammo());

                    } else if (args.length == 3 && args[0].equalsIgnoreCase("ammo") && args[1].equalsIgnoreCase("give")) {
                        int amount = Integer.parseInt(args[2]);
                        ItemStack ammoItems = new ItemStack(Material.valueOf(String.valueOf(AmmoItems.ammo())), amount);
                        p.getInventory().addItem(ammoItems);

                    } else {
                        p.sendMessage(Translator.Colors(messages.getConfig().getString("ammo_usage")
                                .replace("%prefix%",""+messages.getConfig().getString("prefix"))));
                    }
                } else {
                    s.sendMessage(Translator.Colors(messages.getConfig().getString("nopermission_message")
                            .replace("%prefix%",""+messages.getConfig().getString("prefix"))));
                }
            } else {
                s.sendMessage(Translator.Colors("&c&l(!) &fOnly Players can execute this command!"));
            }
            //                                      Ammo command
            //---------------------------------------------------------------------------------------------------------

            //---------------------------------------------------------------------------------------------------------------
            // Unknown Command
        } else {
            s.sendMessage(Translator.Colors(messages.getConfig().getString("unknown_command")
                    .replace("%prefix%", ""+messages.getConfig().getString("prefix"))));
            // Unknown Command
            //---------------------------------------------------------------------------------------------------------------
        }
        return true;
    }
}