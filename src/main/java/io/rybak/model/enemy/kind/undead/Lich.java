package io.rybak.model.enemy.kind.undead;

import io.rybak.model.enemy.AbstractMonster;

public class Lich extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public Lich() {
        super("Undead", "Lich", 100, 20, 25);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
