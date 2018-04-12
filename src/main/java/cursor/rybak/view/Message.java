package cursor.rybak.view;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.team.Team;
import cursor.rybak.store.RaceMap;

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

        printOptions(races);
    }

    public static void printRaceHeroes(String race) {
        Set<String> heroesKey = raceMap.get(race).keySet();
        String[] heroes = heroesKey.toArray(new String[heroesKey.size()]);

        for(int i = 0; i < heroes.length; i++) {
            heroes[i] = String.format("%s%d%s-%s", GREEN, i + 1, RESET, heroes[i]);
        }
        printOptions(heroes);
    }

    public static void printKeyToUpgrade(String[] characteristicsKey) {
        for(int i = 0; i < characteristicsKey.length; i++) {
            characteristicsKey[i] = String.format("%s%d%s-%s", GREEN, i + 1, RESET, characteristicsKey[i]);
        }
        System.out.print("\n");
        printOptions(characteristicsKey);
    }

    private static void printOptions(String [] options) {
        System.out.format("[%s] -> ", String.join(", ", options));
    }

    public static void printChosenOption(String option) {
        System.out.format("\t\t%sYour choice: %s%s\n", YELLOW, option, RESET);
    }

//    /**
//     * print names of all heroes
//     * available to use
//     */
//    public static void printAllHeroes() {
//        ArrayList<String> heroesName = new ArrayList<>();
//        raceMap.values().forEach(heroes -> heroesName.addAll(heroes.keySet()));
//        System.out.println(heroesName);
//    }


    private static void printTeamTableHeader(String format, AbstractRace[] hero) {
        printTeamTableDivider();
        System.out.format(format, "Characteristic\\Hero",
                hero[0].getHeroName() + " (L)", hero[1].getHeroName(), hero[2].getHeroName());
        printTeamTableDivider();
    }

    private static void printTeamTableDivider() {
        System.out.format("+----------------------+----------------------+----------------------+----------------------+%n");
    }

    private static void printTeamMemberInfo(String format, AbstractRace[] hero) {

        printHeroesVitalCharacteristic(format, hero);
        printTeamTableDivider();

        printHeroesCharacteristic(format, hero);
        printTeamTableDivider();
    }

    private static void printHeroesVitalCharacteristic(String format, AbstractRace[] hero) {
        System.out.format(format, "Profession",
                hero[0].getHeroKind() + "  (" + hero[0].getRace() + ")",
                hero[1].getHeroKind() + "  (" + hero[1].getRace() + ")",
                hero[2].getHeroKind() + "  (" + hero[2].getRace() + ")"
        );

        System.out.format(format, "Health",
                hero[0].getHealth(), hero[1].getHealth(), hero[2].getHealth());

        System.out.format(format, "Mana",
                hero[0].getMana(), hero[1].getMana(), hero[2].getMana());

        System.out.format(format, "Rage",
                hero[0].getRage(), hero[1].getRage(), hero[2].getRage());
    }

    private static void printHeroesCharacteristic(String format, AbstractRace[] hero) {
        System.out.format(format, "Charisma",
                hero[0].getCharisma(), hero[1].getCharisma(), hero[2].getCharisma());

        System.out.format(format, "Stamina",
                hero[0].getStamina(), hero[1].getStamina(), hero[2].getStamina());

        System.out.format(format, "Intellect",
                hero[0].getIntellect(), hero[1].getIntellect(), hero[2].getIntellect());

        System.out.format(format, "Agility",
                hero[0].getAgility(), hero[1].getAgility(), hero[2].getAgility());

        System.out.format(format, "Concentration",
                hero[0].getConcentration(), hero[1].getConcentration(), hero[2].getConcentration());
    }

    public static void printTeamInfo(Team team) {
        String leftAlignFormat = "| %-20s | %-20s | %-20s | %-20s |%n";
        System.out.println("\n\tTeam: " + team.getName());
        printTeamTableHeader(leftAlignFormat, team.getHeroes());
        printTeamMemberInfo(leftAlignFormat, team.getHeroes());
    }

    public static void printRemainedPoints(int points) {
        System.out.format("You can distribute %d points: ", points);
    }

    public static void errorOutOfBound(int points) {
        System.out.format("\t%sSorry, you need to choose from range [1:%d]:%s ", RED, points, RESET);
    }

    public static void printDistributionIntro(int points) {
        System.out.format("\t%sNow you should upgrade your hero. You have %d points for that%s\n", BLUE, points, RESET);
    }


//    /**
//     * print all heroes with
//     * their abilities from all races
//     */
//    public static void printHeroesInfo() {
//        String leftAlignFormat = "| %-15s | %-15s | %-7s | %-30s |%n";
//        printMainTableHeader();
//
//        raceMap.forEach((race, heroes) -> {
//            System.out.format(leftAlignFormat, race, "", "", "");
//
//            heroes.forEach((hero, heroAbility) -> {
//                System.out.format(leftAlignFormat, "", hero, "regular", "");
//                printHeroAbilities(heroAbility, leftAlignFormat);
//            });
//
//            printMainTableDivider();
//        });
//    }
//
//    private static void printMainTableHeader() {
//        System.out.format("+-----------------+-----------------+---------+--------------------------------+%n");
//        System.out.format("|       Race      |       Hero      | Feature |             Attack             |%n");
//        System.out.format("+-----------------+-----------------+---------+--------------------------------+%n");
//    }
//
//    private static void printMainTableDivider() {
//        System.out.format("+-----------------+-----------------+---------+--------------------------------+%n");
//    }
//
//    private static void printHeroAbilities(AbstractRace heroAbility, String leftAlignFormat) {
//        heroAbility.getAttacks().keySet().forEach(attack1 ->
//                System.out.format(leftAlignFormat, "", "", "", attack1));
//
//        heroAbility.getSpecialAttacks().forEach((feature, attackList) -> {
//            System.out.format(leftAlignFormat, "", "", feature, "");
//
//            attackList.keySet().forEach(attack -> System.out.format(leftAlignFormat, "", "", "", attack));
//        });
//    }
}