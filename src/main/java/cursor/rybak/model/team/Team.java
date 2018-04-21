package cursor.rybak.model.team;

import cursor.rybak.game.UserInteraction;
import cursor.rybak.model.guide.Guide;
import cursor.rybak.model.maze.LineTypes;
import cursor.rybak.model.maze.Location;
import cursor.rybak.model.maze.MazeConst;
import cursor.rybak.model.maze.compass.Compass;
import cursor.rybak.model.race.AbstractRace;
import lombok.Getter;

import java.util.List;

public class Team implements Move, MoveConst, Compass, MazeConst {
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

    /**
     * find index on line (main or cross)
     *
     * @param line current line
     * @return index on line
     */
    public static int getLocationIndex(List<Location> line) {
        if (line.size() == 2) return RIGHT_OR_STRAIGHT_IF_ALONE;
        else return RIGHT_OR_STRAIGHT_IF_FULL;
    }

    /**
     * Move Team icon on maze
     *
     * @param guide                      abstraction GUIDE (holder of maze map)
     * @param currentLocationCoordinates coordinates of current location
     * @param newLocation                destination location
     */
    private void moveTeamOnMaze(Guide guide,
                                String currentLocationCoordinates,
                                Location newLocation) {

        String[] currentPosition = currentLocationCoordinates.split("\\|");
        String[] newPosition = newLocation.getCoordinates().split("\\|");

        guide.getPlayground().getMaze()
                [Integer.parseInt(currentPosition[0])]
                [Integer.parseInt(currentPosition[1])] = PATH;

        if (LineTypes.lineTypeA.equals(newLocation.getMainLineType())) {

            if (newLocation.isMainReverse()) {
                guide.getPlayground().getMaze()
                        [Integer.parseInt(newPosition[0])]
                        [Integer.parseInt(newPosition[1])] = TEAM_VECTOR_DOWN;
            } else {
                guide.getPlayground().getMaze()
                        [Integer.parseInt(newPosition[0])]
                        [Integer.parseInt(newPosition[1])] = TEAM_VECTOR_UP;
            }
        } else {
            if (newLocation.isMainReverse()) {
                guide.getPlayground().getMaze()
                        [Integer.parseInt(newPosition[0])]
                        [Integer.parseInt(newPosition[1])] = TEAM_VECTOR_LEFT;
            } else {
                guide.getPlayground().getMaze()
                        [Integer.parseInt(newPosition[0])]
                        [Integer.parseInt(newPosition[1])] = TEAM_VECTOR_RIGHT;
            }
        }
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
                                         Team team) {

        int index = getLocationIndex(line);

        Location newLocation = line.get(index);
        return setNewLocation(currentLocation, newLocation, team);
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
                                    Team team) {

        Location newLocation = line.get(LEFT_OR_BACK);
        return setNewLocation(currentLocation, newLocation, team);
    }


    /**
     * Helper method for 'leftOrBackMove' & 'rightOrStraightMove'
     *
     * @param currentLocation current location
     * @param newLocation     destination location
     * @param team            team
     * @return
     */
    private Location setNewLocation(Location currentLocation,
                                    Location newLocation,
                                    Team team) {

        currentLocation.setTeam(null);
        newLocation.setTeam(team);

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

        // NEED REFACTORING

        List<Location> mainLine = currentLocation.getMainLine();
        List<Location> crossLine = currentLocation.getCrossLine();

        if (LEFT_OPTION.equals(moveOption)) {
            Location newLocation = leftOrBackMove(crossLine, currentLocation, this);
            moveLeftCompass(currentLocation, newLocation);
            moveTeamOnMaze(guide, currentLocation.getCoordinates(), newLocation);
            return newLocation;
        }

        if (RIGHT_OPTION.equals(moveOption)) {
            Location newLocation = rightOrStraightMove(crossLine, currentLocation, this);
            moveRightCompass(currentLocation, newLocation);
            moveTeamOnMaze(guide, currentLocation.getCoordinates(), newLocation);
            return newLocation;
        }

        if (STRAIGHT_OPTION.equals(moveOption)) {
            Location newLocation = rightOrStraightMove(mainLine, currentLocation, this);
            moveStraightCompass(currentLocation, newLocation);
            moveTeamOnMaze(guide, currentLocation.getCoordinates(), newLocation);
            return newLocation;
        }

        if (BACK_OPTION.equals(moveOption)) {
            Location newLocation = leftOrBackMove(mainLine, currentLocation, this);
            moveBackCompass(currentLocation, newLocation);
            moveTeamOnMaze(guide, currentLocation.getCoordinates(), newLocation);
            return newLocation;
        }

        return new Location("");
    }
}
