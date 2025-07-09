package com.popogonry.betaPlayerRewardPlugin.player;

import com.popogonry.betaPlayerRewardPlugin.Config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class PlayerDataConfig extends Config {
    private String fileName;

    public PlayerDataConfig(String basePath, String fileName) {
        super(basePath, fileName);
        this.fileName = fileName.split("\\.")[0];
    }

    public void storePlayerSet(HashSet<UUID> playerSet) {
        getConfig().set(fileName, new ArrayList<>(playerSet));
        super.store();
    }

    public HashSet<UUID> loadPlayerSet() {
        return (HashSet<UUID>) getConfig().getList(fileName);
    }

    public boolean hasPlayerSet() {
        return getConfig().contains(fileName);
    }

    public void removePlayerSet() {
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
