package com.codurance;

public class BowlingGame {
    public int score(String scoreSheet) {
        String[] frames = scoreSheet.split("\\|");

        int results = 0;
        for (String rolls : frames) {
            results += scoreFrame(rolls);
        }

        return results;
    }

    private int scoreFrame(String rolls) {
        char roll1 = rolls.charAt(0);
        char roll2 = rolls.charAt(1);

        if(roll1 == '/' || roll2 == '/')
            return 10;
        if(roll1 == '-')
            roll1 = '0';
        if(roll2 == '-')
            roll2 = '0';

        return (Character.getNumericValue(roll1) + Character.getNumericValue(roll2));
    }
}
