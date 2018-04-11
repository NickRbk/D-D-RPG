package cursor.rybak.game;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.store.RaceMap;
import cursor.rybak.view.Message;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UserInteraction {
    private static final Scanner in = new Scanner(System.in);

    /**
     * ask about name (for props, that validate
     * only for empty field)
     *
     * @return name of some property
     */
    public static String askName(String item) {
        Message.askName(item);

        while (true) {
            String userInput = in.nextLine().toUpperCase().trim();

            if (!userInput.isEmpty()) {
                return userInput;
            }
            Message.errorEmptyInput();
        }
    }

    /**
     * choose some item from list by options
     * (validate input)
     *
     * @param items String[]
     * @return chosen option
     */
    private static int chooseOption(String[] items) {
        while (true) {
            String userInput = in.nextLine();

            if (!userInput.isEmpty() && userInput.matches("\\d+")) {
                int option = Integer.parseInt(userInput);

                if (option >= 1 && option <= items.length) {
                    return option - 1;
                }
            }

            Message.errorInfo();
        }
    }

    /**
     * ask about race for heroes
     *
     * @return name of race
     */
    private static String askRace() {
        Set<String> racesKey = RaceMap.getRace().keySet();
        String[] races = racesKey.toArray(new String[racesKey.size()]);

        Message.askName("race");
        Message.printRaces();
        int option = chooseOption(races);

        Message.printChosenOption(races[option]);

        return races[option];
    }

    /**
     * ask about about hero
     *
     * @param heroesMap map of heroes for particular race
     * @param race      race
     * @return chosen hero
     */
    private static AbstractRace askHero(Map<String, AbstractRace> heroesMap, String race) {
        Set<String> heroesKey = heroesMap.keySet();
        String[] heroes = heroesKey.toArray(new String[heroesKey.size()]);

        Message.askName("hero");
        Message.printRaceHeroes(race);
        int option = chooseOption(heroes);

        Message.printChosenOption(heroes[option]);

        return heroesMap.get(heroes[option]);
    }

    /**
     * ask about game mode (for maze edition)
     *
     * @return game mode
     */
    public static String askGameMode() {
        String[] options = {"easy", "medium", "hard"};
        Message.askGameMode(String.join(", ", options));

        while (true) {
            String userInput = in.nextLine().toUpperCase().trim();

            for (Mode mode : Mode.values()) {
                if (userInput.equals(mode.name())) {
                    return userInput;
                }
            }
            Message.errorInfo();
        }
    }

    /**
     * * ask about team members (can be from different races)
     *
     * @param teamMembers heroes number in team
     * @return array of heroes
     */
    public static AbstractRace[] askHeroes(int teamMembers) {
        ArrayList<AbstractRace> teamHeroes = new ArrayList<>();

        Message.askHeroLeader();

        while (teamHeroes.size() < teamMembers) {
            initializeHero(teamHeroes);

            int currentTeamSize = teamHeroes.size();

            if (currentTeamSize < teamMembers) {
                Message.askMoreHero(currentTeamSize, teamMembers);
            }
        }

        return teamHeroes.toArray(new AbstractRace[teamHeroes.size()]);
    }

    /**
     * initialize hero with name of the particular race
     *
     * @param teamHeroes team
     */
    private static void initializeHero(ArrayList<AbstractRace> teamHeroes) {
        Map<String, Map<String, AbstractRace>> raceMap = RaceMap.getRace();

        String name = askName("hero name");
        String race = askRace();
        AbstractRace hero = askHero(raceMap.get(race), race);
        hero.setHeroName(name);

        teamHeroes.add(hero);
    }
}
