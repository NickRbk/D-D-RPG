package cursor.rybak.model.hero.elf.gunslinger;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.gunslinger.abilities.map.GunslingerAbilitiesMap;
import cursor.rybak.model.race.kind.Elf;
import lombok.Getter;

import java.util.Map;

public class Gunslinger extends Elf {
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAttacks = GunslingerAbilitiesMap.getSpecialAttackMap();
    @Getter
    Map<String, int[]> attacks = GunslingerAbilitiesMap.getAttackMap();

    public Gunslinger() {
        super("Gunslinger");
    }

    @Override
    public int attack() {
        return 0;
    }
}
