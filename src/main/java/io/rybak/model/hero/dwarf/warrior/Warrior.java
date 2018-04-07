package io.rybak.model.hero.dwarf.warrior;

import io.rybak.model.hero.AbstractAbility;
import io.rybak.model.hero.dwarf.warrior.abilities.map.WarriorAbilitiesMap;
import io.rybak.model.race.kind.Dwarf;
import lombok.Getter;

import java.util.Map;

public class Warrior extends Dwarf {
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAtacks = WarriorAbilitiesMap.getSpecialAttackMap();
    @Getter
    Map<String, int[]> attacks = WarriorAbilitiesMap.getAttackMap();

    public Warrior() {
        super("Dwarf");
    }

    @Override
    public int attack() {
        return 0;
    }
}
