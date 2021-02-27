package me.pulsi_.magicsticks.Scoreboard;

import me.pulsi_.magicsticks.MagicSticks;
import me.pulsi_.magicsticks.Managers.ConfigManager;
import me.pulsi_.magicsticks.Managers.ListColorsTranslate;
import me.pulsi_.magicsticks.Managers.Translator;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Scoreboard implements Listener {

    private final Map<UUID, FastBoard> boards = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ConfigManager scoreboard = new ConfigManager(MagicSticks.getInstance(), "scoreboard.yml");
        if (scoreboard.getConfig().getBoolean("use_scoreboard")) {


            String delay = scoreboard.getConfig().getString("delay");

            Player player = e.getPlayer();
            FastBoard board = new FastBoard(player);
            boards.put(player.getUniqueId(), board);

            new BukkitRunnable() {
                public void run() {
                    updateBoard(board);

                    ListColorsTranslate color = new ListColorsTranslate();
                    color.colorBoard();

                    updateBoard(board);
                }
            }.runTaskTimer(MagicSticks.getInstance(), 0, Long.parseLong(delay));
        }
    }

    private void updateBoard(FastBoard board) {
        try {
            ConfigManager scoreboard = new ConfigManager(MagicSticks.getInstance(), "scoreboard.yml");
            scoreboard.getConfig().getConfigurationSection("Scoreboard").getKeys(false);

            List<String> lines = MagicSticks.getInstance().getConfig().getStringList("Scoreboard.Lines");
            int size = lines.size() + 1;

            int kills = board.getPlayer().getStatistic(Statistic.PLAYER_KILLS);
            int deaths = board.getPlayer().getStatistic(Statistic.DEATHS);
            double health = board.getPlayer().getHealth();

            board.updateTitle(Translator.Colors(scoreboard.getConfig().getString("Scoreboard.Title")));
            board.updateLines(

            scoreboard.getConfig().getStringList("Scoreboard.Lines")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
