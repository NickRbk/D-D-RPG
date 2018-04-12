package cursor.rybak.view;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.team.Team;
import cursor.rybak.store.RaceMap;

import java.util.Map;
import java.util.Set;

public class Message implements MagicColors {
    private static Map<String, Map<String, AbstractRace>> raceMap = RaceMap.getRace();

    /**
     * welcome message
     */
    public static void welcomeInfo() {
        System.out.println(CYAN + "\n\tHello player, start game!\n" + RESET);
    }


    /**
     * message to ask name for something
     *
     * @param item something for which ask question
     */
    public static void askName(String item) {
        System.out.format("%sChoose %s: %s", BLUE, item, RESET);
    }


    /**
     * message to ask Team leader
     */
    public static void askHeroLeader() {
        System.out.println(BLUE + "Time to create your team" + RESET);
        System.out.println(PURPLE + "\n\tAt first choose a Leader" + RESET);
    }


    /**
     * message to ask more heroes to Team
     *
     * @param currentIndex current count of Team members
     * @param lastIndex    destination length of Team
     */
    public static void askMoreHero(int currentIndex, int lastIndex) {
        System.out.format("\n\t%s... needs more heroes (%d | %d)%s\n", PURPLE, currentIndex, lastIndex, RESET);
    }


    /**
     * message to ask game mode (for advance edition)
     *
     * @param options mode options (in string)
     */
    public static void askGameMode(String options) {
        System.out.print(BLUE + "\n\tChoose GAME MODE -> " + RESET + "[" + options + "]: ");
    }


    /**
     * print options to choose race
     */
    public static void printRaces() {
        String[] races = raceMap.keySet().toArray(new String[raceMap.keySet().size()]);

        for (int i = 0; i < races.length; i++) {
            races[i] = String.format("%s%d%s-%s", GREEN, i + 1, RESET, races[i]);
        }
        printOptions(races);
    }


    /**
     * print options to choose hero from particular race
     *
     * @param race race
     */
    public static void printRaceHeroes(String race) {
        Set<String> heroesKey = raceMap.get(race).keySet();
        String[] heroes = heroesKey.toArray(new String[heroesKey.size()]);

        for (int i = 0; i < heroes.length; i++) {
            heroes[i] = String.format("%s%d%s-%s", GREEN, i + 1, RESET, heroes[i]);
        }
        printOptions(heroes);
    }


    /**
     * print options to choose characteristics needs to upgrade
     *
     * @param characteristicsKey array of characteristics name
     */
    public static void printKeyToUpgrade(String[] characteristicsKey) {
        for (int i = 0; i < characteristicsKey.length; i++) {
            characteristicsKey[i] = String.format("%s%d%s-%s", GREEN, i + 1, RESET, characteristicsKey[i]);
        }
        System.out.print("\n");
        printOptions(characteristicsKey);
    }


    /**
     * heper method, convert options from String[] to String and print
     *
     * @param options String[] of options
     */
    private static void printOptions(String[] options) {
        System.out.format("[%s] -> ", String.join(", ", options));
    }


    /**
     * print chosen option
     *
     * @param option chosen option
     */
    public static void printChosenOption(String option) {
        System.out.format("\t\t%sYour choice: %s%s\n", YELLOW, option, RESET);
    }


    /**
     * print remained point
     *
     * @param points remained points
     */
    public static void printRemainedPoints(int points) {
        System.out.format("You can distribute %d points: ", points);
    }


    /**
     * print total pointed should be distributed
     *
     * @param points total points to distribute
     */
    public static void printDistributionIntro(int points) {
        System.out.format("\t%sNow you should upgrade your hero. You have %d points for that%s\n", BLUE, points, RESET);
    }


    /**
     * print info when some characteristic upgraded
     *
     * @param points         points to upgrade
     * @param characteristic particular hero's characteristic
     * @param heroName       hero's name
     */
    public static void printUpgradeInfo(String points, String characteristic, String heroName) {
        System.out.format("\t\t%sYou add %s points to %s of %s%s\n", YELLOW, points, characteristic, heroName, RESET);
    }


    /**
     * print info that user has undistributed points
     *
     * @param remainedPoints count of undistributed points
     */
    public static void printRemainedInfo(int remainedPoints) {
        System.out.format("%s| You have %d points left |%s ", RED, remainedPoints, RESET);
    }


    /**
     * print info about Team
     *
     * @param team instance of Team
     */
    public static void printTeamInfo(Team team) {
        String leftAlignFormat = "| %-20s | %-20s | %-20s | %-20s |%n";
        System.out.println(CYAN + "\n\tTeam: " + team.getName() + RESET);
        printTeamTableHeader(leftAlignFormat, team.getHeroes());
        printTeamMemberInfo(leftAlignFormat, team.getHeroes());
    }


    /**
     * print header for table about Team
     *
     * @param format special format String
     * @param hero   array of heroes
     */
    private static void printTeamTableHeader(String format, AbstractRace[] hero) {
        printTeamTableDivider();
        System.out.format(format, "Characteristic\\Hero",
                hero[0].getHeroName() + " (L)", hero[1].getHeroName(), hero[2].getHeroName());
        printTeamTableDivider();
    }


    /**
     * divider in table about Team
     */
    private static void printTeamTableDivider() {
        System.out.format("+----------------------+----------------------+----------------------+----------------------+%n");
    }


    /**
     * print info about Team members
     *
     * @param format special format String
     * @param hero   array of heroes
     */
    private static void printTeamMemberInfo(String format, AbstractRace[] hero) {

        printHeroesVitalCharacteristic(format, hero);
        printTeamTableDivider();

        printHeroesCharacteristic(format, hero);
        printTeamTableDivider();
    }


    /**
     * print info about vital characteristics of Team's heroes (Part #1)
     * (such as Profession, Health, Mana, Rage)
     *
     * @param format special format String
     * @param hero   array of heroes
     */
    private static void printHeroesVitalCharacteristic(String format, AbstractRace[] hero) {
        System.out.format(format, "Profession",
                hero[0].getHeroKind() + "  (" + hero[0].getRace() + ")",
                hero[1].getHeroKind() + "  (" + hero[1].getRace() + ")",
                hero[2].getHeroKind() + "  (" + hero[2].getRace() + ")"
        );

        System.out.format(format, "Level",
                hero[0].getLevel(), hero[1].getLevel(), hero[2].getLevel());

        System.out.format(format, "XP",
                hero[0].getXp(), hero[1].getXp(), hero[2].getXp());

        printTeamTableDivider();

        System.out.format(format, "Health",
                hero[0].getHealth(), hero[1].getHealth(), hero[2].getHealth());

        System.out.format(format, "Mana",
                hero[0].getMana(), hero[1].getMana(), hero[2].getMana());

        System.out.format(format, "Rage",
                hero[0].getRage(), hero[1].getRage(), hero[2].getRage());
    }


    /**
     * print info about characteristics of Team's heroes (Part #2)
     * (such as Charisma, Stamina, Intellect, Agility, Concentration)
     *
     * @param format special format String
     * @param hero   special format String
     */
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


    /**
     * error info if user choose item not from list
     */
    public static void errorInfo() {
        System.out.print(RED + "\tSorry, you need to choose from list above: " + RESET);
    }


    /**
     * error info if input field is empty
     */
    public static void errorEmptyInput() {
        System.out.print(RED + "\tSorry, your field empty :( " + RESET);
    }


    /**
     * error that user input is out of bound
     *
     * @param points maximum option can be chosen
     */
    public static void errorOutOfBound(int points) {
        System.out.format("\t%sSorry, you need to choose from range [1:%d]:%s ", RED, points, RESET);
    }
}