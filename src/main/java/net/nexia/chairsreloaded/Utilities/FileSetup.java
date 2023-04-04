package net.nexia.chairsreloaded.Utilities;

import net.nexia.chairsreloaded.ChairsReloaded;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class FileSetup
{

    /**
     * Setup for the basic files needed for the plugin to work.
     * @param javaPlugin The Plugin instance.
     */
    public FileSetup(JavaPlugin javaPlugin)
    {
        //Example Files

        File messagesFile = new File(ChairsReloaded.getMain().getDataFolder(), "messages.yml");
        if (!messagesFile.exists())
            javaPlugin.saveResource("messages.yml", false);
    }


}
