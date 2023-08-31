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



}
