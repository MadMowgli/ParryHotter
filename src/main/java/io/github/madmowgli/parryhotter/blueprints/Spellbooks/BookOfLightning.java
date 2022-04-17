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

public class BookOfLightning extends Spellbook {

    // Constructor
    public BookOfLightning(JavaPlugin parent) {
        super("Book of Lightning", School.LIGHTNING, 3500);

        // Create ItemStack
        ItemStack bookOfLightning = new ItemStack(Material.BOOK);
        NamespacedKey namespacedKey = new NamespacedKey(parent, "bookOfLightning");

        // Item Meta
        ItemMeta bookOfLightningItemMeta = bookOfLightning.getItemMeta();
        bookOfLightningItemMeta.setDisplayName(ChatColor.AQUA + "Spellbook of Lightning");
        ArrayList<String> bookOfLightningLore = new ArrayList<>();
        bookOfLightningLore.add("Spoken of in legend, blue lightning is the weapon,");
        bookOfLightningLore.add("wielded by the ancient dragons.");
        bookOfLightningItemMeta.setLore(bookOfLightningLore);
        bookOfLightning.setItemMeta(bookOfLightningItemMeta);
        this.setItemStack(bookOfLightning);

        // Shape
        ShapedRecipe bookOfLightningRecipe = new ShapedRecipe(namespacedKey, bookOfLightning);
        bookOfLightningRecipe.shape("SBP", "SBP", "SBP");
        bookOfLightningRecipe.setIngredient('S', Material.SOUL_LANTERN);
        bookOfLightningRecipe.setIngredient('B', Material.BOOK);
        bookOfLightningRecipe.setIngredient('P', Material.BLAZE_POWDER);
        this.setShapedRecipe(bookOfLightningRecipe);
//        bookOfFire.setItemMeta(magicWandMeta);

    }

}
