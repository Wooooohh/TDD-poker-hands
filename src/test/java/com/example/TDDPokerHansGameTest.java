package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TDDPokerHansGameTest {

    private static TDDPokerHandsGame tddPokerHandsGame;

    @BeforeAll
    public static void setUp() throws Exception {
        tddPokerHandsGame = new TDDPokerHandsGame();
    }

    @Test
    void should_return_result_when_compare_given_2_cards(){
        String card1 = "";
        String card2 = "";
        String result = tddPokerHandsGame.Compare(card1, card2);
        assertNotNull(result);
    }
}
