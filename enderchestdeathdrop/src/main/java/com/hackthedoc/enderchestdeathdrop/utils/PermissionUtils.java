package com.hackthedoc.enderchestdeathdrop.utils;

import org.bukkit.entity.Player;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.md_5.bungee.api.ChatColor;

public class PermissionUtils {
    private static final String BYPASS_PERMISSION = "enderchestdeathdrop.bypass";
    public static LuckPerms luckPerms;

    public static void addBypassPermission(Player player) {
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        
        if (user == null)
            return;

        Node node = Node.builder(BYPASS_PERMISSION).build();
        user.data().add(node);
        luckPerms.getUserManager().saveUser(user);

        player.sendMessage(ChatColor.GREEN+"You have been granted the following permission: "+BYPASS_PERMISSION);
    }

    public static void removeBypassPermission(Player player) {
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        
        if (user == null)
            return;

        Node node = Node.builder(BYPASS_PERMISSION).build();
        user.data().remove(node);
        luckPerms.getUserManager().saveUser(user);

        player.sendMessage(ChatColor.GREEN+"You have been removed the following permission: "+BYPASS_PERMISSION);
    }

    public static boolean hasBypassPermission(Player player) {
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        
        if (user == null)
            return false;
        
        return user.getCachedData().getPermissionData().checkPermission(BYPASS_PERMISSION).asBoolean();
    }
}
