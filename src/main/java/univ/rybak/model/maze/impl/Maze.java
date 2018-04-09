package univ.rybak.model.maze.impl;

import univ.rybak.model.maze.AbstractMaze;

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
     *
     * @param width  count of columns
     * @param height count of rows
     */
    private void generate(int width, int height) {
        this.maze = new int[width][height];
        ArrayList<int[]> walls = new ArrayList<>();

        Random random = new Random();
        walls.add(randomStartPoint(random));

        // this whole construction is a Prim's algorithm
        // and shouldn't split to separate methods
        while (!walls.isEmpty()) {
            final int[] candidateToCheck = walls.remove(random.nextInt(walls.size()));

            // define current position to start
            int x = candidateToCheck[2];
            int y = candidateToCheck[3];

            if (maze[x][y] == WALL) {
                maze[candidateToCheck[0]][candidateToCheck[1]] = maze[x][y] = PATH;
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

                    printMazeElements(col, PATH_ICON);
                } else if (maze[col][row] == TEAM) {

                    printMazeElements(col, TEAM_ICON);
                } else if (maze[col][row] == ENEMY) {

                    printMazeElements(col, ENEMY_ICON);
                } else if (maze[col][row] == OBJECTIVE) {

                    printMazeElements(col, OBJECTIVE_ICON);
                } else {

                    printMazeElements(col, WALL_ICON);
                }
            }
        }
        System.out.format("%s%s%s", "\t\u2593\u2593", border, "\u2593\u2593\u2593\n");
    }

    /**
     * print maze by appropriate icon, helper for print()
     * @param col current column
     * @param icon icon for maze element
     */
    private void printMazeElements(int col, String icon) {
        if (col == 0) {
            System.out.format("%s", "\t\u2593\u2593" + icon);
        } else {
            System.out.format("%s", col < width - 1 ? icon : icon + "\u2593\n");
        }
    }

    /**
     * find start point to create maze (random)
     * @return array of point
     */
    private int[] randomStartPoint(Random random) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        return new int[]{x, y, x, y};
    }
}
