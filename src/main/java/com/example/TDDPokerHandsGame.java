package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class TDDPokerHandsGame {

  public String Compare(String cards1, String cards2) {
    String[] cards1Array = sortCards(cards1.split(" "));
    String[] cards2Array = sortCards(cards2.split(" "));
    int card1Value = CardValues.getValue(cards1Array[3].charAt(0));
    int card2Value = CardValues.getValue(cards2Array[3].charAt(0));
    int result = Math.max(card1Value, card2Value);
    return "White wins. – with high card: "+CardValues.getName(result);
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
