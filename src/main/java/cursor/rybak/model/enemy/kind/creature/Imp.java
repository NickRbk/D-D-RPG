package cursor.rybak.model.enemy.kind.creature;

import cursor.rybak.model.enemy.AbstractMonster;

public class Imp extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Imp() {
        super("Creature", "Imp", 30, 15, 10);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
