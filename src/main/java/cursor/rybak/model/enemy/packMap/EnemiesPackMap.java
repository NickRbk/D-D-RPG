package cursor.rybak.model.enemy.packMap;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.packMap.components.CreaturePack;
import cursor.rybak.model.enemy.packMap.components.OrkoidPack;
import cursor.rybak.model.enemy.packMap.components.UndeadPack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnemiesPackMap {
    public static Map<String, Map<String, List<AbstractMonster>>> getEnemiesPack() {
        Map<String, Map<String, List<AbstractMonster>>> enemiesPack = new HashMap<>();

        enemiesPack.put(MonsterKinds.CREATURE.getKind(), CreaturePack.getCreaturePack());
        enemiesPack.put(MonsterKinds.ORKOID.getKind(), OrkoidPack.getOrkoidPack());
        enemiesPack.put(MonsterKinds.UNDEAD.getKind(), UndeadPack.getUndeadPack());

        return enemiesPack;
    }
}
