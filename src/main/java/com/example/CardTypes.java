package com.example;

public enum CardTypes {
  highCard(9, "high card"),
  pair(8, "pair"),
  twoPairs(7, "two pairs"),
  threeOfAKind(6, "three of a kind"),
  straight(5, "straight"),
  flush(4, "flush"),
  fullHouse(3, "full house"),
  fourOfAKind(2, "four of a kind"),
  straightFlush(1, "straight flush");
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static String getName(int value) {
    for (CardTypes ct : CardTypes.values()) {
      if (ct.getValue() == value) {
        return ct.getName();
      }
    }
    return "";
  }
}
