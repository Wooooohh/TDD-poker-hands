package com.example;

public enum CardTypes {
  HighCard(9, "high card"),
  Pair(8, "pair"),
  TwoPairs(7, "two pairs"),
  ThreeOfAKind(6, "three of a kind"),
  Straight(5, "straight"),
  Flush(4, "flush"),
  FullHouse(3, "full house"),
  FourOfAKind(2, "four of a kind"),
  StraightFlush(1, "straight flush");
  int value;
  String name;

  CardTypes(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public static String getName(int value) {
    for (CardTypes ct : CardTypes.values()) {
      if (ct.getValue() == value) {
        return ct.name();
      }
    }
    return "";
  }
}
