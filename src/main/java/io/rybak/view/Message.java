package io.rybak.view;

import io.rybak.model.race.AbstractRace;
import io.rybak.store.RaceMap;

import java.util.ArrayList;
import java.util.Map;

public class Message implements MagicColors {
    private static Map<String, Map<String, AbstractRace>> raceMap = RaceMap.getRace();

    public static void welcomeInfo() {
        System.out.println(CYAN + "\n\tHello player, start game!\n" + RESET);
        askTeamName();
    }

    private static void askTeamName() {
        System.out.print(BLUE + "At first choose name for your Team: " + RESET);
    }

    public static void askHeroLeader() {
        System.out.print(BLUE + "Time to create your team.\n\tAvailable to choose -> " + RESET);
        printAllHeroes();

        System.out.print(BLUE + "At first choose a Leader: " + RESET);
    }

    public static void askMoreHero(int index) {
        System.out.format("%sYour Team needs more heroes (%d | 3):%s ", BLUE, index, RESET);
    }

    public static void askGameMode(String options) {
        System.out.print(BLUE + "\n\tChoose GAME MODE -> " + RESET + "[" + options + "]: ");
    }

    public static void errorInfo() {
        System.out.print(RED + "\tSorry, you need to choose from list: " + RESET);
    }

    public static void errorEmptyInput() {
        System.out.print(RED + "\tSorry, your field empty :( " + RESET);
    }

    public static void printRaces() {
        System.out.println(raceMap.keySet());
    }

    /**
     * print names of all heroes
     * available to use
     */
    public static void printAllHeroes() {
        ArrayList<String> heroesName = new ArrayList<>();
        raceMap.values().forEach(heroes -> heroesName.addAll(heroes.keySet()));
        System.out.println(heroesName);
    }

    /**
     * print all heroes with
     * their abilities from all races
     */
    public static void printHeroesInfo() {
        String leftAlignFormat = "| %-15s | %-15s | %-7s | %-30s |%n";

        System.out.format("+-----------------+-----------------+---------+--------------------------------+%n");
        System.out.format("|       Race      |       Hero      | Feature |             Attack             |%n");
        System.out.format("+-----------------+-----------------+---------+--------------------------------+%n");

        raceMap.forEach((race, heroes) -> {
            System.out.format(leftAlignFormat, race, "", "", "");

            heroes.forEach((hero, heroAbility) -> {
                System.out.format(leftAlignFormat, "", hero, "regular", "");

                heroAbility.getAttacks().keySet().forEach(attack1 ->
                        System.out.format(leftAlignFormat, "", "", "", attack1));

                heroAbility.getSpecialAtacks().forEach((feature, attackList) -> {
                    System.out.format(leftAlignFormat, "", "", feature, "");

                    attackList.keySet().forEach(attack -> System.out.format(leftAlignFormat, "", "", "", attack));
                });
            });
            System.out.format("+-----------------+-----------------+---------+--------------------------------+%n");
        });
    }
}