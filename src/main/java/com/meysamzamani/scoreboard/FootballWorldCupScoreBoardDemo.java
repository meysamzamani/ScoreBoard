package com.meysamzamani.scoreboard;

import java.util.List;

public class FootballWorldCupScoreBoardDemo {

    public static void main(String[] args) {

        ScoreBoard scoreboard = new FootballScoreBoard();
        int firstMatch = scoreboard.startMatch(new Team("Mexico"), new Team("Canada"));
        scoreboard.updateScore(firstMatch, 0, 5);
        int secondMatch = scoreboard.startMatch(new Team("Spain"), new Team("Brazil"));
        scoreboard.updateScore(secondMatch, 10, 2);
        int thirdMatch = scoreboard.startMatch(new Team("Germany"), new Team("France"));
        scoreboard.updateScore(thirdMatch, 2, 2);
        int fourthMatch = scoreboard.startMatch(new Team("Uruguay"), new Team("Italy"));
        scoreboard.updateScore(fourthMatch, 6, 6);
        int fifthMatch = scoreboard.startMatch(new Team("Argentina"), new Team("Australia"));
        scoreboard.updateScore(fifthMatch, 3, 1);

        printOnScoreBoard(scoreboard.getSummaryOfMatches());

        scoreboard.finishMatch(fourthMatch);

        printOnScoreBoard(scoreboard.getSummaryOfMatches());
    }

    public static void printOnScoreBoard(List<Match> matches) {
        StringBuilder scoreBoardBuilder = new StringBuilder();
        scoreBoardBuilder.append("\n****** Live Football Scoreboard ******\n");
        for (int i = 0; i < matches.size(); i++) {
            scoreBoardBuilder.append(String.format("%d. %s %d - %s %d%n",
                    i+1,
                    matches.get(i).getHomeTeam().getName(), matches.get(i).getHomeScore(),
                    matches.get(i).getAwayTeam().getName(), matches.get(i).getAwayScore())
            );
        }
        System.out.println(scoreBoardBuilder);
    }
}
