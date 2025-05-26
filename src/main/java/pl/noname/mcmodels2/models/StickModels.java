package pl.noname.mcmodels2.models;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class StickModels implements Listener {

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

    private boolean isPoliceBaton(ItemStack itemStack){
        if(!itemStack.hasItemMeta()) return false;
        ItemMeta meta = itemStack.getItemMeta();
        if(!meta.hasDisplayName()) return false;
        if(!meta.hasCustomModelData()) return false;
        return meta.getCustomModelData() == 1 || meta.getCustomModelData() == 2 || meta.getCustomModelData() == 3;
    }
    @EventHandler
    public void onPoliceBatonAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        if (!(event.getEntity() instanceof LivingEntity)) return;

        Player player = (Player) event.getDamager();
        LivingEntity livingEntity = (LivingEntity) event.getEntity();

        ItemStack item = player.getInventory().getItemInMainHand();
        if (!isPoliceBaton(item)) return;

        if (!(livingEntity instanceof Player)) return;
        Player player1 = (Player) livingEntity;

        player1.addPotionEffect(PotionEffectType.SLOW.createEffect(200, 999));
        player1.addPotionEffect(PotionEffectType.BLINDNESS.createEffect(200, 999));
    }



    public void imports(){
        this.policeBaton();
        this.policeBaton2();
        this.policeBaton3();
    }
}
