package io.github.madmowgli.parryhotter.listeners;

import io.github.madmowgli.parryhotter.ParryHotter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import io.github.madmowgli.parryhotter.blueprints.Spellbook;

    /*
     /  We listen for both right- and left clicks when wielding the wand (either in main- or offhand)
     /  Multiple scenarios are possible:
     /
     /  - The wand is wielded in the main hand:
     /      - Left click:   Cast default spell
     /      - Right click:  Ignore event
     /  - The wand is wielded in the offhand and NO spell book is equipped:
     /      - Left click:   Ignore event
     /      - Right click:  Cast default spell
     /  ------------------------------------------------------------------------- (THIS WILL BE PART OF v.2.0)
     /  - The wand is wielded in the main hand and a spell book is equipped in the offhand:
     /      - Left click:   Cast default spell
     /      - Right click:  Cast special spell
     */

public class ClickListener implements Listener {

    // Vars
    private final ParryHotter parent;

    // Constructor for dependency injection
    public ClickListener(ParryHotter parent) {
        this.parent = parent;
    }

    // Event handler
    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        // Only listen for events related to our magic wand
        if(event.getItem() != null) {
            if(event.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Magic Wand")) {

                // Grab name
                String playerUUID = event.getPlayer().getUniqueId().toString();
                Action playerAction = event.getAction();
                ItemStack mainHandItem = event.getPlayer().getInventory().getItemInMainHand();
                ItemStack offHandItem = event.getPlayer().getInventory().getItemInOffHand();

                // Prevent wand from being placed
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    event.setCancelled(true);
                }

                // Left click (with or without spell book)
                if(playerAction == Action.LEFT_CLICK_AIR || (playerAction == Action.LEFT_CLICK_BLOCK)) {

                    // Valid cooldown
                    if(parent.coolDowns.containsKey(playerUUID)
                            && (System.currentTimeMillis() - parent.coolDowns.get(playerUUID)) > (long) 759) {
                        event.getPlayer().launchProjectile(Arrow.class);
                        parent.coolDowns.put(playerUUID, System.currentTimeMillis());
                    }

                    // First time shooter
                    else if (!parent.coolDowns.containsKey(playerUUID)) {
                        event.getPlayer().launchProjectile(Arrow.class);
                        parent.coolDowns.put(playerUUID, System.currentTimeMillis());
                    }
                }

                // Right click with spell book
                if(playerAction == Action.RIGHT_CLICK_AIR || playerAction == Action.RIGHT_CLICK_BLOCK
                && parent.bookMap.containsKey(offHandItem)) {

                    Spellbook spellbook = parent.bookMap.get(offHandItem);

                    // Check cooldown
                    if((System.currentTimeMillis() - parent.coolDowns.get(playerUUID)) > spellbook.getCoolDown()) {
                        event.getPlayer().launchProjectile(spellbook.getProjectile());
                        parent.coolDowns.put(playerUUID, System.currentTimeMillis());
                    }

                    // First time shooter
                    else if (!parent.coolDowns.containsKey(playerUUID)) {
                        event.getPlayer().launchProjectile(spellbook.getProjectile());
                        parent.coolDowns.put(playerUUID, System.currentTimeMillis());
                    }

                }

            }
        }
    }
}
