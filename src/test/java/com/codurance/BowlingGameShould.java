package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameShould {

    @Test
    void score_zero_for_all_gutter_ball() {
        int expected = 0;
        String scoreSheet = "--|--|--|--|--|--|--|--|--|--|";

        BowlingGame game = new BowlingGame();

        int actual = game.score(scoreSheet);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void score_one_for_single_pin() {
        int expected = 1;
        String scoreSheet = "1-|--|--|--|--|--|--|--|--|--|";

        BowlingGame game = new BowlingGame();

        int actual = game.score(scoreSheet);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void score_two_for_single_frame() {
        int expected = 2;
        String scoreSheet = "11|--|--|--|--|--|--|--|--|--|";

        BowlingGame game = new BowlingGame();

        int actual = game.score(scoreSheet);

        assertThat(actual).isEqualTo(expected);
    }
}
