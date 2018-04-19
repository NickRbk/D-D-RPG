package cursor.rybak.game;

import cursor.rybak.model.maze.AbstractMaze;
import cursor.rybak.model.maze.Location;
import cursor.rybak.model.maze.impl.Maze;
import cursor.rybak.model.maze.map.MazeMap;
import cursor.rybak.model.team.Team;
import cursor.rybak.view.GeneralMessage;
import cursor.rybak.view.TeamMessage;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Map;

public class Game {
    public static void start() {
        GeneralMessage.welcomeInfo();

        String teamName = UserInteraction.askName("Team name");

        Team team = new Team(teamName);
        TeamMessage.printTeamInfo(team);

        String gameMode = UserInteraction.askGameMode();

        Location startLocation = MazeSetUp.enterToMaze(team, gameMode);
        System.out.println(startLocation.getTeam());
        System.out.println(startLocation.getLineA().size());
        System.out.println(startLocation.getLineB().size());
    }
}
