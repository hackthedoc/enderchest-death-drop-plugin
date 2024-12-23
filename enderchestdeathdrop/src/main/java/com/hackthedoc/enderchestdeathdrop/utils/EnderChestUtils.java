package com.hackthedoc.enderchestdeathdrop.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EnderChestUtils {
    
    public static void dropContents(Player player) {
        Inventory enderChest = player.getEnderChest();
        Location location = player.getLocation();

        for (ItemStack item : enderChest.getContents()) {
            if (item != null)
                location.getWorld().dropItemNaturally(location, item);
        }

        enderChest.clear();
    }
}
