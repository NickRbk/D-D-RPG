package io.rybak.model.hero;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractSpell {
    @Getter
    private String name;
    @Getter
    private int manaConsumption;
    @Getter
    private int[] damageOptions;
    @Getter
    @Setter
    private int coolDown;

    /**
     * constructor for abstract
     * class AbstractSpell
     *
     * @param name            name of spell
     * @param manaConsumption how much mana needs (mp)
     * @param damageOptions   destruction options [min value, max value]
     * @param coolDown        pause for recovery (cd)
     */
    public AbstractSpell(String name,
                         int manaConsumption,
                         int[] damageOptions,
                         int coolDown) {

        this.name = name;
        this.manaConsumption = manaConsumption;
        this.damageOptions = damageOptions;
        this.coolDown = coolDown;
    }

    public abstract void specialSpell();
}
