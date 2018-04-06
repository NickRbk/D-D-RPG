package io.rybak.model.hero.elf.gunslinger;

import io.rybak.model.race.impl.Elf;

public class Gunslinger extends Elf {
    public Gunslinger() {
        super("Gunslinger");
    }

    @Override
    public int attack() {
        return 0;
    }
}
