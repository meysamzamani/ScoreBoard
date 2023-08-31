package com.meysamzamani.scoreboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FootballScoreBoard implements ScoreBoard {

    private final Map<Integer, Match> matches;

    public FootballScoreBoard() {
        matches = new HashMap<>();
    }

    @Override
    public int startMatch(Team homeTeam, Team awayTeam) {
        int matchId = matches.size() + 1;
        matches.put(matchId, new Match(homeTeam, awayTeam));
        return matchId;
    }

    @Override
    public void updateScore(int matchId, int homeScore, int awayScore) {
        Match match = matches.get(matchId);
        if (match != null) {
            match.updateScore(homeScore, awayScore);
        }
    }

    @Override
    public void finishMatch(int matchId) {
        matches.remove(matchId);
    }

    @Override
    public List<Match> getSummaryOfMatches() {
        List<Match> orderedMatches = new ArrayList<>(matches.values());
        return orderedMatches;
    }
}
