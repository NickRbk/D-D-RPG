package io.rybak.model.hero.elf.mage.abilities;

import io.rybak.model.hero.AbstractAbility;

public class FrostBolt extends AbstractAbility {

    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public FrostBolt() {
        super("Frost Bolt", 20, DAMAGE_OPTIONS, 1);
    }

    @Override
    public void specialAbility() {
    }
}
