package net.nexia.chairsreloaded.Events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.nexia.chairsreloaded.ChairsReloaded;
import net.nexia.nexiaapi.Versioner;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class NewVersionAvailability implements Listener
{

    /**
     * Sends a message to operators when a new version of the plugin is released.
     */
    @EventHandler
    private void versionAvailability(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();

        if (!player.isOp()) return;

        TextComponent message1 = new TextComponent("There is a new version available for ");
        TextComponent clickableMessage = new TextComponent("ChairsReloaded");
        clickableMessage.setColor(ChatColor.DARK_PURPLE);
        clickableMessage.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org/resources/1-13-1-19-4-%E2%AD%90-chairs-reloaded-%E2%AD%90-sitting-plugin.108963/"));
        clickableMessage.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to download latest version.")));
        TextComponent message2 = new TextComponent(".");

        try
        {
            if (Versioner.isNewVersionAvailable(ChairsReloaded.getMain().getDescription().getVersion(), 108963))
                player.spigot().sendMessage(message1, clickableMessage, message2);
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }

}
