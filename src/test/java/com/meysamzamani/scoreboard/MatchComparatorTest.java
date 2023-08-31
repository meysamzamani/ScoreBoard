package com.meysamzamani.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MatchComparatorTest {

    private MatchComparator comparator;
    private Match match1;
    private Match match2;

    @BeforeEach
    public void setUp() {
        comparator = new MatchComparator();
        Team homeTeam = new Team("Home-Team");
        Team awayTeam = new Team("Away-Team");
        match1 = new Match(homeTeam, awayTeam);
        match2 = new Match(homeTeam, awayTeam);
    }

    @Test
    @DisplayName("Once score updated, then compare must be equal to zero")
    public void givenMatches_whenScoreUpdated_thenShouldEqualZero() {
        match1.updateScore(2, 1);
        match2.updateScore(2, 1);
        assertEquals(0, comparator.compare(match1, match2));
    }


}
