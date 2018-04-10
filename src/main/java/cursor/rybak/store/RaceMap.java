package cursor.rybak.store;

import cursor.rybak.model.hero.dwarf.mechanist.Mechanist;
import cursor.rybak.model.hero.dwarf.warrior.Warrior;
import cursor.rybak.model.hero.elf.gunslinger.Gunslinger;
import cursor.rybak.model.hero.elf.mage.Mage;
import cursor.rybak.model.hero.human.paladin.Paladin;
import cursor.rybak.model.hero.human.priest.Priest;
import cursor.rybak.model.race.AbstractRace;

import java.util.HashMap;
import java.util.Map;

public class RaceMap {
    public static Map<String, Map<String, AbstractRace>> getRace() {
        Map<String, Map<String, AbstractRace>> races = new HashMap<>();

        races.put("human", getHumanHeroes());
        races.put("elf", getElfHeroes());
        races.put("dwarf", getDwarfHeroes());

        return races;
    }

    private static Map<String, AbstractRace> getHumanHeroes() {
        Map<String, AbstractRace> raceHeroes = new HashMap<>();

        raceHeroes.put("priest", new Priest());
        raceHeroes.put("paladin", new Paladin());

        return raceHeroes;
    }

    private static Map<String, AbstractRace> getElfHeroes() {
        Map<String, AbstractRace> raceHeroes = new HashMap<>();

        raceHeroes.put("mage", new Mage());
        raceHeroes.put("gunslinger", new Gunslinger());

        return raceHeroes;
    }

    private static Map<String, AbstractRace> getDwarfHeroes() {
        Map<String, AbstractRace> raceHeroes = new HashMap<>();

        raceHeroes.put("warrior", new Warrior());
        raceHeroes.put("mechanist", new Mechanist());

        return raceHeroes;
    }
}
