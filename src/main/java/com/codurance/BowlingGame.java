package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BowlingGame {

//    private final Frame frame = new Frame();

    public int score(String scoreSheet) {
        String[] frames = scoreSheet.split("\\|");

        List<Frame> framesArray = new ArrayList<>();
        for (String rolls : frames) {
            framesArray.add(new Frame(rolls));
        }
        int results = 0;
        for (int i = 0; i < frames.length; i++) {
            results += calculateFrameScore(framesArray, i);
        }

        return results;
    }

    private int calculateFrameScore(List<Frame> frames, int i) {
        Frame thisFrame = frames.get(i);
        int results = 0;
        if (thisFrame.isSpecialScore()) {
            Frame nextFrame = frames.get(i + 1);
            if (nextFrame.isStrikeFrame()) {
                return (10 + 10 + Character.getNumericValue(frames.get(i + 2).getRollOne()));
            }
            results += scoreSpecial(thisFrame, nextFrame);
            return results;
        }
        return thisFrame.scoreFrame();
    }

    private int scoreSpecial(Frame thisFrame, Frame nextFrame) {
        int result = 0;
        if (thisFrame.isStrikeFrame()) {
            return scoreFrameWithStrike(nextFrame);
        }

        if (thisFrame.isSpareFrame()) {
            return scoreFrameWithSpare(nextFrame);
        }
        return result;
    }

    private int scoreFrameWithStrike(Frame nextFrame) {
        int result = 0;

        if (nextFrame.isSpareFrame()) {
            char nextRoll = nextFrame.getRollOne();
            result += 10 + (Character.getNumericValue(nextRoll) + calculateSpareRollValue(nextRoll));
        }
        if (!nextFrame.isStrikeFrame() && !nextFrame.isSpareFrame()) {
            char nextRoll1 = nextFrame.getRollOne();
            char nextRoll2 = nextFrame.getRollTwo();

            result += 10 + (Character.getNumericValue(nextRoll1) + Character.getNumericValue(nextRoll2));
        }

        return result;
    }

    private int calculateSpareRollValue(char nextRoll) {
        return 10 - Character.getNumericValue(nextRoll);
    }


    private int scoreFrameWithSpare(Frame nextFrame) {
        char nextRoll = nextFrame.getRollOne();
        return 10 + Character.getNumericValue(nextRoll);
    }
}
