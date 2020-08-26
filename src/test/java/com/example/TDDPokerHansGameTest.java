package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TDDPokerHansGameTest {

    private static TDDPokerHandsGame tddPokerHandsGame;

    @BeforeAll
    public static void setUp() throws Exception {
        tddPokerHandsGame = new TDDPokerHandsGame();
    }

    @Test
    void should_return_not_null_when_compare_given_2_cards(){
        String cards1 = "";
        String cards2 = "";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertNotNull(result);
    }

    @Test
    void should_return_white_wins_with_high_card_and_ace_when_compare_given_2H_3D_5S_KD_and_2C_3H_8C_AH(){
        String cards1 = "2H 3D KD 5S";
        String cards2 = "2C 3H 8C AH";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. – with high card: A", result);
    }
}
