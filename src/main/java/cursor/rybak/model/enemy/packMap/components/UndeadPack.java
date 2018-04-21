package cursor.rybak.model.enemy.packMap.components;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.kind.undead.impl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndeadPack {
    public static Map<String, List<AbstractMonster>> getUndeadPack() {

        Map<String, List<AbstractMonster>> undeadPack = new HashMap<>();

        undeadPack.put("0", getPack1());
        undeadPack.put("1", getPack2());
        undeadPack.put("2", getPack3());
        undeadPack.put("3", getPack4());
        undeadPack.put("4", getPack5());
        undeadPack.put("5", getPack6());
        undeadPack.put("6", getPack7());
        undeadPack.put("7", getPack8());

        return undeadPack;
    }

    private static List<AbstractMonster> getPack1() {
        List<AbstractMonster> pack1 = new ArrayList<>();
        pack1.add(new Banshee());
        return pack1;
    }

    private static List<AbstractMonster> getPack2() {
        List<AbstractMonster> pack2 = new ArrayList<>();
        pack2.add(new Lich());
        return pack2;
    }

    private static List<AbstractMonster> getPack3() {
        List<AbstractMonster> pack3 = new ArrayList<>();
        pack3.add(new SkeletonChief());
        return pack3;
    }

    private static List<AbstractMonster> getPack4() {
        List<AbstractMonster> pack4 = new ArrayList<>();
        pack4.add(new Skeleton());
        return pack4;
    }

    private static List<AbstractMonster> getPack5() {
        List<AbstractMonster> pack5 = new ArrayList<>();
        pack5.add(new Zombie());
        pack5.add(new Zombie());
        return pack5;
    }

    private static List<AbstractMonster> getPack6() {
        List<AbstractMonster> pack6 = new ArrayList<>();
        pack6.add(new BoneDragon());
        pack6.add(new Zombie());
        return pack6;
    }

    private static List<AbstractMonster> getPack7() {
        List<AbstractMonster> pack7 = new ArrayList<>();
        pack7.add(new Zombie());
        pack7.add(new Zombie());
        return pack7;
    }

    private static List<AbstractMonster> getPack8() {
        List<AbstractMonster> pack8 = new ArrayList<>();
        pack8.add(new Lich());
        pack8.add(new Skeleton());
        return pack8;
    }
}
