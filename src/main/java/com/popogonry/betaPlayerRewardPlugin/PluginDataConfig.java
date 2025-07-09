
package com.popogonry.betaPlayerRewardPlugin;

public class PluginDataConfig extends Config {
    public PluginDataConfig(String basePath, String fileName) {
        super(basePath, fileName);
    }

    public PluginConfig loadPluginDataConfig() {
        return new PluginConfig(
                this.getConfig().getBoolean("Is-Server-Beta")
        );
    }

    public void loadDefaults() {
    }

    public void applySettings() {
        this.getConfig().options().copyDefaults(true);
    }
}