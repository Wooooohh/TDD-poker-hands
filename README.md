# Environment
* gradle
* JDK 1.8

# How to Run Task
```
gradle test
```


# Reference Link
* https://www.w3cschool.cn/gradle/ebfc1hto.html

# High Card:

High Card:

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

- Then: return "Black wins. - with high card: K"

4.should_return_tie_when_compare_given_2H_5D_3D_KS_7S_and_KC_3H_5C_2H_7D

 - Given
    - cards1(2H 3D KD 5S TD),
    - cards2(KC 3H 5C 2H 7D)

- When: compare

- Then: return "Tie"

5.should_return_white_wins_with_high_card_and_nine_when_compare_given_3C_2H_8C_KH_7D_and_3H_2D_5D_9S_KD

 - Given
    - cards1(3C 2H 5C 5H 7D),
    - cards2(3H 2D 5D 9S KD)

- When: compare

- Then: return "Black wins. - with pair: Pair of 5"
