package io.rybak.model.enemy.kind.creature;

import io.rybak.model.enemy.AbstractMonster;

public class BlackDragon extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {3, 10};

    public BlackDragon() {
        super("Creature", "Black Dragon", 400, 50, 500);
        this.setSpellImmune(true);
    }

    @Override
    public int attack() {
        // implement damage option, Spell imune
        return 0;
    }
}
