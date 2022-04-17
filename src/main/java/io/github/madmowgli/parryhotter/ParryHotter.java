package io.github.madmowgli.parryhotter;

import io.github.madmowgli.parryhotter.blueprints.MagicWand;
import io.github.madmowgli.parryhotter.blueprints.Spellbook;
import io.github.madmowgli.parryhotter.blueprints.Spellbooks.*;
import io.github.madmowgli.parryhotter.listeners.ClickListener;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class ParryHotter extends JavaPlugin {

    // Vars
    public volatile HashMap<String, Long> cooldowns = new HashMap<>();
    private final BookOfWater bookOfWater = new BookOfWater();
    private final BookOfFire bookOfFire = new BookOfFire();
    private final BookOfLightning bookOfLightning = new BookOfLightning();
    private final BookOfSpectra bookOfSpectra = new BookOfSpectra();
    private final BookOfDeath bookOfDeath = new BookOfDeath();
    public ArrayList<Spellbook> spellBooks = new ArrayList<>(Arrays.asList(
            bookOfWater, bookOfFire, bookOfLightning, bookOfSpectra, bookOfDeath
    ));
    public ArrayList<ItemStack> spellBookItemStacks = new ArrayList<>(Arrays.asList(
            bookOfWater.getItemStack(), bookOfFire.getItemStack(), bookOfLightning.getItemStack(),
            bookOfSpectra.getItemStack(), bookOfDeath.getItemStack()
    ));
    public HashMap<ItemStack, Spellbook> bookMap = new HashMap<ItemStack, Spellbook>();

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
