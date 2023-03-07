package net.nexia.chairsreloaded.Utilities;

import net.nexia.chairsreloaded.ChairData;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Utilities
{

    private static final HashMap<UUID, ChairData> occupied = new HashMap<>();

    /**
     * Checks if the current Chair is occupied.
     * @param chair The Chair Block.
     * @return Returns true if the block is occupied.
     */
    public static boolean isOccupied(Block chair)
    {
        for (UUID uuid : occupied.keySet())
        {
            if (occupied.get(uuid).chair.equals(chair))
                return true;
        }

        return false;
    }

    /**
     * Checks whether a Player is sitting.
     * @param uuid The UUID of the Player.
     * @return Returns true if Player is sitting.
     */
    public static boolean isSitting(UUID uuid)
    {
        return occupied.containsKey(uuid);
    }

    /**
     * Makes a Player sit on a Chair (block)
     * @param player The Player to sit.
     * @param chair The Chair (block) to sit on.
     */
    public static void sit(Player player, Block chair)
    {
        if (occupied.containsKey(player.getUniqueId()))
        {
            if (occupied.get(player.getUniqueId()).chair.equals(chair))
                return;

            dismount(player);
        }

        occupied.put(player.getUniqueId(), new ChairData(player, chair));
    }

    /**
     * Makes a seated Player get up.
     * @param player The Player to un-sit.
     */
    public static void dismount(Player player)
    {
        occupied.get(player.getUniqueId()).dismount();
        occupied.remove(player.getUniqueId());
    }

    /**
     * Makes a seated Player on a specific block get up.
     * @param chair The Chair (block) to un-sit a Player from.
     */
    public static void dismount(Block chair)
    {
        UUID remove = null;

        for (UUID uuid : occupied.keySet())
        {
            ChairData data = occupied.get(uuid);

            if (data.chair.equals(chair))
            {
                data.dismount();
                remove = uuid;
                break;
            }
        }

        if (remove != null)
            occupied.remove(remove);
    }

}
