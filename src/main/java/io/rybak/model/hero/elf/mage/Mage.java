package io.rybak.model.hero.elf.mage;

import io.rybak.model.hero.AbstractSpell;
import io.rybak.model.hero.elf.mage.abilities.*;
import io.rybak.model.race.impl.kind.Elf;

import java.util.HashMap;
import java.util.Map;

public class Mage extends Elf {
    public Mage() {
        super("Mage");
    }

    @Override
    public int attack() {
        return 0;
    }


    private void createAttackMap() {
        Map<String, int[]> attackMap = new HashMap<>();

        int[] damageOptions = {0, 6};
        int[] improvementOptions = {-6, -1};

        attackMap.put("Wizard Stuff", damageOptions);
        attackMap.put("Imposition of on improvement", improvementOptions);
    }

    private void createSpellsMap() {
        Map<String, AbstractSpell> spellsMap = new HashMap<>();

        spellsMap.put("Fireball", new Fireball());
        spellsMap.put("Spell Shield", new SpellShield());
        spellsMap.put("Frost Bolt", new FrostBolt());
        spellsMap.put("Dispell", new Dispell());
        spellsMap.put("Stone Gaze", new StoneGaze());
    }
}
