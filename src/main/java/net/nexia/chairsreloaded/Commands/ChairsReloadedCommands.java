package net.nexia.chairsreloaded.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import net.nexia.chairsreloaded.ChairsReloaded;
import net.nexia.nexiaapi.Processes;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

@SuppressWarnings("Unused")
@CommandAlias("chairs")
public class ChairsReloadedCommands extends BaseCommand
{

    ChairsReloaded main = ChairsReloaded.getMain();

    @Subcommand("toggle")
    private void toggleSubcommand(Player player)
    {
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        byte disabled = dataContainer.getOrDefault(new NamespacedKey(main, "sitDisabled"), PersistentDataType.BYTE, Byte.valueOf("0"));
        dataContainer.set(new NamespacedKey(main, "sitDisabled"), PersistentDataType.BYTE, Byte.valueOf(disabled == 1 ? "0" : "1"));

        if (disabled == 0)
            player.sendMessage(Processes.color("&aChair sitting has been toggled to &coff&a."));
        else
            player.sendMessage(Processes.color("&aChair sitting has been toggled to &7on&a."));
    }

}
