package com.meysamzamani.scoreboard;

import java.util.Comparator;

public class MatchComparator implements Comparator<Match> {

    @Override
    public int compare(Match o1, Match o2) {

        if (o1 == null || o2 == null) {
            throw new NullPointerException("Compared object should be not null");
        } else if (o1 == o2) {
            return 0;
        } else {
            return Integer.compare(
                    o1.getHomeScore() + o1.getAwayScore(),
                    o2.getHomeScore() + o2.getAwayScore()
            );
        }

    }
}
