package pl.noname.mcmodels2;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import pl.noname.mcmodels2.commands.GiveModelCommand;
import pl.noname.mcmodels2.models.DiamondModels;
import pl.noname.mcmodels2.models.StickModels;

public final class Main extends JavaPlugin implements Runnable, Listener {

    private DiamondModels diamondModels;
    private StickModels stickModels;

    @Override
    public void onEnable() {
        diamondModels = new DiamondModels();
        stickModels = new StickModels();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("dajmodel").setExecutor(new GiveModelCommand(diamondModels, stickModels));
        getCommand("dajmodel").setTabCompleter(new GiveModelCommand(diamondModels, stickModels));
        getServer().getScheduler().runTaskTimer(this, this, 20L, 20L);

    }

    private String ver = getServer().getVersion();

    @EventHandler
    public void sendTxTOnJoin(PlayerJoinEvent event) {
        if (getConfig().getBoolean("send-resource-pack-on-join", true)) {
            if(this.getServer().getVersion().contains("1.21.4")){
                getLogger().info("1.21.4 texture pack send!");
                event.getPlayer().setResourcePack("https://www.dropbox.com/scl/fi/vs37fg0s7539m8fjx1jun/MCModels2-for-1.21.4.zip?rlkey=hjvo6m1gocnk84kblpx71m2pr&st=omgkb59s&dl=1",
                        null, getConfig().getBoolean("force-resource-pack-on-load"));
            }else
                event.getPlayer().setResourcePack("https://www.dropbox.com/scl/fi/17m10onavbc1lz4oc4opb/mcmodels2.zip?rlkey=190g3tl08l0g4r6saaiho7qmo&dl=1",
                        null, getConfig().getBoolean("force-resource-pack-on-load"));
        }
        return;
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
}
