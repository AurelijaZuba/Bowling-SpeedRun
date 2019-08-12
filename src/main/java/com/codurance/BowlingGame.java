package com.codurance;

public class BowlingGame {

    public static final String SPARE = "/";
    public static final String STRIKE = "X";
    public static final String GUTTER_BALL = "-";

    public int score(String scoreSheet) {
        String[] frames = scoreSheet.split("\\|");

        int results = 0;
        for (int i = 0; i < frames.length; i++) {
            results += calculateFrameScore(frames, i);
        }

        return results;
    }

    private int calculateFrameScore(String[] frames, int i) {
        String thisFrame = frames[i];
        int results = 0;
        if(isSpecialScore(thisFrame)) {
            String nextFrame = frames[i+1];
            results += scoreSpecial(thisFrame, nextFrame);
            return results;
        }
        return scoreFrame(thisFrame);
    }

    private boolean isSpecialScore(String thisFrame) {
        return isStrikeFrame(thisFrame) || isSpareFrame(thisFrame);
    }

    private int scoreSpecial(String thisFrame, String nextFrame) {
        int result = 0;
        if(isStrikeFrame(thisFrame)) {
            return scoreFrameWithStrike();
        }

        if(isSpareFrame(thisFrame)){
            return scoreFrameWithSpare(nextFrame);
        }
        return result;
    }

    private int scoreFrameWithStrike() {
        return 10;
    }

    private int scoreFrameWithSpare(String nextFrame) {
        char nextRoll = nextFrame.charAt(0);
        if(isGutterBall(nextRoll))
            nextRoll = '0';
        return 10 + Character.getNumericValue(nextRoll);
    }

    private int scoreFrame(String rolls) {
        char roll1 = rolls.charAt(0);
        char roll2 = rolls.charAt(1);

        if(isGutterBall(roll1))
            roll1 = '0';
        if(isGutterBall(roll2))
            roll2 = '0';

        return (Character.getNumericValue(roll1) + Character.getNumericValue(roll2));
    }

    private boolean isGutterBall(char roll) {
        return String.valueOf(roll).equals(GUTTER_BALL);
    }

    private boolean isSpareFrame(String thisFrame) {
        return thisFrame.contains(SPARE);
    }

    private boolean isStrikeFrame(String thisFrame) {
        return thisFrame.contains(STRIKE);
    }
}
