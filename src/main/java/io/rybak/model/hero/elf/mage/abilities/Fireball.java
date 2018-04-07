package io.rybak.model.hero.elf.mage.abilities;

import io.rybak.model.hero.AbstractSpell;

public class Fireball extends AbstractSpell {

    private static final int[] DAMAGE_OPTIONS = {3, 10};

    public Fireball() {
        super("Fireball", 45, DAMAGE_OPTIONS, 3);
    }

    @Override
    public void specialSpell() {
    }
}
