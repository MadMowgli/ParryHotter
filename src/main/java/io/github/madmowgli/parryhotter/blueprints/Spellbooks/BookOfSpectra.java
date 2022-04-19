package io.github.madmowgli.parryhotter.blueprints.Spellbooks;

import io.github.madmowgli.parryhotter.blueprints.School;
import io.github.madmowgli.parryhotter.blueprints.Spellbook;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class BookOfSpectra extends Spellbook {

    // Constructor
    public BookOfSpectra(JavaPlugin parent) {
        super("Book of Spectra", School.SPECTRAL, 1800);

        // Create ItemStack
        ItemStack bookOfSpectra = new ItemStack(Material.BOOK);
        NamespacedKey namespacedKey = new NamespacedKey(parent, "bookOfSpectra");

        // Item Meta
        ItemMeta bookOfSpectraItemMeta = bookOfSpectra.getItemMeta();
        bookOfSpectraItemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Spellbook of Spectra");
        ArrayList<String> bookOfSpectraLore = new ArrayList<>();
        bookOfSpectraLore.add("The assassins were charged,");
        bookOfSpectraLore.add("with eliminating Tarnished,");
        bookOfSpectraLore.add("who had strayed from guidance.");
        bookOfSpectraItemMeta.setLore(bookOfSpectraLore);
        bookOfSpectra.setItemMeta(bookOfSpectraItemMeta);
        this.setItemStack(bookOfSpectra);

        // Shape
        ShapedRecipe bookOfLightningRecipe = new ShapedRecipe(namespacedKey, bookOfSpectra);
        bookOfLightningRecipe.shape("SBP", "SBP", "SBP");
        bookOfLightningRecipe.setIngredient('S', Material.AMETHYST_SHARD);
        bookOfLightningRecipe.setIngredient('B', Material.BOOK);
        bookOfLightningRecipe.setIngredient('P', Material.BLAZE_POWDER);
        this.setShapedRecipe(bookOfLightningRecipe);
//        bookOfFire.setItemMeta(magicWandMeta);

    }

}
