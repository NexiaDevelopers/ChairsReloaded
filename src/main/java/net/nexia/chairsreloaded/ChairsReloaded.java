package net.nexia.chairsreloaded;

import net.nexia.chairsreloaded.Utilities.CommandRegistry;
import net.nexia.chairsreloaded.Utilities.EventRegistry;
import net.nexia.chairsreloaded.Utilities.FileSetup;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChairsReloaded extends JavaPlugin
{

    //Main Instance
    private static ChairsReloaded chairsReloaded;

    @Override
    public void onEnable()
    {
        //Main Instance
        chairsReloaded = this;

        //Utilities
        new CommandRegistry(this);
        new EventRegistry(this);
        new FileSetup(this);

        //Config Access
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    //Main Instance
    public static ChairsReloaded getMain() { return chairsReloaded; }

}
