package univ.rybak.model.hero.dwarf.warrior;

import univ.rybak.model.hero.AbstractAbility;
import univ.rybak.model.hero.dwarf.warrior.abilities.map.WarriorAbilitiesMap;
import univ.rybak.model.race.kind.Dwarf;
import lombok.Getter;

import java.util.Map;

public class Warrior extends Dwarf {
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAttacks = WarriorAbilitiesMap.getSpecialAttackMap();
    @Getter
    Map<String, int[]> attacks = WarriorAbilitiesMap.getAttackMap();

    public Warrior() {
        super("Warrior");
    }

    @Override
    public int attack() {
        return 0;
    }
}
