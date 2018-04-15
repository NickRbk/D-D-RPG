package cursor.rybak.store.components;

import cursor.rybak.model.hero.human.paladin.Paladin;
import cursor.rybak.model.hero.human.priest.Priest;
import cursor.rybak.model.race.AbstractRace;

import java.util.LinkedHashMap;
import java.util.Map;

public class HumanHeroesMap {
    public static Map<String, AbstractRace> getHumanHeroes() {
        Map<String, AbstractRace> raceHeroes = new LinkedHashMap<>();

        raceHeroes.put("priest", new Priest());
        raceHeroes.put("paladin", new Paladin());

        return raceHeroes;
    }
}
