package com.popogonry.betaPlayerRewardPlugin;

import com.popogonry.betaPlayerRewardPlugin.player.betaPlayer.BetaPlayerEvent;
import com.popogonry.betaPlayerRewardPlugin.player.betaPlayer.BetaPlayerRepository;
import com.popogonry.betaPlayerRewardPlugin.player.rewardReceivePlayer.RewardReceivePlayerEvent;
import com.popogonry.betaPlayerRewardPlugin.rewardItem.RewardItemCommand;
import com.popogonry.betaPlayerRewardPlugin.rewardItem.RewardItemEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetaPlayerRewardPlugin extends JavaPlugin {
    private static BetaPlayerRewardPlugin serverInstance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        serverInstance = this;
        saveDefaultConfig();
        PluginRepository.loadAllData();

        getServer().getPluginManager().registerEvents(new RewardItemEvent(), this);
        getServer().getPluginManager().registerEvents(new BetaPlayerEvent(), this);
        getServer().getPluginManager().registerEvents(new RewardReceivePlayerEvent(), this);
        getServer().getPluginCommand("베타보상").setExecutor(new RewardItemCommand());

        Bukkit.getConsoleSender().sendMessage(Reference.prefix_normal + "BetaPlayerReward Plugin Enabled (Developer: PopoGonry)");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        PluginRepository.saveAllData();

        Bukkit.getConsoleSender().sendMessage(Reference.prefix_normal + "BetaPlayerReward Plugin Disabled (Developer: PopoGonry)");
    }
    public static BetaPlayerRewardPlugin getServerInstance() {
        return serverInstance;
    }

}
