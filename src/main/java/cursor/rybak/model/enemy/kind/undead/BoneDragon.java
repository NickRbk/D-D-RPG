package cursor.rybak.model.enemy.kind.undead;

import cursor.rybak.model.enemy.AbstractMonster;

public class BoneDragon extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {3, 10};

    public BoneDragon() {
        super("Undead", "Bone Dragon", 550, 50, 300);
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}