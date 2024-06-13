package br.com.minecraft.hanlly.testing.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashSet;

public class ShovelHandler implements Listener {


    static private double woodenRadius = 5.0;
    static private double stoneRadius = 10.0;
    static private double goldenRadius = 15.0;
    static private double ironRadius = 30.0;
    static private double  diamondRadius = 50.0;
    static private double netheriteRadius = 100.0;



    final static private HashSet<Material> SHOVELS = new HashSet<>(Arrays.asList(
            Material.WOODEN_SHOVEL, Material.STONE_SHOVEL, Material.GOLDEN_SHOVEL,
            Material.IRON_SHOVEL, Material.DIAMOND_SHOVEL, Material.NETHERITE_SHOVEL
    ));

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        double radiusShovel = 0;
        Player player = e.getPlayer();
        Material material = e.getMaterial();

        System.out.println("---------------------\n" + material);
        if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
                && SHOVELS.contains(material)){
            ItemStack shovel = e.getItem();
            Damageable shovelDamageable = (Damageable) shovel.getItemMeta();



            shovelDamageable.setDamage(shovelDamageable.getDamage() + 20);
            shovel.setItemMeta((ItemMeta) shovelDamageable);



            switch(material){
                case WOODEN_SHOVEL: radiusShovel = woodenRadius;
                    break;
                case STONE_SHOVEL: radiusShovel = stoneRadius;
                    break;
                case GOLDEN_SHOVEL: radiusShovel = goldenRadius;
                    break;
                case IRON_SHOVEL: radiusShovel = ironRadius;
                    break;
                case DIAMOND_SHOVEL: radiusShovel = diamondRadius;
                    break;
                case NETHERITE_SHOVEL: radiusShovel = netheriteRadius;
                    break;

            }

            LargeFireball projectile = player.launchProjectile(LargeFireball.class, player.getEyeLocation().getDirection().multiply(1.25));
            projectile.setYield((float) radiusShovel);
            player.sendMessage(ChatColor.RED + "Você acionou sua superhabilidade!");

            if(shovelDamageable.getDamage() >  material.getMaxDurability() ){
                player.getInventory().setItemInMainHand(null);
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 0.5F);
            }

        }
    }




}
