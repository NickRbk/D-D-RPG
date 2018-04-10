package cursor.rybak.model.enemy.kind.undead;

import cursor.rybak.model.enemy.AbstractMonster;

public class Zombie extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Zombie() {
        super("Undead", "Zombie", 80, 5, 15);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
