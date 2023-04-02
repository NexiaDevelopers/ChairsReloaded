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
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.io.File;
import java.util.Objects;

@SuppressWarnings("unused")
@CommandAlias("chairs")
public class ChairsReloadedCommands extends BaseCommand
{

    ChairsReloaded main = ChairsReloaded.getMain();

    File messagesConfig = new File(main.getDataFolder(), "messages.yml");
    YamlConfiguration messagesConfigYaml = YamlConfiguration.loadConfiguration(messagesConfig);
    ConfigurationSection chairsCommandMessages = messagesConfigYaml.getConfigurationSection("ChairsCommands");

    @Default
    private void invalidUsage(CommandSender sender)
    {
        //Message
        String invalidMessage = chairsCommandMessages.getString("InvalidUsage");

        Player player = (Player) sender;
        player.sendMessage(Processes.color(Objects.requireNonNull(invalidMessage)));
    }

    @Subcommand("toggle")
    @CommandPermission("nexia.chairsreloaded.chairs.toggle")
    private void toggleSubcommand(Player player)
    {
        //Message
        if (chairsCommandMessages == null) return;
        String onMessage = Objects.requireNonNull(chairsCommandMessages.getConfigurationSection("Toggle")).getString("ToggleOn");
        String offMessage = Objects.requireNonNull(chairsCommandMessages.getConfigurationSection("Toggle")).getString("ToggleOff");

        String version = Bukkit.getServer().getBukkitVersion().replace(".", "").split("-")[0];
        if (Integer.parseInt(version) >= 1140)  //For Versions 1.14 and up
        {
            PersistentDataContainer dataContainer = player.getPersistentDataContainer();
            byte disabled = dataContainer.getOrDefault(new NamespacedKey(main, "sitDisabled"), PersistentDataType.BYTE, Byte.valueOf("0"));
            dataContainer.set(new NamespacedKey(main, "sitDisabled"), PersistentDataType.BYTE, Byte.valueOf(disabled == 0 ? "1" : "0"));

            if (disabled == 0)
                player.sendMessage(Processes.color(Objects.requireNonNull(onMessage)));
            else
                player.sendMessage(Processes.color(Objects.requireNonNull(offMessage)));
        }
        else //For Versions 1.13 and down
        {
            if (Utilities.isSitToggled)
            {
                Utilities.isSitToggled = false;
                player.sendMessage(Processes.color(Objects.requireNonNull(offMessage)));
            }
            else
            {
                Utilities.isSitToggled = true;
                player.sendMessage(Processes.color(Objects.requireNonNull(onMessage)));
            }
        }
    }

}
