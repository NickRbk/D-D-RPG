package io.rybak.model.race.impl;

public class Dwarf extends AbstractRace {

    public Dwarf(String heroName) {
        super("Dwarf", heroName);
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
