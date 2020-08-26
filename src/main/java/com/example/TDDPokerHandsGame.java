package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class TDDPokerHandsGame {

  public String Compare(String cards1, String cards2) {
    String[] cards1Array = sortCards(cards1.split(" "));
    String[] cards2Array = sortCards(cards2.split(" "));
    if (isTie(cards1Array, cards2Array)) {
      return "Tie";
    }

    int result = 0;
    for (int i = cards1Array.length - 1; i >= 0; i--) {
      int card1Value = CardValues.getValue(cards1Array[i].charAt(0));
      int card2Value = CardValues.getValue(cards2Array[i].charAt(0));
      if (card1Value != card2Value){
        result = Math.max(card1Value, card2Value);
        break;
      }
    }
    return "White wins. - with high card: " + CardValues.getName(result);
  }

  private boolean isTie(String[] cards1Array, String[] cards2Array) {
    for (int i = 0; i < cards1Array.length; i++) {
      if (cards1Array[i].charAt(0) != cards2Array[i].charAt(0)) return false;
    }
    return true;
  }

  private String[] sortCards(String[] cards) {
    Arrays.sort(
        cards,
        new Comparator() {
          public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return CardValues.getValue(s1.charAt(0)) - CardValues.getValue(s2.charAt(0));
          }
        });
    return cards;
  }
}
