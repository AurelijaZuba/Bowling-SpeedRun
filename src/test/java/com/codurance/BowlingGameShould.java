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
                Arguments.of("1/|--|--|--|--|--|--|--|--|--|", 10),
                Arguments.of("X|--|--|--|--|--|--|--|--|--|", 10),
                Arguments.of("1/|11|--|--|--|--|--|--|--|--|", 13),
                Arguments.of("X|11|--|--|--|--|--|--|--|--|", 14),
                Arguments.of("X|1/|--|--|--|--|--|--|--|--|", 30),
                Arguments.of("X|X|1-|--|--|--|--|--|--|--|", 33),
                Arguments.of("X|X|1/|--|--|--|--|--|--|--|", 51),
                Arguments.of("--|1/|X|--|--|--|--|--|--|--|", 30),
                Arguments.of("X|X|X|--|--|--|--|--|--|--|", 60),
                Arguments.of("X|X|X|X|--|--|--|--|--|--|", 100),
                Arguments.of("11|11|11|11|11|11|11|11|11|11|", 20)

        );
    }
}
