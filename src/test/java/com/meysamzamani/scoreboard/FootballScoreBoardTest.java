package com.meysamzamani.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
