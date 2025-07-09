
package com.popogonry.betaPlayerRewardPlugin;


import com.popogonry.betaPlayerRewardPlugin.player.betaPlayer.BetaPlayerRepository;
import com.popogonry.betaPlayerRewardPlugin.player.rewardReceivePlayer.RewardReceivePlayerRepository;
import com.popogonry.betaPlayerRewardPlugin.rewardItem.RewardItemRepository;
import org.bukkit.Bukkit;

public class PluginRepository {
    private static final String CONFIG_FILE_NAME = "config.yml";
    private final String configBasePath = BetaPlayerRewardPlugin.getServerInstance().getDataFolder().getAbsolutePath();
    private final PluginDataConfig pluginDataConfig;
    public static PluginConfig pluginConfig;

    public PluginRepository() {
        this.pluginDataConfig = new PluginDataConfig(this.configBasePath, "config.yml");
    }

    public void reloadConfig() {
        this.pluginDataConfig.reload();
    }

    public void saveConfig() {
        this.pluginDataConfig.store();
    }

    public void loadPluginDataConfig() {
        pluginConfig = this.pluginDataConfig.loadPluginDataConfig();
    }

    public static void loadAllData() {
        Bukkit.getConsoleSender().sendMessage(Reference.prefix_normal + "BetaPlayerReward Data Load Start...");

        PluginRepository pluginRepository = new PluginRepository();
        pluginRepository.loadPluginDataConfig();

        BetaPlayerRepository betaPlayerRepository = new BetaPlayerRepository();
        betaPlayerRepository.loadBetaPlayerSet();

        RewardReceivePlayerRepository rewardReceivePlayerRepository = new RewardReceivePlayerRepository();
        rewardReceivePlayerRepository.loadRewardReceivePlayerSet();

        RewardItemRepository rewardItemRepository = new RewardItemRepository();
        rewardItemRepository.loadRewardItemList();

        Bukkit.getConsoleSender().sendMessage(Reference.prefix_normal + "BetaPlayerReward Data Load Complete!");
    }

    public static void saveAllData() {
        Bukkit.getConsoleSender().sendMessage(Reference.prefix_normal + "BetaPlayerReward Data Store Start...");

        BetaPlayerRepository betaPlayerRepository = new BetaPlayerRepository();
        betaPlayerRepository.saveBetaPlayerSet();

        RewardReceivePlayerRepository rewardReceivePlayerRepository = new RewardReceivePlayerRepository();
        rewardReceivePlayerRepository.saveRewardReceivePlayerSet();

        RewardItemRepository rewardItemRepository = new RewardItemRepository();
        rewardItemRepository.saveRewardItemList();

        Bukkit.getConsoleSender().sendMessage(Reference.prefix_normal + "BetaPlayerReward Data Store Complete!");
    }
}
