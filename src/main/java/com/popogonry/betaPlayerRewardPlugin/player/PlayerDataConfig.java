package com.popogonry.betaPlayerRewardPlugin.player;

import com.popogonry.betaPlayerRewardPlugin.Config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class PlayerDataConfig extends Config {
    private String fileName;

    public PlayerDataConfig(String basePath, String fileName) {
        super(basePath, fileName);
        this.fileName = fileName.split("\\.")[0];
    }

    public void storePlayerSet(HashSet<UUID> playerSet) {
        List<String> uuidStringList = playerSet.stream()
                .map(UUID::toString)
                .toList();
        getConfig().set(fileName, uuidStringList);
        super.store();
    }

    public HashSet<UUID> loadPlayerSet() {
        List<String> playerList = getConfig().getStringList(fileName);
        HashSet<UUID> uuidSet = new HashSet<>();
        for (String playerUUID : playerList) {
            uuidSet.add(UUID.fromString(playerUUID));
        }
        return uuidSet;
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
