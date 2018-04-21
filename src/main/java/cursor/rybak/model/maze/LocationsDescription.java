package cursor.rybak.model.maze;

import cursor.rybak.view.MagicColors;
import lombok.Getter;

@Getter
public enum LocationsDescription implements MagicColors {

    START_POINT(CYAN + "\tYou're in Game, welcome! It's dark around... but doesn't matter.\n" +
            "\tYou must know only a few things... here live monsters and\n" +
            "\tyou run away from here, if you find the key)\n" +
            "\tBe careful, good luck!\n" + RESET),

    LOCATION0(CYAN + "\tThere is too much water. TEAM, we need to get out of here" + RESET),

    LOCATION1(CYAN + "\tA terrible place... what a noise here!!" + RESET),

    LOCATION2(CYAN + "\t...the flour creaks.. Nice))" + RESET),

    LOCATION3(CYAN + "\tSo low ceiling, what dwarf lived here!" + RESET),

    LOCATION4(CYAN + "\tSuspicious silence... But I must escape from here!" + RESET),

    LOCATION5(CYAN + "\tHow strange this picture hangs here.. em..\n" +
            "\t No,no,no, I'm very suspicious..)\n" +
            "\tYeah,I'm in a normal conventional.. bunker" + RESET),

    LOCATION6(CYAN + "\tThese inscriptions strain me. Why? Why all rooms named by indexes!\n" +
            "\tMaybe it's key to my freedom..." + RESET),

    LOCATION7(CYAN + "\t'You are in hell'.. very positive text on wall..\n" +
            "\tBut who left it here !?" + RESET),

    LOCATION8(CYAN + "\tIt becomes stuffy... but I feel that exit is close.. I hope" + RESET),

    LOCATION9(CYAN + "\tWow, laboratory! And what equipment are here!\n" +
            "\tTEAM, do not be distracted!" + RESET),

    LOCATION10(CYAN + "\tWhat contrasts, it becomes cool.. Why I didn't take a jacket!" + RESET),

    LOCATION11(CYAN + "\tWell, some interesting table and some letter... 'We have cookies'\n" +
            "\tWhat?! Someone is mocking us! But who?" + RESET),

    LOCATION12(CYAN + "\tWow, what the furniture. The one who lived here had a good taste))" + RESET),

    LOCATION13(CYAN + "\tCasino in the bunker?)) Really? TEAM, do not spend all money))" + RESET),

    LOCATION14(CYAN + "\tThis is good place to rest, quietly here. TEAM, set up a camp!" + RESET),

    LOCATION15(CYAN + "\tWalls, stones, a lot of dust..." + RESET),

    LOCATION16(CYAN + "\tRoom of mirrors, I hate that!" + RESET),

    LOCATION17(CYAN + "\tIt seems like a classroom... who was taught here?" + RESET),

    LOCATION18(CYAN + "\tOval cabinet, cool) But from where the rats are here\n" +
            "\tWhat they eat?" + RESET),

    LOCATION19(CYAN + "\tSome enormous footprints, this is alarming..." + RESET),

    END_POINT(CYAN + "\n\n\t================================" +
            "\n\n\tCongratulations!!! You are free!" +
            "\n\n\tContinue our Game)" +
            "\n\n\t================================\n" + RESET);

    private String description;

    LocationsDescription(String description) {
        this.description = description;
    }
}
