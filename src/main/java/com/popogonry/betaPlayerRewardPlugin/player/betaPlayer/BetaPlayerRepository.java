package com.popogonry.betaPlayerRewardPlugin.player.betaPlayer;

import com.popogonry.betaPlayerRewardPlugin.BetaPlayerRewardPlugin;
import com.popogonry.betaPlayerRewardPlugin.player.PlayerDataConfig;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BetaPlayerRepository {
    public static HashSet<UUID> betaPlayerSet = new HashSet<>();

    private final String configBasePath;
    private static final String FILE_NAME = "betaPlayer.yml";

    private final PlayerDataConfig dataConfig;


    public BetaPlayerRepository() {
        this.configBasePath = BetaPlayerRewardPlugin.getServerInstance().getDataFolder().getAbsolutePath();
        this.dataConfig = new PlayerDataConfig(configBasePath, FILE_NAME);
    }

    public void reloadConfig() {
        dataConfig.reload();
    }

    public void saveConfig() {
        dataConfig.store();
    }

    public boolean hasBetaPlayerSet() {
        return dataConfig.hasPlayerSet();
    }

    public void storeBetaPlayerSet() {
        dataConfig.storePlayerSet(betaPlayerSet);
        betaPlayerSet.clear();
    }

    public void saveBetaPlayerSet() {
        dataConfig.storePlayerSet(betaPlayerSet);
    }

    public void loadBetaPlayerSet() {
        betaPlayerSet = dataConfig.loadPlayerSet();
        if(betaPlayerSet == null) betaPlayerSet = new HashSet<>();
    }

    public void removeBetaPlayerSet() {
        dataConfig.removePlayerSet();
    }
}
