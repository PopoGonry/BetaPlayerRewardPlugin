package com.popogonry.betaPlayerRewardPlugin.player.betaPlayer;

import com.popogonry.betaPlayerRewardPlugin.BetaPlayerRewardPlugin;
import com.popogonry.betaPlayerRewardPlugin.PluginRepository;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BetaPlayerEvent implements Listener {

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        if(PluginRepository.pluginConfig.isServerBeta()) {
            BetaPlayerRepository.betaPlayerSet.add(event.getPlayer().getUniqueId());

            BetaPlayerRepository betaPlayerRepository = new BetaPlayerRepository();
            betaPlayerRepository.saveBetaPlayerSet();
        }
    }
}
