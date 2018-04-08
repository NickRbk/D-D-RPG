package io.rybak.game;

import io.rybak.model.maze.Maze;
import io.rybak.model.team.Team;

public class Game {
    public static void start() {
        Maze.generate();
        String race = UserInteraction.askRace();
        Team team = new Team(race);
        System.out.println(team.toString());
    }
}
