package cursor.rybak.model.enemy.kind.creature.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.creature.Creatures;

public class Minotaur extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public Minotaur() {
        super(MonsterKinds.CREATURE.getKind(), Creatures.Minotaur.getName(), Creatures.Minotaur.getHealth(),
                Creatures.Minotaur.getInitiative(), Creatures.Minotaur.getCost());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
