package cursor.rybak.model.enemy.kind.undead;

import cursor.rybak.model.enemy.AbstractMonster;

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
