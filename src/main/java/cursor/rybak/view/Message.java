package cursor.rybak.view;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.store.RaceMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Message implements MagicColors {
    private static Map<String, Map<String, AbstractRace>> raceMap = RaceMap.getRace();

    public static void welcomeInfo() {
        System.out.println(CYAN + "\n\tHello player, start game!\n" + RESET);
    }

    public static void askName(String item) {
        System.out.format("%sChoose %s: %s", BLUE, item, RESET);
    }

    public static void askHeroLeader() {
        System.out.println(BLUE + "Time to create your team" + RESET);
        System.out.println(PURPLE + "\n\tAt first choose a Leader" + RESET);
    }

    public static void askMoreHero(int currentIndex, int lastIndex) {
        System.out.format("\n\t%s... needs more heroes (%d | %d)%s\n", PURPLE, currentIndex, lastIndex, RESET);
    }

    public static void askGameMode(String options) {
        System.out.print(BLUE + "\n\tChoose GAME MODE -> " + RESET + "[" + options + "]: ");
    }

    public static void errorInfo() {
        System.out.print(RED + "\tSorry, you need to choose from list above: " + RESET);
    }

    public static void errorEmptyInput() {
        System.out.print(RED + "\tSorry, your field empty :( " + RESET);
    }

    public static void printRaces() {
        String[] races = raceMap.keySet().toArray(new String[raceMap.keySet().size()]);

        for(int i = 0; i < races.length; i++) {
            races[i] = String.format("%s%d%s-%s", GREEN, i + 1, RESET, races[i]);
        }

        System.out.format("[%s] -> ", String.join(", ", races));
    }

    public static void printRaceHeroes(String race) {
        Set<String> heroesKey = raceMap.get(race).keySet();
        String[] heroes = heroesKey.toArray(new String[heroesKey.size()]);

        for(int i = 0; i < heroes.length; i++) {
            heroes[i] = String.format("%s%d%s-%s", GREEN, i + 1, RESET, heroes[i]);
        }

        System.out.format("[%s] -> ", String.join(", ", heroes));
    }

    public static void printChosenOption(String option) {
        System.out.format("\t\t%sYour choice: %s%s\n", YELLOW, option, RESET);
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
        printMainTableHeader();

        raceMap.forEach((race, heroes) -> {
            System.out.format(leftAlignFormat, race, "", "", "");

            heroes.forEach((hero, heroAbility) -> {
                System.out.format(leftAlignFormat, "", hero, "regular", "");
                printHeroAbilities(heroAbility, leftAlignFormat);
            });

            printMainTableDivider();
        });
    }

    private static void printMainTableHeader() {
        System.out.format("+-----------------+-----------------+---------+--------------------------------+%n");
        System.out.format("|       Race      |       Hero      | Feature |             Attack             |%n");
        System.out.format("+-----------------+-----------------+---------+--------------------------------+%n");
    }

    private static void printMainTableDivider() {
        System.out.format("+-----------------+-----------------+---------+--------------------------------+%n");
    }

    private static void printHeroAbilities(AbstractRace heroAbility, String leftAlignFormat) {
        heroAbility.getAttacks().keySet().forEach(attack1 ->
                System.out.format(leftAlignFormat, "", "", "", attack1));

        heroAbility.getSpecialAttacks().forEach((feature, attackList) -> {
            System.out.format(leftAlignFormat, "", "", feature, "");

            attackList.keySet().forEach(attack -> System.out.format(leftAlignFormat, "", "", "", attack));
        });
    }
}