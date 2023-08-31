package com.meysamzamani.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TeamTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void givenName_whenCreateNewTeam_thenNameShouldEqual() {
        String name = "Argentina";
        Team team = new Team(name);

        assertEquals(name, team.getName());
    }

}
