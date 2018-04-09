package univ.rybak.model.enemy.kind.undead;

import univ.rybak.model.enemy.AbstractMonster;

public class Banshee extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 10};

    public Banshee() {
        super("Undead", "Banshee", 75, 15, 15);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
