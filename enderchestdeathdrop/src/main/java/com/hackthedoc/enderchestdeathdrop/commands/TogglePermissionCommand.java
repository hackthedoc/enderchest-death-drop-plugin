package com.hackthedoc.enderchestdeathdrop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.hackthedoc.enderchestdeathdrop.utils.PermissionUtils;

import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.ChatColor;

public class TogglePermissionCommand implements CommandExecutor {
    public static final String PERMISSION = "enderchestdeathdrop.bypass";

    public TogglePermissionCommand() {
        PermissionUtils.luckPerms = LuckPermsProvider.get();
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED+"Usage: /enderchestdeathdrop <playerName> <on|off>");
            return true;
        }

        String targetName = args[0];
        String action = args[1].toLowerCase();

        Player target = Bukkit.getPlayer(targetName);
        if (target == null) {
            sender.sendMessage(ChatColor.RED+"Player not found: "+targetName);
            return true;
        }
        
        switch (action) {
        case "on":
            PermissionUtils.addBypassPermission(target);
            sender.sendMessage(ChatColor.GREEN+"Permission sucessfully granted to "+targetName);
            break;
        case "off":
            PermissionUtils.removeBypassPermission(target);
            sender.sendMessage(ChatColor.GREEN+"Permission successfully removed from "+targetName);
        default:
            sender.sendMessage(ChatColor.RED+"Invalid action: "+action+". Use 'on' or 'off'.");
            break;
        }

        return true;
    }
}
