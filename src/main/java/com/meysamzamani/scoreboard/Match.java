package com.meysamzamani.scoreboard;

public class Match implements Comparable<Match> {

    private final int id;
    private final Team homeTeam;
    private final Team awayTeam;
    private int homeScore;
    private int awayScore;

    public Match(int id, Team homeTeam, Team awayTeam) {
        if (homeTeam != null || awayTeam != null || id > 0) {
            this.id = id;
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
        } else {
            throw new IllegalArgumentException("Both team should be not nul and id must be greater than zero");
        }
    }

    public int getId() {
        return id;
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
        if (homeScore >= 0 && awayScore >= 0) {
            this.homeScore = homeScore;
            this.awayScore = awayScore;
        }
    }

    @Override
    public int compareTo(Match o) {
        if (o == null) {
            throw new NullPointerException("Compared object should be not null");
        } else if (this == o) {
            return 0;
        } else {
            long sumScore1 = (long) o.getHomeScore() + o.getAwayScore();
            long sumScore2 = (long) this.getHomeScore() + this.getAwayScore();

            int scoreComparison = Long.compare(sumScore1 , sumScore2);

            if (scoreComparison == 0) {
                return Integer.compare(o.getId(), this.getId());
            }

            return scoreComparison;
        }
    }
}
