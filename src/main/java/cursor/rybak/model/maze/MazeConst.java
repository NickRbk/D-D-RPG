package cursor.rybak.model.maze;

public interface MazeConst {

    // define constants value for wall, path,
    // team, enemies, objective (need to print them later)

    int WALL = 0;
    int PATH = 1;
    int TEAM_VECTOR_UP = 2;
    int TEAM_VECTOR_DOWN = 3;
    int TEAM_VECTOR_LEFT = 4;
    int TEAM_VECTOR_RIGHT = 5;
    int ENEMY = 6;
    int OBJECTIVE = 7;

    int MIN_PATHS = 10;
    int LOCATIONS_COUNT = 19;
}
