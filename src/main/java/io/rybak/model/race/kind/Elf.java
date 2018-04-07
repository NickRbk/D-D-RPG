package io.rybak.model.race.kind;

import io.rybak.model.race.AbstractRace;

public class Elf extends AbstractRace {

    public Elf(String heroName) {
        super("Elf", heroName, 15, 10, 25, 22, 18);
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
