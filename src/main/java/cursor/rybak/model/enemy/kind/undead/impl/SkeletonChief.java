package cursor.rybak.model.enemy.kind.undead.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.undead.Undeads;

public class SkeletonChief extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public SkeletonChief() {
        super(MonsterKinds.UNDEAD.getKind(), Undeads.SkeletonChief.getName(), Undeads.SkeletonChief.getHealth(),
                Undeads.SkeletonChief.getInitiative(), Undeads.SkeletonChief.getCost());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
