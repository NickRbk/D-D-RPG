package io.rybak.model.hero.dwarf.warrior;

import io.rybak.model.race.impl.kind.Dwarf;

public class Warrior extends Dwarf {
    public Warrior() {
        super("Dwarf");
    }

    @Override
    public int attack() {
        return 0;
    }
}
