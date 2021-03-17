package me.pulsi_.magicsticks.Scoreboard;

import me.pulsi_.magicsticks.Main;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class Scoreboard implements Listener {

    ConfigManager scoreboard = new ConfigManager(Main.getInstance(), "scoreboard.yml");

    private final Map<UUID, FastBoard> boards = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!Main.getInstance().getConfig().getBoolean("use_scoreboard")) return;

        String delay = scoreboard.getConfig().getString("Scoreboard.delay");

        Player player = e.getPlayer();
        FastBoard board = new FastBoard(player);
        boards.put(player.getUniqueId(), board);

        new BukkitRunnable() {
            public void run() {
                updateBoard(board);
            }
        }.runTaskTimer(Main.getInstance(), 0, Long.parseLong(delay));
    }

    private void updateBoard(FastBoard board) {
        try {
            ConfigManager scoreboard = new ConfigManager(Main.getInstance(), "scoreboard.yml");

            int kills = board.getPlayer().getStatistic(Statistic.PLAYER_KILLS);
            int deaths = board.getPlayer().getStatistic(Statistic.DEATHS);
            double health = board.getPlayer().getHealth();
            double mana = board.getPlayer().getExp();

            List<String> lines = new ArrayList<String>();
            for (String list : scoreboard.getConfig().getStringList("Scoreboard.lines")) {
                lines.add(ChatColor.translateAlternateColorCodes('&', list)
                        .replace("%kills%", ""+kills)
                        .replace("%deaths%", ""+deaths));
            }

            board.updateTitle(Translator.Colors(scoreboard.getConfig().getString("Scoreboard.title")));
            board.updateLines(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}