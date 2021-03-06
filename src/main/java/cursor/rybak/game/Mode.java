package cursor.rybak.game;

import lombok.Getter;

public enum Mode {
    EASY(20, 6), MEDIUM(50, 30), HARD(65, 40);

    @Getter
    private int width, height;

    Mode(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
