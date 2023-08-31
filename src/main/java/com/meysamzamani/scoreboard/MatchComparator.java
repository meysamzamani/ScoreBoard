package com.meysamzamani.scoreboard;

import java.util.Comparator;

public class MatchComparator implements Comparator<Match> {

    @Override
    public int compare(Match o1, Match o2) {

        if (o1 == o2) {
            return 0;
        }

        if(o1 != null && o2 != null) {
            return Integer.compare(
                    o2.getHomeScore() + o2.getAwayScore(),
                    o1.getHomeScore() + o1.getAwayScore()
            );
        }

        throw new NullPointerException();

    }
}
