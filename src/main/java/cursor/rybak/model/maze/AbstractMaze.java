package cursor.rybak.model.maze;

import cursor.rybak.view.MagicColors;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractMaze implements MagicColors {
    // define constants value for wall, path,
    // team, enemies, objective (need to print them later)
    protected static final int WALL = 0;
    protected static final int PATH = 1;
    protected static final int TEAM = 2;
    protected static final int ENEMY = 3;
    protected static final int OBJECTIVE = 4;

    protected static final String WALL_ICON = "\u2593\u2593";
    protected static final String PATH_ICON = "  ";
    protected static final String TEAM_ICON = GREEN +  "\u29EA " + RESET;
    protected static final String ENEMY_ICON = RED + "\u26BF" + RESET;
    protected static final String OBJECTIVE_ICON = BLUE + "\u26C7" + RESET;

    // save maze dimensions
    @Getter
    protected int width;
    @Getter
    protected int height;

    // 2 dimension array of our maze
    @Getter
    protected int[][] maze;

    @Getter
    @Setter
    private int[] teamStartPoint;

    public AbstractMaze(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void print();
}
