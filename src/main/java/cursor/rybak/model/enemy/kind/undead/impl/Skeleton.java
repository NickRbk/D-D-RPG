package cursor.rybak.model.enemy.kind.undead.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.undead.Undeads;

public class Skeleton extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Skeleton() {
        super(MonsterKinds.UNDEAD.getKind(), Undeads.Skeleton.getName(), Undeads.Skeleton.getHealth(),
                Undeads.Skeleton.getInitiative(), Undeads.Skeleton.getCost());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
