package io.github.madmowgli.parryhotter.blueprints;

import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public abstract class Spellbook {

    // Fields
    private final String name;
    private final School school;
    private final long coolDown;
    private ItemStack itemStack;
    private ShapedRecipe shapedRecipe;

    // Constructor
    public Spellbook(String name, School school, long coolDown) {
        this.name = name;
        this.school = school;
        this.coolDown = coolDown;
    }

    // Methods
    public String getName() { return this.name; }
    public School getSchool() { return this.school; }
    public long getCoolDown() { return this.coolDown; }
    public Class<? extends Projectile> getProjectile() { return this.school.projectile; }
    public ItemStack getItemStack() { return this.itemStack; }
    public ShapedRecipe getShapedRecipe() {return this.shapedRecipe; }

    public void setItemStack(ItemStack itemStack) { this.itemStack = itemStack; }
    public void setShapedRecipe(ShapedRecipe shapedRecipe) { this.shapedRecipe = shapedRecipe; }



}
