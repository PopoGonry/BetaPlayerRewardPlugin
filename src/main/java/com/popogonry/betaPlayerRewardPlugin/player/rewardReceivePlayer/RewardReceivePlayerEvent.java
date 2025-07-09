package com.popogonry.betaPlayerRewardPlugin.player.rewardReceivePlayer;

import com.popogonry.betaPlayerRewardPlugin.PluginRepository;
import com.popogonry.betaPlayerRewardPlugin.player.betaPlayer.BetaPlayerRepository;
import com.popogonry.betaPlayerRewardPlugin.rewardItem.RewardItemRepository;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class RewardReceivePlayerEvent implements Listener {
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        if(!PluginRepository.pluginConfig.isServerBeta()) {
            if(RewardReceivePlayerRepository.rewardReceivePlayerSet.contains(event.getPlayer().getUniqueId())) return;

            RewardReceivePlayerRepository.rewardReceivePlayerSet.add(event.getPlayer().getUniqueId());

            RewardReceivePlayerRepository rewardReceivePlayerRepository = new RewardReceivePlayerRepository();
            rewardReceivePlayerRepository.saveRewardReceivePlayerSet();

            for (ItemStack itemStack : RewardItemRepository.rewardItemList) {
                event.getPlayer().getInventory().addItem(new ItemStack(itemStack));
            }
        }
    }
}
