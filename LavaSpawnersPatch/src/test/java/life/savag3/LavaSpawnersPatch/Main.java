package life.savag3.LavaSpawnersPatch;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
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

    @EventHandler
    public void Et(EntityDamageByBlockEvent e) {
        if (e.getEntity() instanceof Item) {
            ItemStack item = ((Item) e.getEntity()).getItemStack();
            if (item.getType().equals(Material.MOB_SPAWNER)) {
                if (e.getDamager().getType().equals(Material.LAVA) || e.getDamager().getType().equals(Material.STATIONARY_LAVA) || e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)|| e.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
