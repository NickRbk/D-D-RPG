package cursor.rybak.model.enemy.kind.orkoid.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.orkoid.Orkoids;

public class Ork extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public Ork() {
        super(MonsterKinds.ORKOID.getKind(), Orkoids.Ork.getName(), Orkoids.Ork.getHealth(),
                Orkoids.Ork.getInitiative(), Orkoids.Ork.getCost());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
