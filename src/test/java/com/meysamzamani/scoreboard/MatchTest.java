package com.meysamzamani.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    private Team homeTeam;
    private Team awayTeam;
    private Match match;

    @BeforeEach
    void setUp() {
        homeTeam = new Team("Home-Team");
        awayTeam = new Team("Away-Team");
        match = new Match(homeTeam, awayTeam);
    }

    @Test
    @DisplayName("When Match is initialized then initial score should be zero")
    void givenMatch_whenInitialize_thenInitialScoreShouldBeZero() {
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    @DisplayName("Match's teams when is null then IllegalArgumentException should thrown")
    void givenNullTeams_whenInitializeMatch_thenShouldIllegalArgumentExceptionThrown() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Match match = new Match(null, null);
        }, "Both team should be not nul");
        assertEquals("Both team should be not nul", thrown.getMessage());
    }

    @Test
    @DisplayName("Once the match score is updated, the scores must be correct")
    public void givenScores_whenUpdateScore_thenScoreShouldBeEqualExpected() {
        match.updateScore(2, 1);
        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
    }

}
