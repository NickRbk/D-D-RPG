package io.rybak.game;

import io.rybak.model.race.AbstractRace;
import io.rybak.store.RaceMap;
import io.rybak.view.Message;

import java.util.Map;
import java.util.Scanner;

public class UserInteraction {
    private static Scanner in = new Scanner(System.in);

    /**
     * ask about race for heroes
     *
     * @return name of race
     */
    public static String askRace() {
        Map<String, Map<String, AbstractRace>> races = RaceMap.getRace();
        Message.welcomeInfo();

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
     * * ask about heroes in team of particular race
     *
     * @param race        concrete race
     * @param teamMembers heroes in team
     * @return array of heroes
     */
    public static AbstractRace[] askHeroes(String race, int teamMembers) {
        int counter = 0;
        AbstractRace[] heroes = new AbstractRace[teamMembers];

        Message.printHeroesInfo(race);
        Message.askHeroLeader(race);

        while (counter < teamMembers) {
            // need to declare here to fetch new reference to hero object
            Map<String, AbstractRace> raceMap = RaceMap.getRace().get(race);

            String userInput = in.nextLine().toLowerCase();

            if (raceMap.containsKey(userInput)) {
                heroes[counter] = raceMap.get(userInput);
                counter++;
                if (counter > 0 && counter < 3) Message.askMoreHero(counter);
            } else {
                Message.errorInfo();
                Message.printRaceHeroes(race);
            }
        }

        return heroes;
    }
}
