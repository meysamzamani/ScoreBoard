package com.meysamzamani.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchComparatorTest {

    private MatchComparator comparator;
    private Match match1;
    private Match match2;

    @BeforeEach
    void setUp() {
        comparator = new MatchComparator();
        Team homeTeam = new Team("Home-Team");
        Team awayTeam = new Team("Away-Team");
        match1 = new Match(homeTeam, awayTeam);
        match2 = new Match(homeTeam, awayTeam);
    }

    @Test
    @DisplayName("Once score updated and objects are equal, then compare must be equal to zero")
    void givenMatches_whenScoreUpdatedAndEqualWithCompareTo_thenShouldEqualZero() {
        match1.updateScore(2, 1);
        match2 = match1;
        assertEquals(0, comparator.compare(match1, match2));
    }

    @Test
    @DisplayName("Given Null matches, when compared, then should NullPointerException thrown")
    void givenNullMatches_whenCompared_thenShouldNullPointerExceptionThrown() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            comparator.compare(null, null);
        }, "Compared object should be not null");
        assertEquals("Compared object should be not null", thrown.getMessage());
    }

    @Test
    @DisplayName("Given higher score, when compared, then should greater than zero")
    void givenMatches_whenUpdatedScoreAndCompared_thenShouldGreaterThanZero() {
        match1.updateScore(3, 2);
        match2.updateScore(2, 1);
        assertTrue(comparator.compare(match1, match2) > 0);
    }

    @Test
    @DisplayName("Given matches, when score is equal and compared, then should return less than zero")
    void givenEqualScores_whenCompared_thenShouldLessThanZeroBecauseOfRecentlyOrder() {
        match1.updateScore(2, 2);
        match2.updateScore(2, 2);
        assertTrue(comparator.compare(match1, match2) < 0);
    }

}
