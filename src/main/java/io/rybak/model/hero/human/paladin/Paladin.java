package io.rybak.model.hero.human.paladin;

import io.rybak.model.race.impl.Human;

public class Paladin extends Human {
    public Paladin() {
        super("Paladin");
    }

    @Override
    public int attack() {
        return 0;
    }
}
