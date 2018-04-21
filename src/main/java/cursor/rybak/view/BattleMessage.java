package cursor.rybak.view;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.team.Team;

import java.util.List;

public class BattleMessage implements MagicColors {
    public static void printStartBattleInfo(Team team, List<AbstractMonster> enemies) {
        System.out.println(RED + "\t<===BATTLE PHASE WILL BE HERE===>" + RESET);
    }
}
