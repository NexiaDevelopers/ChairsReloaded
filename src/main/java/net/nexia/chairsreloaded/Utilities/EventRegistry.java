package net.nexia.chairsreloaded.Utilities;

import net.nexia.chairsreloaded.Events.ChairUsage;
import net.nexia.chairsreloaded.Events.NewVersionAvailability;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EventRegistry
{

    public EventRegistry(JavaPlugin plugin)
    {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ChairUsage(), plugin);
        pluginManager.registerEvents(new NewVersionAvailability(), plugin);
    }

}
