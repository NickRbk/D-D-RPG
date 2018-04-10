package cursor.rybak.model.hero.human.paladin.abilities;

import cursor.rybak.model.hero.AbstractAbility;

public class Splash extends AbstractAbility {

    private static final int[] DAMAGE_OPTIONS = {2, 10};

    public Splash() {
        super("Splash", 20, DAMAGE_OPTIONS, 2);
    }

    @Override
    public void specialAbility() {
        // implement attack 2 additional targets
    }
}
