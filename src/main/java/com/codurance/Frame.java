package com.codurance;

public class Frame {
    public static final String GUTTER_BALL = "-";
    public static final String STRIKE = "X";
    public static final String SPARE = "/";
    private String rolls;

    public Frame(String rolls) {
        this.rolls = rolls;
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
        char nextRoll = rolls.charAt(0);
        if (isGutterBall(nextRoll))
            nextRoll = '0';

        return nextRoll;
    }
    char getRollTwo() {
        char nextRoll1 = rolls.charAt(1);
        if (isGutterBall(nextRoll1))
            nextRoll1 = '0';

        return nextRoll1;
    }


    boolean isSpareFrame() {

        return rolls.contains(SPARE);
    }

    boolean isStrikeFrame() {

        return rolls.contains(STRIKE);
    }
     boolean isGutterBall(char roll) {
        return String.valueOf(roll).equals(GUTTER_BALL);
    }
}