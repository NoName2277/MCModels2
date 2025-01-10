package pl.noname.mcmodels2.models;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StickModels {

    public ItemStack policeBaton(){
        ItemStack itemStack = new ItemStack(Material.STICK);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Pałka policyjna");
        meta.setCustomModelData(1);
        itemStack.setItemMeta(meta);
        return itemStack;
    }
    public ItemStack policeBaton2(){
        ItemStack itemStack = new ItemStack(Material.STICK);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Pałka policyjna");
        meta.setCustomModelData(2);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public ItemStack policeBaton3(){
        ItemStack itemStack = new ItemStack(Material.STICK);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Pałka policyjna");
        meta.setCustomModelData(3);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public void imports(){
        this.policeBaton();
        this.policeBaton2();
        this.policeBaton3();
    }
}
