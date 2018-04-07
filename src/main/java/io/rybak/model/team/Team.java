package io.rybak.model.team;

import io.rybak.game.UserInteraction;
import io.rybak.model.race.AbstractRace;
import lombok.Getter;


public class Team {
    private static final int TEAM_MEMBERS = 3;

    @Getter
    private AbstractRace[] heroes;
    @Getter
    private String race;

    // Create custom constructor to create Team
    public Team(String race) {
        this.heroes = createTeam(race);
        this.race = race;
    }

    private AbstractRace[] createTeam(String race) {
        AbstractRace[] selectedHeroes = UserInteraction.askHeroes(race, TEAM_MEMBERS);
        selectedHeroes[0].setLeader();
        return selectedHeroes;
    }

    @Override
    public String toString() {
        return String.format("\n\tTeam of %s race, members: %d\n\t\t--> %s",
                race.toUpperCase(), heroes.length, printTeamMembers());
    }

    // Function to print all members name in team
    private String printTeamMembers() {
        String[] heroesName = new String[heroes.length];

        for(int i = 0; i < heroes.length; i++) {
            heroesName[i] = String.format("%s (%d)", heroes[i].getHeroName(), heroes[i].getHealth());
        }

        return String.join(", ", heroesName);
    }
}
