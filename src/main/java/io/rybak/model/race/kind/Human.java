package io.rybak.model.race.kind;

import io.rybak.model.hero.AbstractAbility;
import io.rybak.model.race.AbstractRace;

import java.util.Map;

public class Human extends AbstractRace {

    public Human(String heroName) {
        super("Human", heroName, 10, 30, 20, 15, 15);
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
    public Map<String, Map<String, AbstractAbility>> getSpecialAtacks() {
        return null;
    }

    @Override
    public Map<String, int[]> getAttacks() {
        return null;
    }
}
