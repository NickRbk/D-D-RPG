package io.rybak.model.hero.elf.mage.abilities;

import io.rybak.model.hero.AbstractAbility;

public class Dispell extends AbstractAbility {

    public Dispell() {
        super("Dispell", 20, null, 3);
    }

    @Override
    public void specialAbility() {
        // implement dispell any spell
    }
}
