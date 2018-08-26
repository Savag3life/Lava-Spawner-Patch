package life.savag3.LavaSpawnerPatch;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    // LAVA HANDLER
    @EventHandler(priority = EventPriority.HIGHEST)
    public void LavaHandler(EntityDamageEvent e) {
        if (e.getEntity() instanceof Item) {
            ItemStack item = ((Item) e.getEntity()).getItemStack();
            if (item.getType().equals(Material.MOB_SPAWNER)) {
                    e.setCancelled(true);
            }
        }
    }

    // TNT Handler
    @EventHandler
    public void TNTHandler (EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Item) {
            ItemStack item = ((Item) e.getEntity()).getItemStack();
            if (item.getType().equals(Material.MOB_SPAWNER)) {
                e.setCancelled(true);
            }
        }
    }

}
