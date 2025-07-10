package com.popogonry.betaPlayerRewardPlugin.rewardItem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RewardItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player && commandSender.isOp()) {
            RewardItemGUI rewardItemGUI = new RewardItemGUI();
            rewardItemGUI.openRewardItemGUI((Player) commandSender);
        }
        return false;
    }
}
