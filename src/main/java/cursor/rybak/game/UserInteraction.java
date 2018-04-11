package cursor.rybak.game;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.store.RaceMap;
import cursor.rybak.view.Message;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

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
     * ask about race for heroes
     *
     * @return name of race
     */
    private static String askRace() {
        Map<String, Map<String, AbstractRace>> races = RaceMap.getRace();

        Message.askName("race");
        Message.printRaces();

        while (true) {
            String userInput = in.nextLine().toLowerCase();

            if (races.containsKey(userInput)) {
                return userInput;
            } else {
                Message.errorInfo();
                Message.printRaces();
            }
        }
    }

    /**
     * ask about about hero
     *
     * @param heroes map of heroes for particular race
     * @param race race
     * @return chosen hero
     */
    private static AbstractRace askHero(Map<String, AbstractRace> heroes, String race) {
        Message.askName("hero");
        Message.printRaceHeroes(race);

        while (true) {
            String userInput = in.nextLine().toLowerCase();

            if (heroes.containsKey(userInput)) {
                return heroes.get(userInput);
            } else {
                Message.errorInfo();
                Message.printRaceHeroes(race);
            }
        }
    }

    /**
     * ask about game mode (for maze edition)
     *
     * @return game mode
     */
    public static String askGameMode() {
        String[] options = {"easy", "medium", "hard"};
        Message.askGameMode( String.join(", ", options) );

        while (true) {
            String userInput = in.nextLine().toUpperCase().trim();

            for(Mode mode : Mode.values() ) {
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

            if(currentTeamSize < teamMembers) {
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

//    private static boolean addHeroFromRace(Map<String, AbstractRace> heroes,
//                                           ArrayList<AbstractRace> teamHeroes,
//                                           String hero) {
//
//        int initialTeamSize = teamHeroes.size();
//        heroes.keySet().forEach(heroMap -> {
//            if (heroMap.equals(hero)) {
//                teamHeroes.add(heroes.get(hero));
//
//                int currentTeamSize = teamHeroes.size();
//
//                // this if statement need here to handle case, when
//                // we choose team members and need more
//                //
//                // Note: outside above 'if' we will execute message
//                // that we need more hero every time when run
//                // forEach loop for races and heroes!
//                if (currentTeamSize > 0 && currentTeamSize < 3) Message.askMoreHero(currentTeamSize);
//            }
//        });
//
//        return teamHeroes.size() > initialTeamSize;
//    }


//    private static boolean addHeroFromMap(Map<String, Map<String, AbstractRace>> raceMap,
//                                       ArrayList<AbstractRace> teamHeroes,
//                                       String userInput) {
//
//        int initialTeamSize = teamHeroes.size();
//        raceMap.forEach((race, heroes) ->
//                heroes.keySet().forEach(hero -> {
//                    if (hero.equals(userInput)) {
//                        teamHeroes.add(raceMap.get(race).get(userInput));
//
//                        int currentTeamSize = teamHeroes.size();
//
//                        // this if statement need here to handle case, when
//                        // we choose team members and need more
//                        //
//                        // Note: outside above 'if' we will execute message
//                        // that we need more hero every time when run
//                        // forEach loop for races and heroes!
//                        if (currentTeamSize > 0 && currentTeamSize < 3) Message.askMoreHero(currentTeamSize);
//                    }
//                })
//        );
//        return teamHeroes.size() > initialTeamSize;
//    }
}
