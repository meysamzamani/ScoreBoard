package com.meysamzamani.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    private Team homeTeam;
    private Team awayTeam;
    private Match match1;
    private Match match2;

    @BeforeEach
    void setUp() {
        homeTeam = new Team("Home-Team");
        awayTeam = new Team("Away-Team");
        match1 = new Match(1, homeTeam, awayTeam);
        match2 = new Match(2, homeTeam, awayTeam);
    }

    @Test
    @DisplayName("When Match is initialized then initial score should be zero")
    void givenMatch_whenInitialize_thenInitialScoreShouldBeZero() {
        assertEquals(0, match1.getHomeScore());
        assertEquals(0, match1.getAwayScore());
        assertEquals(0, match2.getHomeScore());
        assertEquals(0, match2.getAwayScore());
    }

    @Test
    @DisplayName("Match's teams when is null then IllegalArgumentException should thrown")
    void givenNullTeams_whenInitializeMatch_thenShouldIllegalArgumentExceptionThrown() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            match1 = new Match(0, null, null);
            match2 = new Match(0, null, null);
        }, "Both team should be not nul and id must be greater than zero");
        assertEquals("Both team should be not nul and id must be greater than zero", thrown.getMessage());
    }

    @Test
    @DisplayName("Once the match score is updated, the scores must be correct")
    public void givenScores_whenUpdateScore_thenScoreShouldBeEqualExpected() {
        match1.updateScore(2, 1);
        assertEquals(2, match1.getHomeScore());
        assertEquals(1, match1.getAwayScore());
    }

    @Test
    @DisplayName("Once the match score is updated by maximum possible, the scores must be correct")
    void givenMaximumScore_whenUpdateScore_thenScoreShouldBeEqualExpected() {
        match1.updateScore(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, match1.getHomeScore());
        assertEquals(Integer.MAX_VALUE, match1.getAwayScore());
    }

    @Test
    @DisplayName("Once the match score is updated by negative number, the scores must be dont change")
    void givenNegativeScore_whenUpdateScore_thenScoreShouldNotChange() {
        match2.updateScore(-1, -10);
        assertEquals(0, match2.getHomeScore());
        assertEquals(0, match2.getAwayScore());
    }

    @Test
    @DisplayName("Once score updated and objects are equal, then compare must be equal to zero")
    void givenMatches_whenScoreUpdatedAndEqualWithCompareTo_thenShouldEqualZero() {
        match1.updateScore(2, 1);
        match2 = match1;
        assertEquals(0, match1.compareTo(match2));
    }

    @Test
    @DisplayName("Given Null matches, when compared, then should NullPointerException thrown")
    void givenNullMatches_whenCompared_thenShouldNullPointerExceptionThrown() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            match1.compareTo(null);
        }, "Compared object should be not null");
        assertEquals("Compared object should be not null", thrown.getMessage());
    }

    @Test
    @DisplayName("Given higher score, when compared, then should less than zero")
    void givenMatches_whenUpdatedScoreAndCompared_thenShouldLessThanZero() {
        match1.updateScore(3, 2);
        match2.updateScore(2, 1);
        assertTrue(match1.compareTo(match2) < 0);
    }

    @Test
    @DisplayName("Given matches, when score is equal and compared, then should return greater than zero")
    void givenEqualScores_whenCompared_thenShouldGreaterThanZeroBecauseOfRecentlyOrder() {
        match1.updateScore(2, 2);
        match2.updateScore(2, 2);
        assertTrue(match1.compareTo(match2) > 0);
    }

}
