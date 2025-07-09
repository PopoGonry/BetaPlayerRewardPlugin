package com.popogonry.betaPlayerRewardPlugin.rewardItem;

import com.popogonry.betaPlayerRewardPlugin.Config;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class RewardItemDataConfig extends Config {
    private String fileName;

    public RewardItemDataConfig(String basePath, String fileName) {
        super(basePath, fileName);
        this.fileName = fileName.split("\\.")[0];
    }

    public void storeRewardItemList(List<ItemStack> rewardItemList) {
        getConfig().set(fileName, rewardItemList);
        super.store();
    }

    public List<ItemStack> loadRewardItemList() {
        return (List<ItemStack>) getConfig().getList(fileName);
    }

    public boolean hasRewardItemList() {
        return getConfig().contains(fileName);
    }

    public void removeRewardItemList() {
        getConfig().set(fileName, null);
        super.store();
    }

    @Override
    public void loadDefaults() {

    }

    @Override
    public void applySettings() {

    }
}
