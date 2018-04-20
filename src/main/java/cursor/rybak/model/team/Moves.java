package cursor.rybak.model.team;

import lombok.Getter;

@Getter
public enum Moves implements MoveConst {
    A(LEFT_OPTION, "left"),
    D(RIGHT_OPTION, "right"),
    W(STRAIGHT_OPTION, "straight"),
    S(BACK_OPTION, "back");

    String optionAlias;
    String optionName;

    Moves(String optionAlias, String optionName) {
        this.optionAlias = optionAlias;
        this.optionName = optionName;
    }
}
