package cursor.rybak.model.enemy.kind.undead.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.undead.Undeads;

public class BoneDragon extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {3, 10};

    public BoneDragon() {
        super(MonsterKinds.UNDEAD.getKind(), Undeads.BoneDragon.getName(), Undeads.BoneDragon.getHealth(),
                Undeads.BoneDragon.getInitiative(), Undeads.BoneDragon.getCost());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
