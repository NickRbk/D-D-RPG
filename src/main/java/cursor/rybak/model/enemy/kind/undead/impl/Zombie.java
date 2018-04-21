package cursor.rybak.model.enemy.kind.undead.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.undead.Undeads;

public class Zombie extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Zombie() {
        super(MonsterKinds.UNDEAD.getKind(), Undeads.Zombie.getName(), Undeads.Zombie.getHealth(),
                Undeads.Zombie.getInitiative(), Undeads.Zombie.getCost());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
