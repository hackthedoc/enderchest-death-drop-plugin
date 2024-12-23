package com.hackthedoc.enderchestdeathdrop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.hackthedoc.enderchestdeathdrop.Plugin;
import com.hackthedoc.enderchestdeathdrop.data.PermissionStorage;

import net.md_5.bungee.api.ChatColor;

public class TogglePermissionCommand implements CommandExecutor {
    public static final String PERMISSION = "enderchestdeathdrop.bypass";
    private final PermissionStorage storage;

    public TogglePermissionCommand(PermissionStorage storage) {
        this.storage = storage;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 3) {
            sender.sendMessage(ChatColor.RED+"Usage: /enderchestdeathdrop <playerName> <on|off>");
            return false;
        }

        String playerName = args[0];
        String action = args[1].toLowerCase();

        Player target = Bukkit.getPlayer(playerName);
        if (target == null) {
            sender.sendMessage(ChatColor.RED+"Player not found: "+playerName);
            return false;
        }

        switch (action) {
        case "on":
            addPermission(target);
            sender.sendMessage(ChatColor.GREEN+"Permission sucessfully granted to "+playerName);
            break;
        case "off":
            removePermission(target);
            sender.sendMessage(ChatColor.GREEN+"Permission successfully removed from "+playerName);
        default:
            sender.sendMessage(ChatColor.RED+"Invalid action: "+action+". Use 'on' or 'off'.");
            break;
        }

        return false;
    }

    private void addPermission(Player target) {
        storage.addUUID(target.getUniqueId());
        target.addAttachment(Plugin.getInstance()).setPermission(PERMISSION, true);
        target.sendMessage(ChatColor.GREEN+"You have been granted the following permission: "+PERMISSION);
    }

    private void removePermission(Player target) {
        storage.removeUUID(target.getUniqueId());
        target.addAttachment(Plugin.getInstance()).setPermission(PERMISSION, false);
        target.sendMessage(ChatColor.GREEN+"You have been removed the following permission: "+PERMISSION);
    }
}
