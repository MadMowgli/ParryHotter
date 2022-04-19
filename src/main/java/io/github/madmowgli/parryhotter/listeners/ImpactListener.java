package io.github.madmowgli.parryhotter.listeners;

import io.github.madmowgli.parryhotter.ParryHotter;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

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
            Player player = (Player) projectileHitEvent.getEntity().getShooter();
            parent.getLogger().info("Shooter: " + player.getDisplayName());
        }

    }


}
