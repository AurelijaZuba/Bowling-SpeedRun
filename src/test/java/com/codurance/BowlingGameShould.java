package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameShould {

    @ParameterizedTest
    @MethodSource("scoreSheetProvider")
    public void correctly_scores_a_sheet(String scoreSheet, int expectedScore) {
        BowlingGame game = new BowlingGame();

        int actual = game.score(scoreSheet);

        assertThat(actual).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> scoreSheetProvider() {
        return Stream.of(
                Arguments.of("--|--|--|--|--|--|--|--|--|--|", 0),
                Arguments.of("1-|--|--|--|--|--|--|--|--|--|", 1),
                Arguments.of("11|--|--|--|--|--|--|--|--|--|", 2),
                Arguments.of("12|--|--|--|--|--|--|--|--|--|", 3),
                Arguments.of("1/|--|--|--|--|--|--|--|--|--|", 10)
        );
    }
}
