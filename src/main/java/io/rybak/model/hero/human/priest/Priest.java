package io.rybak.model.hero.human.priest;

import io.rybak.model.race.impl.Human;

public class Priest extends Human {
    public Priest() {
        super("Priest");
    }

    @Override
    public int attack() {
        return 0;
    }
}
