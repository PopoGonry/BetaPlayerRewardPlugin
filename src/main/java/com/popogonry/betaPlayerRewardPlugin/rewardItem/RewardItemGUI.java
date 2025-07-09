package com.popogonry.betaPlayerRewardPlugin.rewardItem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RewardItemGUI {
    public boolean openRewardItemGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 54, "Reward Item List");

        for (ItemStack itemStack : RewardItemRepository.rewardItemList) {
            inventory.addItem(new ItemStack(itemStack));
        }

        player.openInventory(inventory);

        return true;
    }
}
