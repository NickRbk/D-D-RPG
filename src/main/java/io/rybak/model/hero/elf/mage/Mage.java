package io.rybak.model.hero.elf.mage;

import io.rybak.model.race.impl.Elf;

public class Mage extends Elf {
    public Mage() {
        super("Mage");
    }

    @Override
    public int attack() {
        return 0;
    }
}
