package com.meysamzamani.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballScoreBoardTest {

    private FootballScoreBoard scoreBoard;
    private Team homeTeam;
    private Team awayTeam;

    @BeforeEach
    void setUp() {
        scoreBoard = new FootballScoreBoard();
        homeTeam = new Team("Home-Team");
        awayTeam = new Team("Away-Team");
    }

    @Test
    @DisplayName("Given matches, when start match, then should return matchId with greater than Zero")
    void givenMatches_whenStartMatch_thenShouldReturnMatchIdAndGreaterThanZero() {
        int matchId = scoreBoard.startMatch(homeTeam, awayTeam);
        assertAll(
                () -> assertNotNull(matchId),
                () -> assertTrue(matchId > 0)
        );
    }

    @Test
    @DisplayName("Given match, when score updated, then doesn't throw any exception")
    void givenMatch_whenUpdateScore_thenDoesNotThrowException() {
        int matchId = scoreBoard.startMatch(homeTeam, awayTeam);
        assertDoesNotThrow(() -> scoreBoard.updateScore(matchId, 2, 1));
    }

    @Test
    @DisplayName("Given match, when finished match, then doesn't throw any exception")
    void givenMatch_whenFinishMatch_thenDoesNotThrowException() {
        int matchId = scoreBoard.startMatch(homeTeam, awayTeam);
        assertDoesNotThrow(() -> scoreBoard.finishMatch(matchId));
    }

    @Test
    @DisplayName("Given match, when get summary of matches, then should be not null")
    void givenMatch_whenGetSummaryOfMatches_thenShouldBeNotNull() {
        assertNotNull(scoreBoard.getSummaryOfMatches());
    }

    @Test
    @DisplayName("Given match, when started and updated score and get summary, then should be ordered correct and equal")
    void givenMatch_whenStartedAndUpdatedScoreAndGetSummary_thenShouldOrderedAndEqualExpected() {
        int firstMatch = scoreBoard.startMatch(new Team("Mexico"), new Team("Canada"));
        scoreBoard.updateScore(firstMatch, 0, 5);
        int secondMatch = scoreBoard.startMatch(new Team("Spain"), new Team("Brazil"));
        scoreBoard.updateScore(secondMatch, 10, 2);
        int thirdMatch = scoreBoard.startMatch(new Team("Germany"), new Team("France"));
        scoreBoard.updateScore(thirdMatch, 2, 2);
        int fourthMatch = scoreBoard.startMatch(new Team("Uruguay"), new Team("Italy"));
        scoreBoard.updateScore(fourthMatch, 6, 6);
        int fifthMatch = scoreBoard.startMatch(new Team("Argentina"), new Team("Australia"));
        scoreBoard.updateScore(fifthMatch, 3, 1);

        List<Match> orderedMatch = scoreBoard.getSummaryOfMatches();

        assertAll(
                () -> assertNotNull(orderedMatch),
                () -> assertEquals(5, orderedMatch.size()),
                () -> assertEquals("Uruguay", orderedMatch.get(0).getHomeTeam().getName()),
                () -> assertEquals("Italy", orderedMatch.get(0).getAwayTeam().getName()),
                () -> assertEquals(6, orderedMatch.get(0).getHomeScore()),
                () -> assertEquals(6, orderedMatch.get(0).getAwayScore()),
                () -> assertEquals("Spain", orderedMatch.get(1).getHomeTeam().getName()),
                () -> assertEquals("Brazil", orderedMatch.get(1).getAwayTeam().getName()),
                () -> assertEquals(10, orderedMatch.get(1).getHomeScore()),
                () -> assertEquals(2, orderedMatch.get(1).getAwayScore()),
                () -> assertEquals("Germany", orderedMatch.get(4).getHomeTeam().getName()),
                () -> assertEquals("France", orderedMatch.get(4).getAwayTeam().getName()),
                () -> assertEquals(2, orderedMatch.get(4).getHomeScore()),
                () -> assertEquals(2, orderedMatch.get(4).getAwayScore())
        );
    }
}
