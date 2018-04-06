package io.rybak.model.race.impl;

public class Human extends AbstractRace {

    public Human(String heroName) {
        super("Human", heroName);
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
