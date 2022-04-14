package io.github.madmowgli.parryhotter.blueprints;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.ArrayList;

public class MagicWand {

    // Method to create recipe
    public static ShapedRecipe getMagicWandRecipe(JavaPlugin parent) {

        // Create Item
        ItemStack magicWand = new ItemStack(Material.REDSTONE_TORCH);
        NamespacedKey namespacedKey = new NamespacedKey(parent, "magicWand");

        // Item Meta
        ItemMeta magicWandMeta = magicWand.getItemMeta();
        magicWandMeta.setDisplayName(ChatColor.GOLD + "Magic Wand");
        ArrayList<String> magicWandLore = new ArrayList<>();
        magicWandLore.add("With great power comes great responsibility..");
        magicWandMeta.setLore(magicWandLore);
        magicWand.setItemMeta(magicWandMeta);

        // Shape
        ShapedRecipe magicWandRecipe = new ShapedRecipe(namespacedKey, magicWand);
        magicWandRecipe.shape(" R ", " S ", " S ");
        magicWandRecipe.setIngredient('R', Material.REDSTONE);
        magicWandRecipe.setIngredient('S', Material.STICK);
        magicWand.setItemMeta(magicWandMeta);

        return magicWandRecipe;
    }

}
