package cursor.rybak.game;

import cursor.rybak.model.maze.AbstractMaze;
import cursor.rybak.model.maze.Location;
import cursor.rybak.model.maze.impl.Maze;
import cursor.rybak.model.maze.map.MazeMap;
import cursor.rybak.model.team.Team;

import java.util.Map;

public class Game {
    public static void start() {
        String teamName = UserInteraction.askTeamName();

        Team team = new Team(teamName);
        System.out.println(team.toString());

        String gameMode = UserInteraction.askGameMode();

        enterToMaze(team, gameMode);
    }

    private static void throwTeamOnLocation(AbstractMaze maze, Team team) {
        Map<String, Location> mazeMap = MazeMap.getMazeMap(maze.getMaze());

        while(true) {
            int positionX = (int)Math.round( Math.random() * maze.getWidth());
            int positionY = (int)Math.round( Math.random() * maze.getHeight());
            String key = String.format("%d|%d", positionX, positionY);

            if (mazeMap.get(key).isPath()) {
                mazeMap.get(key).setTeam(team);
                maze.getMaze()[positionX][positionY] = 2;
                return;
            }
        }
    }

    private static void enterToMaze(Team team, String gameMode) {
        AbstractMaze maze = new Maze(Mode.valueOf(gameMode).getWidth(), Mode.valueOf(gameMode).getHeight());
        throwTeamOnLocation(maze, team);
        maze.print();
    }
}
