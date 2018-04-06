package io.rybak.model.race.impl;

public class Elf extends AbstractRace {

    public Elf(String heroName) {
        super("Elf", heroName);
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
