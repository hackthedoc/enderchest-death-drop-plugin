package com.hackthedoc.enderchestdeathdrop;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import com.hackthedoc.enderchestdeathdrop.listerners.DeathListener;

public class Plugin extends JavaPlugin {
  private static final Logger LOGGER=Logger.getLogger("enderchestdeathdrop");

  public void onEnable() {
    getServer().getPluginManager().registerEvents(new DeathListener(), this);

    LOGGER.info("enderchestdeathdrop enabled");
  }

  public void onDisable() {
    LOGGER.info("enderchestdeathdrop disabled");
  }
}
