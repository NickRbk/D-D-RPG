package cursor.rybak.model.enemy.kind.orkoid;

import cursor.rybak.model.enemy.AbstractMonster;

public class Ogre extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 10};

    public Ogre() {
        super("Orkoid", "Ogre", 300, 5, 100);
    }

    @Override
    public int attack() {
        // implement damage option, can stun 15% chance
        return 0;
    }
}
