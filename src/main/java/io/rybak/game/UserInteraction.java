package io.rybak.game;

import io.rybak.model.race.AbstractRace;
import io.rybak.store.RaceMap;
import io.rybak.view.Message;

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
                Message.errorInfo();
                Message.printRaces();
            }
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

            raceMap.forEach((race, heroes) -> {
                heroes.keySet().forEach(hero -> {
                    if (hero.equals(userInput)) {
                        teamHeroes.add(raceMap.get(race).get(userInput));

                        int currentTeamSize = teamHeroes.size();
                        if (currentTeamSize > 0 && currentTeamSize < 3) Message.askMoreHero(currentTeamSize);
                    }
                });
            });

            if(teamSizeInitial == teamHeroes.size()) {
                Message.errorInfo();
                Message.printAllHeroes();
            }
        }

        return teamHeroes.toArray(new AbstractRace[teamHeroes.size()]);
    }
}
