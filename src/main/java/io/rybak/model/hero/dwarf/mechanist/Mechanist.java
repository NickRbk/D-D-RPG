package io.rybak.model.hero.dwarf.mechanist;

import io.rybak.model.hero.AbstractAbility;
import io.rybak.model.hero.dwarf.mechanist.abilities.map.MechanistAbilitiesMap;
import io.rybak.model.race.impl.kind.Dwarf;
import lombok.Getter;

import java.util.Map;

public class Mechanist extends Dwarf {
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAtacks = MechanistAbilitiesMap.getSpecialAttackMap();
    @Getter
    Map<String, int[]> attacks = MechanistAbilitiesMap.getAttackMap();

    public Mechanist() {
        super("Mechanist");
    }

    @Override
    public int attack() {
        return 0;
    }
}
