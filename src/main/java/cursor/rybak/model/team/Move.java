package cursor.rybak.model.team;

import cursor.rybak.model.maze.Location;

public interface Move {
    Location move(Location currentLocation, String moveOption);
}
