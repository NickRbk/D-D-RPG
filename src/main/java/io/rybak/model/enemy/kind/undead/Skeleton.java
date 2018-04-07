package io.rybak.model.enemy.kind.undead;

import io.rybak.model.enemy.AbstractMonster;

public class Skeleton extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Skeleton() {
        super("Undead", "Skeleton", 40, 10, 5);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
