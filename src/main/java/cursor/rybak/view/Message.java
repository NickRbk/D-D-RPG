package cursor.rybak.view;

import cursor.rybak.model.maze.Location;
import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.team.MoveConst;
import cursor.rybak.model.team.Moves;
import cursor.rybak.model.team.Team;
import cursor.rybak.store.RaceMap;

import java.util.*;

public class Message implements MagicColors, MoveConst {
    private static Map<String, Map<String, AbstractRace>> raceMap = RaceMap.getRace();

    /**
     * message to ask name for something
     *
     * @param item something for which ask question
     */
    public static void askName(String item) {
        System.out.format("%sEnter %s: %s", BLUE, item, RESET);
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
     * Analyze which move options available at particular Location
     *
     * @param lastSymbol      option for last index (may be straight, right, currentPosition)
     * @param firstSymbol     option for first index (may be back, left, currentPosition)
     * @param line            line to analyze (main or cross)
     * @param currentLocation current position
     * @param lineSize        length of line (may be 0, 2 or 3)
     * @param options         final options (String)
     */
    private static void defineMoveOptions(String lastSymbol,
                                          String firstSymbol,
                                          List<Location> line,
                                          Location currentLocation,
                                          int lineSize,
                                          StringBuilder options) {
        if (lineSize != 0) {
            String lineOptions;
            if (lineSize == 2) {
                lineOptions = line.indexOf(currentLocation) == 0
                        ? lastSymbol
                        : firstSymbol;
            } else lineOptions = lastSymbol + firstSymbol;

            options.append(lineOptions);
        }
    }


    /**
     * @param options array of options (aliases for move)
     */
    private static void printMoveOptions(String[] options) {
        List<String> optionsList = new ArrayList<>();

        Arrays.stream(options)
                .forEach(option -> {
                    Moves move = Moves.valueOf(option);
                    optionsList.add(
                            String.format("%s - %s",
                                    GREEN + move.getOptionAlias() + RESET,
                                    move.getOptionName())
                    );
                });

        System.out.format("\n\t\tChoose move option: [%s] -> ", String.join(", ", optionsList));
    }


    /**
     * get and print move options
     * Get needs to limit options to choose,
     * how team can move
     *
     * @param currentLocation current location
     * @return options
     */
    public static String getAndPrintMoveOptions(Location currentLocation, boolean print) {
        List<Location> mainLine = currentLocation.getMainLine();
        List<Location> crossLine = currentLocation.getCrossLine();

        StringBuilder options = new StringBuilder();

        defineMoveOptions(STRAIGHT_OPTION, BACK_OPTION,
                mainLine,
                currentLocation,
                mainLine.size(),
                options);

        defineMoveOptions(RIGHT_OPTION, LEFT_OPTION,
                crossLine,
                currentLocation,
                crossLine.size(),
                options);

        if (print) printMoveOptions(options.toString().toUpperCase().split(""));

        return options.toString();
    }


    /**
     * print neighboring locations
     *
     * @param currentLocation current position in maze
     */
    public static void printNeighbors(Location currentLocation) {
        System.out.print(CYAN + "\t\tAhh, What we see here..? " + RESET);
        String[] moveOptions = getAndPrintMoveOptions(currentLocation, false).toUpperCase().split("");


        if (moveOptions.length == 1 && BACK_OPTION.equals(moveOptions[0].toLowerCase())) {
            System.out.format(RED + " Its deadlocked, move back..\n" + RESET);
        } else {
            Arrays.stream(moveOptions)
                    .forEach(option -> {
                        String direction = Moves.valueOf(option).getOptionName();

                        if (STRAIGHT_OPTION.equals(option.toLowerCase())) {
                            List<Location> line = currentLocation.getMainLine();
                            Location StraightLocation = line.get(Team.getLocationIndex(line));
                            printNeighborsLabel(StraightLocation, GREEN + direction + RESET);
                        }

                        if (BACK_OPTION.equals(option.toLowerCase())) {
                            List<Location> line = currentLocation.getMainLine();
                            Location BackLocation = line.get(LEFT_OR_BACK);
                            printNeighborsLabel(BackLocation, GREEN + direction + RESET);
                        }

                        if (LEFT_OPTION.equals(option.toLowerCase())) {
                            List<Location> line = currentLocation.getCrossLine();
                            Location LeftLocation = line.get(LEFT_OR_BACK);
                            printNeighborsLabel(LeftLocation, RED + direction + RESET);
                        }

                        if (RIGHT_OPTION.equals(option.toLowerCase())) {
                            List<Location> line = currentLocation.getCrossLine();
                            Location RightLocation = line.get(Team.getLocationIndex(line));
                            printNeighborsLabel(RightLocation, RED + direction + RESET);
                        }
                    });
        }
    }


    /**
     * print neighbor label
     *
     * @param neighborLocation neighbor
     * @param direction        direction (left? right, straight, back)
     */
    private static void printNeighborsLabel(Location neighborLocation, String direction) {
        System.out.format("\n\t\t%sOn the%s %s %sis Room #%s%s", CYAN, RESET, direction,
                CYAN, neighborLocation.getCoordinates(), RESET);
    }


    /**
     * helper method, convert options from String[] to String and print
     *
     * @param options String[] of options
     */
    private static void printOptions(String[] options) {
        System.out.format("[%s] -> ",
                String.join(", ", options));
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


    public static void askAboutHint() {
        System.out.print(BLUE + "\tMaybe you want to see a maze map ?)) [y - yes] --> " + RESET);
    }
}