package net.nexia.chairsreloaded;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class ChairData
{

    ChairsReloaded main = ChairsReloaded.getMain();

    protected Player player;
    public Block chair;
    private ArmorStand stand;
    private BukkitTask task;

    public ChairData(Player player, Block chair)
    {
        this.player = player;
        this.chair = chair;

        sit();
    }

    private void sit()
    {
        Location loc = chair.getLocation().add(0.5, 0.3, 0.5);
        stand = chair.getWorld().spawn(loc, ArmorStand.class, (settings) ->
        {
            settings.setVisible(false);
            settings.setGravity(false);
            settings.setMarker(true);
            settings.setSmall(true);
            settings.setCollidable(false);
            settings.setInvulnerable(true);
            settings.addPassenger(player);
        });

        task = Bukkit.getScheduler().runTaskTimerAsynchronously(main, () ->
        {
            try
            {
                stand.setRotation(player.getLocation().getYaw(), 0);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }, 3, 3);
    }

    public void dismount()
    {
        Bukkit.getScheduler().cancelTask(task.getTaskId());
        player.leaveVehicle();
        stand.remove();

        //When Player teleports away after dismounts it gives errors, so this is a 1 tick delay to fix that.
        if (main.getConfig().getBoolean("dismountAboveChair") && player.isSneaking())
            Bukkit.getScheduler().scheduleSyncDelayedTask(main, () -> player.teleport(player.getLocation().add(0, 0.8, 0)), 1);
    }

}
