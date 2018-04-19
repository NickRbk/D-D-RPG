package cursor.rybak.model.maze;

import cursor.rybak.model.team.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Location {

    private String coordinates;
    private Team team;

    /**
     * a main line (move straight and back)
     * vertical line
     */
    private List<Location> lineA = new LinkedList<>();
    private int currentLocationOnLineA;

    /**
     * a cross line (move left and back)
     * horizontal line
     */
    private List<Location> lineB = new LinkedList<>();
    private int currentLocationOnLineB;


    public Location(String coordinates) {
        this.coordinates = coordinates;
    }
}
