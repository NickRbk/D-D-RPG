package cursor.rybak.model.enemy.kind.undead.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.kind.undead.Undeads;

public class Lich extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public Lich() {
        super("Undead", Undeads.Lich.getName(), Undeads.Lich.getHealth(),
                Undeads.Lich.getInitiative(), Undeads.Lich.getCost());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
