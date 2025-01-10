package pl.noname.mcmodels2.models;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class DiamondModels {
    public ItemStack crown() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND, 1);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setCustomModelData(1);
        meta.setDisplayName(ChatColor.GOLD + "Korona");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack crown2() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setCustomModelData(2);
        meta.setDisplayName(ChatColor.GOLD + "Korona");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack paper_bag() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setCustomModelData(3);
        meta.setDisplayName(ChatColor.GOLD + "Torba Papierowa");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack pirate_hat() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setCustomModelData(4);
        meta.setDisplayName(ChatColor.GOLD + "Czapka Piracka");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack propeller_hat() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setCustomModelData(5);
        meta.setDisplayName(ChatColor.GOLD + "Czapka Spoceńca");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack speed_carton_car() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setCustomModelData(6);
        meta.setDisplayName(ChatColor.GOLD + "Kartonowe Auto");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack sport_camera() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setCustomModelData(7);
        meta.setDisplayName(ChatColor.GOLD + "Kamera");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack toucan() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setCustomModelData(8);
        meta.setDisplayName(ChatColor.GOLD + "Tucan");
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    private boolean isCrown(ItemStack item) {
        if (!item.getType().equals(Material.DIAMOND)) {
            return false;
        }
        if (!item.hasItemMeta()) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        if (!meta.hasCustomModelData()) {
            return false;
        }
        return meta.getCustomModelData() == 1;
    }

    private boolean isPropellerHat(ItemStack item) {
        if (!item.getType().equals(Material.DIAMOND)) {
            return false;
        }
        if (!item.hasItemMeta()) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        if (!meta.hasCustomModelData()) {
            return false;
        }
        return meta.getCustomModelData() == 5;
    }

    public void propellerHatEvent(Player player) {
        ItemStack helmet = player.getInventory().getHelmet();
        if (helmet == null) {
            return;
        }
        if (!this.isPropellerHat(helmet)) {
            return;
        }
        player.addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(60, 0));
    }

    public void crownEffect(Player player) {
        ItemStack helmet = player.getInventory().getHelmet();
        if (helmet == null) {
            return;
        }
        if (!this.isCrown(helmet)) {
            return;
        }
        player.addPotionEffect(PotionEffectType.SPEED.createEffect(60, 2));
    }

    public void imports() {
        this.crown();
        this.crown2();
        this.paper_bag();
        this.pirate_hat();
        this.propeller_hat();
        this.speed_carton_car();
        this.sport_camera();
        this.toucan();
    }
}
