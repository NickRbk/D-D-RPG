package univ.rybak.model.enemy.kind.orkoid;

import univ.rybak.model.enemy.AbstractMonster;

public class UnstableAlchemist extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 100};

    public UnstableAlchemist() {
        super("Orkoid", "Unstable Alchemist", 15, 25, 5);
    }

    @Override
    public int attack() {
        // implement damage option, with splash (hit 1 additional target)
        return 0;
    }
}
