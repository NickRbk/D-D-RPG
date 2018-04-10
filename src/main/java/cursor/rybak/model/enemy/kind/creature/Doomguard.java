package cursor.rybak.model.enemy.kind.creature;

import cursor.rybak.model.enemy.AbstractMonster;

public class Doomguard extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Doomguard() {
        super("Creature", "Doomguard", 60, 15, 15);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
