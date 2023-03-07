package net.nexia.chairsreloaded.Utilities;

import net.nexia.chairsreloaded.ChairUsage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EventRegistry
{

    public EventRegistry(JavaPlugin plugin)
    {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new ChairUsage(), plugin);
    }

}
