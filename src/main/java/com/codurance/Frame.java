package com.codurance;

public class Frame {
    public static final String GUTTER_BALL = "-";
    public static final String STRIKE = "X";
    public static final String SPARE = "/";
    private String frame;

    public Frame(String frame) {
        this.frame = frame;
    }

    boolean isSpecialScore() {

        return isStrikeFrame() || isSpareFrame();
    }

    int scoreFrame() {
        char roll1 = getRollOne();
        char roll2 = getRollTwo();

        return (Character.getNumericValue(roll1) + Character.getNumericValue(roll2));
    }

    char getRollOne() {
        char nextRoll = frame.charAt(0);
        if (isGutterBall(nextRoll))
            nextRoll = '0';

        return nextRoll;
    }
    char getRollTwo() {
        char nextRoll1 = frame.charAt(1);
        if (isGutterBall(nextRoll1))
            nextRoll1 = '0';

        return nextRoll1;
    }


    boolean isSpareFrame() {

        return frame.contains(SPARE);
    }

    boolean isStrikeFrame() {

        return frame.contains(STRIKE);
    }
     boolean isGutterBall(char roll) {
        return String.valueOf(roll).equals(GUTTER_BALL);
    }
}