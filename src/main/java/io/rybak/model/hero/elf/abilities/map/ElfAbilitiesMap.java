package io.rybak.model.hero.elf.abilities.map;

import io.rybak.model.hero.AbstractAbility;
import io.rybak.model.hero.elf.mage.abilities.map.MagAbilitiesMap;

import java.util.HashMap;
import java.util.Map;

public class ElfAbilitiesMap {

    /**
     * Central store of special attack
     * @return store of special attack
     */
    public static Map<String, Map<String, Map<String, AbstractAbility>>> getSpellsCentralStore() {

        Map<String, Map<String, Map<String, AbstractAbility>>> spellsCentralStore = new HashMap<>();

        spellsCentralStore.put("Mage", MagAbilitiesMap.getSpecialAttackMap());

        return spellsCentralStore;
    }
}
