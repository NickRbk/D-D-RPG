package io.rybak.model.enemy.kind.creature;

import io.rybak.model.enemy.AbstractMonster;

public class Minotaur extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public Minotaur() {
        super("Creature", "Minotaur", 150, 40, 40);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
