package cursor.rybak.model.maze;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.team.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Location implements LineTypes {

    private String coordinates;
    private Team team;
    private List<AbstractMonster> enemies;

    private String description;

    private List<Location> mainLine = new LinkedList<>();
    boolean isMainReverse = false;
    String mainLineType = lineTypeA;

    private List<Location> crossLine = new LinkedList<>();

    private boolean isObjective = false;

    /**
     * a main line (move straight and back)
     * vertical line
     */
    private List<Location> lineA = new LinkedList<>();


    /**
     * a cross line (move left and back)
     * horizontal line
     */
    private List<Location> lineB = new LinkedList<>();



    public Location(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return String.format("\n\tRoom #%s\n%s", coordinates, description);
    }
}
