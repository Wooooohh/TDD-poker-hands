package com.example;

public enum CardValues {
  THREE('3', 0),
  FOUR('4', 1),
  FIVE('5', 2),
  SIX('6', 3),
  SEVEN('7', 4),
  EIGHt('8', 5),
  NINE('9', 6),
  TEN('T', 7),
  JACK('J', 8),
  Queen('Q', 9),
  KING('K', 10),
  ACE('A', 11);
  private char name;
  private int value;

  CardValues(char c, int i) {
    this.name = c;
    this.value = i;
  }

  public char getName() {
    return name;
  }

  public void setName(char name) {
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public static int getValue(char name) {
    for (CardValues cv : CardValues.values()) {
      if (cv.getName() == name) {
        return cv.getValue();
      }
    }
    return -1;
  }

  public static char getName(int value) {
    for (CardValues cv : CardValues.values()) {
      if (cv.getValue() == value) {
        return cv.getName();
      }
    }
    return ' ';
  }
}
