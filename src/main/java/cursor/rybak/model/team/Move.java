package cursor.rybak.model.team;

import cursor.rybak.model.maze.Location;

import java.util.List;

public interface Move {
    Location move(Location currentLocation, String moveOption);

//    Location moveLeft(List<Location> crossDirection);
//    Location moveRight(List<Location> crossDirection);
//    Location moveStraight(List<Location> mainDirection);
//    Location moveBack(List<Location> mainDirection);
}
