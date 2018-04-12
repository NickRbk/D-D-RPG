package cursor.rybak.model.race;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.view.MagicColors;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public abstract class AbstractRace implements MagicColors {
    private static final int INIT_VALUE = 100;
    private static final int MIN_VALUE = 0;

    @Getter
    private String[] keyToUpgrade = {"charisma", "stamina", "intellect", "agility", "concentration", "INFO"};

    @Getter
    private String race;
    @Getter
    private String heroKind;
    @Getter
    @Setter
    private String heroName;
    @Getter
    private double health = INIT_VALUE; // health points (hp)
    @Getter
    private boolean isLeader;

    @Getter
    @Setter
    private double xp = 10; // skill points (xp)

    @Getter
    private double mana = INIT_VALUE; // manna point for spells (mp)

    @Getter
    private double rage = INIT_VALUE; // rage points (rp)

    @Getter
    private int charisma;

    @Getter
    private int stamina;

    @Getter
    private int intellect;

    @Getter
    private int agility;

    @Getter
    private int concentration;

    @Getter
    @Setter
    private int level = 1;

    /**
     * constructor for abstract
     * class AbstractRace
     *
     * @param race          race kind
     * @param heroKind      hero name
     * @param charisma      hero charisma
     * @param stamina       hero stamina
     * @param intellect     hero intellect
     * @param agility       hero agility
     * @param concentration hero concentration
     */
    public AbstractRace(String race,
                        String heroKind,
                        int charisma,
                        int stamina,
                        int intellect,
                        int agility,
                        int concentration) {

        this.race = race;
        this.heroKind = heroKind;
        this.charisma = charisma;
        this.stamina = stamina;
        this.intellect = intellect;
        this.agility = agility;
        this.concentration = concentration;
    }

    public void setLeader() {
        this.isLeader = true;
    }

    public void setHealth(int health) {
        this.health = health < MIN_VALUE ? MIN_VALUE : health;
    }

    public void setMana(int mana) {
        this.mana = mana < MIN_VALUE ? MIN_VALUE : mana;
    }

    public void setRage(int rage) {
        this.rage = rage < MIN_VALUE ? MIN_VALUE : rage;
    }

    public abstract int attack();

    public abstract Map<String, Map<String, AbstractAbility>> getSpecialAttacks();

    public abstract Map<String, int[]> getAttacks();


    public void setCharisma(int charisma) {
        this.charisma += charisma;

        // 2% XP gain for every two points
        int remainder = charisma % 2;
        if (remainder == 0) {
            this.xp += 0.02 * this.xp * charisma / 2;
        } else {
            this.xp += 0.02 * this.xp * (charisma - remainder);
        }

        // 1 additional initiative point per 2 points
        // CODE WILL BE HERE


        // charisma > 40 allows to fear enemies
        // (0.75% chance per 2 points of charisma)
        // CODE WILL BE HERE
    }

    public void setStamina(int stamina) {
        this.stamina += stamina;
        this.health += 2 * stamina + 0.25 * this.health;
    }

    public void setIntellect(int intellect) {
        this.intellect += intellect;
        this.mana += 2 * intellect + 0.25 * this.mana;
    }

    public void setAgility(int agility) {
        this.agility += agility;
        this.rage += 4 * agility;

        // chance to avoid hit 1% per 2 points
        // CODE WILL BE HERE
    }

    public void setConcentration(int concentration) {
        this.concentration += concentration;
        this.health += 2 * concentration;
        this.mana += 1.5 * concentration;

        // 1 rp regen per 1 turn per 1 point
        // CODE WILL BE HERE

        // 1 turn cd decresion per 25 points
        // CODE WILL BE HERE
    }
}
