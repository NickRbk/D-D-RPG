package cursor.rybak.model.enemy.kind.orkoid;

import cursor.rybak.model.enemy.AbstractMonster;

public class Ork extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public Ork() {
        super("Orkoid", "Ork", 100, 30, 18);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
