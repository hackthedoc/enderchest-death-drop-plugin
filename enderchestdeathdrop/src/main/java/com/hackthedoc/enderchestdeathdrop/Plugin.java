package com.hackthedoc.enderchestdeathdrop;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import com.hackthedoc.enderchestdeathdrop.commands.TogglePermissionCommand;
import com.hackthedoc.enderchestdeathdrop.listerners.DeathListener;

public class Plugin extends JavaPlugin {
  private static final Logger LOGGER=Logger.getLogger("enderchestdeathdrop");
  private static Plugin instance;

  public void onEnable() {
    instance = this;

    getCommand("enderchestdeathdrop").setExecutor(new TogglePermissionCommand());

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
