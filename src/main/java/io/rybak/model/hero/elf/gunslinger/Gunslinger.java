package io.rybak.model.hero.elf.gunslinger;

import io.rybak.model.hero.AbstractAbility;
import io.rybak.model.hero.elf.gunslinger.abilities.map.GunslingerAbilitiesMap;
import io.rybak.model.race.kind.Elf;
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
