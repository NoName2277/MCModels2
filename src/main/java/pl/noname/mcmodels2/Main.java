package pl.noname.mcmodels2;

import org.bstats.bukkit.Metrics;
import org.bstats.charts.SingleLineChart;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import pl.noname.mcmodels2.commands.ModelGuiCommand;
import pl.noname.mcmodels2.models.DiamondModels;
import pl.noname.mcmodels2.models.StickModels;
import pl.noname.mcmodels2.models.VersionUtils;

import java.util.concurrent.Callable;

public final class Main extends JavaPlugin implements Runnable, Listener {

    private DiamondModels diamondModels;
    private StickModels stickModels;

    private ModelGui gui;

    @Override
    public void onEnable() {
        diamondModels = new DiamondModels();
        stickModels = new StickModels();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(stickModels, this);
        getServer().getPluginManager().registerEvents(this, this);
        gui = new ModelGui(diamondModels, stickModels);
        gui.createSkinGui();
        getServer().getPluginManager().registerEvents(gui, this);
        getCommand("dajmodel").setExecutor(new ModelGuiCommand(gui));
        getServer().getScheduler().runTaskTimer(this, this, 20L, 20L);
        getServer().getLogger().info("Plugin By NoName0");
        getServer().getLogger().info("Github: https://github.com/NoName2277");

        Metrics metrics = new Metrics(this, id);
        metrics.addCustomChart(new SingleLineChart("players", new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                return Bukkit.getOnlinePlayers().size();
            }
        }));
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void run() {
        for (Player player : getServer().getOnlinePlayers()) {
            //otherModels.policeShieldEffect(player); soon
            diamondModels.propellerHatEvent(player);
            diamondModels.crownEffect(player);
        }
    }

    @EventHandler
    public void sendTxTOnJoin(PlayerJoinEvent event) {
        if (getConfig().getBoolean("send-resource-pack-on-join", true)) {
            String mcVersion = VersionUtils.getMinecraftVersion(getServer());

            if (VersionUtils.isAtLeastVersion(mcVersion, "1.21.4")) {
                getLogger().info("Wersja " + mcVersion + " => wysylam paczke 1.21.4+");
                event.getPlayer().setResourcePack(
                        "https://www.dropbox.com/scl/fi/vs37fg0s7539m8fjx1jun/MCModels2-for-1.21.4.zip?rlkey=hjvo6m1gocnk84kblpx71m2pr&st=omgkb59s&dl=1",
                        null,
                        getConfig().getBoolean("force-resource-pack-on-load")
                );
            } else {
                getLogger().info("Wersja " + mcVersion + " => wysylam paczke 1.18 - 1.21.3");
                event.getPlayer().setResourcePack(
                        "https://www.dropbox.com/scl/fi/17m10onavbc1lz4oc4opb/mcmodels2.zip?rlkey=190g3tl08l0g4r6saaiho7qmo&dl=1",
                        null,
                        getConfig().getBoolean("force-resource-pack-on-load")
                );
            }
        }
    }

}
