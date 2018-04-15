package cursor.rybak.store;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.store.components.DwarfHeroesMap;
import cursor.rybak.store.components.ElfHeroesMap;
import cursor.rybak.store.components.HumanHeroesMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class RaceMap {
    public static Map<String, Map<String, AbstractRace>> getRace() {
        Map<String, Map<String, AbstractRace>> races = new LinkedHashMap<>();

        races.put("human", HumanHeroesMap.getHumanHeroes());
        races.put("elf", ElfHeroesMap.getElfHeroes());
        races.put("dwarf", DwarfHeroesMap.getDwarfHeroes());

        return races;
    }
}
