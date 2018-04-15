package cursor.rybak.store.components;

import cursor.rybak.model.hero.elf.gunslinger.Gunslinger;
import cursor.rybak.model.hero.elf.mage.Mage;
import cursor.rybak.model.race.AbstractRace;

import java.util.LinkedHashMap;
import java.util.Map;

public class ElfHeroesMap {
    public static Map<String, AbstractRace> getElfHeroes() {
        Map<String, AbstractRace> raceHeroes = new LinkedHashMap<>();

        raceHeroes.put("mage", new Mage());
        raceHeroes.put("gunslinger", new Gunslinger());

        return raceHeroes;
    }
}
