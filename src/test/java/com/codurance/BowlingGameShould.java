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
}
