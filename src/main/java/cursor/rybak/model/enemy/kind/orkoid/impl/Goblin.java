package cursor.rybak.model.enemy.kind.orkoid.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.orkoid.Orkoids;

public class Goblin extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Goblin() {
        super(MonsterKinds.ORKOID.getKind(), Orkoids.Goblin.getName(), Orkoids.Goblin.getHealth(),
                Orkoids.Goblin.getInitiative(), Orkoids.Goblin.getCost());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
