package cursor.rybak.model.enemy.kind.undead.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.undead.Undeads;

public class Banshee extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 10};

    public Banshee() {
        super(MonsterKinds.UNDEAD.getKind(), Undeads.Banshee.getName(), Undeads.Banshee.getHealth(),
                Undeads.Banshee.getInitiative(), Undeads.Banshee.getCost());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
