package com.hackthedoc.enderchestdeathdrop.data;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PermissionStorage {
    private final File file;
    private final FileConfiguration config;

    public PermissionStorage(File dataFolder) {
        this.file = new File(dataFolder, "bypass_perm.yml");
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public void addUUID(UUID player) {
        List<String> players = getPlayers();
        if (!players.contains(player.toString())) {
            players.add(player.toString());
            config.set("players", players);
            saveFile();
        }
    }

    public void removeUUID(UUID player) {
        List<String> players = getPlayers();
        players.remove(player.toString());
        config.set("players", player);
        saveFile();
    }

    public List<String> getPlayers() {
        return config.getStringList("players");
    }

    private void saveFile() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
