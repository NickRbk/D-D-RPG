package univ.rybak.model.hero.human.priest.abilities;

import univ.rybak.model.hero.AbstractAbility;

public class BattleTrance extends AbstractAbility {

    public BattleTrance() {
        super("Battle Trance", 65, null, 4);
    }

    @Override
    public void specialAbility() {
        // implement gain immunity for next turn
    }
}
