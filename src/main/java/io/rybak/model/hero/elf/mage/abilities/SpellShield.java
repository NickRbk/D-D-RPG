package io.rybak.model.hero.elf.mage.abilities;

import io.rybak.model.hero.AbstractSpell;

public class SpellShield extends AbstractSpell {

    public SpellShield() {
        super("Spell Shield", 15, null, 2);
    }

    @Override
    public void specialSpell() {
        // implement block 60 dmg till destruction
    }
}
