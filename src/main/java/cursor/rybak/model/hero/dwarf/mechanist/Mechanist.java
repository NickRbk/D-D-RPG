package cursor.rybak.model.hero.dwarf.mechanist;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.dwarf.mechanist.abilities.map.MechanistAbilitiesMap;
import cursor.rybak.model.race.kind.impl.Dwarf;
import lombok.Getter;

import java.util.Map;

public class Mechanist extends Dwarf {
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAttacks = MechanistAbilitiesMap.getSpecialAttackMap();
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
