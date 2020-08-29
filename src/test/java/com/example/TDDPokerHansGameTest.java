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

    @Test
    void should_return_white_wins_with_three_of_a_kind_and_fives_when_compare_given_AC_4H_5C_4H_5D_and_4H_9D_5D_5S_5D(){
        String cards1 = "AC 4H 5C 4H 5D";
        String cards2 = "4H 9D 5D 5S 5D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with three of a kind: three Fives", result);
    }

    @Test
    void should_return_black_wins_with_three_of_a_kind_and_fives_when_compare_given_5C_4H_5C_AH_5D_and_4H_9D_4D_5S_4D(){
        String cards1 = "5C 4H 5C AH 5D";
        String cards2 = "4H 9D 4D 5S 4D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with three of a kind: three Fives A 4", result);
    }

    @Test
    void should_return_black_wins_with_three_of_a_kind_and_fives_when_compare_given_5C_4H_5C_AH_5D_and_5H_9D_5D_5S_AD(){
        String cards1 = "5C 4H 5C AH 5D";
        String cards2 = "5H 9D 5D 5S AD";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with three of a kind: three Fives A 4", result);
    }

    @Test
    void should_return_white_wins_with_straight_and_card_value_when_compare_given_5C_4H_5C_AH_5D_and_5H_9D_5D_5S_AD(){
        String cards1 = "5C 4H 5C AH 5D";
        String cards2 = "7H 8D 9D TS JD";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with straight: 7 8 9 T J", result);
    }

    @Test
    void should_return_white_wins_with_straight_and_card_value_when_compare_given_3C_4H_5C_6H_7D_and_7H_8D_9D_TS_JD(){
        String cards1 = "3C 4H 5C 6H 7D";
        String cards2 = "7H 8D 9D TS JD";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with straight: 7 8 9 T J", result);
    }

    @Test
    void should_return_tie_when_compare_given_7C_8H_9C_TH_JD_and_7H_8D_9D_TS_JD(){
        String cards1 = "7C 8H 9C TH JD";
        String cards2 = "7H 8D 9D TS JD";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Tie", result);
    }

    @Test
    void should_return_white_with_flush_and_card_value_when_compare_given_7C_8H_9C_TH_JD_and_7D_6D_3D_2D_JD(){
        String cards1 = "7C 8H 9C TH JD";
        String cards2 = "7D 6D 3D 2D JD";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with flush: 2D 3D 6D 7D JD", result);
    }

    @Test
    void should_return_black_with_high_card_and_9_when_compare_given_4C_7C_8C_3C_9C_and_7D_6D_3D_2D_4D(){
        String cards1 = "4C 7C 8C 3C 9C";
        String cards2 = "7D 6D 3D 2D 4D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with high card: 9", result);
    }

    @Test
    void should_return_white_with_full_house_and_three_threes_when_compare_given_4C_7C_8C_3C_9C_and_3H_3D_3S_2S_2D(){
        String cards1 = "4C 7C 8C 3C 9C";
        String cards2 = "3H 3D 3S 2S 2D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with full house: three Threes", result);
    }

    @Test
    void should_return_black_with_full_house_and_three_fours_when_compare_given_4H_9S_4C_4D_9C_and_3H_3D_3S_2S_2D(){
        String cards1 = "4H 9S 4C 4D 9C";
        String cards2 = "3H 3D 3S 2S 2D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with full house: three Fours Pairs of Nines", result);
    }

    @Test
    void should_return_white_with_full_house_and_three_fours_when_compare_given_3H_2S_3C_3D_2C_and_3H_3D_3S_9S_9D(){
        String cards1 = "3H 2S 3C 3D 2C";
        String cards2 = "3H 3D 3S 9S 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with full house: three Threes Pairs of Nines", result);
    }

    @Test
    void should_return_black_with_four_of_a_kind_and_four_threes_when_compare_given_3H_3S_3C_3D_2C_and_4H_4D_4S_9S_9D(){
        String cards1 = "3H 3S 3C 3D 2C";
        String cards2 = "4H 4D 4S 9S 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with four of a kind: four Threes", result);
    }

    @Test
    void should_return_white_with_four_of_a_kind_and_four_fours_when_compare_given_3H_3S_3C_3D_2C_and_5H_5D_5c_5S_9D(){
        String cards1 = "3H 3S 3C 3D 2C";
        String cards2 = "5H 5D 5S 5S 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with four of a kind: four Fives and Nine", result);
    }

    @Test
    void should_return_black_with_four_of_a_kind_and_four_fives_when_compare_given_5H_5S_5C_5D_9C_and_5H_5D_5C_5S_2D(){
        String cards1 = "5H 5S 5C 5D 9C";
        String cards2 = "5H 5D 5S 5S 2D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with four of a kind: four Fives and Nine", result);
    }

    @Test
    void should_return_black_with_straight_flush_and_cards_when_compare_given_3C_4C_5C_6C_7C_and_5H_5D_5C_5S_2D(){
        String cards1 = "3C 4C 5C 6C 7C";
        String cards2 = "5H 5D 5S 5S 2D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("Black wins. - with straight flush: 3C 4C 5C 6C 7C", result);
    }

    @Test
    void should_return_white_with_straight_flush_and_cards_when_compare_given_3C_4C_5C_6C_7C_and_5D_6D_7D_8D_9D(){
        String cards1 = "3C 4C 5C 6C 7C";
        String cards2 = "5D 6D 7D 8D 9D";
        String result = tddPokerHandsGame.Compare(cards1, cards2);
        assertEquals("White wins. - with straight flush: 5D 6D 7D 8D 9D", result);
    }
}
