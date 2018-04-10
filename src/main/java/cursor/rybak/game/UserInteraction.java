package cursor.rybak.game;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.store.RaceMap;
import cursor.rybak.view.Message;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class UserInteraction {
    private static Scanner in = new Scanner(System.in);

    /**
     * ask about race for heroes
     *
     * @return name of race
     */
    public static String askTeamName() {
        Message.welcomeInfo();

        while (true) {
            String userInput = in.nextLine().toUpperCase().trim();

            if (!userInput.isEmpty()) {
                return userInput;
            } else {
                Message.errorEmptyInput();
            }
        }
    }

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
     * * ask about heroes (can be from different races)
     *
     * @param teamMembers heroes number in team
     * @return array of heroes
     */
    public static AbstractRace[] askHeroes(int teamMembers) {
        ArrayList<AbstractRace> teamHeroes = new ArrayList<>();

        Message.printHeroesInfo();
        Message.askHeroLeader();

        while (teamHeroes.size() < teamMembers) {
            int teamSizeInitial = teamHeroes.size();
            // need to declare here to fetch new reference to hero object
            Map<String, Map<String, AbstractRace>> raceMap = RaceMap.getRace();

            String userInput = in.nextLine().toLowerCase();

            addHeroFromMap(raceMap, teamHeroes, userInput);

            if(teamSizeInitial == teamHeroes.size()) {
                Message.errorInfo();
                Message.printAllHeroes();
            }
        }

        return teamHeroes.toArray(new AbstractRace[teamHeroes.size()]);
    }


    private static void addHeroFromMap(Map<String, Map<String, AbstractRace>> raceMap,
                                       ArrayList<AbstractRace> teamHeroes,
                                       String userInput) {

        raceMap.forEach((race, heroes) ->
                heroes.keySet().forEach(hero -> {
                    if (hero.equals(userInput)) {
                        teamHeroes.add(raceMap.get(race).get(userInput));

                        int currentTeamSize = teamHeroes.size();

                        // this if statement need here to handle case, when
                        // we choose team members and need more
                        //
                        // Note: outside above 'if' we will execute message
                        // that we need more hero every time when run
                        // forEach loop for races and heroes!
                        if (currentTeamSize > 0 && currentTeamSize < 3) Message.askMoreHero(currentTeamSize);
                    }
                })
        );
    }
}
