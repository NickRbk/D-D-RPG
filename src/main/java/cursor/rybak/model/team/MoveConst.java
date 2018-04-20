package cursor.rybak.model.team;

public interface MoveConst {
    String LEFT_OPTION = "a";
    String BACK_OPTION = "s";
    int LEFT_OR_BACK = 0;

    String RIGHT_OPTION = "d";
    String STRAIGHT_OPTION = "w";

    int RIGHT_OR_STRAIGHT_IF_ALONE = 1;
    int RIGHT_OR_STRAIGHT_IF_FULL = 2;
}
