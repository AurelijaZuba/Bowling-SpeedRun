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
        if (isSpecialScore(thisFrame)) {
            String nextFrame = frames[i + 1];
            if(isStrikeFrame(nextFrame)){
                return (10 + 10 + Character.getNumericValue(getRollOne(frames[i + 2])));
            }
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
        if (isStrikeFrame(thisFrame)) {
            return scoreFrameWithStrike(nextFrame);
        }

        if (isSpareFrame(thisFrame)) {
            return scoreFrameWithSpare(nextFrame);
        }
        return result;
    }

    private int scoreFrameWithStrike(String nextFrame) {
        int result = 0;

//        if (isStrikeFrame(nextFrame)) {
//            result += 10 + Character.getNumericValue(getRollOne(nextFrame)) + secondRoll;
//        }
        if (isSpareFrame(nextFrame)) {
            char nextRoll = getRollOne(nextFrame);
            result += 10 + (Character.getNumericValue(nextRoll) + calculateSpareRollValue(nextRoll));
        }
        if (!isStrikeFrame(nextFrame) && !isSpareFrame(nextFrame)) {
            char nextRoll1 = getRollOne(nextFrame);
            char nextRoll2 = getRollTwo(nextFrame);

            result += 10 + (Character.getNumericValue(nextRoll1) + Character.getNumericValue(nextRoll2));
        }

        return result;
    }

    private int calculateSpareRollValue(char nextRoll) {
        return 10 - Character.getNumericValue(nextRoll);
    }


    private int scoreFrameWithSpare(String nextFrame) {
        char nextRoll = getRollOne(nextFrame);
        return 10 + Character.getNumericValue(nextRoll);
    }

    private int scoreFrame(String frame) {
        char roll1 = getRollOne(frame);
        char roll2 = getRollTwo(frame);

        return (Character.getNumericValue(roll1) + Character.getNumericValue(roll2));
    }

    private char getRollTwo(String frame) {
        char nextRoll1 = frame.charAt(1);
        if (isGutterBall(nextRoll1))
            nextRoll1 = '0';

        return nextRoll1;
    }

    private char getRollOne(String frame) {
        char nextRoll = frame.charAt(0);
        if (isGutterBall(nextRoll))
            nextRoll = '0';

        return nextRoll;
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
