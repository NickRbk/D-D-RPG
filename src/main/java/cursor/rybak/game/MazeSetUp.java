package cursor.rybak.game;

import cursor.rybak.model.maze.AbstractMaze;
import cursor.rybak.model.maze.Location;
import cursor.rybak.model.maze.impl.Maze;
import cursor.rybak.model.maze.map.MazeMap;
import cursor.rybak.model.team.Team;

import java.util.LinkedList;
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

    public static Location enterToMaze(Team team, String gameMode) {
        AbstractMaze maze = new Maze(Mode.valueOf(gameMode).getWidth(), Mode.valueOf(gameMode).getHeight());

        Map<String, Location> mazeMap = generateGameLocations(maze);

        Location startLocation = mazeMap.get(
                generateLocationMapKey(maze.getTeamStartPoint()[0], maze.getTeamStartPoint()[1])
        );

        startLocation.setTeam(team);
        maze.print();

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
     * @param maze maze class
     * @return maze map
     */
    private static Map<String, Location> generateGameLocations(AbstractMaze maze) {
        // prepared map with Locations
        Map<String, Location> mazeMap = MazeMap.getMazeMap(maze.getMaze());

        // prepared map with lines (vertical & horizontal)
        Map<String, LinkedList<Location>> LinesA = MazeMap.getLinesA(maze.getMaze(), mazeMap);
        Map<String, LinkedList<Location>> LinesB = MazeMap.getLinesB(maze.getMaze(), mazeMap);


        mazeMap.forEach((keyLocation, location) -> {

            LinesA.forEach((keyLine, lineA) -> {
                if(keyLine.contains(";" + keyLocation + ";")) {
                    location.setLineA( lineA );
                }
            });

            LinesB.forEach((keyLine, lineB) -> {
                if(keyLine.contains(";" + keyLocation + ";")) {
                    location.setLineB( lineB );
                }
            });

        });

        return mazeMap;

//        System.out.println("All rooms: " + mazeMap.size());
//        System.out.println("All horizontal lines (LinesB): " + getLinesB.size());
//
//        getLinesB.keySet().forEach(System.out::println);
//
//        System.out.println("All vertical lines (LinesA): " + getLinesA.size());
//
//        getLinesA.keySet().forEach(System.out::println);
    }
}
