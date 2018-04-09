package univ.rybak.model.hero.elf.mage;

import univ.rybak.model.hero.AbstractAbility;
import univ.rybak.model.hero.elf.mage.abilities.map.MagAbilitiesMap;
import univ.rybak.model.race.kind.Elf;
import lombok.Getter;

import java.util.Map;

public class Mage extends Elf {
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAttacks = MagAbilitiesMap.getSpecialAttackMap();
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