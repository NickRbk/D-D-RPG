package cursor.rybak.model.team;

import cursor.rybak.game.UserInteraction;
import cursor.rybak.model.guide.Guide;
import cursor.rybak.model.maze.Location;
import cursor.rybak.model.maze.compass.Compass;
import cursor.rybak.model.race.AbstractRace;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Team implements Move, MoveConst, Compass {
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


    private void moveTeamOnMaze(Guide guide,
                                       String currentLocation,
                                       String newLocation) {

        String[] currentPosition = currentLocation.split("\\|");
        String[] newPosition = newLocation.split("\\|");

        guide.getPlayground().getMaze()
                [ Integer.parseInt(currentPosition[0]) ]
                [ Integer.parseInt(currentPosition[1]) ] = 1;

        guide.getPlayground().getMaze()
                [ Integer.parseInt(newPosition[0]) ]
                [ Integer.parseInt(newPosition[1]) ] = 2;
    }

    /**
     * find index on line (main or cross)
     *
     * @param line current line
     * @return index on line
     */
    private int getIndex(List<Location> line) {
        if (line.size() == 2) return RIGHT_OR_STRAIGHT_IF_ALONE;
        else return RIGHT_OR_STRAIGHT_IF_FULL;
    }


    /**
     * Actions when move right or straight
     *
     * @param line            line
     * @param currentLocation current location
     * @param team            team
     * @return new location
     */
    private Location rightOrStraightMove(List<Location> line,
                                                Location currentLocation,
                                                Guide guide,
                                                Team team) {

        int index = getIndex(line);

        Location newLocation = line.get(index);

        currentLocation.setTeam(null);
        newLocation.setTeam(team);

        moveTeamOnMaze(guide, currentLocation.getCoordinates(), newLocation.getCoordinates());

        return newLocation;
    }

    /**
     * Actions when move left or back
     *
     * @param line            line
     * @param currentLocation current location
     * @param team            team
     * @return new location
     */
    private Location leftOrBackMove(List<Location> line,
                                           Location currentLocation,
                                           Guide guide,
                                           Team team) {

        Location newLocation = line.get(LEFT_OR_BACK);

        currentLocation.setTeam(null);
        newLocation.setTeam(team);

        moveTeamOnMaze(guide, currentLocation.getCoordinates(), newLocation.getCoordinates());

        return newLocation;
    }

    /**
     * create Team
     *
     * @return array of members team
     */
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

    /**
     * return String of all members name in team
     *
     * @return members name in team
     */
    private String printTeamMembers() {
        String[] heroesName = new String[heroes.length];

        for (int i = 0; i < heroes.length; i++) {
            heroesName[i] = String.format("%s (%.0f)", heroes[i].getHeroName(), heroes[i].getHealth());
        }

        return String.join(", ", heroesName);
    }

    @Override
    public Location move(Location currentLocation, String moveOption, Guide guide) {

        // SHOULD BE CHANGE
        List<Location> mainLine = currentLocation.getMainLine();
//        List<Location> mainLine = currentLocation.getLineA();
        List<Location> crossLine = currentLocation.getCrossLine();
//        List<Location> crossLine = currentLocation.getLineB();

        if (LEFT_OPTION.equals(moveOption)) {
            Location newLocation = leftOrBackMove(crossLine, currentLocation, guide, this);
            moveLeftCompass(currentLocation, newLocation);
            return newLocation;
        }

        if (RIGHT_OPTION.equals(moveOption)) {
            Location newLocation = rightOrStraightMove(crossLine, currentLocation, guide, this);
            moveRightCompass(currentLocation, newLocation);
            return  newLocation;
        }

        if (STRAIGHT_OPTION.equals(moveOption)) {
            Location newLocation = rightOrStraightMove(mainLine, currentLocation, guide, this);
            moveStraightCompass(currentLocation, newLocation);
            return  newLocation;
        }

        if (BACK_OPTION.equals(moveOption)) {
            Location newLocation = leftOrBackMove(mainLine, currentLocation, guide, this);
            moveBackCompass(currentLocation, newLocation);
            return  newLocation;
        }

        return new Location("");
    }
}
