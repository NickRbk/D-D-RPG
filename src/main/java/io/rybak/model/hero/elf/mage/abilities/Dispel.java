package io.rybak.model.hero.elf.mage.abilities;

import io.rybak.model.hero.AbstractAbility;

public class Dispel extends AbstractAbility {

    public Dispel() {
        super("Dispel", 20, null, 3);
    }

    @Override
    public void specialAbility() {
        // implement dispel any spell
    }
}
