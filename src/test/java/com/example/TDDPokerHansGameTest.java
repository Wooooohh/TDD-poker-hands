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
        String cards1 = "2H 3D KD 5S 4D";
        String cards2 = "2C 3H 8C AH 2D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertNotNull(result);
    }

    @Test
    void should_return_white_wins_with_high_card_and_ace_when_compare_given_2H_3D_KD_5S_TD_and_2C_3H_8C_AH_5D(){
        String cards1 = "2H 3D KD 5S TD";
        String cards2 = "2C 3H 8C AH 5D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with high card: A", result);
    }

    @Test
    void should_return_black_wins_with_high_card_and_k_when_compare_given_2H_3D_KD_5S_TD_and_2C_3H_8C_AH_5D(){
        String cards1 = "2H 3D KD 5S TD";
        String cards2 = "2C 3H 8C QH 5D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with high card: K", result);
    }

    @Test
    void should_return_tie_when_compare_given_2H_5D_3D_KS_7S_and_KC_3H_5C_2H_7D(){
        String cards1 = "2H 5D 3D KS 7S";
        String cards2 = "KC 3H 5C 2H 7D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Tie", result);
    }

    @Test
    void should_return_white_wins_with_high_card_and_nine_when_compare_given_3C_2H_8C_KH_7D_and_3H_2D_5D_9S_KD(){
        String cards1 = "3C 2H 8C KH 7D";
        String cards2 = "3H 2D 5D 9S KD";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with high card: 9", result);
    }

    @Test
    void should_return_black_wins_with_pair_and_pair_fives_when_compare_given_3C_2H_5C_5H_7D_and_3H_2D_5D_9S_KD(){
        String cards1 = "3C 2H 5C 5H 7D";
        String cards2 = "3H 2D 5D 9S KD";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with pair: Pair of Fives", result);
    }

    @Test
    void should_return_White_wins_with_pair_and_pair_fives_when_compare_given_3C_2H_5C_5H_7D_and_3H_2D_5D_9S_9D(){
        String cards1 = "3C 2H 5C 5H 7D";
        String cards2 = "3H 2D 5D 9S 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with pair: Pair of Nines", result);
    }

    @Test
    void should_return_black_wins_with_high_card_and_seven_when_compare_given_3C_2H_9C_9H_7D_and_3H_5D_2D_9S_9D(){
        String cards1 = "3C 2H 9C 9H 7D";
        String cards2 = "3H 5D 2D 9S 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with high card: 7", result);
    }

    @Test
    void should_return_black_wins_with_high_card_and_seven_when_compare_given_3C_2H_7C_AH_7D_and_3H_5D_7D_7S_6D(){
        String cards1 = "3C 2H 7C AH 7D";
        String cards2 = "3H 5D 7D 7S 6D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with high card: A", result);
    }

    @Test
    void should_return_tie_when_compare_given_3C_2H_9C_9H_7D_and_3H_5D_2D_9S_9D(){
        String cards1 = "3C 2H 9C 9H AD";
        String cards2 = "3H 2D AD 9S 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Tie", result);
    }

    @Test
    void should_return_black_wins_with_two_pairs_and_seven_when_compare_given_2C_2H_4C_4H_AD_and_3H_2D_AD_9S_9D(){
        String cards1 = "2C 2H 4C 4H AD";
        String cards2 = "3H 2D AD 9S 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with two pairs: Pair of TwosPair of Fours", result);
    }

    @Test
    void should_return_white_wins_with_two_pairs_and_nine_when_compare_given_2C_2H_4C_4H_AD_and_4H_4D_5D_5S_9D(){
        String cards1 = "2C 2H 4C 4H AD";
        String cards2 = "4H 4D 5D 5S 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with two pairs: Pair of FoursPair of Fives9", result);
    }

    @Test
    void should_return_black_wins_with_two_pairs_and_ace_when_compare_given_AC_4H_5C_4H_5D_and_3H_3D_5D_5S_9D(){
        String cards1 = "AC 4H 5C 4H 5D";
        String cards2 = "3H 3D 5D 5S 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with two pairs: Pair of FoursPair of FivesA", result);
    }

    @Test
    void should_return_black_wins_with_two_pairs_and_ace_when_compare_given_AC_4H_5C_4H_5D_and_4H_9D_5D_5S_4D(){
        String cards1 = "AC 4H 5C 4H 5D";
        String cards2 = "4H 9D 5D 5S 4D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with two pairs: Pair of FoursPair of FivesA", result);
    }
}
