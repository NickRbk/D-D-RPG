package io.rybak.model.race.kind;

import io.rybak.model.hero.AbstractAbility;
import io.rybak.model.race.AbstractRace;

import java.util.Map;

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

    @Override
    public Map<String, Map<String, AbstractAbility>> getSpecialAttacks() {
        return null;
    }

    @Override
    public Map<String, int[]> getAttacks() {
        return null;
    }
}
