package io.rybak.model.hero.elf.mage;

import io.rybak.model.hero.AbstractAbility;
import io.rybak.model.hero.elf.mage.abilities.map.MagAbilitiesMap;
import io.rybak.model.race.kind.Elf;
import lombok.Getter;

import java.util.Map;

public class Mage extends Elf {
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAtacks = MagAbilitiesMap.getSpecialAttackMap();
    @Getter
    Map<String, int[]> attacks = MagAbilitiesMap.getAttackMap();

    public Mage() {
        super("Mage");
    }

    @Override
    public int attack() {
        return 0;
    }
}
