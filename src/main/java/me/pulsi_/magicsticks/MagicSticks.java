package me.pulsi_.magicsticks;

import me.pulsi_.magicsticks.Abilities.AbilitiesShopListener;
import me.pulsi_.magicsticks.Mana.ManaRegeneration;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.TabComplete;
import me.pulsi_.magicsticks.Managers.Translator;
import me.pulsi_.magicsticks.Powers.PowersEffects;
import me.pulsi_.magicsticks.Powers.PowersShopListener;
import me.pulsi_.magicsticks.Scoreboard.Scoreboard;
import me.pulsi_.magicsticks.Sticks.SticksEffects;
import me.pulsi_.magicsticks.Sticks.SticksShopListener;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public final class MagicSticks extends JavaPlugin implements Listener {

    ConfigManager scoreboardConfig, messagesConfig, sticksConfig, powersConfig, abilitiesConfig, shopConfig, powersShopConfig, abilitiesShopConfig;

    private static MagicSticks instance;
    public static MagicSticks getInstance() {
        return instance;
    }

    private static Economy econ = null;

    @Override
    public void onEnable() {
        instance = this;

        {
            this.scoreboardConfig = new ConfigManager(this, "scoreboard.yml");
            this.messagesConfig = new ConfigManager(this, "messages.yml");
            this.sticksConfig = new ConfigManager(this, "sticks.yml");
            this.powersConfig = new ConfigManager(this, "powers.yml");
            this.abilitiesConfig = new ConfigManager(this, "abilities.yml");
        }

        this.saveDefaultConfig();

        if (!setupEconomy()) {
            System.out.println(Translator.Colors("&8&m---------------"));
            System.out.println(Translator.Colors("&c"));
            System.out.println(Translator.Colors("&cNo economy Plugin Found!"));
            System.out.println(Translator.Colors("&c"));
            System.out.println(Translator.Colors("&cDisabling &5Magic&9Sticks&c!"));
            System.out.println(Translator.Colors("&c"));
            System.out.println(Translator.Colors("&8&m---------------"));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        //------------------------------------------------------------------------------------------------
        //Commands/Listeners

        getCommand("magicsticks").setExecutor(new Commands());
        getCommand("magicsticks").setTabCompleter(new TabComplete());
        getServer().getPluginManager().registerEvents(new AbilitiesShopListener(), this);
        getServer().getPluginManager().registerEvents(new SticksShopListener(), this);
        getServer().getPluginManager().registerEvents(new SticksEffects(), this);
        getServer().getPluginManager().registerEvents(new ManaRegeneration(), this);
        getServer().getPluginManager().registerEvents(new PowersShopListener(), this);
        getServer().getPluginManager().registerEvents(new PowersEffects(), this);
        getServer().getPluginManager().registerEvents(new Scoreboard(), this);

        //Commands/Listeners
        //------------------------------------------------------------------------------------------------

        //------------------------------------------------------------------------------------------------
        // The Console message for Start
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8&m---------------"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("  &5Magic&9Sticks"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors(" &2Plugin enabled!"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8&m---------------"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
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
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8&m---------------"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("   &5Magic&9Sticks"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors(" &cDisabling Plugin"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8"));
        getServer().getConsoleSender().sendMessage(Translator.Colors("&8&m---------------"));
        // The Console message for ShutDown
        //------------------------------------------------------------------------------------------------
    }
}
