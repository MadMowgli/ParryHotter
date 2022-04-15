package io.github.madmowgli.parryhotter.blueprints;

import org.bukkit.entity.Projectile;

public abstract class Spellbook {

    // Fields
    private final String name;
    private final School school;
    private final long coolDown;

    // Constructor
    public Spellbook(String name, School school, long coolDown) {
        this.name = name;
        this.school = school;
        this.coolDown = coolDown;
    }

    // Methods
    public String getName() { return this.name; }
    public School getFlavour() { return this.school; }
    public long getCoolDown() { return this.coolDown; }

}
