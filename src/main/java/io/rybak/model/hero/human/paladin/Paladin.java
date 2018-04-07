package io.rybak.model.hero.human.paladin;

import io.rybak.model.hero.AbstractAbility;
import io.rybak.model.hero.human.paladin.abilities.map.PaladinAbilitiesMap;
import io.rybak.model.race.kind.Human;
import lombok.Getter;

import java.util.Map;

public class Paladin extends Human {
    @Getter
    private Map<String, Map<String, AbstractAbility>> specialAtacks = PaladinAbilitiesMap.getSpecialAttackMap();
    @Getter
    private Map<String, int[]> attacks = PaladinAbilitiesMap.getAttackMap();

    public Paladin() {
        super("Paladin");
    }

    @Override
    public int attack() {
        return 0;
    }
}
