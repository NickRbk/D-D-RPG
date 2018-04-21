package cursor.rybak.model.maze.map;

import cursor.rybak.model.maze.Location;
import cursor.rybak.model.maze.MazeConst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MazeMap implements MazeConst {

    /**
     * Generate maze map.
     * Keys in map are string to the indexes in format "i|i"
     * That needed to initialize Locations
     *
     * @param maze 2 dimension int maze int[][]
     * @return maze map
     */
    public static Map<String, Location> getMazeMap(int[][] maze) {
        int width = maze.length;
        int height = maze[0].length;

        Map<String, Location> mazeMap = new HashMap<>();

        // store in map only game playground (without WALL)
        // KEY in map is INDEXES in [][] array
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                String key = String.format("%d|%d", i, j);

                if (maze[i][j] != WALL) {
                    mazeMap.put(key, new Location(key));
                }
            }
        }

        return mazeMap;
    }


    /**
     * Find all horizontal lines in map (LineB)
     * and put them into map
     *
     * @param maze    2 dimension int maze int[][]
     * @param mazeMap maze map
     * @return map of all horizontal lines
     * (in our app it's LineB)
     */
    public static Map<String, List<Location>> getLinesB(int[][] maze,
                                                        Map<String, Location> mazeMap) {

        Map<String, List<Location>> linesAMap = new HashMap<>();

        int width = maze.length;
        int height = maze[0].length;

        for (int row = 0; row < height; row++) {

            StringBuilder keys = new StringBuilder();
            List<Location> lineA = new LinkedList<>();

            int counterA = 0;

            for (int col = 0; col < width; col++) {

                if (maze[col][row] != WALL) {

                    addToLineLocation(col, row, keys, lineA, mazeMap);
                    counterA++;

                } else {
                    if (counterA > 1) {
                        linesAMap.put(keys.toString(), lineA);
                    }

                    counterA = 0;
                    lineA = new LinkedList<>();
                    keys = new StringBuilder();
                }

                if (col == width - 1) {
                    if (counterA > 1) {
                        linesAMap.put(keys.toString(), lineA);
                    }

                    counterA = 0;
                    lineA = new LinkedList<>();
                    keys = new StringBuilder();
                }
            }
        }

        return linesAMap;
    }


    /**
     * Find all vertical lines in map (LineA)
     * and put them into map
     *
     * @param maze    2 dimension int maze int[][]
     * @param mazeMap maze map
     * @return map of all vertical lines
     * (in our app it's LineA)
     */
    public static Map<String, List<Location>> getLinesA(int[][] maze,
                                                              Map<String, Location> mazeMap) {

        Map<String, List<Location>> linesBMap = new HashMap<>();

        int width = maze.length;
        int height = maze[0].length;

        for (int col = 0; col < width; col++) {

            StringBuilder keys = new StringBuilder();
            List<Location> lineB = new LinkedList<>();

            int counterB = 0;

            for (int row = height - 1; row >= 0; row--) {


                if (maze[col][row] != WALL) {

                    addToLineLocation(col, row, keys, lineB, mazeMap);
                    counterB++;

                } else {
                    if (counterB > 1) {
                        linesBMap.put(keys.toString(), lineB);
                    }

                    counterB = 0;
                    lineB = new LinkedList<>();
                    keys = new StringBuilder();
                }

                if (row == 0) {
                    if (counterB > 1) {
                        linesBMap.put(keys.toString(), lineB);
                    }

                    counterB = 0;
                    lineB = new LinkedList<>();
                    keys = new StringBuilder();
                }
            }
        }

        return linesBMap;
    }


    /**
     * create LinkedList of Locations for
     * particular line
     *
     * @param col     column in maze[][]
     * @param row     row in maze[][]
     * @param keys    StringBuilder to create general key
     * @param line    List of current line
     * @param mazeMap map of our maze
     */
    private static void addToLineLocation(int col,
                                          int row,
                                          StringBuilder keys,
                                          List<Location> line,
                                          Map<String, Location> mazeMap) {

        String key = generateLocationMapKey(col, row);
        String keyLines = ";" + key + ";";

        keys.append(keyLines);

        line.add(mazeMap.get(key));
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

}
