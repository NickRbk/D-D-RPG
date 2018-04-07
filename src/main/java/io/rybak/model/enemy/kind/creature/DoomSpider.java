package io.rybak.model.enemy.kind.creature;

import io.rybak.model.enemy.AbstractMonster;

public class DoomSpider extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 3};

    public DoomSpider() {
        super("Creature", "Doom Spider", 10, 5, 3);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
