package io.rybak.model.race.impl;

import io.rybak.model.race.Activity;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractRace implements Activity {
    @Getter
    private String race;
    @Getter
    private String heroName;
    @Getter
    private int health = 100; // health points (hp)


    @Getter
    @Setter
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

    /**
     * constructor for abstract
     * class AbstractRace
     *
     * @param race     race kind
     * @param heroName hero name
     */
    public AbstractRace(String race, String heroName) {
        this.race = race;
        this.heroName = heroName;
    }

    /**
     * health should not be more 100
     * and less 0
     *
     * @param health new health
     */
    public void setHealth(int health) {
        if (health > 100 || health < 0) {
            this.health = health > 100 ? 100 : 0;
        } else {
            this.health = health;
        }
    }
}
