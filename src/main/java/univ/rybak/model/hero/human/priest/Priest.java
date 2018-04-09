package univ.rybak.model.hero.human.priest;

import univ.rybak.model.hero.AbstractAbility;
import univ.rybak.model.hero.human.priest.abilities.map.PriestAbilitiesMap;
import univ.rybak.model.race.kind.Human;
import lombok.Getter;

import java.util.Map;

public class Priest extends Human {
    private boolean immunity = false;
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAttacks = PriestAbilitiesMap.getSpecialAttackMap();
    @Getter
    Map<String, int[]> attacks = PriestAbilitiesMap.getAttackMap();

    public Priest() {
        super("Priest");
    }

    @Override
    public int attack() {
        return 0;
    }
}
