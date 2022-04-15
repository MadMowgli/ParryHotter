package io.github.madmowgli.parryhotter.blueprints;

import org.bukkit.entity.*;

public enum School {

    // Enums
    WATER(LlamaSpit.class),
    FIRE(LargeFireball.class),
    LIGHTNING(Egg.class),       // The egg is made visible & only used to cast a lightning strike on where it hits the ground
    DEATH(WitherSkull.class),
    SPECTRAL(SpectralArrow.class);

    // Fields
    public final Class<? extends Projectile> projectile;

    // Constructor
    private School(Class<? extends Projectile> projectile) {
        this.projectile = projectile;
    }
}
