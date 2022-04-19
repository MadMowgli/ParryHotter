package io.github.madmowgli.parryhotter.listeners;

import io.github.madmowgli.parryhotter.ParryHotter;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class ImpactListener implements Listener {

    // Vars
    private final ParryHotter parent;

    // Constructor
    public ImpactListener(ParryHotter parent) { this.parent = parent; }

    // Event handler
    @EventHandler
    public void onProjectileImpact(ProjectileHitEvent projectileHitEvent) {

        // Only listen for egg events
        if(projectileHitEvent.getEntity() instanceof Egg) {
            try {
                Player player = (Player) projectileHitEvent.getEntity().getShooter();
                ItemStack offHandItem = player.getInventory().getItemInOffHand();

                // Only cast if player has spellbook equipped
                if(parent.bookMap.containsKey(offHandItem)) {

                    // Player hit block
                    try {
                        player.getWorld().strikeLightning(projectileHitEvent.getHitBlock().getLocation());
                    } catch (Exception e) {

                        // Player hit another entity
                        player.getWorld().strikeLightning(projectileHitEvent.getHitEntity().getLocation());
                    }
                }
            } catch (Exception e) {
                parent.getLogger().severe("Exception: " + e.getMessage());
            }

        }

    }


}
