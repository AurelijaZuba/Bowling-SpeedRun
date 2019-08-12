package com.codurance;

public class BowlingGame {
    public int score(String scoreSheet) {
        String[] frames = scoreSheet.split("\\|");

        int results = 0;
        for (String rolls : frames) {
            char roll1 = rolls.charAt(0);
            char roll2 = rolls.charAt(1);

            if(roll1 == '-')
                roll1 = '0';
            if(roll2 == '-')
                roll2 = '0';

            results += (Character.getNumericValue(roll1) + Character.getNumericValue(roll2));
        }

        return results;
    }
}
