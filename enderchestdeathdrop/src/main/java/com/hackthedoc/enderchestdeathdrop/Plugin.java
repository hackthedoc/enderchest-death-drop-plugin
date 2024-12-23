package com.hackthedoc.enderchestdeathdrop;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * enderchestdeathdrop java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("enderchestdeathdrop");

  public void onEnable()
  {
    LOGGER.info("enderchestdeathdrop enabled");
  }

  public void onDisable()
  {
    LOGGER.info("enderchestdeathdrop disabled");
  }
}
