package cursor.rybak.game;

import cursor.rybak.model.team.Team;
import cursor.rybak.view.Message;

public class Game {
    public static void start() {
        Message.welcomeInfo();

        String teamName = UserInteraction.askName("Team name");

        Team team = new Team(teamName);
        Message.printTeamInfo(team);
    }
}
