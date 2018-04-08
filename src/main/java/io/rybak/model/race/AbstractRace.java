package io.rybak.model.race;

import io.rybak.model.hero.AbstractAbility;
import io.rybak.view.MagicColors;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public abstract class AbstractRace implements MagicColors {
    private static final int MAX_HEALTH = 100;
    private static final int MIN_HEALTH = 0;

    @Getter
    private String race;
    @Getter
    private String heroName;
    @Getter
    private int health = MAX_HEALTH; // health points (hp)
    @Getter
    private boolean isLeader;

    @Getter
    @Setter
    private float xp = 10f; // skill points (xp)

    @Getter
    @Setter
    private float mana; // manna point for spells (mp)

    @Getter
    @Setter
    private float rage; // rage points (rp)

    @Getter
    @Setter
    private int charisma;

    @Getter
    @Setter
    private int stamina;

    @Getter
    @Setter
    private int intellect;

    @Getter
    @Setter
    private int agility;

    @Getter
    @Setter
    private int concentration;

    @Getter
    @Setter
    private int level = 1;

    /**
     * constructor for abstract
     * class AbstractRace
     *
     * @param race          race kind
     * @param heroName      hero name
     * @param charisma      hero charisma
     * @param stamina       hero stamina
     * @param intellect     hero intellect
     * @param agility       hero agility
     * @param concentration hero concentration
     */
    public AbstractRace(String race,
                        String heroName,
                        int charisma,
                        int stamina,
                        int intellect,
                        int agility,
                        int concentration) {

        this.race = race;
        this.heroName = heroName;
        this.charisma = charisma;
        this.stamina = stamina;
        this.intellect = intellect;
        this.agility = agility;
        this.concentration = concentration;
    }

    public void setLeader() {
        this.isLeader = true;
        this.heroName = YELLOW + this.heroName + RESET;
    }

    /**
     * health should not be more 100
     * and less 0
     *
     * @param health new health
     */
    public void setHealth(int health) {
        if (health > MAX_HEALTH || health < MIN_HEALTH) {
            this.health = health > MAX_HEALTH ? MAX_HEALTH : MIN_HEALTH;
        } else {
            this.health = health;
        }
    }

    public abstract int attack();

    public abstract Map<String, Map<String, AbstractAbility>> getSpecialAtacks();

    public abstract Map<String, int[]> getAttacks();
}
