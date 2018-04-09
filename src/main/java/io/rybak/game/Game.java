package io.rybak.game;

import io.rybak.model.maze.Location;
import io.rybak.model.maze.Maze;
import io.rybak.model.maze.map.MazeMap;
import io.rybak.model.team.Team;

import java.util.Map;

public class Game {
    public static void start() {
        String teamName = UserInteraction.askTeamName();
        Team team = new Team(teamName);
        System.out.println(team.toString());
        String gameMode = UserInteraction.askGameMode();
        Maze maze = new Maze(Mode.valueOf(gameMode).getWidth(), Mode.valueOf(gameMode).getHeight());

        throwTeamOnLocation(maze, team);
        maze.print();
    }

    private static void throwTeamOnLocation(Maze maze, Team team) {
        Map<String, Location> mazeMap = MazeMap.getMazeMap(maze.getMaze());

        while(true) {
            int positionX = (int)Math.round( Math.random() * maze.getWidth());
            int positionY = (int)Math.round( Math.random() * maze.getHeight());
            String key = String.format("%d|%d", positionX, positionY);

            if (mazeMap.get(key).isPath()) {
                mazeMap.get(key).setTeam(team);
                System.out.println("Team on location " + key);
//                maze.getMaze()[positionX][positionY] = null;
                return;
            }
        }
    }
}
