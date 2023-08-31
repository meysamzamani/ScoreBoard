package com.meysamzamani.scoreboard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    @DisplayName("Team's name must be equal")
    void givenName_whenCreateNewTeam_thenNameShouldEqual() {
        String name = "Argentina";
        Team team = new Team(name);

        assertEquals(name, team.getName());
    }

    @Test
    @DisplayName("Team's name when is null then NullPointerException should thrown")
    void givenNullName_whenCreateNewTeam_thenShouldIllegalArgumentExceptionThrown() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Team team = new Team(null);
        }, "Name should be not null");
        assertEquals("Name should be not null", thrown.getMessage());
    }

}
