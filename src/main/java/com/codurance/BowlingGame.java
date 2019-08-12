package com.codurance;

public class BowlingGame {
    public int score(String scoreSheet) {
        String[] frames = scoreSheet.split("\\|");

        int results = 0;
        for (int i = 0; i < frames.length; i++) {
            String thisFrame = frames[i];
            if(thisFrame.contains("X") || thisFrame.contains("/")) {
                String nextFrame = frames[i+1];
                results += scoreSpecial(thisFrame, nextFrame);
                continue;
            }
            results += scoreFrame(thisFrame);
        }

        return results;
    }

    private int scoreSpecial(String thisFrame, String nextFrame) {
        int result = 0;
        if(thisFrame.contains("X")) {
            return 10;
        }

        if(thisFrame.contains("/")){
            char nextRoll = nextFrame.charAt(0);
            if(nextRoll == '-')
                nextRoll = '0';
            return 10 + Character.getNumericValue(nextRoll);
        }
        return result;
    }

    private int scoreFrame(String rolls) {
        char roll1 = rolls.charAt(0);
        char roll2 = rolls.charAt(1);

        if(roll1 == '-')
            roll1 = '0';
        if(roll2 == '-')
            roll2 = '0';

        return (Character.getNumericValue(roll1) + Character.getNumericValue(roll2));
    }
}
