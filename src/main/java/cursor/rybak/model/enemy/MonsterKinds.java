package cursor.rybak.model.enemy;

import lombok.Getter;

public enum MonsterKinds {

    CREATURE("creature"), ORKOID("orkoid"), UNDEAD("undead");

    @Getter
    private String kind;

    MonsterKinds(String kind) {
        this.kind = kind;
    }
}
