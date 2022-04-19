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

public class BookOfWater extends Spellbook {

    // Constructor
    public BookOfWater(JavaPlugin parent) {
        super("Book of Water", School.WATER, 350);

        // Create ItemStack
        ItemStack bookOfWater = new ItemStack(Material.BOOK);
        NamespacedKey namespacedKey = new NamespacedKey(parent, "bookOfWater");

        // Item Meta
        ItemMeta bookOfWaterItemMeta = bookOfWater.getItemMeta();
        bookOfWaterItemMeta.setDisplayName(ChatColor.BLUE + "Spellbook of Water");
        ArrayList<String> bookOfWaterLore = new ArrayList<>();
        bookOfWaterLore.add("The ice dragons were once,");
        bookOfWaterLore.add("lords of the mountaintops long ago,");
        bookOfWaterLore.add("until they were defeated by the Fire Giants,");
        bookOfWaterLore.add("and chased from the peak.");
        bookOfWaterItemMeta.setLore(bookOfWaterLore);
        bookOfWater.setItemMeta(bookOfWaterItemMeta);
        this.setItemStack(bookOfWater);

        // Shape
        ShapedRecipe bookOfWaterRecipe = new ShapedRecipe(namespacedKey, bookOfWater);
        bookOfWaterRecipe.shape("IBG", "IBG", "IBG");
        bookOfWaterRecipe.setIngredient('I', Material.IRON_NUGGET);
        bookOfWaterRecipe.setIngredient('B', Material.BOOK);
        bookOfWaterRecipe.setIngredient('G', Material.GLOW_INK_SAC);
        this.setShapedRecipe(bookOfWaterRecipe);
//        bookOfFire.setItemMeta(magicWandMeta);

    }

}
