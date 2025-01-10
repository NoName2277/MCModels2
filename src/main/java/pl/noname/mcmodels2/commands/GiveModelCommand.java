package pl.noname.mcmodels2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import pl.noname.mcmodels2.models.DiamondModels;
import pl.noname.mcmodels2.models.StickModels;

import java.util.ArrayList;
import java.util.List;

public class GiveModelCommand implements CommandExecutor, TabCompleter {

    private final DiamondModels diamondModels;
    private final StickModels stickModels;

    public GiveModelCommand(DiamondModels diamondModels, StickModels stickModels){
        this.diamondModels = diamondModels;
        this.stickModels = stickModels;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof  Player)) return true;
        Player player = (Player) sender;
        if(args.length==1){
            if (args[0].equalsIgnoreCase("crown")){
                player.getInventory().addItem(diamondModels.crown());
                return true;
            }else if (args[0].equalsIgnoreCase("crown2")){
                player.getInventory().addItem(diamondModels.crown2());
                return true;
            }else if(args[0].equalsIgnoreCase("paper_bag")){
                player.getInventory().addItem(diamondModels.propeller_hat());
                return true;
            }else if(args[0].equalsIgnoreCase("pirate_hat")){
                player.getInventory().addItem(diamondModels.pirate_hat());
                return true;
            }else if(args[0].equalsIgnoreCase("propeller_hat")){
                player.getInventory().addItem(diamondModels.pirate_hat());
                return true;
            }else if(args[0].equalsIgnoreCase("speed_carton_car")){
                player.getInventory().addItem(diamondModels.pirate_hat());
                return true;
            }else if(args[0].equalsIgnoreCase("sport_camera")){
                player.getInventory().addItem(diamondModels.pirate_hat());
                return true;
            }else if(args[0].equalsIgnoreCase("toucan")){
                player.getInventory().addItem(diamondModels.pirate_hat());
                return true;
            }else if(args[0].equalsIgnoreCase("policebaton")){
                player.getInventory().addItem(stickModels.policeBaton());
                return true;
            }else if(args[0].equalsIgnoreCase("policebaton2")){
                player.getInventory().addItem(stickModels.policeBaton2());
                return true;
            }else if(args[0].equalsIgnoreCase("policebaton3")){
                player.getInventory().addItem(stickModels.policeBaton3());
                return true;
            }
        }
        player.getInventory().addItem(diamondModels.crown());
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==1){
            ArrayList<String> list = new ArrayList<>();
            list.add("policebaton");
            list.add("policebaton/2");
            list.add("policebaton/3");
            list.add("policeshield");
            list.add("crown");
            list.add("crown/2");
            list.add("paper_bag");
            list.add("pirate_hat");
            list.add("propeller_hat");
            list.add("speed_carton_car");
            list.add("sport_camera");
            list.add("toucan");
            return list;
        }
        return null;
    }
}
