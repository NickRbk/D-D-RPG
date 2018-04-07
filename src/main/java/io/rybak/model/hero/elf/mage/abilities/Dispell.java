package io.rybak.model.hero.elf.mage.abilities;

import io.rybak.model.hero.AbstractSpell;

public class Dispell extends AbstractSpell {

    public Dispell() {
        super("Dispell", 20, null, 3);
    }

    @Override
    public void specialSpell() {
        // implement dispell any spell
    }
}
