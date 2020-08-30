# Environment
* gradle
* JDK 1.8

# How to Run Task
```
gradle test
```


# Reference Link
* https://www.w3cschool.cn/gradle/ebfc1hto.html

# cases of poker-hands:

## High Card:

1.should_return_not_null_when_compare_given_2_cards

- Given: 
  cards1(2H 3D KD 5S 4D),
  cards2(2C 3H 8C AH 2D)

- When: compare

- Then: return not null

2.should_return_white_wins_with_high_card_and_ace_when_compare_given_2H_3D_KD_5S_TD_and_2C_3H_8C_AH_5D

- Given: 
  cards1(2H 3D KD 5S TD),
  cards2(2C 3H 8C AH 5D)
- When: compare
- Then: return "White wins. - with high card: A"

3.should_return_black_wins_with_high_card_and_k_when_compare_given_2H_3D_KD_5S_TD_and_2C_3H_8C_AH_5D

- Given: 
  cards1(2H 3D KD 5S TD),
  cards2(2C 3H 8C QH 5D)
- When: compare
- Then: return "Black wins. - with high card:k"

3.should_return_black_wins_with_high_card_and_k_when_compare_given_2H_3D_KD_5S_TD_and_2C_3H_8C_AH_5D

- Given: 
  cards1(2H 3D KD 5S TD),
  cards2(2C 3H 8C QH 5D)

- When: compare

- Then: return "Black wins. - with high card: K"

4.should_return_tie_when_compare_given_2H_5D_3D_KS_7S_and_KC_3H_5C_2H_7D

 - Given
  - cards1(2H 5D 3D KS 7S),
  - cards2(KC 3H 5C 2H 7D)

- When: compare

- Then: return "Tie"

5.should_return_white_wins_with_high_card_and_nine_when_compare_given_3C_2H_8C_KH_7D_and_3H_2D_5D_9S_KD

 - Given
   - cards1(3C 2H 8C KH 7D),
   - cards2(3H 2D 5D 9S KD)

- When: compare

- Then: return "White wins. - with high card: 9"

## Pair:
6.should_return_black_wins_with_pair_and_pair_fives_when_compare_given_3C_2H_5C_5H_7D_and_3H_2D_5D_9S_KD

 - Given
   - cards1(3C 2H 5C 5H 7D),
   - cards2(3H 2D 5D 9S KD)
- When: compare
- Then: return "Black wins. - with pair: Pair of Fives"

7.should_return_White_wins_with_pair_and_pair_nines_when_compare_given_3C_2H_5C_5H_7D_and_3H_2D_5D_9S_9D

 - Given
   - cards1(3C 2H 5C 5H 7D),
   - cards2(3H 2D 5D 9S 9D)
- When: compare
- Then: return "White wins. - with pair: Pair of Nines"

7.should_return_black_wins_with_high_card_and_seven_when_compare_given_3C_2H_9C_9H_7D_and_3H_5D_2D_9S_9D

 - Given
   - cards1(3C 2H 9C 9H 7D),
   - cards2(3H 5D 2D 9S 9D)
- When: compare
- Then: return "Black wins. - with high card: 7"

8.should_return_black_wins_with_high_card_and_seven_when_compare_given_3C_2H_7C_AH_7D_and_3H_5D_7D_7S_6D

 - Given
   - cards1(3C 2H 7C AH 7D),
   - cards2(3H 5D 7D 7S 6D)
- When: compare
- Then: return "Black wins. - with high card: A"

9.should_return_tie_when_compare_given_3C_2H_9C_9H_7D_and_3H_5D_2D_9S_9D

 - Given
   - cards1(3C 2H 9C 9H AD),
   - cards2(3H 2D AD 9S 9D)
- When: compare
- Then: return "Tie"

## two pairs:
10.should_return_black_wins_with_two_pairs_and_seven_when_compare_given_2C_2H_4C_4H_AD_and_3H_2D_AD_9S_9D

 - Given
   - cards1(2C 2H 4C 4H AD),
   - cards2(3H 2D AD 9S 9D)
- When: compare
- Then: return "Black wins. - with two pairs: Pair of TwosPair of Fours"

11.should_return_white_wins_with_two_pairs_and_nine_when_compare_given_2C_2H_4C_4H_AD_and_4H_4D_5D_5S_9D

 - Given
   - cards1(2C 2H 4C 4H AD),
   - cards2(4H 4D 5D 5S 9D)
- When: compare
- Then: return "White wins. - with two pairs: Pair of FoursPair of Fives9"

12.should_return_black_wins_with_two_pairs_and_ace_when_compare_given_AC_4H_5C_4H_5D_and_3H_3D_5D_5S_9D

 - Given
   - cards1(AC 4H 5C 4H 5D),
   - cards2(3H 3D 5D 5S 9D)
- When: compare
- Then: return "Black wins. - with two pairs: Pair of FoursPair of FivesA"

13.should_return_black_wins_with_two_pairs_and_ace_when_compare_given_AC_4H_5C_4H_5D_and_4H_9D_5D_5S_4D

 - Given
   - cards1(AC 4H 5C 4H 5D),
   - cards2(4H 9D 5D 5S 4D)
- When: compare
- Then: return "Black wins. - with two pairs: Pair of FoursPair of FivesA"

## Three Fives:
14.should_return_white_wins_with_three_of_a_kind_and_fives_when_compare_given_AC_4H_5C_4H_5D_and_4H_9D_5D_5S_5D

 - Given
   - cards1(AC 4H 5C 4H 5D),
   - cards2(4H 9D 5D 5S 5D)
- When: compare
- Then: return "White wins. - with three of a kind: three Fives"

15.should_return_black_wins_with_three_of_a_kind_and_three_fives_when_compare_given_5C_4H_5C_AH_5D_and_4H_9D_4D_5S_4D

 - Given
   - cards1(5C 4H 5C AH 5D),
   - cards2(4H 9D 4D 5S 4D)
- When: compare
- Then: return "Black wins. - with three of a kind: three Fives A 4"

16.should_return_black_wins_with_three_of_a_kind_and_fives_when_compare_given_5C_4H_5C_AH_5D_and_5H_9D_5D_5S_AD

 - Given
   - cards1(5C 4H 5C AH 5D),
   - cards2(5H 9D 5D 5S AD)
- When: compare
- Then: return "Black wins. - with three of a kind: three Fives A 4"

## Straight:
17.should_return_white_wins_with_straight_and_card_value_when_compare_given_5C_4H_5C_AH_5D_and_7H_8D_9D_TS_JD

 - Given
   - cards1(5C 4H 5C AH 5D),
   - cards2(7H 8D 9D TS JD)
- When: compare
- Then: return "White wins. - with straight: 7 8 9 T J"

18.should_return_white_wins_with_straight_and_card_value_when_compare_given_3C_4H_5C_6H_7D_and_7H_8D_9D_TS_JD

 - Given
   - cards1(3C 4H 5C 6H 7D),
   - cards2(7H 8D 9D TS JD)
- When: compare
- Then: return "White wins. - with straight: 7 8 9 T J"

19.should_return_tie_when_compare_given_7C_8H_9C_TH_JD_and_7H_8D_9D_TS_JD

 - Given
   - cards1(7C 8H 9C TH JD),
   - cards2(7H 8D 9D TS JD)
- When: compare
- Then: return "Tie"

## Flush:
20.should_return_white_with_flush_and_card_value_when_compare_given_7C_8H_9C_TH_JD_and_7D_6D_3D_2D_JD

 - Given
   - cards1(7C 8H 9C TH JD),
   - cards2(7D 6D 3D 2D JD)
- When: compare
- Then: return "White wins. - with flush: 2D 3D 6D 7D JD"

21.should_return_black_with_high_card_and_9_when_compare_given_4C_7C_8C_3C_9C_and_7D_6D_3D_2D_4D

 - Given
   - cards1(4C 7C 8C 3C 9C),
   - cards2(7D 6D 3D 2D 4D)
- When: compare
- Then: return "Black wins. - with high card: 9"

## Full house:
22.should_return_white_with_full_house_and_three_threes_when_compare_given_4C_7C_8C_3C_9C_and_3H_3D_3S_2S_2D

 - Given
   - cards1(4C 7C 8C 3C 9C),
   - cards2(3H 3D 3S 2S 2D)
- When: compare
- Then: return "White wins. - with full house: three Threes"

23.should_return_black_with_full_house_and_three_fours_when_compare_given_4H_9S_4C_4D_9C_and_3H_3D_3S_2S_2D

 - Given
   - cards1(4H 9S 4C 4D 9C),
   - cards2(3H 3D 3S 2S 2D)
- When: compare
- Then: return "Black wins. - with full house: three Fours Pairs of Nines"

24.should_return_white_with_full_house_and_three_fours_when_compare_given_3H_2S_3C_3D_2C_and_3H_3D_3S_9S_9D

 - Given
   - cards1(3H 2S 3C 3D 2C),
   - cards2(3H 3D 3S 9S 9D)
- When: compare
- Then: return "White wins. - with full house: three Threes Pairs of Nines"

## Four of a kind:
25.should_return_black_with_four_of_a_kind_and_four_threes_when_compare_given_3H_3S_3C_3D_2C_and_4H_4D_4S_9S_9D

 - Given
   - cards1(3H 3S 3C 3D 2C),
   - cards2(4H 4D 4S 9S 9D)
- When: compare
- Then: return "Black wins. - with four of a kind: four Threes"

26.should_return_white_with_four_of_a_kind_and_four_fours_when_compare_given_3H_3S_3C_3D_2C_and_5H_5D_5c_5S_9D

 - Given
   - cards1(3H 3S 3C 3D 2C),
   - cards2(5H 5D 5S 5S 9D)
- When: compare
- Then: return "White wins. - with four of a kind: four Fives and Nine"

27.should_return_black_with_four_of_a_kind_and_four_fives_when_compare_given_5H_5S_5C_5D_9C_and_5H_5D_5C_5S_2D

 - Given
   - cards1(5H 5S 5C 5D 9C),
   - cards2(5H 5D 5S 5S 2D)
- When: compare
- Then: return "Black wins. - with four of a kind: four Fives and Nine"

## Straight flush:
28.should_return_black_with_straight_flush_and_cards_when_compare_given_3C_4C_5C_6C_7C_and_5H_5D_5C_5S_2D

 - Given
   - cards1(3C 4C 5C 6C 7C),
   - cards2(5H 5D 5S 5S 2D)
- When: compare
- Then: return "Black wins. - with straight flush: 3C 4C 5C 6C 7C"

29.should_return_white_with_straight_flush_and_cards_when_compare_given_3C_4C_5C_6C_7C_and_5D_6D_7D_8D_9D

 - Given
   - cards1(3C 4C 5C 6C 7C),
   - cards2(5D 6D 7D 8D 9D)
- When: compare
- Then: return "White wins. - with straight flush: 5D 6D 7D 8D 9D"

30.should_return_tie_when_compare_given_3C_4C_5C_6C_7C_and_3D_4D_5D_6D_7D

 - Given
   - cards1(3C 4C 5C 6C 7C),
   - cards2(3D 4D 5D 6D 7D)
- When: compare
- Then: return "Tie"


