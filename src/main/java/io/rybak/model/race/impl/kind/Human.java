package io.rybak.model.race.impl.kind;

import io.rybak.model.race.impl.AbstractRace;

public class Human extends AbstractRace {

    public Human(String heroName) {
        super("Human", heroName, 10, 30, 20, 15, 15);
    }

    /**
     * @return int, damage point
     * functionality defined
     * in certain hero
     */
    @Override
    public int attack() {
        return 0;
    }
}
