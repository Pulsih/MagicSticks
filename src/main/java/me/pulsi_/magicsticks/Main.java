package me.pulsi_.magicsticks;

import me.pulsi_.magicsticks.Abilities.Abilities;
import me.pulsi_.magicsticks.Abilities.AbilitiesManager;
import me.pulsi_.magicsticks.Abilities.AbilitiesShopListener;
import me.pulsi_.magicsticks.Ammos.AmmoPowersMechanics;
import me.pulsi_.magicsticks.Ammos.AmmoSticksMechanics;
import me.pulsi_.magicsticks.Commands.Commands;
import me.pulsi_.magicsticks.Commands.TabComplete;
import me.pulsi_.magicsticks.KillsEvent.Mobs;
import me.pulsi_.magicsticks.KillsEvent.Players;
import me.pulsi_.magicsticks.Mana.ManaRegeneration;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import me.pulsi_.magicsticks.Powers.PowersDrop;
import me.pulsi_.magicsticks.Powers.PowersEffects;
import me.pulsi_.magicsticks.Powers.PowersPickup;
import me.pulsi_.magicsticks.Powers.PowersShopListener;
import me.pulsi_.magicsticks.Scoreboard.Scoreboard;
import me.pulsi_.magicsticks.Security.DisableFireballExplosion;
import me.pulsi_.magicsticks.Security.DisablePowersPlace;
import me.pulsi_.magicsticks.Security.DisableSticksPlace;
import me.pulsi_.magicsticks.Security.DisableWitherSkullExplosion;
import me.pulsi_.magicsticks.Sticks.SticksDamageManager;
import me.pulsi_.magicsticks.Sticks.SticksEffects;
import me.pulsi_.magicsticks.Sticks.SticksShopListener;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;


public final class Main extends JavaPlugin implements Listener {

    ConfigManager scoreboardConfig, messagesConfig, sticksConfig, powersConfig, abilitiesConfig, shopConfig, powersShopConfig, abilitiesShopConfig, ammoConfig;

    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    private static Economy econ = null;

    @Override
    public void onEnable() {
        instance = this;

        {
            this.scoreboardConfig = new ConfigManager(this, "scoreboard.yml");
            this.ammoConfig = new ConfigManager(this, "ammo.yml");
            this.messagesConfig = new ConfigManager(this, "messages.yml");
            this.sticksConfig = new ConfigManager(this, "sticks.yml");
            this.powersConfig = new ConfigManager(this, "powers.yml");
            this.abilitiesConfig = new ConfigManager(this, "abilities.yml");
            this.shopConfig = new ConfigManager(this, "shop.yml");
            this.abilitiesShopConfig = new ConfigManager(this, "abilities.yml");
            this.powersShopConfig = new ConfigManager(this, "powers.yml");
        }

        this.saveDefaultConfig();

        if (!setupEconomy()) {
            getServer().getConsoleSender().sendMessage(Translator.Colors(""));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l  __  __             _       _____ _   _      _        "));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l |  \\/  |           (_)     / ____| | (_)    | |       "));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l | \\  / | __ _  __ _ _  ___| (___ | |_ _  ___| | _____ "));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l | |\\/| |/ _` |/ _` | |/ __|\\___ \\| __| |/ __| |/ / __|"));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l | |  | | (_| | (_| | | (__ ____) | |_| | (__|   <\\__ \\"));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l |_|  |_|\\__,_|\\__, |_|\\___|_____/ \\__|_|\\___|_|\\_\\___/"));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l                __/ |                                  "));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l               |___/                                   "));
            getServer().getConsoleSender().sendMessage(Translator.Colors(""));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&2&lEnabling Plugin!"));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&fLoading Files..."));
            getServer().getConsoleSender().sendMessage(Translator.Colors("&4FAILED! &cThe plugin has not detected any economy Plugins!"));
            getServer().getConsoleSender().sendMessage(Translator.Colors(""));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        //------------------------------------------------------------------------------------------------
        //Commands/Listeners

        getCommand("magicsticks").setExecutor(new Commands());
        getCommand("magicsticks").setTabCompleter(new TabComplete());

        getServer().getPluginManager().registerEvents(new AbilitiesShopListener(), this);

        getServer().getPluginManager().registerEvents(new Players(), this);
        getServer().getPluginManager().registerEvents(new Mobs(), this);

        getServer().getPluginManager().registerEvents(new DisableFireballExplosion(), this);
        getServer().getPluginManager().registerEvents(new DisableWitherSkullExplosion(), this);

        getServer().getPluginManager().registerEvents(new AmmoSticksMechanics(), this);
        getServer().getPluginManager().registerEvents(new AmmoPowersMechanics(), this);

        getServer().getPluginManager().registerEvents(new SticksShopListener(), this);
        getServer().getPluginManager().registerEvents(new SticksEffects(), this);
        getServer().getPluginManager().registerEvents(new SticksDamageManager(), this);

        getServer().getPluginManager().registerEvents(new ManaRegeneration(), this);

        getServer().getPluginManager().registerEvents(new PowersShopListener(), this);
        getServer().getPluginManager().registerEvents(new PowersEffects(), this);
        getServer().getPluginManager().registerEvents(new PowersPickup(), this);
        getServer().getPluginManager().registerEvents(new PowersDrop(), this);

        getServer().getPluginManager().registerEvents(new Scoreboard(), this);

        getServer().getPluginManager().registerEvents(new DisablePowersPlace(), this);
        getServer().getPluginManager().registerEvents(new DisableSticksPlace(), this);

        //Commands/Listeners
        //------------------------------------------------------------------------------------------------

        //------------------------------------------------------------------------------------------------
        // The Console message for Start
        getServer().getConsoleSender().sendMessage(Translator.Colors(""));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l  __  __             _       _____ _   _      _        "));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l |  \\/  |           (_)     / ____| | (_)    | |       "));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l | \\  / | __ _  __ _ _  ___| (___ | |_ _  ___| | _____ "));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l | |\\/| |/ _` |/ _` | |/ __|\\___ \\| __| |/ __| |/ / __|"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l | |  | | (_| | (_| | | (__ ____) | |_| | (__|   <\\__ \\"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l |_|  |_|\\__,_|\\__, |_|\\___|_____/ \\__|_|\\___|_|\\_\\___/"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l                __/ |                                  "));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l               |___/                                   "));
        getServer().getConsoleSender().sendMessage(Translator.Colors(""));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&2&lEnabling Plugin!"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&fLoading Files..."));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&2SUCCESS! &fYou are running the &9v%version% &fof this Plugin!")
                .replace("%version%", ""+this.getDescription().getVersion()));
        getServer().getConsoleSender().sendMessage(Translator.Colors(""));
        // The Console message for Start
        //------------------------------------------------------------------------------------------------

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {

        return econ;
    }

    @Override
    public void onDisable() {
        instance = this;


        //------------------------------------------------------------------------------------------------
        // The Console message for ShutDown
        getServer().getConsoleSender().sendMessage(Translator.Colors(""));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l  __  __             _       _____ _   _      _        "));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l |  \\/  |           (_)     / ____| | (_)    | |       "));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l | \\  / | __ _  __ _ _  ___| (___ | |_ _  ___| | _____ "));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l | |\\/| |/ _` |/ _` | |/ __|\\___ \\| __| |/ __| |/ / __|"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l | |  | | (_| | (_| | | (__ ____) | |_| | (__|   <\\__ \\"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l |_|  |_|\\__,_|\\__, |_|\\___|_____/ \\__|_|\\___|_|\\_\\___/"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l                __/ |                                  "));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&a&l               |___/                                   "));
        getServer().getConsoleSender().sendMessage(Translator.Colors(""));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&c&lDisabling Plugin!"));
        getServer().getConsoleSender().sendMessage(Translator.Colors(""));
        // The Console message for ShutDown
        //------------------------------------------------------------------------------------------------
    }

    public static HashMap<Abilities, Integer> getSkillMultipliers() {
        return getSkillMultipliers();
    }

    public static AbilitiesManager getSkillManager() {
        return getSkillManager();
    }
}