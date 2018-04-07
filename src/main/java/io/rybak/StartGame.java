package io.rybak;

import io.rybak.model.hero.elf.mage.Mage;
import io.rybak.model.hero.human.priest.Priest;

public class StartGame {

    /**
     * @param args rm params
     */
    public static void main(final String... args) {
        System.out.println("Game started!");

        Priest mag = new Priest();
        mag.getSpecialAtacks().forEach((key, value) -> {
            System.out.format("Key[%s]\n", key);
            value.forEach((keyInner, valueInner) -> System.out.format("\tkeyInner[%s]\n", keyInner));
        });
    }
}
