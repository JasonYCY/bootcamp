public class Card {
  // attribute
  private Suit suit; // D C H S
  private Rank rank; // A 2 3 4 5 6 7 8 9 T J Q K

  // constructor
  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  // getter
  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  // toString
  @Override
  public String toString() {
    return rank.getDisplayString() + suit.getDisplaySymbol();
  }







  // main method
  public static void main(String[] args) {
    // test
    System.out.println(new Card(Suit.DIAMONDS, Rank.TEN));
    System.out.println(new Card(Suit.HEARTS, Rank.ACE));
    System.out.println(new Card(Suit.SPADES, Rank.JACK));
    





  }
}