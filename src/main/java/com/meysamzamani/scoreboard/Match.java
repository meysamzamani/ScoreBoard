package com.meysamzamani.scoreboard;

public class Match {

    private final Team homeTeam;
    private final Team awayTeam;
    private int homeScore;
    private int awayScore;

    public Match(Team homeTeam, Team awayTeam) {
        if (homeTeam != null || awayTeam != null) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
        } else {
            throw new IllegalArgumentException("Both team should be not nul");
        }
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
