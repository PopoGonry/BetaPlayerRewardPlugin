
package com.popogonry.betaPlayerRewardPlugin;

import java.util.List;

public class PluginConfig {
    private final boolean isServerBeta;

    public PluginConfig(boolean isServerBeta) {
        this.isServerBeta = isServerBeta;
    }

    @Override
    public String toString() {
        return "PluginConfig{" +
                "isServerBeta=" + isServerBeta +
                '}';
    }

    public boolean isServerBeta() {
        return isServerBeta;
    }
}

