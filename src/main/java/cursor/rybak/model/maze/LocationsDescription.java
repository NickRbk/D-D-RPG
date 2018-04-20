package cursor.rybak.model.maze;

import com.sun.org.apache.regexp.internal.RE;
import cursor.rybak.view.MagicColors;
import lombok.Getter;

@Getter
public enum LocationsDescription implements MagicColors {

    START_POINT(CYAN + "\n\tYou're in Game, welcome! It's dark around... but doesn't matter.\n" +
            "\tYou must know only a few things... here live monsters and\n" +
            "\tyou run away from here, if you find the key)\n" +
            "\tBe careful, good luck!\n" + RESET),

    LOCATION0(CYAN + "\tThere is too much water. TEAM, we need to get out of here\n" + RESET),

    LOCATION1(CYAN + "\tA terrible place... what a noise here!!\n" + RESET),

    LOCATION2(CYAN + "\t...the flour creaks.. Nice))\n" + RESET),

    LOCATION3(CYAN + "\tSo low ceiling, what dwarf lived here!\n" + RESET),

    LOCATION4(CYAN + "\tSuspicious silence... But I must escape from here!\n" + RESET),

    LOCATION5(CYAN + "\tHow strange this picture hangs here.. em..\n" +
            "\t No,no,no, I'm very suspicious..)\n" +
            "\tYeah,I'm in a normal conventional.. bunker\n" + RESET),

    LOCATION6(CYAN + "\tThese inscriptions strain me. Why? Why all rooms named by indexes!\n" +
            "\tMaybe it's key to my freedom...\n" + RESET),

    LOCATION7(CYAN + "\t'You are in hell'.. very positive text on wall..\n" +
            "\tBut who left it here !?\n" + RESET),

    LOCATION8(CYAN + "\tIt becomes stuffy... but I feel that exit is close.. I hope\n" + RESET),

    LOCATION9(CYAN + "\tWow, laboratory! And what equipment are here!\n" +
            "\tTEAM, do not be distracted!\n" + RESET),

    LOCATION10(CYAN + "\tWhat contrasts, it becomes cool.. Why I didn't take a jacket!\n" + RESET),

    LOCATION11(CYAN + "\tWell, some interesting table and some letter... 'We have cookies'\n" +
            "\tWhat?! Someone is mocking us! But who?" + RESET),

    LOCATION12(CYAN + "\tWow, what the furniture. The one who lived here had a good taste))\n" + RESET),

    LOCATION13(CYAN + "\tCasino in the bunker?)) Really? TEAM, do not spend all money))\n" + RESET),

    LOCATION14(CYAN + "\tThis is good place to rest, quietly here. TEAM, set up a camp!\n" + RESET),

    LOCATION15(CYAN + "\tWalls, stones, a lot of dust...\n" + RESET),

    LOCATION16(CYAN + "\tRoom of mirrors, I hate that!\n" + RESET),

    LOCATION17(CYAN + "\tIt seems like a classroom... who was taught here?\n" + RESET),

    LOCATION18(CYAN + "\tOval cabinet, cool) But from where the rats are here\n" +
            "\tWhat they it?\n" + RESET),

    LOCATION19(CYAN + "\tSome enormous footprints, this is alarming...\n" + RESET),

//    LOCATION20(""),
//
//    LOCATION21(""),
//
//    LOCATION22(""),
//
//    LOCATION23(""),
//
//    LOCATION24(""),
//
//    LOCATION25(""),
//
//    LOCATION26(""),
//
//    LOCATION27(""),
//
//    LOCATION28(""),
//
//    LOCATION29(""),
//
//    LOCATION30(""),
//
//    LOCATION31(""),
//
//    LOCATION32(""),
//
//    LOCATION33(""),
//
//    LOCATION34(""),
//
//    LOCATION35(""),
//
//    LOCATION36(""),
//
//    LOCATION37(""),
//
//    LOCATION38(""),
//
//    LOCATION39(""),
//
//    LOCATION40(""),
//
//    LOCATION41(""),
//
//    LOCATION42(""),

    END_POINT(CYAN + "\tCongratulations!!! You are free!" + RESET);

    private String description;

    LocationsDescription(String description) {
        this.description = description;
    }
}
