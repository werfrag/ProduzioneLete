package me.werfrag.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WaterFillListener implements Listener {

    @EventHandler
    public void onWaterFill(PlayerBucketFillEvent event) {
        if (event.getItemStack().getType() == Material.GLASS_BOTTLE) {
            Player player = event.getPlayer();
            if (player.hasPermission("late.get.water-dirty")) {
                ItemStack filledBottle = event.getItemStack();
                ItemMeta itemMeta = filledBottle.getItemMeta();

                if (itemMeta != null) {
                    itemMeta.setDisplayName("§2§lAcqua §8§lSporca");
                    filledBottle.setItemMeta(itemMeta);
                }


                event.setItemStack(filledBottle);
                player.sendMessage("§aHai preso l'§2§lAcqua §8§lSporca.");
            } else {
                event.setCancelled(true);
                player.sendMessage("§4§lNon puoi prendere l'acqua.");
            }
        }
    }
}
