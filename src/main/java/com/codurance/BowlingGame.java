package com.codurance;

public class BowlingGame {
    public int score(String scoreSheet) {
        if(scoreSheet.contains("1"))
            return 1;

        return 0;
    }
}
