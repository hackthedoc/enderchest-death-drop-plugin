package com.hackthedoc.enderchestdeathdrop.listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.hackthedoc.enderchestdeathdrop.utils.EnderChestUtils;

public class DeathListener implements Listener {
    
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        EnderChestUtils.dropContents(event.getEntity());
    }
}
