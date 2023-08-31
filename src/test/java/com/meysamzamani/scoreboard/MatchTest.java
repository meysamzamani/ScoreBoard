package com.meysamzamani.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    private Team homeTeam;
    private Team awayTeam;
    private Match match;

    @BeforeEach
    public void setUp() {
        homeTeam = new Team("Home-Team");
        awayTeam = new Team("Away-Team");
        match = new Match(homeTeam, awayTeam);
    }

    @Test
    public void testInitialScores() {
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

}
