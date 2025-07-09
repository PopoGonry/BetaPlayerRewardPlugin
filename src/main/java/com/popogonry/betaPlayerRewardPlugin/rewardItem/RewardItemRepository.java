package com.popogonry.betaPlayerRewardPlugin.rewardItem;

import com.popogonry.betaPlayerRewardPlugin.BetaPlayerRewardPlugin;
import com.popogonry.betaPlayerRewardPlugin.player.PlayerDataConfig;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class RewardItemRepository {
    public static List<ItemStack> rewardItemList = new ArrayList<>();


    private final String configBasePath;
    private static final String FILE_NAME = "rewardItem.yml";

    private final RewardItemDataConfig dataConfig;

    public RewardItemRepository() {
        this.configBasePath = BetaPlayerRewardPlugin.getServerInstance().getDataFolder().getAbsolutePath();
        this.dataConfig = new RewardItemDataConfig(configBasePath, FILE_NAME);
    }

    public void reloadConfig() {
        dataConfig.reload();
    }

    public void saveConfig() {
        dataConfig.store();
    }

    public boolean hasRewardItemList() {
        return dataConfig.hasRewardItemList();
    }

    public void storeRewardItemList() {
        dataConfig.storeRewardItemList(rewardItemList);
        rewardItemList.clear();
    }

    public void saveRewardItemList() {
        dataConfig.storeRewardItemList(rewardItemList);
    }

    public void loadRewardItemList() {
        rewardItemList = dataConfig.loadRewardItemList();
        if(rewardItemList == null) rewardItemList = new ArrayList<>();
    }

    public void removeRewardItemList() {
        dataConfig.removeRewardItemList();
    }
}
