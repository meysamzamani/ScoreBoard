package com.meysamzamani.scoreboard;

import java.util.List;

public interface ScoreBoard {

    int startMatch(Team homeTeam, Team awayTeam);
    void updateScore(int matchId, int homeScore, int awayScore);
    void finishMatch(int matchId);
    List<Match> getSummaryOfMatches();

}
