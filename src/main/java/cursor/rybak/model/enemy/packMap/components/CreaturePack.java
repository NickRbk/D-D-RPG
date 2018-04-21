package cursor.rybak.model.enemy.packMap.components;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.kind.creature.impl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreaturePack {
    public static Map<String, List<AbstractMonster>> getCreaturePack() {

        Map<String, List<AbstractMonster>> creaturePack = new HashMap<>();

        creaturePack.put("0", getPack1());
        creaturePack.put("1", getPack2());
        creaturePack.put("2", getPack3());
        creaturePack.put("3", getPack4());
        creaturePack.put("4", getPack5());
        creaturePack.put("5", getPack6());
        creaturePack.put("6", getPack7());
        creaturePack.put("7", getPack8());

        return creaturePack;
    }

    private static List<AbstractMonster> getPack1() {
        List<AbstractMonster> pack1 = new ArrayList<>();
        pack1.add(new BlackDragon());
        return pack1;
    }

    private static List<AbstractMonster> getPack2() {
        List<AbstractMonster> pack2 = new ArrayList<>();
        pack2.add(new DoomSpider());
        pack2.add(new DoomSpider());
        pack2.add(new DoomSpider());
        return pack2;
    }

    private static List<AbstractMonster> getPack3() {
        List<AbstractMonster> pack3 = new ArrayList<>();
        pack3.add(new Doomguard());
        return pack3;
    }

    private static List<AbstractMonster> getPack4() {
        List<AbstractMonster> pack4 = new ArrayList<>();
        pack4.add(new Imp());
        return pack4;
    }

    private static List<AbstractMonster> getPack5() {
        List<AbstractMonster> pack5 = new ArrayList<>();
        pack5.add(new Minotaur());
        pack5.add(new Succubus());
        return pack5;
    }

    private static List<AbstractMonster> getPack6() {
        List<AbstractMonster> pack6 = new ArrayList<>();
        pack6.add(new BlackDragon());
        pack6.add(new Imp());
        return pack6;
    }

    private static List<AbstractMonster> getPack7() {
        List<AbstractMonster> pack7 = new ArrayList<>();
        pack7.add(new Minotaur());
        pack7.add(new Imp());
        return pack7;
    }

    private static List<AbstractMonster> getPack8() {
        List<AbstractMonster> pack8 = new ArrayList<>();
        pack8.add(new Doomguard());
        pack8.add(new Succubus());
        return pack8;
    }
}
