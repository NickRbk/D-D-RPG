package cursor.rybak.model.enemy.kind.creature;

import cursor.rybak.model.enemy.AbstractMonster;

public class Succubus extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};
    private int coolDown = 4;

    public Succubus() {
        super("Creature", "Succubus", 100, 35, 35);
    }

    @Override
    public int attack() {
        // implement damage option, can cast fear
        return 0;
    }
}
