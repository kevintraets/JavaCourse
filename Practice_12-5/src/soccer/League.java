/* Copyright © 2016 Oracle and/or its affiliates. All rights reserved. */
package soccer;

import java.util.ArrayList;
import utility.PlayerDatabase;

public class League {

    public static void main(String[] args) {
        League theLeague = new League();
        String[] teamNames = {"The Reds", "The Blacks", "The Blues", "The Oranges"};

        Team[] theTeams = theLeague.createTeams(teamNames, 5);
        Game[] theGames = theLeague.createGames(theTeams);

        for (Game currGame : theGames) {
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }

        theLeague.showBestTeam(theTeams);
    }

    public Team[] createTeams(String[] teamNames, int numberOfPlayers) {
        String[] playerNames = PlayerDatabase.getAuthorList().split(",");
        Player[] allPlayers = new Player[playerNames.length];
        ArrayList<String> playersUsed = new ArrayList<String>();
        Team[] allTeams = new Team[teamNames.length];

        for (int i = 0; i < playerNames.length; i++) {
            allPlayers[i] = new Player(playerNames[i]);
        }

        for (int i = 0; i < teamNames.length; i++) {
            Player[] playersForNewTeam = new Player[numberOfPlayers];
            for (int j = 0; j < numberOfPlayers; j++) {
                //Creating Players for Team
                int randomNumber = (int) (Math.random() * playerNames.length);
                Player player = allPlayers[randomNumber];
                if (playersUsed.contains(player.getPlayerName())) {
                    j--;
                } else {
                    playersUsed.add(player.getPlayerName());
                    playersForNewTeam[j] = player;
                }
            }
            //Creating a Team in outer loop
            Team team = new Team(teamNames[i], playersForNewTeam);
            allTeams[i] = team;

        }
        return allTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        ArrayList<Game> theGamesList = new ArrayList<Game>();
        for (int i = 0; i < theTeams.length; i++) {
            for (int j = 0; j < theTeams.length; j++) {
                if (i != j) {
                    Game game = new Game(theTeams[i], theTeams[j]);
                    theGamesList.add(game);
                }

            }
        }
        Game[] theGames = theGamesList.toArray(new Game[theGamesList.size()]);
        return theGames;
    }

    public void showBestTeam(Team[] theTeams) {
        Team currBestTeam = new Team("Dummy Team");
        String currBestTeamName = currBestTeam.getTeamName();
        System.out.println("\nTeam Points");

        for (Team currTeam : theTeams) {
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : " + currTeam.getGoalsTotal());

            if (currTeam.getPointsTotal() > currBestTeam.getPointsTotal()) {
                currBestTeam = currTeam;
                currBestTeamName = currBestTeam.getTeamName();
            } else if (currTeam.getPointsTotal() == currBestTeam.getPointsTotal()) {
                if (currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()) {
                    currBestTeam = currTeam;
                    currBestTeamName = currBestTeam.getTeamName();
                } else if (currTeam.getGoalsTotal() == currBestTeam.getGoalsTotal()) {
                    currBestTeamName = currBestTeamName + ", " + currTeam.getTeamName();
                }
            }
        }

        System.out.println("This year's champions are: " + currBestTeamName + "!");
    }

}
