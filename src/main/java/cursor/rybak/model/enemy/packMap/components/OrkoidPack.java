package cursor.rybak.model.enemy.packMap.components;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.kind.orkoid.impl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrkoidPack {
    public static Map<String, List<AbstractMonster>> getOrkoidPack() {

        Map<String, List<AbstractMonster>> orkoidPack = new HashMap<>();

        orkoidPack.put("0", getPack1());
        orkoidPack.put("1", getPack2());
        orkoidPack.put("2", getPack3());
        orkoidPack.put("3", getPack4());
        orkoidPack.put("4", getPack5());
        orkoidPack.put("5", getPack6());
        orkoidPack.put("6", getPack7());
        orkoidPack.put("7", getPack8());

        return orkoidPack;
    }

    private static List<AbstractMonster> getPack1() {
        List<AbstractMonster> pack1 = new ArrayList<>();
        pack1.add(new Goblin());
        return pack1;
    }

    private static List<AbstractMonster> getPack2() {
        List<AbstractMonster> pack2 = new ArrayList<>();
        pack2.add(new Ogre());
        return pack2;
    }

    private static List<AbstractMonster> getPack3() {
        List<AbstractMonster> pack3 = new ArrayList<>();
        pack3.add(new OrkShaman());
        return pack3;
    }

    private static List<AbstractMonster> getPack4() {
        List<AbstractMonster> pack4 = new ArrayList<>();
        pack4.add(new UnstableAlchemist());
        return pack4;
    }

    private static List<AbstractMonster> getPack5() {
        List<AbstractMonster> pack5 = new ArrayList<>();
        pack5.add(new Goblin());
        pack5.add(new Ork());
        return pack5;
    }

    private static List<AbstractMonster> getPack6() {
        List<AbstractMonster> pack6 = new ArrayList<>();
        pack6.add(new OrkWarlord());
        pack6.add(new OrkShaman());
        return pack6;
    }

    private static List<AbstractMonster> getPack7() {
        List<AbstractMonster> pack7 = new ArrayList<>();
        pack7.add(new Ogre());
        pack7.add(new Goblin());
        return pack7;
    }

    private static List<AbstractMonster> getPack8() {
        List<AbstractMonster> pack8 = new ArrayList<>();
        pack8.add(new OrkShaman());
        pack8.add(new Ogre());
        return pack8;
    }
}
