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
            match = new Match(null, null);
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

    @Test
    @DisplayName("Once the match score is updated by maximum possible, the scores must be correct")
    void givenMaximumScore_whenUpdateScore_thenScoreShouldBeEqualExpected() {
        match.updateScore(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, match.getHomeScore());
        assertEquals(Integer.MAX_VALUE, match.getAwayScore());
    }

    @Test
    @DisplayName("Once the match score is updated by negative number, the scores must be dont change")
    void givenNegativeScore_whenUpdateScore_thenScoreShouldNotChange() {
        match.updateScore(-1, -10);
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

}
