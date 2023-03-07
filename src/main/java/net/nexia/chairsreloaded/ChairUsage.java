package net.nexia.chairsreloaded;

import net.nexia.chairsreloaded.Utilities.Utilities;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.spigotmc.event.entity.EntityDismountEvent;

public class ChairUsage implements Listener
{

    ChairsReloaded main = ChairsReloaded.getMain();

    /**
     * Mount the Player when they interact with a Chair.
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e)
    {
        Player player = e.getPlayer();
        Block clickedBlock = e.getClickedBlock();
        if (clickedBlock == null) return;
        Material clickedBlockType = clickedBlock.getType();
        FileConfiguration config = main.getConfig();

        //Checks whether Player has toggled the plugin
        PersistentDataContainer dataContainer = e.getPlayer().getPersistentDataContainer();
        var disabled = dataContainer.getOrDefault(new NamespacedKey(main, "sitDisabled"), PersistentDataType.BYTE, Byte.valueOf("0"));
        if (disabled == 1) return;

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && player.getInventory().getItemInMainHand().getType() == Material.AIR &&
                (clickedBlockType.name().contains("SLAB") || clickedBlockType.name().contains("STAIRS")))
        {
            //Checks if current world is BlackListed
            for (String world : config.getStringList("blacklistedWorlds"))
            {
                if (e.getClickedBlock().getWorld().getName().equals(world))
                    return;
            }

            //Checks if there is space above the Chair if enabled via config
            if (main.getConfig().getBoolean("checkForEmptySpace"))
            {
                boolean found = false;

                //Checks for ignored blocks for empty space via config
                for (String block : config.getStringList("ignoredEmptySpaceBlocks"))
                {
                    if (clickedBlock.getLocation().add(0, 1, 0).getBlock().getType().toString().startsWith(block) ||
                            clickedBlock.getLocation().add(0, 1, 0).getBlock().getType().toString().contains("_" + block))
                    {
                        found = true;
                        break;
                    }
                }

                if (!found) return;
            }

            //Checks if Block is Stair or Slab
            if (e.getClickedBlock().getBlockData() instanceof Stairs stair)
            {
                if (stair.getHalf() != Bisected.Half.TOP)
                    if (!Utilities.isOccupied(e.getClickedBlock()))
                        Utilities.sit(e.getPlayer(), e.getClickedBlock());
            }
            else if (e.getClickedBlock().getBlockData() instanceof Slab slab)
            {
                if (slab.getType() != Slab.Type.TOP && slab.getType() != Slab.Type.DOUBLE)
                {
                    if (!Utilities.isOccupied(e.getClickedBlock()))
                        Utilities.sit(e.getPlayer(), e.getClickedBlock());
                }
            }
        }
    }

    /**
     * Dismount the Player onEntityDismount.
     */
    @EventHandler
    public void onEntityDismount(EntityDismountEvent e)
    {
        if (e.getEntity() instanceof Player player)
        {
            if (Utilities.isSitting(player.getUniqueId()))
                Utilities.dismount(player);
        }
    }

    /**
     * Dismount the Player onPlayerTeleport.
     */
    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e)
    {
        if (Utilities.isSitting(e.getPlayer().getUniqueId()))
            Utilities.dismount(e.getPlayer());
    }

    /**
     * Dismount the Player onPlayerDeath.
     */
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        if (Utilities.isSitting(e.getEntity().getUniqueId()))
            Utilities.dismount(e.getEntity());
    }

    /**
     * Dismount the Player onBlockBreak.
     */
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e)
    {
        if (Utilities.isOccupied(e.getBlock()))
            Utilities.dismount(e.getBlock());
    }

    /**
     * Dismount the Player onPistonExtend.
     */
    @EventHandler
    public void onPistonExtend(BlockPistonExtendEvent e)
    {
        for (Block b : e.getBlocks())
        {
            if (Utilities.isOccupied(b))
            {
                Utilities.dismount(b);
                break;
            }
        }
    }

    /**
     * Dismount the Player onPistonRetract.
     */
    @EventHandler
    public void onPistonRetract(BlockPistonRetractEvent e)
    {
        for (Block b : e.getBlocks())
        {
            if (Utilities.isOccupied(b))
            {
                Utilities.dismount(b);
                break;
            }
        }
    }

    /**
     * Dismount the Player onExplosion.
     */
    @EventHandler
    public void onExplosion(EntityExplodeEvent e)
    {
        for (Block b : e.blockList())
        {
            if (Utilities.isOccupied(b))
            {
                Utilities.dismount(b);
                break;
            }
        }
    }

    /**
     * Dismount the Player onPlayerQuit.
     */
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e)
    {
        if (Utilities.isSitting(e.getPlayer().getUniqueId()))
            Utilities.dismount(e.getPlayer());
    }

}
