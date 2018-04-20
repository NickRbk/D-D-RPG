package cursor.rybak.model.team;

import cursor.rybak.game.UserInteraction;
import cursor.rybak.model.maze.Location;
import cursor.rybak.model.race.AbstractRace;
import lombok.Getter;

import java.util.List;

public class Team implements Move, MoveConst {
    private static final int TEAM_MEMBERS = 3;

    @Getter
    private AbstractRace[] heroes;
    @Getter
    private String name;

    // Create custom constructor to create Team
    public Team(String name) {
        heroes = createTeam();
        this.name = name;
    }

    private AbstractRace[] createTeam() {
        AbstractRace[] selectedHeroes = UserInteraction.askHeroes(TEAM_MEMBERS);
        selectedHeroes[0].setLeader();
        return selectedHeroes;
    }

    @Override
    public String toString() {
        return String.format("\n\t%s team, members: %d\n\t\t--> %s",
                name, heroes.length, printTeamMembers());
    }

    // Function to print all members name in team
    private String printTeamMembers() {
        String[] heroesName = new String[heroes.length];

        for (int i = 0; i < heroes.length; i++) {
            heroesName[i] = String.format("%s (%.0f)", heroes[i].getHeroName(), heroes[i].getHealth());
        }

        return String.join(", ", heroesName);
    }


    @Override
    public Location move(Location currentLocation, String moveOption) {

        // SHOULD BE CHANGE
        List<Location> mainLine = currentLocation.getLineA();
        List<Location> crossLine = currentLocation.getLineB();

        if(LEFT_OPTION.equals(moveOption)) return leftOrBackMove(crossLine, currentLocation, this);

        if(RIGHT_OPTION.equals(moveOption)) return rightOrStraightMove(crossLine, currentLocation, this);

        if(STRAIGHT_OPTION.equals(moveOption)) return rightOrStraightMove(mainLine, currentLocation, this);

        if(BACK_OPTION.equals(moveOption)) return leftOrBackMove(mainLine, currentLocation, this);

        return new Location("");
    }


    private static int getIndex(List<Location> line) {
        if(line.size() == 2) return RIGHT_OR_STRAIGHT_IF_ALONE;
        else return RIGHT_OR_STRAIGHT_IF_FULL;
    }

    private static Location rightOrStraightMove(List<Location> line, Location currentLocation, Team team) {
        int index = getIndex(line);

        Location newLocation = line.get(index);
        currentLocation.setTeam(null);
        newLocation.setTeam(team);

        return newLocation;
    }

    private static Location leftOrBackMove(List<Location> line, Location currentLocation, Team team) {
        Location newLocation = line.get(LEFT_OR_BACK);
        currentLocation.setTeam(null);
        newLocation.setTeam(team);

        return newLocation;
    }
}
