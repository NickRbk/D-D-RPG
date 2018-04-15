package cursor.rybak.store.components;

import cursor.rybak.model.hero.dwarf.mechanist.Mechanist;
import cursor.rybak.model.hero.dwarf.warrior.Warrior;
import cursor.rybak.model.race.AbstractRace;

import java.util.LinkedHashMap;
import java.util.Map;

public class DwarfHeroesMap {
    public static Map<String, AbstractRace> getDwarfHeroes() {
        Map<String, AbstractRace> raceHeroes = new LinkedHashMap<>();

        raceHeroes.put("warrior", new Warrior());
        raceHeroes.put("mechanist", new Mechanist());

        return raceHeroes;
    }
}
