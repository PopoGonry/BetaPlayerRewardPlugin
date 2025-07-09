package com.popogonry.betaPlayerRewardPlugin.player.rewardReceivePlayer;

import com.popogonry.betaPlayerRewardPlugin.BetaPlayerRewardPlugin;
import com.popogonry.betaPlayerRewardPlugin.player.PlayerDataConfig;

import java.util.HashSet;
import java.util.UUID;

public class RewardReceivePlayerRepository {
    public static HashSet<UUID> rewardReceivePlayerSet = new HashSet<>();

    private final String configBasePath;
    private static final String FILE_NAME = "rewardReceivePlayer.yml";

    private final PlayerDataConfig dataConfig;


    public RewardReceivePlayerRepository() {
        this.configBasePath = BetaPlayerRewardPlugin.getServerInstance().getDataFolder().getAbsolutePath();
        this.dataConfig = new PlayerDataConfig(configBasePath, FILE_NAME);
    }

    public void reloadConfig() {
        dataConfig.reload();
    }

    public void saveConfig() {
        dataConfig.store();
    }

    public boolean hasRewardReceivePlayerSet() {
        return dataConfig.hasPlayerSet();
    }

    public void storeRewardReceivePlayerSet() {
        dataConfig.storePlayerSet(rewardReceivePlayerSet);
        rewardReceivePlayerSet.clear();
    }

    public void saveRewardReceivePlayerSet() {
        dataConfig.storePlayerSet(rewardReceivePlayerSet);
    }

    public void loadRewardReceivePlayerSet() {
        rewardReceivePlayerSet = dataConfig.loadPlayerSet();
        if(rewardReceivePlayerSet == null) rewardReceivePlayerSet = new HashSet<>();
    }

    public void removeRewardReceivePlayerSet() {
        dataConfig.removePlayerSet();
    }
}
