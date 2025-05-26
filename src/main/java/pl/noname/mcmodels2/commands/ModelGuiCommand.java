package pl.noname.mcmodels2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.noname.mcmodels2.ModelGui;

public class ModelGuiCommand implements CommandExecutor {

    private final ModelGui gui;

    public ModelGuiCommand(ModelGui gui){
        this.gui = gui;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
        ((Player) sender).openInventory(gui.skinGui);
        return false;
    }
}
