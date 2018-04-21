package cursor.rybak.model.enemy.kind.orkoid.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.orkoid.Orkoids;

public class Ogre extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 10};

    public Ogre() {
        super(MonsterKinds.ORKOID.getKind(), Orkoids.Ogre.getName(), Orkoids.Ogre.getHealth(),
                Orkoids.Ogre.getInitiative(), Orkoids.Ogre.getCost());
    }

    @Override
    public int attack() {
        // implement damage option, can stun 15% chance
        return 0;
    }
}
