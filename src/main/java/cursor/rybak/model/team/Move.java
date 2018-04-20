package cursor.rybak.model.team;

import cursor.rybak.model.guide.Guide;
import cursor.rybak.model.maze.Location;

public interface Move {
    Location move(Location currentLocation, String moveOption, Guide guide);
}
