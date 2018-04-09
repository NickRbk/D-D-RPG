package univ.rybak.model.enemy.kind.undead;

import univ.rybak.model.enemy.AbstractMonster;

public class SkeletonChief extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public SkeletonChief() {
        super("Undead", "Skeleton Chief", 60, 15, 10);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
