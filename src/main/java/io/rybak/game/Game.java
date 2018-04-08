package io.rybak.game;

import io.rybak.model.maze.Maze;
import io.rybak.model.team.Team;

public class Game {
    public static void start() {
        String teamName = UserInteraction.askTeamName();
        Team team = new Team(teamName);
        System.out.println(team.toString());
    }
}
