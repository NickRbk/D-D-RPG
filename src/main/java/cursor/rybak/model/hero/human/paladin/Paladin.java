package cursor.rybak.model.hero.human.paladin;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.paladin.abilities.map.PaladinAbilitiesMap;
import cursor.rybak.model.race.kind.Human;
import lombok.Getter;

import java.util.Map;

public class Paladin extends Human {
    @Getter
    private Map<String, Map<String, AbstractAbility>> specialAttacks = PaladinAbilitiesMap.getSpecialAttackMap();
    @Getter
    private Map<String, int[]> attacks = PaladinAbilitiesMap.getAttackMap();

    public Paladin() {
        super("Paladin");
    }

    @Override
    public int attack() {
        return 0;
    }
}
