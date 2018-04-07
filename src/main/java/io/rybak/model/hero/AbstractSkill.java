package io.rybak.model.hero;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractSkill {
    @Getter
    public int rageConsumption;
    @Getter
    public int[] damageOptions;
    @Getter
    @Setter
    public int coolDown;
    @Getter
    private String name;


    /**
     * constructor for abstract
     * class AbstractSkill
     *
     * @param name            name of spell
     * @param rageConsumption how much rage needs (rp)
     * @param damageOptions   destruction options [min value, max value]
     * @param coolDown        pause for recovery (cd)
     */
    public AbstractSkill(String name,
                         int rageConsumption,
                         int[] damageOptions,
                         int coolDown) {

        this.name = name;
        this.rageConsumption = rageConsumption;
        this.damageOptions = damageOptions;
        this.coolDown = coolDown;
    }

    public abstract void specialAttack();
}
