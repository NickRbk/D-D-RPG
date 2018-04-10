package cursor.rybak.model.enemy;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractMonster {
    private static final int MIN_HEALTH = 0;
    @Getter
    @Setter
    private boolean spellImmune = false;
    @Getter
    private String kind; // kind of monster (e.g. UNDEAD, ORKOID, CREATURE)
    @Getter
    private String name; // name of monster in certain kind
    @Getter
    private int health;
    @Getter
    private int initiative;
    @Getter
    private int cost;

    public AbstractMonster(String kind, String name, int health, int initiative, int cost) {
        this.kind = kind;
        this.name = name;
        this.health = health;
        this.initiative = initiative;
        this.cost = cost;
    }

    /**
     * health should not be less 0
     *
     * @param health new health
     */
    public void setHealth(int health) {
        this.health = health < MIN_HEALTH ? 0 : health;
    }

    public abstract int attack();
}
