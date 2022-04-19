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

public class BookOfDeath extends Spellbook {

    // Constructor
    public BookOfDeath(JavaPlugin parent) {
        super("Book of Death", School.DEATH, 3100);

        // Create ItemStack
        ItemStack bookOfDeath = new ItemStack(Material.BOOK);
        NamespacedKey namespacedKey = new NamespacedKey(parent, "bookOfDeath");

        // Item Meta
        ItemMeta bookOfDeathItemMeta = bookOfDeath.getItemMeta();
        bookOfDeathItemMeta.setDisplayName(ChatColor.WHITE + "Spellbook of Death");
        ArrayList<String> bookOfDeathLore = new ArrayList<>();
        bookOfDeathLore.add("The assassins were themselves,");
        bookOfDeathLore.add("once Tarnished who had strayed from guidance,");
        bookOfDeathLore.add("and they pursued their duty,");
        bookOfDeathLore.add("in the darkness that is without grace.");
        bookOfDeathItemMeta.setLore(bookOfDeathLore);
        bookOfDeath.setItemMeta(bookOfDeathItemMeta);
        this.setItemStack(bookOfDeath);

        // Shape
        ShapedRecipe bookOfDeathRecipe = new ShapedRecipe(namespacedKey, bookOfDeath);
        bookOfDeathRecipe.shape("HBP", "HBP", "HBP");
        bookOfDeathRecipe.setIngredient('H', Material.SKELETON_SKULL);
        bookOfDeathRecipe.setIngredient('B', Material.BOOK);
        bookOfDeathRecipe.setIngredient('P', Material.BLAZE_POWDER);
        this.setShapedRecipe(bookOfDeathRecipe);
//        bookOfFire.setItemMeta(magicWandMeta);
    }


}
