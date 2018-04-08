package io.rybak.model.maze;

import java.util.ArrayList;

public class Maze {
    private static final int numRows = 30;
    private static final int numCols = 30;
    private static String[][] maze = new String[numRows][numCols];

    public static void generate() {

        maze = new String[numRows][numCols];

        initializeBoard(maze);
        draw();
        printMaze();
    }

    /**
     * Initialize board for future maze (STEP 1)
     *
     * @param maze array of our maze
     */
    private static void initializeBoard(String[][] maze) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // initialize playground with default layout ("not in maze")
                maze[i][j] = j < numCols - 1 ? "\u2593\u2593" : "\u2593\u2593\n";
            }
        }
    }

    /**
     * Check if our current position is out (STEP 2)
     * of bounds
     *
     * @param row current row
     * @param col current col
     * @return true if out of bounds
     */
    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || col < 0 || row >= numRows || col >= numCols;
    }

    /**
     * check if current position in maze (STEP 3)
     *
     * @param row current row
     * @param col current col
     * @return true if in Maze (or out bounds)
     */
    private static boolean inMaze(int row, int col) {
        return isOutOfBounds(row, col) || maze[row][col].equals("  "); // "in maze"
    }

    /**
     * find all walls around current position (STEP 4)
     *
     * @param row current row
     * @param col current col
     * @return walls around the current position
     */
    private static ArrayList<int[][]> getWalls(int row, int col) {
        ArrayList<int[][]> walls = new ArrayList<>();
        int[] source = {row, col};

        if (!inMaze(row, col - 1)) {
            int[] dest = {row, col - 1};
            int[][] wall = {source, dest};
            walls.add(wall);
        }
        if (!inMaze(row - 1, col)) {
            int[] dest = {row - 1, col};
            int[][] wall = {source, dest};
            walls.add(wall);
        }
        if (!inMaze(row, col + 1)) {
            int[] dest = {row, col + 1};
            int[][] wall = {source, dest};
            walls.add(wall);
        }
        if (!inMaze(row + 1, col)) {
            int[] dest = {row + 1, col};
            int[][] wall = {source, dest};
            walls.add(wall);
        }
        return walls;
    }

    /**
     * print maze in console (STEP PRINT)
     */
    private static void printMaze() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.format("%s", maze[row][col]);
            }
        }
    }

    // STEP 7
    private static int curRow = (int) Math.floor(Math.random() * numRows);
    private static int curCol = (int) Math.floor(Math.random() * numCols);

    /**
     * draw maze (STEP 5)
     */
    private static void draw() {
        maze[curRow][curCol] = "  ";
        ArrayList<int[][]> wallsToKnockDown = getWalls(curRow, curCol);

        while (wallsToKnockDown.size() > 0) {

            // HAVE QUESTiONS
            int[][] wall = wallsToKnockDown.get((int) Math.round(Math.random() * (wallsToKnockDown.size() - 1)));
//            System.out.println(wall.toString());

            int sourceRow = wall[0][0];
            int sourceCol = wall[0][1];
            int destRow = wall[1][0];
            int destCol = wall[1][1];
            String destCell = maze[destRow][destCol];

            if (destCell.equals("  ")) {
                return;
            }

            maze[destRow][destCol] = "  "; // set new cell as part of maze
            maze[sourceRow][sourceCol] = "  ";

            wallsToKnockDown.addAll(getWalls(destRow, destCol));

            maze[curRow][curCol] = "  ";
            maze[destRow][destCol] = "LP";

//            drawCell(curRow, curCol, cells[curRow][curCol]);
//            drawCell(destRow, destCol, cells[destRow][destCol]);
//
//            fill(255, 255, 255);
//            rect(2 + (cellSize * 2) * (sourceCol + destCol)/2,
//                    2 + (cellSize * 2) * (sourceRow + destRow)/2,
//                    cellSize, cellSize);

            printMaze();
            curRow = destRow;
            curCol = destCol;
        }
    }


    private static void makePath(String[][] maze) {
        maze[28][0] = "  ";
        maze[28][1] = "  ";
        maze[28][2] = "  ";
        maze[27][2] = "  ";
        maze[26][2] = "  ";
    }
}
