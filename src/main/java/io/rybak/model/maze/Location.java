package io.rybak.model.maze;

import io.rybak.model.team.Team;
import lombok.Getter;
import lombok.Setter;

public class Location {
    @Getter
    private boolean isPath;

    @Getter
    private String coordinates;

    @Getter
    @Setter
    private Team team;

    public Location(boolean isPath, String coordinates) {
        this.isPath = isPath;
        this.coordinates = coordinates;
    }
}
