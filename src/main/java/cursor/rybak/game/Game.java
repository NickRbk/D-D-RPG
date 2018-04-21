package cursor.rybak.game;

import cursor.rybak.model.guide.Guide;
import cursor.rybak.model.team.MoveConst;
import cursor.rybak.model.maze.Location;
import cursor.rybak.model.team.Team;
import cursor.rybak.view.GeneralMessage;
import cursor.rybak.view.Message;
import cursor.rybak.view.TeamMessage;

public class Game implements MoveConst {
    public static void start() {
        GeneralMessage.welcomeInfo();

        String teamName = UserInteraction.askName("Team name");

        Team team = new Team(teamName);
        TeamMessage.printTeamInfo(team);

        String gameMode = UserInteraction.askGameMode();

        Guide guide = new Guide();

        int i = 0;

        // Temporary make endless condition
        while(true) {
            Location currentLocation = MazeSetUp.enterToMaze(team, gameMode, guide);

            while(!currentLocation.isObjective()) {
                System.out.println(currentLocation);

                Battle.blitzkrieg(currentLocation);

                Message.printNeighbors(currentLocation);
                String moveOption = UserInteraction.chooseMoveOption( currentLocation );

                currentLocation = team.move(currentLocation, moveOption, guide);
                i++;

                if(i > 10) {
                    UserInteraction.offerHint(guide);
                    i = 0;
                }
            }

            System.out.println(currentLocation.getDescription());
        }
    }
}
