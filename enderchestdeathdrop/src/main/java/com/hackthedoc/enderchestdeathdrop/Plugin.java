package com.hackthedoc.enderchestdeathdrop;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import com.hackthedoc.enderchestdeathdrop.commands.TogglePermissionCommand;
import com.hackthedoc.enderchestdeathdrop.data.PermissionStorage;
import com.hackthedoc.enderchestdeathdrop.listerners.DeathListener;
import com.hackthedoc.enderchestdeathdrop.listerners.PlayerJoinListener;

public class Plugin extends JavaPlugin {
  private static final Logger LOGGER=Logger.getLogger("enderchestdeathdrop");
  private static Plugin instance;

  public void onEnable() {
    instance = this;
    PermissionStorage storage = new PermissionStorage(getDataFolder());
    this.getCommand("enderchestdeathdrop").setExecutor(new TogglePermissionCommand(storage));

    getServer().getPluginManager().registerEvents(new PlayerJoinListener(storage), instance);
    getServer().getPluginManager().registerEvents(new DeathListener(), instance);

    LOGGER.info("enderchestdeathdrop enabled");
  }

  public void onDisable() {
    LOGGER.info("enderchestdeathdrop disabled");
  }

  public static Plugin getInstance() {
    return instance;
  }
}
