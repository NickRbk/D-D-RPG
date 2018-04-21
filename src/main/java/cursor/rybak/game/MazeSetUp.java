package cursor.rybak.game;

import cursor.rybak.model.guide.Guide;
import cursor.rybak.model.maze.AbstractMaze;
import cursor.rybak.model.maze.Location;
import cursor.rybak.model.maze.LocationsDescription;
import cursor.rybak.model.maze.compass.ListUtil;
import cursor.rybak.model.maze.impl.Maze;
import cursor.rybak.model.maze.map.MazeMap;
import cursor.rybak.model.team.Team;

import java.util.List;
import java.util.Map;

public class MazeSetUp {
    private static void throwTeamOnLocation(AbstractMaze maze, Team team) {
        Map<String, Location> mazeMap = MazeMap.getMazeMap(maze.getMaze());

//        while(true) {
//            int positionX = (int)Math.round( Math.random() * maze.getWidth());
//            int positionY = (int)Math.round( Math.random() * maze.getHeight());
//            String key = String.format("%d|%d", positionX, positionY);
//
//            if (mazeMap.get(key).isPath()) {
//                mazeMap.get(key).setTeam(team);
//                maze.getMaze()[positionX][positionY] = 2;
//                return;
//            }
//        }
    }


    /**
     * Initialize maze and all locations in it
     *
     * @param team     team
     * @param gameMode game mode
     * @return start location
     */
    public static Location enterToMaze(Team team, String gameMode, Guide guide) {
        AbstractMaze maze = new Maze(Mode.valueOf(gameMode).getWidth(), Mode.valueOf(gameMode).getHeight());
        Map<String, Location> mazeMap = generateGameLocations(maze);

        guide.setPlayground(maze);
        maze.print();

        return initStartLocation(mazeMap, maze, team);
    }


    /**
     * Initialize game start location
     *
     * @param mazeMap map maze
     * @param maze    maze instance
     * @param team    team
     * @return start location
     */
    private static Location initStartLocation(Map<String, Location> mazeMap,
                                              AbstractMaze maze,
                                              Team team) {

        Location startLocation = mazeMap.get(
                generateLocationMapKey(maze.getTeamStartPoint()[0], maze.getTeamStartPoint()[1])
        );

        startLocation.setTeam(team);
        startLocation.setDescription(LocationsDescription.START_POINT.getDescription());

        // ALWAYS pass to MainLine and Cross line COPY of LineA and LineB
        startLocation.setMainLine( ListUtil.copy(startLocation.getLineA()) );
        startLocation.setCrossLine( ListUtil.copy(startLocation.getLineB()) );

        return startLocation;
    }


    /**
     * helper function to create key in
     * specific form
     *
     * @param positionX column
     * @param positionY row
     * @return key
     */
    private static String generateLocationMapKey(int positionX, int positionY) {
        return String.format("%d|%d", positionX, positionY);
    }


    /**
     * Generate location abstraction
     *
     * @param maze maze class
     * @return maze map
     */
    private static Map<String, Location> generateGameLocations(AbstractMaze maze) {
        // prepared map with Locations
        Map<String, Location> mazeMap = MazeMap.getMazeMap(maze.getMaze());

        // prepared map with lines (vertical & horizontal)
        Map<String, List<Location>> LinesA = MazeMap.getLinesA(maze.getMaze(), mazeMap);
        Map<String, List<Location>> LinesB = MazeMap.getLinesB(maze.getMaze(), mazeMap);


        mazeMap.forEach((keyLocation, location) -> {

            LinesA.forEach((keyLine, lineA) -> {
                if (keyLine.contains(";" + keyLocation + ";")) {
                    location.setLineA(listOfNeighbors(lineA, location));
                }
            });

            LinesB.forEach((keyLine, lineB) -> {
                if (keyLine.contains(";" + keyLocation + ";")) {
                    location.setLineB(listOfNeighbors(lineB, location));
                }
            });

            location.setDescription(getLocationDescription());
        });

        return mazeMap;
    }


    /**
     * Choose description from enum randomly
     *
     * @return location description
     */
    private static String getLocationDescription() {
        int index = (int) Math.round(Math.random() * 19);

        return LocationsDescription.valueOf("LOCATION" + index).getDescription();
    }


    /**
     * retrieve from full path only our concrete location
     * and its neighbors
     *
     * @param fullPath full line
     * @param location certain location
     * @return list of adjacent fields
     */
    private static List<Location> listOfNeighbors(List<Location> fullPath, Location location) {
        int locationIndex = fullPath.indexOf(location);

        int startIndex = locationIndex == 0 ? locationIndex : locationIndex - 1;
        int lastIndex = locationIndex + 2 > fullPath.size() ? fullPath.size() : locationIndex + 2;

        return fullPath.subList(startIndex, lastIndex);
    }
}
