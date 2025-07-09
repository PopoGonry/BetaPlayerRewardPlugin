package com.popogonry.betaPlayerRewardPlugin.rewardItem;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RewardItemEvent implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if(event.getView().getTitle().equals("Reward Item List")) {

            RewardItemRepository.rewardItemList.clear();
            Inventory inventory = event.getInventory();

            for (ItemStack itemStack : inventory) {
                if(itemStack != null && itemStack.getType() != Material.AIR) RewardItemRepository.rewardItemList.add(itemStack);
            }

            RewardItemRepository rewardItemRepository = new RewardItemRepository();
            rewardItemRepository.saveRewardItemList();
        }
    }
}
