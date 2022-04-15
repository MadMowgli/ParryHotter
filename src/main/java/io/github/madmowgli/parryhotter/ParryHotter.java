package io.github.madmowgli.parryhotter;

import io.github.madmowgli.parryhotter.blueprints.MagicWand;
import io.github.madmowgli.parryhotter.listeners.ClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class ParryHotter extends JavaPlugin {

    // Vars
    public volatile HashMap<String, Long> cooldowns = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info("onEnabled is called.");

        // Add recipe
        try {
            Bukkit.addRecipe(MagicWand.getMagicWandRecipe(this));
        } catch (Exception e) {
            this.getLogger().severe("Couldn't load recipe: " + e.getMessage());
        }

        // Add event listener
        this.getServer().getPluginManager().registerEvents(new ClickListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("onDisabled is called.");
    }
}
