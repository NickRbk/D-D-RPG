package cursor.rybak.game;

import cursor.rybak.model.maze.Location;
import cursor.rybak.view.BattleMessage;

public class Battle {
    public static void blitzkrieg(Location currentLocation) {
        if(currentLocation.getEnemies() != null) {
            BattleMessage.printStartBattleInfo(currentLocation.getTeam(), currentLocation.getEnemies());
            currentLocation.setEnemies(null);
        }
    }
}
