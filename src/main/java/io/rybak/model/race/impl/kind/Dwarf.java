package io.rybak.model.race.impl.kind;

import io.rybak.model.race.impl.AbstractRace;

public class Dwarf extends AbstractRace {

    public Dwarf(String heroName) {
        super("Dwarf", heroName, 5, 45, 15, 20, 5);
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
