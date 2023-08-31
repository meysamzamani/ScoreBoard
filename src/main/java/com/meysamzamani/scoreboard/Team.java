package com.meysamzamani.scoreboard;

public class Team {

    private final String name;

    public Team(String name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name should be not null");
        }
    }

    public String getName() {
        return name;
    }
}
