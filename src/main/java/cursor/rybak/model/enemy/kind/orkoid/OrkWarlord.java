package cursor.rybak.model.enemy.kind.orkoid;

import cursor.rybak.model.enemy.AbstractMonster;

public class OrkWarlord extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public OrkWarlord() {
        super("Orkoid", "Ork Warlord", 150, 50, 40);
    }

    @Override
    public int attack() {
        // implement damage option, with splash (hit 1 additional target)
        return 0;
    }
}
