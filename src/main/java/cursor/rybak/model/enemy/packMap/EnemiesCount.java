package cursor.rybak.model.enemy.packMap;

import lombok.Getter;

public enum EnemiesCount {
    EASY(8), MEDIUM(14), HARD(25);

    @Getter
    private int count;

    EnemiesCount(int count) {
        this.count = count;
    }
}
