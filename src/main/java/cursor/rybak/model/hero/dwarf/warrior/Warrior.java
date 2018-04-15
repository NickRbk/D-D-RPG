package cursor.rybak.model.hero.dwarf.warrior;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.dwarf.warrior.abilities.map.WarriorAbilitiesMap;
import cursor.rybak.model.race.kind.impl.Dwarf;
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
