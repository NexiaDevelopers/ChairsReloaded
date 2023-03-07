package net.nexia.chairsreloaded.Utilities;

import co.aikar.commands.BukkitCommandManager;
import net.nexia.chairsreloaded.Commands.ChairsReloadedCommands;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandRegistry
{

    /**
     * Registers all the Commands.
     */
    public CommandRegistry(JavaPlugin plugin)
    {
        BukkitCommandManager manager = new BukkitCommandManager(plugin);
        manager.registerCommand(new ChairsReloadedCommands());
    }

}