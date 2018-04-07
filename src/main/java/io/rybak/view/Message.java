package io.rybak.view;

import io.rybak.model.race.AbstractRace;
import io.rybak.store.RaceMap;

import java.util.Map;

public class Message implements MagicColors {
    private static Map<String, Map<String, AbstractRace>> raceMap = RaceMap.getRace();

    public static void welcomeInfo() {
        System.out.println(CYAN + "\n\tHello player, start game!\n" + RESET);
        askRace();
    }

    private static void askRace() {
        System.out.print(BLUE + "At first choose Race:" + RESET);
        printRaces();
    }

    public static void askHeroLeader(String race) {
        System.out.print(BLUE + "Create your team of " + race + " race:" + RESET);
        printRaceHeroes(race);

        System.out.print(BLUE + "At first choose a Leader: " + RESET);
    }

    public static void askMoreHero(int index) {
        System.out.format("%sYour Team needs more heroes (%d | 3):%s ", BLUE, index, RESET);
    }

    public static void errorInfo() {
        System.out.print(RED + "\tSorry, you need to choose from list: " + RESET);
    }

    public static void printRaces() {
        System.out.println(raceMap.keySet());
    }

    public static void printRaceHeroes(String race) {
        System.out.println(raceMap.get(race).keySet());
    }

    public static void printHeroesInfo(String race) {
        String leftAlignFormat = "| %-15s | %-7s | %-30s |%n";

        System.out.format("+-----------------+---------+--------------------------------+%n");
        System.out.format("|       Hero      | Feature |               Attack           |%n");
        System.out.format("+-----------------+---------+--------------------------------+%n");

        raceMap.get(race).forEach((hero, heroAbility) -> {
            System.out.format(leftAlignFormat, "", "", "");
            System.out.format(leftAlignFormat, hero, "", "");

            System.out.format(leftAlignFormat, "", "regular", "");
            heroAbility.getAttacks().keySet().forEach(attack1 -> System.out.format(leftAlignFormat, "", "", attack1));

            heroAbility.getSpecialAtacks().forEach((feature, attackList) -> {
                System.out.format(leftAlignFormat, "", feature, "");

                attackList.keySet().forEach(attack -> System.out.format(leftAlignFormat, "", "", attack));
            });

            System.out.format("+-----------------+---------+--------------------------------+%n");
        });
    }
}