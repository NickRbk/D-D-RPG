package io.rybak.model.hero.dwarf.mechanist;

import io.rybak.model.race.impl.kind.Dwarf;

public class Mechanist extends Dwarf {
    public Mechanist() {
        super("Mechanist");
    }

    @Override
    public int attack() {
        return 0;
    }
}
