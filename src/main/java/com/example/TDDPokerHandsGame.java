package com.example;

import java.util.*;

public class TDDPokerHandsGame {

  public String Compare(String cards1, String cards2) {
    String[] cards1Array = sortCards(cards1.split(" "));
    String[] cards2Array = sortCards(cards2.split(" "));
    if (isTie(cards1Array, cards2Array)) {
      return "Tie";
    }
    int cardType1 = judge(cards1Array);
    int cardType2 = judge(cards2Array);
    if (cardType1 == cardType2) {
      if (cardType1 == CardTypes.highCard.value)
        return getHighCardCompareResult(cards1Array, cards2Array, 5);
      else if (cardType1 == CardTypes.pair.value)
        return getPairCompareResult(cards1Array, cards2Array);
      else if (cardType1 == CardTypes.twoPairs.value)
        return getTwoPairsCompareResult(cards1Array, cards2Array);
      else if (cardType1 == CardTypes.threeOfAKind.value)
        return getThreeOfKindCompareResult(cards1Array, cards2Array);
      else if (cardType1 == CardTypes.straight.value)
        return getStraightCompareResult(cards1Array, cards2Array);
      else if (cardType1 == CardTypes.flush.value)
        return getFlushCompareResult(cards1Array, cards2Array);
      else if (cardType1 == CardTypes.fullHouse.value)
        return getFullHouseCompareResult(cards1Array, cards2Array);
      else if (cardType1 == CardTypes.fourOfAKind.value)
        return getFullOfAKindCompareResult(cards1Array, cards2Array);
    }
    return getCardResult(cards1Array, cards2Array, cardType1, cardType2);
  }

  private String getFullOfAKindCompareResult(String[] cards1Array, String[] cards2Array) {
    if (cards1Array[4].charAt(0) != cards1Array[3].charAt(0)) {
      swap(cards1Array, 0, 4);
    }
    if (cards2Array[4].charAt(0) != cards2Array[3].charAt(0)) {
      swap(cards2Array, 0, 4);
    }
    for (int i = 1; i >= 0; i--) {
      int value1 = getCardValue(cards1Array[i]);
      int value2 = getCardValue(cards2Array[i]);
      if (value1 > value2) {
        return "Black"
                + " wins. - with "
                + "four of a kind"
                + ": four "
                + CardValues.getFullName(getCardValue(cards1Array[4]))
                + "s "
                + "and "
                + CardValues.getFullName(getCardValue(cards1Array[0]));
      } else if(value1 < value2){
        return "White"
                + " wins. - with "
                + "four of a kind"
                + ": four "
                + CardValues.getFullName(getCardValue(cards2Array[4]))
                + "s "
                + "and "
                + CardValues.getFullName(getCardValue(cards2Array[0]));
      }
    }
    return null;
  }

  private String getFullHouseCompareResult(String[] cards1Array, String[] cards2Array) {
    if (cards1Array[2].charAt(0) != cards1Array[4].charAt(0)) {
      swap(cards1Array, 0, 3);
      swap(cards1Array, 1, 4);
    }
    if (cards2Array[2].charAt(0) != cards2Array[4].charAt(0)) {
      swap(cards2Array, 0, 3);
      swap(cards2Array, 1, 4);
    }
    for (int i = 2; i >= 1; i--) {
      if (i == 3) continue;
      int value1 = getCardValue(cards1Array[i]);
      int value2 = getCardValue(cards2Array[i]);
      if (value1 > value2) {
        return "Black"
            + " wins. - with "
            + "full house"
            + ": three "
            + CardValues.getFullName(getCardValue(cards1Array[4]))
            + "s "
            + "Pairs of "
            + CardValues.getFullName(getCardValue(cards1Array[1]))
            + "s";
      } else if(value1 < value2){
        return "White"
            + " wins. - with "
            + "full house"
            + ": three "
            + CardValues.getFullName(getCardValue(cards2Array[4]))
            + "s "
            + "Pairs of "
            + CardValues.getFullName(getCardValue(cards2Array[1]))
            + "s";
      }
    }
    return null;
  }

  private String getFlushCompareResult(String[] cards1Array, String[] cards2Array) {
    return getHighCardCompareResult(cards1Array, cards2Array, 5);
  }

  private String getStraightCompareResult(String[] cards1Array, String[] cards2Array) {
    int value1 = getCardValue(cards1Array[4]);
    int value2 = getCardValue(cards2Array[4]);
    if (value1 < value2) {
      return "White" + " wins. - with " + "straight" + ": " + getStraightString(cards2Array);
    } else {
      return "Black" + " wins. - with " + "straight" + ": " + getStraightString(cards2Array);
    }
  }

  private String getThreeOfKindCompareResult(String[] cards1Array, String[] cards2Array) {
    String[] sortThree1 = sortThree(cards1Array);
    String[] sortThree2 = sortThree(cards2Array);
    for (int i = cards1Array.length - 1; i >= 0; i--) {
      if (i == 2 || i == 3) continue;
      int value1 = getCardValue(cards1Array[i]);
      int value2 = getCardValue(cards2Array[i]);
      if (value1 < value2) {
        return "White wins. - with three of a kind: three "
            + CardValues.getFullName(value2)
            + "s"
            + " "
            + CardValues.getName(getCardValue(sortThree2[1]))
            + " "
            + CardValues.getName(getCardValue(sortThree2[0]));
      } else {
        return "Black wins. - with three of a kind: three "
            + CardValues.getFullName(value1)
            + "s"
            + " "
            + CardValues.getName(getCardValue(sortThree1[1]))
            + " "
            + CardValues.getName(getCardValue(sortThree1[0]));
      }
    }
    return null;
  }

  private String[] sortThree(String[] cardsArray) {
    if (cardsArray[0].charAt(0) == cardsArray[2].charAt(0)) {
      swap(cardsArray, 0, 3);
      swap(cardsArray, 1, 4);
    }
    if (cardsArray[1].charAt(0) == cardsArray[3].charAt(0)) {
      swap(cardsArray, 1, 4);
    }
    return cardsArray;
  }

  private String getCardResult(
      String[] cards1Array, String[] cards2Array, int cardType1, int cardType2) {
    String winner = "";
    String type = "";
    int maxType = 0;
    String[] maxCards = null;
    if (cardType1 < cardType2) {
      winner = "Black";
      type = CardTypes.getName(cardType1);
      maxType = cardType1;
      maxCards = cards1Array;
    } else {
      winner = "White";
      type = CardTypes.getName(cardType2);
      maxType = cardType2;
      maxCards = cards2Array;
    }
    return winner + " wins. - with " + type + ": " + getCardValue(maxType, maxCards);
  }

  private String getCardValue(int maxType, String[] maxCards) {
    switch (maxType) {
      case 8:
        return getPairString(maxCards);
      case 7:
        return getTwoPairString(maxCards);
      case 6:
        return getThreeString(maxCards);
      case 5:
        return getStraightString(maxCards);
      case 4:
        return getFlushString(maxCards);
      case 3:
        return getFullHouseString(maxCards);
      case 2:
        return getFourOfAKindString(maxCards);
      default:
        return "";
    }
  }

  private String getFourOfAKindString(String[] maxCards) {
    return "four " + CardValues.getFullName(getCardValue(maxCards[3])) + "s";
  }

  private String getFullHouseString(String[] maxCards) {
    return "three " + CardValues.getFullName(getCardValue(maxCards[3])) + "s";
  }

  private String getFlushString(String[] maxCards) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxCards.length - 1; i++) {
      sb.append(maxCards[i] + " ");
    }
    sb.append(maxCards[4]);
    return sb.toString();
  }

  private String getStraightString(String[] maxCards) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxCards.length - 1; i++) {
      sb.append(maxCards[i].charAt(0) + " ");
    }
    sb.append(maxCards[4].charAt(0));
    return sb.toString();
  }

  private String getThreeString(String[] maxCards) {
    return "three " + CardValues.getFullName(getCardValue(maxCards[3])) + "s";
  }

  private String getTwoPairString(String[] maxCards) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxCards.length - 1; i++)
      if (getCardValue(maxCards[i]) == getCardValue(maxCards[i + 1]))
        sb.append("Pair of " + CardValues.getFullName(getCardValue(maxCards[i])) + "s");
    return sb.toString();
  }

  private String getPairString(String[] maxCards) {
    for (int i = 0; i < maxCards.length - 1; i++)
      if (getCardValue(maxCards[i]) == getCardValue(maxCards[i + 1]))
        return "Pair of " + CardValues.getFullName(getCardValue(maxCards[i])) + "s";
    return "";
  }

  private int getCardValue(String card) {
    return CardValues.getValue(card.charAt(0));
  }

  private String getPairCompareResult(String[] cards1Array, String[] cards2Array) {
    String[] pairCard1 = sortPair(cards1Array);
    String[] pairCard2 = sortPair(cards2Array);
    int pairValue1 = getCardValue(pairCard1[4]);
    int pairValue2 = getCardValue(pairCard2[4]);
    if (pairValue1 == pairValue2) {
      return getHighCardCompareResult(cards1Array, cards2Array, 3);
    } else {
      if (pairValue1 > pairValue2) {
        return "Black"
            + " wins. - with "
            + CardTypes.pair.name()
            + ": Pair of "
            + CardTypes.getName(pairValue1)
            + "s";
      } else {
        return "White"
            + " wins. - with "
            + CardTypes.pair.name()
            + ": Pair of "
            + CardValues.getFullName(pairValue2)
            + "s";
      }
    }
  }

  private String getTwoPairsCompareResult(String[] cards1Array, String[] cards2Array) {
    String[] twoPairCards1 = sortTwoPairs(cards1Array);
    String[] twoPairCards2 = sortTwoPairs(cards2Array);
    for (int i = 4; i >= 0; i = i - 2) {
      int value1 = getCardValue(twoPairCards1[i]);
      int value2 = getCardValue(twoPairCards2[i]);
      if (value1 > value2) {
        return "Black wins. - with two pairs: Pair of "
            + CardValues.getFullName(getCardValue(twoPairCards1[2]))
            + "sPair of "
            + CardValues.getFullName(getCardValue(twoPairCards1[4]))
            + "s"
            + CardValues.getName(getCardValue(twoPairCards1[0]));
      } else if (value1 < value2) {
        return "White wins. - with two pairs: Pair of "
            + CardValues.getFullName(getCardValue(twoPairCards2[2]))
            + "sPair of "
            + CardValues.getFullName(getCardValue(twoPairCards2[4]))
            + "s"
            + CardValues.getName(getCardValue(twoPairCards2[0]));
      }
    }
    return null;
  }

  private String[] sortTwoPairs(String[] cardsArray) {
    if (cardsArray[4].charAt(0) != cardsArray[3].charAt(0)) swap(cardsArray, 2, 4);
    if (cardsArray[2].charAt(0) != cardsArray[1].charAt(0)) swap(cardsArray, 2, 0);
    return cardsArray;
  }

  private void swap(String[] cardsArray, int i, int j) {
    String temp = cardsArray[i];
    cardsArray[i] = cardsArray[j];
    cardsArray[j] = temp;
  }

  private String[] sortPair(String[] cardsArray) {
    for (int i = 1; i < cardsArray.length; i++) {
      if (getCardValue(cardsArray[i]) == getCardValue(cardsArray[i - 1])) {
        if (i < 3) {
          String temp4 = cardsArray[4];
          String temp3 = cardsArray[3];
          cardsArray[4] = cardsArray[i];
          cardsArray[3] = cardsArray[i - 1];
          cardsArray[i] = temp4;
          cardsArray[i - 1] = temp3;
        } else if (i == 3) {
          String temp4 = cardsArray[4];
          cardsArray[4] = cardsArray[i];
          cardsArray[i - 1] = temp4;
        }
      }
    }
    return cardsArray;
  }

  private int judge(String[] cardsArray) {
    boolean flag1 = false;
    boolean flag2 = false;
    if (cardsArray[0].charAt(1) == cardsArray[1].charAt(1)
        && cardsArray[1].charAt(1) == cardsArray[2].charAt(1)
        && cardsArray[2].charAt(1) == cardsArray[3].charAt(1)
        && cardsArray[3].charAt(1) == cardsArray[4].charAt(1)) flag1 = true;
    if (getCardValue(cardsArray[0]) + 1 == getCardValue(cardsArray[1])
        && getCardValue(cardsArray[1]) + 1 == getCardValue(cardsArray[2])
        && getCardValue(cardsArray[2]) + 1 == getCardValue(cardsArray[3])
        && getCardValue(cardsArray[3]) + 1 == getCardValue(cardsArray[4])) flag2 = true;
    if (flag1 && flag2) return 1;
    else if (flag1 && !flag2) return 4;
    else if (!flag1 && flag2) return 5;

    int[] up = new int[10];
    int i, k = 0;
    for (i = 1; i <= 4; i++) {
      if (CardValues.getValue(cardsArray[i].charAt(0))
          != CardValues.getValue(cardsArray[i - 1].charAt(0))) {
        up[k++] = i;
      }
    }

    if (k == 1) {
      if (up[0] == 1 || up[0] == 4) return 2;
      if (up[0] == 2 || up[0] == 3) return 3;
    } else if (k == 2) {
      if (up[0] == 1 && up[1] == 2 || up[0] == 3 && up[1] == 4 || up[0] == 1 && up[1] == 4) {
        return 6;
      } else {
        return 7;
      }
    } else if (k == 3) {
      return 8;
    } else if (k == 4) return 9;
    return 0;
  }

  private String getHighCardCompareResult(String[] cards1Array, String[] cards2Array, int size) {
    int result = 0;
    String winner = "";
    for (int i = size - 1; i >= 0; i--) {
      int card1Value = CardValues.getValue(cards1Array[i].charAt(0));
      int card2Value = CardValues.getValue(cards2Array[i].charAt(0));
      if (card1Value != card2Value) {
        if (card1Value < card2Value) {
          result = card2Value;
          winner = "White";
        } else {
          result = card1Value;
          winner = "Black";
        }
        break;
      }
    }
    return winner + " wins. - with high card: " + CardValues.getName(result);
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
        (o1, o2) -> {
          return CardValues.getValue(((String) o1).charAt(0))
              - CardValues.getValue(((String) o2).charAt(0));
        });
    return cards;
  }
}
