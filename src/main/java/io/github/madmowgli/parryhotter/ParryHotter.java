package io.github.madmowgli.parryhotter;

import io.github.madmowgli.parryhotter.blueprints.MagicWand;
import io.github.madmowgli.parryhotter.blueprints.Spellbook;
import io.github.madmowgli.parryhotter.blueprints.Spellbooks.*;
import io.github.madmowgli.parryhotter.listeners.ClickListener;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class ParryHotter extends JavaPlugin {

    // Vars
    private final BookOfWater bookOfWater = new BookOfWater(this);
    private final BookOfFire bookOfFire = new BookOfFire(this);
    private final BookOfLightning bookOfLightning = new BookOfLightning(this);
    private final BookOfSpectra bookOfSpectra = new BookOfSpectra(this);
    private final BookOfDeath bookOfDeath = new BookOfDeath(this);

    public HashMap<ItemStack, Spellbook> bookMap = new HashMap<ItemStack, Spellbook>();
    public volatile HashMap<String, Long> coolDowns = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info("onEnabled is called.");

        // Fill dictionary
        bookMap.put(bookOfWater.getItemStack(), bookOfWater);
        bookMap.put(bookOfFire.getItemStack(), bookOfFire);
        bookMap.put(bookOfLightning.getItemStack(), bookOfLightning);
        bookMap.put(bookOfSpectra.getItemStack(), bookOfSpectra);
        bookMap.put(bookOfDeath.getItemStack(), bookOfDeath);

        // Add Recipes
        Bukkit.addRecipe(MagicWand.getMagicWandRecipe(this));
        for (Spellbook spellbook : bookMap.values()) {
            Bukkit.addRecipe(spellbook.getShapedRecipe());
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
