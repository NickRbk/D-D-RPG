package cursor.rybak.model.maze;

import cursor.rybak.view.MagicColors;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class AbstractMaze implements MazeConst, MagicColors {
    protected static final String WALL_ICON = "\u2593\u2593";
    protected static final String PATH_ICON = "  ";
    protected static final String TEAM_ICON_VECTOR_UP = GREEN +  "\u2B06 " + RESET;
    protected static final String TEAM_ICON_VECTOR_DOWN = GREEN +  "\u2B07 " + RESET;
    protected static final String TEAM_ICON_VECTOR_LEFT = GREEN +  "\u2B05 " + RESET;
    protected static final String TEAM_ICON_VECTOR_RIGHT = GREEN +  "\u27A1 " + RESET;
    protected static final String ENEMY_ICON = RED + "\u26BF " + RESET;
    protected static final String OBJECTIVE_ICON = BLUE + "\u26C7 " + RESET;

    // save maze dimensions
    protected int width;
    protected int height;

    // 2 dimension array of our maze
    protected int[][] maze;

    @Setter
    private int[] teamStartPoint;
    @Setter
    private int[] objectiveEndPoint;


    public AbstractMaze(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void print();
}
