package com.example;

public enum CardValues {
  Two('2',-1),
  Three('3', 0),
  Four('4', 1),
  Five('5', 2),
  Six('6', 3),
  Seven('7', 4),
  Eight('8', 5),
  Nine('9', 6),
  Ten('T', 7),
  Jack('J', 8),
  Queen('Q', 9),
  King('K', 10),
  Ace('A', 11);
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
    return -999;
  }

  public static char getName(int value) {
    for (CardValues cv : CardValues.values()) {
      if (cv.getValue() == value) {
        return cv.getName();
      }
    }
    return ' ';
  }

  public static String getFullName(int value) {
    for (CardValues cv : CardValues.values()) {
      if (cv.getValue() == value) {
        return cv.name();
      }
    }
    return "";
  }
}
