package cursor.rybak.model.enemy.kind.orkoid;

import cursor.rybak.model.enemy.AbstractMonster;

public class Goblin extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Goblin() {
        super("Orkoid", "Goblin", 35, 20, 10);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
