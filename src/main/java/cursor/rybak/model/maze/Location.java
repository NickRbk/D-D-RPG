package cursor.rybak.model.maze;

import cursor.rybak.model.team.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class Location {

    private String coordinates;
    private Team team;

    /**
     * a main line (move straight and back)
     * vertical line
     */
    private LinkedList<Location> lineA = new LinkedList<>();
    private int currentLocationOnLineA;

    /**
     * a cross line (move left and back)
     * horizontal line
     */
    private LinkedList<Location> lineB = new LinkedList<>();
    private int currentLocationOnLineB;


    public Location(String coordinates) {
        this.coordinates = coordinates;
    }
}
