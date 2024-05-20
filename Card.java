public class Card {
  private int value;
  private int suit;

  public Card() {
    value = 0;
    suit = 0;
  }

  public Card(int value, int suit) {
    this.value = value;
    this.suit = suit;
  }

  public void setValue(int i) {
    value = i;
  }

  public int getValue() {
    return value;
  }

  public void setSuit(int i) {
    suit = i;
  }

  public int getSuit() {
    return suit;
  }

  public String toString() {
    String string = "";
    switch (value) {
      case 1: {
        string = "Ace";
        break;
      }
      case 11: {
        string = "Jack";
        break;
      }
      case 12: {
        string = "Queen";
        break;
      }
      case 13: {
        string = "King";
        break;
      }
      default: {
        string += value;
        break;
      }
    }
    string += " of ";
    switch (suit) {
      case 1: {
        string += "Hearts";
        break;
      }
      case 2: {
        string += "Diamonds";
        break;
      }
      case 3: {
        string += "Clubs";
        break;
      }
      case 4: {
        string += "Spades";
        break;
      }
    }
    return string;
  }
}