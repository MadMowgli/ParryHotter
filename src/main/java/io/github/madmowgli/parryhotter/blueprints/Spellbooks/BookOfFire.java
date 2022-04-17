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

public class BookOfFire extends Spellbook {

    // Constructor
    public BookOfFire(JavaPlugin parent) {
        super("Book of Fire", School.FIRE, 2500);

        // Create ItemStack
        ItemStack bookOfFire = new ItemStack(Material.BOOK);
        NamespacedKey namespacedKey = new NamespacedKey(parent, "bookOfFire");

        // Item Meta
        ItemMeta bookOfFireItemMeta = bookOfFire.getItemMeta();
        bookOfFireItemMeta.setDisplayName(ChatColor.DARK_RED + "Spellbook of Fire");
        ArrayList<String> bookOfFireLore = new ArrayList<>();
        bookOfFireLore.add("Arghanthy, the chief guardian of the Flame, had kept this incantation a well-kept secret,");
        bookOfFireLore.add("until it was stolen by Adan. The fell god still lurks within the Fire Giants.");
        bookOfFireItemMeta.setLore(bookOfFireLore);
        bookOfFire.setItemMeta(bookOfFireItemMeta);
        this.setItemStack(bookOfFire);

        // Shape
        ShapedRecipe bookOfFireRecipe = new ShapedRecipe(namespacedKey, bookOfFire);
        bookOfFireRecipe.shape("RBP", "RBP", "RBP");
        bookOfFireRecipe.setIngredient('R', Material.BLAZE_ROD);
        bookOfFireRecipe.setIngredient('B', Material.BOOK);
        bookOfFireRecipe.setIngredient('P', Material.BLAZE_POWDER);
        this.setShapedRecipe(bookOfFireRecipe);
//        bookOfFire.setItemMeta(magicWandMeta);
    }

}
