package com.hackthedoc.enderchestdeathdrop.listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.hackthedoc.enderchestdeathdrop.Plugin;
import com.hackthedoc.enderchestdeathdrop.commands.TogglePermissionCommand;
import com.hackthedoc.enderchestdeathdrop.data.PermissionStorage;

public class PlayerJoinListener implements Listener {
    private final PermissionStorage storage;

    public PlayerJoinListener(PermissionStorage storage) {
        this.storage = storage;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        for (String s : storage.getPlayers()) {
            if (s == event.getPlayer().getUniqueId().toString()) {
                event.getPlayer().addAttachment(Plugin.getInstance()).setPermission(TogglePermissionCommand.PERMISSION, true);
                return;
            }
        }
    }
}
