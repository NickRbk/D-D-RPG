package io.rybak.game;

import io.rybak.model.hero.human.priest.Priest;

public class Game {
    public static void start() {
        System.out.println("Game started!");

        Priest priest = new Priest();
        priest.getSpecialAtacks().forEach((key, value) -> {
            System.out.format("Key[%s]\n", key);
            value.forEach((keyInner, valueInner) -> System.out.format("\tkeyInner[%s]\n", keyInner));
        });
    }
}
