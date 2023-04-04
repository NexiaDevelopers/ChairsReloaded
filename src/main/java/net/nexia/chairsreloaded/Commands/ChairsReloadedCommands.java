package net.nexia.chairsreloaded.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import net.nexia.chairsreloaded.ChairsReloaded;
import net.nexia.chairsreloaded.Utilities.Utilities;
import net.nexia.nexiaapi.Processes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

@SuppressWarnings("unused")
@CommandAlias("chairs")
public class ChairsReloadedCommands extends BaseCommand
{

    ChairsReloaded main = ChairsReloaded.getMain();

    @Default
    private void invalidUsage(Player player)
    {
        player.sendMessage(Processes.color("&cInvalid usage. Use &7/chairs toggle&c."));
    }

    @Subcommand("toggle")
    @CommandPermission("nexia.chairsreloaded.chairs.toggle")
    private void toggleSubcommand(Player player)
    {
        String version = Bukkit.getServer().getBukkitVersion().replace(".", "").split("-")[0];
        if (Integer.parseInt(version) >= 1140)  //For Versions 1.14 and up
        {
            PersistentDataContainer dataContainer = player.getPersistentDataContainer();
            byte disabled = dataContainer.getOrDefault(new NamespacedKey(main, "sitDisabled"), PersistentDataType.BYTE, Byte.valueOf("0"));
            dataContainer.set(new NamespacedKey(main, "sitDisabled"), PersistentDataType.BYTE, Byte.valueOf(disabled == 0 ? "1" : "0"));

            if (disabled == 0)
                player.sendMessage(Processes.color("&aChair sitting has been toggled to &coff&a."));
            else
                player.sendMessage(Processes.color("&aChair sitting has been toggled to &7on&a."));
        }
        else //For Versions 1.13 and down
        {
            if (Utilities.isSitToggled)
            {
                Utilities.isSitToggled = false;
                player.sendMessage(Processes.color("&aChair sitting has been toggled to &coff&a."));
            }
            else
            {
                Utilities.isSitToggled = true;
                player.sendMessage(Processes.color("&aChair sitting has been toggled to &7on&a."));
            }
        }
    }

}
