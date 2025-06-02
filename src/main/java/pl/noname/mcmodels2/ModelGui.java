package pl.noname.mcmodels2;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import pl.noname.mcmodels2.models.DiamondModels;
import pl.noname.mcmodels2.models.StickModels;

public class ModelGui implements Listener {

    public Inventory skinGui;

    private DiamondModels diamondModels;
    private StickModels stickModels;

    public ModelGui (DiamondModels diamondModels, StickModels stickModels){
        this.diamondModels = diamondModels;
        this.stickModels = stickModels;
    }
    public void createSkinGui(){
        skinGui = Bukkit.createInventory(null, 18, "§a§lWybierz Model");

        skinGui.setItem(0, diamondModels.crown());
        skinGui.setItem(1, diamondModels.crown2());
        skinGui.setItem(2, diamondModels.pirate_hat());
        skinGui.setItem(3, diamondModels.paper_bag());
        skinGui.setItem(4, diamondModels.propeller_hat());
        skinGui.setItem(5, diamondModels.speed_carton_car());
        skinGui.setItem(6, diamondModels.toucan());
        skinGui.setItem(7, diamondModels.pirate_hat());
        skinGui.setItem(8, diamondModels.sport_camera());
        skinGui.setItem(12, stickModels.policeBaton());
        skinGui.setItem(13, stickModels.policeBaton2());
        skinGui.setItem(14, stickModels.policeBaton3());
    }

    @EventHandler
    public void ModelGuiClickEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if(!(event.getInventory() == skinGui)) return;
        switch (event.getSlot()){
            case 0:
                player.getInventory().addItem(diamondModels.crown());
                event.setCancelled(true);
                break;
            case 1:
                player.getInventory().addItem(diamondModels.crown2());
                event.setCancelled(true);
                break;
            case 2:
                player.getInventory().addItem(diamondModels.pirate_hat());
                event.setCancelled(true);
                break;
            case 3:
                player.getInventory().addItem(diamondModels.paper_bag());
                event.setCancelled(true);
                break;
            case 4:
                player.getInventory().addItem(diamondModels.propeller_hat());
                event.setCancelled(true);
                break;
            case 5:
                player.getInventory().addItem(diamondModels.speed_carton_car());
                event.setCancelled(true);
                break;
            case 6:
                player.getInventory().addItem(diamondModels.toucan());
                event.setCancelled(true);
                break;
            case 7:
                player.getInventory().addItem(diamondModels.pirate_hat());
                event.setCancelled(true);
                break;
            case 8:
                player.getInventory().addItem(diamondModels.sport_camera());
                event.setCancelled(true);
                break;
            case 12:
                player.getInventory().addItem(stickModels.policeBaton());
                event.setCancelled(true);
                break;
            case 13:
                player.getInventory().addItem(stickModels.policeBaton2());
                event.setCancelled(true);
                break;
            case 14:
                player.getInventory().addItem(stickModels.policeBaton3());
                event.setCancelled(true);
                break;

        }
    }
}
