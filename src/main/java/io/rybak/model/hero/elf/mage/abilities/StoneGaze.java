package io.rybak.model.hero.elf.mage.abilities;

import io.rybak.model.hero.AbstractSpell;

public class StoneGaze extends AbstractSpell {

    public StoneGaze() {
        super("Stone Gaze", 20, null, 4);
    }

    @Override
    public void specialSpell() {
        // implement transform enemy into stone
        // for 2 turns
    }
}
