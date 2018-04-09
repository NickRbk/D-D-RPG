package io.rybak.model.maze.impl;

import io.rybak.model.maze.AbstractMaze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Maze extends AbstractMaze {

    public Maze(int width, int height) {
        super(width, height);
        generate(width, height);
    }

    /**
     * Randomized Prim's algorithm
     * @param width count of columns
     * @param height count of rows
     */
    private void generate(int width, int height) {
        this.maze = new int[width][height];

        ArrayList<int[]> walls = new ArrayList<>();
        Random random = new Random();
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        walls.add(new int[]{x, y, x, y});

        while (!walls.isEmpty()) {
            final int[] f = walls.remove(random.nextInt(walls.size()));

            // define current position tp start
            x = f[2];
            y = f[3];

            if (maze[x][y] == WALL) {
                maze[f[0]][f[1]] = maze[x][y] = PATH;
                if (x >= 2 && maze[x - 2][y] == WALL)
                    walls.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && maze[x][y - 2] == WALL)
                    walls.add(new int[]{x, y - 1, x, y - 2});
                if (x < width - 2 && maze[x + 2][y] == WALL)
                    walls.add(new int[]{x + 1, y, x + 2, y});
                if (y < height - 2 && maze[x][y + 2] == WALL)
                    walls.add(new int[]{x, y + 1, x, y + 2});
            }
        }
    }

    /**
     * print maze
     */
    @Override
    public void print() {
        String border = String.join("", Collections.nCopies(width - 1, "\u2593\u2593"));
        System.out.format("%s%s%s", "\n\n\t\u2593\u2593", border, "\u2593\u2593\u2593\n");
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (maze[col][row] == PATH) {
                    if (col == 0) {
                        System.out.format("%s", "\t\u2593\u2593" + PATH_ICON);
                    } else {
                        System.out.format("%s", col < width - 1 ? PATH_ICON : PATH_ICON + "\u2593\n");
                    }
                } else if (maze[col][row] == TEAM) {
                    if (col == 0) {
                        System.out.format("%s", "\t\u2593\u2593" + TEAM_ICON);
                    } else {
                        System.out.format("%s", col < width - 1 ? TEAM_ICON : TEAM_ICON + "\u2593\n");
                    }
                } else if (maze[col][row] == ENEMY) {
                    if (col == 0) {
                        System.out.format("%s", "\t\u2593\u2593" + ENEMY_ICON);
                    } else {
                        System.out.format("%s", col < width - 1 ? ENEMY_ICON : ENEMY_ICON + "\u2593\n");
                    }
                } else if (maze[col][row] == OBJECTIVE) {
                    if (col == 0) {
                        System.out.format("%s", "\t\u2593\u2593" + OBJECTIVE_ICON);
                    } else {
                        System.out.format("%s", col < width - 1 ? OBJECTIVE_ICON : OBJECTIVE_ICON + "\u2593\n");
                    }
                } else {
                    if (col == 0) {
                        System.out.format("%s", "\t\u2593\u2593" + WALL_ICON);
                    } else {
                        System.out.format("%s", col < width - 1 ? WALL_ICON : WALL_ICON + "\u2593\n");
                    }

                }
            }
        }
        System.out.format("%s%s%s", "\t\u2593\u2593", border, "\u2593\u2593\u2593\n");
    }
}
